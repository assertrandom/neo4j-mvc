/**
 * 
 */
package com.jiacon.poc.neo4j.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.jiacon.poc.neo4j.beans.ServerInfoBean;

/**
 * @author manalesl
 * 
 */
@Configuration
@PropertySource("classpath:app.properties")
public class AppConfigurator {

	@Autowired
	private Environment env;

	@Bean
	public ServerInfoBean getServerInfo() {
		ServerInfoBean serverInfo = new ServerInfoBean();
		serverInfo.setRootLocation(env.getProperty("server.location"));
		return serverInfo;
	}

}
