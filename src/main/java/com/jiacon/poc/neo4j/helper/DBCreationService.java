package com.jiacon.poc.neo4j.helper;

import org.neo4j.graphdb.GraphDatabaseService;

//Interface

public interface DBCreationService {

	public abstract GraphDatabaseService getGraphDatabase();

	void instantiateDatabase(String rootPath);

	public void populateData(String users, String music, String sports);

}