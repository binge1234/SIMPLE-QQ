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

/**
 *
 * @author 志彬
 */
public class Shanchu  {
    Image a=new Image("tu/chacha.png");
    ImageView tu=new ImageView(a);
    Label bq=new Label();
    Button an1=new Button("确定");
    Button an2=new Button("取消");
     int flag;
    public Shanchu(ArrayList<String> ss,ArrayList<People> aa,TreeView<String> t,double x,double y,String mz){
        Stage primaryStage=new Stage();
        String ss1="删除该组会将该组的联系人\n"+"全部移至默认分组中。确认删除该组吗";
        bq.setText(ss1);
       
        for(int j=0;j<ss.size();j++){
            if(ss.get(j).equals(mz)){
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
    
    
     void ready(Stage g,ArrayList<String> s,ArrayList<People> aa,TreeView<String> t,String ss,int a){
         s.remove(a);
           for(int i=0;i<aa.size();i++){
             String group=aa.get(i).group;
             String name=aa.get(i).name;
             if(group.equals(ss)){
                 String Group="好友";
              int flag=i;
              People ren=new People(name,Group);
              aa.set(i,ren);
             }
             
         }
         
         Connection ct=null;
 	 ResultSet rs=null;
         Statement st=null;
         PreparedStatement ps=null;
         
         try{
            Class.forName("com.mysql.jdbc.Driver");
             ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","11278");
		     st=ct.createStatement();
                      ps=ct.prepareStatement("delete from team where name=?");
					  ps.setString(1,ss);
					  ps.executeUpdate();		
                    
                     ps=ct.prepareStatement("update people set zubie='好友' where zubie=?");
                     
                     ps.setString(1,ss);
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
            TreeItem<String> Root=md2.getRoot(s,aa);
           //TreeItem Root=getRoot(sb);
           
          t.setRoot(Root);
           
          g.close();
     }
     void delay(Stage g){
         g.close();
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
