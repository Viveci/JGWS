package myThreads;

public class Computer{

   public static void main(String[] args){
   
      MailBox mailbox = new MailBox(20);
      Program program1 = new Program("Windows", "update", 30);
      Program program2 = new Program("AVG", "update virus database", 5);
      Program program3 = new Program("FBackup",
      "perform a scheduled backup", 3);
      Program program4 = new Program("Skype",
      "notify you about a person logging in", 17);
      
      Thread mb = new Thread(mailbox); 
      Thread p1 = new Thread(program1);
      Thread p2 = new Thread(program2);
      Thread p3 = new Thread(program3);
      Thread p4 = new Thread(program4);
      
      mb.start();
      p1.start();
      p2.start();
      p3.start();
      p4.start();
      
   }
}
