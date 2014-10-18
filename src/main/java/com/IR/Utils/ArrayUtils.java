/*
Copyright 2014 Array-Utilities

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

 * */

package com.IR.Utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class ArrayUtils.
 */
public class ArrayUtils {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		// set operations ordered set
		//convert ket to list value to list etc
		// add subs multi divide mod
		// equal not equal
		// to set to map
		// auto fill
		// nulltoempty
		// subarray
		// reverse
		// indexof
		// lastindexof
		// contains
		// to primitive
		
		
		
		//Set<Object> a = new LinkedHashSet<Object>(); 
		/*a.add("a"); 
		a.add("b");*/
		//System.out.println(a);
		//Set<Object> b = new LinkedHashSet<Object>();
		/*b.add("a");
		b.add("d");*/
		//System.out.println(b);
		
		//System.out.println(diffAbyB(a,b));

		List<String> list1 = new ArrayList<String>();
		list1.add("A");
		list1.add("r");
		list1.add("a");
		System.out.println(list1);
		List<String> list2 = new ArrayList<String>();
		
		list2.add("r");
		list2.add("A");
		list2.add("A");
		System.out.println(list2);
		System.out.println(subArray(list1,list2));
		List<Object> list=new ArrayList<Object>();
		list.add(1);
		list.add(-1);
		list.add("-a");
		list.add(-5f);
		list.add(-8d);
		//System.out.println(absIntegerList(list));
		// System.out.println(union(b,a));
		/*
		 * System.out.println(isEmpty(a)); System.out.println(isEmpty(a));
		 * System.out.println(isEmpty(a));
		 */
	}

	/**
	 * Checks if is empty.
	 *
	 * @param <E>
	 *            the element type
	 * @param collection
	 *            the collection
	 * @return true, if is empty
	 */
	public static <E> boolean isEmpty(Collection<? super E> collection) {

		if ((collection.size() == 0) || (collection == null))
			return true;
		return false;
	}

	/**
	 * Union.
	 *
	 * @param <T> the generic type
	 * @param setA            the set a
	 * @param setB            the set b
	 * @return the sets the
	 */
	public static <T> Set<T> union(Set<T> setA, Set<T> setB) {

		// SetA empty & SetB has values
		if (isEmpty(setA) && !isEmpty(setB)) {
			return Collections.unmodifiableSet(setB);
		}

		// SetA has values & SetB is empty
		if (!isEmpty(setA) && isEmpty(setB)) {
			return Collections.unmodifiableSet(setA);
		}

		// Both set are empty
		if (isEmpty(setA) && isEmpty(setB)) {
			return new LinkedHashSet<T>();
		}

		if (setA.equals(setB)) {
			return setA;
		}

		Set<T> setC = new LinkedHashSet<T>();
		Iterator<T> iterA = setA.iterator();
		Iterator<T> iterB = setB.iterator();

		while (iterA.hasNext()) {
			setC.add(iterA.next());
		}
		while (iterB.hasNext()) {
			setC.add(iterB.next());
		}
		return Collections.unmodifiableSet(setC);
	}

	/**
	 * Intersection.
	 *
	 * @param <T> the generic type
	 * @param setA            the set a
	 * @param setB            the set b
	 * @return the sets the
	 */
	public static <T> Set<T> intersection(Set<T> setA, Set<T> setB) {
		// SetA empty & SetB has values
		if (isEmpty(setA) && !isEmpty(setB)) {
			return Collections.unmodifiableSet(new LinkedHashSet<T>());
		}

		// SetA has values & SetB is empty
		if (!isEmpty(setA) && isEmpty(setB)) {
			return Collections.unmodifiableSet(new LinkedHashSet<T>());
		}

		// Both set are empty
		if (isEmpty(setA) && isEmpty(setB)) {
			return Collections.unmodifiableSet(new LinkedHashSet<T>());
		}

		if (setA.equals(setB)) {
			return setA;
		}

		Set<T> setC = new LinkedHashSet<T>();
		Iterator<T> iterA = setA.iterator();

		while (iterA.hasNext()) {
			T obj = iterA.next();
			if (setB.contains(obj)) {
				setC.add(obj);
			}
		}
		return Collections.unmodifiableSet(setC);
	}

	/**
	 * Checks if is sub set.
	 *
	 * @param <T> the generic type
	 * @param setA            the set a
	 * @param setB            the set b
	 * @return true, if is sub set
	 */
	public static <T> boolean isSubSet(Set<T> setA, Set<T> setB) {

		// SetA empty & SetB has values
		if (isEmpty(setA) && !isEmpty(setB)) {
			return false;
		}

		// SetA has values & SetB is empty
		if (!isEmpty(setA) && isEmpty(setB)) {
			return true;
		}

		// Both set are empty
		if (isEmpty(setA) && isEmpty(setB)) {
			return true;// double check
		}

		if (setA.equals(setB)) {
			return true;
		}

		// If setA is subset of setB then setA size will be same or less than
		// setB
		if (setA.size() <= setB.size()) {

			Iterator<T> iterA = setA.iterator();
			while (iterA.hasNext()) {
				if (!setB.contains(iterA.next())) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * Cartesian product.
	 *
	 * @param <T> the generic type
	 * @param setA the set a
	 * @param setB the set b
	 * @return the sets the
	 */
	@SuppressWarnings("unchecked")
	public static <T> Set<T> cartesianProduct(Set<T> setA, Set<T> setB) {

		// SetA empty & SetB has values
		if (isEmpty(setA) && !isEmpty(setB)) {
			return Collections.unmodifiableSet(setB);
		}

		// SetA has values & SetB is empty
		if (!isEmpty(setA) && isEmpty(setB)) {
			return Collections.unmodifiableSet(setA);
		}

		// Both set are empty
		if (isEmpty(setA) && isEmpty(setB)) {
			return Collections.unmodifiableSet(new LinkedHashSet<T>());
		}
		
		T[] A=(T[]) setA.toArray();
		T[] B=(T[]) setB.toArray();

		ArrayList<ArrayList<T>> list=new ArrayList<ArrayList<T>>();
		ArrayList<T> subList=new ArrayList<T>();
		
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				
				subList.add(A[i]);
				subList.add(B[j]);
				list.add(subList);
				subList=new ArrayList<T>();
			}
		}
		
		Set<T> setC=new LinkedHashSet<T>();
		Iterator<ArrayList<T>> listIter=list.iterator();
		while(listIter.hasNext()){
			setC.add((T) listIter.next());
		}
		return Collections.unmodifiableSet(setC);
	}

	/**
	 *  A = {1, 2, 3, 4, 5} and B = {3, 4, 5, 6, 7, 8}. 
	 * To find the difference A - B of these two sets, we begin by writing all of the elements of A, 
	 * and then take away every element of A that is also an element of B. Since A shares the elements 
	 * 3, 4 and 5 with B, this gives us the set difference 
	 * A - B = {1, 2 }.
	 *
	 * @param <T> the generic type
	 * @param setA the set a
	 * @param setB the set b
	 * @return the sets the
	 */
	
	public static <T> Set<T> diffAbyB(Set<T> setA, Set<T> setB) {

		// SetA empty & SetB has values
		if (isEmpty(setA) && !isEmpty(setB)) {
			return Collections.unmodifiableSet(setB);
		}

		// SetA has values & SetB is empty
		if (!isEmpty(setA) && isEmpty(setB)) {
			return Collections.unmodifiableSet(setA);
		}

		// Both set are empty
		if (isEmpty(setA) && isEmpty(setB)) {
			return Collections.unmodifiableSet(new LinkedHashSet<T>());
		}

		Set<T> setC = new LinkedHashSet<T>();
		Iterator<T> iterA = setA.iterator();
		Iterator<T> iterB = setB.iterator();

		while (iterA.hasNext()) {
			setC.add(iterA.next());
		}
		while (iterB.hasNext()) {
			T o = iterB.next();
			if (setC.contains(o)) {
				setC.remove(o);
			}
		}
		return Collections.unmodifiableSet(setC);
	}
	
	/**
	 * ***********************************************************************************************.
	 *
	 * @param <T> the generic type
	 * @param list1 the list1
	 * @param list2 the list2
	 * @return the list
	 */
	/**
	 * Union list.
	 *
	 * @param <T> the generic type
	 * @param list1            the list1
	 * @param list2            the list2
	 * @return the list
	 */
	public static <T> List<T> unionList(List<T> list1, List<T> list2) {

		if (isEmpty(list1) && isEmpty(list2)) {
			return new ArrayList<T>();
		}
		// list1 empty & list2 has values
		if (isEmpty(list1) && !isEmpty(list2)) {
			return list2;
		}

		// list1 has values & list2 is empty
		if (!isEmpty(list1) && isEmpty(list2)) {
			return list1;
		}

		if (list1.equals(list2)) {
			return list1;
		}

		List<T> list3 = new ArrayList<T>();
		for (T object : list1) {
			list2.add(object);
		}

		for (T object : list2) {
			if (!list3.contains(object)) {
				list3.add(object);
			}
		}
		return list3;
	}

	/**
	 * Intersect list.
	 *
	 * @param <T> the generic type
	 * @param list1            the list1
	 * @param list2            the list2
	 * @return the list
	 */
	public static <T> List<T> intersectList(List<T> list1, List<T> list2) {

		if (isEmpty(list1) && isEmpty(list2)) {
			return new ArrayList<T>();
		}
		// list1 empty & list2 has values
		if (isEmpty(list1) && !isEmpty(list2)) {
			return new ArrayList<T>();
		}

		// list1 has values & list2 is empty
		if (!isEmpty(list1) && isEmpty(list2)) {
			return new ArrayList<T>();
		}

		if (list1.equals(list2)) {
			return list1;
		}

		List<T> list3 = new ArrayList<T>();
		for (T object : list1) {
			if (list2.contains(object)) {
				if (!list3.contains(object)) {
					list3.add(object);
				}
			}
		}
		return list3;
	}

	/**
	 * Checks if is sub set list.
	 *
	 * @param <T> the generic type
	 * @param list1 the list1
	 * @param list2 the list2
	 * @return true, if is sub set list
	 */
	public static <T> boolean isSubSetList(List<T> list1, List<T> list2) {

		// SetA empty & SetB has values
		if (isEmpty(list1) && !isEmpty(list2)) {
			return false;
		}

		// SetA has values & SetB is empty
		if (!isEmpty(list1) && isEmpty(list2)) {
			return true;
		}

		// Both set are empty
		if (isEmpty(list1) && isEmpty(list2)) {
			return true;// double check
		}

		if (list1.equals(list2)) {
			return true;
		}

		// If setA is subset of setB then setA size will be same or less than
		// setB
		if (list1.size() <= list2.size()) {

			Iterator<T> iterA = list1.iterator();
			while (iterA.hasNext()) {
				if (!list2.contains(iterA.next())) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Cartesian product list.
	 *
	 * @param <T> the generic type
	 * @param listA the list a
	 * @param listB the list b
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> cartesianProductList(List<T> listA, List<T> listB) {

		// ListA empty & ListB has values
		if (isEmpty(listA) && !isEmpty(listB)) {
			return listB;
		}

		// ListA has values & List is empty
		if (!isEmpty(listA) && isEmpty(listB)) {
			return listA;
		}

		// Both List are empty
		if (isEmpty(listA) && isEmpty(listB)) {
			return new ArrayList<T>();
		}

		T[] A = (T[]) listA.toArray();
		T[] B = (T[]) listB.toArray();

		ArrayList<ArrayList<T>> list = new ArrayList<ArrayList<T>>();
		ArrayList<T> subList = new ArrayList<T>();

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				subList.add(A[i]);
				subList.add(B[j]);
				if (!list.contains(subList)) {
					list.add(subList);
				}
				subList = new ArrayList<T>();
			}
		}
		ArrayList<T> setC = new ArrayList<T>();
		Iterator<ArrayList<T>> listIter = list.iterator();
		while (listIter.hasNext()) {
			setC.add((T) listIter.next());
		}
		return setC;
	}
	
	/**
	 * *************************************************************************
	 * *****************.
	 *
	 * @param listA
	 *            the list a
	 * @param listB
	 *            the list b
	 * @return the list
	 */

	public static List<Integer> addIntegerLists(List<Integer> listA,
			List<Integer> listB) {

		// ListA empty & ListB has values
		if (isEmpty(listA) && !isEmpty(listB)) {
			return listB;
		}

		// ListA has values & ListB is empty
		if (!isEmpty(listA) && isEmpty(listB)) {
			return listA;
		}

		// Both List are empty
		if (isEmpty(listA) && isEmpty(listB)) {
			return new ArrayList<Integer>();
		}

		// [1,2,3,4,5]
		// [3,4,5,6,7,8,9]
		ArrayList<Integer> list = new ArrayList<Integer>();
		int i = 0;
		int j = 0;

		while (i < listA.size() && j < listB.size()) {
			list.add(listA.get(i) + listB.get(j));
			i++;
			j++;

		}
		while (i < listA.size()) {
			list.add(listA.get(i));
			i++;
		}
		while (j < listB.size()) {
			list.add(listB.get(j));
			j++;
		}
		System.out.println("list is " + list);
		return list;
	}

	/**
	 * Adds the float lists.
	 *
	 * @param listA
	 *            the list a
	 * @param listB
	 *            the list b
	 * @return the list
	 */
	public static List<Float> addFloatLists(List<Float> listA, List<Float> listB) {

		// ListA empty & ListB has values
		if (isEmpty(listA) && !isEmpty(listB)) {
			return listB;
		}

		// ListA has values & ListB is empty
		if (!isEmpty(listA) && isEmpty(listB)) {
			return listA;
		}

		// Both List are empty
		if (isEmpty(listA) && isEmpty(listB)) {
			return new ArrayList<Float>();
		}

		// [1,2,3,4,5]
		// [3,4,5,6,7,8,9]
		ArrayList<Float> list = new ArrayList<Float>();
		int i = 0;
		int j = 0;

		while (i < listA.size() && j < listB.size()) {
			list.add(listA.get(i) + listB.get(j));
			i++;
			j++;

		}
		while (i < listA.size()) {
			list.add(listA.get(i));
			i++;
		}
		while (j < listB.size()) {
			list.add(listB.get(j));
			j++;
		}
		System.out.println("list is " + list);
		return list;
	}

	/**
	 * Adds the double lists.
	 *
	 * @param listA
	 *            the list a
	 * @param listB
	 *            the list b
	 * @return the list
	 */
	public static List<Double> addDoubleLists(List<Double> listA,
			List<Double> listB) {

		// ListA empty & ListB has values
		if (isEmpty(listA) && !isEmpty(listB)) {
			return listB;
		}

		// ListA has values & ListB is empty
		if (!isEmpty(listA) && isEmpty(listB)) {
			return listA;
		}

		// Both List are empty
		if (isEmpty(listA) && isEmpty(listB)) {
			return new ArrayList<Double>();
		}

		// [1,2,3,4,5]
		// [3,4,5,6,7,8,9]
		ArrayList<Double> list = new ArrayList<Double>();
		int i = 0;
		int j = 0;

		while (i < listA.size() && j < listB.size()) {
			list.add(listA.get(i) + listB.get(j));
			i++;
			j++;

		}
		while (i < listA.size()) {
			list.add(listA.get(i));
			i++;
		}
		while (j < listB.size()) {
			list.add(listB.get(j));
			j++;
		}
		System.out.println("list is " + list);
		return list;
	}

	/**
	 * Subtract integer lists.
	 *
	 * @param listA
	 *            the list a
	 * @param listB
	 *            the list b
	 * @return the list
	 */
	public static List<Integer> subtractIntegerLists(List<Integer> listA,
			List<Integer> listB) {

		// ListA empty & ListB has values
		if (isEmpty(listA) && !isEmpty(listB)) {
			return listB;
		}

		// ListA has values & ListB is empty
		if (!isEmpty(listA) && isEmpty(listB)) {
			return listA;
		}

		// Both List are empty
		if (isEmpty(listA) && isEmpty(listB)) {
			return new ArrayList<Integer>();
		}

		// [1,2,3,4,5]
		// [3,4,5,6,7,8,9]
		ArrayList<Integer> list = new ArrayList<Integer>();
		int i = 0;
		int j = 0;

		while (i < listA.size() && j < listB.size()) {
			list.add(listA.get(i) - listB.get(j));
			i++;
			j++;

		}
		while (i < listA.size()) {
			list.add(listA.get(i));
			i++;
		}
		while (j < listB.size()) {
			list.add(listB.get(j));
			j++;
		}
		System.out.println("list is " + list);
		return list;
	}

	/**
	 * Subtract float lists.
	 *
	 * @param listA
	 *            the list a
	 * @param listB
	 *            the list b
	 * @return the list
	 */
	public static List<Float> subtractFloatLists(List<Float> listA,
			List<Float> listB) {

		// ListA empty & ListB has values
		if (isEmpty(listA) && !isEmpty(listB)) {
			return listB;
		}

		// ListA has values & ListB is empty
		if (!isEmpty(listA) && isEmpty(listB)) {
			return listA;
		}

		// Both List are empty
		if (isEmpty(listA) && isEmpty(listB)) {
			return new ArrayList<Float>();
		}

		// [1,2,3,4,5]
		// [3,4,5,6,7,8,9]
		ArrayList<Float> list = new ArrayList<Float>();
		int i = 0;
		int j = 0;

		while (i < listA.size() && j < listB.size()) {
			list.add(listA.get(i) - listB.get(j));
			i++;
			j++;

		}
		while (i < listA.size()) {
			list.add(listA.get(i));
			i++;
		}
		while (j < listB.size()) {
			list.add(listB.get(j));
			j++;
		}
		System.out.println("list is " + list);
		return list;
	}

	/**
	 * Subtract double lists.
	 *
	 * @param listA
	 *            the list a
	 * @param listB
	 *            the list b
	 * @return the list
	 */
	public static List<Double> subtractDoubleLists(List<Double> listA,
			List<Double> listB) {

		// ListA empty & ListB has values
		if (isEmpty(listA) && !isEmpty(listB)) {
			return listB;
		}

		// ListA has values & ListB is empty
		if (!isEmpty(listA) && isEmpty(listB)) {
			return listA;
		}

		// Both List are empty
		if (isEmpty(listA) && isEmpty(listB)) {
			return new ArrayList<Double>();
		}

		// [1,2,3,4,5]
		// [3,4,5,6,7,8,9]
		ArrayList<Double> list = new ArrayList<Double>();
		int i = 0;
		int j = 0;

		while (i < listA.size() && j < listB.size()) {
			list.add(listA.get(i) - listB.get(j));
			i++;
			j++;

		}
		while (i < listA.size()) {
			list.add(listA.get(i));
			i++;
		}
		while (j < listB.size()) {
			list.add(listB.get(j));
			j++;
		}
		System.out.println("list is " + list);
		return list;
	}

	/**
	 * Multiply integer lists.
	 *
	 * @param listA
	 *            the list a
	 * @param listB
	 *            the list b
	 * @return the list
	 */
	public static List<Integer> multiplyIntegerLists(List<Integer> listA,
			List<Integer> listB) {

		// ListA empty & ListB has values
		if (isEmpty(listA) && !isEmpty(listB)) {
			return listB;
		}

		// ListA has values & ListB is empty
		if (!isEmpty(listA) && isEmpty(listB)) {
			return listA;
		}

		// Both List are empty
		if (isEmpty(listA) && isEmpty(listB)) {
			return new ArrayList<Integer>();
		}

		// [1,2,3,4,5]
		// [3,4,5,6,7,8,9]
		ArrayList<Integer> list = new ArrayList<Integer>();
		int i = 0;
		int j = 0;

		while (i < listA.size() && j < listB.size()) {
			list.add(listA.get(i) * listB.get(j));
			i++;
			j++;

		}
		while (i < listA.size()) {
			list.add(listA.get(i));
			i++;
		}
		while (j < listB.size()) {
			list.add(listB.get(j));
			j++;
		}
		System.out.println("list is " + list);
		return list;
	}

	/**
	 * Multiply float lists.
	 *
	 * @param listA
	 *            the list a
	 * @param listB
	 *            the list b
	 * @return the list
	 */
	public static List<Float> multiplyFloatLists(List<Float> listA,
			List<Float> listB) {

		// ListA empty & ListB has values
		if (isEmpty(listA) && !isEmpty(listB)) {
			return listB;
		}

		// ListA has values & ListB is empty
		if (!isEmpty(listA) && isEmpty(listB)) {
			return listA;
		}

		// Both List are empty
		if (isEmpty(listA) && isEmpty(listB)) {
			return new ArrayList<Float>();
		}

		// [1,2,3,4,5]
		// [3,4,5,6,7,8,9]
		ArrayList<Float> list = new ArrayList<Float>();
		int i = 0;
		int j = 0;

		while (i < listA.size() && j < listB.size()) {
			list.add(listA.get(i) * listB.get(j));
			i++;
			j++;

		}
		while (i < listA.size()) {
			list.add(listA.get(i));
			i++;
		}
		while (j < listB.size()) {
			list.add(listB.get(j));
			j++;
		}
		System.out.println("list is " + list);
		return list;
	}

	/**
	 * Multiply double lists.
	 *
	 * @param listA
	 *            the list a
	 * @param listB
	 *            the list b
	 * @return the list
	 */
	public static List<Double> multiplyDoubleLists(List<Double> listA,
			List<Double> listB) {

		// ListA empty & ListB has values
		if (isEmpty(listA) && !isEmpty(listB)) {
			return listB;
		}

		// ListA has values & ListB is empty
		if (!isEmpty(listA) && isEmpty(listB)) {
			return listA;
		}

		// Both List are empty
		if (isEmpty(listA) && isEmpty(listB)) {
			return new ArrayList<Double>();
		}

		// [1,2,3,4,5]
		// [3,4,5,6,7,8,9]
		ArrayList<Double> list = new ArrayList<Double>();
		int i = 0;
		int j = 0;

		while (i < listA.size() && j < listB.size()) {
			list.add(listA.get(i) - listB.get(j));
			i++;
			j++;

		}
		while (i < listA.size()) {
			list.add(listA.get(i));
			i++;
		}
		while (j < listB.size()) {
			list.add(listB.get(j));
			j++;
		}
		System.out.println("list is " + list);
		return list;
	}

	/**
	 * Divide integer lists.
	 *
	 * @param listA
	 *            the list a
	 * @param listB
	 *            the list b
	 * @return the list
	 */
	public static List<Integer> divideIntegerLists(List<Integer> listA,
			List<Integer> listB) {

		// ListA empty & ListB has values
		if (isEmpty(listA) && !isEmpty(listB)) {
			return listB;
		}

		// ListA has values & ListB is empty
		if (!isEmpty(listA) && isEmpty(listB)) {
			return listA;
		}

		// Both List are empty
		if (isEmpty(listA) && isEmpty(listB)) {
			return new ArrayList<Integer>();
		}

		// [1,2,3,4,5]
		// [3,4,5,6,7,8,9]
		ArrayList<Integer> list = new ArrayList<Integer>();
		int i = 0;
		int j = 0;

		while (i < listA.size() && j < listB.size()) {
			if (listB.get(j) == 0) {
				// if denominator is 0 then infinity
				// we represent infinity by 0
				list.add(listB.get(j));
			} else {
				list.add(listA.get(i) / listB.get(j));
			}
			i++;
			j++;
		}
		while (i < listA.size()) {
			list.add(listA.get(i));
			i++;
		}
		while (j < listB.size()) {
			list.add(listB.get(j));
			j++;
		}
		System.out.println("list is " + list);
		return list;
	}

	/**
	 * Divide float lists.
	 *
	 * @param listA
	 *            the list a
	 * @param listB
	 *            the list b
	 * @return the list
	 */
	public static List<Float> divideFloatLists(List<Float> listA,
			List<Float> listB) {

		// ListA empty & ListB has values
		if (isEmpty(listA) && !isEmpty(listB)) {
			return listB;
		}

		// ListA has values & ListB is empty
		if (!isEmpty(listA) && isEmpty(listB)) {
			return listA;
		}

		// Both List are empty
		if (isEmpty(listA) && isEmpty(listB)) {
			return new ArrayList<Float>();
		}

		// [1,2,3,4,5]
		// [3,4,5,6,7,8,9]
		ArrayList<Float> list = new ArrayList<Float>();
		int i = 0;
		int j = 0;

		while (i < listA.size() && j < listB.size()) {
			if (listB.get(j) == 0) {
				// if denominator is 0 then infinity
				// we represent infinity by 0
				list.add(Float.POSITIVE_INFINITY);
			} else {
				list.add(listA.get(i) / listB.get(j));
			}
			i++;
			j++;
		}
		while (i < listA.size()) {
			list.add(listA.get(i));
			i++;
		}
		while (j < listB.size()) {
			list.add(listB.get(j));
			j++;
		}
		System.out.println("list is " + list);
		return list;
	}

	/**
	 * Divide double lists.
	 *
	 * @param listA
	 *            the list a
	 * @param listB
	 *            the list b
	 * @return the list
	 */
	public static List<Double> divideDoubleLists(List<Double> listA,
			List<Double> listB) {

		// ListA empty & ListB has values
		if (isEmpty(listA) && !isEmpty(listB)) {
			return listB;
		}

		// ListA has values & ListB is empty
		if (!isEmpty(listA) && isEmpty(listB)) {
			return listA;
		}

		// Both List are empty
		if (isEmpty(listA) && isEmpty(listB)) {
			return new ArrayList<Double>();
		}

		// [1,2,3,4,5]
		// [3,4,5,6,7,8,9]
		ArrayList<Double> list = new ArrayList<Double>();
		int i = 0;
		int j = 0;

		while (i < listA.size() && j < listB.size()) {
			if (listB.get(j) == 0) {
				// if denominator is 0 then infinity
				// we represent infinity by 0
				list.add(Double.POSITIVE_INFINITY);
			} else {
				list.add(listA.get(i) / listB.get(j));
			}
			i++;
			j++;
		}
		while (i < listA.size()) {
			list.add(listA.get(i));
			i++;
		}
		while (j < listB.size()) {
			list.add(listB.get(j));
			j++;
		}
		System.out.println("list is " + list);
		return list;
	}

	/**
	 * Abs integer list.
	 *
	 * @param listA
	 *            the list a
	 * @return the list
	 */
	public static List<Object> absIntegerList(List<Object> listA) {

		// List are empty
		if (isEmpty(listA)) {
			return new ArrayList<Object>();
		}

		// [1,2,3,4,5]
		List<Object> list = abs(listA);
		System.out.println("list is " + list);
		return null;
	}

	/**
	 * Abs.
	 *
	 * @param listA
	 *            the list a
	 * @return the list
	 */
	private static List<Object> abs(List<Object> listA) {

		ArrayList<Object> list = new ArrayList<Object>();
		for (int i = 0; i < listA.size(); i++) {
			Object o = listA.get(i);
			if (o instanceof Integer) {
				list.add(Math.abs((Integer) o));
			} else if (o instanceof Long) {
				list.add(Math.abs((Long) o));
			} else if (o instanceof Float) {
				list.add(Math.abs((Float) o));
			} else if (o instanceof Double) {
				list.add(Math.abs((Double) o));
			} else if (o instanceof String) {
				try {
					list.add(Integer.parseInt((String) o));
				} catch (NumberFormatException e) {
					list.add(o);
				}
			} else {
				list.add(o);
			}
		}
		return list;
	}

	/**
	 * List equals string.
	 *
	 * @param listA
	 *            the list a
	 * @param listB
	 *            the list b
	 * @return true, if successful Case Sensitive equals
	 */
	public static boolean listEqualsString(List<String> listA,
			List<String> listB) {

		// ListA empty & ListB has values
		if (isEmpty(listA) && !isEmpty(listB)) {
			return false;
		}

		// ListA has values & ListB is empty
		if (!isEmpty(listA) && isEmpty(listB)) {
			return false;
		}

		if (listA == null && listB == null) {
			return true;
		}

		// Both List are empty
		if (listA.size() == 0 && 0 == listB.size()) {
			return true;
		}

		ArrayList<String> tempA = new ArrayList<String>(listA);
		ArrayList<String> tempB = new ArrayList<String>(listB);

		Collections.sort(tempA, StringComparatorCaseSensitive);
		Collections.sort(tempB, StringComparatorCaseSensitive);

		return tempA.equals(tempB);
	}

	/** The String comparator case sensitive. */
	private static Comparator<String> StringComparatorCaseSensitive = new Comparator<String>() {
		public int compare(String o1, String o2) {
			if (o1 == null && o2 == null) {
				return 0;
			}
			if (o1 == null) {
				return 1;
			}
			if (o2 == null) {
				return -1;
			}
			return o1.compareTo(o2);
		}
	};

	/*
	 * private static Comparator<String> StringComparatorCaseInSensitive=new
	 * Comparator<String>() { public int compare(String o1, String o2) {
	 * if(o1==null && o2==null){ return 0; } if(o1==null){ return 1; }
	 * if(o2==null){ return -1; } return
	 * o1.toLowerCase().compareTo(o2.toLowerCase()); } };
	 */

	/**
	 * Checks if is size zero.
	 *
	 * @param <T>
	 *            the generic type
	 * @param list
	 *            the list
	 * @return true, if is size zero
	 */
	public static <T> boolean isSizeZero(List<T> list) {
		return list.size() == 0;
	}

	/**
	 * Checks if is list null.
	 *
	 * @param <T>
	 *            the generic type
	 * @param list
	 *            the list
	 * @return true, if is list null
	 */
	public static <T> boolean isListNull(List<T> list) {
		return list == null;
	}

	/**
	 * Sub array.
	 *
	 * @param <T>
	 *            the generic type
	 * @param listA
	 *            the list a
	 * @param listB
	 *            the list b
	 * @return true, if successful
	 * 
	 *         Case Insensitive
	 */
	public static <T> boolean subArray(List<T> listA, List<T> listB) {

		// ListA empty & ListB has values
		if (isEmpty(listA) && !isEmpty(listB)) {
			return false;
		}

		// ListA has values & ListB is empty
		if (!isEmpty(listA) && isEmpty(listB)) {
			return false;
		}

		if (isSizeZero(listA) && isSizeZero(listB)) {
			return true;
		}

		if (isListNull(listA) && isListNull(listB)) {
			return true;
		}
		return listA.containsAll(listB);
	}
}