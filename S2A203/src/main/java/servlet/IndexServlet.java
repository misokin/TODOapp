package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Todo;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
		// TODO Auto-generated constructor stub

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リダイレクト
		//response.sendRedirect(".jsp");
		// TODO Auto-generated method stub
		int no = 1;
		int index = new Random().nextInt(4);
		int important = index + 1;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
		String today = sdf.format(date);
		String[] todoList = { "Linuxテスト対策", "paiza", "TODOアプリ作成", "履歴書作成" };
		String todo = todoList[index];
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//パラメータの取得
		String priority = request.getParameter("priority");
		String content = request.getParameter("content");
		String deadline = request.getParameter("deadline");
		String errorMsg = "";

		//入力チェック
		if (content == null || content.length() <= 0) {
			errorMsg = "内容が入力されていません<br>";

		}
		if (deadline == null || deadline.length() <= 0) {
			errorMsg = "期日が入力されていません<br>";
		}

		//javaBeanのインスタンス生成
		Todo todo = new Todo(priority, content, deadline);
		//リクエストスコープに値を保存
		request.setAttribute("todo", todo);

		//フォワード処理
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/list.jsp");
		dispatcher.forward(request, response);
	}
}
