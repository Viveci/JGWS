package Model;

public class RoomBuilder{

   //Trololol
   
   public RoomBuilder(){
      
   }
   
   public Room buildSingleRoom(int i){
      return new Room(i, "Single");
   }
   
   public Room buildDoubleRoom(int i){
      return new Room(i, "Double");
   }
   
   public Room buildTwinBedRoom(int i){
      return new Room(i,"Twin beds");
   }
   
   public Room buildKingSizedRoom(int i){
      return new Room(i, "King size");
   }
   
}
