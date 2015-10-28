package Tests;


import org.springframework.util.StringUtils;

/**
 * Created by Master on 27-Apr-15.
 */
public class VariousTests {
    public static void main(String[] args) {
//        String variationAllele = "ablabla";
//        int AaAfter = 56;
//        String fileName = "G:\\GoogleDrive\\Genetics\\Diploma\\R\\R_0.05-0.5_2315015\\R_0.05-0.07_260139.txt";
//        fileName=fileName.substring(0,fileName.lastIndexOf("\\"))+"\\R_Allele_Results_Database.txt";
//        System.out.println(fileName);
//        String s = "Total number of AA phrases Controller.SearchMethodBehaviour.After "+variationAllele+" = " + AaAfter;
//        System.out.println(Integer.parseInt(s.substring(s.lastIndexOf(" ")+1)));
//        double d = 1.0;
//        d=d/3;
//        NumberFormat formatPhrase = new DecimalFormat("#0.000");
//        String forRet = formatPhrase.format(d);
//        System.out.println(forRet);
//        String s = "rs363836\t[Homo sapiens]\tGGACCCGGGTATCAGCGGAGACCTGA\tC/T\tGGAGAAGGCTGTGTAGGTAAGAGGA";
//        Pattern p = Pattern.compile("Homo");
//        Matcher m = p.matcher(s);
//        int count = 0;
//        while (m.find()) {
//            count++;
//            System.out.println(count);
//            System.out.println("Start " + m.start());
//            System.out.println("End " + m.end());
//        }

//        AlleleNamesMap anm = new AlleleNamesMap();
//        System.out.println(anm.getAlleleNames().get("R").toString());
        String aa = "aa";
        String s = "build150402-0955.1rs17571\t[homo sapiens]\taggccccgtctcaaagtactcccagg\tc/t\tggtgccagccgtgaccgaggggccc";
        System.out.println(StringUtils.countOccurrencesOf(s,aa));
    }
}
