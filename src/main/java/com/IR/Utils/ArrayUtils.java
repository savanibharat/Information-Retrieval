package com.IR.Utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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

		// set operations
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

		
		Set<Object> a = new LinkedHashSet<Object>(); 
		/*a.add("a"); 
		a.add("b");*/
		System.out.println(a);
		Set<Object> b = new LinkedHashSet<Object>();
		/*b.add("a");
		b.add("d");*/
		System.out.println(b);
		
		System.out.println(diffAbyB(a,b));

		/*List<Object> list1 = new ArrayList<Object>();
		list1.add("a");
		list1.add("b");
		List<Object> list2 = new ArrayList<Object>();
		list2.add("c");
		list2.add("d");
		System.out.println(cartesianProductList(list1,list2));*/
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
	
	
	/**************************************************************************************************/
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
	 * @param setA the set a
	 * @param setB the set b
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> cartesianProductList(List<T> setA, List<T> setB) {

		// SetA empty & SetB has values
		if (isEmpty(setA) && !isEmpty(setB)) {
			return setB;
		}

		// SetA has values & SetB is empty
		if (!isEmpty(setA) && isEmpty(setB)) {
			return setA;
		}

		// Both set are empty
		if (isEmpty(setA) && isEmpty(setB)) {
			return new ArrayList<T>();
		}

		T[] A = (T[]) setA.toArray();
		T[] B = (T[]) setB.toArray();

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
	
}