package ua.com.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class DispatcherServletInitializer implements WebApplicationInitializer
{
	@Override
	public void onStartup(final ServletContext servletContext)
	{
		final WebApplicationContext context = getContext();
		servletContext.addListener(new ContextLoaderListener(context));
		final ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",
				new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		dispatcher.setInitParameter("throwExceptionIfNoHandlerFound", "true");
	}

	private AnnotationConfigWebApplicationContext getContext()
	{
		final AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setConfigLocation("ua.com.config");
		return context;
	}
}
