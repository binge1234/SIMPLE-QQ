/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zjm;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
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
//import javafx.scene.layout.TitledPane;
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
import javafx.event.EventType;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.control.Tab;

/**
 *
 * @author 志彬
 */
public class Move  {
    
    

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
      ComboBox<String> cb=new ComboBox();
     public Move(ArrayList<String> ss,ArrayList<People> aa,TreeView<String> t,double x,double y,String mc,String mf){
         Stage g=new Stage();
         BorderPane p=new BorderPane();
      
       Image p1=new Image("tu/qd.png");
       Image p2=new Image("tu/qx.png");
       ImageView tu1=new ImageView(p1);
       ImageView tu2=new ImageView(p2);
       
       Button an1=new Button();
       Button an2=new Button();
       
       an1.setGraphic(new ImageView(p1));
       an2.setGraphic(new ImageView(p2));
     
       cb.getItems().addAll(ss);
       cb.setStyle("-fx-color:gray");
       cb.setValue(mf);
      // String zb=cb.getValue();
         an1.setOnAction(e->ready(g,ss,aa,t,mc,mf));
       an2.setOnAction(e->delay(g));
       HBox h2=new HBox();
       h2.getChildren().add(cb);
       HBox h1=new HBox(100);
        h1.getChildren().add(an1);
        h1.getChildren().add(an2);
        p.setTop(h2);
        p.setBottom(h1);
        Scene scene=new Scene(p,300,200);
       g.setScene(scene);
       g.setTitle("666");
       g.setX(x);
       g.setY(y);
       g.show();
        
     }
     void ready(Stage g,ArrayList<String> ss,ArrayList<People> aa,TreeView<String> t,String mc,String mf){
         String zb=cb.getValue();
           Connection ct=null;
 	 ResultSet rs=null;
         Statement st=null;
         PreparedStatement ps=null;
         for(int i=0;i<aa.size();i++){
            String name=aa.get(i).name;
            if(name.equals(mc)){
              People ren=new People(name,zb);
              aa.set(i,ren);
              break;
            }
         }
         try{
             Class.forName("com.mysql.jdbc.Driver");
             ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","11278");
		     st=ct.createStatement();
                      String sql=("update people set zubie=? where mingzi=? and zubie=?");
                      
                     ps=ct.prepareStatement(sql);
                      ps.setString(1,zb);
                      ps.setString(2,mc);
                      ps.setString(3,mf);
                      
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
         Model md4=new Model();
            TreeItem<String> Root=md4.getRoot(ss,aa);
           //TreeItem Root=getRoot(sb);
           
          t.setRoot(Root);
           
          g.close();
         
          
     }
     void delay(Stage g){
      g.close();
     }
    
}
