package com.MIT.HMS_DJ.DBUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseConnectivity {

	

	public Connection conn=null;
	
	public void RegisterDriver() throws SQLException
	{
		Driver driver=new Driver();
		
		DriverManager.registerDriver(driver);
		
		try {
			
		 conn=DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333", "root", "root");
		}
		catch(Exception e)
		{
			
		}
	}
	public void ExecuteUpdate() throws SQLException 
	{
		 Statement stmt=conn.createStatement();
		 
	 //create Database
		 boolean resultDropDB=stmt.execute("Drop database DJ_HMS");
		  boolean resultCreateDB=stmt.execute("create database DJ_HMS");
		  int resultUse=stmt.executeUpdate("use DJ_HMS; ");
		  
	 //Create table
		// int resultDrop=stmt.executeUpdate("Drop table DJTable2; ");
		 
		 boolean resultCreate=stmt.execute("create table DJTable2(name varchar(20),number varchar(20), Address varchar(20));");
		// System.out.println(resultCreate);
				 if(resultCreate==false)
					 
					 System.out.println("Table Created");
				else
					 System.out.println("Sorry !!! Cant create Table ! ");
			

				int resultUpdate;
	 //Insert into table 
				 for(int i=1;i<=5;i++)
				 {
				 resultUpdate=stmt.executeUpdate("INSERT INTO DJtable2 (Name, number, Address) VALUES (\"Divya"+i+"\", \"98764\", \"bglr\");");
				 if(resultUpdate!=1)
				 {
					 System.out.println("Sorry !!! Cant insert into Table");
					 break;
				 }
					 
				 }
				 
		 //Display Table
				 ResultSet resultTable=stmt.executeQuery("Select * from DJtable2; ");
				 Boolean flag1=false;
				 while(resultTable.next())
				 {
					 System.out.println(resultTable.getString(1)+"\t"+resultTable.getString(2)+"\t"+resultTable.getString(3));
					 flag1=true;
				 }
				if(flag1==false) System.out.println("Sorry !!! Cant Find Data !");
				
		 //Select data with name:Divya3
		 ResultSet result=stmt.executeQuery("Select * from DJtable2 Where Name=\"Divya3\"; ");
		 Boolean flag=false;
		 while(result.next())
		 {
			 System.out.println("\n" +result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
			 flag=true;
		 }
		if(flag==true)
			 System.out.println("Data Found");
		else
			 System.out.println("Sorry !!! Cant Find Data !");

		}
	public void closeDB() throws SQLException
	{
	try {
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			conn.close();
			System.out.println("Conection Closed");
		}

	}
	
}
