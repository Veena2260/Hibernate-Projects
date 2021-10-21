package mvcconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan({"controller","model","dao","service"})
public class MvcConfig {
	@Bean
	public ViewResolver ConfigureViewResolver(){
		System.out.println("in view Resolver");
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setPrefix("/WEB-INF/jsp/");
		view.setSuffix(".jsp");
		return view;
		
	}

}
