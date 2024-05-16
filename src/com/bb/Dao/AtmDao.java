package com.bb.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.bb.Beans.CardDetails;

public class AtmDao 
{
	
	public int deposite(CardDetails cd) 
	{
		int k=0;
		
		
		try(Connection con = DBConnection.getConnection();) {
			
			PreparedStatement ps = con.prepareStatement("select cardnumber,pin from bank where cardnumber=?" );
			
			ps.setInt(1, cd.getCardNumber());
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				Integer cardNumber = rs.getInt(1); Integer pin = rs.getInt(2);
				
				if(cd.getPin().equals(pin))
				{
					PreparedStatement ps1 = con.prepareStatement("update Bank set balance=balance+? where cardnumber=? AND pin=?");
					
					ps1.setInt(1, cd.getAmount()); ps1.setInt(2, cd.getCardNumber()); ps1.setInt(3, cd.getPin());
					
					k = ps1.executeUpdate();
					
					
				}else System.out.println(" Enter pin is wrong..");
				
				
				
			}else {System.out.println(" Enter card number is wrong check your card number");}
			
			
			
			
		
		
		} catch (SQLException e) 
		{
		
			e.getMessage(); System.out.println(" Database error connection...");
			
		}
		
		
		
		
		return k;
	}
	

	
	
	public int withdraw(CardDetails cd) 
	{
		int k=0;
		
		
		try(Connection con = DBConnection.getConnection();) {
			
			PreparedStatement ps = con.prepareStatement("select cardnumber,pin,balance from bank where cardnumber=?" );
			
			ps.setInt(1, cd.getCardNumber());
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				Integer cardNumber = rs.getInt(1); Integer pin = rs.getInt(2); Integer balance = rs.getInt(3);
				
				if(cd.getPin().equals(pin))
				{
					if(balance>=cd.getAmount())
					{
					
					PreparedStatement ps1 = con.prepareStatement("update Bank set balance=balance-? where cardnumber=? AND pin=?");
					
					ps1.setInt(1, cd.getAmount()); ps1.setInt(2, cd.getCardNumber()); ps1.setInt(3, cd.getPin());
					
					k = ps1.executeUpdate();
					} else System.out.println("  Insufficient fund...");
					
				}else System.out.println(" Enter pin is wrong..");
				
				
				
			}else {System.out.println(" Enter card number is wrong check your card number");}
			
			
			
			
		
		
		} catch (SQLException e) 
		{
		
			e.getMessage(); System.out.println(" Database error connection...");
			
		}
		
		
		
		
		return k;
	}

	
	public CardDetails checkBalance(CardDetails cd) 
	{
		int k=0;
		
		
		try(Connection con = DBConnection.getConnection();) {
			
			PreparedStatement ps = con.prepareStatement("select cardnumber,pin from bank where cardnumber=?" );
			
			ps.setInt(1, cd.getCardNumber());
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				Integer cardNumber = rs.getInt(1); Integer pin = rs.getInt(2);
				
				System.out.println("pin:"+pin);
				System.out.println(" pin"+cd.getPin());
				if(cd.getPin().equals(pin))
				{
					PreparedStatement ps1 = con.prepareStatement("select balance from bank where cardnumber=? AND pin=?");
					
					 ps1.setInt(1, cd.getCardNumber()); ps1.setInt(2, cd.getPin());
					
					ResultSet rs1 = ps1.executeQuery();
					
					if(rs1.next())  cd.setAmount(rs1.getInt(1)); 					
					
				}else System.out.println(" Enter pin is wrong..");
				
				
				
			}else {System.out.println(" Enter card number is wrong check your card number");}
			
			
			
			
		
		
		} catch (Exception e) 
		{
		
			e.printStackTrace(); System.out.println(" Database error connection...");
			
		}
		
		
		
		
		return cd;
	}

	
	
	
	
	public int changePin(CardDetails cd) 
	{
		int k=0;
		
		
		try(Connection con = DBConnection.getConnection();) {
			
			PreparedStatement ps = con.prepareStatement("select cardnumber,pin from bank where cardnumber=?" );
			
			ps.setInt(1, cd.getCardNumber());
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				Integer cardNumber = rs.getInt(1); Integer pin = rs.getInt(2);
				
				
				if(cd.getPin().equals(pin))
				{
					Scanner s = new Scanner(System.in);
					System.out.print(" Enter new Pin");  
					Integer newPin = Integer.parseInt(s.nextLine());
					
					PreparedStatement ps1 = con.prepareStatement("update bank set pin=? where cardnumber=?");
					
					  ps1.setInt(1, newPin);ps1.setInt(2, cd.getCardNumber());
					
					   k = ps1.executeUpdate();
						
				}else System.out.println(" Enter pin is wrong..");
				
				
				
			}else {System.out.println(" Enter card number is wrong check your card number");}
			
			
			
			
		
		
		} catch (Exception e) 
		{
		
			e.printStackTrace(); System.out.println(" Database error connection...");
			
		}
		
		
		
		
		return k;
	}

	
	
	
	
	
	
	
	
	
	

}
