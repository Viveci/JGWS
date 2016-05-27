import chat.controller.ClientController;
import chat.controller.Controller;
import chat.controller.ServerController;
import chat.domain.mediator.ClientModelManager;
import chat.domain.mediator.Model;
import chat.domain.mediator.ServerModelManager;
import chat.view.ClientView;
import chat.view.ServerView;
import chat.view.View;

public class ClientMain
{
   public static void main(String args[])
   {
      try
      {
         Model model = new ClientModelManager();
         View view = new ClientView();
         Controller controller = new ClientController(model, view);

         view.start(controller);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}
