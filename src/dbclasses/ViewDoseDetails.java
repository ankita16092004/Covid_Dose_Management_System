/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbclasses;

import covide_dose.ViewDoseDetailsFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author ana
 */
public class ViewDoseDetails 
{
    public void getData()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddosemanagementsystem","root","root");
            Statement st =conn.createStatement(); 
            Statement st1 =conn.createStatement(); 
            String query="select * from dosedetails";
            
            ResultSet rs1=st.executeQuery(query);
            ResultSet rs2=st1.executeQuery(query);
            
            int row=0;
            while(rs1.next())
            {
                row++;
            }
            int i=0;
            String data[][]=new String[row][12];
            while(rs2.next())
            {
                String name=rs2.getString(1);
                data[i][0]=name;
                String dob=rs2.getString(2);
                data[i][1]=dob;
                String aadharno=rs2.getString(3);
                data[i][2]=aadharno;
                String gender=rs2.getString(4);
                data[i][3]=gender;
                String email=rs2.getString(5);
                data[i][4]=email;
                String mob=rs2.getString(6);
                data[i][5]=mob;
                String fddate=rs2.getString(7);
                data[i][6]=fddate;
                String fdgivenby=rs2.getString(8);
                data[i][7]=fdgivenby;
                String fvaccinename=rs2.getString(9);
                data[i][8]=fvaccinename;
                 String sddate=rs2.getString(10);
                data[i][9]=sddate;
                String sdgivenby=rs2.getString(11);
                data[i][10]=sdgivenby;
                String svaccinename=rs2.getString(12);
                data[i][11]=svaccinename;
                
                
                i++;
            }
            ViewDoseDetailsFrame.data1=data;
            st.close();
            st1.close();
            conn.close();
            
        }
        catch(Exception ex)
        {
            System.out.println("Exception in view dose details class"+ex);
        }
    }
    
}
