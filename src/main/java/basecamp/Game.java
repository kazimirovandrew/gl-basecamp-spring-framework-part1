package basecamp;

public interface Game {

    int getSmallest();

    int getBiggest();

    void reset();

    void check();

    boolean isValidNumberRange();

    boolean isGameWon();

    boolean isGameLost();

}
