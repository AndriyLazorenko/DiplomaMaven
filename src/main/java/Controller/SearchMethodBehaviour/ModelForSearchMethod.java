package Controller.SearchMethodBehaviour;

import java.util.Properties;

/**
 * Class used to instantiate all the fields needed for counting occurrences of dinucleotides
 * @author andriylazorenko
 */

public class ModelForSearchMethod {

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
}
