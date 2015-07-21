package Controller;

import Controller.DatabaseParsingBehaviour.ParsingDBBehaviour;
import Controller.GenomeDinucleotideFreq.AllResultsContainer;
import Properties.DatabaseBehaviourMap;
import Properties.Results;
import Properties.OrderedPrintList;
import View.OutputFilesParsing.CSVParser;

import java.io.*;
import java.util.Properties;


/**
 * The class provides various methods to work with Results
 * @author andriylazorenko
 */

public class ResultsDB {

    /**
     * Variables
     */

    protected ParsingDBBehaviour parsingDBBehaviour;
    protected DatabaseBehaviourMap dbbm = new DatabaseBehaviourMap();
    private String variationAllele;
    private String fileName;
    private Results results;
    private AllResultsContainer adjustedFreq;

    /**
     * Constructor accepts String of variation Allele, determines parsing behaviour of
     * results depending on variation Allele and accepts statistically calculated frequencies
     * of occurrence of dinucleotides in processed data.
     * @param s - String of variation allele
     * @param adjustedFreq - file containing data on frequencies of occurrence of dinucleotides
     */

    public ResultsDB(String s, AllResultsContainer adjustedFreq){
        this.parsingDBBehaviour = dbbm.getDatabaseBehaviour().get(s);
        this.variationAllele = s;
        this.adjustedFreq = adjustedFreq;
    }

    /**
     * Getters and setters
     */

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Method receives String with file path and modifies it for .CSV output
     * @param fileName - received String with file path
     * @throws IOException
     */

    public void toFile(String fileName) throws IOException {

        setFileName(fileName);
        if (getFileName().contains("\\")) {
            setFileName(getFileName().substring(0, getFileName().lastIndexOf("\\"))
                    + "\\" + variationAllele + "_Results_Database.csv");
        }
        else {
            setFileName(getFileName().substring(0, getFileName().lastIndexOf("/"))
                    + "/" + variationAllele + "_Results_Database.csv");
        }
        File file = new File(getFileName());
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        CSVParser csv = new CSVParser(results,adjustedFreq);
        fw.write(csv.toCSV());
        fw.flush();
        fw.close();
    }


    /**
     * Method for erasing all results. Might need a refactoring.
     */

    public void erase() {
        System.out.println("Do you want to erase all results? Y/N");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String eraseChoice;
        try {
            eraseChoice = br.readLine();
            if (eraseChoice.equals("Y")||eraseChoice.equals("y")){
                parsingDBBehaviour.erase();
                setResults(null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for printing results to console
     */

    public void print() {
        Properties forPrint = results.applyWording();
        OrderedPrintList opl = new OrderedPrintList(variationAllele);
        for (String s:opl.orderedPrintSequence()){
            System.out.println(s + " = " + forPrint.get(s).toString() + " in Variation Allele " + results.getVariationAllele());
        }
    }

    /**
     * Method for setting Results object a null value
     */

    public void clearResults(){
        setResults(null);
    }
}
