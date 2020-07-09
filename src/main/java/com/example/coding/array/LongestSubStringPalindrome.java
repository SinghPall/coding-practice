package com.example.coding.array;

import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubStringPalindrome {
	static Set<String> set = new LinkedHashSet<>();
	public static void main(String[] args) {
		//System.out.println(reverse(1534236469));
		/*
		System.out.println(longestPalindrome("abba")); // len : 4, abba
		System.out.println(longestPalindrome("abcba")); //len : 5, abcba
		System.out.println(longestPalindrome("cbbd")); // len : 2, bb
		 */	
		System.out.println(countAllPalindroms("pallavi"));
	}
	
	public static String longestPalindrome(String s) {
		if(null == s || s.length() < 1) return "";
		int start = 0, end = 0, l1 = 0, l2 = 0, l = 0;
		for(int i=0; i<s.length(); i++){
			l1 = expendingFromCenter(s, i, i); // abcba -> center is one char only
			l2 = expendingFromCenter(s, i, i+1); // abba -> when 2 char of center are same
			l = Math.max(l1, l2);
			if(l > (end - start)){
				start = i - (l-1)/2;
				end = i + l/2;
			}
		}
		return s.substring(start, end+1);
	}
	public static int expendingFromCenter(String s, int l, int r){
		while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
			l--; r++;
		}
		return r-l-1;
	}
	public static int countAllPalindroms(String str){
		if(null == str || str.trim().length() <= 0)
			return 0;
		for(int i=0; i<str.length(); i++){
			count(str, i, i);
			count(str, i, i+1);
		}
		System.out.println(set);
		return set.size();
	}
	public static void count(String s, int l, int r){
		while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
			set.add(s.substring(l, r+1));
			l--; r++;
		}
	}
}
