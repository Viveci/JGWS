package matrix;

public class Vector{

   private double[] vector;
   private boolean isColumn;
   
   public Vector(double [] v){
      this.vector = v;
      isColumn = true;
   }
   
   public double[] getArrayRepresentation(){
      return vector.clone();
   }
   
   public int dimension(){
      return this.vector.length;
   }
   
   public boolean isCulomnVector(){
      return isColumn;
   }
   
   public Vector transpose(){
      Vector rtrn = new Vector(vector);
      rtrn.isColumn = false;
      return rtrn; 
   }
   
   public void plus(Vector v){
      if(v.dimension() == vector.length){
         double[] in = v.getArrayRepresentation();
         for (int i = 0; i < vector.length; i++){
            vector[i] += in[i];
         }
      }
      else{
         throw new IllegalArgumentException();
      }
   }
   
   public void minus(Vector v){
      if(v.dimension() == vector.length){
         double[] in = v.getArrayRepresentation();
         for (int i = 0; i < vector.length; i++){
            vector[i] -= in[i];
         }
      }
      else{
         throw new IllegalArgumentException();
      }
   }
   
   public void product(int c){
      for (int i = 0; i < vector.length; i++){
         vector[i] *= c;
      }
   }
   
   public void product(Vector v){
      if(v.dimension() == vector.length){
         double[] in = v.getArrayRepresentation();
         for (int i = 0; i < vector.length; i++){
            vector[i] *= in[i];
         }
      }
      else{
         throw new IllegalArgumentException();
      }
   }
   
   public double length(){
      double rtrn = 0, sum = 0;
      for (int i = 0; i < vector.length; i++){
         sum += vector[i] * vector[i];
      }
      rtrn = Math.abs(Math.sqrt(sum));
      return rtrn;
   }
   
   public Vector unitVector(){
      double[] temp = new double[vector.length];
      for (int i = 0; i < vector.length; i++)
      {
         temp[i] = vector[i] / length();
      }
      return new Vector(temp);
   }

   public String toString()
   {
      String rep = "";
      if (isColumn)
      {
         rep += "[ ";
         for (int i = 0; i < vector.length; i++)
         {
            if (i < vector.length - 1)
               rep += vector[i] + "\n";
            else
               rep += vector[i];
         }
         rep += " ]";
      }
      else
      {
         rep += "[";
         for (int i = 0; i < vector.length; i++)
         {
            if (i < vector.length - 1)
               rep += " " + vector[i] + ",";
            else
               rep += " " + vector[i];
         }
         rep += " ]";
      }
      return rep;
   }
   
}
