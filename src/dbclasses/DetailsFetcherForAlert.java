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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


/**
 *
 * @author ana
 */
public class DetailsFetcherForAlert 
{
     public ArrayList getUserData()
    {

       String seconddose="none";
      // ArrayList userinfo=new ArrayList();
       ArrayList alertinfo=new ArrayList();
       String date=getDate();

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddosemanagementsystem","root","root");
            Statement st =conn.createStatement();
            String query="Select *from dosedetails where sdosegivenby='"+seconddose+"'";

            ResultSet rs1=st.executeQuery(query);
            
             while(rs1.next())
            {
                ArrayList userinfo=new ArrayList();

             String name=rs1.getString(1);
             String aadharno=rs1.getString(3);
             String mobilenumber=rs1.getString(6);
             String firstdosedate=rs1.getString(7);
             String firstvaccinename=rs1.getString(9);
            //S String seconddosedate=rs1.getString(10);
             
              userinfo.add(name);
              userinfo.add(aadharno);
              userinfo.add(mobilenumber);
              userinfo.add(firstdosedate);
              userinfo.add(firstvaccinename);
             // userinfo.add(seconddosedate);
              userinfo.add(date);
              alertinfo.add(userinfo);
              
               
             


            }
              System.out.println("arraylist"+alertinfo);
                  conn.close();
                  st.close();
                  
               
        }

        catch(Exception e)
        {
            System.out.println("Exception in generate alert Class is: "+e);

        }
        return alertinfo;
       
    }

    public String getDate()
    {
        Calendar cal=Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy ");
        String date=dateformat.format(cal.getTime());
        return date;
    }
}
