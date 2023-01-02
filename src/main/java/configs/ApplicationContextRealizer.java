package configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("java")
@EnableWebMvc
public class ApplicationContextRealizer implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;

    @Autowired
    public ApplicationContextRealizer(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


}
