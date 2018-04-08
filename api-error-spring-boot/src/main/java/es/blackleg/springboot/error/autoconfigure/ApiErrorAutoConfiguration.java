package es.blackleg.springboot.error.autoconfigure;

import es.blackleg.springboot.error.ApiErrorAttributes;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcProperties.Servlet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author Hector Espert
 */
@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass({ Servlet.class, DispatcherServlet.class })
@AutoConfigureAfter(ErrorMvcAutoConfiguration.class)
public class ApiErrorAutoConfiguration {

    @Bean
    public ApiErrorAttributes errorAttributes() {
        return new ApiErrorAttributes();
    }

}
