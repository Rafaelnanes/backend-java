package rbn.edu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@EnableScheduling
@ComponentScan(basePackages = { "rbn.edu.config", "rbn.edu.controllers", "rbn.edu.filters", "rbn.edu.handler",
	"rbn.edu.security" })
public class ApplicationConfig extends WebMvcConfigurerAdapter {

}
