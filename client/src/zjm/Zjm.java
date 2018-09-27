
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
public class Zjm extends Application {
    BorderPane pane=new BorderPane();
    BorderPane pane1=new BorderPane();
    Label bq1=new Label();
    Label bq2=new Label();
    TextField wbk=new TextField();
    ImageView tp1=new ImageView();
    ImageView tp2=new ImageView();
    //Button an1=new Button();
    //Button an2=new Button();
    Node rootIcon;
    TreeItem<String> Root=new TreeItem<>();
     //Image d;
    ContextMenu cm1=new ContextMenu();
      ContextMenu cm2 = new ContextMenu();
      ContextMenu cm3=new ContextMenu();
          MenuItem cmItem1 = new MenuItem("添加分组");
          MenuItem cmItem2=new MenuItem("删除分组");
          MenuItem cmItem3=new MenuItem("重命名分组");
          MenuItem cmItem4=new MenuItem("添加联系人");
          MenuItem cmItem5=new MenuItem("导入联系人");
          MenuItem cmItem6=new MenuItem("导出联系人");
          MenuItem cmitem2=new MenuItem("删除联系人");
          MenuItem cmitem3=new MenuItem("移动联系人至");
          MenuItem cmitem4=new MenuItem("修改联系人");
          MenuItem  mi1=new MenuItem("修改密码");
          MenuItem mi2=new MenuItem("修改个人信息");
         // Button an1=new Button();
         // Button an2=new Button();
      //StackPane root = new StackPane();
       Tooltip tooltip = new Tooltip();
      TreeView<String> tree = new TreeView<> ();
      
    @Override
    public void start(Stage primaryStage) {
        
       Pane s1=new Pane();
        Pane s2=new Pane();
        Pane s3=new Pane();
      Pane s4=new Pane();
        Pane s5=new Pane();
        cm1.getItems().add(cmItem1);
       cm1.getItems().add(cmItem2);
       cm1.getItems().add(cmItem3);
       cm1.getItems().add(cmItem4);
       cm1.getItems().add(cmItem5);
       cm1.getItems().add(cmItem6);
       //cm2.getItems().add(cmitem1);
       cm2.getItems().add(cmitem2);
       cm2.getItems().add(cmitem3);    
      cm2.getItems().add(cmitem4); 
       cm3.getItems().add(mi1);
       cm3.getItems().add(mi2);
      Image pic1=new Image("tu/qq.png");
      Image pic2=new Image("tu/an.png");
       bq1=new Label("  用户名");
       bq2=new Label("  备注");
      // an1=new Button("修改密码");
      // an2=new Button("修改个人信息");
       tooltip.setText("图片\n"+"真实姓名\n"+"电话\n"+"住址");
      tp1.setImage(pic1);
      tp1.setOnMouseClicked(e-> {
    if (e.getButton() == MouseButton.SECONDARY)
       cm3.show(tp1, e.getScreenX(), e.getScreenY());
});
       Tooltip.install(tp1,tooltip);
      // pane1.setLeft(s1);
      // pane1.setRight(s2);
      //pane.setCenter(s3);
      // pane.setTop(pane1);
      // pane.setCenter(s4);
      // pane.setBottom(s5);
       s1.getChildren().addAll(tp1);
       pane1.setLeft(s1);
       VBox v=new VBox();
       VBox v1=new VBox();
      // v.setStyle("-fx-background-color:red");
       v.setPadding(new Insets(7,7,7,7));
       v.getChildren().add(bq1);
       v.getChildren().add(bq2);
       pane1.setCenter(v);
      // s2.getChildren().add(an1);
     //  v1.getChildren().add(an1);
      // v1.getChildren().add(an2);
       pane1.setRight(v1);
       pane.setTop(pane1);
     
       ComboBox<String> c=new ComboBox<>();
       c.getItems().addAll("手机查找","姓名查找","首字母查找","拼音查找");
       c.setValue("手机查找");
       
       wbk.setPromptText("请输入相应内容来查找");
       String cha1=c.getValue();
        Label la=new Label();
      ListView<String> lv=new ListView<>();
      // Image pic2 = new Image(getClass().getResourceAsStream("tu/an.png"));
      Button an3=new Button();
       an3.setGraphic(new ImageView(pic2));
       an3.setOnAction(e1->find(c,la,lv,wbk));
      HBox h=new HBox();
      BorderPane bp=new BorderPane();
     h.getChildren().add(c);
       h.getChildren().add(wbk);
      h.getChildren().add(an3);
      bp.setTop( h);
      VBox hh=new VBox(20);
      hh.getChildren().add(la);
        hh.getChildren().add(lv);
        bp.setBottom(hh);
     
      
     
      
       
      
       ArrayList<String> ss=new ArrayList<>();
       ArrayList<People> aa=new ArrayList<>();
        Connection ct=null;
 	 ResultSet rs=null;
         Statement st=null;
         try{
             Class.forName("com.mysql.jdbc.Driver");
             ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","11278");
		     st=ct.createStatement();
                     rs=st.executeQuery("select *from team");
                      
               
                     while(rs.next()){
                         String u=rs.getString(1);
                        ss.add(u);
                        
         }
                     rs=st.executeQuery("select *from people");
                     while(rs.next()){
                         String n=rs.getString(1);
                         String z=rs.getString(9);
                         People p=new People(n,z);
                         aa.add(p);
                        
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
         
       Model md1=new Model();
       Root=md1.getRoot(ss,aa);
        tree.setRoot(Root);
         VBox v3=new VBox();
    v3.getChildren().add(tree);
   // pane.setBottom(v3);
     TabPane tpane1=new TabPane();
      TabPane tpane2=new TabPane();
      Tab tb1=new Tab(" 所 有 联 系 人 ");
      Tab tb2=new Tab("搜 索 联 系 人 ");
      Tab tb3=new Tab("个 人 备 忘 录");
      Pane pp=new Pane();
      tb1.setContent(v3);
      tb2.setContent(bp);
      tb3.setContent(pp);
      tpane1.getTabs().add(tb1);
       tpane1.getTabs().add(tb2);
       tpane1.getTabs().add(tb3);
       pane.setBottom(tpane1);
       tb1.closableProperty().set(false);
      tb2.closableProperty().set(false);
       tb3.closableProperty().set(false);
tree.setOnMouseClicked(new EventHandler<MouseEvent>(){
   
        @Override
        public void handle(MouseEvent e){
             TreeItem<String> b=tree.getSelectionModel().getSelectedItem();
           TreeItem<String> b1=b.getParent();
          String c=b1.getValue();
    if(e.getClickCount()==1){
       
        if(e.getButton()==MouseButton.SECONDARY)
        {String mz=b.getValue();
             double x=e.getScreenX();
             double y=e.getScreenY();
        if(c.equals("所有分组")){
           // cm1.hide();
            // cm2.show(pane,e.getScreenX(),e.getScreenY());
           
            cm2.hide();
      cm1.show(pane,x,y);
         
             cmItem1.setOnAction(k->gongneng1("添加",ss,aa,tree,x,y,mz));
             cmItem2.setOnAction(k->gongneng1("删除",ss,aa,tree,x,y,mz));
             cmItem3.setOnAction(k->gongneng1("修改",ss,aa,tree,x,y,mz));
             cmItem4.setOnAction(k->gongneng1("新增",ss,aa,tree,x,y,mz));
             cmItem5.setOnAction(k->gongneng1("导入",ss,aa,tree,x,y,mz));
             cmItem6.setOnAction(k->gongneng1("导出",ss,aa,tree,x,y,mz));
             //cmitem1.setOnAction(m->gongneng2("添加",ss,aa,tree,x,y,mc));
            // cmitem2.setOnAction(m->gongneng2("删除",ss,aa,tree,x,y,mc));
             //cmitem3.setOnAction(m->gongneng2("移动",ss,aa,tree,x,y,mc));
            // cmitem4.setOnAction(m->gongneng2("修改",ss,aa,tree,x,y,mc));
        }
        
            //cm2.hide()
        else {
             String mf=b1.getValue();
           cm1.hide();
           cm2.show(pane,x,y);
           cmitem2.setOnAction(k->gongneng2("删除",ss,aa,tree,x,y,mz,mf));
             cmitem3.setOnAction(k->gongneng2("移动",ss,aa,tree,x,y,mz,mf));
             cmitem4.setOnAction(k->gongneng2("修改",ss,aa,tree,x,y,mz,mf));
        }  
            
             
        
        }
        if(e.getButton()==MouseButton.PRIMARY){
            
            cm2.hide();
            cm1.hide();
        }
    }
    if(e.getClickCount()==2){
        String mz=b.getValue();
        cm1.hide();
        cm2.hide();
        if(e.getButton()==MouseButton.PRIMARY){
            if(!c.equals("所有分组")){
             // b.addEventHandler(l->zhu());
                Zhuye zy=new Zhuye(mz);
            }
        //if(){
            //cm2.hide();
            //cm1.hide();
       // }
        }
    }
}
    });

    
    
       //pane.setCenter(s4);
      // pane.setBottom(s5);
       // wbk
       Scene scene=new Scene(pane,291,400);
       primaryStage.setScene(scene);
       primaryStage.setTitle("666");
       primaryStage.show();
       //System.out.println(s.getX());
              
    }
    void gongneng1(String s,ArrayList<String> ss,ArrayList<People> aa,TreeView<String> t,double x,double y ,String mz){
        if(s.equals("添加")){
            Tianjia tj=new Tianjia(ss,aa,tree,x,y);
          
           // st.setX(x);
            //st.setY(y);
           //System.out.println(tj.sb);
          // Root=getRoot(tj.sb);
            
           
          // t.setRoot(Root);
        }
        else if(s.equals("修改")){
            Xiugai xg=new Xiugai(ss,aa,tree,x,y,mz);
           
            
        }
        else if(s.equals("删除")){
            Shanchu sc=new Shanchu(ss,aa,tree,x,y,mz);
        }
        else if(s.equals("新增")){
            Xinzeng xz=new Xinzeng(ss,aa,tree);
        }
        else if(s.equals("导入")){
         Leadin li=new Leadin( ss,aa,t);
        }
        else if(s.equals("导出")){
           Leadout lo=new Leadout(aa);
        }
    }
    void gongneng2(String s,ArrayList<String> ss,ArrayList<People> aa,TreeView<String> t,double x,double y,String mc,String mf){
        if(s.equals("删除")){
             
          Delete de=new Delete(ss,aa,tree,x,y,mc);
            //Zhuye zy=new Zhuye(mc);
        }
        else if(s.equals("修改")){
           
          Revise re=new Revise(ss,aa,tree,x,y,mc);
        }
        else if(s.equals("移动")){
          Move mo=new Move(ss,aa,tree,x,y,mc,mf);
        }
        
    }
    void find( ComboBox<String> c,Label bq,ListView<String> lv,TextField wbk){
        String cha1=c.getValue();
        String cha2=wbk.getText();
           if(!cha2.equals("")){
               
               Search sh=new Search(cha1,cha2,bq,lv);
           }
    }
   


    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *tree
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
