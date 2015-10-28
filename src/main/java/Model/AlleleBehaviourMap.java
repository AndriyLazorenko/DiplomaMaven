package Model;

import Controller.SearchMethodBehaviour.Both;
import Controller.SearchMethodBehaviour.SearchMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Master on 12-May-15.
 */
public class AlleleBehaviourMap {

    private Map<String, SearchMethod> alleleBehaviour = new HashMap<>();

    public AlleleBehaviourMap() {
        alleleBehaviour.put("R", new Both());
        alleleBehaviour.put("Y", new Both());
        alleleBehaviour.put("K", new Both());
        alleleBehaviour.put("M", new Both());
        alleleBehaviour.put("W", new Both());
        alleleBehaviour.put("S", new Both());
    }

    public Map<String, SearchMethod> getAlleleBehaviour() {
        return alleleBehaviour;
    }
}
