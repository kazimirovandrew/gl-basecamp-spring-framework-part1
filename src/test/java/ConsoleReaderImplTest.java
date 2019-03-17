import basecamp.ConsoleReader;
import basecamp.Impl.ConsoleReaderImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleReaderImplTest {

    private static ConsoleReader consoleReader;

    @BeforeAll
    public static void init() {
        consoleReader = new ConsoleReaderImpl();
    }

    @Test
    public void givenValidNumber_whenInput_thenReturnValidNumber() {

        // given
        // simulation of user input
        String input = "33";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        int inputNumber = consoleReader.input();

        // then
        assertEquals(33, inputNumber);
    }

    @Test
    public void givenInvalidNumber_whenInput_thenReturnCodeOfWrongInputFormat() {

        // given
        // simulation of user input
        String input = "q11w";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        int inputNumber = consoleReader.input();

        // then
        assertEquals(-1, inputNumber);
    }
}
