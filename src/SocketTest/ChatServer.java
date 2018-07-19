package SocketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
   public static void main(String[] args) throws IOException {
      ServerSocket  server = new ServerSocket(9081);
      try {
         Socket client = server.accept();
         try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            boolean flag = true;
            while (flag) {
               String txt = reader.readLine().trim();
               if (txt.toUpperCase().equals("EXIT")) {
                  System.out.println("客户端已退出");
                  flag = false;
               } else {
                  System.out.println("客户端说：" + txt);
               }
            }
         } finally {
            client.close();
         }
      }finally {
         server.close();
         System.exit(1);
      }
   }
}
