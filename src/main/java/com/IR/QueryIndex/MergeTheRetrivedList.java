package com.IR.QueryIndex;

import java.util.ArrayList;
import java.util.HashSet;

// TODO: Auto-generated Javadoc
/**
 * The Class MergeTheRetrivedList.
 */
public class MergeTheRetrivedList {

	/**
	 * OR intersection.
	 *
	 * @param arr1 the arr1
	 * @param arr2 the arr2
	 */
	public static void ORIntersection(ArrayList<Integer> arr1,
			ArrayList<Integer> arr2) {

		HashSet<Integer> unionSet = new HashSet<Integer>();
		for (int i = 0; i < arr1.size(); i++) {
			unionSet.add(arr1.get(i));
		}
		for (int i = 0; i < arr2.size(); i++) {
			unionSet.add(arr2.get(i));
		}
		System.out.println(unionSet);
	}

	/**
	 * AND union.
	 *
	 * @param arr1 the arr1
	 * @param arr2 the arr2
	 */
	public static void ANDUnion(ArrayList<Integer> arr1,
			ArrayList<Integer> arr2) {

		ArrayList<Integer> intersectMerge=new ArrayList<Integer>();
		int i=0,j=0;
		//Merge the two retrieved list for specific query
		while(i!=arr1.size() && j!=arr2.size()){
			
			if(arr1.get(i)==arr2.get(j)){
				intersectMerge.add(arr1.get(i));
				i++;
				j++;
			}
			else if(arr1.get(i)<arr2.get(j)){
				i++;
			}
			else{
				j++;
			}
		}
		System.out.println();
		for (int j2 = 0; j2 < intersectMerge.size(); j2++) {
			System.out.print(intersectMerge.get(j2)+" ");
		}
	}
}
