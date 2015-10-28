package Controller.DatabaseParsingBehaviour;

import DAO.Results;

/**
 * Created by Master on 05-May-15.
 */
public interface ParsingDBBehaviour {
    public void addToDB(Results results);
    public void compute();
    public Results creatingResults(String variationAllele);
    public void erase();
}
