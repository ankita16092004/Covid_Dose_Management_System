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
public class DoseDetailsExtractor
{
      public ArrayList getDoseDetails(String aadharno)
    {

       ArrayList DoseD=new ArrayList();

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddosemanagementsystem","root","root");
            Statement st =conn.createStatement();
            String query="Select *from dosedetails where aadhar='"+aadharno+"'";

            ResultSet rs1=st.executeQuery(query);
            
             if(rs1.next())
            {

                String name = rs1.getString(1);
                String dob = rs1.getString(2);
                String aadhar = rs1.getString(3);
                String gender = rs1.getString(4);
                String email = rs1.getString(5);
                String mobileno = rs1.getString(6);
                String firstdosedate = rs1.getString(7);
                String firstdosegivenby = rs1.getString(8);
                String firstvaccinename = rs1.getString(9);
                String seconddosedate = rs1.getString(10);
                String seconddosegivenby = rs1.getString(11);
                String secondvaccinename = rs1.getString(12);
                //userinfo.add(rs1.getString(1));
           
                DoseD.add(name);
                DoseD.add(dob);
                DoseD.add(aadhar);
                DoseD.add(gender);
                DoseD.add(email);
                DoseD.add(mobileno);
                DoseD.add(firstdosedate);
                DoseD.add(firstdosegivenby);
                DoseD.add(firstvaccinename);
                DoseD.add(seconddosedate);
                DoseD.add(seconddosegivenby);
                DoseD.add(secondvaccinename);

                


            }
              st.close();
              conn.close();
               
        }

        catch(Exception e)
        {
            System.out.println("Exception in Dose Details Extractor Class is: "+e);

        }

       return DoseD;
    }
}
