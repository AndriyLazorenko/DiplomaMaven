package Controller.InputProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class handles allele validation and standardizes the allele name
 * @author andriylazorenko
 */

public class AlleleValidation {

    /**
     * Validation method (needs console input)
     * @returns String value of standardized allele name
     * @throws IOException
     */

    public String ask () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String variationAllele;
        boolean variationAlleleIsCorrect;
        do {
            variationAlleleIsCorrect=true;
            System.out.println("Insert Variation Allele");
            variationAllele=br.readLine();
            if (variationAllele.equals("A")|| variationAllele.equals("a")){
                variationAllele="A";
            }
            else if (variationAllele.equals("B")|| variationAllele.equals("b")){
                variationAllele="B";
            }
            else if (variationAllele.equals("C")|| variationAllele.equals("c")){
                variationAllele="C";
            }
            else if (variationAllele.equals("D")|| variationAllele.equals("d")){
                variationAllele="D";
            }
            else if (variationAllele.equals("G")|| variationAllele.equals("g")){
                variationAllele="G";
            }
            else if (variationAllele.equals("Germline")|| variationAllele.equals("germline")){
                variationAllele="Germline";
            }
            else if (variationAllele.equals("H")|| variationAllele.equals("h")){
                variationAllele="H";
            }
            else if (variationAllele.equals("K")|| variationAllele.equals("k")){
                variationAllele="K";
            }
            else if (variationAllele.equals("M")|| variationAllele.equals("m")){
                variationAllele="M";
            }
            else if (variationAllele.equals("N")|| variationAllele.equals("n")){
                variationAllele="N";
            }
            else if (variationAllele.equals("R")|| variationAllele.equals("r")){
                variationAllele="R";
            }
            else if (variationAllele.equals("S")|| variationAllele.equals("s")){
                variationAllele="S";
            }
            else if (variationAllele.equals("Somatic")|| variationAllele.equals("somatic")){
                variationAllele="Somatic";
            }
            else if (variationAllele.equals("T")|| variationAllele.equals("t")){
                variationAllele="T";
            }
            else if (variationAllele.equals("V")|| variationAllele.equals("v")){
                variationAllele="V";
            }
            else if (variationAllele.equals("W")|| variationAllele.equals("w")){
                variationAllele="W";
            }
            else if (variationAllele.equals("Y")|| variationAllele.equals("y")){
                variationAllele="Y";
            }
            else {
                variationAlleleIsCorrect=(false);
            }
        } while (variationAlleleIsCorrect == false);
        return variationAllele;
    }
}
