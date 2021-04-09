package app;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< Updated upstream:testi/src/main/java/app/showDatabase.java
import dao.Dao;
import data.ListedData;
=======
import dao.ElecteeDao;
import dao.QuestionDao;
import data.ElecteeData;
import data.QuestionData;
>>>>>>> Stashed changes:testi/src/main/java/app/ControlDatabases.java

/**
 * Servlet implementation class ShowDatabase
 */
@WebServlet("/showDatabase")
public class showDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
<<<<<<< Updated upstream:testi/src/main/java/app/showDatabase.java
	private Dao dao=null;
	
=======
	private QuestionDao dao=null;
	private ElecteeDao dao2=null;

>>>>>>> Stashed changes:testi/src/main/java/app/ControlDatabases.java
	@Override
	public void init() {
		/*
		 *Change this to be a context based solutions later. 
		 */
<<<<<<< Updated upstream:testi/src/main/java/app/showDatabase.java
		dao=new Dao("jdbc:mysql://localhost:3306/webappdb", "user", "password");
=======
		dao=new QuestionDao("jdbc:mysql://localhost:3306/webappdb", "user", "password");
		dao2=new ElecteeDao("jdbc:mysql://localhost:3306/webappdb", "user", "password");

>>>>>>> Stashed changes:testi/src/main/java/app/ControlDatabases.java
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<QuestionData> list=null;
		ArrayList<ElecteeData> list2=null;

		if (dao.getConnection()) {
			list=dao.readAllData();
			list2=dao2.readAllData();
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
