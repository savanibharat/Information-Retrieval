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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class ArrayUtils.
 */
public class ArrayUtils {

	/** The Constant BYTE_ARRAY. */
	public static final byte[] BYTE_ARRAY=new byte[0];
	
	/** The Constant BYTE_WRAPPER_ARRAY. */
	public static final Byte[] BYTE_WRAPPER_ARRAY=new Byte[0];
	
	/** The Constant SHORT_ARRAY. */
	public static final short[] SHORT_ARRAY=new short[0];
	
	/** The Constant SHORT_WRAPPER_ARRAY. */
	public static final Short[] SHORT_WRAPPER_ARRAY=new Short[0];
	
	/** The Constant INT_ARRAY. */
	public static final int[] INT_ARRAY=new int[0];
	
	/** The Constant INTEGER_WRAPPER_ARRAY. */
	public static final Integer[] INTEGER_WRAPPER_ARRAY=new Integer[0];
	
	/** The Constant LONG_ARRAY. */
	public static final long[] LONG_ARRAY=new long[0];
	
	/** The Constant LONG_WRAPPER_ARRAY. */
	public static final Long[] LONG_WRAPPER_ARRAY=new Long[0];
	
	/** The Constant FLOAT_ARRAY. */
	public static final float[] FLOAT_ARRAY=new float[0];
	
	/** The Constant FLOAT_WRAPPER_ARRAY. */
	public static final Float[] FLOAT_WRAPPER_ARRAY=new Float[0];
	
	/** The Constant DOUBLE_ARRAY. */
	public static final double[] DOUBLE_ARRAY=new double[0];
	
	/** The Constant DOUBLE_WRAPPER_ARRAY. */
	public static final Double[] DOUBLE_WRAPPER_ARRAY=new Double[0];
	
	/** The Constant BOOLEAN_ARRAY. */
	public static final boolean[] BOOLEAN_ARRAY=new boolean[0];
	
	/** The Constant BOOLEAN_WRAPPER_ARRAY. */
	public static final Boolean[] BOOLEAN_WRAPPER_ARRAY=new Boolean[0];
	
	/** The Constant CHAR_ARRAY. */
	public static final char[] CHAR_ARRAY=new char[0];
	
	/** The Constant CHARACTER_WRAPPER_ARRAY. */
	public static final Character[] CHARACTER_WRAPPER_ARRAY=new Character[0];
	
	public static final Object[] OBJECT_ARRAY =new Object[0];
	
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

	/**
	 * Key of HashMap to list.
	 *
	 * @param <T> the generic type
	 * @param <K> the key type
	 * @param <V> the value type
	 * @param map the map
	 * @return the list
	 */
	public static <T, K, V> List<K> keyToList(Map<K,V> map){
		List<K> list=new ArrayList<K>();
		for (K mapper : map.keySet()) {
			list.add(mapper);
		}
		return list;
	}
	
	/**
	 * Values to list.
	 *
	 * @param <T> the generic type
	 * @param <K> the key type
	 * @param <V> the value type
	 * @param map the map
	 * @return the list
	 */
	public static <T,K,V> List<V> valuesToList(Map<K,V> map){
		return new ArrayList<V>(map.values());
	}
	
	/**
	 * Reverse list.
	 *
	 * @param <T> the generic type
	 * @param list the list
	 * @param shallowCopy the shallow copy
	 * @return the list
	 */
	public static <T> List<T> reverseList(List<T> list,boolean shallowCopy){
		
		if(shallowCopy){
			reverseListShallowCopy(list);
		}
		else{//Deep copy and then reverse
			List<T> list1=new ArrayList<T>();
			for (int i = list.size()-1; i >=0; i--) {
				list1.add(list.get(i));
			}
			return list1;
		}
		return null;
	}
	
	/**
	 * Reverse list shallow copy.
	 *
	 * @param <T> the generic type
	 * @param list the list
	 */
	public static <T> void reverseListShallowCopy(List<T> list){
		Collections.reverse(list);
	}
	
	/**
	 * Primes.
	 *
	 * @return the int[]
	 */
	public static List<Integer> primes() {

		int N = 10000;
		boolean[] isPrime = new boolean[N];
		for (int i = 0; i < isPrime.length; i++) {
			isPrime[i] = true;
		}
		for (int i = 2; i * i < N; i++) {
			if (isPrime[i]) {
				for (int j = i; i * j < N; j++) {
					isPrime[i * j] = false;
				}
			}
		}
		for (int i = 2; i < isPrime.length; i++) {
			if (isPrime[i]) {
			}
		}
		List<Integer> list=new ArrayList<Integer>();
		for (int i = 0; i < isPrime.length; i++) {
			if(isPrime[i]){
				list.add(i);
			}
		}
		return list;
	}
	
	/**
	 * Composite.
	 *
	 * @return the list
	 */
	public static List<Integer> composite() {

		List<Integer> primes=primes();
		List<Integer> composite=new ArrayList<Integer>();
		Object[] obj=primes.toArray();
		for (int i = 3; i < obj.length; i++) {
			
			if(Arrays.binarySearch(obj, i)<0){
				composite.add(i);
			}
		}
		return composite;
	}
	
	
	/**
	 * Resolve null.
	 *
	 * @param byteArray the byte array
	 * @return the byte[]
	 */
	public static byte[] resolveNull(byte[] byteArray){
		if(byteArray==null||byteArray.length==0){
			return BYTE_ARRAY;
		}
		return byteArray;
	}
	
	/**
	 * Resolve null.
	 *
	 * @param byteArray the byte array
	 * @return the byte[]
	 */
	public static Byte[] resolveNull(Byte[] byteArray){
		if(byteArray==null||byteArray.length==0){
			return BYTE_WRAPPER_ARRAY;
		}
		return byteArray;
	}
	
	/**
	 * Resolve null.
	 *
	 * @param shortArray the short array
	 * @return the short[]
	 */
	public static short[] resolveNull(short[] shortArray){
		if(shortArray==null||shortArray.length==0){
			return SHORT_ARRAY;
		}
		return shortArray;
	}
	
	/**
	 * Resolve null.
	 *
	 * @param shortArray the short array
	 * @return the short[]
	 */
	public static Short[] resolveNull(Short[] shortArray){
		if(shortArray==null||shortArray.length==0){
			return SHORT_WRAPPER_ARRAY;
		}
		return shortArray;
	}
	
	/**
	 * Resolve null.
	 *
	 * @param intArray the int array
	 * @return the int[]
	 */
	public static int[] resolveNull(int[] intArray){
		if(intArray==null||intArray.length==0){
			return INT_ARRAY;
		}
		return intArray;
	}
	
	/**
	 * Resolve null.
	 *
	 * @param integerArray the integer array
	 * @return the integer[]
	 */
	public static Integer[] resolveNull(Integer[] integerArray){
		if(integerArray==null||integerArray.length==0){
			return INTEGER_WRAPPER_ARRAY;
		}
		return integerArray;
	}
	
	/**
	 * Resolve null.
	 *
	 * @param longArray the long array
	 * @return the long[]
	 */
	public static long[] resolveNull(long[] longArray){
		if(longArray==null||longArray.length==0){
			return LONG_ARRAY;
		}
		return longArray;
	}
	
	/**
	 * Resolve null.
	 *
	 * @param longArray the long array
	 * @return the long[]
	 */
	public static Long[] resolveNull(Long[] longArray){
		if(longArray==null||longArray.length==0){
			return LONG_WRAPPER_ARRAY;
		}
		return longArray;
	}
	
	/**
	 * Resolve null.
	 *
	 * @param floatArray the float array
	 * @return the float[]
	 */
	public static float[] resolveNull(float[] floatArray){
		if(floatArray==null||floatArray.length==0){
			return FLOAT_ARRAY;
		}
		return floatArray;
	}
	
	/**
	 * Resolve null.
	 *
	 * @param floatArray the float array
	 * @return the float[]
	 */
	public static Float[] resolveNull(Float[] floatArray){
		if(floatArray==null||floatArray.length==0){
			return FLOAT_WRAPPER_ARRAY;
		}
		return floatArray;
	}
	
	/**
	 * Resolve null.
	 *
	 * @param doubleArray the double array
	 * @return the double[]
	 */
	public static double[] resolveNull(double[] doubleArray){
		if(doubleArray==null||doubleArray.length==0){
			return DOUBLE_ARRAY;
		}
		return doubleArray;
	}
	
	/**
	 * Resolve null.
	 *
	 * @param doubleArray the double array
	 * @return the double[]
	 */
	public static Double[] resolveNull(Double[] doubleArray){
		if(doubleArray==null||doubleArray.length==0){
			return DOUBLE_WRAPPER_ARRAY;
		}
		return doubleArray;
	}
	
	/**
	 * Resolve null.
	 *
	 * @param booleanArray the boolean array
	 * @return the boolean[]
	 */
	public static boolean[] resolveNull(boolean[] booleanArray){
		if(booleanArray==null||booleanArray.length==0){
			return BOOLEAN_ARRAY;
		}
		return booleanArray;
	}
	
	/**
	 * Resolve null.
	 *
	 * @param booleanArray the boolean array
	 * @return the boolean[]
	 */
	public static Boolean[] resolveNull(Boolean[] booleanArray){
		if(booleanArray==null||booleanArray.length==0){
			return BOOLEAN_WRAPPER_ARRAY;
		}
		return booleanArray;
	}
	
	/**
	 * Resolve null.
	 *
	 * @param charArray the char array
	 * @return the char[]
	 */
	public static char[] resolveNull(char[] charArray){
		if(charArray==null||charArray.length==0){
			return CHAR_ARRAY;
		}
		return charArray;
	}
	
	/**
	 * Resolve null.
	 *
	 * @param characterArray the character array
	 * @return the character[]
	 */
	public static Character[] resolveNull(Character[] characterArray){
		if(characterArray==null||characterArray.length==0){
			return CHARACTER_WRAPPER_ARRAY;
		}
		return characterArray;
	}
	
	public static Object[] resolveNull(Object[] objectArray){
		if(objectArray==null||objectArray.length==0){
			return OBJECT_ARRAY;
		}
		return objectArray;
	}
	
	/**
	 * A van der Corput sequence is a low-discrepancy sequence over the unit interval .
	 *
	 * @param start the start
	 * @param end the end
	 * @param binary the binary
	 */
	public static void vanderCorputsequence(int start, int end,boolean binary){
		
		if (binary) {
			for (int i = start; i <= start; i++) {
				for (int j = 1; j < end; j++) {
					StringBuffer sb = new StringBuffer(
							Integer.toBinaryString(j)).reverse();
					String t = sb.toString();
					String a = i + "." + t;
					System.out.println(a);
				}
			}
		}
		else{
			for (int i = start; i <= start; i++) {
				for (int j = 1; j < end; j++) {
					StringBuffer sb = new StringBuffer(j+"").reverse();
					String t = sb.toString();
					String a = i + "." + t;
					System.out.println(a);
				}
			}
		}
	}
	
	/**
	 * *
	 * Standard Deviation (SD) (represented by the Greek letter sigma, σ) 
	 * measures the amount of variation or dispersion from the average.
	 *
	 * @param list the list
	 * @return the double
	 */
	public static double sumDouble(List<Double> list){
		
		double sum=0;
		for (int i = 0; i < list.size(); i++) {
			sum+=list.get(i);
		}
		return sum;
	}
	
	/**
	 * Mean double.
	 *
	 * @param list the list
	 * @return the double
	 */
	public static double meanDouble(List<Double> list){
		
		return sumDouble(list)/list.size();
	}
	
	/**
	 * Variance double.
	 *
	 * @param list the list
	 * @param populationStandardDeviation the population standard deviation
	 * @return the double
	 */
	public static double varianceDouble(List<Double> list,boolean populationStandardDeviation){
		
		double mean=meanDouble(list);
		double variance=0;
		for (int i = 0; i < list.size(); i++) {
			double a=Math.pow(list.get(i)-mean,2);
			variance+=a;
		}
		if(populationStandardDeviation){
			return variance/list.size();	
		}
		return variance/(list.size()-1);
	}
	//Population Standard Deviation
	/**
	 * Standard deviation double.
	 *
	 * @param list the list
	 * @param populationStandardDeviation the population standard deviation
	 * @return the double
	 */
	public static double standardDeviationDouble(List<Double> list,boolean populationStandardDeviation){
		
		if(populationStandardDeviation){
			return Math.sqrt(varianceDouble(list,populationStandardDeviation));
		}
		return Math.sqrt(varianceDouble(list,populationStandardDeviation));
		
	}
	
	/**
	 * Sum long.
	 *
	 * @param list the list
	 * @return the long
	 */
	public static long sumLong(List<Long> list) {

		long sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		return sum;
	}
	
	/**
	 * Mean long.
	 *
	 * @param list the list
	 * @return the long
	 */
	public static long meanLong(List<Long> list) {

		return sumLong(list)/list.size();
	}

	/**
	 * Variance long.
	 *
	 * @param list the list
	 * @param populationStandardDeviation the population standard deviation
	 * @return the long
	 */
	public static long varianceLong(List<Long> list,boolean populationStandardDeviation){
		
		long mean=meanLong(list);
		long variance=0;
		for (int i = 0; i < list.size(); i++) {
			long a=(long) Math.pow(list.get(i)-mean,2);
			variance+=a;
		}
		if(populationStandardDeviation){
			return variance/list.size();	
		}
		return variance/(list.size()-1);
	}
	//Population Standard Deviation
	/**
	 * Standard deviation long.
	 *
	 * @param list the list
	 * @param populationStandardDeviation the population standard deviation
	 * @return the double
	 */
	public static double standardDeviationLong(List<Long> list,boolean populationStandardDeviation){
		
		if(populationStandardDeviation){
			return Math.sqrt(varianceLong(list,populationStandardDeviation));
		}
		return Math.sqrt(varianceLong(list,populationStandardDeviation));
		
	}
	
	/**
	 * Sum integer.
	 *
	 * @param list the list
	 * @return the int
	 */
	public static int sumInteger(List<Integer> list) {

		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		return sum;
	}
	
	/**
	 * Mean integer.
	 *
	 * @param list the list
	 * @return the int
	 */
	public static int meanInteger(List<Integer> list) {

		return sumInteger(list)/list.size();
	}
	
	/**
	 * Variance integer.
	 *
	 * @param list the list
	 * @param populationStandardDeviation the population standard deviation
	 * @return the int
	 */
	public static int varianceInteger(List<Integer> list,boolean populationStandardDeviation){
		
		int mean=meanInteger(list);
		int variance=0;
		for (int i = 0; i < list.size(); i++) {
			int a=(int) Math.pow(list.get(i)-mean,2);
			variance+=a;
		}
		if(populationStandardDeviation){
			return variance/list.size();	
		}
		return variance/(list.size()-1);
	}
	//Population Standard Deviation
	/**
	 * Standard deviation integer.
	 *
	 * @param list the list
	 * @param populationStandardDeviation the population standard deviation
	 * @return the int
	 */
	public static int standardDeviationInteger(List<Integer> list,boolean populationStandardDeviation){
		
		if(populationStandardDeviation){
			return (int) Math.sqrt(varianceInteger(list,populationStandardDeviation));
		}
		return (int) Math.sqrt(varianceInteger(list,populationStandardDeviation));
	}
	
	/**
	 * Distance.
	 *
	 * @param p1 the p1
	 * @param p2 the p2
	 * @return the float
	 */
	public static double distance(Point p1,Point p2){
		
		double x2=p2.getX();
		double x1=p1.getX();
		double y2=p2.getY();
		double y1=p1.getY();
		
		double y=(float)Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
		System.out.println(y);
		return y;
	}
	
	/**
	 * Mid point.
	 *
	 * @param p1 the p1
	 * @param p2 the p2
	 * @return the point
	 */
	public static Point midPoint(Point p1,Point p2){
		
		double x1=p1.getX();
		double y1=p1.getY();
		double x2=p2.getX();
		double y2=p2.getY();
		
		return new Point(((x1+x2)/2),((y1+y2)/2));
	}
	
	public static void hailStoneSequence(double d){
		d=27;
		if(d<0){
			return;
		}
		List<Double> list=new ArrayList<Double>();
		while(d!=1){
			if((d%2)==0){
				d=d/2;
			}
			else{
				d=(3*d)+1;
			}
			list.add(d);
		}
		System.out.println(list);
		System.out.println(list.size());
	}
	
	public static Object[] uniqueElements(Object[] data){
		if(data==null || data.length==0){
			return OBJECT_ARRAY;
		}
		Set<Object> set=new HashSet<Object>(Arrays.asList(data));
		System.out.println(set);
		data=set.toArray();
		return data;
	}
	
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
		Object[] obj={};
		uniqueElements(obj);
		hailStoneSequence(10);
		//populationStandardDeviation
		//System.out.println(standardDeviationDouble(Arrays.asList(1d,2d,3d,4d,5d,6d,7d,8d),false));
		Point p1=new Point(3,-4);
		Point p2=new Point(-1,3);
		Point p3=midPoint(p1, p2);
		System.out.println(p3.getX());
		System.out.println(p3.getY());
		List<String> list1 = new ArrayList<String>();
		list1.add("A");
		list1.add("r");
		list1.add("a");
		//System.out.println(list1);
		List<String> list2 = new ArrayList<String>();
		
		list2.add("r");
		list2.add("A");
		list2.add("A");
		//System.out.println(list2);
		//System.out.println(subArray(list1,list2));
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

	
}