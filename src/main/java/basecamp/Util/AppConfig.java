package basecamp.Util;

import basecamp.ConsoleReader;
import basecamp.Game;
import basecamp.Impl.ConsoleReaderImpl;
import basecamp.Impl.GameImpl;
import basecamp.Impl.NumberGeneratorImpl;
import basecamp.NumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Autowired
    private Environment env;

    @Bean
    public NumberGenerator numberGenerator() {

        int minNumber = env.getProperty("minNumber", Integer.class, 0);
        int maxNumber = env.getProperty("maxNumber", Integer.class, 100);

        return new NumberGeneratorImpl(minNumber, maxNumber);
    }

    @Bean
    public ConsoleReader consoleReader() {
        return new ConsoleReaderImpl();
    }

    @Bean
    public Game game() {

        int guessCount = env.getProperty("guessCount", Integer.class, 10);

        return new GameImpl(numberGenerator(), consoleReader(), guessCount);
    }
}
