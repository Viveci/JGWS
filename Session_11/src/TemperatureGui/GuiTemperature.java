package TemperatureGui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiTemperature extends JFrame
{
   private JLabel labelTemp;
   private JButton buttonUpdate;
   // model facade class
   private Model model;

   public GuiTemperature(Model model)
   {
      super("Temperature presenter");
      this.model = model;
      createComponents();
      initializeComponents();
      registerEventHandlers();
      addComponentsToFrame();
   }

   private void createComponents()
   {
      labelTemp = new JLabel("No data");
      buttonUpdate = new JButton("Update");
   }

   private void initializeComponents()
   {
      labelTemp.setFont(new Font("Helvetica", Font.PLAIN, 20));
      buttonUpdate.setFont(new Font("Helvetica", Font.PLAIN, 20));
      setSize(350, 120); // set frame size
      setLocationRelativeTo(null); // center of the screen
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   private void registerEventHandlers()
   {
      ButtonHandler handler = new ButtonHandler(model);
      buttonUpdate.addActionListener(handler);
   }

   private void addComponentsToFrame()
   {
      JPanel contentPane = new JPanel(new BorderLayout(0, 5));
      contentPane.add(buttonUpdate, BorderLayout.NORTH);
      contentPane.add(labelTemp);
      setContentPane(contentPane);
   }

   private class ButtonHandler implements ActionListener
   {
      private Model model;

      public ButtonHandler(Model model)
      {
         this.model = model;
      }

      public void actionPerformed(ActionEvent event)
      {
         if (event.getSource() == buttonUpdate)
         {
            Temperature t = model.getLastInsertedTemperature();
            labelTemp.setText(t.toString());
         }
      }
   }
}