package Controller.GenomeDinucleotideFreq;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;
import java.util.TreeMap;

/**
 * Handles all results on dinucleotide occurrence in analysed areas of genome.
 * Extends abstract class VariableContainer
 * @author andriylazorenko
 */

public class AllResultsContainer extends VariableContainer {

    /**
     * Variables
     */

    private Map <String,Long> results;
    private Map <String,String> frequencies;
    private static final String outputPath = "src/main/resources/DinucleotideOccurrence.txt";

    /**
     * Getters
     */

    public Map<String, String> getFrequencies() {
        return frequencies;
    }
    public Map<String, Long> getResults() {
        return results;
    }

    /**
     * Prints container variables to console
     */

    public void printContainerToConsole(){
        results = formResults();
        for (String s :results.keySet()) {
            System.out.println(s+" = "+results.get(s).toString());
        }
    }

    /**
     * Writes results to a txt file
     */

    public void writeContainerToFile(){
        results = formResults();
        File output = new File(outputPath);
        try {
            FileWriter fw = new FileWriter(output);
            for (String s : results.keySet()) {
                fw.write(s+" = "+results.get(s).toString()+"\n");
                fw.flush();
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads results from file
     */

    private void load(){
        File input = new File (outputPath);
        results = new TreeMap<>();
        try {
            FileReader fr = new FileReader(input);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line!= null) {
                String key = line.substring(0,line.indexOf(" "));
                Long value = Long.parseLong(line.substring(line.indexOf("=") + 2, line.length()));
                results.put(key,value);
                line = br.readLine();
            }
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method creates Map<String, Double> of frequencies of occurrence of dinucleotides in alphabetical
     * order in the container.
     * @parameter results - Map of results is required for correct work of this method
     * @return Map <String,Double> frequencies object containing names of dinucleotides with corresponding
     * frequencies of occurrence
     */

    public void computeFrequencies(){
        load();
        frequencies = new TreeMap<>();
        long denominator = results.get("total");
        frequencies.put("aaFreq", formatter((double)results.get("aa")/denominator));
        frequencies.put("acFreq", formatter((double)results.get("ac")/denominator));
        frequencies.put("agFreq", formatter((double)results.get("ag")/denominator));
        frequencies.put("atFreq", formatter((double)results.get("at")/denominator));
        frequencies.put("caFreq", formatter((double)results.get("ca")/denominator));
        frequencies.put("ccFreq", formatter((double)results.get("cc")/denominator));
        frequencies.put("cgFreq", formatter((double)results.get("cg")/denominator));
        frequencies.put("ctFreq", formatter((double)results.get("ct")/denominator));
        frequencies.put("gaFreq", formatter((double)results.get("ga")/denominator));
        frequencies.put("gcFreq", formatter((double)results.get("gc")/denominator));
        frequencies.put("ggFreq", formatter((double)results.get("gg")/denominator));
        frequencies.put("gtFreq", formatter((double)results.get("gt")/denominator));
        frequencies.put("taFreq", formatter((double)results.get("ta")/denominator));
        frequencies.put("tcFreq", formatter((double)results.get("tc")/denominator));
        frequencies.put("tgFreq", formatter((double)results.get("tg")/denominator));
        frequencies.put("ttFreq", formatter((double)results.get("tt")/denominator));
    }

    /**
     * Formats double to output to 3 decimal points for better reading
     * @param d - double type input value
     * @returns String type value formatted for output
     */

    private String formatter(double d) {
        NumberFormat formatter = new DecimalFormat("#0.000");
        String forRet = formatter.format(d);
        return forRet;
    }
}
