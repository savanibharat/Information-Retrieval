package com.IR.Utils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ArrayUtils {

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
		Set<Object> a = new HashSet<Object>();
		a.add("a");
		Set<Object> b = new HashSet<Object>();
		b.add("b");
		b.add("a");
		/*
		 * b.add("a"); b.add("b");
		 */
		System.out.println(intersection(a, b));
		// System.out.println(union(b,a));
		/*
		 * System.out.println(isEmpty(a)); System.out.println(isEmpty(a));
		 * System.out.println(isEmpty(a));
		 */
	}

	public static <E> boolean isEmpty(Collection<? super E> collection) {

		if ((collection.size() == 0) || (collection == null))
			return true;
		return false;
	}

	public static Set<Object> union(Set<Object> setA, Set<Object> setB) {

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
			return new HashSet<Object>();
		}

		Set<Object> setC = new HashSet<Object>();
		Iterator<Object> iterA = setA.iterator();
		Iterator<Object> iterB = setB.iterator();

		while (iterA.hasNext()) {
			setC.add(iterA.next());
		}
		while (iterB.hasNext()) {
			setC.add(iterB.next());
		}
		return Collections.unmodifiableSet(setC);
	}

	public static Set<Object> intersection(Set<Object> setA, Set<Object> setB) {
		// SetA empty & SetB has values
		if (isEmpty(setA) && !isEmpty(setB)) {
			return Collections.unmodifiableSet(new HashSet<Object>());
		}

		// SetA has values & SetB is empty
		if (!isEmpty(setA) && isEmpty(setB)) {
			return Collections.unmodifiableSet(new HashSet<Object>());
		}

		// Both set are empty
		if (isEmpty(setA) && isEmpty(setB)) {
			return Collections.unmodifiableSet(new HashSet<Object>());
		}

		Set<Object> setC = new HashSet<Object>();
		Iterator<Object> iterA = setA.iterator();
		Iterator<Object> iterB = setB.iterator();
		
		while(iterA.hasNext()){
			Object obj= iterA.next();
			if(setB.contains(obj)){
				setC.add(obj);
			}
		}
		return Collections.unmodifiableSet(setC);
		
	}

}
