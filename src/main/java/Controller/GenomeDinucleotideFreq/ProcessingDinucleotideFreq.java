package Controller.GenomeDinucleotideFreq;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class is responsible for processing the results into files or data storing classes.
 * It also provides API for working with DinucleotideFrequencyCounter class
 * @author andriylazorenko
 */

public class ProcessingDinucleotideFreq {

    /**
     * Variables
     */

    private Map <String,Long> results;
    private String filename;
    private DinucleotideFrequencyCounter counter;

    /**
     * Constructor accepts String filename (path) and FileReader input, creates a new processor class
     * DinucleotideFrequencyCounter
     * @param filename - String with path to file
     * @param input - FileReader with char data from file
     */

    public ProcessingDinucleotideFreq(String filename, FileReader input) {
        this.filename = filename;
        this.counter = new DinucleotideFrequencyCounter(input);
        this.results = this.counter.run();
    }

    /**
     * Prints results to console
     */

    public void printToConsole(){
        for (String s : results.keySet()) {
            System.out.println(s+" = "+results.get(s).toString());
        }
    }

    /**
     * Adds data to a container class designed to hold and process data from various files.
     * @param vc -  <class>VariableContainer</class> object to add results to
     * @parameter results - Map of results to add to container
     */

    public void addToDataContainer(VariableContainer vc){

        vc.getContainer().put("aa", vc.getContainer().get("aa") + results.get("aa"));
        vc.getContainer().put("ac", vc.getContainer().get("ac") + results.get("ac"));
        vc.getContainer().put("ag", vc.getContainer().get("ag") + results.get("ag"));
        vc.getContainer().put("at", vc.getContainer().get("at") + results.get("at"));
        vc.getContainer().put("ca", vc.getContainer().get("ca") + results.get("ca"));
        vc.getContainer().put("cc", vc.getContainer().get("cc") + results.get("cc"));
        vc.getContainer().put("cg", vc.getContainer().get("cg") + results.get("cg"));
        vc.getContainer().put("ct", vc.getContainer().get("ct") + results.get("ct"));
        vc.getContainer().put("ga", vc.getContainer().get("ga") + results.get("ga"));
        vc.getContainer().put("gc", vc.getContainer().get("gc") + results.get("gc"));
        vc.getContainer().put("gg", vc.getContainer().get("gg") + results.get("gg"));
        vc.getContainer().put("gt", vc.getContainer().get("gt") + results.get("gt"));
        vc.getContainer().put("ta", vc.getContainer().get("ta") + results.get("ta"));
        vc.getContainer().put("tc", vc.getContainer().get("tc") + results.get("tc"));
        vc.getContainer().put("tg", vc.getContainer().get("tg") + results.get("tg"));
        vc.getContainer().put("tt", vc.getContainer().get("tt") + results.get("tt"));
        vc.getContainer().put("total", vc.getContainer().get("total") + results.get("total"));

    }
}
