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
@WebServlet("/showDatabase")
public class ControlDatabases extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao=null;
	
	@Override
	public void init() {
		/*
		 *Change this to be a context based solutions later. 
		 */
		dao=new Dao("jdbc:mysql://localhost:3306/webappdb", "user", "password");
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlDatabases() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ArrayList<ListedData>> aList = new ArrayList<ArrayList<ListedData>>(2);
		if (dao.getConnection()) {
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
