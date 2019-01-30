package com.runner;

import com.dao.VotersDao;
import com.model.Data;
import com.srvc.voteCalculate;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class AppRunnerMain {

private static Data data;
    
    public static void main(String args[]){
        
      VotersDao v = new VotersDao();
      voteCalculate  voteCalculate = new voteCalculate();
        try {
            data = v.readData();
            voteCalculate.winners(data);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AppRunnerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
