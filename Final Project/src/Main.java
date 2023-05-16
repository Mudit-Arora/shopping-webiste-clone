import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		LoginScreen gui = new LoginScreen();
		Connection c = null;
		Statement stmt = null;
		try 
		{
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/project",
					"postgres", "muditarora");
		} catch(Exception ex) {
			ex.printStackTrace();
			System.err.println(ex.getClass().getName()+": "+ ex.getMessage());
			System.exit(0);
		}
		/*
			try 
			{
				stmt = c.createStatement();
				String sql = "CREATE TABLE EMP" +
				"(firstname TEXT NOT NULL," +
				"lastname TEXT NOT NULL," +
				"username TEXT NOT NULL," +
				"password TEXT NOT NULL," +
				"email TEXT NOT NULL," +
				"position TEXT NOT NULL)";
				stmt.execute(sql);
				stmt.close();
				c.close();
			} catch(Exception ex) {
				ex.printStackTrace();
				System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
				System.exit(0);
			}
			
		try 
		{
			stmt = c.createStatement();
			String sql = "CREATE TABLE CUST" +
			"(firstname TEXT NOT NULL," +
			"lastname TEXT NOT NULL," +
			"username TEXT NOT NULL," +
			"password TEXT NOT NULL," +
			"email TEXT NOT NULL," +
			"address TEXT NOT NULL)";
			stmt.execute(sql);
			stmt.close();
			c.close();
		} catch(Exception ex) {
			ex.printStackTrace();
			System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
			System.exit(0);
		}
		
		try
		{
		stmt = c.createStatement();
		String sql = "CREATE TABLE CART" +
		"(Num INT NOT NULL," +
		"item TEXT NOT NULL," +
		"price TEXT NOT NULL," +
		"quantity INT NOT NULL)";
		stmt.execute(sql);
		stmt.close();
		c.close();
		} catch(Exception ex) {
		ex.printStackTrace();
		System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
		System.exit(0);
		}
		*/
	}
}
	

