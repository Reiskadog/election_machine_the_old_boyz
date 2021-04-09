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
 * Servlet implementation class ShowDatabase
 */
@WebServlet("/AddElecteeToDatabase")
public class AddElecteeToDatabase extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private QuestionDao dao=null;

	public void init() {
		/*
		 *Change this to be a context based solutions later. 
		 */
		dao=new QuestionDao("jdbc:mysql://localhost:3306/webappdb", "user", "password");
	}
	
	public AddElecteeToDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ListedData> list=null;
		ArrayList<ListedData> list2=null;
		if (dao.getConnection()) {
				int idValue = Integer.parseInt(request.getParameter("idValue"));
				String fName = request.getParameter("fName");
				String lName = request.getParameter("lName");
				System.out.println(idValue);
				System.out.println(fName);

				dao.AddElecteeTableData(idValue,fName,lName);
				list=dao.readAllQuestionData();
				list2=dao.readAllElecteeData();
				System.out.println("You are at AddToDatabase");
		}	
			else {
				System.out.println("No connection to database");
			}
		request.setAttribute("dataList", list);
		request.setAttribute("dataList2", list2);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showData.jsp");
		rd.forward(request, response);
	}
}
