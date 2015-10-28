package Controller.DatabaseParsingBehaviour;

import Controller.SearchMethodBehaviour.Both;
import DAO.Results;

/**
 * Created by Master on 05-May-15.
 */
public class ParseAfter extends Both implements ParsingDBBehaviour {


    @Override
    public void addToDB(Results results) {

        this.variationAllele = results.getVariationAllele();

        setAaAfter(getAaAfter() + Integer.parseInt(results.getProperties().getProperty("AA_After")));
        setAcAfter(getAcAfter() + Integer.parseInt(results.getProperties().getProperty("AC_After")));
        setAgAfter(getAgAfter() + Integer.parseInt(results.getProperties().getProperty("AG_After")));
        setAtAfter(getAtAfter() + Integer.parseInt(results.getProperties().getProperty("AT_After")));
        setCaAfter(getCaAfter() + Integer.parseInt(results.getProperties().getProperty("CA_After")));
        setCcAfter(getCcAfter() + Integer.parseInt(results.getProperties().getProperty("CC_After")));
        setCgAfter(getCgAfter() + Integer.parseInt(results.getProperties().getProperty("CG_After")));
        setCtAfter(getCtAfter() + Integer.parseInt(results.getProperties().getProperty("CT_After")));
        setGaAfter(getGaAfter() + Integer.parseInt(results.getProperties().getProperty("GA_After")));
        setGcAfter(getGcAfter() + Integer.parseInt(results.getProperties().getProperty("GC_After")));
        setGgAfter(getGgAfter() + Integer.parseInt(results.getProperties().getProperty("GG_After")));
        setGtAfter(getGtAfter() + Integer.parseInt(results.getProperties().getProperty("GT_After")));
        setTaAfter(getTaAfter() + Integer.parseInt(results.getProperties().getProperty("TA_After")));
        setTcAfter(getTcAfter() + Integer.parseInt(results.getProperties().getProperty("TC_After")));
        setTgAfter(getTgAfter() + Integer.parseInt(results.getProperties().getProperty("TG_After")));
        setTtAfter(getTtAfter() + Integer.parseInt(results.getProperties().getProperty("TT_After")));

        setI(getI() + Integer.parseInt(results.getProperties().getProperty("Total")));
    }

    @Override
    public void compute() {

        computeAfter();

    }

    @Override
    public Results creatingResults(String variationAllele) {

        this.variationAllele = variationAllele;

        addAfterToResults();
        addAfterFreqToResults();

        properties.setProperty("Total", String.valueOf(getI()));

        Results forRet = new Results(properties,variationAllele);

        return forRet;

    }
}
