package model;

import java.util.ArrayList;

public class Data {
   
   private ArrayList<String> data;
   
   public Data(ArrayList<String> data){
      this.data = data;
   }
   
   public String toString(){
      return data.get(0);
   }

}
