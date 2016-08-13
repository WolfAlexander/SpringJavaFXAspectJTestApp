package configuration;

import aspect.MessageJDBCTemplateAspect;
import aspect.TestClickAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AspectConfig {
    @Bean
    public TestClickAspect buttonClickAspect(){
        return new TestClickAspect();
    }

    @Bean
    public MessageJDBCTemplateAspect messageJDBCTemplateAspect(){
        return new MessageJDBCTemplateAspect();
    }
}