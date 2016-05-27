package Logger;

public class LogLine{

   private String text;
   private DateTime timeStamp;
   
   public LogLine(String text){
      this.text = text;
      timeStamp = new DateTime();
   }
   
   public String getLogText(){
      return this.text;
   }
   
   public DateTime getDateTime(){
      return timeStamp;
   }
   
   public String getTimeStamp(){
      return timeStamp.getTimestamp();
   }
   
   public String toString(){
      return (this.timeStamp.getTimestamp() + ": " + this.text);
   }
   
}
