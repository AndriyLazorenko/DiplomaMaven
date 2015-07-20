package Controller.GenomeDinucleotideFreq;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible for processing the results into files or data storing classes.
 * It also provides API for working with DinucleotideFrequencyCounter class
 * @author andriylazorenko
 */

public class ProcessingDinucleotideFreq {

    /**
     * Variables
     */

    private Map<String,Object> results = new HashMap<>();
    private String filename;
    private FileReader input;
    private DinucleotideFrequencyCounter counter;

    /**
     * Constructor accepts String filename (path) and FileReader input, creates a new processor class
     * DinucleotideFrequencyCounter
     * @param filename - String with path to file
     * @param input - FileReader with char data from file
     */

    public ProcessingDinucleotideFreq(String filename, FileReader input) {
        this.filename = filename;
        this.input = input;
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
     * Adds data to a container designed to hold data from various files.
     * @param container - Container class object to add results to
     * @parameter results - Map of results to add to container
     */

    public void addToDataContainer(AllResultsContainer container){

        container.aaCounter +=Integer.parseInt(results.get("aa").toString());
        container.acCounter +=Integer.parseInt(results.get("ac").toString());
        container.agCounter +=Integer.parseInt(results.get("ag").toString());
        container.atCounter +=Integer.parseInt(results.get("at").toString());
        container.caCounter +=Integer.parseInt(results.get("ca").toString());
        container.ccCounter +=Integer.parseInt(results.get("cc").toString());
        container.cgCounter +=Integer.parseInt(results.get("cg").toString());
        container.ctCounter +=Integer.parseInt(results.get("ct").toString());
        container.gaCounter +=Integer.parseInt(results.get("ga").toString());
        container.gcCounter +=Integer.parseInt(results.get("gc").toString());
        container.ggCounter +=Integer.parseInt(results.get("gg").toString());
        container.gtCounter +=Integer.parseInt(results.get("gt").toString());
        container.taCounter +=Integer.parseInt(results.get("ta").toString());
        container.tcCounter +=Integer.parseInt(results.get("tc").toString());
        container.tgCounter +=Integer.parseInt(results.get("tg").toString());
        container.ttCounter +=Integer.parseInt(results.get("tt").toString());
    }
}
