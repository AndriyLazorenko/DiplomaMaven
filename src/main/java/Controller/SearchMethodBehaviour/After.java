package Controller.SearchMethodBehaviour;

import DAO.Results;

/**
 * Created by Master on 04-May-15.
 */
public class After extends Both implements SearchMethod {

    @Override
    public void searchInSingleString(String s) {

        //After part

        if (s.contains(variationAllele+"\tAA")) {
            setAaAfter(getAaAfter()+1);
        } else if (s.contains(variationAllele+"\tAC")) {
            setAcAfter(getAcAfter() + 1);
        } else if (s.contains(variationAllele+"\tAG")) {
            setAgAfter(getAgAfter() + 1);
        } else if (s.contains(variationAllele+"\tAT")) {
            setAtAfter(getAtAfter() + 1);
        } else if (s.contains(variationAllele+"\tCA")) {
            setCaAfter(getCaAfter() + 1);
        } else if (s.contains(variationAllele+"\tCC")) {
            setCcAfter(getCcAfter() + 1);
        } else if (s.contains(variationAllele+"\tCG")) {
            setCgAfter(getCgAfter() + 1);
        } else if (s.contains(variationAllele+"\tCT")) {
            setCtAfter(getCtAfter() + 1);
        } else if (s.contains(variationAllele+"\tGA")) {
            setGaAfter(getGaAfter() + 1);
        } else if (s.contains(variationAllele+"\tGC")) {
            setGcAfter(getGcAfter() + 1);
        } else if (s.contains(variationAllele+"\tGG")) {
            setGgAfter(getGgAfter() + 1);
        } else if (s.contains(variationAllele+"\tGT")) {
            setGtAfter(getGtAfter() + 1);
        } else if (s.contains(variationAllele+"\tTA")) {
            setTaAfter(getTaAfter() + 1);
        } else if (s.contains(variationAllele+"\tTC")) {
            setTcAfter(getTcAfter() + 1);
        } else if (s.contains(variationAllele+"\tTG")) {
            setTgAfter(getTgAfter() + 1);
        } else if (s.contains(variationAllele+"\tTT")) {
            setTtAfter(getTtAfter() + 1);
        }
        setI(getI() + 1);
    }

    @Override
    public Results fastCompute() {

        computeAfter();

        //Creating an output set

        addAfterToResults();
        addAfterFreqToResults();

        properties.setProperty("Total", String.valueOf(getI()));

        Results forRet = new Results(properties,variationAllele);

        return forRet;
    }

    @Override
    public void getVariationAllele(String variationAllele) {
        this.variationAllele=variationAllele;
    }

}
