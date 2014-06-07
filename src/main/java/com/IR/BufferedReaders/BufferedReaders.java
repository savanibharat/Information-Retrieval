package com.IR.BufferedReaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class BufferedReaders {

	/**
	 * Retrive buffered reader.
	 *
	 * @param filePath the file path
	 * @return the buffered reader
	 */
	public static BufferedReader retriveBufferedReader(String filePath) {
		//returning the object of BufferedReader object of particular file.
		//No need to create several BufferedReaders in same .java file
		//Method is static so will be called as BufferedReaders.retriveBufferedReader(path);
		try {
			return new BufferedReader(
					new FileReader(new File(filePath)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
