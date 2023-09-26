package smallExcercises;
import java.util.Scanner;

import shared.DateUtil;

public class DateValidationExample {
	public static void main(String[] args) {
		// String datePattern = "dd/MM/yyyy";
		// String separator = "/";
		
		// String datePattern = "yyyy-mm-dd";
		// String separator = "-";

		String datePattern = "dd,MM,yyyy";
		String separator = ",";

		Scanner sc = new Scanner(System.in);
		DateUtil dateUtil = new DateUtil();

		String dateStr = dateUtil.userInputDate(sc, datePattern, separator);
		System.out.println(dateStr);

		int ages = dateUtil.calculateAge(dateStr, datePattern);
		System.out.println("Your age is " + ages);

		sc.close();
	}
}
