public class DebitCard extends ChargeCard
{
   private double overdraftLimit;
   private double overdraftFee;
   private double feesIncured;
   
   //overloaded constructor that accepts 2 arguments
   public DebitCard(String n, String cardNum)
      {  
         super(n, cardNum);
         feesIncured = 0; //$
         overdraftFee = 50; //$
         overdraftLimit = -100; //$
      }
      
   //Purchase method
   public double purchase(double amountSpent)
      {    
        balance -= amountSpent;
        double finalBalance = balance;
        
         if(balance < 0 && balance > overdraftLimit)
           {System.out.println("Your balance is below 0! An overdraft fee will be applied");
            feesIncured += overdraftFee;
            return finalBalance; }     
         
         if(balance <= overdraftLimit)
           {System.out.println("Your purchase was declined! You've reached your overdraft limit");
            return balance += amountSpent;}
       
       return finalBalance;
      }
   
   //Increase Overdraft Limit method
   public double increaseOverdraftLimit()
      {
         overdraftLimit -= 100;
      
         return overdraftLimit;
      }
   
   //Deposit funds method
   public double depositFunds(double d)
      {
         balance += d;
         return balance;
      }
   
   //Widraw funds method
   public double widrawFunds(double w)
      {
         balance -= w;
         return balance;
      }
   
   //Pay fees method
   public void payFees()
   {
      feesIncured = 0;
   }
   
   //accessors
  
   public double getOverdraftLimit()
      {return overdraftLimit;}
     
 
   public double getOverdraftFee()
      {return overdraftFee;}
      
   public double getFeesIncured()
      {return feesIncured;}
   
   
   //mutators
   public void setOverdraftLimit(double o)
      {
         if(o>0)
            overdraftLimit = -o;
      }   
   
   public void setOverdraftFee(double f)
      {
         if(f>0)
         overdraftFee = f;
      }   

   
   //toString
   public String toString()
      {
         return super.toString()+ "\nOverdraft Limit: " + overdraftLimit + 
                "\nOverdraft Fee: " + overdraftFee + "\nFees Incured: " + feesIncured;
      }
   
}