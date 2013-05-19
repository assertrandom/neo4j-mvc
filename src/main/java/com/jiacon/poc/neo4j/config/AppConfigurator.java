/**
 * 
 */
package com.jiacon.poc.neo4j.config;

import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import com.jiacon.poc.neo4j.beans.ServerInfoBean;
import com.jiacon.poc.neo4j.helper.DBCreationService;

/**
 * @author manalesl
 * 
 */
@Configuration
@PropertySource("classpath:app.properties")
public class AppConfigurator {

	@Autowired
	private Environment env;

	@Autowired
	private DBCreationService dbCreationService;

	@Bean
	@Scope(BeanDefinition.SCOPE_SINGLETON)
	public ServerInfoBean instantiateNeo4JServer() {
		ServerInfoBean serverInfo = new ServerInfoBean();
		serverInfo.setRootLocation(env.getProperty("server.location"));
		GraphDatabaseService graphDatabase = dbCreationService.getGraphDatabase();
		return serverInfo;
	}

}
