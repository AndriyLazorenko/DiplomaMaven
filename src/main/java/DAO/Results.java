package DAO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Contains logic of accessing to ResultsFineWording file containing map of names and applying them
 * as well as providing access to variationAllele
 * @author andriylazorenko
 */

public class Results {
    private Properties properties = new Properties();
    private String variationAllele = "";

    public Properties getProperties() {
        return properties;
    }

    public String getVariationAllele() {
        return variationAllele;
    }

    public Results(Properties properties, String variationAllele) {
        this.properties=properties;
        this.variationAllele=variationAllele;
    }

    public Properties applyWording(){
        FileReader fr;
        Properties forRet = new Properties();
        try {
            fr = new FileReader("src/main/resources/ConfigFiles/Properties/ResultsFineWording.txt");
            Properties phrases = new Properties();
            phrases.load(fr);
            for(Object o: properties.keySet()){
                String s = (String)o;
                s=s.trim();
                forRet.setProperty(phrases.getProperty(s),properties.getProperty(s));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return forRet;
    }

    public void erase(){
        properties=new Properties();
        variationAllele="";
    }
}
