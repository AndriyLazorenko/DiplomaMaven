package Controller.GenomeDinucleotideFreq;

import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 * This class contains variables and methods needed to count and compute occurrences of
 * dinucleotide phrases all over the analysed samples
 * @author andriylazorenko
 */

public class DinucleotideFrequencyCounter extends VariableContainer {

    /**
     * Variables
     */

    private FileReader fr;

    /**
     * Constructor for class. FileReader object must be passed
     * @param fr - FileReader object
     */

    public DinucleotideFrequencyCounter(FileReader fr) {
        this.fr = fr;
    }

    /**
     * Method for parsing FileReader to single Strings and process them using another method.
     */

    private void process(){
        BufferedReader br = new BufferedReader(fr);
        String line;
        try {
            line = br.readLine();
            while (line != null) {
                searchInString(line);
                line=br.readLine();
            }
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method searches for dinucleotide phrases in the input String and counts their occurrences.
     * The counters are class variables.
     * @param input - String undergoing search
     */

    private void searchInString(String input){

        String inputLowercase = input.toLowerCase();

        getContainer().put("aa", getContainer().get("aa") + StringUtils.countOccurrencesOf(inputLowercase,"aa"));
        getContainer().put("ac", getContainer().get("ac") + StringUtils.countOccurrencesOf(inputLowercase,"ac"));
        getContainer().put("ag", getContainer().get("ag") + StringUtils.countOccurrencesOf(inputLowercase,"ag"));
        getContainer().put("at", getContainer().get("at") + StringUtils.countOccurrencesOf(inputLowercase,"at"));
        getContainer().put("ca", getContainer().get("ca") + StringUtils.countOccurrencesOf(inputLowercase,"ca"));
        getContainer().put("cc", getContainer().get("cc") + StringUtils.countOccurrencesOf(inputLowercase,"cc"));
        getContainer().put("cg", getContainer().get("cg") + StringUtils.countOccurrencesOf(inputLowercase,"cg"));
        getContainer().put("ct", getContainer().get("ct") + StringUtils.countOccurrencesOf(inputLowercase,"ct"));
        getContainer().put("ga", getContainer().get("ga") + StringUtils.countOccurrencesOf(inputLowercase,"ga"));
        getContainer().put("gc", getContainer().get("gc") + StringUtils.countOccurrencesOf(inputLowercase,"gc"));
        getContainer().put("gg", getContainer().get("gg") + StringUtils.countOccurrencesOf(inputLowercase,"gg"));
        getContainer().put("gt", getContainer().get("gt") + StringUtils.countOccurrencesOf(inputLowercase,"gt"));
        getContainer().put("ta", getContainer().get("ta") + StringUtils.countOccurrencesOf(inputLowercase,"ta"));
        getContainer().put("tc", getContainer().get("tc") + StringUtils.countOccurrencesOf(inputLowercase,"tc"));
        getContainer().put("tg", getContainer().get("tg") + StringUtils.countOccurrencesOf(inputLowercase,"tg"));
        getContainer().put("tt", getContainer().get("tt") + StringUtils.countOccurrencesOf(inputLowercase,"tt"));

    }

    /**
     * A public method for accessing the functionality provided by class.
     * @returns A map of results. Names of dinucleotides are keys, counters are values
     */

    public Map<String,Long> run(){
        process();
        updateTotal(getContainer());
        return getContainer();
    }
}
