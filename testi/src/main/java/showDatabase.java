import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.tieto;

/**
 * Servlet implementation class ShowDatabase
 */
@WebServlet("/showDatabase")
public class showDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao=null;
	
	@Override
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "ROBOSALA2");
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<tieto> list=null;
		if (dao.getConnection()) {
			list=dao.readAllTieto();
		}
		else {
			System.out.println("No connection to database");
		}
		request.setAttribute("fishlist", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showTieto.jsp");
		rd.forward(request, response);
	}
}
