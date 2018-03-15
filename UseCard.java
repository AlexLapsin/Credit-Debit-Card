import java.util.*;

public class UseCard
{
     //Main method      
   public static void main(String[]args)
   {
      
      ChargeCard cred = new CreditCard("John Doe", "1587954987568521");
      ChargeCard deb = new DebitCard("John Doe", "4810848467952130"); 
      
      Scanner console = new Scanner(System.in);
      char exit;
      
      System.out.println("\nWould you like to use credit or debit card? c/d\n");
         char card = console.next().charAt(0);
      
      
      do 
      {  
       //Credit card                    
       //*************************************************************
       if(card == 'c' || card == 'C' && cred instanceof CreditCard)
          {
            System.out.println("\n1.View credit card information"+
                              "\n2.Purchase an item"+
                              "\n3.Pay bill"+
                              "\n4.Increase spending limit\n");
                              
            System.out.print("\n\nPlease make your choice: "); 
            int choice = console.nextInt();
         
           
            if(choice == 1)
               System.out.println(cred.toString());
            if(choice == 2)
               {
                  System.out.println("\nHow much would you like to spend? ");
                  int spent = console.nextInt();
                  ((CreditCard)cred).purchase(spent);
                  System.out.println("\nThank you for purchase! Your new balance is: $" + cred.getBalance());
               } 
            if(choice == 3)
               {
                  ((CreditCard)cred).payBill();
                  System.out.println("\nBill is paid, thank you!");
               }
            if(choice == 4)  
               {
                  System.out.println("\nHow much credit limit should be ? ");
                  double totalCredit = console.nextDouble();
                  double times = (totalCredit - ((CreditCard)cred).getSpendingLimit())/50;
                  
                  for(int i = 0; i < times; i++)
                   ((CreditCard)cred).increaseSpendingLimit();
                  System.out.println("\nThank you for request! Spending limit increased");  
               }
          }//closing exterior if credit
        
        //Debit card
      //**********************************************************************       
        else if(card == 'd' || card == 'D' && deb instanceof DebitCard)
           
           {  
                 System.out.println("\n1.View debit card information"+
                                    "\n2.Purchase an item"+
                                    "\n3.Make a deposit"+
                                    "\n4.Increase overdraft limit"+
                                    "\n5.Pay Fees"+
                                    "\n6.Change the overdraft fee\n");
                                    
               System.out.print("\n\nPlease make your choice: "); 
               int input = console.nextInt();
            
              
               if(input == 1)
                  System.out.println(deb.toString());
               
               if(input == 2)
                  {
                     System.out.println("\nHow much would you like to spend? ");
                     double spent = console.nextDouble();
                     ((DebitCard)deb).purchase(spent);
                  } 
                  
               if(input == 3)
                  {
                     System.out.println("\nHow much would you like to deposit? ");
                     double deposit = console.nextDouble();
                     ((DebitCard)deb).depositFunds(deposit);
                     System.out.println("\nFunds deposited. Your new balance is: " + deb.getBalance());   
                  }  
               if(input == 4)  
                  {
                     System.out.println("\nHow much overdraft limit should be ? (Positive number)");
                     double totalLimit = console.nextDouble();
                     double times = (totalLimit + ((DebitCard)deb).getOverdraftLimit())/100;
                     
                     for(int i = 0; i < times; i++)
                      ((DebitCard)deb).increaseOverdraftLimit(); 
                     System.out.println("\nThank you for request! Overdraft limit increased");
                  }
               
               if(input == 5)
                  {((DebitCard)deb).payFees();
                   System.out.println("\nFees paid, thank you!");} 
                   
               if(input == 6)
                  {
                     System.out.println("\nHow much the overdraft fee should be ?");
                     double fee = console.nextDouble();
                     ((DebitCard)deb).setOverdraftFee(fee);    
                  }         
           }//closing exterior if debit
        
        
         //**********************************************************************
         else
          System.out.println("ERROR!!!Wrong input");  
        
        
        System.out.println("\nCONTINUE? y/n");
         exit = console.next().charAt(0);
        
      }//closing loop
        while(exit == 'y' || exit == 'Y'); 
        
   }

}