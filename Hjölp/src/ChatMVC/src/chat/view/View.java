package chat.view;

import java.util.Observer;

import chat.controller.Controller;
import chat.controller.ServerController;

public interface View extends Observer
{
   public void start(Controller controller);
   public String getAndRemoveInput();
}
