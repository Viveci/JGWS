import java.sql.Time;
import java.time.LocalDateTime;

public class Clock{

   private int hour,minute,sec;
   
   public Clock(){
      this.hour = LocalDateTime.now().getHour();
      this.minute =  LocalDateTime.now().getMinute();
      this.sec = LocalDateTime.now().getSecond();
   }   
   
   public void set(int hour, int minute, int sec){
      if(sec > 60){
         sec = 1;
         minute++;
      }
      if(minute > 60){
         minute = 0;
         hour++;
      }
      if(hour > 24){
         hour = 0;
      }
      this.hour = hour;
      this.minute = minute;
      this.sec = sec;
   }
   
   public String toString(){
      return hour+":"+minute+":"+sec;
   }
   
   public int getHour(){
      return hour;
   }
   
   public int getMinute(){
      return minute;
   }
   
   public int getSec(){
      return sec;
   }
   
   
}
