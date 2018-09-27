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
public class Model  {
    
  
     
     Node k;
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    
    public TreeItem<String> getRoot(ArrayList<String> a,ArrayList<People> people){
          ContextMenu cm1=new ContextMenu();
      ContextMenu cm2 = new ContextMenu();
          MenuItem cmItem1 = new MenuItem("添加分组");
          MenuItem cmItem2=new MenuItem("删除分组");
          MenuItem cmItem3=new MenuItem("重命名分组");
          MenuItem cmitem1=new MenuItem("添加联系人");
          MenuItem cmitem2=new MenuItem("删除联系人");
          MenuItem cmitem3=new MenuItem("移动联系人至");
          MenuItem cmitem4=new MenuItem("修改联系人");
        
       cm1.getItems().add(cmItem1);
       cm1.getItems().add(cmItem2);
       cm1.getItems().add(cmItem3);
       cm2.getItems().add(cmitem1);
       cm2.getItems().add(cmitem2);
       cm2.getItems().add(cmitem3);    
       cm2.getItems().add(cmitem4); 
        TreeItem<String> rootItem = new TreeItem<> ("所有分组",k);
       rootItem.setExpanded(true);
        for(int i=0;i<a.size();i++){
            Image d=new Image("tu/3.png");
    ImageView p=new ImageView(d);
    TreeItem<String> item = new TreeItem<> (a.get(i),p);
          
rootItem.getChildren().add(item);
 
for(int j=0;j<people.size();j++){
    String zu=people.get(j).group;
    if(zu.equals(a.get(i))){
      //String name=people.get(j).name;
    Image d1=new Image("tu/7.png");
 ImageView p1=new ImageView();
 p1.setImage(d1);
Tooltip tooltip1 = new Tooltip();
  tooltip1.setText("图片\n"+"真实姓名\n"+"电话\n"+"住址");
      //tp1.setImage(pic1);
       Tooltip.install(p1,tooltip1);
    TreeItem<String> t = new TreeItem<> (people.get(j).name ,p1);
    	
    item.getChildren().add(t);
    
    }
}
        }

    
        return rootItem;
    }

    
    
}
