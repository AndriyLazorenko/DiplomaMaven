package Controller.SearchMethodBehaviour;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import DAO.Results;

/**
 * The composite class Both contains all variables necessary for computations as well as
 * methods responsible for counting occurrences of dinucleotides, computing frequencies and
 * other results
 * @author andriylazorenko
 */

public class Both implements SearchMethod {

    /**
     * Below are all the variables split by groups
     */

    /**
     * Declarations of counters of phrases, used AFTER variation allele
     */

    private int ttAfter = 0;
    private int taAfter = 0;
    private int tcAfter = 0;
    private int tgAfter = 0;
    private int ctAfter = 0;
    private int caAfter = 0;
    private int cgAfter = 0;
    private int ccAfter = 0;
    private int aaAfter = 0;
    private int atAfter = 0;
    private int acAfter = 0;
    private int agAfter = 0;
    private int gaAfter = 0;
    private int ggAfter = 0;
    private int gcAfter = 0;
    private int gtAfter = 0;

    /**
     * Declarations of counters of phrases, used BEFORE variation allele
     */

    private int ttBefore = 0;
    private int taBefore = 0;
    private int tcBefore = 0;
    private int tgBefore = 0;
    private int ctBefore = 0;
    private int caBefore = 0;
    private int cgBefore = 0;
    private int ccBefore = 0;
    private int aaBefore = 0;
    private int atBefore = 0;
    private int acBefore = 0;
    private int agBefore = 0;
    private int gaBefore = 0;
    private int ggBefore = 0;
    private int gcBefore = 0;
    private int gtBefore = 0;

    /**
     * Declarations of frequencies of occurrence of phrases used AFTER variation Allele
     */

    private double ttFreqAfter;
    private double taFreqAfter;
    private double tcFreqAfter;
    private double tgFreqAfter;
    private double ctFreqAfter;
    private double caFreqAfter;
    private double ccFreqAfter;
    private double cgFreqAfter;
    private double aaFreqAfter;
    private double acFreqAfter;
    private double agFreqAfter;
    private double atFreqAfter;
    private double gaFreqAfter;
    private double gcFreqAfter;
    private double ggFreqAfter;
    private double gtFreqAfter;

    /**
     * Declarations of frequencies of occurrence of phrases used BEFORE variation Allele
     */

    private double ttFreqBefore;
    private double taFreqBefore;
    private double tcFreqBefore;
    private double tgFreqBefore;
    private double ctFreqBefore;
    private double caFreqBefore;
    private double ccFreqBefore;
    private double cgFreqBefore;
    private double aaFreqBefore;
    private double acFreqBefore;
    private double agFreqBefore;
    private double atFreqBefore;
    private double gaFreqBefore;
    private double gcFreqBefore;
    private double ggFreqBefore;
    private double gtFreqBefore;

    /**
     * Declarations of various other variables
     */

    protected int sumOfAfter = 0;
    protected int sumOfBefore = 0;
    protected int sumDiffAfter = 0;
    protected int sumDiffBefore = 0;
    protected double doubleAfterFreq =0;
    protected double doubleBeforeFreq =0;
    private int i = 0;
    private int totalSNP = 0;
    private double totalFreq;
    private double totalFreqBefore;
    private int totalSNPBefore;
    protected String variationAllele;
    protected Properties properties = new Properties();

    /**
     * Getters for all the variables
     */

    public int getTtAfter() {
        return ttAfter;
    }

    public int getTaAfter() {
        return taAfter;
    }

    public int getTcAfter() {
        return tcAfter;
    }

    public int getTgAfter() {
        return tgAfter;
    }

    public int getCtAfter() {
        return ctAfter;
    }

    public int getCaAfter() {
        return caAfter;
    }

    public int getCgAfter() {
        return cgAfter;
    }

    public int getCcAfter() {
        return ccAfter;
    }

    public int getAaAfter() {
        return aaAfter;
    }

    public int getAtAfter() {
        return atAfter;
    }

    public int getAcAfter() {
        return acAfter;
    }

    public int getAgAfter() {
        return agAfter;
    }

    public int getGaAfter() {
        return gaAfter;
    }

    public int getGgAfter() {
        return ggAfter;
    }

    public int getGcAfter() {
        return gcAfter;
    }

    public int getGtAfter() {
        return gtAfter;
    }

    public int getTtBefore() {
        return ttBefore;
    }

    public int getTaBefore() {
        return taBefore;
    }

    public int getTcBefore() {
        return tcBefore;
    }

    public int getTgBefore() {
        return tgBefore;
    }

    public int getCtBefore() {
        return ctBefore;
    }

    public int getCaBefore() {
        return caBefore;
    }

    public int getCgBefore() {
        return cgBefore;
    }

    public int getCcBefore() {
        return ccBefore;
    }

    public int getAaBefore() {
        return aaBefore;
    }

    public int getAtBefore() {
        return atBefore;
    }

    public int getAcBefore() {
        return acBefore;
    }

    public int getAgBefore() {
        return agBefore;
    }

    public int getGaBefore() {
        return gaBefore;
    }

    public int getGgBefore() {
        return ggBefore;
    }

    public int getGcBefore() {
        return gcBefore;
    }

    public int getGtBefore() {
        return gtBefore;
    }

    public double getTtFreqAfter() {
        return ttFreqAfter;
    }

    public double getTaFreqAfter() {
        return taFreqAfter;
    }

    public double getTcFreqAfter() {
        return tcFreqAfter;
    }

    public double getTgFreqAfter() {
        return tgFreqAfter;
    }

    public double getCtFreqAfter() {
        return ctFreqAfter;
    }

    public double getCaFreqAfter() {
        return caFreqAfter;
    }

    public double getCcFreqAfter() {
        return ccFreqAfter;
    }

    public double getCgFreqAfter() {
        return cgFreqAfter;
    }

    public double getAaFreqAfter() {
        return aaFreqAfter;
    }

    public double getAcFreqAfter() {
        return acFreqAfter;
    }

    public double getAgFreqAfter() {
        return agFreqAfter;
    }

    public double getAtFreqAfter() {
        return atFreqAfter;
    }

    public double getGaFreqAfter() {
        return gaFreqAfter;
    }

    public double getGcFreqAfter() {
        return gcFreqAfter;
    }

    public double getGgFreqAfter() {
        return ggFreqAfter;
    }

    public double getGtFreqAfter() {
        return gtFreqAfter;
    }

    public double getTtFreqBefore() {
        return ttFreqBefore;
    }

    public double getTaFreqBefore() {
        return taFreqBefore;
    }

    public double getTcFreqBefore() {
        return tcFreqBefore;
    }

    public double getTgFreqBefore() {
        return tgFreqBefore;
    }

    public double getCtFreqBefore() {
        return ctFreqBefore;
    }

    public double getCaFreqBefore() {
        return caFreqBefore;
    }

    public double getCcFreqBefore() {
        return ccFreqBefore;
    }

    public double getCgFreqBefore() {
        return cgFreqBefore;
    }

    public double getAaFreqBefore() {
        return aaFreqBefore;
    }

    public double getAcFreqBefore() {
        return acFreqBefore;
    }

    public double getAgFreqBefore() {
        return agFreqBefore;
    }

    public double getAtFreqBefore() {
        return atFreqBefore;
    }

    public double getGaFreqBefore() {
        return gaFreqBefore;
    }

    public double getGcFreqBefore() {
        return gcFreqBefore;
    }

    public double getGgFreqBefore() {
        return ggFreqBefore;
    }

    public double getGtFreqBefore() {
        return gtFreqBefore;
    }

    public int getI() {
        return i;
    }

    public int getTotalSNP() {
        return totalSNP;
    }

    public double getTotalFreq() {
        return totalFreq;
    }

    public double getTotalFreqBefore() {
        return totalFreqBefore;
    }

    public int getTotalSNPBefore() {
        return totalSNPBefore;
    }

    /**
     * Setters for all the variables
     */

    public void setTotalSNP(int totalSNP) {
        this.totalSNP = totalSNP;
    }

    public void setTotalFreq(double totalFreq) {
        this.totalFreq = totalFreq;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setTtAfter(int ttAfter) {
        this.ttAfter = ttAfter;
    }

    public void setTaAfter(int taAfter) {
        this.taAfter = taAfter;
    }

    public void setTcAfter(int tcAfter) {
        this.tcAfter = tcAfter;
    }

    public void setTgAfter(int tgAfter) {
        this.tgAfter = tgAfter;
    }

    public void setCtAfter(int ctAfter) {
        this.ctAfter = ctAfter;
    }

    public void setCaAfter(int caAfter) {
        this.caAfter = caAfter;
    }

    public void setCgAfter(int cgAfter) {
        this.cgAfter = cgAfter;
    }

    public void setCcAfter(int ccAfter) {
        this.ccAfter = ccAfter;
    }

    public void setAaAfter(int aaAfter) {
        this.aaAfter = aaAfter;
    }

    public void setAtAfter(int atAfter) {
        this.atAfter = atAfter;
    }

    public void setAcAfter(int acAfter) {
        this.acAfter = acAfter;
    }

    public void setAgAfter(int agAfter) {
        this.agAfter = agAfter;
    }

    public void setGaAfter(int gaAfter) {
        this.gaAfter = gaAfter;
    }

    public void setGgAfter(int ggAfter) {
        this.ggAfter = ggAfter;
    }

    public void setGcAfter(int gcAfter) {
        this.gcAfter = gcAfter;
    }

    public void setGtAfter(int gtAfter) {
        this.gtAfter = gtAfter;
    }

    public void setTtBefore(int ttBefore) {
        this.ttBefore = ttBefore;
    }

    public void setTaBefore(int taBefore) {
        this.taBefore = taBefore;
    }

    public void setTcBefore(int tcBefore) {
        this.tcBefore = tcBefore;
    }

    public void setTgBefore(int tgBefore) {
        this.tgBefore = tgBefore;
    }

    public void setCtBefore(int ctBefore) {
        this.ctBefore = ctBefore;
    }

    public void setCaBefore(int caBefore) {
        this.caBefore = caBefore;
    }

    public void setCgBefore(int cgBefore) {
        this.cgBefore = cgBefore;
    }

    public void setCcBefore(int ccBefore) {
        this.ccBefore = ccBefore;
    }

    public void setAaBefore(int aaBefore) {
        this.aaBefore = aaBefore;
    }

    public void setAtBefore(int atBefore) {
        this.atBefore = atBefore;
    }

    public void setAcBefore(int acBefore) {
        this.acBefore = acBefore;
    }

    public void setAgBefore(int agBefore) {
        this.agBefore = agBefore;
    }

    public void setGaBefore(int gaBefore) {
        this.gaBefore = gaBefore;
    }

    public void setGgBefore(int ggBefore) {
        this.ggBefore = ggBefore;
    }

    public void setGcBefore(int gcBefore) {
        this.gcBefore = gcBefore;
    }

    public void setGtBefore(int gtBefore) {
        this.gtBefore = gtBefore;
    }

    public void setTtFreqAfter(double ttFreqAfter) {
        this.ttFreqAfter = ttFreqAfter;
    }

    public void setTaFreqAfter(double taFreqAfter) {
        this.taFreqAfter = taFreqAfter;
    }

    public void setTcFreqAfter(double tcFreqAfter) {
        this.tcFreqAfter = tcFreqAfter;
    }

    public void setTgFreqAfter(double tgFreqAfter) {
        this.tgFreqAfter = tgFreqAfter;
    }

    public void setCtFreqAfter(double ctFreqAfter) {
        this.ctFreqAfter = ctFreqAfter;
    }

    public void setCaFreqAfter(double caFreqAfter) {
        this.caFreqAfter = caFreqAfter;
    }

    public void setCcFreqAfter(double ccFreqAfter) {
        this.ccFreqAfter = ccFreqAfter;
    }

    public void setCgFreqAfter(double cgFreqAfter) {
        this.cgFreqAfter = cgFreqAfter;
    }

    public void setAaFreqAfter(double aaFreqAfter) {
        this.aaFreqAfter = aaFreqAfter;
    }

    public void setAcFreqAfter(double acFreqAfter) {
        this.acFreqAfter = acFreqAfter;
    }

    public void setAgFreqAfter(double agFreqAfter) {
        this.agFreqAfter = agFreqAfter;
    }

    public void setAtFreqAfter(double atFreqAfter) {
        this.atFreqAfter = atFreqAfter;
    }

    public void setGaFreqAfter(double gaFreqAfter) {
        this.gaFreqAfter = gaFreqAfter;
    }

    public void setGcFreqAfter(double gcFreqAfter) {
        this.gcFreqAfter = gcFreqAfter;
    }

    public void setGgFreqAfter(double ggFreqAfter) {
        this.ggFreqAfter = ggFreqAfter;
    }

    public void setGtFreqAfter(double gtFreqAfter) {
        this.gtFreqAfter = gtFreqAfter;
    }

    public void setTtFreqBefore(double ttFreqBefore) {
        this.ttFreqBefore = ttFreqBefore;
    }

    public void setTaFreqBefore(double taFreqBefore) {
        this.taFreqBefore = taFreqBefore;
    }

    public void setTcFreqBefore(double tcFreqBefore) {
        this.tcFreqBefore = tcFreqBefore;
    }

    public void setTgFreqBefore(double tgFreqBefore) {
        this.tgFreqBefore = tgFreqBefore;
    }

    public void setCtFreqBefore(double ctFreqBefore) {
        this.ctFreqBefore = ctFreqBefore;
    }

    public void setCaFreqBefore(double caFreqBefore) {
        this.caFreqBefore = caFreqBefore;
    }

    public void setCcFreqBefore(double ccFreqBefore) {
        this.ccFreqBefore = ccFreqBefore;
    }

    public void setCgFreqBefore(double cgFreqBefore) {
        this.cgFreqBefore = cgFreqBefore;
    }

    public void setAaFreqBefore(double aaFreqBefore) {
        this.aaFreqBefore = aaFreqBefore;
    }

    public void setAcFreqBefore(double acFreqBefore) {
        this.acFreqBefore = acFreqBefore;
    }

    public void setAgFreqBefore(double agFreqBefore) {
        this.agFreqBefore = agFreqBefore;
    }

    public void setAtFreqBefore(double atFreqBefore) {
        this.atFreqBefore = atFreqBefore;
    }

    public void setGaFreqBefore(double gaFreqBefore) {
        this.gaFreqBefore = gaFreqBefore;
    }

    public void setGcFreqBefore(double gcFreqBefore) {
        this.gcFreqBefore = gcFreqBefore;
    }

    public void setGgFreqBefore(double ggFreqBefore) {
        this.ggFreqBefore = ggFreqBefore;
    }

    public void setGtFreqBefore(double gtFreqBefore) {
        this.gtFreqBefore = gtFreqBefore;
    }

    public void setTotalSNPBefore(int totalSNPBefore) {
        this.totalSNPBefore = totalSNPBefore;
    }

    public void setTotalFreqBefore(double totalFreqBefore) {
        this.totalFreqBefore = totalFreqBefore;
    }

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
