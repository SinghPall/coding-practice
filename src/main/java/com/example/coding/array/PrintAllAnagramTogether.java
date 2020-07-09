package com.example.coding.array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class PrintAllAnagramTogether {

	public static void main(String[] args) {
		String arr[] = { "cat", "dog", "tac", "god", "act" };
		printAnagram(arr, arr.length);
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
		
	}

	public static void printAnagram(String str[], int n){
		Map<String, List<String>> map = new HashMap<>();
		String key = null;
		for(int i=0; i<n; i++){
			char ch[] = str[i].toCharArray();
			Arrays.sort(ch);
			key = new String(ch);
			if(map.containsKey(key))
				map.get(key).add(str[i]);
			else{
				List<String> l = new ArrayList<>();
				l.add(str[i]);
				map.put(key, l);
			}
		}
		// printing all anagram
		map.entrySet().forEach(s -> System.out.println(s.getKey()+" --> "+s.getValue()));
		
	}
}
