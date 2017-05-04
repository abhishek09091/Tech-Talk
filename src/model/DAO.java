package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;




import pojos.Employee;
import pojos.TechTalk;




public class DAO {
	private Connection connection;
	private PreparedStatement pst0,pst1;//pst2,pst3,pst4;
	private Statement statement;
	
	
	public DAO(String dvr,String url,String name,String pass) throws Exception
	{
		connection =DBUtils.getConnection(dvr,url,name,pass);
		//insert a new user in the user table
		pst0=connection.prepareStatement("insert into user values(?,?,?)");
		// insert a new tech talk topic
		pst1=connection.prepareStatement("insert into techtalks(techTalkDate,title,description,speaker) values(?,?,?,?)");
		
		//pst2=connection.prepareStatement("select bal from bank_accounts where ac_no=?");
		//to withdraw the money from account
		//pst3=connection.prepareStatement("update bank_accounts set bal=bal-? where ac_no=?;");
		
		//pst4=connection.prepareStatement("update bank_accounts set bal=bal+? where ac_no=?;");
		
		//selecting all users
		statement=connection.createStatement();
	}
	
	public void cleanUp() throws SQLException
	{
		System.out.println("Clean Up..is done");
		if(connection != null)
			connection.close();
		
		if(pst0 != null)
			pst0.close();
		
		
		if(pst1 !=null)
			pst1.close();
		
		/*if(pst2 !=null)
			pst2.close();
		
		if(pst3 !=null)
			pst3.close();
		
		if(pst4 !=null)
			pst4.close();*/
		
	
	}

	
	
	
	
	
	
	
	
	//returning the list of all tech talks
	public  ArrayList<TechTalk> getTechTalk()
	{
		
		try {
			 statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("Select * from techtalks");
			ArrayList<TechTalk> arrayList=new ArrayList<TechTalk>();
			TechTalk techtalk=null;
			if(resultSet!=null)
			{
				while(resultSet.next())
				{
					int techTId=resultSet.getInt("techTalkId");
					Date techTDate=resultSet.getDate("techTalkDate");
					String title=resultSet.getString("title");
					String description=resultSet.getString("description");
					String speaker=resultSet.getString("speaker");
					
					
					techtalk=new TechTalk(techTId, techTDate, title, description, speaker);
					arrayList.add(techtalk);
				}
			}
			return arrayList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	//Verifying the User
	public Employee verifyUser(String employeeEmail, String employeePassword) {
		
		try {
			Employee employee = null;
			System.out.println("inside verifyUser");
			ResultSet rst=statement.executeQuery("select * from user where empEmail='"+employeeEmail+"'");
			if(rst.next())
			{
					System.out.println("Hi I m here");
					String employeeEmailUser=rst.getString("EmpEmail");
					String employeeName=rst.getString("EName");
					String employeePass=rst.getString("Password");
					employee=new Employee(employeeEmailUser, employeeName, employeePass);
					if(employeePassword.equals(employeePass))
					{
						
						return employee;
					}
					else
					{
						employee=null;
						return employee;
					}
			}
			else
			{
				return employee;
			}		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	
	//user registration
	public boolean registerUser(String employeeName, String employeeEmail,
			String employeePassword) {
		
		
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
		ResultSet rs=connection.createStatement().executeQuery("select * from user where empEmail="+"'"+employeeEmail+"'");
		
		if(rs.next()){
			
			return flag;
		
		}
		else{
				
				pst0.setString(1, employeeEmail);
				pst0.setString(2, employeeName);
				pst0.setString(3, employeePassword);
				if(pst0.executeUpdate()!=0)
				{
					 flag=true;
					 return flag;
					 
				}
				else
				{
					System.out.println("Some problem in registration");
				}
		}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return flag;
	}

		
	//Admin to insert a tech talk
	public void addTechTalk(String title, String speaker,String description, Date sql)
	{
		try {
			pst1.setDate(1, sql);
			pst1.setString(2, title);
			pst1.setString(3, description);
			pst1.setString(4, speaker);
			//preparedStatement.setDate(6,date);
			pst1.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	}
	



