
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import oracle.jdbc.driver.OracleDriver;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/AddSaleItem")
public class AddSaleItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * Connection con = null; Statement stmt = null; ResultSet rs = null; String
	 * JDBCUrl =
	 * "jdbc:oracle:thin:@ee417.c7clh2c6565n.eu-west-1.rds.amazonaws.com:1521:EE417";
	 * String username = "ee_user"; String password = "ee_pass";
	 */
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddSaleItem() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String JDBCUrl = "jdbc:oracle:thin:@ee417.c7clh2c6565n.eu-west-1.rds.amazonaws.com:1521:EE417";
		String username = "ee_user";
		String password = "ee_pass";
		int id = 0;
		if (request.getParameter("createaccount") != null) {
			String sellerid = request.getParameter("sellerID");
			String itemname = request.getParameter("itemName");
			String itemid = request.getParameter("itemID");
			String itemdescription = request.getParameter("itemDesc");
			String category = request.getParameter("category");
			String saleid = request.getParameter("saleid");
			String startingprice = request.getParameter("price");

			System.out.println(username);
			System.out.println(password);
			String addItem = "INSERT INTO MLECE_ITEMS (" + sellerid + ", '" + itemname + "', " + itemid + ", '"
					+ itemdescription + "', '" + category + "' )";
			String addSale = "INSERT INTO MLECE_SALES (" + saleid + ", " + itemid + ", " + startingprice
					+ ", NULL + ,  + NULL  )";
			try {
				System.out.println("\nConnecting to the SSD Database......");
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection(JDBCUrl, username, password);
			} catch (Exception e) {
				System.out.println(e);
			}
			try {
				stmt = con.createStatement();
				System.out.println(addItem);
				stmt.executeQuery(addItem);
			} catch (Exception e) {
				System.out.println(e);
				System.out.println(
						"<BR>An error has occurred during the Statement/ResultSet phase.  Please check the syntax and study the Exception details!");
			}
			try {
				stmt = con.createStatement();
				System.out.println(addSale);
				stmt.executeQuery(addSale);
			} catch (Exception e) {
				System.out.println(e);
				System.out.println(
						"<BR>An error has occurred during the Statement/ResultSet phase.  Please check the syntax and study the Exception details!");
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (stmt != null)
						stmt.close();
					if (con != null)
						con.close();
				} catch (Exception ex) {
					System.out.println("<BR>An error occurred while closing down connection/statement");
				}
			}
		} else {
		}
	}
}
