package Configure;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

public class MySpringMvcDispatcherConfigureInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {SpringConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	} 
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException{
		super.onStartup(servletContext);
		registerHiddenFieldFilter(servletContext);
	}
	
	public void registerHiddenFieldFilter(ServletContext servletContext) {
		servletContext.addFilter("hiddenHttpFieldFilter", new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null, true, "/*");
	}
}
