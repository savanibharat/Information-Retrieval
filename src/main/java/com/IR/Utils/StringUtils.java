package com.IR.Utils;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringTokenizer;

// TODO: Auto-generated Javadoc
/**
 * The Class StringUtils.
 */
public class StringUtils {

	// Don't want to create instance of this class
	/**
	 * Does not Instantiates a new string utils.
	 */
	private StringUtils() {
	}

	// Always use this function to avoid NullPointerException on Strings
	/**
	 * Resolve null string.
	 *
	 * @param str
	 *            the str
	 * @return the string
	 */
	public static String resolveNullString(String str) {
		if (str == null) {
			return "";
		}
		return str;
	}

	// Check if String has length or not
	/**
	 * Checks for length.
	 *
	 * @param str
	 *            the str
	 * @return true, if successful
	 */
	public static boolean hasLength(String str) {
		return (str != null && str.length() > 0);
	}

	// check if the array is empty or not
	/**
	 * Checks if is array empty.
	 *
	 * @param obj
	 *            the obj
	 * @return true, if is array empty
	 */
	public static boolean isArrayEmpty(Object obj[]) {
		return (obj.length == 0 || obj == null);
	}

	// Check if array is null or not
	/**
	 * Checks if is array null.
	 *
	 * @param obj
	 *            the obj
	 * @return true, if is array null
	 */
	public static boolean isArrayNull(Object obj[]) {
		if (obj == null) {
			return true;
		}
		return false;
	}

	// Checks if there is text in string(except space)
	/**
	 * Checks for text.
	 *
	 * @param str
	 *            the str
	 * @return true, if successful
	 */
	public static boolean hasText(String str) {

		if (!hasLength(str)) {
			return false;
		}
		// Check if any character exists except space
		for (int i = 0; i < str.length(); i++) {
			if (!(str.charAt(i) == 32)) {// 32 is ASCII for space
				return true;
			}
		}
		return false;
	}

	// Check if there is white space. String with one whitespace will also
	// return true
	/**
	 * Contains white space.
	 *
	 * @param str
	 *            the str
	 * @return true, if successful
	 */
	public static boolean containsWhiteSpace(String str) {
		if (!hasLength(str)) {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 32) {
				return true;
			}
		}
		return false;
	}

	// Trim first and last space from string
	/**
	 * Trim white spaces sync.
	 *
	 * @param str
	 *            the str
	 * @return the string
	 */
	public static String trimWhiteSpacesSync(String str) {

		if (!hasLength(str)) {
			return "";
		}
		StringBuffer sb = new StringBuffer(str);
		sb = removeLeadingWhiteSpaces(sb);
		sb = removeTrailingWhiteSpaces(sb);
		return sb.toString();
	}

	/**
	 * Removes the leading white spaces.
	 *
	 * @param sb
	 *            the sb
	 * @return the string buffer
	 */
	private static StringBuffer removeLeadingWhiteSpaces(StringBuffer sb) {
		while (sb.length() > 0 && sb.charAt(0) == 32) {
			sb.deleteCharAt(0);
		}
		return sb;
	}

	/**
	 * Removes the trailing white spaces.
	 *
	 * @param sb
	 *            the sb
	 * @return the string buffer
	 */
	private static StringBuffer removeTrailingWhiteSpaces(StringBuffer sb) {
		while (sb.length() > 0 && sb.charAt(sb.length() - 1) == 32) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb;
	}

	// Trim first and last space from string
	/**
	 * Trim white spaces.
	 *
	 * @param str
	 *            the str
	 * @return the string
	 */
	public static String trimWhiteSpaces(String str) {
		if (!hasLength(str)) {
			return "";
		}
		StringBuilder sb = new StringBuilder(str);
		sb = removeLeadingWhiteSpaces(sb);
		sb = removeTrailingWhiteSpaces(sb);
		return sb.toString();
	}

	/**
	 * Removes the leading white spaces.
	 *
	 * @param sb
	 *            the sb
	 * @return the string builder
	 */
	private static StringBuilder removeLeadingWhiteSpaces(StringBuilder sb) {
		while (sb.length() > 0 && sb.charAt(0) == 32) {
			sb.deleteCharAt(0);
		}
		return sb;
	}

	/**
	 * Removes the trailing white spaces.
	 *
	 * @param sb
	 *            the sb
	 * @return the string builder
	 */
	private static StringBuilder removeTrailingWhiteSpaces(StringBuilder sb) {
		while (sb.length() > 0 && sb.charAt(sb.length() - 1) == 32) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb;
	}

	// Remove all white spaces
	/**
	 * Trim all white spaces.
	 *
	 * @param str
	 *            the str
	 * @return the string
	 */
	public static String trimAllWhiteSpaces(String str) {
		if (!hasLength(str)) {
			return "";
		}
		StringBuffer sb = new StringBuffer(str);
		for (int index = 0; index < sb.length();) {
			if (sb.charAt(index) == 32) {
				sb.deleteCharAt(index);
			} else {
				index++;
			}
		}
		return sb.toString();
	}

	// Trim first character
	/**
	 * Trim leading character.
	 *
	 * @param str
	 *            the str
	 * @param character
	 *            the character
	 * @return the string
	 */
	public static String trimLeadingCharacter(String str, char character) {
		if (!hasLength(str)) {
			return "";
		}
		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && sb.charAt(0) == character) {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}

	// Trim last character
	/**
	 * Trim trailing character.
	 *
	 * @param str
	 *            the str
	 * @param character
	 *            the character
	 * @return the string
	 */
	public static String trimTrailingCharacter(String str, char character) {
		if (!hasLength(str)) {
			return "";
		}
		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && sb.charAt(sb.length() - 1) == character) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	// startsWith prefix (Ignore case)
	/**
	 * Starts with ignore case.
	 *
	 * @param str
	 *            the str
	 * @param prefix
	 *            the prefix
	 * @return true, if successful
	 */
	public static boolean startsWithIgnoreCase(String str, String prefix) {

		if ((!hasLength(str)) && !(hasLength(prefix))) {
			return false;
		}
		if (prefix.length() > str.length()) {
			return false;
		}
		if (str.toLowerCase().startsWith(prefix.toLowerCase())) {
			return true;
		}
		return false;
	}

	// endsWith prefix (Ignore case)
	/**
	 * Ends with ignore case.
	 *
	 * @param str
	 *            the str
	 * @param suffix
	 *            the suffix
	 * @return true, if successful
	 */
	public static boolean endsWithIgnoreCase(String str, String suffix) {
		if ((!hasLength(str)) && !(hasLength(suffix))) {
			return false;
		}
		if (suffix.length() > str.length()) {
			return false;
		}
		if (str.toLowerCase().endsWith(suffix.toLowerCase())) {
			return true;
		}
		return false;
	}

	/*
	 * public static boolean subStringMatchAtIndex(String str,int index,String
	 * subString){ for (int i = 0; i < str.length(); i++) {
	 * 
	 * int temp=index+i;
	 * if(temp>=str.length()||str.charAt(temp)!=subString.charAt(i)){ return
	 * false; } } return true; }
	 */

	// Count occurrences of string
	/**
	 * Count occurencesof string.
	 *
	 * @param str
	 *            the str
	 * @param subString
	 *            the sub string
	 * @return the int
	 */
	public static int countOccurencesofString(String str, String subString) {

		if (!hasLength(str) || !hasLength(subString) || str.length() == 0
				|| subString.length() == 0) {
			return 0;
		}
		int count = 0;
		int pos = 0;
		int index;
		while ((index = str.indexOf(subString, pos)) != -1) {
			count++;
			pos = index + subString.length();
		}
		return count;
	}

	// replace old pattern with new pattern
	/**
	 * Replace.
	 *
	 * @param str
	 *            the str
	 * @param oldPattern
	 *            the old pattern
	 * @param newPattern
	 *            the new pattern
	 * @return the string
	 */
	public static String replace(String str, String oldPattern,
			String newPattern) {
		if (!hasLength(str) || !hasLength(oldPattern) || newPattern == null) {
			return str;
		}
		StringBuilder sb = new StringBuilder();
		int position = 0;
		int index = str.indexOf(oldPattern);
		int patternLength = oldPattern.length();
		while (index >= 0) {
			sb.append(str.substring(position, index));
			sb.append(newPattern);
			position = index + patternLength;
			index = str.indexOf(oldPattern, position);
		}
		return sb.append(str.substring(position)).toString();
	}

	// delete the pattern
	/**
	 * Delete.
	 *
	 * @param str
	 *            the str
	 * @param pattern
	 *            the pattern
	 * @return the string
	 */
	public static String delete(String str, String pattern) {
		return replace(str, pattern, "");
	}

	// delete characters from string
	/**
	 * Chars to delete.
	 *
	 * @param str
	 *            the str
	 * @param charsToDelete
	 *            the chars to delete
	 * @return the string
	 */
	public static String charsToDelete(String str, String charsToDelete) {

		if (!hasLength(str) || !hasLength(charsToDelete)
				|| charsToDelete == null) {
			return str;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (charsToDelete.indexOf(str.charAt(i)) == -1) {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}

	// Quote the string
	/**
	 * Quote.
	 *
	 * @param str
	 *            the str
	 * @return the string
	 */
	public static String quote(String str) {
		return (str != null ? "'" + str + "'" : null);
	}

	// unquote the string
	/**
	 * Un quote.
	 *
	 * @param str
	 *            the str
	 * @return the string
	 */
	public static String unQuote(String str) {
		if (str != null && (str.startsWith("\"") && str.endsWith("\""))
				|| (str.startsWith("'") && str.endsWith("'"))) {
			return str.substring(1, str.length() - 1);
		}
		return str;
	}

	// Quote if string
	/**
	 * Quote if string.
	 *
	 * @param obj
	 *            the obj
	 * @return the object
	 */
	public static Object quoteIfString(Object obj) {
		return (obj instanceof String ? quote((String) obj) : obj);
	}

	// capitalize the first letter
	/**
	 * Capitalize.
	 *
	 * @param str
	 *            the str
	 * @return the string
	 */
	public static String capitalize(String str) {
		return changeFirstLetterCase(str, true);
	}

	// upCapitalize the first letter
	/**
	 * Up capitalize.
	 *
	 * @param str
	 *            the str
	 * @return the string
	 */
	public static String upCapitalize(String str) {
		return changeFirstLetterCase(str, false);
	}

	// change the first letter case
	/**
	 * Change first letter case.
	 *
	 * @param str
	 *            the str
	 * @param capitalize
	 *            the capitalize
	 * @return the string
	 */
	private static String changeFirstLetterCase(String str, boolean capitalize) {

		if (!hasLength(str) || str == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		if (capitalize) {
			sb.append(Character.toUpperCase(str.charAt(0)));
		} else {
			sb.append(Character.toLowerCase(str.charAt(0)));
		}
		sb.append(str.substring(1));
		return sb.toString();
	}

	/**
	 * Un qualify.
	 *
	 * @param str
	 *            the str
	 * @return the string
	 */
	public static String unQualify(String str) {
		if (!hasLength(str))
			return "";
		return unQualify(str, '.');
	}

	/**
	 * Un qualify.
	 *
	 * @param str
	 *            the str
	 * @param seperator
	 *            the seperator
	 * @return the string
	 */
	public static String unQualify(String str, char seperator) {
		if (!hasLength(str))
			return null;
		return str.substring(str.lastIndexOf(seperator) + 1);
	}

	/**
	 * Gets the file name.
	 *
	 * @param path
	 *            the path
	 * @return the file name
	 */
	public static String getFileName(String path) {
		if (!hasLength(path)) {
			return null;
		}
		int seperatorIndex = path.lastIndexOf("/");
		return (seperatorIndex != -1 ? path.substring(seperatorIndex + 1)
				: path);
	}

	// Get the extension of the file
	/**
	 * Gets the file name extension.
	 *
	 * @param path
	 *            the path
	 * @return the file name extension
	 */
	public static String getFileNameExtension(String path) {
		if (!hasLength(path)) {
			return null;
		}
		int extensionIdx = path.lastIndexOf(".");
		if (extensionIdx == -1) {
			return null;
		}
		int folderIdx = path.lastIndexOf("/");
		if (folderIdx > extensionIdx) {
			return null;
		}
		return path.substring(extensionIdx + 1);
	}

	// Strip the file name extension
	/**
	 * Strip file name extension.
	 *
	 * @param path
	 *            the path
	 * @return the string
	 */
	public static String stripFileNameExtension(String path) {
		if (!hasLength(path)) {
			return null;
		}
		int extensionIdx = path.lastIndexOf(".");
		if (extensionIdx == -1) {
			return null;
		}
		int folderIdx = path.lastIndexOf("/");
		if (folderIdx > extensionIdx) {
			return null;
		}
		return path.substring(0, extensionIdx);
	}

	// add a string to array
	/**
	 * Adds the string to array.
	 *
	 * @param arr
	 *            the arr
	 * @param str
	 *            the str
	 * @return the string[]
	 */
	public static String[] addStringToArray(String arr[], String str) {

		if (isArrayEmpty(arr)) {
			return new String[] { str };
		}
		String newArr[] = new String[arr.length + 1];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		newArr[arr.length] = str;
		return newArr;
	}

	// Concatenate the string array
	/**
	 * Concatenate string arrays.
	 *
	 * @param array1
	 *            the array1
	 * @param array2
	 *            the array2
	 * @return the string[]
	 */
	public static String[] concatenateStringArrays(String array1[],
			String array2[]) {

		if (isArrayEmpty(array1)) {
			return array2;
		}
		if (isArrayEmpty(array2)) {
			return array1;
		}
		String temp[] = new String[array1.length + array2.length];
		System.arraycopy(array1, 0, temp, 0, array1.length);
		System.arraycopy(array2, 0, temp, array1.length, array2.length);
		return temp;
	}

	// Merge the string array
	/**
	 * Merge string arrays.
	 *
	 * @param array1
	 *            the array1
	 * @param array2
	 *            the array2
	 * @return the string[]
	 */
	public static String[] mergeStringArrays(String array1[], String array2[]) {
		if (isArrayEmpty(array1)) {
			return array2;
		}
		if (isArrayEmpty(array2)) {
			return array1;
		}
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(array1));
		for (int i = 0; i < array2.length; i++) {
			if (!list.contains(array2[i])) {
				list.add(array2[i]);
			}
		}
		return toStringArray(list);
	}

	// convert the collection to the string array
	/**
	 * To string array.
	 *
	 * @param collection
	 *            the collection
	 * @return the string[]
	 */
	public static String[] toStringArray(Collection<String> collection) {
		if (collection == null) {
			return null;
		}
		return collection.toArray(new String[collection.size()]);
	}

	// Convert enum to string array
	/**
	 * To string array.
	 *
	 * @param enumeration
	 *            the enumeration
	 * @return the string[]
	 */
	public static String[] toStringArray(Enumeration<String> enumeration) {
		if (enumeration == null) {
			return null;
		}
		List<String> list = Collections.list(enumeration);
		return list.toArray(new String[list.size()]);
	}

	// Sort the string array
	/**
	 * Sort string array.
	 *
	 * @param array
	 *            the array
	 * @return the string[]
	 */
	public static String[] sortStringArray(String[] array) {
		if (isArrayNull(array)) {
			return new String[0];
		}
		Arrays.sort(array);
		return array;
	}

	// Trim array elements using string.trim()
	/**
	 * Trim array elements.
	 *
	 * @param array
	 *            the array
	 * @return the string[]
	 */
	public static String[] trimArrayElements(String[] array) {
		if (isArrayNull(array)) {
			return new String[0];
		}
		String[] result = new String[array.length];
		for (int i = 0; i < array.length; i++) {
			String temp = array[i];
			result[i] = (temp != null ? temp.trim() : null);
		}
		return result;
	}

	// Trim the ArrayLst<String>
	/**
	 * Trim string list.
	 *
	 * @param list
	 *            the list
	 * @return the array list
	 */
	public static ArrayList<String> trimStringList(ArrayList<String> list) {

		if (list == null) {
			return null;
		}
		if (list.size() == 0) {
			return list;
		}
		ArrayList<String> newList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			newList.add(list.get(i).trim());
		}
		return newList;
	}

	// Remove the duplicate strings from the string array
	/**
	 * Removes the duplicate strings.
	 *
	 * @param array
	 *            the array
	 * @return the string[]
	 */
	public static String[] removeDuplicateStrings(String[] array) {
		if (isArrayNull(array)) {
			return new String[0];
		}
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < array.length; i++) {
			if (!list.contains(array[i])) {
				list.add(array[i]);
			}
		}
		return toStringArray(list);
	}

	// Split the str using the delimiter
	/**
	 * Split.
	 *
	 * @param str
	 *            the str
	 * @param delimiter
	 *            the delimiter
	 * @return the string[]
	 */
	public static String[] split(String str, String delimiter) {// cant locate
																// delimiter
		if (!hasLength(str) || !hasLength(delimiter)) {
			return null;
		}
		int offset = str.indexOf(delimiter);
		if (offset < 0) {
			return null;
		}
		String before = str.substring(0, offset);
		String after = str.substring(offset + delimiter.length());
		return new String[] { before, after };
	}

	/**
	 * Split array elements into properties.
	 *
	 * @param array
	 *            the array
	 * @param delimiter
	 *            the delimiter
	 * @return the linked hash map
	 */
	public static LinkedHashMap<String, String> splitArrayElementsIntoProperties(
			String[] array, String delimiter) {
		return splitArrayElementsIntoProperties(array, delimiter, null);
	}

	/**
	 * Split array elements into properties.
	 *
	 * @param array
	 *            the array
	 * @param delimiter
	 *            the delimiter
	 * @param charsToDelete
	 *            the chars to delete
	 * @return the linked hash map
	 */
	public static LinkedHashMap<String, String> splitArrayElementsIntoProperties(
			String[] array, String delimiter, String charsToDelete) {

		if (isArrayNull(array)) {
			return null;
		}
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		for (int i = 0; i < array.length; i++) {

			if (charsToDelete != null) {
				array[i] = delete(array[i], charsToDelete);
			}
			String[] split = split(array[i], delimiter);
			if (split == null) {
				continue;
			}
			map.put(split[0].trim(), split[1].trim());
		}
		return map;
	}

	/**
	 * Tokenizeto string array.
	 *
	 * @param str
	 *            the str
	 * @param delimiter
	 *            the delimiter
	 * @return the string[]
	 */
	public static String[] tokenizetoStringArray(String str, String delimiter) {
		return tokenizetoStringArray(str, delimiter, true, true);
	}

	/**
	 * Tokenizeto string array.
	 *
	 * @param str
	 *            the str
	 * @param delimiter
	 *            the delimiter
	 * @param trimTokens
	 *            the trim tokens
	 * @param ignoreEmptyTokens
	 *            the ignore empty tokens
	 * @return the string[]
	 */
	public static String[] tokenizetoStringArray(String str, String delimiter,
			boolean trimTokens, boolean ignoreEmptyTokens) {

		if (str == null) {
			return null;
		}
		StringTokenizer stringTokenizer = new StringTokenizer(str, delimiter);
		ArrayList<String> tokens = new ArrayList<String>();
		while (stringTokenizer.hasMoreTokens()) {
			String token = stringTokenizer.nextToken();
			if (trimTokens) {
				token = token.trim();
			}
			if (!ignoreEmptyTokens || token.length() > 0) {
				tokens.add(token);
			}
		}
		return toStringArray(tokens);
	}

	// Get the stack trace as string
	/**
	 * Gets the stack trace.
	 *
	 * @param throwable
	 *            the throwable
	 * @return the stack trace
	 */
	public static String getStackTrace(Throwable throwable) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		throwable.printStackTrace(printWriter);
		return stringWriter.toString();
	}

	// Sort the strings that are actually interger
	// Example "111","2","11","0",null
	/**
	 * Sort string array of integers.
	 *
	 * @param str
	 *            the str
	 * @return the string[]
	 */
	public static String[] sortStringArrayOfIntegers(String str[]) {

		if (isArrayNull(str)) {
			return null;
		}
		if (isArrayEmpty(str)) {
			return new String[0];
		}

		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < str.length; i++) {
			if (str[i] != null && str[i].length() > 0) {
				list.add(Integer.parseInt(str[i]));
			}
		}

		Collections.sort(list);
		String newStr[] = new String[list.size()];

		for (int i = 0; i < newStr.length; i++) {
			newStr[i] = Integer.toString(list.get(i));
		}
		System.out.println(list);
		for (int i = 0; i < newStr.length; i++) {
			System.out.println(newStr[i]);
		}
		return newStr;
	}

	/**
	 * Sort string array of integers.
	 *
	 * @param str
	 *            the str
	 * @return the string[]
	 */
	public static String[] sortStringArrayOfIntegers(ArrayList<String> str) {
		return sortStringArrayOfIntegers(toStringArray(str));
	}

	/**
	 * Merge in sorted way.
	 *
	 * @param str1
	 *            the str1
	 * @param str2
	 *            the str2
	 * @return the string[]
	 */
	public static String[] mergeInSortedWay(String[] str1, String str2[]) {

		String str3[] = new String[str1.length + str2.length - 1];
		str3 = mergeStringArrays(str1, str2);
		Arrays.sort(str3);
		return str3;

	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
	}
}