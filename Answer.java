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
 * Servlet implementation class Answer
 */
public class Answer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Answer() {
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
		int id = Integer.parseInt(request.getParameter("qnumber"));
		String ans = request.getParameter("answer");
		System.out.println("id : "+id);
		System.out.println("ans : "+ans);
		try {
			PreparedStatement ptmt = con.prepareStatement("update qna set answer=? where srno=?");
			ptmt.setString(1,ans);
			ptmt.setInt(2,id);
			int i = ptmt.executeUpdate();
			System.out.println("updated : ");
			if(i>0)
			{System.out.println("updated : ");
				response.sendRedirect("admindetail.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
