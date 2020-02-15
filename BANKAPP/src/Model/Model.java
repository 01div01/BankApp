package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Model 
{
	String name=null;
	String accountno=null;
	String balance=null;
	String customerid=null;
	String password=null;
	String emailid=null;
	String raccountno=null;
	String url="jdbc:oracle:thin:@//localhost:1521/XE";
	String uname="SYSTEM";
	String pwd="system";
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet res=null;
		
		
		public Model()
		{
			try 
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection(url, uname, pwd);
			} 
			catch (Exception e) 
			{
				System.out.println("Loaded and Connected ");
			}
		}
		
		
		public boolean getLogin()
		{
			try 
			{
				pstmt=con.prepareStatement("SELECT * FROM BANKAPP WHERE CUSTOMERID=? AND PASSWORD=?");
				pstmt.setString(1,customerid);
				pstmt.setString(2,password);
				res=pstmt.executeQuery();
				System.out.println("querry executed");
				
				if(res.next()==false)
				{
					
					return false;
					
				}
				else
				{
					accountno=res.getString(2);
					return true;
				}
			} 
			catch (SQLException e) 
			{
				System.out.println("if part not executed");
			}
			return false;
		}
		
		
		public boolean Balance()
		{
			try 
			{
				pstmt=con.prepareStatement("SELECT * FROM BANKAPP WHERE ACCOUNTNO=?");
				pstmt.setString(1,accountno);
			
				res=pstmt.executeQuery();
				System.out.println("querry executed");
				
				if(res.next()==false)
				{
					
					return false;
					
				}
				else
				{
					balance=res.getString(3);
					return true;
				}
			} 
			catch (SQLException e) 
			{
				System.out.println("if part not executed");
			}
			return false;
		}
		
		public boolean chPaswword()
		{
			try 
			{
				pstmt=con.prepareStatement("UPDATE BANKAPP SET PASSWORD=? WHERE ACCOUNTNO=?");
				pstmt.setString(1,password);
				pstmt.setString(2,accountno);
			
				int num=pstmt.executeUpdate();
				System.out.println("querry executed");
				
				if(num==0)
				{
					
					return false;
					
				}
				else
				{
					return true;
				}
			} 
			catch (SQLException e) 
			{
				System.out.println("if part not executed");
			}
			return false;
			
		}
		
		
		public boolean transfer(String amount)
		{
			
			try 
			{
				pstmt=con.prepareStatement("UPDATE BANKAPP SET BALANCE=BALANCE-? WHERE ACCOUNTNO=?");
				pstmt.setString(1,amount);
				pstmt.setString(2,accountno);
				int num=pstmt.executeUpdate();
				
				
				pstmt=con.prepareStatement("INSERT INTO BANKAPPSTMT VALUES(?,?)");
				amount=amount.concat("dr");
				pstmt.setString(1,accountno);
				pstmt.setString(2,amount);
				pstmt.executeUpdate();
				System.out.println("querry executed");
				if(num==0)
				{
					
					return false;
					
				}
				else
				{
					return true;
				}
			} 
			catch (SQLException e) 
			{
				System.out.println("if part not executed");
			}
			return false;
			
		}
		
		
		public boolean WBtransfer(String amount)
		{
			try 
			{
				//Statement stmt=con.createStatement();
				//res=stmt.executeQuery("DELETE FROM BANKAPPSTMT");
				pstmt=con.prepareStatement("SELECT * FROM BANKAPP WHERE ACCOUNTNO=?");
				pstmt.setString(1,raccountno);
				res=pstmt.executeQuery();
				System.out.println("R querry executed");
				if(res.next()==true)
				{
				
						//deduction
						pstmt=con.prepareStatement("UPDATE BANKAPP SET BALANCE=BALANCE-? WHERE ACCOUNTNO=?");
						pstmt.setString(1,amount);
						pstmt.setString(2,accountno);
						int num=pstmt.executeUpdate();
						
						//addition
						pstmt=con.prepareStatement("UPDATE BANKAPP SET BALANCE=BALANCE+? WHERE ACCOUNTNO=?");
						pstmt.setString(1,amount);
						pstmt.setString(2,raccountno);
						int num1=pstmt.executeUpdate();
						
						
						pstmt=con.prepareStatement("INSERT INTO BANKAPPSTMT VALUES(?,?)");
						String amount1=amount;
						amount=amount.concat("Dr");
						pstmt.setString(1,accountno);
						pstmt.setString(2,amount);
						pstmt.executeUpdate();
						System.out.println("querry executed");
						
						pstmt=con.prepareStatement("INSERT INTO BANKAPPSTMT VALUES(?,?)");
						amount=amount1;
						amount=amount.concat("Cr");
						pstmt.setString(1,raccountno);
						pstmt.setString(2,amount);
						pstmt.executeUpdate();
						System.out.println("WB querry executed");
						if(num==0 && num1==0)
						{
							
							return false;
							
						}
						else
						{
							return true;
						}
				}
				else
				{
					return false;
				}
			} 
			catch (SQLException e) 
			{
				System.out.println("if part not executed");
			}
			
			return false;
		}
		
		
		
		public ArrayList getStmt()
		{
			ArrayList al=new ArrayList();
			try 
			{
				
				pstmt=con.prepareStatement("SELECT *FROM BANKAPPSTMT WHERE ACCOUNTNO=?");
				pstmt.setString(1,accountno);
			
				res=pstmt.executeQuery();
				System.out.println("querry executed");
				while(res.next()==true)
				{
					String temp=res.getString(2);
					al.add(temp);
				
				}
			}
			catch (SQLException e) 
			{
				System.out.println("if part not executed");
			}
			
			return al;
		
		}
		
		
		public boolean applyLoan()
		{
			try 
			{
				pstmt=con.prepareStatement("SELECT * FROM BANKAPP WHERE ACCOUNTNO=?");
				pstmt.setString(1,accountno);
			
				res=pstmt.executeQuery();
				System.out.println("querry executed");
				
				if(res.next()==false)
				{
					
					return false;
					
				}
				else
				{
					name=res.getString(1);
					return true;
				}
			} 
			catch (SQLException e) 
			{
				System.out.println("if part not executed");
			}
			return false;
		}
		
		
		
		
		public boolean forgetPwd(String emailid)
		{
			try 
			{
				System.out.println(emailid);
				pstmt=con.prepareStatement("UPDATE BANKAPP SET PASSWORD=? WHERE EMAILID=?");
				pstmt.setString(1,password);
				pstmt.setString(2,emailid);
				
				int num=pstmt.executeUpdate();
				System.out.println("querry executed");
				
				if(num==0)
				{
					
					return false;
					
				}
				else
				{
					return true;
				}
			} 
			catch (SQLException e) 
			{
				System.out.println("if part not executed");
			}
			return false;
			
		}
		

		
		public void setRes(ResultSet res) {
			this.res = res;
		}
		public String geRes() {
			return name;
		}
		
		

		public void setName(String name) {
			this.name = name;
		}
		

		public void setAccountno(String accountno) {
			this.accountno = accountno;
		}

		
		public void setRAccountno(String raccountno) {
			this.raccountno = raccountno;
		}
		

		public void setBalance(String balance) {
			this.balance = balance;
		}


		public void setCustomerid(String customerid) {
			this.customerid = customerid;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public void setEmailid(String emailid) {
			this.emailid = emailid;
		}
		

		public String getName() {
			return name;
		}


		public String getAccountno() {
			return accountno;
		}

		
		public String getRAccountno() {
			return raccountno;
		}
		

		public String getBalance() {
			return balance;
		}


		public String getCustomerid() {
			return customerid;
		}


		public String getPassword() {
			return password;
		}


		public String getEmailid() {
			return emailid;
		}	
}
