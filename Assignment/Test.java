

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Test {


	static Scanner sc=new Scanner(System.in);
	public void createTable() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","root");
		java.sql.Statement st= con.createStatement();
		st.execute("create table student(student_id int,student_name Varchar(20),class int)");
		System.out.println("table created");
	}
	public void insertValues() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
	PreparedStatement prep=con.prepareStatement("insert into student values(?,?,?)");
	System.out.println("enter id");
	int id=sc.nextInt();
	System.out.println("enter name");
	String name=sc.next();
	System.out.println("enter class");
	int Class=sc.nextInt();
	prep.setInt(1, id);
	prep.setString(2,name);
	prep.setInt(3, Class);
	prep.execute();
	System.out.println("values inserted");	
	}
	public void retriveData() throws SQLException
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		PreparedStatement prep=con.prepareStatement("select * from student where student_id=?");
		System.out.println("enter id");
		int id=sc.nextInt();
		prep.setInt(1, id);
		ResultSet rs= prep.executeQuery();
		while(rs.next())
		{
			int id1=rs.getInt(1);
			String name1=rs.getString(2);
			int Class=rs.getInt(3);
			System.out.println(id1);
			System.out.println(name1);
			System.out.println(Class);
		}
	}
	public void deleteData() throws SQLException
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		PreparedStatement prep=con.prepareStatement("delete from student where student_id=?");
		System.out.println("enter id");
		int id=sc.nextInt();
		prep.setInt(1, id);
		prep.execute();
		System.out.println("data deleted");
	}
	public void updateData() throws SQLException
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		PreparedStatement prep=con.prepareStatement("update student set student_name=? where student_id=?");
		System.out.println("enter id");
		int id=sc.nextInt();
		prep.setInt(2, id);
		System.out.println("enter new name");
		String name=sc.next();
		prep.setString(1, name);
		prep.execute();
		System.out.println("data updated");
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Demo1 d1=new Demo1();
		for(;;)
		{
			System.out.println("1.createtable 2.insertvalue 3.retrivedata 4.deletedata 5.updatedata");
			switch(sc.nextInt())
			{
			case 1:
				d1.createTable();
				break;
			case 2:
				d1.insertValues();
				break;
			case 3:
				d1.retriveData();
				break;
			case 4:
				d1.deleteData();
				break;
			case 5:
				d1.updateData();
				break;	
			}
		}	
	}
}
