package memo3.test;

import java.util.ArrayList;
import java.util.Arrays;

import memo3.run.Student;

public class Test {
	public static void main(String[] args) {

		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		int value = 0;
		
		if (arr.length > 10) for (int numb : arr) value += numb;
		else {
			value ++;
			for (int numb : arr) value *= numb;
		}
		
		
	}
}
