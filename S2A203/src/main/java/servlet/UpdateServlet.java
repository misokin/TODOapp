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

import model.Todo;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リクエストパラメータを取得
		int no = Integer.parseInt(request.getParameter("no"));
		String content = request.getParameter("content");
		String deadline = request.getParameter("deadline");
		String priority = request.getParameter("priority");

		HttpSession session = request.getSession();
		//セッションスコープからTODOの情報を取得する
		List<Todo> todoList = (List<Todo>) session.getAttribute("todoList");
		if (todoList == null) {
			todoList = new ArrayList<Todo>();
		}
		//変更対象のTODOを取得
		Todo todo = todoList.get(no);

		//リクエストパラメータをチェック
		//入力されていたら変更
		if (content != null && content.length() >= 1) {
			//Todoの内容を書き換える
			todo.setContent(content);
		}

		if (deadline != null && deadline.length() >= 1) {
			//Todoの期日を書き換える
			todo.setDeadline(deadline);
		}
		if (priority != null && priority.length() >= 1) {
			//Todoの重要度を書き換える
			todo.setPriority(priority);
		}

		//UpdateLogicのexecuteで変更する→ArrrayList.set(no todo)
		session.setAttribute("todoList", todoList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/list.jsp");
		dispatcher.forward(request, response);

	}
}
