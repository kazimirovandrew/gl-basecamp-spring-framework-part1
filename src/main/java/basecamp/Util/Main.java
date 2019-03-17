package basecamp.Util;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        // create context
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
    }
}
