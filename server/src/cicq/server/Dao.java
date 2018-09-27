/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cicq.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author 志彬
 */
public class Dao {
         Connection ct=null;
 	 ResultSet rs=null;
         Statement st=null;
         PreparedStatement ps=null;
    public  Boolean isCorrect(String name,String password){
        try{
            System.out.println("1");
            Class.forName("com.mysql.jdbc.Driver");
             ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/qq","root","");
               st=ct.createStatement();
           String sql="select * from user where name=? and password=?";
                      
                     ps=ct.prepareStatement(sql);
                    System.out.println("11111");
                      ps.setString(1,name);
                      ps.setString(2,password);
                      rs = ps.executeQuery();
                      if(rs.next()){
                          
                       return true;
                       
                      }
                      else{
                      return false;
                      }
                     
                              
                   
                     
                      
                      
               
               
                        
                     
         }
         catch(Exception e){
             return false;
         }
           finally
 	   {
 		  try {
 			 if(rs!=null)
				{
					rs.close();
				}
                         if(st!=null)
                         {
                             st.close();
                         }
                         
				if(ct!=null)
				{
					ct.close();
				}
 				
 			} catch (Exception k){}
 	   }
         
    }
}
