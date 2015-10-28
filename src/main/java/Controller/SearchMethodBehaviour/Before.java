package Controller.SearchMethodBehaviour;

import DAO.Results;

/**
 * Created by Master on 04-May-15.
 */
public class Before extends Both implements SearchMethod {

    @Override
    public void searchInSingleString(String s) {

        //Before part

        if (s.contains("AA\t"+variationAllele)) {
            setAaBefore(getAaBefore() + 1);
        } else if (s.contains("AC\t"+variationAllele)) {
            setAcBefore(getAcBefore() + 1);
        } else if (s.contains("AG\t"+variationAllele)) {
            setAgBefore(getAgBefore() + 1);
        } else if (s.contains("AT\t"+variationAllele)) {
            setAtBefore(getAtBefore() + 1);
        } else if (s.contains("CA\t"+variationAllele)) {
            setCaBefore(getCaBefore() + 1);
        } else if (s.contains("CC\t"+variationAllele)) {
            setCcBefore(getCcBefore() + 1);
        } else if (s.contains("CG\t"+variationAllele)) {
            setCgBefore(getCgBefore() + 1);
        } else if (s.contains("CT\t"+variationAllele)) {
            setCtBefore(getCtBefore() + 1);
        } else if (s.contains("GA\t"+variationAllele)) {
            setGaBefore(getGaBefore() + 1);
        } else if (s.contains("GC\t"+variationAllele)) {
            setGcBefore(getGcBefore() + 1);
        } else if (s.contains("GG\t"+variationAllele)) {
            setGgBefore(getGgBefore() + 1);
        } else if (s.contains("GT\t"+variationAllele)) {
            setGtBefore(getGtBefore() + 1);
        } else if (s.contains("TA\t"+variationAllele)) {
            setTaBefore(getTaBefore() + 1);
        } else if (s.contains("TC\t"+variationAllele)) {
            setTcBefore(getTcBefore() + 1);
        } else if (s.contains("TG\t"+variationAllele)) {
            setTgBefore(getTgBefore() + 1);
        } else if (s.contains("TT\t"+variationAllele)) {
            setTtBefore(getTtBefore() + 1);
        }
        setI(getI() + 1);

    }

    @Override
    public Results fastCompute() {

        computeBefore();

        //Creating an output set

        addBeforeToResults();
        addBeforeFreqToResults();

        properties.setProperty("Total", String.valueOf(getI()));

        Results forRet = new Results(properties,variationAllele);

        return forRet;
    }

    @Override
    public void getVariationAllele(String variationAllele) {
        this.variationAllele=variationAllele;
    }

}
