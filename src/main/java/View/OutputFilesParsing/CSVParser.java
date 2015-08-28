package View.OutputFilesParsing;


import Controller.GenomeDinucleotideFreq.ResultsProcessor;
import Properties.Results;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Class is created for data output formatted in .csv excel-ready. Accepts Results class object
 * and ready-for-CSV String object.
 * @author andriylazorenko
 */

public class CSVParser {

    /**
     * Other variables
     */

    private String[] forCSV;
    private Results results;
    private ResultsProcessor adjustedFreq;

    /**
     * Constructor of class. Receives Results object and produces forCSV array of Strings from
     * template, accessed by hard-coded path
     * @param res - Results object received
     * @param adjustedFreq - statistical frequencies of occurrence of dinucleotides in studied data
     * @returns forCSV - array of Strings used by @toCSV method
     */

    public CSVParser(Results res, ResultsProcessor adjustedFreq) {
        FileReader fileReader;
        Set<String> helper = new LinkedHashSet<>();
        this.results = res;
        this.adjustedFreq = adjustedFreq;
        this.adjustedFreq.computeFrequencies();
        try {
            final String templatePath = "src/main/resources/ConfigFiles/ExcelFormatting/Template.txt";
            fileReader = new FileReader(templatePath);
            BufferedReader br = new BufferedReader(fileReader);
            String line = br.readLine();
            int counter=0;
            while (line!=null) {
                counter++;
                helper.add(line);
                line = br.readLine();
            }

            forCSV=new String[counter];

            int i = 0;
            Iterator<String> iter = helper.iterator();
            while (iter.hasNext()) {
                line = iter.next();
                forCSV[i]=line;
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Uses forCSV array of Strings created by constructor to produce a String of results
     * ready to be written in a .CSV file
     * @return String of results ready to be written in a .CSV file
     */

    public String toCSV() {

        forCSV[0]=forCSV[0];
        forCSV[1]=forCSV[1].replace(";;", ";" + results.getVariationAllele() + ";");

        /*The block substitutes ;; symbols in the pattern with number of occurrences of corresponding
        dinucleotides after SNP*/

        forCSV[4]=forCSV[4].replaceFirst(";;"  ,";"+results.getProperties().getProperty("AA_After")+";");
        forCSV[5]=forCSV[5].replaceFirst(";;"  ,";"+results.getProperties().getProperty("AC_After")+";");
        forCSV[6]=forCSV[6].replaceFirst(";;"  ,";"+results.getProperties().getProperty("AG_After")+";");
        forCSV[7]=forCSV[7].replaceFirst(";;"  ,";"+results.getProperties().getProperty("AT_After")+";");
        forCSV[8]=forCSV[8].replaceFirst(";;"  ,";"+results.getProperties().getProperty("CA_After")+";");
        forCSV[9]=forCSV[9].replaceFirst(";;"  ,";"+results.getProperties().getProperty("CC_After")+";");
        forCSV[10]=forCSV[10].replaceFirst(";;",";"+results.getProperties().getProperty("CG_After")+";");
        forCSV[11]=forCSV[11].replaceFirst(";;",";"+results.getProperties().getProperty("CT_After")+";");
        forCSV[12]=forCSV[12].replaceFirst(";;",";"+results.getProperties().getProperty("GA_After")+";");
        forCSV[13]=forCSV[13].replaceFirst(";;",";"+results.getProperties().getProperty("GC_After")+";");
        forCSV[14]=forCSV[14].replaceFirst(";;",";"+results.getProperties().getProperty("GG_After")+";");
        forCSV[15]=forCSV[15].replaceFirst(";;",";"+results.getProperties().getProperty("GT_After")+";");
        forCSV[16]=forCSV[16].replaceFirst(";;",";"+results.getProperties().getProperty("TA_After")+";");
        forCSV[17]=forCSV[17].replaceFirst(";;",";"+results.getProperties().getProperty("TC_After")+";");
        forCSV[18]=forCSV[18].replaceFirst(";;",";"+results.getProperties().getProperty("TG_After")+";");
        forCSV[19]=forCSV[19].replaceFirst(";;",";"+results.getProperties().getProperty("TT_After")+";");

        /*The block substitutes 1/16 symbols in the pattern with frequency of occurrence of corresponding
        dinucleotides in data analysed*/

        forCSV[4]=forCSV[4].replaceFirst("1/16"  ,adjustedFreq.getFrequencies().get("aaFreq"));
        forCSV[5]=forCSV[5].replaceFirst("1/16"  ,adjustedFreq.getFrequencies().get("acFreq"));
        forCSV[6]=forCSV[6].replaceFirst("1/16"  ,adjustedFreq.getFrequencies().get("agFreq"));
        forCSV[7]=forCSV[7].replaceFirst("1/16"  ,adjustedFreq.getFrequencies().get("atFreq"));
        forCSV[8]=forCSV[8].replaceFirst("1/16"  ,adjustedFreq.getFrequencies().get("caFreq"));
        forCSV[9]=forCSV[9].replaceFirst("1/16"  ,adjustedFreq.getFrequencies().get("ccFreq"));
        forCSV[10]=forCSV[10].replaceFirst("1/16",adjustedFreq.getFrequencies().get("cgFreq"));
        forCSV[11]=forCSV[11].replaceFirst("1/16",adjustedFreq.getFrequencies().get("ctFreq"));
        forCSV[12]=forCSV[12].replaceFirst("1/16",adjustedFreq.getFrequencies().get("gaFreq"));
        forCSV[13]=forCSV[13].replaceFirst("1/16",adjustedFreq.getFrequencies().get("gcFreq"));
        forCSV[14]=forCSV[14].replaceFirst("1/16",adjustedFreq.getFrequencies().get("ggFreq"));
        forCSV[15]=forCSV[15].replaceFirst("1/16",adjustedFreq.getFrequencies().get("gtFreq"));
        forCSV[16]=forCSV[16].replaceFirst("1/16",adjustedFreq.getFrequencies().get("taFreq"));
        forCSV[17]=forCSV[17].replaceFirst("1/16",adjustedFreq.getFrequencies().get("tcFreq"));
        forCSV[18]=forCSV[18].replaceFirst("1/16",adjustedFreq.getFrequencies().get("tgFreq"));
        forCSV[19]=forCSV[19].replaceFirst("1/16",adjustedFreq.getFrequencies().get("ttFreq"));

        /*This block substitutes 'abs' symbols from template for absolute values of dinucleotide
         occurrence */

        forCSV[4]=forCSV[4].replace("abs"  ,adjustedFreq.getResults().get("aa").toString());
        forCSV[5]=forCSV[5].replace("abs"  ,adjustedFreq.getResults().get("ac").toString());
        forCSV[6]=forCSV[6].replace("abs"  ,adjustedFreq.getResults().get("ag").toString());
        forCSV[7]=forCSV[7].replace("abs"  ,adjustedFreq.getResults().get("at").toString());
        forCSV[8]=forCSV[8].replace("abs"  ,adjustedFreq.getResults().get("ca").toString());
        forCSV[9]=forCSV[9].replace("abs"  ,adjustedFreq.getResults().get("cc").toString());
        forCSV[10]=forCSV[10].replace("abs",adjustedFreq.getResults().get("cg").toString());
        forCSV[11]=forCSV[11].replace("abs",adjustedFreq.getResults().get("ct").toString());
        forCSV[12]=forCSV[12].replace("abs",adjustedFreq.getResults().get("ga").toString());
        forCSV[13]=forCSV[13].replace("abs",adjustedFreq.getResults().get("gc").toString());
        forCSV[14]=forCSV[14].replace("abs",adjustedFreq.getResults().get("gg").toString());
        forCSV[15]=forCSV[15].replace("abs",adjustedFreq.getResults().get("gt").toString());
        forCSV[16]=forCSV[16].replace("abs",adjustedFreq.getResults().get("ta").toString());
        forCSV[17]=forCSV[17].replace("abs",adjustedFreq.getResults().get("tc").toString());
        forCSV[18]=forCSV[18].replace("abs",adjustedFreq.getResults().get("tg").toString());
        forCSV[19]=forCSV[19].replace("abs",adjustedFreq.getResults().get("tt").toString());
        forCSV[20]=forCSV[20].replace("abs",adjustedFreq.getResults().get("total").toString());


        /*The block substitutes ;; symbols in the pattern with number of occurrences of corresponding
        dinucleotides before SNP*/

        forCSV[4]=forCSV[4].replace(";;", ";" + results.getProperties().getProperty("AA_before") + ";");
        forCSV[5]=forCSV[5].replace(";;", ";" + results.getProperties().getProperty("AC_before") + ";");
        forCSV[6]=forCSV[6].replace(";;", ";" + results.getProperties().getProperty("AG_before") + ";");
        forCSV[7]=forCSV[7].replace(";;", ";" + results.getProperties().getProperty("AT_before") + ";");
        forCSV[8]=forCSV[8].replace(";;", ";" + results.getProperties().getProperty("CA_before") + ";");
        forCSV[9]=forCSV[9].replace(";;", ";" + results.getProperties().getProperty("CC_before") + ";");
        forCSV[10]=forCSV[10].replace(";;", ";" + results.getProperties().getProperty("CG_before") + ";");
        forCSV[11]=forCSV[11].replace(";;", ";" + results.getProperties().getProperty("CT_before") + ";");
        forCSV[12]=forCSV[12].replace(";;", ";" + results.getProperties().getProperty("GA_before") + ";");
        forCSV[13]=forCSV[13].replace(";;", ";" + results.getProperties().getProperty("GC_before") + ";");
        forCSV[14]=forCSV[14].replace(";;", ";" + results.getProperties().getProperty("GG_before") + ";");
        forCSV[15]=forCSV[15].replace(";;", ";" + results.getProperties().getProperty("GT_before") + ";");
        forCSV[16]=forCSV[16].replace(";;", ";" + results.getProperties().getProperty("TA_before") + ";");
        forCSV[17]=forCSV[17].replace(";;", ";" + results.getProperties().getProperty("TC_before") + ";");
        forCSV[18]=forCSV[18].replace(";;", ";" + results.getProperties().getProperty("TG_before") + ";");
        forCSV[19]=forCSV[19].replace(";;", ";" + results.getProperties().getProperty("TT_before") + ";");

        forCSV[20]=forCSV[20].replaceAll("after", results.getProperties().getProperty("Sum_After"));
        forCSV[20]=forCSV[20].replaceAll("before", results.getProperties().getProperty("Sum_Before"));
        forCSV[21]=forCSV[21].replace("diff_before", results.getProperties().getProperty("Diff_Before"));
        forCSV[21]=forCSV[21].replace("diff_after",results.getProperties().getProperty("Diff_After"));
        forCSV[22]=forCSV[22].replace("total_snp",results.getProperties().getProperty("Total"));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <forCSV.length ; i++) {
            sb.append(forCSV[i]).append("\n");
        }
        return sb.toString();
    }


}
