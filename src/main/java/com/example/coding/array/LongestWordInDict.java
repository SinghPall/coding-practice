package com.example.coding.array;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
public class LongestWordInDict {
	static Set<String> dict = null;
	public static void main(String args[]){
		 String[] arr = {"ale", "apple", "monkey", "plea"};
		 dict = new HashSet<>(Arrays.asList(arr));
		 String str = "ale";
		 System.out.println(findLongestWordInDict(str));
	}
	// finds longest word in dictionary, after deleting few chars in given string
	public static String findLongestWordInDict(String str){
		if(null != str){
			int len = 0; String res = "";
			for(String word : dict){
				if(len < word.length() && isSubSeq(word, str)){
					res = word;
					len = word.length();
				}
			}
			return res;
		}return "-1";
	}
	public static boolean isSubSeq(String word, String str){
		int wordIndex = 0, wLen = word.length(), sLen = str.length();
		for(int strIndex=0; strIndex<sLen && wordIndex<wLen; strIndex++){
			if(word.charAt(wordIndex) == str.charAt(strIndex))
				wordIndex++;
		}
		return (wordIndex == wLen);
	}
}
