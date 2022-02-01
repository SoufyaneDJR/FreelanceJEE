package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.UserBean;

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
	
	public UserBean validate(UserBean loginBean) throws SQLException
	{
		UserBean User = null;
		
		loadDriver(dbDriver);
		Connection con = getConnection();
		String sql = "select * from USERS where email = ? and password = ?";
		PreparedStatement ps;
		
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, loginBean.getEmail());
		ps.setString(2, loginBean.getPassword());
		ResultSet rs = ps.executeQuery();
		
		User = new UserBean();
		while (rs.next()) {
			User.setUser_id(rs.getInt("user_id"));
			User.setEmail(rs.getString("email"));
			User.setFirstname(rs.getString("firstname"));
			User.setLastname(rs.getString("lastname"));
			User.setPassword(rs.getString("password"));
			User.setCreationDate(rs.getDate("creationdate"));
			User.setStatus(rs.getString("status"));
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return User;
	}
}
