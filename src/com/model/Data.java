package com.model;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class Data {
	private Map<String,Set<Voters>> regionAndVotersInfo = new HashMap<String, Set<Voters>>();
	private Set<Region> regions = new HashSet<Region>();

    public Map<String, Set<Voters>> getRegionAndVotersInfo() {
        return regionAndVotersInfo;
    }

    public void setRegionAndVotersInfo(Map<String, Set<Voters>> regionAndVotersInfo) {
        this.regionAndVotersInfo = regionAndVotersInfo;
    }

    public Set<Region> getRegions() {
        return regions;
    }

    public void setRegions(Set<Region> regions) {
        this.regions = regions;
    }
        
        

}
