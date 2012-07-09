package util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppConfigFactory {
	private static ApplicationContext appCtx;
	
	static {
		appCtx =
			new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml", "services.xml"});
	}
	
	public static ApplicationContext getAppContext() {
		return appCtx;
	}
}
