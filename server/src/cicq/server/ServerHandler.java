/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cicq.server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
/**
 *
 * @author 志彬
 */
public class ServerHandler implements Runnable{
    private Map<String,PrintWriter> map;
    private Socket socket;
    private StringBuilder names = new StringBuilder();
    InputStreamReader reader;
    BufferedReader buffer_reader;
    PrintWriter writer;
    Dao dao;
    public ServerHandler(Map<String, PrintWriter> map,Socket socket){
     this.map = map;
     this.socket = socket;
    }
    @Override
    public void run(){
    
        try {
            reader = new InputStreamReader(socket.getInputStream());
            buffer_reader =  new BufferedReader(reader);
            writer = new PrintWriter(socket.getOutputStream());
            dao = new Dao();
            
            
           
       while(true){
                String request = buffer_reader.readLine();
                if(request.equals("login")){
                connect_client(request);
                
                 }
                else if(request.equals("init")){
                init_client(request);
                 }
              
              }
       
        }
        
        
        
        
        
        
        
        catch (IOException ex) {
            Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    

    }
    
    public void connect_client(String request) throws IOException{
           
                 String name = buffer_reader.readLine();
                 String password = buffer_reader.readLine();
                 if(dao.isCorrect(name,password)){
                    writer.println("success");
                    System.out.println("成功");
                    map.put(name,writer);
                    
                 }
                 else{
                   writer.println("failure");
                 }
                 writer.flush();
        
    }
    
    public void init_client(String request){
       for(String key : map.keySet()){
        System.out.println("666");
        names.append(key);
        names.append(" ");
        System.out.println("666");
          
       }
       if(names != null){
       writer.println(names);
       }
       else{
       writer.println("nobody");
       }
       writer.flush();
    }
    public void warn_other(){
        for(String key :map.keySet()){
        
            
        }
    }

    
}
