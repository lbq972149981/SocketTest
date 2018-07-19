package SocketTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
   public static void main(String[] args) {
      Socket client = null;
      PrintWriter out = null;
      try {
          client = new Socket("127.0.0.1",9081);
          out = new PrintWriter(client.getOutputStream(),true);
         Scanner sc = new Scanner(System.in);
         String words;
          while(sc.hasNext()){
             words = sc.nextLine();
             out.println(words);
             if(words.equals("exit")){
                System.exit(1);
             }
          }


      } catch (IOException e) {
         e.printStackTrace();
      }finally {
         try {
            client.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }
}
