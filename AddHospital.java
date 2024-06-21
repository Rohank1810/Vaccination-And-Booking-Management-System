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
 * Servlet implementation class AddHospital
 */
public class AddHospital extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHospital() {
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
		int hid = 0;
		String hname = request.getParameter("hname");
		String haddress = request.getParameter("haddress");
		String hnumber = request.getParameter("hnumber");
		System.out.println("hnum"+hnumber);
		String hemail = request.getParameter("hemail");
		String hpassword = request.getParameter("hpass");
		System.out.println("hemail : "+hemail);
		try {
			PreparedStatement ptmt = con.prepareStatement("insert into hospital values(?,?,?,?,?,?,?)");
			ptmt.setInt(1,hid);
			ptmt.setString(2,hname);
			ptmt.setString(3,haddress);
			ptmt.setString(4,hnumber);
			ptmt.setString(5,hemail);
			ptmt.setString(6,hpassword);
			ptmt.setString(7,"Pending");
			int i = ptmt.executeUpdate();
			if(i>0){
				response.sendRedirect("admindetail.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
