package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.UserBean;

public class RegisterDao {

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
	public UserBean returnUserWithId(int user_id) throws SQLException{
		
		UserBean User = null;
		
		loadDriver(dbDriver);
		Connection con = getConnection();
		String sql = "select * from USERS where user_id= ?";
		PreparedStatement ps;
		
		try {
		ps = con.prepareStatement(sql);
		ps.setInt(1, user_id);
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
	

	public UserBean returnUserWithId(String userEmail) throws SQLException{
		
		UserBean User = null;
		
		loadDriver(dbDriver);
		Connection con = getConnection();
		String sql = "select * from USERS where email = ?";
		PreparedStatement ps;
		
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, userEmail);
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
	
	public boolean checkUniqueEmail(UserBean newUser) throws SQLException {
		
		boolean unique = true;
		
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		String sql = "select * from USERS where email = ?";
		PreparedStatement ps;
		
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, newUser.getEmail());
		ResultSet rs = ps.executeQuery();
		unique = ! rs.next();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return unique;
	}
	
	public UserBean insert(UserBean newUser) throws SQLException
	{
		boolean unique = checkUniqueEmail(newUser);
		
		UserBean result ;
		if (unique) {
			
			loadDriver(dbDriver);
			Connection con = getConnection();
			
			String sql = "insert into users (email,firstname,lastname,password,status,creationDate) values (?,?,?,?,?,?)";
			
			PreparedStatement ps;
			try {
			ps = con.prepareStatement(sql);
			ps.setString(1, newUser.getEmail());
			ps.setString(2, newUser.getFirstname());
			ps.setString(3, newUser.getLastname());
			ps.setString(4, newUser.getPassword());
			ps.setString(5, newUser.getStatus());
			ps.setDate(6, newUser.getCreationDate());
			
			ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Select user with his USER ID :
			result = returnUserWithId(newUser.getEmail());
			return result;
		} else {
			return null;
		}
		
	}
}
