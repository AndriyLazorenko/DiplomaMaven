package Controller;

import Controller.DatabaseParsingBehaviour.ParsingDBBehaviour;
import Properties.DatabaseBehaviourMap;
import Properties.Results;
import Properties.OrderedPrintList;
import View.OutputFilesParsing.CSVParser;

import java.io.*;
import java.util.Properties;


/**
 * Created by Master on 04-May-15.
 */
public class ResultsDB {

    protected ParsingDBBehaviour parsingDBBehaviour;
    protected DatabaseBehaviourMap dbbm = new DatabaseBehaviourMap();
    private String variationAllele;
    private String fileName;
    private Results results;

    public ResultsDB(String s){
        this.parsingDBBehaviour = dbbm.getDatabaseBehaviour().get(s);
        this.variationAllele = s;
    }

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

    public void toFile(String fileName) throws IOException {

        setFileName(fileName);
        setFileName(getFileName().substring(0,getFileName().lastIndexOf("\\"))+"\\"+variationAllele+"_Results_Database.csv");
        File file = new File(getFileName());
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        CSVParser csv = new CSVParser(results);
        fw.write(csv.toCSV());
        fw.flush();
        fw.close();
    }

    //Refactor erase method

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

    public void print() {
        Properties forPrint = results.applyWording();
        OrderedPrintList opl = new OrderedPrintList(variationAllele);
        for (String s:opl.orderedPrintSequence()){
            System.out.println(s + " = " + forPrint.get(s).toString() + " in Variation Allele " + results.getVariationAllele());
        }
    }

    public void clearResults(){
        setResults(null);
    }
}
