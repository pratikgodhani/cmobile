/**
 * 
 */
package org.cmobile.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.context.ConfigurableWebApplicationContext;

/**
 * This is custom application initializer used by the application. reference to
 * this is specified in web.xml file.
 * 
 * In this implementation this custom initializer is used to set a profile using
 * system environment variable. Based on the value specified in environment
 * variable, the specified profile is loaded.
 * 
 */
public class ProfileInitializer implements
		ApplicationContextInitializer<ConfigurableWebApplicationContext> {

	@Override
	public void initialize(ConfigurableWebApplicationContext applicationContext) {

		String activeProfile=System.getenv("MYAPP_ACTIVE_PROFILE");
		if(activeProfile==null){
			System.exit(1);
		}else{
			applicationContext.getEnvironment().setActiveProfiles(activeProfile);	
		}
	}

}
