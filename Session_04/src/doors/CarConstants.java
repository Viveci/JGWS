package doors;

public interface CarConstants {
    CarState CLOSED = new CarState()
   {
      
      @Override
      public void click(Car door)
      {
         // TODO Auto-generated method stub
         
      }
   };
    CarState OPENING = new CarState()
    {
       
       @Override
       public void click(Car door)
       {
          // TODO Auto-generated method stub
          
       }
    };
    CarState OPEN = new CarState()
    {
       
       @Override
       public void click(Car door)
       {
          // TODO Auto-generated method stub
          
       }
    };
    CarState CLOSING = new CarState()
    {
       
       @Override
       public void click(Car door)
       {
          // TODO Auto-generated method stub
          
       }
    };
    CarState STAYOPEN = new CarState()
    {
       
       @Override
       public void click(Car door)
       {
          // TODO Auto-generated method stub
          
       }
    };
}