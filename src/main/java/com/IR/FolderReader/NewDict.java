package com.IR.FolderReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
//Experiemental java class. 
//Not used in project
//was developed to understand the procedure of the inverted indexing
public class NewDict {
	public static void main(String[] args) throws Throwable {
		HashMap<String, ArrayList<Integer>> hashMap = null;// = new HashMap<String,
													// ArrayList<Integer>>();

		HashMap<Integer, HashMap<String, ArrayList<Integer>>> hashMapLine = null;// = new HashMap<Integer, HashMap<String, ArrayList<Integer>>>();

		HashMap<String, HashMap<Integer, HashMap<String, ArrayList<Integer>>>> document = null;// = new HashMap<String, HashMap<Integer, HashMap<String, ArrayList<Integer>>>>();

		ArrayList<Integer> c = null;
		for (int doc = 1; doc <= 2; doc++) {

			String filename="StringTokenizerInput"+doc+".txt";
			document= new HashMap<String, HashMap<Integer, HashMap<String, ArrayList<Integer>>>>();
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(filename));
			BufferedWriter bw = new BufferedWriter(new FileWriter("index.txt"));
			hashMapLine=new HashMap<Integer, HashMap<String, ArrayList<Integer>>>();
			String str;
			int lineNumber = 0;
			while ((str = br.readLine()) != null) {
				lineNumber++;
				hashMap = new HashMap<String, ArrayList<Integer>>();
				String[] newStr = str.toLowerCase().split(" ");
				for (int i = 0; i < newStr.length; i++) {
					if (newStr[i].length() > 2) {

						c = new ArrayList<Integer>();

						if (hashMap.containsKey(newStr[i])) {

							c = hashMap.get(newStr[i]);
							if (!c.contains(i)) {
								c.add(i);
								hashMap.put(newStr[i], c);
								hashMapLine.put(lineNumber, hashMap);
								document.put(filename, hashMapLine);
							}
						} else {

							c.add(i);
							hashMap.put(newStr[i], c);
							hashMapLine.put(lineNumber, hashMap);
							document.put(filename, hashMapLine);
						}
					}
				}
			}
			System.out.println(document);
		}
		String find="string";
		
		/*for(int i=2;i<=2;i++){
			
			String filename="StringTokenizerInput"+i+".txt";
			
			hashMapLine=document.get(filename);
			for(Integer k:hashMapLine.keySet()){
				hashMap=hashMapLine.get(k);
				System.out.println(filename+" "+hashMap.get(find));
			}
		}*/
	}
}
