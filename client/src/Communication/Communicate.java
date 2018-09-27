    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Communication;
import Bean.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 志彬
 */
public class Communicate {
    private String name;
    private String password;
    private Socket socket;
    BufferedInputStream reader; 
    ObjectInputStream input;
    ObjectOutputStream output;
    public Communicate(String name,String password,Socket socket){
    this.name = name;
    this.password = password;
    this.socket = socket;
    }
    public void transfer_Message(Message message) {
        try {
            output.writeObject(message);
            System.out.println(message.getContent());
            output.flush();
        } 
        
        
        catch (IOException ex) {
            Logger.getLogger(Communicate.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public String getName(){
       return name;
    }
    public Socket getSocket(){
      return socket;
    }
    public ObjectInputStream getInput(){
       return input;
    }
    public ObjectOutputStream getOutput(){
       return output;
    }
    public void init() throws IOException{
       
        output = new ObjectOutputStream(socket.getOutputStream());
        reader = new BufferedInputStream(socket.getInputStream());
       input = new ObjectInputStream(reader);
       
      //output = new ObjectOutputStream(socket.getOutputStream());
       
    }
    public Boolean login() throws IOException, ClassNotFoundException{
     
     init();
     output.writeObject("login");
     
     output.writeObject(name);
     output.writeObject(password);
      output.flush();
      String response = (String)input.readObject();
      if(response.equals("success")){
      return true;
      }
      else{
      return false;
      }
    }
     
    
    
    public List<User> initUsers() throws IOException, ClassNotFoundException{
        output.writeObject("init");
        output.flush();
        
        List<User> users = (List<User>)input.readObject();
        //System.out.println(user.getName());
        return users;
 
 
    }
    
    public Object getObject() throws IOException, ClassNotFoundException{
     Object object = input.readObject();
     return object;
    
    }
    
}
