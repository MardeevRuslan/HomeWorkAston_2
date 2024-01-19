package mardeev.homeworkaston_2.main;

import mardeev.homeworkaston_2.application.Application;
import mardeev.homeworkaston_2.application.ApplicationImpl;
import mardeev.homeworkaston_2.config.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Application application = context.getBean(ApplicationImpl.class);
        application.run();
    }
}
