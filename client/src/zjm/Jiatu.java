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
import java.awt.Desktop;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
 

/**
 *
 * @author 志彬
 */
public class Jiatu  {
    final Desktop desktop = Desktop.getDesktop();
    Stage g=new Stage();
    String path;
    public Jiatu(){
       final FileChooser fileChooser = new FileChooser();
       
       configureFileChooser(fileChooser);
              File file = fileChooser.showOpenDialog(g);
               
               
                
                
                //if (file != null) {
                  // openFile(file);
               // }
                 path=file.getAbsolutePath();
                  System.out.println(path);
    }
    static void configureFileChooser(
        final FileChooser fileChooser) {      
            fileChooser.setTitle("View Pictures");
            fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
            );                 
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.csv")
            );
    }
 
     private void openFile(File file) {
        EventQueue.invokeLater(() -> {
            try {
                desktop.open(file);
              
            } catch (IOException ex) {
                Logger.getLogger(Jiatu.
                        class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        });
    }
    
    

   
   
    
}
