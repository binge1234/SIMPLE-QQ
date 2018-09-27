/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import Communication.Communicate;
import Bean.*;
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
public class PublicRoom  {
    private Communicate communicate;
    private String members;
    private  String owner;
    private Button button;
    private TextField textfield;
    private TextArea area;
    private BorderPane pane; 
    private Label label;
    private Scene scene;
    private Stage stage;
    private Double stage_X;
    private Double stage_Y;
    public PublicRoom(Communicate communicate,String members,Double stage_X,Double stage_Y){
        this.communicate = communicate;
        this.members = members;
        this.stage_X = stage_X;
        this.stage_Y = stage_Y;
        owner = this.communicate.getName();
        pane = new BorderPane();
        
        BorderPane p = new BorderPane();
        label = new Label(members);
        p.setCenter(label);
        pane.setTop(p);
        
        area = new TextArea();
        pane.setCenter(area);
        
        textfield = new TextField();
        button = new Button("send");
        button.setOnAction(e->send_message());
        HBox h = new HBox();
        h.getChildren().add(textfield);
        h.getChildren().add(button);
        pane.setBottom(h);
        
       scene = new Scene(pane,200,400);
        stage = new Stage();
       stage.setScene(scene);
       stage.setX(stage_X);
       stage.setY(stage_Y);
       stage.show();
        
    }
     public Stage getStage(){
     return stage;
     }
    
    public String getMembers(){
    return this.members;
    }
    
    public void send_message(){
      String content = textfield.getText();
      if(content !=null || !content.equals("")){
          Message message = new Message();
          message.setSender(owner);
          message.setReceiver(members);
          message.setContent(content);
          
       area.appendText(owner +" \n");
       area.appendText(content + "\n");
       textfield.setText("");
       communicate.transfer_Message(message);
       
      }
    
    }
    
    public void receive_message(Message message){//可能会有错other
        String other = message.getSender();
        String content = message.getContent();
        
        area.appendText(other +" \n");
        area.appendText(content + "\n");
    }
    


    
    
    
}