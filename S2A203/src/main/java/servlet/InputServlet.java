package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		response.sendRedirect("input.jsp");
		System.out.println("doGet");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		//リクエストパラメータを取得
		String priority = request.getParameter("priority");
		String content = request.getParameter("content");
		String deadline = request.getParameter("deadline");

		String errorMsg = "";

		//リクエストパラメータをチェック
		if (content == null || content.length() == 0) {
			errorMsg += "内容が入力されていません<br>";
		}
		if (deadline == null || deadline.length() == 0) {
			errorMsg += "期日が入力されていません<br>";
		}

		//javaBeanのインスタンス生成
		Todo todo = new Todo();
		todo.setContent(content);
		todo.setDeadline(deadline);
		todo.setPriority(priority);
		//リクエストスコープに値を保存
		request.setAttribute("todo", todo);

		//フォワード処理
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
		dispatcher.forward(request, response);

	}
}

//表示されるメッセージを設定

//			String msg = todo + "を(" + deadline + ")までに登録しました。";
//			if (errorMsg.length() != 0) {
//				msg = errorMsg;
//			}

//html
