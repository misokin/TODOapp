package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		//Userインスタンスの生成
		User user = new User(name, pass);

		//ログイン処理
		LoginLogic loginLogic = new LoginLogic();
		boolean isLogin = loginLogic.execute(user);

		String errorMsg1 = "";
		String errorMsg2 = "";

		//ログイン成功時の処理

		if (isLogin) {
			//ユーザー情報をセッションスコープに保存

			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
		}
		if (name == null || name.length() <= 0) {
			errorMsg1 += "ユーザー名に誤りがあります";
			request.setAttribute("errorMsg1", errorMsg1);

		}
		if (pass == null || pass.length() <= 0) {
			errorMsg2 += "パスワードに誤りがあります";
			request.setAttribute("errorMsg2", errorMsg2);

		}
		if (errorMsg1.length() >= 1 || errorMsg2.length() >= 1) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);

		}

		//ログイン結果画面にフォワード
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("WEB-INF/jsp/input.jsp");
		dispatcher.forward(request, response);
	}
}