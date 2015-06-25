package au.com.optus;


import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DictionaryApplication {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(DictionaryApplication.class);
	
	public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DictionaryApplication.class, args);

        LOGGER.info("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
        	LOGGER.info("bean name {} ", beanName);
        }
    }
}
