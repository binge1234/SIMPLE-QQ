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
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;;
import java.util.ArrayList;


/**
 *
 * @author 志彬
 */
public class Tianjia {
   
  
    TextField wbk=new TextField();
    Button an1=new Button("确定");
    Button an2=new Button("取消");
    Label bq=new Label("添加分组:");
    Label bq2=new Label();
   
    public Tianjia(ArrayList<String> ss,ArrayList<People> aa,TreeView<String> t,double x,double y){
        Stage primaryStage=new Stage();
        
       BorderPane p=new BorderPane();
      an1.setOnAction(m->ready( primaryStage,ss,aa,t));
      an2.setOnAction(m->delay( primaryStage,t));
      wbk.setOnMouseClicked(e->xiaoshi());
       HBox h1=new HBox(20);
       h1.setPadding(new Insets(7,7,7,7));
       h1.getChildren().add(bq);
       h1.getChildren().add(wbk);
       HBox h2=new HBox(50);
       h2.getChildren().add(an1);
       h2.getChildren().add(an2);
       HBox h3=new HBox();
       h3.getChildren().add(bq2);
       p.setTop(h1);
       p.setCenter(h2);
       p.setBottom(h3);
       
    
      Scene scene=new Scene(p,300,200);
       primaryStage.setScene(scene);
       primaryStage.setTitle("666");
       primaryStage.setX(x);
       primaryStage.setY(y);
       primaryStage.show();
  
    }
   
    void ready(Stage g,ArrayList<String> ss,ArrayList<People> aa,TreeView<String> t){
         int sign=1;
        String mc=wbk.getText();
        System.out.println(mc);
        if(mc.equals("")){
          bq2.setText("分组名字不能为空");
        }
        else{
            for(int i=0;i<ss.size();i++){
                if(ss.get(i).equals(mc)){
                    sign=0;
                    break;
                }
            }
            if(sign==0){
                bq2.setText("该分组已存在");
            }
            else if(sign==1){
            ss.add(mc);
            Connection ct=null;
 	 ResultSet rs=null;
         Statement st=null;
         PreparedStatement ps=null;
         try{
             Class.forName("com.mysql.jdbc.Driver");
             ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","11278");
		     st=ct.createStatement();
                      String sql=("insert into team values(?)");
                      
                     ps=ct.prepareStatement(sql);
                      ps.setString(1,mc);
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
        
    }
    }
    void delay(Stage g,TreeView<String> t){
        g.close();
    }
    void xiaoshi(){
        bq2.setText("");
    }
     

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
   
    
}
