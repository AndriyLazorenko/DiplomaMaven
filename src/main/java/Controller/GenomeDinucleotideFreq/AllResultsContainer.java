package Controller.GenomeDinucleotideFreq;

import java.io.*;
import java.util.Map;

/**
 * Handles all results on dinucleotide occurrence in analysed areas of genome.
 * Extends abstract class VariableContainer
 * @author andriylazorenko
 */

public class AllResultsContainer extends VariableContainer {

    /**
     * Variables
     */

    private Map <String,Object> results;
    private static final String outputPath = "src/main/resources/DinucleotideOccurrence.txt";

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
                fw.write(s+" = "+results.get(s).toString());
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

    public void load(){
        File input = new File (outputPath);
        try {
            FileReader fr = new FileReader(input);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line!= null) {
                String key = line.substring(0,1);
                Object value = line.substring(5,line.length());
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



}
