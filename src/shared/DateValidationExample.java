package shared;
import java.util.Scanner;

public class DateValidationExample {
	public static void main(String[] args) {
		
		String datePattern = "dd/MM/yyyy";
		Scanner sc = new Scanner(System.in);
		DateUtil dateUtil = new DateUtil();
		String date = dateUtil.enterDate(sc, datePattern);
		int ages = dateUtil.calculateAge(date, datePattern);

		System.out.println("Your age is " + ages);
		sc.close();
	}
}
