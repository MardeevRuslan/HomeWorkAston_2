package mardeev.homeworkaston_2.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Посмотреть подробнее можно тут:
 * https://javarush.com/quests/lectures/questspring.level04.lecture03
 *
 * Если кратко, то этот класс позволяет нам конфигурировать DispatcherServlet
 * Сама же конфигурация автоматически подключиться в спринге
 */
public class DispatcherConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    /**
     * Данный метод отвечает за нашу конфигурацию контекста
     * @see SpringConfig
     * @return массив классов, в которых лежат наши конфигурации
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ApplicationConfig.class};
    }

    /**
     * Данный метод отвечает за точки "вхождения" эндпоинтов
     * Тут просто указываем /, чтобы любой запрос проходил через это приложение
     * @return массив String, который указывает, какие запросы обрабатывать
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
