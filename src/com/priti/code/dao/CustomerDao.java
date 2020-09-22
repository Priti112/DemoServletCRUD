package com.priti.code.dao;

import java.sql.SQLException;
import java.util.List;

import com.priti.code.model.Customer;

public interface CustomerDao {
	
	//this is an interface
	//here, we declare all methods
	//this all methods implements in implementation class to write queries
	int insert(Customer customer) throws SQLException;
	int update(Customer customer) throws SQLException;
	int delete(int id) throws SQLException;
	List<Customer> listAllCustomer() throws SQLException;
	Customer GetById(int id) throws SQLException;
	
	List<String> getCity();

}
