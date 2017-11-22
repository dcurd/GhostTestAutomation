package utilities;

import java.security.Security;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;


public class DBUtils {
	// this is for SQLServer; similar set up would be for Oracle and MySql!
	// Let's have some fun!
	public String host = null;
	public int port = 0;
	public String databaseName = null;
	public String userName = null;
	public String password = null;
	public Connection root_connection = null;
	private static DBUtils instance = null;
	protected DBUtils(){
		
	}
	
	static public DBUtils getInstance(){
		if(instance == null){
			instance = new DBUtils();
		}
		return instance;
	}


	
	public Connection OpenConnection() throws Exception {
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(Exception ex){
			System.err.println("OpenConnection: Database Driver not found");
			ex.printStackTrace();
		}

		try{

			String url = "jdbc:microsoft:sqlserver://" + host + ":" + port + ":" + databaseName;
			root_connection = DriverManager.getConnection(url, userName, password);
			System.out.println("OpenConnection: Database connection Successful");
		}catch(SQLException e){
			System.err.println("OpenConnection: Database connection Failed");
		}

		return root_connection;
	}

	

	public void CloseConnection()
	{
		if(root_connection == null) return;
		try {
			root_connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet executeQuery(String query,Connection conn) throws SQLException
	{
		ResultSet rs = null;
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rs = stmt.executeQuery(query);
		return rs;
	}
	
	public void executeInsert(String query,Connection conn) throws SQLException
	{
		
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		stmt.execute(query);
				
	}

	public boolean isConnected()
	{
		if(root_connection == null) return false;
		try {
			if(this.root_connection.isClosed())
			{
				return false;
			}
			else
			{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection getConnection() {
		return root_connection;
	}

		public static void main(String[]args)
		{	
			DBUtils dbUtil = new DBUtils();
			try {
				dbUtil.OpenConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Database is" + (dbUtil.isConnected() ? "Connected." : "Not Connected"));
			dbUtil.CloseConnection();
		}

}

