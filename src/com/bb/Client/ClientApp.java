package com.bb.Client;

import java.util.Scanner;

import com.bb.Beans.CardDetails;

public class ClientApp 
{
	
	
	public static void main(String[] args) 
	{
		
		Scanner s = new Scanner(System.in);

		System.out.println("********Welcome To ATM **********\n");

		while (true) {

			int flag = 0;
			System.out.println(
					"\n Choose Below Option.... \t \n1.Deposite Amount  \t \n2.Withdraw Amount \t \n3.Check balance \t \n4.  Change pin\t \n5.  Exit \t \n Enter Your choice:- \n");
			
			Integer choice = Integer.parseInt(s.nextLine());
			
			switch (choice) {

			case 1: 
			{
				
				int k = new AtmService().performDeposite();
				if(k>0) System.out.println(" Transaction Sucessfully Completed....");
				else System.err.println(" transaction failed....");

			}break; // case 1
			
			case 2: 
			{
				
			int k=	new AtmService().performWithdraw();
			if(k>0) System.out.println(" Transction sucessfully compled....");
			else System.err.println(" transaction failed....");
				
			} break ; // case 2 
			
			
			case 3: 
			{
				
				CardDetails balance = new AtmService().checkBalance();
			 if(balance.getAmount()!=null)	System.out.println(" Your Account balance:"+balance.getAmount());
			 else System.err.println(" transaction filed..");
				
			} break; // case 3
			
			case 4:{
				
				int k = new AtmService().changePin();
				if(k>0) System.out.println(" pin change Sucessfully...");
				else System.err.println(" transaction faild..");
				
				
			} break;
			
			
			
        case 5:{
				
				flag=1;  System.out.println(" Thank you for using our Atm."); System.exit(0);
				
			} 
			
			
			
			
			default: System.out.println("Enter choice is wrong..");
			
			}//  switch

			
			if(flag>0) break;
		
	           }//  while
	s.close();
	}
}
