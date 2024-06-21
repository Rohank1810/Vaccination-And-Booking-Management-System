package vaccine;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Form
 */
public class Form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Form() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con = Dbconnection.connect();
		int pid = 0;
		String pname = request.getParameter("pname");
		String pnumber = request.getParameter("pnumber");
		String paddress = request.getParameter("paddress");
		String pcamp = request.getParameter("pcamp");
		String pvaccine = request.getParameter("pvaccine");
		try {
			PreparedStatement ptmt = con.prepareStatement("insert into patient values(?,?,?,?,?,?,?)");
			ptmt.setInt(1,pid);
			ptmt.setString(2,pname);
			ptmt.setString(3,pnumber);
			ptmt.setString(4,paddress);
			ptmt.setString(5,pcamp);
			ptmt.setString(6,pvaccine);
			ptmt.setString(7,"Pending");
			int i = ptmt.executeUpdate();
			if(i>0){
				response.sendRedirect("vaccinedash.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
