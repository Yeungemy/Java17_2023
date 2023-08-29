package shared;

import java.time.LocalDate;

import org.junit.Assert;

public class SharedTest {
     @Test
    public void SharedTest_Success() {
        Shared shared = new Shared();
        // setup
        LocalDate birthDate = LocalDate.of(1961, 5, 17);
        // exercise
        int actual = shared.calculateAge(birthDate, LocalDate.of(2016, 7, 12));
        // assert
        Assert.assertEquals(55, actual);
    }
}
