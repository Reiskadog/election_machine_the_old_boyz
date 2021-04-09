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
 * Servlet implementation class DeleteFromDatabase
 */
@WebServlet("/delete")
public class DeleteFromDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Dao dao=null;

	public void init() {
		/*
		 *Change this to be a context based solutions later. 
		 */
		dao=new Dao("jdbc:mysql://localhost:3306/webappdb", "user", "password");
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFromDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		ArrayList<ListedData> list=null;
		if (dao.getConnection()) {
			list=dao.deleteTableData(id);
			System.out.println("Deleted succesfully");
		}
		request.setAttribute("dataList", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showData.jsp");
		rd.forward(request, response);
	}

}
