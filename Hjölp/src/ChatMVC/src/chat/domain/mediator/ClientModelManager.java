package chat.domain.mediator;

import java.io.IOException;
import java.util.Observable;

import chat.domain.model.Message;


public class ClientModelManager extends Observable implements Model
{
   private ClientModelProxy proxy;
 
   public ClientModelManager()
   {
      try
      {
         proxy = new ClientModelProxy(this);
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }

   @Override
   public void addMessage(Message message)
   {
      proxy.addMessage(message);
   }

   @Override
   public void notifyAboutMessage(Message message)
   {
      super.setChanged();
      super.notifyObservers(message);
   }
}
