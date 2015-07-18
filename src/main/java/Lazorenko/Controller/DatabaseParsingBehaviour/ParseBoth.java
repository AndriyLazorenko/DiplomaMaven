package Controller.DatabaseParsingBehaviour;

import Controller.SearchMethodBehaviour.Both;
import Properties.Results;

/**
 * Created by Master on 05-May-15.
 */
public class ParseBoth extends Both implements ParsingDBBehaviour {

    @Override
    public void addToDB(Results results) {

        this.variationAllele = results.getVariationAllele();

        setAaAfter(getAaAfter()+Integer.parseInt(results.getProperties().getProperty("AA_After")));
        setAcAfter(getAcAfter()+Integer.parseInt(results.getProperties().getProperty("AC_After")));
        setAgAfter(getAgAfter()+Integer.parseInt(results.getProperties().getProperty("AG_After")));
        setAtAfter(getAtAfter()+Integer.parseInt(results.getProperties().getProperty("AT_After")));
        setCaAfter(getCaAfter()+Integer.parseInt(results.getProperties().getProperty("CA_After")));
        setCcAfter(getCcAfter()+Integer.parseInt(results.getProperties().getProperty("CC_After")));
        setCgAfter(getCgAfter()+Integer.parseInt(results.getProperties().getProperty("CG_After")));
        setCtAfter(getCtAfter()+Integer.parseInt(results.getProperties().getProperty("CT_After")));
        setGaAfter(getGaAfter()+Integer.parseInt(results.getProperties().getProperty("GA_After")));
        setGcAfter(getGcAfter()+Integer.parseInt(results.getProperties().getProperty("GC_After")));
        setGgAfter(getGgAfter()+Integer.parseInt(results.getProperties().getProperty("GG_After")));
        setGtAfter(getGtAfter()+Integer.parseInt(results.getProperties().getProperty("GT_After")));
        setTaAfter(getTaAfter()+Integer.parseInt(results.getProperties().getProperty("TA_After")));
        setTcAfter(getTcAfter()+Integer.parseInt(results.getProperties().getProperty("TC_After")));
        setTgAfter(getTgAfter()+Integer.parseInt(results.getProperties().getProperty("TG_After")));
        setTtAfter(getTtAfter()+Integer.parseInt(results.getProperties().getProperty("TT_After")));

        setAaBefore(getAaBefore()+Integer.parseInt(results.getProperties().getProperty("AA_before")));
        setAcBefore(getAcBefore()+Integer.parseInt(results.getProperties().getProperty("AC_before")));
        setAgBefore(getAgBefore()+Integer.parseInt(results.getProperties().getProperty("AG_before")));
        setAtBefore(getAtBefore()+Integer.parseInt(results.getProperties().getProperty("AT_before")));
        setCaBefore(getCaBefore()+Integer.parseInt(results.getProperties().getProperty("CA_before")));
        setCcBefore(getCcBefore()+Integer.parseInt(results.getProperties().getProperty("CC_before")));
        setCgBefore(getCgBefore()+Integer.parseInt(results.getProperties().getProperty("CG_before")));
        setCtBefore(getCtBefore()+Integer.parseInt(results.getProperties().getProperty("CT_before")));
        setGaBefore(getGaBefore()+Integer.parseInt(results.getProperties().getProperty("GA_before")));
        setGcBefore(getGcBefore()+Integer.parseInt(results.getProperties().getProperty("GC_before")));
        setGgBefore(getGgBefore()+Integer.parseInt(results.getProperties().getProperty("GG_before")));
        setGtBefore(getGtBefore()+Integer.parseInt(results.getProperties().getProperty("GT_before")));
        setTaBefore(getTaBefore()+Integer.parseInt(results.getProperties().getProperty("TA_before")));
        setTcBefore(getTcBefore()+Integer.parseInt(results.getProperties().getProperty("TC_before")));
        setTgBefore(getTgBefore()+Integer.parseInt(results.getProperties().getProperty("TG_before")));
        setTtBefore(getTtBefore()+Integer.parseInt(results.getProperties().getProperty("TT_before")));

        setI(getI()+Integer.parseInt(results.getProperties().getProperty("Total")));

    }

    @Override
    public void compute(){

        computeAfter();
        computeBefore();

    }

    @Override
    public Results creatingResults(String variationAllele) {

        this.variationAllele = variationAllele;
        addAfterToResults();
        addBeforeToResults();
        addAfterFreqToResults();
        addBeforeFreqToResults();
        properties.setProperty("Total", String.valueOf(getI()));

        Results forRet = new Results(properties,variationAllele);

        return forRet;
    }
}
