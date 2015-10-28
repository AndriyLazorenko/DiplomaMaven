package Controller.SearchMethodBehaviour;

import DAO.Results;

/**
 * Created by Master on 04-May-15.
 */
public interface SearchMethod {
    public void erase();
    public String formatter(double d);
    public void searchInSingleString(String s);
    public Results fastCompute();
    public void getVariationAllele(String variationAllele);

}
