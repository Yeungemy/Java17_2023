package shared;

import java.util.Scanner;

public class PhoneNoUtil {
    private final String regx = "\\d{3}-\\d{3}-\\d{4}";

    /**
     * 
     * @param {String} phoneNo - a phone number
     * @param {String} regx - phone number pattern
     * @return a boolean of true or false
     */
    public boolean isValid(String phoneNo, String regx) {
        if (phoneNo == null || phoneNo.isBlank()) {
            throw new IllegalArgumentException("Phone number cannot be null or blank!");
        } else {
            if (regx == null) {
                return phoneNo.matches(this.regx);
            } else {
                return phoneNo.matches(regx);
            }
        }
    }

    /**
     * Prompt user input a valid phone number
     * 
     * @param {Scanner} scanner - System Scanner
     * @param {String}  regx - phone number pattern
     * @return a phone number
     */
    public String userInputPhoneNumber(Scanner scanner, String regx) {
        String phoneNo = "";
        boolean isValid = false;
        
        do {
            System.out.print("Please enter a phone number in 'XXX-XXX-XXXX' format: ");
            phoneNo = scanner.next();

            isValid = isValid(phoneNo, regx);

            if (!isValid) {
                System.out.println("Sorry, that phone number cannot be accepted!");
            }
        } while (!isValid);

        return phoneNo;
    }
}
