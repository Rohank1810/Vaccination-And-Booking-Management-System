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
 * Servlet implementation class Hospital
 */
public class Hospital extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hospital() {
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
		int hid;
		Connection con = Dbconnection.connect();
		String hemail = request.getParameter("hemail");
		String hpassword = request.getParameter("hpass");
		
		try {
			PreparedStatement ptmt = con.prepareStatement("select * from hospital where email=? and password=?");
			ptmt.setString(1,hemail);
			ptmt.setString(2,hpassword);
			ResultSet rs = ptmt.executeQuery();
		   
			while(rs.next())
				{
				    hid = rs.getInt(1);
					System.out.println(hid);
					GetSetHospital.setHid(hid);
					response.sendRedirect("hospitaldetail.html");
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
