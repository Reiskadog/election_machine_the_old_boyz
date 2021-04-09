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
 * Servlet implementation class DeleteFromDatabase
 */
@WebServlet("/delete")
public class DeleteFromDatabase extends HttpServlet {
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
    public DeleteFromDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String choice=request.getParameter("choice");
		ArrayList<ListedData> list=null;//*************************************
		ArrayList<ListedData> list2=null;//*************************************
		if (dao.getConnection()) {
			if ("q".equals(choice))
			{
				list=dao.deleteQuestionData(id);//*************************************
				System.out.println("Deleted Question");
			}
			else
			{
				list2=dao.deleteElecteeData(id);//*************************************
				System.out.println("Deleted Electee");
			}
		}
		request.setAttribute("dataList", list);//*************************************
		request.setAttribute("dataList2", list2);//*************************************
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showData.jsp");
		rd.forward(request, response);
	}
}
