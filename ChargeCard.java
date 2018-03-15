abstract class ChargeCard 
{
   protected String name;
   protected String cardNumber;
   protected double balance;
   protected int securityCode;
   
   //overloaded constructor that accepts 2 arguments
   public ChargeCard(String n, String cardNum)
   {  
      name = n;
      cardNumber = cardNum;
      balance = 0; //$
      securityCode = 0000;
   }
   

   //accessors
   public String getName()
      {return name; }
  
   public String getCardNumber()
      {return cardNumber;}
  
   public double getBalance()
      {return balance;}
  
   public int getSecurityCode()
      {return securityCode;}         
   
   
   //mutators
   public void setCardNumber(String cardNum)
      {
         if(cardNum.length() > 16)
            System.out.println("Wrong card number\n");
         else
            cardNum = cardNumber;   
      }
   
   public void setSecurityCode(int secCode)
      {
         if(securityCode < 0 || Integer.toString(securityCode).length() > 4)
            System.out.println("\nThe code should not have more then four numbers or be negative");
         else
            secCode = securityCode;
      }
   
   //toString
   public String toString()
   {
      return "\nName: "+name+"\nCredit card num: "+cardNumber+"\nBalance: "+balance;
   }
   
}   

