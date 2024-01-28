package mardeev.homeworkaston_2.config;





import org.springframework.context.annotation.*;



import java.util.logging.Logger;

@Configuration
@ComponentScan("mardeev.homeworkaston_2")
public class ApplicationConfig {


    @Bean
    @Scope("prototype")
    public Logger logger() {
        return Logger.getLogger(getClass().getName());
    }
}
