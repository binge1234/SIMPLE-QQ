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

/**
 *
 * @author 志彬
 */
public class Leadin {
     final Desktop desktop = Desktop.getDesktop();
    Stage g=new Stage();
    String path;
   public Leadin(ArrayList<String> ss,ArrayList<People> aa,TreeView<String> t){
     final FileChooser fileChooser = new FileChooser();
       
       configureFileChooser(fileChooser);
                File file = fileChooser.showOpenDialog(g);
                 CSV cs=new CSV();
            
                ArrayList<String> data= cs.importCsv(file);
                 if(data!=null && !data.isEmpty()){
            for(String Data : data){
               
               int a1=Data.indexOf(",");
               int a2=Data.indexOf(",",a1+1);
               int a3=Data.indexOf(",",a2+1);
               int a4=Data.indexOf(",",a3+1);
               int a5=Data.indexOf(",",a4+1);
               int a6=Data.indexOf(",",a5+1);
               int a7=Data.indexOf(",",a6+1);
               int a8=Data.indexOf(",",a7+1);
               int a9=Data.length();
               String s1=Data.substring(0,a1);
               System.out.println(s1);
               String s2=Data.substring(a1+1,a2);
               System.out.println(s2);
               String s3=Data.substring(a2+1,a3);
               System.out.println(s3);
               String s4=Data.substring(a3+1,a4);
               System.out.println(s3);
               String s5=Data.substring(a4+1,a5);
               System.out.println(s5);
               String s6=Data.substring(a5+1,a6);
               String s7=Data.substring(a6+1,a7);
               String s8=Data.substring(a7+1,a8);
               String s9=Data.substring(a8+1,a9);
               System.out.println(s1+s9);
               Change cg=new Change();
               String s10=cg.getPingYin(s1);
               String s11=cg.getPinYinHeadChar(s1);
               String s12=null;
               People ren= new People(s1,s9);
             
               aa.add(ren);
         Connection ct=null;
 	 ResultSet rs=null;
         Statement st=null;
         PreparedStatement ps=null;
         try{
             Class.forName("com.mysql.jdbc.Driver");
             ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","11278");
		     st=ct.createStatement();
                      String sql=("insert into people values(?,?,?,?,?,?,?,?,?,?,?,?)");
                      
                     ps=ct.prepareStatement(sql);
                      ps.setString(1,s1);
                      ps.setString(2,s2);
                      ps.setString(3,s3);
                      ps.setString(4,s4);
                      ps.setString(5,s5);
                      ps.setString(6,s6);
                      ps.setString(7,s7);
                      ps.setString(8,s8);
                      ps.setString(9,s9);
                      ps.setString(10,s10);
                      ps.setString(11,s11);
                      ps.setString(12,s12);
                      ps.executeUpdate();
                      System.out.println("1");
                     
                    
               
                
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
             Model md4=new Model();
            TreeItem<String> Root=md4.getRoot(ss,aa);
           //TreeItem Root=getRoot(sb);
           
          t.setRoot(Root);
            
        }
                 
                
                
               
                
   }
    static void configureFileChooser(
        final FileChooser fileChooser) {      
            fileChooser.setTitle("View Pictures");
            fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
            );                 
            fileChooser.getExtensionFilters().addAll(
               // new FileChooser.ExtensionFilter("All Images", "*.*"),
                //new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("CSV", "*.csv")
            );
    }
 
     private void openFile(File file) {
        EventQueue.invokeLater(() -> {
            try {
                desktop.open(file);
              
            } catch (IOException ex) {
                Logger.getLogger(Jiatu.
                        class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        });
    }
   

    
}
