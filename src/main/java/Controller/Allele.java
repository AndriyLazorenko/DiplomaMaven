package Controller;

import Controller.SearchMethodBehaviour.SearchMethod;
import Model.AlleleBehaviourMap;
import Model.AlleleNamesMap;
import DAO.Results;
import DAO.OrderedPrintList;
import java.io.*;
import java.util.Properties;

/**
 * This class contains set of methods to process inputs of a certain allele and implements
 * a different set of behaviours depending on allele
 * @author andriylazorenko
 */

public class Allele {

    /**
     * Variables declaration
     */

    private String variationAllele;
    private String fileName;
    private String line = null;
    protected SearchMethod searchMethod;
    protected Results results;
    protected AlleleNamesMap anm = new AlleleNamesMap();
    protected AlleleBehaviourMap abm = new AlleleBehaviourMap();

    /**
     * Constructor sets behaviour of processing depending on allele, also - stores its correct name
     * @param s - allele name
     */

    public Allele (String s){
        this.variationAllele = anm.getAlleleNames().get(s).toString();
        this.searchMethod = abm.getAlleleBehaviour().get(s);
    }

    /**
     * Getters and setters
     */

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getVariationAllele(){
        return variationAllele;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    /**
     * Results are obtained depending on method of search for a specific allele
     * @return Results class with computed results
     */

    public Results methodOfSearch (){
        setResults(searchMethod.fastCompute());
        return getResults();
    }

    /**
     * Method for processing inputs from file in form of FileReader using method from any class
     * implementing SearchMethod interface. Method also renames old file name to a new one,
     * which is going to be used later on for creating a Results.txt file from processed results
     * @param fr - FileReader object from file with input data
     * @param oldFileName - String which is old file path for input data *.txt file
     * @throws IOException
     */

    public void fastProcess(FileReader fr, String oldFileName)throws IOException {
        BufferedReader br = new BufferedReader(fr);
        searchMethod.getVariationAllele(variationAllele);
        setLine(br.readLine());
        while (getLine() != null) {
            searchMethod.searchInSingleString(getLine());
            setLine(br.readLine());
        }
        fr.close();

        //Receiving filename from old file

        setFileName(oldFileName.replace(".txt", "_RESULTS.txt"));
    }

    /**
     * Method erases variables from results
     */

    public void erase() {
        getResults().erase();
        searchMethod.erase();
    }

    /**
     * Method for writing the result in file. Receives path to file from class variable
     * @throws IOException
     */

    public void toFile() throws IOException {
        File file = new File(getFileName());
        FileWriter fw = new FileWriter(file.getAbsoluteFile());

        Properties forPrint = results.applyWording();
        OrderedPrintList opl = new OrderedPrintList(variationAllele);
        for (String s:opl.orderedPrintSequence()){
            fw.write(s + " = " + forPrint.get(s).toString() + " in Variation Allele "
                    + results.getVariationAllele()+"\n");
        }
        fw.close();
    }

    /**
     * Method for printing the Results in console. Currently deprecated.
     */

    public void print() {
        Properties forPrint = results.applyWording();
        for (Object o : forPrint.keySet()) {
            System.out.println(o.toString() + " = " + forPrint.get(o).toString()
                    + " in Variation Allele " + results.getVariationAllele());
        }
    }

    /**
     * Ordered print method to console.
     */

    public void orderedPrint(){
        Properties forPrint = results.applyWording();
        OrderedPrintList opl = new OrderedPrintList(variationAllele);
        for (String s:opl.orderedPrintSequence()){
            System.out.println(s + " = " + forPrint.get(s).toString()
                    + " in Variation Allele " + results.getVariationAllele());
        }
    }

}