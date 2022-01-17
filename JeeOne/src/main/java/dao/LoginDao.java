package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.LoginBean;

public class LoginDao {

	private String dbUrl = "jdbc:mysql://localhost:3306/JEE?serverTimezone=UTC";
	private String dbUname = "root";
	private String dbPassword = "soufyane";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException
	{
		Connection con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		return con;
	}
	
	public boolean validate(LoginBean loginBean) throws SQLException
	{
		boolean status = false;
		
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		String sql = "select * from USERS where email = ? and password = ?";
		PreparedStatement ps;
		
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, loginBean.getEmail());
		ps.setString(2, loginBean.getPassword());
		ResultSet rs = ps.executeQuery();
		status = rs.next();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
}
