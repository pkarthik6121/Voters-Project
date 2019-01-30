package com.dao;
import com.model.Data;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.model.Region;
import com.model.Voters;
import java.util.ArrayList;
import java.util.List;
public class VotersDao {
	private Map<String,Set<Voters>> regionAndVotersInfo = new HashMap<String, Set<Voters>>();
	private Set<Region> regions = new HashSet<Region>();
        private Set<Voters> voters = new HashSet<Voters>();
        
        private List<String> regionNames = new ArrayList<String>();
	
	public Data readData() throws FileNotFoundException  {
            
		String temp;
		Data data = new Data();
                
		BufferedReader rd = new BufferedReader(new FileReader("C:\\Users\\pkart\\Desktop\\data.txt"));
		String regn = "";
		try {
			while((temp = rd.readLine()) != null) {
				if(temp.equals("&&")){
                                        System.out.println("end of file");	
                                
                                }
                                else if(temp.contains("//")) {
                                    voters.clear();
					//System.out.println("\n separators - // ");		
				}else if(temp.contains("/")) {   
					Region r = new Region();
                                        
                                        //System.out.println("temp.indexOf(\"/\") : " + temp.indexOf("/"));
                                        r.setRgnName(temp.substring(0, temp.indexOf("/")));
                                      //  System.out.println("temp.indexOf(\"/\")+1 " + (temp.indexOf("/")+1));	
                                        r.setContestants(temp.substring((temp.indexOf("/")+1)));
                                       // System.out.println("\n Region : " + r.getRgnName() + "\n\n");
                                        regionNames.add(temp.substring(0, temp.indexOf("/")));
                                       // System.out.println("region : " + r);
					regions.add(r);		
				}else if(regionNames.contains(temp)) {
					regn = temp;
				}else if(!temp.isEmpty()){
                                    Voters v = new Voters();
                                   
                                    v.setVid(Integer.parseInt(temp.substring(0, temp.indexOf(" "))));
                                    v.setvPreference(temp.substring(temp.indexOf(" ")+1));
                                    voters.add(v);
                                  
                                    regionAndVotersInfo.put(regn,new HashSet<Voters>(voters));
                                    
                                }
				
			}	
                        
                        data.setRegions(regions);
                        data.setRegionAndVotersInfo(regionAndVotersInfo);
                       
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
		
	}
	
}
