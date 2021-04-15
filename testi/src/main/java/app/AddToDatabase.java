package app;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.ListedData;

/**
 * Servlet implementation class ShowDatabase
 */
@WebServlet("/addToDatabase")
public class AddToDatabase extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Dao dao=null;

	/**
	 *	Initializes the dao that is used to access the database.
	 */
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/webappdb", "user", "password");
	}
	
	/**
	 * An empty constructor
	 */
	public AddToDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	/**
	 *	Called by the server to allow a servlet to handle a POST request.
     *	HTTP POST-method allows the user to send unlimited amount of data to the server.
     *	POST is useful when sending large amounts of information or information such as credit card number.
	 * 
	 *	Handles the request and its data, also checks the connection. Checks which table to add new information and forwards updated databases to showData in lists.
	 *	
	 *	@param request        object that contains the request the client has made of the servlet
     *	@param response        object that contains the response the servlet sends to the client
     * 
     *	@throws ServletException    if the request for the POST could not be handled
     *	@throws IOException        if an input or output error is detected when the servlet handles the request
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ArrayList<ListedData>> aList = new ArrayList<ArrayList<ListedData>>(2);
		if (dao.getConnection()) {
				int idValue = Integer.parseInt(request.getParameter("idValue"));
				String qValue = request.getParameter("qValue");
				String fName = request.getParameter("fName");
				String lName = request.getParameter("lName");
				if (qValue != null) {
					dao.AddTableData(idValue,qValue);
					System.out.println("question add");
				}
				else {
					dao.AddElecteeTableData(idValue,fName,lName);
					System.out.println("electee add");
				}
				aList.add(dao.readAllQuestionData());
				aList.add(dao.readAllElecteeData());
		}	
		else {
			System.out.println("No connection to database");
		}
		request.setAttribute("dataList", aList.get(0));
		request.setAttribute("dataList2", aList.get(1));
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showData.jsp");
		rd.forward(request, response);
	}
}
