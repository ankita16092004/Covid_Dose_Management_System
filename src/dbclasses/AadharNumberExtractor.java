/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbclasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ana
 */
public class AadharNumberExtractor 
{
    
       public ArrayList getAadharno()
    {

       ArrayList Aadharno=new ArrayList();

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddosemanagementsystem","root","root");
            Statement st =conn.createStatement();
            String query="Select *from dosedetails";

            ResultSet rs1=st.executeQuery(query);
            
             while(rs1.next())
            {


             String aadhar=rs1.getString(3);
             Aadharno.add(aadhar);
              //userinfo.add(rs1.getString(1));


            }
              st.close();
              conn.close();
               
        }

        catch(Exception e)
        {
            System.out.println("Exception in AadharNumberExtractor Class is: "+e);

        }

       return Aadharno;
    }

      
}
