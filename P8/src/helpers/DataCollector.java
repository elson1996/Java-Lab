package helpers;

import java.io.IOException;
import java.io.PrintWriter;

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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataCollector() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		double salary = Double.parseDouble(request.getParameter("salary"));
		double deduction = Double.parseDouble(request.getParameter("deduction"));
		double incomeTax = (salary*20/100);
		incomeTax = incomeTax - (incomeTax*deduction/100);
		response.getWriter().append("Name: "+name).append("\nGender: "+gender).append("\nSalary: "+salary).append("\nDeduction: "+deduction).append("\nIncomeTax: "+incomeTax);
		PrintWriter w = new PrintWriter("data.txt", "UTF-8");
		w.println("Name: "+name);
		w.println("Gender: "+gender);
		w.println("Salary: "+salary);
		w.println("Deduction: "+deduction);
		w.println("IncomeTax: "+incomeTax);
		w.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
