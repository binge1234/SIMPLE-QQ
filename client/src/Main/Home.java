/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import Communication.Communicate;
import Bean.User;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.net.*;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import java.util.*;
import Communication.*;

/**
 *
 * @author 志彬
 */
public class Home  {
    private Communicate communicate;
    private Label bq1=new Label();
    private Label bq2=new Label("  备注");
    private TreeView treeview ;
    private CheckBoxTreeItem<String> rootItem;
    private ImageView view = new ImageView();
    private String userName;
    private List<User> users;
    private Button button;
    private List<PrivateRoom> private_rooms;
    private List<PublicRoom> public_rooms;
    private Scene scene;
    private Stage stage;
    private Double stage_X;
    private Double stage_Y;
    private Receive receive;
    
    public Home(Communicate communicate) throws IOException, ClassNotFoundException{
      this.communicate = communicate;
      userName = communicate.getName();
      users = communicate.initUsers();
      BorderPane pane=new BorderPane();
      
      Image image = new Image("tu/qq.png");
      bq1.setText(userName);
      bq2.setText("172.16.28.143");
      view.setImage(image);
       VBox v=new VBox();
       v.setPadding(new Insets(7,7,7,7));
       v.getChildren().add(bq1);
       v.getChildren().add(bq2);
       HBox h = new HBox();
       h.getChildren().add(view);
       h.getChildren().add(v);
       pane.setTop(h);
       
       private_rooms = new ArrayList<PrivateRoom>();
       public_rooms = new ArrayList<PublicRoom>();
       
       treeview = new TreeView(rootItem);
       rootItem = getRoot();
       rootItem.setExpanded(true);
       treeview.setCellFactory(CheckBoxTreeCell.<String>forTreeView());
       treeview.setRoot(rootItem);
       treeview.setShowRoot(true);
       System.out.println(stage_X);
       System.out.println(stage_Y);

       pane.setCenter(treeview);
       
       button = new Button("CREAT");
       button.setOnAction(e->creat_room());
       pane.setBottom(button);
      
       
       
       scene = new Scene(pane,200,400);
       stage = new Stage();
       stage.setScene(scene);
       stage_X  = stage.getX();
       stage_Y =  stage.getY();
       stage.show();
       
        receive = new Receive(treeview,communicate,private_rooms,public_rooms,stage_X,stage_Y);
       Thread thread = new Thread(receive);
       thread.start();
       
    }
    
    
    public CheckBoxTreeItem<String> getRoot(){
        
        CheckBoxTreeItem<String> root = new CheckBoxTreeItem<String>("所有联系人");
        for(int i = 0; i < users.size();i++){
                   String name = users.get(i).getName();
                   Image d=new Image("tu/3.png");
                   ImageView view = new ImageView(d);
                   CheckBoxTreeItem<String> item = new CheckBoxTreeItem<String>(name,view);
                   root.getChildren().add(item);
                   
        }
        
       return root;
    }
    public void creat_room(){
       stage_X = stage.getX();
       stage_Y = stage.getY();
        List<String> names = new ArrayList<String>();
    for(Iterator<TreeItem<String>> iterator=rootItem.getChildren().iterator();iterator.hasNext();){
                    CheckBoxTreeItem<String> item=(CheckBoxTreeItem<String>) iterator.next();
                     if(item.isSelected()){
                         //获得勾选的item
                         String name = item.getValue();
                         names.add(name);
//                         User receiver = new User();
//                         for(int i = 0; i < users.size(); i++){
//                         if(users.get(i).getName().equals(name)){
//                            receiver = users.get(i);
//                         }
//                         }
                         
                        
                         
                     }
                 }
          
             if(names.size()==1){
                 String other = names.get(0);
                 private_rooms = receive.getArray1();
                 int flag = 0;
                 int index = 0;
                 for(int i = 0; i < private_rooms.size();i++){
                 if(private_rooms.get(i).getOther().equals(other)&&!private_rooms.get(i).getStage().isShowing() ){
                    flag = 1;
                    index = i;
                      break;
                 }
                 else if(private_rooms.get(i).getOther().equals(other)&&private_rooms.get(i).getStage().isShowing()){
                   flag = 2;
                   break;
                 }
               
                 }
                 if(flag == 0){
                   PrivateRoom private_room = new PrivateRoom(communicate,other,stage_X,stage_Y);
                   private_rooms.add(private_room);
                   receive.setArray1(private_rooms);
                 }
                 if(flag == 1){
                 private_rooms.remove(index);
                  PrivateRoom private_room = new PrivateRoom(communicate,other,stage_X,stage_Y);
                  private_rooms.add(private_room);
                 receive.setArray1(private_rooms);
                 }
            }
             else if(names.size() > 1){
                 StringBuilder members = new StringBuilder();
               for(int i = 0; i < names.size(); i++){
                members.append(names.get(i));
                 members.append(" ");
                 
               }
               members.append(userName);
               String leaguers = new String(members);
               public_rooms = receive.getArray2();
               int flag = 0;
               int index  = 0;
               for(int i = 0; i < public_rooms.size();i++){
                 if(public_rooms.get(i).getMembers().equals(leaguers)&&!public_rooms.get(i).getStage().isShowing() ){
                    flag = 1;
                    index = i;
                      break;
                 }
                 else if(public_rooms.get(i).getMembers().equals(leaguers)&&public_rooms.get(i).getStage().isShowing()){
                   flag = 2;
                   break;
                 }
               
                 }
                 if(flag == 0){
                   PublicRoom public_room = new PublicRoom(communicate,leaguers,stage_X,stage_Y);
                   public_rooms.add(public_room);
                   receive.setArray2(public_rooms);
                 }
                 if(flag == 1){
                 public_rooms.remove(index);
                  PublicRoom public_room = new PublicRoom(communicate,leaguers,stage_X,stage_Y);
                  public_rooms.add(public_room);
                 receive.setArray2(public_rooms);
                 }
               
             }
    
    }
    



    
}
