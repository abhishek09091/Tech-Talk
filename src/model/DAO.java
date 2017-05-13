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
	private PreparedStatement pst0,pst1,pst2,pst3;//,pst4;
	private Statement statement;
	
	
	public DAO(String dvr,String url,String name,String pass) throws Exception
	{
		connection =DBUtils.getConnection(dvr,url,name,pass);
		//insert a new user in the user table
		pst0=connection.prepareStatement("insert into user values(?,?,?)");
		// insert a new tech talk topic
		pst1=connection.prepareStatement("insert into techtalks(techTalkDate,title,description,speaker) values(?,?,?,?)");
		
		
		
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
		
		if(pst3 !=null)
			pst3.close();
		
		
		/*if(pst2 !=null)
			pst2.close();
		
		
		
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
			System.out.println("Inside add tech talk method");
			System.out.println("Values: "+title+speaker+description+sql);
			pst1.setDate(1, sql);
			pst1.setString(2, title);
			pst1.setString(3, description);
			pst1.setString(4, speaker);
			//preparedStatement.setDate(6,date);
			pst1.execute();
			System.out.println("after inserting into the table");
			String create = "CREATE TABLE "+ title + 
	                   "(serialNo int  auto_increment primary key, " +
	                   " empEmailId VARCHAR(200))"; 

	      statement.executeUpdate(create);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int getRegistrationAboutTechTalk(String empEmail,String tableName)
	{
		System.out.println("name of employee"+empEmail+"name of table"+tableName);
		try {
			ResultSet rs=connection.createStatement().executeQuery("select count(*) as total from "+tableName+" where empEmailId='"+empEmail+"'");
			int count=0;
			while(rs.next()){
				count=rs.getInt("total");
			}
			System.out.println(count);
			if(count==1)
			{
				return count;
			}
			else
			{
				return count;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public String registerUserInTable(String employeeEmail, String tableName) {
		// TODO Auto-generated method stub
		try {
			System.out.println("registerUserIn Table "+employeeEmail+" IN table"+tableName);
			pst3=connection.prepareStatement("insert into "+tableName+"(empEmailId) values(?)");
			pst3.setString(1,employeeEmail);
			boolean bool=pst3.execute();
			if(bool)
			{
				return "successfull";
			}
			else
			{
				return "unsuccessfull";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "unsuccessfull";
		
	}

	public String UnregisterUserInTable(String employeeEmail, String tableName) {
		// TODO Auto-generated method stub
		System.out.println("Un-registerUserIn Table "+employeeEmail+" IN table"+tableName);
		try {
			statement=connection.createStatement();
			int count=statement.executeUpdate("delete from "+tableName+" where empEmailId="+"'"+employeeEmail+"'");
			if(count>=0)
			{
				return "successfull";
			}
			else
			{
				return "unsuccessfull";
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return "unsuccessfull";
		
	}
	
	
	
	}
	



