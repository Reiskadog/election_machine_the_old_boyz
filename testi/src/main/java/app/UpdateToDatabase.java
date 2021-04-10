package app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QuestionDao;
import data.ListedData;

/**
 * Servlet implementation class UpdateToDatabase
 */
@WebServlet("/update")
public class UpdateToDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuestionDao dao=null;
       
	public void init() {
		/*
		 *Change this to be a context based solutions later. 
		 */
		dao=new QuestionDao("jdbc:mysql://localhost:3306/webappdb", "user", "password");
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateToDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		ListedData e=null;

		if (dao.getConnection()) {
			e=dao.readElectee(id);
			System.out.println(id);
			System.out.println(e);
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("idValue");
		String fname=request.getParameter("fName");
		String lname=request.getParameter("lName");
		
		ListedData f=new ListedData(id, fname, lname);
		
		ArrayList<ListedData> list=null;
		ArrayList<ListedData> list2=null;
		if (dao.getConnection()) {
			list=dao.updateElectee(f);
			System.out.println(id+fname+lname+f);
		}
		list=dao.readAllQuestionData();
		list2=dao.readAllElecteeData();
		
		request.setAttribute("dataList", list);
		request.setAttribute("dataList2", list2);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showData.jsp");
		rd.forward(request, response);
	}

}
