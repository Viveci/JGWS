package View;

import java.util.Observer;

import controllers.ClientController;
import controllers.Controller;

public interface View extends Observer {
   public void start(Controller cntrl);
}
