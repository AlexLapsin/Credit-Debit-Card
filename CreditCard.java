public class CreditCard extends ChargeCard
{
   private double spendingLimit;
   
   //overloaded constructor that accepts 2 arguments
   public CreditCard(String n, String cardNum)
   {  
      super(n, cardNum);
      spendingLimit = 2000; //$
   }
   
   //purchase method
   public double purchase(double amountSpent)
      { 
        double finalBalance;   
        balance += amountSpent;
        
         if(balance > spendingLimit)
           {System.out.println("Your purchase was declined! You exceeded you spending limit!");
           return balance -= amountSpent;}     
         else 
           finalBalance = balance;
       
       return finalBalance;
      }
   
   //increase Credit Limit method
   public double increaseSpendingLimit()
      {
         spendingLimit += 50;
      
         return spendingLimit;
      }
   
   //reset balance method
   public void payBill()
   {
      balance = 0;
   }
   
   //accessors
  
   public double getSpendingLimit()
      {return spendingLimit;}
     
   
   
   //mutators
   public void setSpendingLimit(double s)
      {
         if(s>0)
         spendingLimit = s;
      }   
   
   //toString
   public String toString()
   {
      return super.toString()+ "\nSpending Limit: "+spendingLimit;
   }
   
}