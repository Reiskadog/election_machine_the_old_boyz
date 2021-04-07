package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dao.QuestionDao;
import data.ListedData;
import model.QuestionModel;

/**
 * Servlet implementation class ShowDatabase
 */
@WebServlet("/showDatabase")
public class showDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuestionDao dao = null;

	@Override
	public void init() {
		/*
		 * Change this to be a context based solutions later.
		 */
		dao = new QuestionDao();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public showDatabase() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		ArrayList<ListedData> list=null;
		List<QuestionModel> list = dao.getQuestions();
		for (QuestionModel questionModel : list) {
			System.out.println(questionModel.getQuestion());
		}
		request.setAttribute("dataList", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/showData.jsp");
		rd.forward(request, response);
	}
}
