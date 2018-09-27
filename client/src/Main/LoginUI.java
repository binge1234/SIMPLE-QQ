/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import Communication.Communicate;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;  
import javafx.scene.text.Font;  
import javafx.scene.text.FontWeight;  
import javafx.scene.text.Text;  
import javafx.stage.Stage; 
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 志彬
 */
public class LoginUI extends Application {
    GridPane pane = new GridPane();
    Text title = new Text("WELCOME");
    Label lb1 = new Label("User Name");
    Label lb2 = new Label("Password");
    TextField tf = new TextField();
    PasswordField pf = new PasswordField();
    Button btn = new Button("Sign in");
    Label text = new Label("hello");
    Socket socket ;
    
    
    
    
   
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        socket = new Socket("127.0.0.1",888);
        
        pane.setAlignment(Pos.CENTER);  
        pane.setHgap(10);  
        pane.setVgap(10);  
        pane.setPadding(new Insets(25, 25, 25, 25)); 
        
       
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        pane.add(title, 0, 0, 2, 1);
        
        
        pane.add(lb1,0,1);
        
        
        pane.add(lb2,0,2);
        
        
        pane.add(tf,1,1);
        
        
        
        pane.add(pf,1,2);
        
        
          
        HBox hbBtn = new HBox(10);  
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);  
        hbBtn.getChildren().add(btn);  
        pane.add(hbBtn, 1, 4);
        btn.setOnAction(e->judge(tf,pf,primaryStage,socket));
        
        
        pane.add(text, 1,5); 
        
        
        
        Scene scene = new Scene(pane, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void judge(TextField tf, PasswordField pf,Stage primaryStage,Socket socket)  {
        String name = tf.getText();
        String password = pf.getText();
       if(password == null || name == null ||password.equals("")||name.equals("")){
         text.setText("ERROR");
         tf.setText("");
         pf.setText("");
       }
       else{
           Communicate communicate = new Communicate(name,password,socket);
           Boolean status = false;
            try {
                status = communicate.login();
            } catch (IOException ex) {
                Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
            }
           
           
          if(status){
               try {
                   Home home = new Home(communicate);
                   System.out.println("123456");
               } catch (IOException ex) {
                   Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
               }
          primaryStage.close();
          
          }
          else{
              tf.setText("");
              pf.setText("");
              text.setText("Error");
          }
       }
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
