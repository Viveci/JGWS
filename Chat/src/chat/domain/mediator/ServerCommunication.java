package chat.domain.mediator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Observable;
import java.util.Observer;

import chat.domain.model.*;

public class ServerCommunication implements Observer, Runnable
{
   private ObjectInputStream inFromClient;
   private ObjectOutputStream outToClient;
   private Model model;

   public ServerCommunication(Socket clientSocket, Model model)
         throws IOException
   {
      this.model = model;

      outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
      inFromClient = new ObjectInputStream(clientSocket.getInputStream());
   }

   public void run()
   {
      try
      {
         try
         {
            ((Observable) model).addObserver(this);
            Message m = new Message(0, "Server> A client has been connected");
            System.out.println("DEBUG: " + m);
            model.addMessage(m);
         }
         catch (Exception e2)
         {
         }         

         Thread.sleep(1000);

         while (true)
         {
            Message message = (Message) inFromClient.readObject();
            model.addMessage(message);
            System.out.println("DEBUG: " + message);
         }
      }
      catch (SocketException e)
      {
         // ok
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   @Override
   public void update(Observable arg0, Object arg1)
   {
      try
      {
         Message message = (Message) arg1;
         outToClient.writeObject(message);
      }
      catch (Exception e)
      {
         // no client connection
         try
         {
            ((Observable) model).deleteObserver(this);
            Message m = new Message(-1, "Server> A client has been disconnected");
            System.out.println("DEBUG: " + m);
            model.addMessage(m);
         }
         catch (Exception e2)
         {
         }         
      }
   }

}
