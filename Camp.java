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
 * Servlet implementation class Camp
 */
public class Camp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Camp() {
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
		String cName = request.getParameter("cname");
		String cAddress = request.getParameter("caddress");
		int hosid = GetSetHospital.getHid();
		int id = 0;
		try {
			PreparedStatement ptmt = con.prepareStatement("insert into camp values(?,?,?,?,?)");
			ptmt.setInt(1,id);
			ptmt.setString(2,cName);
			ptmt.setString(3,cAddress);
			ptmt.setString(4,"Pending");
			ptmt.setInt(5, hosid);
			int i = ptmt.executeUpdate();
			if(i>0){
				response.sendRedirect("hospitaldetail.html");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
		doGet(request, response);
	}

}
