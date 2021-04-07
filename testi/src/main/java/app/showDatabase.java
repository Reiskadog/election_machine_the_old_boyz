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
public class showDatabase extends HttpServlet {
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
    public showDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    /*
     * Lets make amethod that will handle the connection check, so our doGet and doPost will be less crowded.
     */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ListedData> list=null;
		if (dao.getConnection()) {
			int idValue = Integer.parseInt(request.getParameter("idValue"));
			String qValue = request.getParameter("qValue");
			dao.AddTableData(idValue,qValue);
			list=dao.readAllData();
		}
		else {
			System.out.println("No connection to database");
		}
		request.setAttribute("dataList", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showData.jsp");
		rd.forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ListedData> list=null;
		if (dao.getConnection()) {
			list=dao.readAllData();
		}
		else {
			System.out.println("No connection to database");
		}
		request.setAttribute("dataList", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showData.jsp");
		rd.forward(request, response);
	}
}
