
package dbclasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class UserDBUpdater {
    
     public boolean updateUserinfo(String name, String emailid, String mobno, String empid, String pass)
    {
        boolean flag=true;
        
        try
        {
            
           Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddosemanagementsystem","root","root");
            Statement st =conn.createStatement(); 
           String query="Update registerinfo set Name='"+name+"',emailid='"+emailid+"',mobileno='"+mobno+"',password='"+pass+"' where employeeid='"+empid+"'";
                      
            
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
            System.out.println("Exception in AWSUserDBUpdater Class is: "+e);
            flag=false;
        }
        
        
        return flag;
    }
    
    
}
