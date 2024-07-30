package pkg4.exception;

public class UserDefinedExceptionRun {
	
	public static void main(String[] args) {
		try {
			throw new UserException();
			
		} catch (UserException e) {
			System.out.println("----- catch 문 -----");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

}
