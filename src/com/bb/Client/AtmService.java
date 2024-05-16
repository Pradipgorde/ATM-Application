package com.bb.Client;

import java.util.Scanner;

import com.bb.Beans.CardDetails;
import com.bb.Dao.AtmDao;

public class AtmService
{
	
	public int performDeposite()
	{
		int k=0;
		
		CardDetails carddetails = new CardDetails();
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter card number:");
		
		try {
		
		Integer cardNumber = Integer.parseInt(s.nextLine());		
	           
		
		System.out.print("Enter pin:"); Integer pin = Integer.parseInt(s.nextLine());
		System.out.print("Enter Deposie Amount:"); Integer amount=Integer.parseInt(s.nextLine());
		
		if(amount<0) System.out.println(" Amount cant be negative");
		else {
		carddetails.setAmount(amount);
		
		 carddetails.setCardNumber(cardNumber); carddetails.setPin(pin);
		 
		 k = new AtmDao().deposite(carddetails);
		}
		
		}catch(Exception e) { System.err.println(" Enter digit only...");}
		 
		 s.close();
		
		return k;
		
		
	}
	
	public int performWithdraw()
	{
		
		int k=0;
		
		CardDetails carddetails = new CardDetails();
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter card number:");
		
		try {
		
		Integer cardNumber = Integer.parseInt(s.nextLine());		
	           
		
		System.out.print("Enter pin:"); Integer pin = Integer.parseInt(s.nextLine());
		System.out.print("Enter Withdraw Amount:"); Integer amount=Integer.parseInt(s.nextLine());
		
		if(amount<0) { System.out.println(" Amount cant be negative");}
		else {
		
		carddetails.setAmount(amount);
		
		 carddetails.setCardNumber(cardNumber); carddetails.setPin(pin);
		 
		 k = new AtmDao().withdraw(carddetails);
		}
		
		}catch(Exception e) { System.err.println(" Enter Digit only .."); }
		
		 s.close();
		
		return k;
		}
	
	public CardDetails checkBalance()
	{
		
		
		CardDetails carddetails = new CardDetails();
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter card number:");
		
		try {
		
		Integer cardNumber = Integer.parseInt(s.nextLine());		
	           
		
		System.out.print("Enter pin:"); Integer pin = Integer.parseInt(s.nextLine());
		
		
		
		
		 carddetails.setCardNumber(cardNumber); carddetails.setPin(pin);
		 
		 carddetails = new AtmDao().checkBalance(carddetails);
		 
		
		}catch(Exception e) { System.err.println(" Enter Digit only .."); }
		 
		 s.close();
		
		return carddetails;	}

	
	public int changePin()
	{
		
		int k=0;
		
		CardDetails carddetails = new CardDetails();
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter card number:");
		
		try {
		
		Integer cardNumber = Integer.parseInt(s.nextLine());		
	           
		
		System.out.print("Enter old pin:"); Integer pin = Integer.parseInt(s.nextLine());
		
		
		
		
		 carddetails.setCardNumber(cardNumber); carddetails.setPin(pin);
		 
		 k = new AtmDao().changePin(carddetails);
		 
		
		}catch(Exception e) { System.err.println(" Enter Digit only .."); }
		 
		 s.close();
		
		return k;	}

	
	
	
	
	
	

}
