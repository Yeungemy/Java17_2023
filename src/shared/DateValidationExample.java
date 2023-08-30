package shared;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
import java.text.DateFormat;

public class DateValidationExample {
	public static void main(String[] args) {
		
		String datePattern = "dd-MM-yyyy";
		Scanner sc = new Scanner(System.in);
		DateUtil dateUtil = new DateUtil();

		LocalDate date = dateUtil.parseLocalDate(dateUtil.enterDate(sc, datePattern), datePattern);
		LocalDate today = LocalDate.now();

		int ages = Period.between(date, today).getYears();

		System.out.println("Your age is " + ages);
 		


		sc.close();
	}

	/**
	 * 
	 * @param date       - date string
	 * @param datePatter - like "dd/MM/yyyy" which can accept '-', '/' or ',' as
	 *                   separator
	 * @return boolean - the data entered by user is valid or not
	 */
	private static boolean dateValidation(String date, String datePattern) {
		boolean status = false;
		if (checkDate(date)) {
			DateFormat dateFormat = new SimpleDateFormat(datePattern);
			dateFormat.setLenient(false);
			try {
				dateFormat.parse(date);
				status = true;
			} catch (Exception e) {
				status = false;
			}
		}
		return status;
	}

	static boolean checkDate(String date) {
		String pattern = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
		boolean flag = false;
		if (date.matches(pattern)) {
			flag = true;
		}
		return flag;
	}
}
