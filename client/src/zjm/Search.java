/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zjm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.collections.*;

/**
 *
 * @author 志彬
 */
public class Search{
    
  Search(String cha1,String cha2,Label bq,ListView<String> lv){
      ArrayList<String> pe=new ArrayList();
       if(cha1.equals("手机查找")){
          dianhua(cha1,cha2,bq,lv,pe);
       }
       else if(cha1.equals("姓名查找")){
         xingming(cha1,cha2,bq,lv,pe);       
       }
       else if(cha1.equals("拼音查找")){
         pinyin(cha1,cha2,bq,lv,pe);
       }
       else{
         zimu(cha1,cha2,bq,lv,pe);
       }
  }
  void dianhua(String cha1,String cha2,Label bq,ListView<String> lv,ArrayList<String> pe){
        
         Connection ct=null;
 	 ResultSet rs=null;
         Statement st=null;
         try{
             Class.forName("com.mysql.jdbc.Driver");
             ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","11278");
		     st=ct.createStatement();
                    
                     rs=st.executeQuery("select mingzi,phone from people where phone LIKE'%"+cha2+"%'");
                     
                     while(rs.next()){
                     String m=rs.getString(1);
                     String p=rs.getString(2);
                    String mp=m+"("+p+")";
                     pe.add(mp);
                     
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
         if(pe.size()==0){
           bq.setText("查询不到搜索结果");
           lv.setItems(null);
         }
         else{
         ObservableList<String> item=FXCollections.observableArrayList(pe);
         lv.setItems(item);
      // lv.getSelectionModel().selectedItemProperty().addListener(o->jiemian(lv));
         lv.setOnMouseClicked(o->handle(lv));
         String ss="根据手机'"+cha2+"'查询到的结果";
         bq.setText(ss);
         }
         
         
  }
  
  void xingming(String cha1,String cha2,Label bq,ListView<String> lv,ArrayList<String> pe){
       Connection ct=null;
 	 ResultSet rs=null;
         Statement st=null;
         try{
             Class.forName("com.mysql.jdbc.Driver");
             ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","11278");
		     st=ct.createStatement();
                    
                     rs=st.executeQuery("select mingzi,phone from people where mingzi LIKE'%"+cha2+"%'");
                     while(rs.next()){
                     String m=rs.getString(1);
                     String p=rs.getString(2);
                     String mp=m+"("+p+")";
                     pe.add(mp);
                     
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
         if(pe.size()==0){
           bq.setText("查询不到搜索结果");
           lv.setItems(null);
         }
         else{
         ObservableList<String> item=FXCollections.observableArrayList(pe);
        lv.setItems(item);
       //lv.getSelectionModel().selectedItemProperty().addListener(o->jiemian(lv));
        lv.setOnMouseClicked(o->handle(lv));
         String ss="根据姓名'"+cha2+"'查询到的结果";
         bq.setText(ss);
         }
  }
  
  void pinyin(String cha1,String cha2,Label bq,ListView<String> lv,ArrayList<String> pe){
    Connection ct=null;
 	 ResultSet rs=null;
         Statement st=null;
         try{
             Class.forName("com.mysql.jdbc.Driver");
             ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","11278");
		     st=ct.createStatement();
                    
                     rs=st.executeQuery("select mingzi,phone from people where pinyin LIKE'%"+cha2+"%'");
                     while(rs.next()){
                     String m=rs.getString(1);
                     String p=rs.getString(2);
                     String mp=m+"("+p+")";
                     pe.add(mp);
                     
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
         if(pe.size()==0){
           bq.setText("查询不到搜索结果");
           
           lv.setItems(null);
         }
         else{
         ObservableList<String> item=FXCollections.observableArrayList(pe);
         lv.setItems(item);
         //lv.getSelectionModel().selectedItemProperty().addListener(o->jiemian(lv));
         lv.setOnMouseClicked(o->handle(lv));
         String ss="根据姓名拼音'"+cha2+"'查询到的结果";
         bq.setText(ss);
         }
         
         
  }
  
  void zimu(String cha1,String cha2,Label bq,ListView<String> lv,ArrayList<String> pe){
   Connection ct=null;
 	 ResultSet rs=null;
         Statement st=null;
         try{
             Class.forName("com.mysql.jdbc.Driver");
             ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","11278");
		     st=ct.createStatement();
                    
                     rs=st.executeQuery("select mingzi,phone from people where shouzi LIKE'%"+cha2+"%'");
                     while(rs.next()){
                     String m=rs.getString(1);
                     String p=rs.getString(2);
                     String mp=m+"("+p+")";
                     pe.add(mp);
                     
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
         if(pe.size()==0){
           bq.setText("查询不到搜索结果");
           lv.setItems(null);
         }
         else{
         ObservableList<String> item=FXCollections.observableArrayList(pe);
         lv.setItems(item);
      //  lv.getSelectionModel().selectedItemProperty().addListener(o->jiemian(lv));
         lv.setOnMouseClicked(o->handle(lv));
         String ss="根据姓名首字母'"+cha2+"'查询到的结果";
         bq.setText(ss);
         }
         
  }
  void jiemian(ListView<String> lv){
      
     String ss=lv.getSelectionModel().getSelectedItem();
     int flag=ss.indexOf("(");
    String s=ss.substring(0,flag);
    // Stage g=new Stage();
     Zhuye zy=new Zhuye(s);
     
    // BorderPane pane=new BorderPane();
      //Scene scene=new Scene(pane,220,380);
     //g.setScene(scene);
      //g.setTitle("666");
      // primaryStage.setX(x);
      // primaryStage.setY(y);
     // g.show();
      //Zhuye zy=new Zhuye(ss);
  }
  void handle(ListView<String> lv){
     String ss=lv.getSelectionModel().getSelectedItem();
     int flag=ss.indexOf("(");
    String s=ss.substring(0,flag);
    Zhuye zy=new Zhuye(s);
     
     
  }
  
    
}
