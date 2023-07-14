package model;

import java.io.Serializable;

public class Todo implements Serializable {
	private String priority;
	private String content;
	private String deadline;
	private String no;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Todo() {
	}

	public Todo(String priority, String content, String deadline) {
		this.priority = priority;
		this.content = content;
		this.deadline = deadline;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
