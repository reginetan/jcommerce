
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Import these libraries from java.io and java.sql
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class addShopLocationServlet
 */
@WebServlet("/addShopLocationServlet")
public class addShopLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addShopLocationServlet() {
		super();
		// TODO Auto-generated constructor stub
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html"); // Step 1: Initialize a PrintWriter object to return the html values via
												// the response
		PrintWriter out = response.getWriter(); // Step 2: retrieve the four parameters from the request from the web
												// form
		String n = request.getParameter("shopName");
		String m = request.getParameter("shopImage");
		String l = request.getParameter("shopLocation");
		String d = request.getParameter("shopDescription");

		// Step 3: attempt connection to database using JDBC, you can change the
		// username and password accordingly using the phpMyAdmin > User Account
		// dashboard
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jcommerce", "root", "");

			PreparedStatement ps = con.prepareStatement("insert into SHOP_LOCATION values(?,?,?,?)");
			// Step 5: parse in the data retrieved from the web form request into the
			// prepared statement accordingly
			ps.setString(1, n);
			ps.setString(2, m);
			ps.setString(3, l);
			ps.setString(4, d); // Step 6: perform the query on the database using the prepared statement
			int i = ps.executeUpdate();

			// Step 7: check if the query had been successfully execute, return �You are
			// successfully registered� via the response,
			if (i > 0) {
				PrintWriter writer = response.getWriter();
				writer.println("<h1>" + "You have successfully added a new location!" + "</h1>");
				writer.close();
			}
		} // Step 8: catch and print out any exception
		catch (Exception exception) {
			System.out.println(exception);
			out.close();
		}

		doGet(request, response);
	}

}
