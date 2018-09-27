/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Communication;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Bean.*;
import Main.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Platform;
import Main.*;
/**
 *
 * @author 志彬
 */
public class Receive implements Runnable{
    private Communicate communicate;
    private TreeView treeview;
    private CheckBoxTreeItem<String> rootItem;
    private List<PrivateRoom> private_rooms;
    private List<PublicRoom> public_rooms;
    private Double stage_X;
    private Double stage_Y;
    private String name;
    public Receive(TreeView treeview,Communicate communicate,List<PrivateRoom> private_rooms,List<PublicRoom> public_rooms,Double stage_X,Double stage_Y){
    this.treeview = treeview;
    this.rootItem = (CheckBoxTreeItem<String>)treeview.getRoot();
    this.communicate = communicate;
    this.private_rooms = private_rooms;
    this.public_rooms = public_rooms;
    this.stage_X = stage_X;
    this.stage_Y = stage_Y; 
    this.name = communicate.getName();
    
    }
    
    public void run(){
        
      while(true){
          try {
              Object object = communicate.getObject();
              if(object instanceof User){
                 User user = (User)object;
                 String name = user.getName();
                 Image image = new Image("tu/3.png");
                 ImageView pic = new ImageView(image);
                 CheckBoxTreeItem<String> item = new CheckBoxTreeItem<String>(name,pic);
                 rootItem.getChildren().add(item);
              }
//              else if(object instanceof Message){
//                  Platform.runLater(new Runnable(){
//                      public void run(){
//                 Message message = (Message)object;
//                 String other = message.getSender();
//                 String owner = message.getReceiver();
//                 System.out.println(message.getContent());
//                 int flag = 0;//判断聊天框是否存在
//                 for(int i = 0; i < private_rooms.size();i++){
//                 if(private_rooms.get(i).getOther().equals(other)){
//                  PrivateRoom private_room = private_rooms.get(i);
//                  private_room.getStage().show();
//                  private_room.receive_message(message);
//                   flag = 1;
//                   break;
//                 
//                 }
//                 }
//                 if(flag == 0){
//                     System.out.println(stage_X);
//                     System.out.println("新建不起来"); 
//                     System.out.println(stage_X); 
//                      System.out.println(stage_Y); 
//                  PrivateRoom private_room = new PrivateRoom(communicate,other,stage_X,stage_Y);
//                  
//                  System.out.println(other);
//                  private_room.receive_message(message);
//                  System.out.println(other);
//                  private_rooms.add(private_room);
//                 }
//                      }
//              });
//              }
              
              else if(object instanceof Message){
                  Platform.runLater(new Runnable(){
                      public void run(){
                 Message message = (Message)object;
                 String other = message.getSender();
                 String owner = message.getReceiver();
                 String[] owner1 = owner.split(" ");
                 
                 
                 if(owner1.length == 1){
                 int flag = 0;//判断聊天框是否存在
                 for(int i = 0; i < private_rooms.size();i++){
                 if(private_rooms.get(i).getOther().equals(other)){
                  PrivateRoom private_room = private_rooms.get(i);
                  private_room.getStage().show();
                  private_room.receive_message(message);
                   flag = 1;
                   break;
                 
                 }
                 }
                 if(flag == 0){
                     System.out.println(stage_X);
                     System.out.println("新建不起来"); 
                     System.out.println(stage_X); 
                      System.out.println(stage_Y); 
                  PrivateRoom private_room = new PrivateRoom(communicate,other,stage_X,stage_Y);
                  
                  System.out.println(other);
                  private_room.receive_message(message);
                  System.out.println(other);
                  private_rooms.add(private_room);
                 }
                 }
                 
                 else{
                 int flag = 0;
                 List<String> teamers = Arrays.asList(owner1);
                
                 
                 
                 for(int i = 0; i < public_rooms.size();i++){
                     
                     List<String> others = Arrays.asList(public_rooms.get(i).getMembers().split(" "));
                    if(Tools.judge(teamers,others)){
                        System.out.println("222");
                         PublicRoom public_room = public_rooms.get(i);
                         public_room.getStage().show();
                        public_room.receive_message(message);
                       flag = 1;
                      break;
                         
                    }
                 }
                   if(flag == 0){
                     PublicRoom public_room = new PublicRoom(communicate,owner,stage_X,stage_Y);
                     public_room.receive_message(message);
                     public_rooms.add(public_room);
                     
                 }

                 }
                      }
              });
              }
             
                 
                 
              
          } 
          
          
          
          
          
          
          catch (IOException ex) {
              Logger.getLogger(Receive.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(Receive.class.getName()).log(Level.SEVERE, null, ex);
          }
      } 
    
    }
    
    public void setArray1(List<PrivateRoom> private_rooms){
    this.private_rooms = private_rooms;
    }
    public void setArray2(List<PublicRoom> public_rooms){
    this.public_rooms = public_rooms;
    }
    
    public List<PrivateRoom> getArray1(){
    return this.private_rooms;
    }
    public List<PublicRoom> getArray2(){
    return this.public_rooms;
    }
    
}
