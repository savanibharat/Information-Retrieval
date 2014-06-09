package com.IR.FolderReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class RetriveFilesFromFolder.
 * This class retrives various files from folder and stores in ArrayList
 */
public class RetriveFilesFromFolder {

	/** The files. */
	private static ArrayList<String> filesAbsolutePath = new ArrayList<String>();
	
	/** The folder path. */
	static String folderPath;
	
	/** The file. */
	File file = null;
	
	/** The file mapper. */
	private static HashMap<String, Integer> fileMapper = new HashMap<String, Integer>();

	/**
	 * The Constructor.
	 *
	 * @param folderPath the folder path
	 */
	public RetriveFilesFromFolder(String folderPath) {
		this.folderPath = folderPath;
		file = new File(folderPath);
	}

	/**
	 * Gets the files.
	 *
	 * @return the files
	 * @throws IOException the IO exception
	 */
	public ArrayList<String> getFiles() throws IOException {
		return getFiles(file);
	}

	/**
	 * Gets the files.
	 *
	 * @param folder            the folder
	 * @return the files
	 * @throws IOException the IO exception
	 */
	private static ArrayList<String> getFiles(File folder) throws IOException {

		for (File fileEntry : folder.listFiles()) {

			if (fileEntry.isDirectory()) {
				//if we encounter a folder than we will take files within that folder too
				//recursion is lazy way to get this thing done.
				getFiles(fileEntry);
			} else {
				
				filesAbsolutePath.add(folderPath + "\\" + fileEntry.getName());
			}
		}
		return filesAbsolutePath;
	}

	/**
	 * Gets the file mapper.
	 *
	 * @return the file mapper
	 * @throws IOException the IO exception
	 */
	public HashMap<String, Integer> getFileMapper() throws IOException{
		return getFileMapper(file);
	}
	
	/**
	 * Gets the file mapper.
	 *
	 * @param folder the folder
	 * @return the file mapper
	 * @throws IOException the IO exception
	 */
	private static HashMap<String, Integer> getFileMapper(File folder) throws IOException {
		int i=1;
		for (File fileEntry : folder.listFiles()) {

			if (fileEntry.isDirectory()) {
				getFiles(fileEntry);
			} else {
				//fileMapper is used to map an integer to filename
				//we are keeping filename as key because one folder will have various files and every filename
				//will be different
				//if two folders contains same file then also no problem as we will change that folder name making it 
				//ideal condidate for HashMap's key
				fileMapper.put(folderPath + "\\" + fileEntry.getName(),i);
				i++;
			}
		}
		return fileMapper;
	}

}
