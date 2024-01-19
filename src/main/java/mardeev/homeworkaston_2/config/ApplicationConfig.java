package mardeev.homeworkaston_2.config;




import mardeev.homeworkaston_2.database.MyDataBase;
import mardeev.homeworkaston_2.database.MyDataBaseImpl;
import org.springframework.context.annotation.*;



import java.util.logging.Logger;

@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan(basePackages = {"mardeev/homeworkaston_2/*"})
public class ApplicationConfig {

    @Bean
    public MyDataBase dataBase() {
        return new MyDataBaseImpl();
    }

    @Bean
    @Scope("prototype")
    public Logger logger() {
        return Logger.getLogger(getClass().getName());
    }

}
