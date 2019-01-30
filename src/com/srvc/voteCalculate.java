package com.srvc;
import com.model.Data;
import com.model.Region;
import com.model.Voters;
import java.util.Map;
import java.util.Set;

public class voteCalculate {
	 private Map<String,Set<Voters>> regionAndVotersInfo;
	    private Set<Region> regions;
	    
	    
	    public void winners(Data d){
	    
	        regionAndVotersInfo = d.getRegionAndVotersInfo();
	        regions = d.getRegions();
	        int CHIEF_SCORE = 0;
	        char CHIEF = ' ';
	        
	        
	        for (Region rgn : regions){
	            
	        Set<Voters> allVoters = regionAndVotersInfo.get(rgn.getRgnName());   
	        
	        if(allVoters != null){
	        int regionOfficerScore = 0;
	        char regionOfficer = ' ';
	        int invalidVote =0;
	        //int chiefOfficerScore = 0;
	        //char chiefOfficer =' ';
	            
	           //System.out.println("\n\n*******All voters for region : "+ rgn.getRgnName() +" " + allVoters + "********");
	           char[] contestnts = rgn.getContestants().toCharArray();
	           
	           for(char contestant : contestnts){
	               int score = 0;
	                    for(Voters voter : allVoters){
	                        //System.out.println("voter ID : " + voter.getVid());
	                        //char[] preferences = voter.getvPreference().toCharArray();
	                        
	                        if(voter.getvPreference().length() >  3 || voter.getvPreference().length() < 0 ){
	                            
	                            invalidVote++;
	                            
	                        }else if(voter.getvPreference().indexOf(contestant) <= 2){
	                            //System.out.println("score1 : " + score);
	                                 score = score + (3- (voter.getvPreference().indexOf(contestant)));
	                
	                        }
	                    }
	       
	                    System.out.println("contestant : " + contestant + "score : " + score);
	                if(score > regionOfficerScore){    
	                   regionOfficerScore = score;
	                   regionOfficer = contestant;
	                }
	               
	           }
	           
	           System.out.println("\n Regional Officer of the region : " + rgn.getRgnName() + " is " + regionOfficer );
	         //  System.out.println(" 2nd High of the region : " + rgn.getRgnName() + " is " + regionOfficer );
	           System.out.println("invalid votes for region " + rgn.getRgnName() +" : " + invalidVote);
	           
	           if(CHIEF_SCORE < regionOfficerScore){
	               CHIEF_SCORE = regionOfficerScore;
	               CHIEF = regionOfficer;
	           }
	        }else{
	            System.out.println("\n No voters for region : " + rgn.getRgnName());
	        }
	        }
	        System.out.println("Chief of all the contestant including all regions is : " + CHIEF + " with having score " + CHIEF_SCORE ); 
	    }
}
