package com.electricityBilling.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.electricityBilling.model.electricityBilling;

public class electricityBillingDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/electricityBillingdb";
	private String jdbcUserName = "root";
	private String jdbcPassword = "root";
	
	
	private static final String INSERT_USER_SQL = "INSERT INTO Users(username, password_hash, email, contact_number, address, country, created_at) VALUES "+ "(?,?,?,?,?,?,?);";
	private static final String SELECT_USER_BY_ID = "SELECT * FROM Users WHERE user_id = ?;";
	private static final String SELECT_ALL_USERS = "SELECT * FROM Users;";
	private static final String DELETE_USERS_SQL = "DELETE FROM Users WHERE user_id = ?;";
	private static final String UPDATE_USERS_SQL = "UPDATE Users SET username = ?, password_hash = ?, email = ?, contact_number = ?, address = ?, country = ?, created_at = ? WHERE user_id = ?;";
	
//	ELECTRICITY USAGE:
	
	private static final String INSERT_ELECTRICITY_USAGE = "INSERT INTO Electricity_Usage(usage_id,user_id, units_consumed, start_date, end_date) VALUES "+ "(?,?,?,?,?);";
	private static final String SELECT_USAGE_BY_ID = "SELECT * FROM Electricity_Usage WHERE usage_id = ?;";
	private static final String SELECT_ALL_USAGE  = "SELECT * FROM Electricity_Usage;";
	private static final String UPDATE_ELECTRICITY_USAGE = "UPDATE Electricity_Usage SET usage_id = ?, units_consumed = ?, start_date = ?, end_date = ? WHERE usage_id = ?;";
	
//	BILLING TABLE:
	
	private static final String INSERT_BILLING_SQL = "INSERT INTO Billing(bill_id, usage_id, user_id, units_consumed, rate_per_unit, total_amount, billing_date, due_date) VALUES "+ "(?,?,?,?);";
	private static final String SELECT_BILLING_BY_ID = "SELECT * FROM Billing WHERE billing_id = ?;";
	private static final String SELECT_ALL_BILLING  = "SELECT * Billing;";
	private static final String UPDATE_BILLING_SQL = "UPDATE Payments SET bill_id = ?, usage_id = ?, user_id = ?, units_consumed = ?, rate_per_unit = ?, total_amount = ?, billing_date = ?, due_date = ?  WHERE usage_id = ?;";
	
//	PAYMRNTS TABLE:
	
	private static final String INSERT_PAYMENTS_SQL = "INSERT INTO Payments(payment_id, bill_id, user_id,  amount_paid, payment_date, payment_method, transaction_id) VALUES "+ "(?,?,?,?);";
	private static final String SELECT_PYMT_BY_ID = "SELECT * FROM Payments WHERE payment_id = ?;";
	private static final String SELECT_ALL_PYMTS  = "SELECT * Payments;";
	private static final String UPDATE_PYMT_SQL = "UPDATE Payments SET payment_id = ?, bill_id = ?, amount_paid = ?, payment_date = ?, payment_method = ?, transaction_id = ?  WHERE usage_id = ?;";
	
//	RECEIPTS TABLE:
	
	private static final String INSERT_RECEIPTS_SQL = "INSERT INTO Receipts(receipt_id, payment_id, user_id, receipt_date, receipt_amount) VALUES "+ "(?,?,?,?,?);";
	private static final String SELECT_RECEIPT_BY_ID = "SELECT * FROM Receipts WHERE receipt_id = ?;";
	private static final String SELECT_ALL_RECEIPTS  = "SELECT * FROM Receipts;";
	private static final String UPDATE_RECEIPT_SQL = "UPDATE Receipts SET receipt_id = ?, payment_id = ?, user_id = ?, receipt_date = ?, receipt_amount = ? WHERE receipt_id = ?;";
	
	
	public electricityBillingDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Connection getConnection() {
		
		Connection connection = null;
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection= DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
		}
		
		catch(SQLException | ClassNotFoundException e )
		{
			e.printStackTrace();
		}
		
		catch(Exception e )
		{
			e.printStackTrace();
		}
		
		return connection;
	}
	
	
	public void insertUser(electricityBilling user)
	{
		electricityBillingDAO dao = new electricityBillingDAO();
		
		try(Connection connection = dao.getConnection()) 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL);
			preparedStatement.setString(1, user.getUser_name());
			preparedStatement.setString(2, user.getPassword_hash());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getAddress());
			preparedStatement.setString(6, user.getCountry());
			
			preparedStatement.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public electricityBilling selectUser(int id) {
		
		electricityBilling user = new electricityBilling();
		electricityBillingDAO dao = new electricityBillingDAO();
		
		try(Connection connection = dao.getConnection()) 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				user.setUser_id(id);
				user.setUser_name(resultSet.getString("username"));
				user.setPassword_hash(resultSet.getString("password_hash"));
				user.setContact_number(resultSet.getString("contact_number"));
				user.setAddress(resultSet.getString("address"));
				user.setCountry(resultSet.getString("country"));
				
			}
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	return user;
		
	}
	
	public List<electricityBilling> selectAllUsers(){
		List<electricityBilling> users = new ArrayList<electricityBilling>();
		electricityBillingDAO dao = new electricityBillingDAO();
		
		try(Connection connection = dao.getConnection()) 
		{
			PreparedStatement preparedstatement = connection.prepareStatement(SELECT_ALL_USERS);
			ResultSet resultSet = preparedstatement.executeQuery();
			
			while(resultSet.next()) {
				int id =resultSet.getInt("user_id");
				String user_name = resultSet.getString("username");
				String password = resultSet.getString("password_hash");
				String Contact_number = resultSet.getString("contact_number");
				String Address = resultSet.getString("address");
				String Country = resultSet.getString("country");
				
				users.add(new electricityBilling(id, user_name, password, Contact_number, Address, Country));
			
		}
			}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}	
		return users;
	}
	
	public boolean deleteUser(int id) {
		boolean status =false;
		electricityBillingDAO dao = new electricityBillingDAO();
		
		try(Connection connection = dao.getConnection()) 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
			preparedStatement.setInt(1, id);
			status = preparedStatement.execute();
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
}
