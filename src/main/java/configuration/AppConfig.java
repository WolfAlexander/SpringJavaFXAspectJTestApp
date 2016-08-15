package configuration;

import integration.MessageJDBCTemplate;
import model.TestClickModel;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
    @Bean
    @Scope("singleton")
    public TestClickModel buttonClickModel(){
        return new TestClickModel();
    }

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/javadb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("password");

        return dataSource;
    }

    @Bean
    public MessageJDBCTemplate messageJDBCTemplate(){
        MessageJDBCTemplate template = new MessageJDBCTemplate();
        template.setDataSource(getDataSource());

        return template;
    }
}
