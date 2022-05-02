package ua.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan("ua.com")
public class SpringConfig implements WebMvcConfigurer
{
	private static final String PAGES_PATH_PREFIX = "/WEB-INF/pages/";
	private static final String PAGES_PATH_SUFFIX = ".jsp";
	private static final String RESOURCES_PATH_HANDLER = "/resources/**";
	private static final String RESOURCES_PATH_LOCATION = "/resources/";

	@Bean
	public InternalResourceViewResolver viewResolver()
	{
		final InternalResourceViewResolver result = new InternalResourceViewResolver();
		result.setPrefix(PAGES_PATH_PREFIX);
		result.setSuffix(PAGES_PATH_SUFFIX);
		return result;
	}

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler(RESOURCES_PATH_HANDLER).addResourceLocations(RESOURCES_PATH_LOCATION);
	}
}
