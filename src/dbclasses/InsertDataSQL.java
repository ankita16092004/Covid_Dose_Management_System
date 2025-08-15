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
public class InsertDataSQL 
{
    public boolean getInsert(String name, String emailid, String mobno, String empid, String pass)
    {
        boolean flag=false;
    try
    {
       Class.forName("com.mysql.jdbc.Driver").newInstance();
       Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddosemanagementsystem","root","root");
       Statement st =conn.createStatement();
       String query="insert into registerinfo values('"+name+"','"+emailid+"','"+mobno+"','"+empid+"','"+pass+"')";
       System .out.println("Query is:"+query);
        int x=st.executeUpdate(query);
        if(x>0)
            flag =true;
        else
            flag=false;
        conn.close();
        st.close();
        
       
    }
    catch(Exception ex)
    {
        System.out.println("Exceptoin is"+ex);
    }
    
    return flag;
    }
    
}

