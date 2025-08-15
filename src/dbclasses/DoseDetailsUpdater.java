/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbclasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author ana
 */
public class DoseDetailsUpdater 
{
     public boolean updateDoseDetails(String seconddosegivenby, String aadharno)
    {
        boolean flag=true;
        
        try
        {
            
           Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddosemanagementsystem","root","root");
            Statement st =conn.createStatement(); 
           String query="Update dosedetails set sdosegivenby='"+seconddosegivenby+"' where aadhar='"+aadharno+"'";
                      
            
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            else
                flag=false;
             conn.close();
             st.close();
            
        }
        
        catch(Exception e)
        {
            System.out.println("Exception in Dose Details Updater Class is: "+e);
            flag=false;
        }
        
        
        return flag;
    }
}
