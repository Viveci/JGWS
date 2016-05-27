package tcp;

import java.net.*;
import java.io.*;

public class TCPServer
{

   public static void main(String[] args) throws IOException
   {
      String clientSentence;
      String capitalizedSentence;
      ServerSocket welcomeSocket = new ServerSocket(3);

      while (true)
      {
         Socket connectionSocket = welcomeSocket.accept();
         BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
         DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
         clientSentence = inFromClient.readLine();
         System.out.println("Received: " + clientSentence);
         capitalizedSentence = clientSentence.toUpperCase() + '\n';
         outToClient.writeBytes(capitalizedSentence);
      }

   }

}
