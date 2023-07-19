package model;

import java.util.List;

public class UpdateLogic {
	public void execute(List<Todo> todoList, Todo todo, int no) {
		todoList.set(no, todo);
	}

}
