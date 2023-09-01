package smallExcercises;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import shared.DateUtil;

public class DateValidationExample {
	public static void main(String[] args) {
		String datePattern = "dd/MM/yyyy";
		Scanner sc = new Scanner(System.in);
		DateUtil dateUtil = new DateUtil();

		String dateStr = dateUtil.userInputDate(sc, datePattern, "/");
		System.out.println(dateStr);
		int ages = dateUtil.calculateAge(dateStr, datePattern);
		System.out.println("Your age is " + ages);

		sc.close();
	}
}
