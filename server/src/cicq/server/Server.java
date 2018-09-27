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
      ServerSocket server = new ServerSocket(888);//服务器端开启服务端口
      System.out.println(server.getChannel());
      System.out.println(server.getLocalSocketAddress());
       
      Map<String, PrintWriter> map = new HashMap<>();
      while(true){
      Socket socket = server.accept();//服务端等待客户端连接，若连接上为每个客户端开启一个线程去处理
      System.out.println(socket.getLocalAddress());
      Runnable handler = new ServerHandler(map,socket);
      Thread thread = new Thread(handler);
      thread.start();
      }
      
        
    }
}
