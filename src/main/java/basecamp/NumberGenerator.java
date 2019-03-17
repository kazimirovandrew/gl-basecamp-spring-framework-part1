package basecamp;

public interface NumberGenerator {

    int next();

    int getMinNumber();

    int getMaxNumber();

    void setMinNumber(int minNumber);

    void setMaxNumber(int maxNumber);

}
