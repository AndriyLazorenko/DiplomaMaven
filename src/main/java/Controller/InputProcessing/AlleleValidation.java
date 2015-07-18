package Controller.InputProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlleleValidation {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private String variationAllele;
    private boolean variationAlleleIsCorrect;

    public String ask () throws IOException {
        do {
            setVariationAlleleIsCorrect(true);
            System.out.println("Insert Variation Allele");
            setVariationAllele(getBr().readLine());
            if (getVariationAllele().equals("A")|| getVariationAllele().equals("a")){
                setVariationAllele("A");
            }
            else if (getVariationAllele().equals("B")|| getVariationAllele().equals("b")){
                setVariationAllele("B");
            }
            else if (getVariationAllele().equals("C")|| getVariationAllele().equals("c")){
                setVariationAllele("C");
            }
            else if (getVariationAllele().equals("D")|| getVariationAllele().equals("d")){
                setVariationAllele("D");
            }
            else if (getVariationAllele().equals("G")|| getVariationAllele().equals("g")){
                setVariationAllele("G");
            }
            else if (getVariationAllele().equals("Germline")|| getVariationAllele().equals("germline")){
                setVariationAllele("Germline");
            }
            else if (getVariationAllele().equals("H")|| getVariationAllele().equals("h")){
                setVariationAllele("H");
            }
            else if (getVariationAllele().equals("K")|| getVariationAllele().equals("k")){
                setVariationAllele("K");
            }
            else if (getVariationAllele().equals("M")|| getVariationAllele().equals("m")){
                setVariationAllele("M");
            }
            else if (getVariationAllele().equals("N")|| getVariationAllele().equals("n")){
                setVariationAllele("N");
            }
            else if (getVariationAllele().equals("R")|| getVariationAllele().equals("r")){
                setVariationAllele("R");
            }
            else if (getVariationAllele().equals("S")|| getVariationAllele().equals("s")){
                setVariationAllele("S");
            }
            else if (getVariationAllele().equals("Somatic")|| getVariationAllele().equals("somatic")){
                setVariationAllele("Somatic");
            }
            else if (getVariationAllele().equals("T")|| getVariationAllele().equals("t")){
                setVariationAllele("T");
            }
            else if (getVariationAllele().equals("V")|| getVariationAllele().equals("v")){
                setVariationAllele("V");
            }
            else if (getVariationAllele().equals("W")|| getVariationAllele().equals("w")){
                setVariationAllele("W");
            }
            else if (getVariationAllele().equals("Y")|| getVariationAllele().equals("y")){
                setVariationAllele("Y");
            }
            else {
                setVariationAlleleIsCorrect(false);
            }
        } while (isVariationAlleleIsCorrect() == false);
        return getVariationAllele();
    }

    public BufferedReader getBr() {
        return br;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }

    public String getVariationAllele() {
        return variationAllele;
    }

    public void setVariationAllele(String variationAllele) {
        this.variationAllele = variationAllele;
    }

    public boolean isVariationAlleleIsCorrect() {
        return variationAlleleIsCorrect;
    }

    public void setVariationAlleleIsCorrect(boolean variationAlleleIsCorrect) {
        this.variationAlleleIsCorrect = variationAlleleIsCorrect;
    }
}
