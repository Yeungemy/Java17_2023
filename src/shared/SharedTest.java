package shared;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;

public class SharedTest {
    @Test
    public void SharedTest_Success() {
        final String CUSTOM_PATTERN = "MM-dd-yyyy";
		

        DateUtil sharedDateUtil = new DateUtil();
        // setup
        String birthDate = "1961-5-17";
        // exercise
        int actual = sharedDateUtil.calculateAge(birthDate, CUSTOM_PATTERN);

        // assert
        Assert.assertEquals(55, actual);

        LocalDate parsedLocalDate = sharedDateUtil.parseLocalDate("01-26-2023", CUSTOM_PATTERN);

        Assert.assertNotNull(parsedLocalDate);
        Assert.assertEquals(26, parsedLocalDate.getDayOfMonth());
        Assert.assertEquals(1, parsedLocalDate.getMonthValue());
        Assert.assertEquals(2023, parsedLocalDate.getYear());
    }
}
