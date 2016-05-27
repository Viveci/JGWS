package chat.controller;

import java.util.Observable;

import chat.domain.mediator.Model;
import chat.domain.mediator.ServerModelManager;
import chat.domain.model.*;
import chat.view.ServerView;
import chat.view.View;


public class ServerController implements Controller
{
   private Model model;
   private View view; 

   public ServerController(Model model, View view)
   {
      this.model = model;
      this.view = view;  
      ((Observable) this.model).addObserver(view);
   }

   public void execute(String what)
   {
      switch (what)
      {
         case "Send":
            String input = view.getAndRemoveInput();
            if (input.length() > 0)
            {
               model.addMessage(new Message(input));
            }
            break;
         case "Quit":
            System.exit(0);
      }
   }

}