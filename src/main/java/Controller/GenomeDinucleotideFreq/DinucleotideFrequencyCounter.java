package Controller.GenomeDinucleotideFreq;

import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class contains  variables and methods needed to count and compute occurrences of
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
            total  = aaCounter+
                     acCounter+
                     agCounter+
                     atCounter+
                     caCounter+
                     ccCounter+
                     cgCounter+
                     ctCounter+
                     gaCounter+
                     gcCounter+
                     ggCounter+
                     gtCounter+
                     taCounter+
                     tcCounter+
                     tgCounter+
                     ttCounter;

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

        aaCounter += StringUtils.countOccurrencesOf(inputLowercase,aa);
        acCounter += StringUtils.countOccurrencesOf(inputLowercase,ac);
        agCounter += StringUtils.countOccurrencesOf(inputLowercase,ag);
        atCounter += StringUtils.countOccurrencesOf(inputLowercase,at);
        caCounter += StringUtils.countOccurrencesOf(inputLowercase,ca);
        ccCounter += StringUtils.countOccurrencesOf(inputLowercase,cc);
        cgCounter += StringUtils.countOccurrencesOf(inputLowercase,cg);
        ctCounter += StringUtils.countOccurrencesOf(inputLowercase,ct);
        gaCounter += StringUtils.countOccurrencesOf(inputLowercase,ga);
        gcCounter += StringUtils.countOccurrencesOf(inputLowercase,gc);
        ggCounter += StringUtils.countOccurrencesOf(inputLowercase,gg);
        gtCounter += StringUtils.countOccurrencesOf(inputLowercase,gt);
        taCounter += StringUtils.countOccurrencesOf(inputLowercase,ta);
        tcCounter += StringUtils.countOccurrencesOf(inputLowercase,tc);
        tgCounter += StringUtils.countOccurrencesOf(inputLowercase,tg);
        ttCounter += StringUtils.countOccurrencesOf(inputLowercase,tt);

    }

    /**
     * A public method for accessing the functionality provided by class.
     * @returns A map of results. Names of dinucleotides are keys, counters are values
     */

    public Map<String,Long> run(){
        process();
        return formResults();
    }
}
