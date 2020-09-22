package com.priti.code.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.priti.code.dao.CustomerDao;
import com.priti.code.dao.CustomerDaoImpl;
import com.priti.code.model.Customer;


@WebServlet("/")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    CustomerDao dao;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		System.out.println("action : " + action);
		
		try {
		switch(action) {
		case "/new" :
			showNewForm(request, response);
			break;
		case "/insert" :
			insertCustomer(request, response);
			break;
		case "/delete" :
			deleteCustomer(request, response);
			break;
		case "/edit" :
			showEditForm(request, response);
			break;
		case "/update" :
			updateCustomer(request, response);
			break;
		default :
	            //this is list method
			    //you can write any name for this method
			    //here, i use abc name 
				abc(request, response);
		}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	

    //this is list method
	private void abc(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		dao = new CustomerDaoImpl();
		List<Customer> list = dao.listAllCustomer();
		
		request.setAttribute("customerList", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/CustomerList.jsp");
		rd.forward(request, response);
		
	}

    //this is update method
	private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String city = request.getParameter("city");
		String hobbies = request.getParameter("hobbies");
		
		Customer customer = new Customer(id, name, gender, city, hobbies);
		dao = new CustomerDaoImpl();
		dao.update(customer);
		
		RequestDispatcher rd = request.getRequestDispatcher("abc");//abc means list page
		rd.forward(request, response);
		
	}

    //this is edit method
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		dao = new CustomerDaoImpl();
		Customer customer = dao.GetById(id);
		request.setAttribute("customer", customer);
		request.setAttribute("action", "update");
		List<String> city_list = dao.getCity();
		request.setAttribute("city_list",city_list);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/CustomerEntry.jsp");
		rd.forward(request, response);
		
	}

    //this is delete method
	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		dao = new CustomerDaoImpl();
		dao.delete(id);
		
		RequestDispatcher rd = request.getRequestDispatcher("abc");//abc means list page
		rd.forward(request, response);
		
	}

    //this is insert method
	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String city = request.getParameter("city");
		String hobbies = request.getParameter("hobbies");
		
		Customer customer = new Customer(name, gender, city, hobbies);
		dao = new CustomerDaoImpl();
		dao.insert(customer);
		
		RequestDispatcher rd = request.getRequestDispatcher("abc");//abc means list page
		rd.forward(request, response);
		
	}

    //this is new method
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("action", "insert");
		List<String> city_list = dao.getCity();
		request.setAttribute("city_list",city_list);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/CustomerEntry.jsp");
		rd.forward(request, response);
		
	}

}
