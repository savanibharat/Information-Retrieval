package com.IR.DAO;

import java.net.UnknownHostException;
import java.util.ArrayList;

import org.json.JSONException;

import com.IR.CreateIndex.IndexingInDatabase;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

// TODO: Auto-generated Javadoc
/**
 * The Class DatabaseConnection.
 */
public class DatabaseConnection {

	/** The client. */
	private MongoClient client;
	
	/** The db. */
	private DB db;
	
	/** The collection. */
	private DBCollection collection;
	
	/** The files path. */
	private ArrayList<String> filesPath;
	
	/**
	 * Instantiates a new database connection.
	 */
	public DatabaseConnection() {
		try {
			this.client = new MongoClient();
			this.db = client.getDB("index");
			this.collection = db.getCollection("inverted");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the client.
	 *
	 * @return the client
	 */
	public MongoClient getClient() {
		return client;
	}

	/**
	 * Gets the db.
	 *
	 * @return the db
	 */
	public DB getDb() {
		return db;
	}

	/**
	 * Gets the collection.
	 *
	 * @return the collection
	 */
	public DBCollection getCollection() {
		return collection;
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws JSONException the JSON exception
	 */
	public static void main(String[] args) throws JSONException {
		System.out.println(System.currentTimeMillis());
		DatabaseConnection d=new DatabaseConnection();
		IndexingInDatabase i=new IndexingInDatabase(d);
		i.createIndexInDB();
		System.out.println(System.currentTimeMillis());
	}
}
