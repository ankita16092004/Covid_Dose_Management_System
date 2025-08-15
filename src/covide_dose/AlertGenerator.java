/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covide_dose;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ana
 */
public class AlertGenerator
{
  //  public static ArrayList seconddosedatecross=new ArrayList();
    public void getAlert(ArrayList alertinfo) 
    {
        ArrayList seconddosedatecross=new ArrayList();
        
        
        
        
        for (int i = 0; i < alertinfo.size(); i++) 
        {
            ArrayList row=(ArrayList)alertinfo.get(i);
            String firstdosedate=(String)row.get(3);
            String currentdate=(String)row.get(5);
            
            try
            {
                SimpleDateFormat dateformat= new SimpleDateFormat("dd/MM/yyyy");
                Date d1=dateformat.parse(firstdosedate);
                Date d2=dateformat.parse(currentdate);
                
                long diff_in_date=d2.getTime()-d1.getTime();
                
                long difference_In_Days=(diff_in_date/(1000*60*60*24))%365;
                System.out.println("Difference Between Two Dates:"+difference_In_Days);
                
                if(difference_In_Days>30)
                {
                    seconddosedatecross.add(row);
                }
                
               
                
            }
            catch(Exception ex)
            {
                System.out.println("Exception :"+ex);
            }
            
            
        }
        String res="";
        for (int i = 0; i < seconddosedatecross.size(); i++) 
        {
            ArrayList row=(ArrayList)seconddosedatecross.get(i);
            String temp=row.toString();
            res=res+"\n\n"+temp;
        }
         OperationFrame.alertdata=res;
        System.out.println("second dose date cross details:"+res);
        
    }
}
