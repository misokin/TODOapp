package model;

import java.util.List;

public class RemoveLogic {
	public void execute(List<Todo> todoList, int no) {
		todoList.remove(no);
	}
}
