/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cicq.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 志彬
 */
public class Server {
        public static void main(String[] args) throws IOException {
        // TODO code application logic here
      ServerSocket server = new ServerSocket(888);
      System.out.println(server.getChannel());
      System.out.println(server.getLocalSocketAddress());
       
      Map<String, PrintWriter> map = new HashMap<>();
      while(true){
      Socket socket = server.accept();
      System.out.println(socket.getLocalAddress());
      Runnable handler = new ServerHandler(map,socket);
      Thread thread = new Thread(handler);
      thread.start();
      }
      
        
    }
}
