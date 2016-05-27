import chat.controller.Controller;
import chat.controller.ServerController;
import chat.domain.mediator.Model;
import chat.domain.mediator.ServerModelManager;
import chat.view.ServerView;
import chat.view.View;

public class ServerMain
{
   public static void main(String args[])
   {
      try
      {
         Model model = new ServerModelManager();
         View view = new ServerView();
         Controller controller = new ServerController(model, view);

         view.start(controller);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}
