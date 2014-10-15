package com.IR.QueryIndex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import com.IR.CreateIndex.InvertedIndexByFileMapper;
import com.IR.CreateIndex.StartIndexing;
import com.IR.DisplayContents.DisplayContents;

public class QueryIndex {

	public static void main(String[] args) throws IOException {

		/*
		 * StartIndexing.startIndexing(); String query1="suffix";
		 * ArrayList<Integer> arr1=StartIndexing.queryString(query1);
		 * DisplayContents.displayIndexByArrayList(arr1); String
		 * query2="objective"; ArrayList<Integer>
		 * arr2=StartIndexing.queryString(query2);
		 * DisplayContents.displayIndexByArrayList(arr2);
		 * MergeTheRetrivedList.ORIntersection(arr1, arr2);
		 * MergeTheRetrivedList.ANDUnion(arr1, arr2);
		 */
		InvertedIndexByFileMapper i = new InvertedIndexByFileMapper();
		HashSet<HashMap<String, HashMap<Integer, HashMap<String, ArrayList<Integer>>>>> allDocuments = InvertedIndexByFileMapper
				.createIndexByFileMapperLineByLine();
		HashMap<String, Integer> totalLinesInFile = i.getTotalLinesInFile();

		Iterator<HashMap<String, HashMap<Integer, HashMap<String, ArrayList<Integer>>>>> iterator=allDocuments.iterator();
		
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
}