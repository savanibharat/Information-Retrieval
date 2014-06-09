package com.IR.CreateIndex;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;

import com.IR.BufferedReaders.BufferedReaders;
import com.IR.DAO.DatabaseConnection;
import com.IR.DAO.FileDetails;
import com.IR.DAO.Search;
import com.IR.FolderReader.RetriveFilesFromFolder;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class IndexingInDatabase {

	private BufferedReader br;
	@SuppressWarnings("unused")
	private DatabaseConnection connection;
	@SuppressWarnings("unused")
	private MongoClient client;
	@SuppressWarnings("unused")
	private DB db;
	private DBCollection collection;
	private ArrayList<String> filesPath;
	@SuppressWarnings("unused")
	private DBObject query;
	@SuppressWarnings("unused")
	private DBObject cursor;
	private BasicDBObject object;

	public IndexingInDatabase(DatabaseConnection connection) {

		this.connection = connection;
		client = connection.getClient();
		db = connection.getDb();
		collection = connection.getCollection();
		collection.createIndex(new BasicDBObject("Key",1));
		String folderPath = "Files";
		RetriveFilesFromFolder retriveFiles = new RetriveFilesFromFolder(
				folderPath);
		try {
			this.filesPath = retriveFiles.getFiles();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createIndexInDB() throws JSONException {
		createIndexInDB(filesPath);
	}

	private void createIndexInDB(ArrayList<String> filesPath)
			throws JSONException {

		for (String filePath : filesPath) {
			System.out.println(filePath);
			br = BufferedReaders.retriveBufferedReader(filePath);
			try {

				if (br != null) {
					String str;
					int lineNumber = 0;
					while ((str = br.readLine()) != null) {
						lineNumber++;
						String[] newStr = str.replaceAll("[^a-zA-Z0-9 ]+", "")
								.split(" ");

						for (int i = 0; i < newStr.length; i++) {
							if (newStr[i].length() >= 2) {
								BasicDBObject query = new BasicDBObject();
								query.put("Key", newStr[i]);
								
								query.put("Files.File", filePath.replace("Files\\", ""));
								DBCursor cursor = collection.find(query);
								//check if the current key is in the database.
								//DBCursor return the iterator if it contains
								if (cursor.hasNext()) {
									//Database has the key.
									//Well things are easy then
									//Just push that line number and index to DB
									//Enjoy
									BasicDBObject newDocument = new BasicDBObject();
									newDocument.put("$push",
											new BasicDBObject().append(
													"Files.$.Location",
													lineNumber + "." + i));
									collection.update(query, newDocument);
								} else {// value does not exists.
										
									BasicDBObject queryKey = new BasicDBObject();
									queryKey.put("Key", newStr[i]);
									DBCursor cursorwithKey = collection.find(queryKey);
									//start the things that are required to add in DB
									Search search = new Search();
									search.setKeyWord(newStr[i]);
									ArrayList<String> wordLocation = new ArrayList<String>();
									wordLocation.add(lineNumber + "." + i);
									FileDetails fileDetails = new FileDetails(
											filePath.replace("Files\\", ""), wordLocation);
									ArrayList<FileDetails> fileDetailsArrayList = new ArrayList<FileDetails>();
									fileDetailsArrayList.add(fileDetails);
									
									if (!cursorwithKey.hasNext()) {
										object = new BasicDBObject("Key",
												search.getKeyWord()).append(
												"Files", fileDetailsArrayList);
										collection.insert(object);
										//System.out.println("if");
									} else {
										
										BasicDBObject newDocumentFileArray = new BasicDBObject();
										newDocumentFileArray.put("$push",
												new BasicDBObject(
														"Files",
														fileDetails));
										
										collection.update(queryKey,
												newDocumentFileArray);
										//System.out.println("else");
									}
									//System.out.println("inserted record "
											//+ newStr[i]);
								}
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				//connection.getClient().close();
			}
		}
	}
}

/***
 * database structure
 * {
    "Files": [
        {
            "File": "AdvancedEncryptionStandard",
            "Location": [
                "2.45",   2.45 means line number 2 and index 45
                "7.11",
                "7.27",
                "9.38",
                "9.58",
                "16.16",
                "20.21",
                "20.24",
                "26.6",
                "26.40",
                "28.46"
            ]
        }
    ]
}
 * 
 * */

