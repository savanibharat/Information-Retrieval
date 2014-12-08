package com.IR.Algorithms.TernarySearchTree;

import java.util.Iterator;
import java.util.LinkedList;

public class TernarySearchTree<Value> implements TreeOperableFunctions<Value> {

	private int N;
	private Node root;

	private class Node {
		private char c;
		private Node left, mid, right;
		private Value val;
	}

	public int size() {
		return N;
	}

	public boolean contains(String key) {
		return get(key) != null;
	}

	public Value get(String key) {
		if (key == null)
			throw new NullPointerException();
		if (key.length() == 0)
			throw new IllegalArgumentException("key must have length>=1");
		Node x = get(root, key, 0);
		if (x == null)
			return null;
		return x.val;
	}

	private Node get(Node x, String key, int d) {
		if (key == null)
			throw new NullPointerException();
		if (key.length() == 0)
			throw new IllegalArgumentException("key must have length>=1");
		if (x == null)
			return null;
		char c = key.charAt(d);
		if (c < x.c)
			return get(x.left, key, d);
		else if (c > x.c)
			return get(x.right, key, d);
		else if (d < key.length() - 1)
			return get(x.mid, key, d + 1);
		else
			return x;
	}

	public void put(String str, Value val) {
		if (!contains(str))
			N++;
		root = put(root, str, val, 0);
	}

	private Node put(Node x, String str, Value val, int d) {

		char c = str.charAt(d);
		if (x == null) {
			x = new Node();
			x.c = c;
		}
		if (c < x.c)
			x.left = put(x.left, str, val, d);
		else if (c > x.c)
			x.right = put(x.right, str, val, d);
		else if (d < str.length() - 1)
			x.mid = put(x.mid, str, val, d + 1);
		else
			x.val = val;
		return x;
	}

	public String longestPrefixOf(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterable<String> keys() {
		LinkedList<String> queue = new LinkedList<String>();
		collect(root, "", queue);
		return queue;
	}

	private void collect(Node x, String prefix, LinkedList<String> queue) {

		if (x == null)
			return;
		collect(x.left, prefix, queue);
		if (x.val != null)
			queue.add(prefix + x.c);
		collect(x.mid, prefix + x.c, queue);
		collect(x.right, prefix, queue);

	}

	public Iterable<String> prefixMatch(String prefix) {
		LinkedList<String> queue = new LinkedList<String>();
		Node x = get(root, prefix, 0);
		if (x == null)
			return queue;
		if (x.val != null)
			queue.add(prefix);
		collect(x.mid, prefix, queue);
		return queue;
	}

	public Iterable<String> wildCardMatch(String pat) {
		LinkedList<String> queue = new LinkedList<String>();
        collect(root, "", 0, pat, queue);
		return queue;
	}

	private void collect(Node x, String prefix, int i,
			String pat, LinkedList<String> q) {
		if (x == null)
			return;
		char c = pat.charAt(i);
		if (c == '.' || c < x.c)
			collect(x.left, prefix, i, pat, q);
		if (c == '.' || c == x.c) {
			if (i == pat.length() - 1 && x.val != null)
				q.add(prefix + x.c);
			if (i < pat.length() - 1)
				collect(x.mid, prefix + x.c, i + 1, pat, q);
		}
		if (c == '.' || c > x.c)
			collect(x.right, prefix, i, pat, q);
	}

	public static void main(String[] args) {
		
		TernarySearchTree<Integer> tst=new TernarySearchTree<Integer>();
		tst.put("abc", "abc".hashCode());
		tst.put("abd", "abd".hashCode());
		tst.put("abf", "abf".hashCode());
		Iterator<String> iter=tst.prefixMatch("ab").iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
		
	}
}
