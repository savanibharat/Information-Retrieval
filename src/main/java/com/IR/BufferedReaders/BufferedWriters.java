package com.IR.BufferedReaders;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriters {

		/**
		 * Retrive buffered reader.
		 *
		 * @param filePath the file path
		 * @return the buffered reader
		 */
		public static BufferedWriter retriveBufferedWriter(String filePath) {
			//returning the object of BufferedWriter object of particular file.
			//No need to create several BufferedWriters in same .java file
			//Method is static so will be called as BufferedWriters.retriveBufferedWriter(path);
			try {
				return new BufferedWriter(
						new FileWriter(new File(filePath),true));//true means we will append data at the EOF is same
																 //file is encountered as the article in wiki
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
}
