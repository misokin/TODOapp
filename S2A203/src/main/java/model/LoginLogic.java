package model;

public class LoginLogic {

	public boolean execute(User user) {
		if (user.getPass().equals("1234")) {
			return true;
		}
		//エラーメッセージをリクエストスコープに保存
		return false;
	}

}