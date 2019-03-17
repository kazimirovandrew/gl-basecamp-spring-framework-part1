import basecamp.Impl.NumberGeneratorImpl;
import basecamp.NumberGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberGeneratorImplTest {

    private static NumberGenerator numberGenerator;

    @BeforeAll
    public static void init() {
        numberGenerator = new NumberGeneratorImpl();
    }

    @Test
    public void givenMinAndMaxNumbers_whenNext_thenReturnRandomNumber() {

        // given
        numberGenerator.setMinNumber(0);
        numberGenerator.setMaxNumber(1);

        // when
        int randomNumber = numberGenerator.next();

        //then
        assertTrue(randomNumber == 0 || randomNumber == 1);
    }
}
