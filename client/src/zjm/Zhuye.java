/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zjm;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import javafx.scene.input.MouseButton;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import java.util.ArrayList;
import java.sql.*;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

/**
 *
 * @author 志彬
 */
public class Zhuye  {
    
    

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     * 
     */
     Image p3=new Image("tu/xm.png");
        Image p4=new Image("tu/sr.png");
        Image p5=new Image("tu/phone.png");
       Button an1=new Button("导出联系人");
       Button an2=new Button("退出");
       Button an3=new Button();
       Label bq1=new Label("姓名  ",new ImageView(p3));
       Label bq2=new Label("手机  ",new ImageView(p5));
       Label bq3=new Label("生日  ",new ImageView(p4));
       Label bq4=new Label("       电话  ");
       Label bq5=new Label("       地址  ");
       Label bq6=new Label("工作单位  ");
       Label bq8=new Label("       邮编  ");
       Label bq9=new Label("       组别  ");
       Label bq7=new Label();
       Label q1=new Label();
       Label q2=new Label();
       Label q3=new Label();
       Label q4=new Label();
       Label q5=new Label();
       Label q6=new Label();
       Label q7=new Label();
       Label q8=new Label();
       Label q9=new Label();
       GridPane pane2=new GridPane();
        BorderPane pane3=new BorderPane();
        BorderPane pane4=new BorderPane();
        BorderPane pane=new BorderPane();
         Stage primaryStage=new Stage();
           String s10=new String();
           String s1,s2,s3,s4,s5,s6,s7,s8,s9;
           String lu;
     public Zhuye(String mz){
         //String s10=new String();
   
         Connection ct=null;
 	 ResultSet rs=null;
         Statement st=null;
         PreparedStatement ps=null;
         try{
            Class.forName("com.mysql.jdbc.Driver");
             ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","11278");
            
		     st=ct.createStatement();
                     String sql="select mingzi,phone,birth,tel,dizhi,job,youbian,beizhu,zubie,tupian from people where mingzi='"+mz+"'";
                     System.out.println("1");
                       rs=st.executeQuery(sql);
				 System.out.println("1");			
                    if(rs.next()){
                    s1=rs.getString(1);
                    System.out.println(s1);
                    
                    s2=rs.getString(2);
                   
                    s3=rs.getString(3);
                    
                    s4=rs.getString(4);
                   
                    s5=rs.getString(5);
                    s6=rs.getString(6);
                     
                    s7=rs.getString(7);
                     
                    s8=rs.getString(8);
                   
                    s9=rs.getString(9);
                    lu=rs.getString(10);
                    
                   s10=s1+","+s2+","+s3+","+s4+","+s5+","+s6+","+s7+","+s8+","+s9;
                   
                    
                   System.out.println("1");
                    q1.setText(s1);
                    q2.setText(s2);
                    q3.setText(s3);
                    q4.setText(s4);
                    q5.setText(s5);
                    q6.setText(s6);
                    q7.setText(s8);
                    q8.setText(s7);
                    q9.setText(s9);
                    Image tu=new Image(lu);
                    ImageView p=new ImageView(tu);
                     an3.setGraphic(p);;
                     
                     System.out.println("1");
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
                VBox pane1=new VBox(5);
       pane1.setStyle("-fx-background-color:gray");
       pane1.setPadding(new Insets(11.5,12.5,13.5,14.5));
       pane1.setAlignment(Pos.CENTER);
       Circle circle=new Circle();
       circle.setRadius(30);
       circle.setFill(Color.WHITE);
       an3.setShape(circle);
       an3.setPrefSize(60,60);
	pane1.getChildren().add(an3);
        pane.setTop(pane1);
      
       pane2.setHgap(5);
	pane2.setVgap(4);
        pane2.add(bq1,0,0);
        pane2.add(q1,1,0);
        pane2.add(bq2,0,1);
        pane2.add(q2,1,1);
        pane2.add(bq3,0,2);
        pane2.add(q3,1,2);
        pane2.add(bq4,0,3);
        pane2.add(q4,1,3);
        pane2.add(bq5,0,4);
        pane2.add(q5,1,4);
        pane2.add(bq6,0,5);
        pane2.add(q6,1,5);
        pane2.add(bq8,0,6);
        pane2.add(q8,1,6);
        pane2.add(bq9,0,7);
       pane2.add(q9,1,7);
     // VBox v1=new VBox(5);
     // v1.getChildren().add(q7);
     // v1.getChildren().add(bq7);
       //pane3.setTop(v1);
       pane4.setTop(pane2);
       pane4.setBottom(pane3);
        pane.setCenter(pane4);
        HBox h=new HBox(100);
        h.getChildren().add(an1);
        h.getChildren().add(an2);
        pane.setBottom(h);
         
     // VBox v1=new VBox(5);
     // v1.getChildren().add(q7);
     // v1.getChildren().add(bq7);
       //pane3.setTop(v1);
       pane4.setTop(pane2);
       pane4.setBottom(pane3);
        pane.setCenter(pane4);
       
       // System.out.println(s10);
        //an1.setOnAction(e->delay(primaryStage));
       //an2.setOnAction(e->daochu(s10));
        Scene scene=new Scene(pane,220,380);
       primaryStage.setScene(scene);
       primaryStage.setTitle("666");
      // primaryStage.setX(x);
      // primaryStage.setY(y);
       primaryStage.show();
     }
     void daochu(String s10){
   
     }
     void delay(Stage g){
      g.close();
     }
    
}
