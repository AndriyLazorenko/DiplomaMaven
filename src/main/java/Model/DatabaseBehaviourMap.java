package Model;

import Controller.DatabaseParsingBehaviour.ParseBoth;
import Controller.DatabaseParsingBehaviour.ParsingDBBehaviour;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Master on 12-May-15.
 */
public class DatabaseBehaviourMap {
    private Map<String, ParsingDBBehaviour> databaseBehaviour = new HashMap<>();

    public DatabaseBehaviourMap() {
        databaseBehaviour.put("R", new ParseBoth());
        databaseBehaviour.put("Y", new ParseBoth());
        databaseBehaviour.put("K", new ParseBoth());
        databaseBehaviour.put("M", new ParseBoth());
        databaseBehaviour.put("W", new ParseBoth());
        databaseBehaviour.put("S", new ParseBoth());
    }

    public Map<String, ParsingDBBehaviour> getDatabaseBehaviour() {
        return databaseBehaviour;
    }
}
