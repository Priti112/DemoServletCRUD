package com.priti.code.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.priti.code.model.Customer;

public class CustomerDaoImpl implements CustomerDao {
	//this is an implementation class
	//here, we write all queries
	//this class is connect with the database

	//take sql as a string
	String sql;	
	//take connection
	//create connection object
	Connection connection;  
	
	String url = "jdbc:mysql://localhost:3306/customer_db";
	String username = "root";
	String password = "";
	
	
	//this is connect method
	//to open connection for execute query 
	//it use in all queries
	public void connect() throws SQLException {
		if(connection == null || connection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connection = DriverManager.getConnection(url, username, password);
		}
	}
	
	//this is disconnect method
	//to close connection after execute query
	//it use in all queries 
	public void disconnect() throws SQLException {
		if(connection != null && !connection.isClosed()) {
			connection.close();
		}
	}
    
	
	//this is insert method
	//to insert new data in database
	@Override
	public int insert(Customer customer) throws SQLException {
		//in insert, update, delete and getbyid we put question marks in values
	    //so, question mark means parameters and parameters means preparedStatement
		//that's why, we use PreparedSatement in our query
		sql = "insert into customer(name, gender, city, hobbies) values(?,?,?,?)";
		connect();
		PreparedStatement statement  = connection.prepareStatement(sql);
		statement.setString(1, customer.getName());
		statement.setString(2, customer.getGender());
		statement.setString(3, customer.getCity());
		statement.setString(4, customer.getHobbies());
		int n = statement.executeUpdate();
		disconnect();
		return n;
	}
    
	
	//this is update method
	//to update data from database
	//it works on particular id
	@Override
	public int update(Customer customer) throws SQLException {
		sql = "update customer set name = ?, gender = ?, city = ?, hobbies = ? where id = ?";
		connect();
		PreparedStatement statement  = connection.prepareStatement(sql);
		statement.setString(1, customer.getName());
		statement.setString(2, customer.getGender());
		statement.setString(3, customer.getCity());
		statement.setInt(4, customer.getId());
		statement.setString(5, customer.getHobbies());
		int n = statement.executeUpdate();
		disconnect();
		return n;
	}
    
	
	//this is delete method
	//to delete data from database
	//it also works on particular id
	@Override
	public int delete(int id) throws SQLException {
		sql = "delete from customer where id = ?";
		connect();
		PreparedStatement statement  = connection.prepareStatement(sql);
		statement.setInt(1, id);
		int n = statement.executeUpdate();
		disconnect();
		return n;
	}
    
	
	//this is list method
	//this method shows entier data from the database 
	@Override
	public List<Customer> listAllCustomer() throws SQLException {
		List<Customer> customerList = new ArrayList<Customer>();
		sql = "select * from customer";
		connect();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String gender = resultSet.getString("gender");
			String city = resultSet.getString("city");
			String hobbies = resultSet.getString("hobbies");
			Customer customer = new Customer(id, name, gender, city, hobbies);
			customerList.add(customer);
		}
		disconnect();
		return customerList;
	}
    
	
	//this is getbyid method
	//this method shows particular data from the database 
	//to perform task update or delete according to id
	@Override
	public Customer GetById(int id) throws SQLException {
		sql = "select * from customer where id = ?";
		connect();
		PreparedStatement statement  = connection.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		Customer customer = null;
		
		if(resultSet.next()) {
			int xid = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String gender = resultSet.getString("gender");
			String city = resultSet.getString("city");
			String hobbies = resultSet.getString("hobbies");
			customer = new Customer(xid, name, gender, city, hobbies);
		}
		disconnect();
		return customer;
	}

	@Override
	public List<String> getCity() {
		List<String> city_list = new ArrayList<String>();
		city_list.add("Ahmedabad");
		city_list.add("Mehsana");
		city_list.add("Gandhinagar");
		city_list.add("Surat");
		city_list.add("Mumbai");
		city_list.add("Baroda");
		city_list.add("Visnagar");
		city_list.add("Delhi");
		return city_list;
	}

}
