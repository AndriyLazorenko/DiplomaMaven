package Properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Master on 12-May-15.
 */
public class AlleleNamesMap {

    Properties properties = new Properties();

    public AlleleNamesMap() {
        try {
            FileReader fr = new FileReader("src/ConfigFiles/Properties.Properties/AlleleNames.txt");
            properties.load(fr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        alleleNames.put("R", "A/G");
//        alleleNames.put("Y", "C/T");
//        alleleNames.put("K", "G/T");
//        alleleNames.put("M", "A/C");
//        alleleNames.put("W", "A/T");
//        alleleNames.put("S", "C/G");
    }

    public Properties getAlleleNames() {
        return properties;
    }
}
