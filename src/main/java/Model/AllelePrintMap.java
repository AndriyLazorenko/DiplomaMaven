package Model;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lazorenko on 26.05.2015.
 */
public class AllelePrintMap {
    private Map<String, File> allelePrint = new HashMap<>();
    private final File propertyBoth = new File("src/main/resources/ConfigFiles/Properties/OrderForPrintBoth.txt");

    public AllelePrintMap() {
        allelePrint.put("R", propertyBoth);
        allelePrint.put("Y", propertyBoth);
        allelePrint.put("K", propertyBoth);
        allelePrint.put("M", propertyBoth);
        allelePrint.put("W", propertyBoth);
        allelePrint.put("S", propertyBoth);
    }

    public Map<String, File> getAllelePrint() {
        return allelePrint;
    }
}
