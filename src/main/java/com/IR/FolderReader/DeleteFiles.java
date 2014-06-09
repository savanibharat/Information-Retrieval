package com.IR.FolderReader;

import java.io.File;
import java.io.IOException;

public class DeleteFiles {

	public static void main(String[] args) throws IOException {
		
		
		getFiles(new File("Files"));
	}
	static void getFiles(File folder) throws IOException {
		int i=0;
		//This program is used to delete every file in folder
		for (File fileEntry : folder.listFiles()) {

			if (fileEntry.isDirectory()) {
				getFiles(fileEntry);
			} else {
				fileEntry.delete();
				i++;
				System.out.println(i);
				if(i%100==0)
					System.out.println(i);
			}
		}
	}
}
