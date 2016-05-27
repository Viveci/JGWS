package matrix;

public class Matrix{

   private int[][] matrix;
   
   public Matrix(int [][] m){
      if(!isRectangular()){
         throw new IllegalArgumentException();
      }
      this.matrix = m;
   }
   
   public int[][] get2DArrayRepresentation(){
      int[][] rtrn = new int[matrix.length][];
      for (int i = 0; i < matrix.length; i++){
         rtrn[i] = matrix[i].clone();
      }
      return rtrn;
   }
   
   public boolean isRectangular(){
      boolean rtrn = true;
      for (int i = 0; i < matrix.length; i++){
         if(matrix[i].length != matrix[0].length){
            rtrn = false;
         }
      }
      return rtrn;
   }
   
   public boolean isSquare(){
      boolean rtrn = true;
      
      if (!isRectangular() || matrix.length != matrix[0].length ){
         rtrn = false;
      }
      
      return rtrn;
   }
   
   public boolean isDiagonal(){
      boolean rtrn = true;
      
      if(!isSquare()){
         rtrn = false; 
      }
      else{
         for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
               if(i != j && matrix[i][j] != 0){
                  rtrn = false;
               }
            }
         }
      }
      
      return rtrn;
   }
   
   public boolean isIdentity(){
      boolean rtrn = true;;
     
      if(!isDiagonal()){
         rtrn = false;
      }
      else{
         for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
               if(matrix[i][j] != 1){
                  rtrn = false;
               }
            }
         }
      }
      
      return rtrn;
   }
   
   public boolean isLowerTriangular(){
      boolean rtrn = true;
      
      if(!isSquare()){
         rtrn = false;
      }
      else{
         for(int i = 0; i < matrix.length ; i++){
            for(int j = i; j < matrix[0].length; j++){
               if(matrix[i][j] != 0){
                  rtrn = false;
               }
            }
         }
      }
      
      return rtrn;
   }
   
   public boolean isHigherTriangular(){
      boolean rtrn = true;
      
      if(!isSquare()){
         rtrn = false;
      }
      else{
         for(int i = 0; i < matrix.length ; i++){
            for(int j = 0; j < i; j++){
               if(matrix[i][j] != 0){
                  rtrn = false;
               }
            }
         }
      }
      
      return rtrn;
   }
   
   public boolean isSymetrical(){
      boolean rtrn = true;
      
      if(!isSquare()){
         rtrn = false;
      }
      else{
         for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
               if(matrix[i][j] != matrix[j][j]){
                  rtrn = false;
               }
            }
         }
      }
      
      return rtrn;
   }
   
   public String toString(){
      String s = "";
      for (int i = 0; i < matrix.length; i++){
         s += "[";
         for (int j = 0; j < matrix[0].length-1; j++){
            s += matrix[i][j]+",";
         }
         s += matrix[i][matrix[0].length] + "]\n";
      }
      return s;
   }
   
   public Matrix transpose(){
      int[][] temp = new int[matrix.length][matrix[0].length];
      for (int i = 0; i < temp.length; i++){
         for (int j = 0; j < temp.length; j++){
            temp[j][i] = matrix[i][j];
         }
      }
      Matrix rtrn = new Matrix(temp);
      return rtrn;
   }
   
   public Matrix add(Matrix m){
      int[][] clone = matrix.clone();
      int[][] temp = m.get2DArrayRepresentation();
      for (int i = 0; i < temp.length; i++){
         for (int j = 0; j < temp.length; j++){
            clone[i][j] += temp[i][j]; 
         }
      }
      Matrix rtrn = new Matrix(clone);
      return rtrn;
   }
   
}
