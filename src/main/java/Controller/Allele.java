package Controller;

import Controller.SearchMethodBehaviour.SearchMethod;
import Properties.AlleleBehaviourMap;
import Properties.AlleleNamesMap;
import Properties.Results;
import Properties.OrderedPrintList;
import java.io.*;
import java.util.Properties;

public class Allele {

    private String variationAllele;
    private String fileName;
    private String line = null;
    SearchMethod searchMethod;
    protected Results results;

    AlleleNamesMap anm = new AlleleNamesMap();
    AlleleBehaviourMap abm = new AlleleBehaviourMap();

    public Allele (String s){
        this.variationAllele = anm.getAlleleNames().get(s).toString();
        this.searchMethod = abm.getAlleleBehaviour().get(s);
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public Results methodOfSearch (){
        setResults(searchMethod.fastCompute());
        return getResults();
    }

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

    public void erase() {
        getResults().erase();
        searchMethod.erase();
    }

    //Writing the result in file

    public void toFile() throws IOException {
        File file = new File(getFileName());
        FileWriter fw = new FileWriter(file.getAbsoluteFile());

        Properties forPrint = results.applyWording();
        OrderedPrintList opl = new OrderedPrintList(variationAllele);
        for (String s:opl.orderedPrintSequence()){
            fw.write(s + " = " + forPrint.get(s).toString() + " in Variation Allele " + results.getVariationAllele()+"\n");
        }
        fw.close();
    }

    //Printing the Results

    public void print() {
        Properties forPrint = results.applyWording();
        for (Object o : forPrint.keySet()) {
            System.out.println(o.toString() + " = " + forPrint.get(o).toString() + " in Variation Allele " + results.getVariationAllele());
        }
    }

    //Ordered print

    public void orderedPrint(){
        Properties forPrint = results.applyWording();
        OrderedPrintList opl = new OrderedPrintList(variationAllele);
        for (String s:opl.orderedPrintSequence()){
            System.out.println(s + " = " + forPrint.get(s).toString() + " in Variation Allele " + results.getVariationAllele());
        }
    }

    //Getters and setters

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

}