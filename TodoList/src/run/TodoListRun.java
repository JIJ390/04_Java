package run;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.print.attribute.standard.DateTimeAtCompleted;

import view.TodoListView;

public class TodoListRun {
	
	private static LocalDateTime regDate;
	
	public static void main(String[] args) {
		TodoListView view = new TodoListView();
		
		view.mainMenu();
		
	}

}
