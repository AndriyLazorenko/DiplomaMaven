package Controller.GenomeDinucleotideFreq;

import java.util.Map;
import java.util.TreeMap;

/**
 * Abstract class for handling and processing variables
 * @author andriylazorenko
 */

public abstract class VariableContainer {

    /**
     * Variables
     */
    
    protected long aaCounter = 0;
    protected long acCounter = 0;
    protected long agCounter = 0;
    protected long atCounter = 0;
    protected long caCounter = 0;
    protected long ccCounter = 0;
    protected long cgCounter = 0;
    protected long ctCounter = 0;
    protected long gaCounter = 0;
    protected long gcCounter = 0;
    protected long ggCounter = 0;
    protected long gtCounter = 0;
    protected long taCounter = 0;
    protected long tcCounter = 0;
    protected long tgCounter = 0;
    protected long ttCounter = 0;

    protected long total = 0;

    protected String aa = "aa";
    protected String ac = "ac";
    protected String ag = "ag";
    protected String at = "at";
    protected String ca = "ca";
    protected String cc = "cc";
    protected String cg = "cg";
    protected String ct = "ct";
    protected String ga = "ga";
    protected String gc = "gc";
    protected String gg = "gg";
    protected String gt = "gt";
    protected String ta = "ta";
    protected String tc = "tc";
    protected String tg = "tg";
    protected String tt = "tt";

    /**
     * Forms results from counters into a TreeMap.
     * @returns Map of results. Names of dinucleotides are keys, counters are values
     */

    protected Map<String,Long> formResults(){

        total  = aaCounter+
                acCounter+
                agCounter+
                atCounter+
                caCounter+
                ccCounter+
                cgCounter+
                ctCounter+
                gaCounter+
                gcCounter+
                ggCounter+
                gtCounter+
                taCounter+
                tcCounter+
                tgCounter+
                ttCounter;
        
        Map <String,Long> forRet = new TreeMap<>();
        forRet.put(aa,aaCounter);
        forRet.put(ac,acCounter);
        forRet.put(ag,agCounter);
        forRet.put(at,atCounter);
        forRet.put(ca,caCounter);
        forRet.put(cc,ccCounter);
        forRet.put(cg,cgCounter);
        forRet.put(ct,ctCounter);
        forRet.put(ga,gaCounter);
        forRet.put(gc,gcCounter);
        forRet.put(gg,ggCounter);
        forRet.put(gt,gtCounter);
        forRet.put(ta,taCounter);
        forRet.put(tc,tcCounter);
        forRet.put(tg,tgCounter);
        forRet.put(tt,ttCounter);
        forRet.put("total",total);

        return forRet;
    }
}
