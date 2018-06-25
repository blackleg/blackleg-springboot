package es.blackleg.springboot.error.autoconfigure;

import es.blackleg.springboot.error.ApiErrorAttributes;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import javax.servlet.Servlet;

/**
 *
 * @author Hector Espert
 */
@Configuration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@ConditionalOnClass({ Servlet.class, DispatcherServlet.class })
@AutoConfigureAfter(ErrorMvcAutoConfiguration.class)
public class ApiErrorAutoConfiguration {

    @Bean
    public ApiErrorAttributes errorAttributes(ServerProperties serverProperties) {
        return new ApiErrorAttributes(serverProperties.getError().isIncludeException());
    }

}
