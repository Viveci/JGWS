package TemperatureGui;

public class Main
{
 public static void main(String[] args)
 {
 Model model = new ModelManager();

 DataLogger dataLogger = new DataLogger(model, 3000);
 Thread loggerThread = new Thread(dataLogger, "DataLogger");
 loggerThread.start();
 GuiTemperature view = new GuiTemperature(model);
 view.setVisible(true);
 }
}
