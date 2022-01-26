package com.flyaway.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.dao.CitiesDao;
import com.flyaway.models.Cities;

/**
 * Servlet implementation class City
 */
@WebServlet("/city")
public class City extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CitiesDao city = new CitiesDao();    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public City() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * PrintWriter out = response.getWriter(); System.out.println("I am from get");
		 * String cityName = request.getParameter("city"); List<String> listCities =
		 * city.getDropDownValue(cityName); Iterator<String> iterator =
		 * listCities.iterator(); String country; while(iterator.hasNext()) { country =
		 * iterator.next(); System.out.println(country+"From City Servlet");
		 * request.setAttribute("CityName", country);
		 * 
		 * } RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		 * dispatcher.forward(request, response);
		 */
		
		request.getRequestDispatcher("city/index.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
