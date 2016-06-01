package Model;

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
            FileReader fr = new FileReader("src/main/resources/ConfigFiles/Properties/AlleleNames.txt");
            properties.load(fr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Properties getAlleleNames() {
        return properties;
    }
}
