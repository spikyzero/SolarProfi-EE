package ua.com.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
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
	private static final String COOKIE_NAME = "language";
	private static final String MESSAGE_SOURCE = "localization/messages";

	@Bean
	public InternalResourceViewResolver viewResolver()
	{
		final InternalResourceViewResolver result = new InternalResourceViewResolver();
		result.setPrefix(PAGES_PATH_PREFIX);
		result.setSuffix(PAGES_PATH_SUFFIX);
		return result;
	}

	@Bean
	public LocaleResolver localeResolver()
	{
		final CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		cookieLocaleResolver.setDefaultLocale(Locale.ENGLISH);
		cookieLocaleResolver.setCookieName(COOKIE_NAME);
		return cookieLocaleResolver;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor()
	{
		return new LocaleChangeInterceptor();
	}

	@Bean
	public MessageSource messageSource()
	{
		final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename(MESSAGE_SOURCE);
		return messageSource;
	}

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler(RESOURCES_PATH_HANDLER).addResourceLocations(RESOURCES_PATH_LOCATION);
	}

	@Override
	public void addInterceptors(final InterceptorRegistry registry)
	{
		registry.addInterceptor(localeChangeInterceptor());
	}
}
