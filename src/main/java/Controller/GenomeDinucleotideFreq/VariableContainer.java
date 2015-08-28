package Controller.GenomeDinucleotideFreq;

import java.util.Map;
import java.util.TreeMap;

/**
 * Abstract class for handling and processing variables
 * @author andriylazorenko
 */

public class VariableContainer {

    /**
     * Constructor creates a container of results (Map<String,Long> container)
     */

    public VariableContainer (){
        this.container.put("aa",0L);
        this.container.put("ac",0L);
        this.container.put("ag",0L);
        this.container.put("at",0L);
        this.container.put("ca",0L);
        this.container.put("cc",0L);
        this.container.put("cg",0L);
        this.container.put("ct",0L);
        this.container.put("ga",0L);
        this.container.put("gc",0L);
        this.container.put("gg",0L);
        this.container.put("gt",0L);
        this.container.put("ta",0L);
        this.container.put("tc",0L);
        this.container.put("tg",0L);
        this.container.put("tt",0L);
        this.container.put("total",0L);
    }

    /**
     * Variables
     */

    private Map <String,Long> container = new TreeMap<>();

    /**
     * Getter for container
     * @returns Map <String,Long> object
     */

    public Map<String, Long> getContainer() {
        return container;
    }

    /**
     * Counts total value of all dinucleotide occurrences
     * @param container - Map <String, Long> container to process
     * @return long value of all dinucleotide occurrences
     */

    protected void updateTotal(Map<String, Long> container){
        long total = container.get("aa")+
                container.get("ac")+
                container.get("ag")+
                container.get("at")+
                container.get("ca")+
                container.get("cc")+
                container.get("cg")+
                container.get("ct")+
                container.get("ga")+
                container.get("gc")+
                container.get("gg")+
                container.get("gt")+
                container.get("ta")+
                container.get("tc")+
                container.get("tg")+
                container.get("tt");
        container.put("total",total);
    }

}
