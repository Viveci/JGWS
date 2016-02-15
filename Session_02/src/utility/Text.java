package utility;

public class Text{
   private String text;
   
   public Text(String text){
      this.text = text;
   }
   
   public String getText(){
      return text;
   }
   
   public String toString(){
      return text;
   }
   
   public boolean isPalindrome(){
      return isPalindrome(text,0,text.length()-1);
   }
   
   private boolean isPalindrome(String text, int left, int right){
      if(left>=right){
         return true;
      }
      return (Character.toLowerCase(text.charAt(left))==Character.toLowerCase(text.charAt(right))
            &&isPalindrome(text, left+1, right-1));
      
   }
}