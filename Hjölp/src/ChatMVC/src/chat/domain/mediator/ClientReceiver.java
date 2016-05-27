package chat.domain.mediator;

import java.io.ObjectInputStream;
import java.net.SocketException;

import chat.domain.model.*;

public class ClientReceiver implements Runnable
{
   private ObjectInputStream inFromServer;
   private Model model;

   public ClientReceiver(ObjectInputStream inFromServer, Model model) 
   {
      this.inFromServer = inFromServer;
      this.model = model;
   }

   public void run()
   {
      try
      {
         while (true)
         {
            Message message = (Message) inFromServer.readObject();
            System.out.println("Reciever: " + message);
            model.notifyAboutMessage(message);
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
}
