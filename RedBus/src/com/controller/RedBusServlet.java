package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.PassengerDao;
import com.dao.DistanceDao;
import com.dao.PaymentDao;
import com.dao.RouteDao;
import com.dao.TicketDao;
import com.dao.UserDao;
import com.dto.PassengerDto;
import com.dto.RouteDto;
import com.dto.UserDto;

@WebServlet("/RedBusServlet")
public class RedBusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String button = request.getParameter("bt");
		HttpSession se = request.getSession();
		PrintWriter pw = response.getWriter();
		if (button == null) {
			List<String> cList;
			List<RouteDto> table;
			try {
				cList = RouteDao.getAllRoutes();
//				table = RouteDao.getTableDetails();
				se.setAttribute("cList", cList);
//				se.setAttribute("table", table);
				request.getRequestDispatcher("Login.jsp").forward(request, response);

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String button = request.getParameter("bt");
		PrintWriter pw = response.getWriter();
		HttpSession se = request.getSession();
		if (button.equals("Register")) {

			String n = request.getParameter("f1");
			String e = request.getParameter("f2");
			String p = request.getParameter("f3");
			String a = request.getParameter("f4");
			String phoneno = request.getParameter("f5");

			try {
				boolean check = UserDao.checkEmailExistsorNot(e);
				if (check) {
					System.out.println("registered sucessufully");
				} else {
					boolean insert = UserDao.register(n, e, p, a, phoneno);
					if (insert) {
						pw.println("Registered sucessfully");
						request.getRequestDispatcher("Register.jsp").forward(request, response);

					} else {
						pw.println("Registration not sucessfull");
					}

				}
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (button.equals("Login")) {
			String e = request.getParameter("t1");
			String p = request.getParameter("t2");

			try {
				boolean login = UserDao.emailexistsornot(e, p);
				String welcomename = UserDao.getnameafterwelcome(e);
				int uid = UserDao.getIdUsingEmail(e);
				se.setAttribute("uid", uid);
				if (login) {
					pw.println("logged in");
					se.setAttribute("n", welcomename);
					request.getRequestDispatcher("Home.jsp").forward(request, response);
				} else {
					pw.println("incorret credentials");
				}
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (button.equals("Book Ticket")) {
			String from = request.getParameter("from");
			String to = request.getParameter("to");
			se.setAttribute("from", from);
			se.setAttribute("to", to);
			String user_name = request.getParameter("t1");
			int user_id = (Integer) se.getAttribute("uid");
			boolean insertticket = false;

			try {
				if (from.equals(to)) {
					pw.println("destination and starting should not be same");
				} else {
					insertticket = TicketDao.getticket(user_id, from, to);

					if (insertticket) {
						int ticket_id = TicketDao.getticketId(user_id);

						se.setAttribute("ticket_id", ticket_id);
						request.getRequestDispatcher("AddPassenger.jsp").forward(request, response);
					}
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (button.equals("Add")) {
			String n1 = request.getParameter("t1");
			String g = request.getParameter("t4");
			int a1 = Integer.parseInt(request.getParameter("t2"));
			String category = request.getParameter("t5");
			int uid1 = (Integer) se.getAttribute("uid");
			Date d = new Date();
			Timestamp ts = new Timestamp(d.getTime());
			List<PassengerDto> plist = new ArrayList<PassengerDto>();

			try {
				int ticket_id = (int) se.getAttribute("ticket_id");
				boolean insert = PassengerDao.insertpassengerdetails(uid1, ticket_id, n1, g, a1, category, ts);
				if (insert) {

					plist = PassengerDao.ShowPassengerDetails(uid1, ticket_id);
					se.setAttribute("plist", plist);
					request.getRequestDispatcher("AddPassenger.jsp").include(request, response);

				}

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (button.equals("Proceed to Payment")) {
			String from = (String) se.getAttribute("from");
			String to = (String) se.getAttribute("to");
			int uid1 = (Integer) se.getAttribute("uid");
			int ticket_id = (int) se.getAttribute("ticket_id");
			int totalprice = 0;

			List<PassengerDto> plist = new ArrayList<PassengerDto>();
			try {
				plist = PassengerDao.ShowPassengerDetails(uid1, ticket_id);
				int kilometers = DistanceDao.getkilometers(from, to);
				int numofpassengers = PassengerDao.getcount(ticket_id);
				totalprice = (kilometers * numofpassengers * 6);
				se.setAttribute("totalprice", totalprice);
				se.setAttribute("numofpassengers", numofpassengers);
				se.setAttribute("plist", plist);
				request.getRequestDispatcher("PassengerDetails.jsp").forward(request, response);

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (button.equals("Make Payment")) {
			String from = (String) se.getAttribute("from");
			String to = (String) se.getAttribute("to");
			int uid1 = (Integer) se.getAttribute("uid");
			int ticket_id = (int) se.getAttribute("ticket_id");
			int totalprice = (int) se.getAttribute("totalprice");
			try {
				boolean finalinsert = PaymentDao.insertpaymentdetails(uid1, ticket_id, from, to, totalprice);
				if (finalinsert) {
					request.getRequestDispatcher("Final.jsp").forward(request, response);
				} else {
					pw.println("payment is not sucessfull");
				}

			}

			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (button.equals("Locate")) {
			String pos = request.getParameter("position");
			if (pos != null) {
				se.setAttribute("city", pos);
				request.getRequestDispatcher("Home.jsp").include(request, response);
			}

		} else if (button.equals("My Profile")) {
			int uid = (Integer) se.getAttribute("uid");
			if (uid > 0) {
				try {
					List<UserDto> userDetails = UserDao.getUserDetails(uid);
					se.setAttribute("userDetails", userDetails);
					request.getRequestDispatcher("MyProfile.jsp").include(request, response);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
