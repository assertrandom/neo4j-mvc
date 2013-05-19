package com.jiacon.poc.neo4j.helper;

import org.neo4j.graphdb.GraphDatabaseService;

public interface DBCreationService {

	public abstract GraphDatabaseService getGraphDatabase();

	void instantiateDatabase(String rootPath);

}