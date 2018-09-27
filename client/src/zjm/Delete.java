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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author 志彬
 */
public class Delete {
    
   Image a=new Image("tu/chacha.png");
    ImageView tu=new ImageView(a);
    Label bq=new Label();
    Button an1=new Button("确定");
    Button an2=new Button("取消");
     int flag;
      public Delete(ArrayList<String> ss,ArrayList<People> aa,TreeView<String> t,double x,double y,String mz){
     Stage primaryStage=new Stage();
        String ss1="确认删除该联系人吗?";
        bq.setText(ss1);
       
        for(int j=0;j<aa.size();j++){
            if(aa.get(j).name.equals(mz)){
              flag=j;
              break;
            }
        }
       BorderPane p=new BorderPane();
       HBox h1=new HBox(20);
       h1.getChildren().add(tu);
       h1.getChildren().add(bq);
       HBox h2=new HBox(50);
       h2.getChildren().add(an1);
       h2.getChildren().add(an2);
      an1.setOnAction(m->ready( primaryStage,ss,aa,t,mz,flag));
      an2.setOnAction(m->delay( primaryStage));
       p.setTop(h1);
       p.setCenter(h2);
       
      Scene scene=new Scene(p,300,200);
       primaryStage.setScene(scene);
       primaryStage.setTitle("666");
       primaryStage.setX(x);
       primaryStage.setY(y);
       primaryStage.show();
     }
      void ready(Stage g,ArrayList<String> ss,ArrayList<People> aa,TreeView<String> t,String mz,int flag){
           aa.remove(aa.get(flag));
         Connection ct=null;
 	 ResultSet rs=null;
         Statement st=null;
         PreparedStatement ps=null;
         try{
            Class.forName("com.mysql.jdbc.Driver");
             ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","11278");
		     st=ct.createStatement();
                      ps=ct.prepareStatement("delete from people where mingzi=?");
					  ps.setString(1,mz);
					  ps.executeUpdate();		
                    
               
                
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
            Model md2=new Model();
            TreeItem<String> Root=md2.getRoot(ss,aa);
           //TreeItem Root=getRoot(sb);
           
          t.setRoot(Root);
           
          g.close();
      }
      
      void delay(Stage g){
          g.close();
      }
     }
    

