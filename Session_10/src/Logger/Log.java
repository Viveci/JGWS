package Logger;

import java.io.File;

public class Log{

   private ArrayQueue<LogLine> lines;
   private File logfile;
   
   public Log(){
      lines = new ArrayQueue<>();
      String fileName = new DateTime().getTimestamp();
      logfile = new File(fileName);
   }
   
   public synchronized void add(LogLine line){
      this.lines.enqueue(line);
   }
   
   public ArrayQueue<LogLine> getAll(){
      return this.lines;
   }
   
}
