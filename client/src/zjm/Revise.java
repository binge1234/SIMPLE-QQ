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

/**
 *
 * @author 志彬
 */
public class Revise {
  Image p1=new Image("tu/tj.png");
        Image p2=new Image("tu/qx.png");
        Image p3=new Image("tu/xm.png");
        Image p4=new Image("tu/sr.png");
        Image p5=new Image("tu/phone.png");
         Button an1=new Button();
          Button an2=new Button();
          Button an3=new Button();
          
          ImageView pic=new ImageView();
           Label bq1=new Label("姓名",new ImageView(p3));
       Label bq2=new Label("手机",new ImageView(p5));
       Label bq3=new Label("生日",new ImageView(p4));
       Label bq4=new Label("   电话");
       Label bq5=new Label("   地址");
       Label bq6=new Label("工作单位");
       Label bq8=new Label("   邮编");
       Label bq9=new Label("   组别");
       Label bq7=new Label();
       TextField wbk1=new TextField();
       TextField wbk2=new TextField();
       TextField wbk3=new TextField();
       TextField wbk4=new TextField();
       TextField wbk5=new TextField();
       TextField wbk6=new TextField();
       TextField wbk7=new TextField();
       TextField wbk8=new TextField();
        GridPane pane2=new GridPane();
        BorderPane pane3=new BorderPane();
        BorderPane pane4=new BorderPane();
        BorderPane pane=new BorderPane();
        ComboBox<String> cb=new ComboBox();
        int flag;
        String lu;
        public Revise(ArrayList<String> ss,ArrayList<People> aa,TreeView<String> t,double x,double y,String mz){
            String s1,s2,s3,s4,s5,s6,s7,s8,s9,tu;
            for(int j=0;j<aa.size();j++){
            if(aa.get(j).name.equals(mz)){
                flag=j;
                break;
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
                     String sql="select mingzi,phone,birth,tel,dizhi,job,youbian,beizhu,zubie,tupian from people where mingzi='"+mz+"'";
                     
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
                    tu=rs.getString(10);
                    wbk1.setText(s1);
                    wbk2.setText(s2);
                    wbk3.setText(s3);
                    wbk4.setText(s4);
                    wbk5.setText(s5);
                    wbk6.setText(s6);
                    wbk7.setText(s8);
                    wbk8.setText(s7);
                    cb.setValue(s9);
                    Image im=new Image(tu);
                    ImageView p=new ImageView(im);
                    an3.setGraphic(p);
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
         Stage primaryStage=new Stage();
        cb.getItems().addAll(ss);
           
       an1.setGraphic(new ImageView(p1));
       an2.setGraphic(new ImageView(p2));
       an1.setOnAction(m->ready(primaryStage,ss,aa,t,mz,flag));
       an2.setOnAction(m->delay(primaryStage));
       BorderPane p=new BorderPane();
        wbk1.setOnMouseClicked(e->xiaoshi());
       
       wbk2.setOnMouseClicked(e->xiaoshi());
       
       wbk7.setPromptText("备注");

       VBox pane1=new VBox(5);
       pane1.setStyle("-fx-background-color:gray");
       pane1.setPadding(new Insets(11.5,12.5,13.5,14.5));
       pane1.setAlignment(Pos.CENTER);
       Circle circle=new Circle();
       circle.setRadius(30);
       circle.setFill(Color.WHITE);
       an3.setShape(circle);
       an3.setPrefSize(60,60);
       an3.setOnMouseClicked(k->gaitu());
	pane1.getChildren().add(an3);
        pane.setTop(pane1);
      
       pane2.setHgap(5);
	pane2.setVgap(4);
        pane2.add(bq1,0,0);
        pane2.add(wbk1,1,0);
        pane2.add(bq2,0,1);
        pane2.add(wbk2,1,1);
        pane2.add(bq3,0,2);
        pane2.add(wbk3,1,2);
        pane2.add(bq4,0,3);
        pane2.add(wbk4,1,3);
        pane2.add(bq5,0,4);
        pane2.add(wbk5,1,4);
        pane2.add(bq6,0,5);
        pane2.add(wbk6,1,5);
        pane2.add(bq8,0,6);
        pane2.add(wbk8,1,6);
        pane2.add(bq9,0,7);
       pane2.add(cb,1,7);
       VBox v1=new VBox(5);
       v1.getChildren().add(wbk7);
       v1.getChildren().add(bq7);
       pane3.setTop(v1);
       pane4.setTop(pane2);
       pane4.setBottom(pane3);
        pane.setCenter(pane4);
        HBox h=new HBox(100);
        h.getChildren().add(an1);
        h.getChildren().add(an2);
        pane.setBottom(h);
        
        Scene scene=new Scene(pane,220,380);
       primaryStage.setScene(scene);
       primaryStage.setTitle("666");
      // primaryStage.setX(x);
      // primaryStage.setY(y);
       primaryStage.show();
        
            
        }
        void ready(Stage g,ArrayList<String> ss,ArrayList<People> aa,TreeView<String> tree,String mz,int flag){
        String s1=wbk1.getText();
        String s2=wbk2.getText();
        String s3=wbk3.getText();
        String s4=wbk4.getText();
        String s5=wbk5.getText();
        String s6=wbk6.getText();
        String s7=wbk7.getText();
        String s8=wbk8.getText();
        String s9=cb.getValue();
        Change cg=new Change();
        String s10=cg.getPingYin(s1);
        String s11=cg.getPinYinHeadChar(s1);
       
        if(s1.equals("")||s2.equals("")){
        bq7.setText("姓名和手机号码必填");
        //bq7.setColor("-fx-color:red");
        //bq7.setTextFill(Color.web("#00646"));
        
        
        }
        else{
            int sign=1;
                for(int i=0;i<aa.size();i++){
                  String mc1=aa.get(i).name;
                  if(mc1.equals(s1)&&!mc1.equals(mz)){
                      sign=0;
                      break;
                  }
                }
                if(sign==0){
                    bq7.setText("该联系人已存在");
                }
                else{
                    People people=new People(s1,s9);
                    aa.set(flag,people);
                    Connection ct=null;
 	 ResultSet rs=null;
         Statement st=null;
         PreparedStatement ps=null;
         try{
             Class.forName("com.mysql.jdbc.Driver");
             ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","11278");
		     st=ct.createStatement();
                      String sql=("update people set mingzi=?,phone=?,birth=?,tel=?,dizhi=?,job=?,youbian=?,beizhu=?,zubie=?,pinyin=?,shouzi=? where mingzi=?");
                      
                     ps=ct.prepareStatement(sql);
                    // System.out.println("1");
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
                      //ps.setString(12,lu);
                              
                      ps.setString(12,mz);
                      ps.executeUpdate();
                    //  System.out.println("1");
                   
                    
               
                
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
           
          tree.setRoot(Root);
           
          g.close();
                }
                }
        }
        
        void delay(Stage g){
        g.close();
        }
        
        void xiaoshi(){
          bq7.setText("");
        }
        void gaitu(){
         Jiatu jt=new Jiatu();
       lu=jt.path;
       int flag1=lu.lastIndexOf("\\");
       int flag2=lu.length();
      // System.out.println(flag1);
       
       String lu1=lu.substring(flag1+1,flag2);
        lu="tu/"+lu1;
      
               
       Image tu=new Image(lu);
       ImageView p=new ImageView(tu);
       an3.setGraphic(p);
        }
  

    
   
    
}
