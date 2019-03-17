package basecamp.Impl;

import basecamp.ConsoleReader;
import basecamp.Game;
import basecamp.NumberGenerator;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@RequiredArgsConstructor()
@NoArgsConstructor
@Getter
@Setter
public class GameImpl implements Game {

    @NonNull
    private NumberGenerator numberGenerator;
    @NonNull
    private ConsoleReader consoleReader;

    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    @NonNull
    private int remainingGuesses;
    private boolean validNumberRange = true;

    @PostConstruct
    @Override
    public void reset() {
        log.info("Guess Number");

        smallest = numberGenerator.getMinNumber();
        biggest = numberGenerator.getMaxNumber();

        number = numberGenerator.next();
        log.info(number + "");

        do {
            log.info("Enter the number between " + smallest + " and " + biggest);
            guess = consoleReader.input();
            check();
        } while (!isGameWon() && !(remainingGuesses <= 0));


        log.info("the number is {}", number);
        log.info("My guess = {}", guess);

        log.info("Result = {}", isGameWon() ? "Win" : "Lose");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("in Game preDestroy()");
    }

    @Override
    public void check() {

        checkValidNumberRange();

        if (validNumberRange) {
            if (guess > number) {
                biggest = guess - 1;
            }

            if (guess < number) {
                smallest = guess + 1;
            }
        }

        remainingGuesses--;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    private void checkValidNumberRange() {
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }

}
