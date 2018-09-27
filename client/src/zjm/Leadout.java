/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zjm;

import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import static zjm.Jiatu.configureFileChooser;
import javafx.scene.layout.StackPane;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.scene.text.*;


/**
 *
 * @author 志彬
 */
public class Leadout {
    
   

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
   public Leadout(ArrayList<People> aa){
       ArrayList<String> data=new ArrayList<>();
       for(int i=0;i<aa.size();i++){
           String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
         String name=aa.get(i).name;
          Connection ct=null;
 	 ResultSet rs=null;
         Statement st=null;
         PreparedStatement ps=null;
         try{
            Class.forName("com.mysql.jdbc.Driver");
             ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","11278");
            
		     st=ct.createStatement();
                     String sql="select mingzi,phone,birth,tel,dizhi,job,youbian,beizhu,zubie from people where mingzi='"+name+"'";
                     
                       rs=st.executeQuery(sql);
							
                    if(rs.next()){
                    s1=rs.getString(1);
                    s2=rs.getString(2);
                    s3=rs.getString(3);
                    s4=rs.getString(4);
                    s5=rs.getString(5);
                    s6=rs.getString(6);
                     
                    s7=rs.getString(7);
                     
                    s8=rs.getString(8);
                   
                    s9=rs.getString(9);
                   s10=s1+","+s2+","+s3+","+s4+","+s5+","+s6+","+s7+","+s8+","+s9;
                  
                    data.add(s10);
                   
                    }
                    
                    
                    
               
                
         }
         catch(Exception e){
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
      CSV cs=new CSV();
      boolean flag=cs.exportCsv(new File("D:/test/ljq.csv"), data);
      if(flag){
      Stage g=new Stage();
      StackPane pane=new StackPane();
      Label bq=new Label("导出成功");
     Font f=new Font("SanSerif",20);
     bq.setFont(f);
      
      pane.getChildren().add(bq);
      Scene scene=new Scene(pane);
      g.setScene(scene);
      g.show();
      }
      else{
      System.out.println(flag);
      }
   }
    
}
