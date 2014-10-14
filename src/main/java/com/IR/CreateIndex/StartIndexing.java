package com.IR.CreateIndex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

// TODO: Auto-generated Javadoc
/**
 * The Class StartIndexing.
 */
public class StartIndexing {

	/**
	 * The main method.
	 *
	 * @param args the args
	 * @throws IOException the IO exception
	 */
	public static void startIndexing() throws IOException{
		InvertedIndexByFileName fileName = new InvertedIndexByFileName();
		InvertedIndexByFileMapper fileMapper=new InvertedIndexByFileMapper();
		startIndexing(fileName,fileMapper);
	}
	
	public static ArrayList<Integer> queryString(String str){
		return queryStringInIndex(str);
		
	}
	
	private static ArrayList<Integer> queryStringInIndex(String str){
		ArrayList<Integer> arr=new ArrayList<Integer>(InvertedIndexByFileMapper.queryIndexFileMapper(str));
		Collections.sort(arr);
		return arr;
		
	}
	
	
	private static void startIndexing(InvertedIndexByFileName fileName,InvertedIndexByFileMapper fileMapper) throws IOException{
		
		fileName.createIndexByFileName();
		//fileName.displayIndex();
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		fileMapper.createIndexByFileMapper();
		//fileMapper.displayIndex();
		
		
	}
}