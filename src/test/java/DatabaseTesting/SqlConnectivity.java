package DatabaseTesting;

import java.sql.Connection;   import java.sql.DriverManager;     import java.sql.ResultSet;
import java.sql.SQLException; import java.sql.Statement;         import org.testng.annotations.Test;

public class SqlConnectivity 
{
	@Test
	public void testDB() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver is Loaded");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium","root","Poojaavi@15");
		System.out.println("Connected to MySqlDB");
		Statement smt=conn.createStatement();
//		smt.executeUpdate("Insert into selenium_users values ('Ravi','ravi@gmail.com')");
		ResultSet rs=smt.executeQuery("Select * from selenium_users");

		System.out.println("Records of selenium_users table: \n"+"FIRST_NAME  |"+"    EMAIL  ");
		while(rs.next())
		{
			String col1=rs.getString(1);
			String col2=rs.getString(2);

			System.out.println(col1+"     "+col2);
		}
		int size=rs.getFetchSize();
		System.out.println("Deleting Specific Record");
		
		while(rs.next())
		{
			if(rs.getString(1)=="Ravi")
			{
//				rs.deleteRow();
				smt.executeUpdate("delete from selenium_users where first_name='Ravi'");
				smt.executeQuery("commit");

//				break;
			}
		}

		System.out.println("Records after deletion");
		ResultSet rs1=smt.executeQuery("Select * from selenium_users");

		while(rs1.next())
		{
			String col1=rs1.getString(1);
			String col2=rs1.getString(2);
			System.out.println(col1+"     "+col2);

		}

	}

}
