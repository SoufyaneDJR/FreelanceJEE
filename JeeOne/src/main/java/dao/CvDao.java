package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import bean.CvBean;

/**
 * @author DJAIDER Soufyane
 *
 */
public class CvDao {

	private String dbUrl = "jdbc:mysql://localhost:3306/JEE?serverTimezone=UTC";
	private String dbUname = "root";
	private String dbPassword = "soufyane";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";

	private static final String INSERT_CV = "INSERT INTO CVS"
			+ "(user_id,firstname,Lastname,email,cv_category,cv_skills,cv_language,cv_hobbies,cv_title,cv_description,cv_project_title,cv_project_url) VALUES "
			+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_CV_BY_USER_ID = "SELECT * FROM CVS WHERE USER_ID = ?;";
	private static final String UPDATE_CV = "";

	public CvDao() {
	}

	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		return con;
	}

	// select one Cv
	public CvBean selectCv(int user_id) {
		CvBean cv = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CV_BY_USER_ID);) {
			preparedStatement.setInt(1, user_id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String cv_category = rs.getString("cv_category");
				String cv_skills = rs.getString("cv_skills");
				String cv_language = rs.getString("cv_language");
				String cv_hobbies = rs.getString("cv_hobbies");
				String cv_title = rs.getString("cv_title");
				String cv_description = rs.getString("cv_description");
				String cv_project_title = rs.getString("cv_project_title");
				String cv_project_url = rs.getString("cv_project_url");
				cv = new CvBean(user_id,firstname,lastname,email,cv_category,cv_skills,cv_language,cv_hobbies,cv_title,cv_description,cv_project_title,cv_project_url);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return cv;
	}

	public void insertCv(CvBean Cv) throws SQLException {
		System.out.println(INSERT_CV);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CV)) {
			preparedStatement.setInt(1, Cv.getUser_id());
			preparedStatement.setString(2, Cv.getFirstname());
			preparedStatement.setString(3, Cv.getLastname());
			preparedStatement.setString(4, Cv.getEmail());
			preparedStatement.setString(5, Cv.getCv_category());
			preparedStatement.setString(6, Cv.getCv_skills());
			preparedStatement.setString(7, Cv.getCv_language());
			preparedStatement.setString(8, Cv.getCv_hobbies());
			preparedStatement.setString(9, Cv.getCv_title());
			preparedStatement.setString(10, Cv.getCv_description());
			preparedStatement.setString(11, Cv.getCv_project_title());
			preparedStatement.setString(12, Cv.getCv_project_url());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	// Update a Cv
	/*
	 * public boolean updateCv(CvBean Cv) throws SQLException { boolean rowUpdated;
	 * try (Connection connection = getConnection(); PreparedStatement
	 * preparedStatement = connection.prepareStatement(UPDATE_CV);) {
	 * preparedStatement.setInt(1, Cv.getUser_id()); preparedStatement.setString(2,
	 * Cv.getFirstname()); preparedStatement.setString(3, Cv.getLastname());
	 * preparedStatement.setString(4, Cv.getEmail()); preparedStatement.setString(5,
	 * Cv.getCv_category()); preparedStatement.setString(6, Cv.getCv_skills());
	 * preparedStatement.setString(7, Cv.getCv_language());
	 * preparedStatement.setString(8, Cv.getCv_hobbies());
	 * preparedStatement.setString(9, Cv.getCv_title());
	 * preparedStatement.setString(10, Cv.getCv_description());
	 * preparedStatement.setString(11, Cv.getCv_project_title());
	 * preparedStatement.setString(12, Cv.getCv_project_url()); rowUpdated =
	 * preparedStatement.executeUpdate() > 0; } return rowUpdated; }
	 */

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
