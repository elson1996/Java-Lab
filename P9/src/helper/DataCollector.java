package helper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DataCollector
 */
@WebServlet("/DataCollector")
public class DataCollector extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String URL = "jdbc:mysql://localhost:3306/online_tshirt";
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "3070";
    Connection conn;
    /**
     * @see HttpServlet#HttpServlet()
     */
   
    public DataCollector() {
        super();
        System.out.println("\n\nConstructor");
        // TODO Auto-generated constructor stub
        try {
        	Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL,USER,PASS);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void init(){
    	System.out.println("\ninit");
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tag = request.getParameter("tag");
		String[] accessories = request.getParameterValues("accessories");
		String color =  request.getParameter("color");
		int pocket = Integer.parseInt(request.getParameter("pocket"));
		System.out.println("Tag: "+tag);
		System.out.println("Color: "+color);
		System.out.println("Pocket: "+pocket);
		System.out.print("accessories: ");
		String acc="";
		for(String s: accessories){
			acc+=s+" ";
			System.out.print(s+",");
		}
		String sql = "INSERT INTO `T-Shirt`(`color`, `chest_pocket`, `tag_line`, `accessories`) VALUES (?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, color);
			ps.setInt(2, pocket);
			ps.setString(3, tag);
			ps.setString(4, acc);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("display.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
