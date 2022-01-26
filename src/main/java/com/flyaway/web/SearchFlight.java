package com.flyaway.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyaway.dao.FlightDao;

/**
 * Servlet implementation class SearchFlight
 */
public class SearchFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FlightDao dao;
	List<Map<String, Object>> flightDetails;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchFlight() {
		super();
		dao = new FlightDao();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String source = request.getParameter("Source");
			System.out.println("Source:" + source);
			String destination = request.getParameter("Destination");
			System.out.println("Destination:" + destination);
			String date = request.getParameter("Date");
			System.out.println("Date:" + date);
			String capacity = request.getParameter("NoOfPeople");
			System.out.println("Capacity:" + capacity);
			flightDetails = dao.searchFlight(source, destination, date, capacity);
			request.setAttribute("data", flightDetails);
			RequestDispatcher rd = request.getRequestDispatcher("UserDashboard.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		/*
		 * PrintWriter out = response.getWriter(); response.setContentType("text/html");
		 * RequestDispatcher dispatcher = null; System.out.println("Me in Do"); String
		 * source = request.getParameter("Source"); System.out.println("Source:" +
		 * source); String destination = request.getParameter("Destination");
		 * System.out.println("Destination:" + destination); String date =
		 * request.getParameter("Date"); System.out.println("Date:" + date); String
		 * capacity = request.getParameter("NoOfPeople"); System.out.println("Capacity:"
		 * + capacity); flightDetails = dao.searchFlight(source, destination, date,
		 * capacity); HttpSession session = request.getSession();
		 * System.out.println(flightDetails); if (flightDetails.isEmpty()) {
		 * System.out.println("if"); // String errorMessage =
		 * "Flights not available for this date"; //
		 * request.getSession().setAttribute("errorMessage", errorMessage); //
		 * request.setAttribute("errorMessage","Flights not available for this date");
		 * out.
		 * println("<b><font color='red'>Flights not available for this date!</font></b>"
		 * ); // dispatcher = // request.getRequestDispatcher("/index.jsp"); //
		 * out.println("<h3 // style='color:red'>Flights // not // available</h3>");
		 * dispatcher.forward(request, response); } else { System.out.println("else");
		 * 
		 * dispatcher = request.getRequestDispatcher("UserDashboard.jsp");
		 * dispatcher.include(request, response);
		 * out.println("<table border =1 width=500 align=center>"); out.print(
		 * "<tr bgcolor=00FF7F><th><b> </b></th> <th><b>Departure Time</b></th> <th><b>Arrival Time</b></th><th><b>Airline Name</b></th></tr>"
		 * ); for (Map<String, Object> map : flightDetails) { out.print("<tr>");
		 * out.print("<td><input type=radio id=html name=fav_language value=HTML></td>"
		 * ); System.out.println(map.size()); for (Map.Entry<String, Object> entry
		 * :map.entrySet()) { out.print("<td>"); out.print(entry.getValue());
		 * out.print("</td>"); // out.print(entry.getValue());
		 * System.out.println(entry.getValue()); } out.print("</tr>"); }
		 * out.println("<br>"); out.println(); System.out.println("Done");
		 * out.println("</table>"); out.println("<br><br>"); out.println(); }
		 */
		processRequest(request,response);
		// dispatcher.forward(request, response);
	}
}
