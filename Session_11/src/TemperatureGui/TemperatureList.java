package TemperatureGui;

public class TemperatureList
{
   private ListADT<Temperature> list;

   public TemperatureList()
   {
      this.list = new LinkedList<>();
   }

   public void addTemperature(Temperature temperature)
   {
      list.add(0, temperature);
   }

   public Temperature getTemperature(int index)
   {
      return list.get(index);
   }

   public int getSize()
   {
      return list.size();
   }

   public String toString()
   {
      String s = "{";
      for (int i = 0; i < list.size(); i++)
      {
         s += list.get(i);
         if (i < list.size() - 1)
         {
            s += ", ";
         }
      }
      return s;
   }
}