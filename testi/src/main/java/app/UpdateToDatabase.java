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
 * Servlet implementation class UpdateToDatabase
 */
@WebServlet("/update")
public class UpdateToDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao=null;
    
	/**
	 *	Initializes the dao that is used to access the database.
	 */
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/webappdb", "user", "password");
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
	/**
	 *	An empty constructor
	 */
    public UpdateToDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /**
	 */
    
    /**
     *	Called by the server to allow a servlet to handle a POST request.
     *	HTTP POST-method allows the user to send unlimited amount of data to the server.
     *	GET called by the server to allowed a servlet to handle a get request. Should not be used, while handling delicate or large amount of data.
     * 
	 *	Handles the request and its data, also checks the connection. Reads the electee data using id and then forwards the lists to updateElectee
     *
     *	@param request        object that contains the request the client has made of the servlet
     *	@param response        object that contains the response the servlet sends to the client
     * 
     *	@throws ServletException    if the request for the POST could not be handled
     *	@throws IOException        if an input or output error is detected when the servlet handles the request
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		ListedData e=null;

		if (dao.getConnection()) {
			e=dao.readElectee(id);
		}
		else {
			System.out.println("No connection to database");
		}
		request.setAttribute("dataList", e);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/updateElectee.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 *	Called by the server to allow a servlet to handle a POST request.
     *	HTTP POST-method allows the user to send unlimited amount of data to the server.
     *	POST is useful when sending large amounts of information or information such as credit card number.
	 * 
	 *	Handles the request and its data, also checks the connection. Updates the electee data using id and then forwards the updated lists to showData
	 *	
	 *	@param request        object that contains the request the client has made of the servlet
     *	@param response        object that contains the response the servlet sends to the client
     * 
     *	@throws ServletException    if the request for the POST could not be handled
     *	@throws IOException        if an input or output error is detected when the servlet handles the request
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("idValue");
		String fname=request.getParameter("fName");
		String lname=request.getParameter("lName");
		ListedData f=new ListedData(id, fname, lname);
		ArrayList<ArrayList<ListedData>> aList = new ArrayList<ArrayList<ListedData>>(2);
		
		if (dao.getConnection()) {
			aList.add(dao.updateElectee(f));
			System.out.println("electee updated");
		}
		aList.add(dao.readAllElecteeData());
		request.setAttribute("dataList", aList.get(0));
		request.setAttribute("dataList2", aList.get(1));
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showData.jsp");
		rd.forward(request, response);
	}
}
