package Controller.SearchMethodBehaviour;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import Properties.Results;

/**
 * The composite class Both receives all variables necessary for computations from ModelForSearchMethod as well as
 * containing methods responsible for counting occurrences of dinucleotides, computing frequencies and
 * other results
 * @author andriylazorenko
 */

public class Both extends ModelForSearchMethod implements SearchMethod {

    /**
     * The values of counters of dinucleotides after SNP are added to data structure of results
     */

    protected void addAfterToResults(){
        properties.setProperty("AA_After",String.valueOf(getAaAfter()));
        properties.setProperty("AC_After",String.valueOf(getAcAfter()));
        properties.setProperty("AG_After",String.valueOf(getAgAfter()));
        properties.setProperty("AT_After",String.valueOf(getAtAfter()));
        properties.setProperty("CA_After",String.valueOf(getCaAfter()));
        properties.setProperty("CC_After",String.valueOf(getCcAfter()));
        properties.setProperty("CG_After",String.valueOf(getCgAfter()));
        properties.setProperty("CT_After",String.valueOf(getCtAfter()));
        properties.setProperty("GA_After",String.valueOf(getGaAfter()));
        properties.setProperty("GC_After",String.valueOf(getGcAfter()));
        properties.setProperty("GG_After",String.valueOf(getGgAfter()));
        properties.setProperty("GT_After",String.valueOf(getGtAfter()));
        properties.setProperty("TA_After",String.valueOf(getTaAfter()));
        properties.setProperty("TC_After",String.valueOf(getTcAfter()));
        properties.setProperty("TG_After",String.valueOf(getTgAfter()));
        properties.setProperty("TT_After",String.valueOf(getTtAfter()));
        properties.setProperty("Sum_After",String.valueOf(sumOfAfter));
        properties.setProperty("Diff_After",String.valueOf(sumDiffAfter));
    }

    /**
     * The values of frequencies of dinucleotides after SNP are added to data structure of results
     */

    protected void addAfterFreqToResults(){

        properties.setProperty("AA_freq_After",formatter(getAaFreqAfter()));
        properties.setProperty("AC_freq_After",formatter(getAcFreqAfter()));
        properties.setProperty("AG_freq_After",formatter(getAgFreqAfter()));
        properties.setProperty("AT_freq_After",formatter(getAtFreqAfter()));
        properties.setProperty("CA_freq_After",formatter(getCaFreqAfter()));
        properties.setProperty("CC_freq_After",formatter(getCcFreqAfter()));
        properties.setProperty("CG_freq_After",formatter(getCgFreqAfter()));
        properties.setProperty("CT_freq_After",formatter(getCtFreqAfter()));
        properties.setProperty("GA_freq_After",formatter(getGaFreqAfter()));
        properties.setProperty("GC_freq_After",formatter(getGcFreqAfter()));
        properties.setProperty("GG_freq_After",formatter(getGgFreqAfter()));
        properties.setProperty("GT_freq_After",formatter(getGtFreqAfter()));
        properties.setProperty("TA_freq_After",formatter(getTaFreqAfter()));
        properties.setProperty("TC_freq_After",formatter(getTcFreqAfter()));
        properties.setProperty("TG_freq_After",formatter(getTgFreqAfter()));
        properties.setProperty("TT_freq_After",formatter(getTtFreqAfter()));

        properties.setProperty("TT,TA,CT,CA_After",String.valueOf(getTotalSNP()));
        properties.setProperty("Freq_TT,TA,CT,CA_After",formatter(getTotalFreq()));
        properties.setProperty("Diff_After_Freq",formatter(doubleAfterFreq));
    }

    /**
     * The values of counters of dinucleotides before SNP are added to data structure of results
     */

    protected void addBeforeToResults(){

        properties.setProperty("AA_before", String.valueOf(getAaBefore()));
        properties.setProperty("AC_before", String.valueOf(getAcBefore()));
        properties.setProperty("AG_before", String.valueOf(getAgBefore()));
        properties.setProperty("AT_before", String.valueOf(getAtBefore()));
        properties.setProperty("CA_before", String.valueOf(getCaBefore()));
        properties.setProperty("CC_before", String.valueOf(getCcBefore()));
        properties.setProperty("CG_before", String.valueOf(getCgBefore()));
        properties.setProperty("CT_before", String.valueOf(getCtBefore()));
        properties.setProperty("GA_before", String.valueOf(getGaBefore()));
        properties.setProperty("GC_before", String.valueOf(getGcBefore()));
        properties.setProperty("GG_before", String.valueOf(getGgBefore()));
        properties.setProperty("GT_before", String.valueOf(getGtBefore()));
        properties.setProperty("TA_before", String.valueOf(getTaBefore()));
        properties.setProperty("TC_before", String.valueOf(getTcBefore()));
        properties.setProperty("TG_before", String.valueOf(getTgBefore()));
        properties.setProperty("TT_before", String.valueOf(getTtBefore()));
        properties.setProperty("Sum_Before", String.valueOf(sumOfBefore));
        properties.setProperty("Diff_Before", String.valueOf(sumDiffBefore));

    }

    /**
     * The values of frequencies of dinucleotides before SNP are added to data structure of results
     */

    protected void addBeforeFreqToResults(){

        properties.setProperty("AA_freq_before", formatter(getAaFreqBefore()));
        properties.setProperty("AC_freq_before", formatter(getAcFreqBefore()));
        properties.setProperty("AG_freq_before", formatter(getAgFreqBefore()));
        properties.setProperty("AT_freq_before", formatter(getAtFreqBefore()));
        properties.setProperty("CA_freq_before", formatter(getCaFreqBefore()));
        properties.setProperty("CC_freq_before", formatter(getCcFreqBefore()));
        properties.setProperty("CG_freq_before", formatter(getCgFreqBefore()));
        properties.setProperty("CT_freq_before", formatter(getCtFreqBefore()));
        properties.setProperty("GA_freq_before", formatter(getGaFreqBefore()));
        properties.setProperty("GC_freq_before", formatter(getGcFreqBefore()));
        properties.setProperty("GG_freq_before", formatter(getGgFreqBefore()));
        properties.setProperty("GT_freq_before", formatter(getGtFreqBefore()));
        properties.setProperty("TA_freq_before", formatter(getTaFreqBefore()));
        properties.setProperty("TC_freq_before", formatter(getTcFreqBefore()));
        properties.setProperty("TG_freq_before", formatter(getTgFreqBefore()));
        properties.setProperty("TT_freq_before", formatter(getTtFreqBefore()));

        properties.setProperty("AA,AG,TA,TG_before",String.valueOf(getTotalSNPBefore()));
        properties.setProperty("Freq_AA,AG,TA,TG_before", formatter(getTotalFreqBefore()));
        properties.setProperty("Diff_Before_Freq", formatter(doubleBeforeFreq));

    }

    /**
     * The values of frequencies of dinucleotides before SNP are computed from counters
     */

    protected void computeBefore(){

        setAaFreqBefore((double) getAaBefore() / getI());
        setAcFreqBefore((double) getAcBefore() / getI());
        setAgFreqBefore((double) getAgBefore() / getI());
        setAtFreqBefore((double) getAtBefore() / getI());
        setCaFreqBefore((double) getCaBefore() / getI());
        setCcFreqBefore((double) getCcBefore() / getI());
        setCgFreqBefore((double) getCgBefore() / getI());
        setCtFreqBefore((double) getCtBefore() / getI());
        setGaFreqBefore((double) getGaBefore() / getI());
        setGcFreqBefore((double) getGcBefore() / getI());
        setGgFreqBefore((double) getGgBefore() / getI());
        setGtFreqBefore((double) getGtBefore() / getI());
        setTaFreqBefore((double) getTaBefore() / getI());
        setTcFreqBefore((double) getTcBefore() / getI());
        setTgFreqBefore((double) getTgBefore() / getI());
        setTtFreqBefore((double) getTtBefore() / getI());

        setTotalSNPBefore(getAaBefore() + getAgBefore() + getTaBefore() + getTgBefore());
        setTotalFreqBefore((double) getTotalSNPBefore() / getI());
        sumOfBefore = getAaBefore()+getAcBefore()+getAgBefore()+getAtBefore()+
                getCaBefore()+getCcBefore()+getCgBefore()+getCtBefore()+
                getGaBefore()+getGcBefore()+getGgBefore()+getGtBefore()+
                getTaBefore()+getTcBefore()+getTgBefore()+getTtBefore();

        sumDiffBefore = getI()-sumOfBefore;
        doubleBeforeFreq = sumDiffBefore/getI();
    }

    /**
     * The values of frequencies of dinucleotides after SNP are computed from counters
     */

    protected void computeAfter(){

        setAaFreqAfter((double) getAaAfter() / getI());
        setAcFreqAfter((double) getAcAfter() / getI());
        setAgFreqAfter((double) getAgAfter() / getI());
        setAtFreqAfter((double) getAtAfter() / getI());
        setCaFreqAfter((double) getCaAfter() / getI());
        setCcFreqAfter((double) getCcAfter() / getI());
        setCgFreqAfter((double) getCgAfter() / getI());
        setCtFreqAfter((double) getCtAfter() / getI());
        setGaFreqAfter((double) getGaAfter() / getI());
        setGcFreqAfter((double) getGcAfter() / getI());
        setGgFreqAfter((double) getGgAfter() / getI());
        setGtFreqAfter((double) getGtAfter() / getI());
        setTaFreqAfter((double) getTaAfter() / getI());
        setTcFreqAfter((double) getTcAfter() / getI());
        setTgFreqAfter((double) getTgAfter() / getI());
        setTtFreqAfter((double) getTtAfter() / getI());

        setTotalSNP(getTtAfter() + getTaAfter() + getCtAfter() + getCaAfter());
        setTotalFreq((double) getTotalSNP() / getI());

        sumOfAfter = getAaAfter()+getAcAfter()+getAgAfter()+getAtAfter()+
                getCaAfter()+getCcAfter()+getCgAfter()+getCtAfter()+
                getGaAfter()+getGcAfter()+getGgAfter()+getGtAfter()+
                getTaAfter()+getTcAfter()+getTgAfter()+getTtAfter();

        sumDiffAfter = getI()-sumOfAfter;
        doubleAfterFreq = sumDiffAfter/getI();
    }

    /**
     * Method erases all variables
     */

    @Override
    public void erase() {
        setAaAfter(0);
        setAcAfter(0);
        setAgAfter(0);
        setAtAfter(0);
        setCaAfter(0);
        setCcAfter(0);
        setCgAfter(0);
        setCtAfter(0);
        setGaAfter(0);
        setGcAfter(0);
        setGgAfter(0);
        setGtAfter(0);
        setTaAfter(0);
        setTcAfter(0);
        setTgAfter(0);
        setTtAfter(0);

        setAaBefore(0);
        setAcBefore(0);
        setAgBefore(0);
        setAtBefore(0);
        setCaBefore(0);
        setCcBefore(0);
        setCgBefore(0);
        setCtBefore(0);
        setGaBefore(0);
        setGcBefore(0);
        setGgBefore(0);
        setGtBefore(0);
        setTaBefore(0);
        setTcBefore(0);
        setTgBefore(0);
        setTtBefore(0);

        setAaFreqAfter(0);
        setAcFreqAfter(0);
        setAgFreqAfter(0);
        setAtFreqAfter(0);
        setCaFreqAfter(0);
        setCcFreqAfter(0);
        setCgFreqAfter(0);
        setCtFreqAfter(0);
        setGaFreqAfter(0);
        setGcFreqAfter(0);
        setGgFreqAfter(0);
        setGtFreqAfter(0);
        setTaFreqAfter(0);
        setTcFreqAfter(0);
        setTgFreqAfter(0);
        setTtFreqAfter(0);

        setAaFreqBefore(0);
        setAcFreqBefore(0);
        setAgFreqBefore(0);
        setAtFreqBefore(0);
        setCaFreqBefore(0);
        setCcFreqBefore(0);
        setCgFreqBefore(0);
        setCtFreqBefore(0);
        setGaFreqBefore(0);
        setGcFreqBefore(0);
        setGgFreqBefore(0);
        setGtFreqBefore(0);
        setTaFreqBefore(0);
        setTcFreqBefore(0);
        setTgFreqBefore(0);
        setTtFreqBefore(0);

        setI(0);
        setTotalFreq(0);
        setTotalSNP(0);
        properties=new Properties();

    }

    /**
     * Method formats output of double type variables
     */

    @Override
    public String formatter(double d) {
        NumberFormat formatter = new DecimalFormat("#0.000");
        String forRet = formatter.format(d);
        return forRet;
    }

    /**
     * The method searches single string for dinucleotide phrases for SNP and
     * affects all counters depending on phrases found
     * @param inputString String which is checked. Must be a line
     */

    @Override
    public void searchInSingleString(String inputString) {
        //Transforming input String to lower case for purpose of quick search
        String s = inputString.toLowerCase();
        //Local variable for variation allele for lower case comparison sake
        String variationAllele = this.variationAllele.toLowerCase();
        //Before part

            if (s.contains("aa\t"+variationAllele)) {
                setAaBefore(getAaBefore() + 1);
            } else if (s.contains("ac\t"+variationAllele)) {
                setAcBefore(getAcBefore() + 1);
            } else if (s.contains("ag\t"+variationAllele)) {
                setAgBefore(getAgBefore() + 1);
            } else if (s.contains("at\t"+variationAllele)) {
                setAtBefore(getAtBefore() + 1);
            } else if (s.contains("ca\t"+variationAllele)) {
                setCaBefore(getCaBefore() + 1);
            } else if (s.contains("cc\t"+variationAllele)) {
                setCcBefore(getCcBefore() + 1);
            } else if (s.contains("cg\t"+variationAllele)) {
                setCgBefore(getCgBefore() + 1);
            } else if (s.contains("ct\t"+variationAllele)) {
                setCtBefore(getCtBefore() + 1);
            } else if (s.contains("ga\t"+variationAllele)) {
                setGaBefore(getGaBefore() + 1);
            } else if (s.contains("gc\t"+variationAllele)) {
                setGcBefore(getGcBefore() + 1);
            } else if (s.contains("gg\t"+variationAllele)) {
                setGgBefore(getGgBefore() + 1);
            } else if (s.contains("gt\t"+variationAllele)) {
                setGtBefore(getGtBefore() + 1);
            } else if (s.contains("ta\t"+variationAllele)) {
                setTaBefore(getTaBefore() + 1);
            } else if (s.contains("tc\t"+variationAllele)) {
                setTcBefore(getTcBefore() + 1);
            } else if (s.contains("tg\t"+variationAllele)) {
                setTgBefore(getTgBefore() + 1);
            } else if (s.contains("tt\t"+variationAllele)) {
                setTtBefore(getTtBefore() + 1);
            }


        //After part

            if (s.contains(variationAllele+"\taa")) {
                setAaAfter(getAaAfter()+1);
            } else if (s.contains(variationAllele+"\tac")) {
                setAcAfter(getAcAfter() + 1);
            } else if (s.contains(variationAllele+"\tag")) {
                setAgAfter(getAgAfter() + 1);
            } else if (s.contains(variationAllele+"\tat")) {
                setAtAfter(getAtAfter() + 1);
            } else if (s.contains(variationAllele+"\tca")) {
                setCaAfter(getCaAfter() + 1);
            } else if (s.contains(variationAllele+"\tcc")) {
                setCcAfter(getCcAfter() + 1);
            } else if (s.contains(variationAllele+"\tcg")) {
                setCgAfter(getCgAfter() + 1);
            } else if (s.contains(variationAllele+"\tct")) {
                setCtAfter(getCtAfter() + 1);
            } else if (s.contains(variationAllele+"\tga")) {
                setGaAfter(getGaAfter() + 1);
            } else if (s.contains(variationAllele+"\tgc")) {
                setGcAfter(getGcAfter() + 1);
            } else if (s.contains(variationAllele+"\tgg")) {
                setGgAfter(getGgAfter() + 1);
            } else if (s.contains(variationAllele+"\tgt")) {
                setGtAfter(getGtAfter() + 1);
            } else if (s.contains(variationAllele+"\tta")) {
                setTaAfter(getTaAfter() + 1);
            } else if (s.contains(variationAllele+"\ttc")) {
                setTcAfter(getTcAfter() + 1);
            } else if (s.contains(variationAllele+"\ttg")) {
                setTgAfter(getTgAfter() + 1);
            } else if (s.contains(variationAllele+"\ttt")) {
                setTtAfter(getTtAfter() + 1);
            }

        setI(getI() + 1);
    }

    /**
     * Method computes all results from counters and returns Results class
     */

    @Override
    public Results fastCompute() {

        computeAfter();
        computeBefore();

        //Creating an output set

        addAfterToResults();
        addAfterFreqToResults();
        addBeforeToResults();
        addBeforeFreqToResults();

        properties.setProperty("Total", String.valueOf(getI()));

        Results forRet = new Results(properties,variationAllele);

        return forRet;
    }

    /**
     * Getter for Variation Allele
     */

    @Override
    public void getVariationAllele(String variationAllele) {
        this.variationAllele=variationAllele;
    }
}
