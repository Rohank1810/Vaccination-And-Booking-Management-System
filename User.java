package vaccine;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class User
 */
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
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
		int uid = 0;
		String uname = request.getParameter("uname");
		String uaddress = request.getParameter("uaddress");
		String unumber = request.getParameter("unumber");
		System.out.println("unum"+unumber);
		String uemail = request.getParameter("uemail");
		String upassword = request.getParameter("upass");
		try {
			PreparedStatement ptmt = con.prepareStatement("insert into user values(?,?,?,?,?,?)");
			ptmt.setInt(1,uid);
			ptmt.setString(2,uname);
			ptmt.setString(3,uaddress);
			ptmt.setString(4,unumber);
			ptmt.setString(5,uemail);
			ptmt.setString(6,upassword);
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
