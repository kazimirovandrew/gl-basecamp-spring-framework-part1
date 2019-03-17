import basecamp.ConsoleReader;
import basecamp.Game;
import basecamp.Impl.GameImpl;
import basecamp.NumberGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameImplTest {

    private static NumberGenerator numberGenerator;
    private static ConsoleReader consoleReader;
    private static Game game;

    @BeforeAll
    public static void init() {
        numberGenerator = Mockito.mock(NumberGenerator.class);
        consoleReader = Mockito.mock(ConsoleReader.class);

        game = new GameImpl(numberGenerator, consoleReader, 1);
    }

    @Test
    public void givenValidGuess_whenCheckValidNumberRange_thenReturnTrue() {

        // given
        when(consoleReader.input()).thenReturn(50);// valid guess
        when(numberGenerator.getMaxNumber()).thenReturn(100);
        when(numberGenerator.getMinNumber()).thenReturn(10);
        when(numberGenerator.next()).thenReturn(51);
        game.reset();

        // when
        boolean isValidNumberRange = game.isValidNumberRange();

        // then
        assertTrue(isValidNumberRange);
    }

    @Test
    public void givenInvalidGuess_whenCheckValidNumberRange_thenReturnFalse() {

        // given
        when(consoleReader.input()).thenReturn(200);// invalid guess
        when(numberGenerator.getMaxNumber()).thenReturn(100);
        when(numberGenerator.getMinNumber()).thenReturn(10);
        when(numberGenerator.next()).thenReturn(51);
        game.reset();

        // when
        boolean isValidNumberRange = game.isValidNumberRange();

        // then
        assertFalse(isValidNumberRange);
    }

    @Test
    public void givenGuessBiggerThanRandomNumber_whenCheck_thenChangeBiggest() {

        // given
        when(consoleReader.input()).thenReturn(70);// guess
        when(numberGenerator.next()).thenReturn(51);// random number
        when(numberGenerator.getMaxNumber()).thenReturn(100);// biggest
        when(numberGenerator.getMinNumber()).thenReturn(10);
        game.reset();

        // when
        game.check();

        // then
        int before = 100;
        int after = game.getBiggest();
        assertNotEquals(before, after);
    }

    @Test
    public void givenGuessSmallerThanRandomNumber_whenCheck_thenChangeSmallest() {

        // given
        when(consoleReader.input()).thenReturn(22);// guess
        when(numberGenerator.next()).thenReturn(51);// random number
        when(numberGenerator.getMaxNumber()).thenReturn(100);// smallest
        when(numberGenerator.getMinNumber()).thenReturn(10);
        game.reset();

        // when
        game.check();

        // then
        int before = 10;
        int after = game.getSmallest();
        assertNotEquals(before, after);
    }

    @Test
    public void givenSameGuessAndRandomNumber_whenIsGameWon_thenReturnTrue() {

        // given
        when(consoleReader.input()).thenReturn(50);// guess
        when(numberGenerator.next()).thenReturn(50);// random number
        when(numberGenerator.getMaxNumber()).thenReturn(100);
        when(numberGenerator.getMinNumber()).thenReturn(10);
        game.reset();

        // when
        boolean isGameWon = game.isGameWon();

        // then
        assertTrue(isGameWon);
    }

    @Test
    public void givenDifferentGuessAndRandomNumber_whenIsGameLost_thenReturnTrue() {

        // given
        when(consoleReader.input()).thenReturn(51);// guess
        when(numberGenerator.next()).thenReturn(50);// random number
        when(numberGenerator.getMaxNumber()).thenReturn(100);
        when(numberGenerator.getMinNumber()).thenReturn(10);
        game.reset();

        // when
        boolean isGameLost = game.isGameLost();

        // then
        assertTrue(isGameLost);
    }
}
