package by.application.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.sql.DataSource;

@Configuration
@ComponentScan("by.application")
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;

    @Autowired
    public SpringConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean // настраиваем Thymeleaf и указываем папку где будут лежать представления и с каким расширением
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/"); //папка где хранятся представления
        templateResolver.setSuffix(".html"); // расширение представлений
        return templateResolver;
    }

    @Bean // производим конфигурацию представлений
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Override // указываем спрингу что хотим использовать маршрутизатор Thymeleaf
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/styles/**").addResourceLocations("/WEB-INF/styles/");
        registry.addResourceHandler("/scripts/**").addResourceLocations("/WEB-INF/scripts/");
           }

    @Bean //создаём бин который будет указывать на БД к которой мы хотим подключится
    public DataSource dataSource(){
        DriverManagerDataSource dataSource =new DriverManagerDataSource(); // создаём драйвер менеджер

        dataSource.setDriverClassName("org.postgresql.Driver"); // указываем драйвер на подключение к БД
        dataSource.setUrl("jdbc:postgresql://localhost:5432/AppDataBase"); // указываем путь подключение
        dataSource.setUsername("postgres"); // казываем название профиля
        dataSource.setPassword("1431"); // указываем пароль
        return dataSource; // возвращаем объект класса  DriverManager
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());// создаём обёртку JDBC API и передаём ему БД к которой мы хотим подключиться
    }
}
