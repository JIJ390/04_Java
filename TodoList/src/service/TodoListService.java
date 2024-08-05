package service;

import java.io.IOException;
import java.time.LocalDateTime;

public interface TodoListService {
	
	String formatDate(LocalDateTime regDate);

	String fullView();

	String detailView(int index);
	
	int addTodo(String title, String detail) throws IOException;

	void completeTodo(int index) throws IOException;

	void updateTodo(String title, String detail, int index) throws IOException;

	void deleteTodo(int index) throws IOException;



}
