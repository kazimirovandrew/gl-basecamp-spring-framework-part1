package basecamp.Impl;

import basecamp.NumberGenerator;
import lombok.*;

import java.util.Random;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NumberGeneratorImpl implements NumberGenerator {

    private final Random random = new Random();
    @NonNull
    private int minNumber;
    @NonNull
    private int maxNumber;

    @Override
    public int next() {
        return random.nextInt(maxNumber - minNumber + 1) + minNumber;
    }
}
