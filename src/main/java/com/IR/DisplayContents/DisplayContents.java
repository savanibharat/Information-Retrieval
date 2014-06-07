package com.IR.DisplayContents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class DisplayContents.
 */
public class DisplayContents {

	/**
	 * Display index by file name.
	 *
	 * @param index the index
	 */
	public static void displayIndexByFileName(HashMap<String, LinkedList<String>> index){
		for (Map.Entry<String, LinkedList<String>> mapper : index.entrySet()) {
			System.out.println(mapper);
		}
	}
	
	/**
	 * Display index by file mapper.
	 *
	 * @param index the index
	 */
	public static void displayIndexByFileMapper(HashMap<String, LinkedList<Integer>> index){
		for (Map.Entry<String, LinkedList<Integer>> mapper : index.entrySet()) {
			System.out.println(mapper);
		}
	}
	
	public static void displayIndexByArrayList(ArrayList<Integer> arr){
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i)+" ");
		}
		System.out.println();
	}
	
}
