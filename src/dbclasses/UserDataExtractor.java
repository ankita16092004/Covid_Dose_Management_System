package dbclasses;

import java.sql.*;
import java.util.ArrayList;


public class UserDataExtractor {

       
       public ArrayList getUserData(String employeeid)
    {

       ArrayList userinfo=new ArrayList();

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddosemanagementsystem","root","root");
            Statement st =conn.createStatement();
            String query="Select *from registerinfo where employeeid='"+employeeid+"'";

            ResultSet rs1=st.executeQuery(query);
            
             if(rs1.next())
            {


             String name=rs1.getString(1);
             String emailid=rs1.getString(2);
             String mobno=rs1.getString(3);
             String employid=rs1.getString(4);
             String pass=rs1.getString(5);
             
              userinfo.add(name);
              userinfo.add(emailid);
              userinfo.add(mobno);
              userinfo.add(employid);
              userinfo.add(pass);
              
              //userinfo.add(rs1.getString(1));


            }

               
        }

        catch(Exception e)
        {
            System.out.println("Exception in UserDataExtractor Class is: "+e);

        }

       return userinfo;
    }

      
}


     
      