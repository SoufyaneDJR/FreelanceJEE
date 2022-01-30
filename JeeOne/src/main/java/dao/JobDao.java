package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import bean.JobBean;

public class JobDao {

	private String dbUrl = "jdbc:mysql://localhost:3306/JEE?serverTimezone=UTC";
	private String dbUname = "root";
	private String dbPassword = "soufyane";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	private static final String INSERT_JOB = "INSERT INTO JOBS" + "(user_id,job_title,job_description,job_category,job_skills,job_size,job_lenght,job_experience,job_budget,job_date,job_status) VALUES "
			+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_JOB_BY_ID = "SELECT * FROM JOBS WHERE JOB_ID = ? AND USER_ID = ?;";
	private static final String SELECT_ALL_JOBS_BY_USER_ID = "SELECT * FROM JOBS WHERE USER_ID = ?;";
	private static final String DELETE_JOB = "DELETE FROM JOBS WHERE JOB_ID = ? AND USER_ID = ? ;";
	private static final String UPDATE_JOB = "UPDATE JOBS SET job_title = ? ,job_description = ?,job_size = ?,job_lenght = ?,job_experience = ?,job_status = ? WHERE JOB_ID = ? AND USER_ID = ?;";
	public JobDao() {
	}

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
	//select one Job 
	public JobBean selectJob(int job_id,int user_id) {
		JobBean job = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_JOB_BY_ID);) {
			preparedStatement.setInt(1, job_id);
			preparedStatement.setInt(2, user_id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String job_title = rs.getString("job_title");
				String job_description = rs.getString("job_description");
				int job_category = rs.getInt("job_category");
				String job_skills = rs.getString("job_skills");
				String job_size = rs.getString("job_size");
				String job_lenght = rs.getString("job_lenght");
				String job_experience = rs.getString("job_experience");
				int job_budget = rs.getInt("job_budget");
				Timestamp job_date = rs.getTimestamp("job_date");
				String job_status = rs.getString("job_status");
				job = new JobBean(job_id,user_id,job_title,job_description,job_category,job_skills,job_size,job_lenght,job_experience,job_budget,job_date,job_status);
				
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return job;
	}

	// Select all jobs
	public List<JobBean> selectAllJobs(int user_id) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<JobBean> jobs = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_JOBS_BY_USER_ID);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			preparedStatement.setInt(1, user_id);
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int job_id = rs.getInt("job_id");
				String job_title = rs.getString("job_title");
				String job_description = rs.getString("job_description");
				int job_category = rs.getInt("job_category");
				String job_skills = rs.getString("job_skills");
				String[] skills = job_skills.split(".");
				System.out.println(skills);
				String job_size = rs.getString("job_size");
				String job_lenght = rs.getString("job_lenght");
				String job_experience = rs.getString("job_experience");
				int job_budget = rs.getInt("job_budget");
				Timestamp job_date = rs.getTimestamp("job_date");
				String job_status = rs.getString("job_status");
				jobs.add(new JobBean(job_id,user_id,job_title,job_description,job_category,job_skills,job_size,job_lenght,job_experience,job_budget,job_date,job_status));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return jobs;
	}

	public void insertJob(JobBean Job) throws SQLException {
		System.out.println(INSERT_JOB);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_JOB)) {
			preparedStatement.setInt(1, Job.getUser_id());
			preparedStatement.setString(2, Job.getJob_title());
			preparedStatement.setString(3, Job.getJob_description());
			preparedStatement.setInt(4, Job.getJob_category());
			preparedStatement.setString(5,Job.getJob_skills());
			preparedStatement.setString(6, Job.getJob_size());
			preparedStatement.setString(7, Job.getJob_lenght());
			preparedStatement.setString(8,Job.getJob_experience());
			preparedStatement.setInt(9, Job.getJob_budget());
			preparedStatement.setObject(10, Job.getJob_date());
			preparedStatement.setString(11,Job.getJob_status());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	// Delete a Job 
	public boolean deleteJob(int job_id, int user_id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_JOB);) {
			statement.setInt(1, job_id);
			statement.setInt(2, user_id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	// Update a Job
	public boolean updateJob(JobBean job) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_JOB);) {
			System.out.println("updated Job :"+statement);
			statement.setString(1, job.getJob_title());
			statement.setString(2, job.getJob_description());
			statement.setString(3, job.getJob_size());
			statement.setString(4, job.getJob_lenght());
			statement.setString(5,job.getJob_experience());
			statement.setString(6, job.getJob_status());
			statement.setInt(7, job.getJob_id());
			statement.setInt(8, job.getUser_id());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
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
