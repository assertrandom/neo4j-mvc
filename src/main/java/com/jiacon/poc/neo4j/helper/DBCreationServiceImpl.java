package com.jiacon.poc.neo4j.helper;

import java.io.File;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;

@Service
@PropertySource("classpath:app.properties")
public class DBCreationServiceImpl implements DBCreationService {

	private GraphDatabaseService db = null;

	@Autowired
	private Environment env;

	private static final Logger logger = LoggerFactory.getLogger(DBCreationServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jiacon.poc.neo4j.helper.DBCreationService#getGraphDatabase()
	 */
	@Override
	public GraphDatabaseService getGraphDatabase() {
		logger.info("Gettting the service");
		logger.info(env.getProperty("server.location"));
		return db;
	}

	private void populateData(String users, String ) {

	}

	@Override
	public void instantiateDatabase(String rootPath) {
		// env.getProperty("server.location");
		FileSystemUtils.deleteRecursively(new File(rootPath));
		logger.info("Deleted folder structure ");
		db = new GraphDatabaseFactory().newEmbeddedDatabase(rootPath);
		logger.info("Created database ");

	}

}
