package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.InputLogic;
import model.Todo;

/**
 * Servlet implementation class inputservlet
 */
@WebServlet("/InputServlet")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InputServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/jsp/input.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		//リクエストパラメータを取得

		String content = request.getParameter("content");
		String deadline = request.getParameter("deadline");
		String priority = request.getParameter("priority");

		String errorMsg3 = "";
		String errorMsg4 = "";

		//リクエストパラメータをチェック
		if (content == null || content.length() <= 0) {
			//			errorMsg1 += "ユーザー名が入力されていません";
			errorMsg3 += "内容が入力されていません";
			request.setAttribute("errorMsg1", errorMsg3);
		}
		if (deadline == null || deadline.length() <= 0) {
			//			errorMsg2 += "パスワードが入力されていません";
			errorMsg4 += "期日が入力されていません。";
			request.setAttribute("errorMsg4", errorMsg4);

		}

		//エラーがあったら
		if (errorMsg3.length() >= 1 || errorMsg4.length() >= 1) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/input.jsp");
			dispatcher.forward(request, response);
			return;
		}

		//javaBeanのインスタンス生成
		Todo todo = new Todo(priority, content, deadline);
		//セッションスコープに値を保存 
		HttpSession session = request.getSession();
		List<Todo> todoList = (List<Todo>) session.getAttribute("todoList");
		if (todoList == null) {
			todoList = new ArrayList<Todo>();
		}

		InputLogic inputLogic = new InputLogic();
		inputLogic.execute(todoList, todo);
		session.setAttribute("todoList", todoList);
		//フォワード処理
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
		dispatcher.forward(request, response);

	}
}
