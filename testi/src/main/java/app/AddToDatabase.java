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

	public void init() {
		/*
		 *Change this to be a context based solutions later. 
		 */
		dao=new Dao("jdbc:mysql://localhost:3306/webappdb", "user", "password");
	}
	
	public AddToDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ListedData> list=null;
		ArrayList<ListedData> list2=null;
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
				list=dao.readAllQuestionData();
				list2=dao.readAllElecteeData();
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
