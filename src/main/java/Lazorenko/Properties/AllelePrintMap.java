package Properties;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lazorenko on 26.05.2015.
 */
public class AllelePrintMap {
    private Map<String, File> allelePrint = new HashMap<>();

    public AllelePrintMap() {
        allelePrint.put("R", new File("src/ConfigFiles/Properties.Properties/OrderForPrintBoth.txt"));
        allelePrint.put("Y", new File("src/ConfigFiles/Properties.Properties/OrderForPrintBoth.txt"));
        allelePrint.put("K", new File("src/ConfigFiles/Properties.Properties/OrderForPrintBoth.txt"));
        allelePrint.put("M", new File("src/ConfigFiles/Properties.Properties/OrderForPrintBoth.txt"));
        allelePrint.put("W", new File("src/ConfigFiles/Properties.Properties/OrderForPrintBoth.txt"));
        allelePrint.put("S", new File("src/ConfigFiles/Properties.Properties/OrderForPrintBoth.txt"));
    }

    public Map<String, File> getAllelePrint() {
        return allelePrint;
    }
}
