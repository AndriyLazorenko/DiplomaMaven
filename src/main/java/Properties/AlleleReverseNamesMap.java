package Properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Lazorenko on 26.05.2015.
 */
public class AlleleReverseNamesMap {

    Properties properties = new Properties();

    public AlleleReverseNamesMap() {
        try {
            FileReader fr = new FileReader("src/main/resources/ConfigFiles/Properties/AlleleReverseNames.txt");
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

