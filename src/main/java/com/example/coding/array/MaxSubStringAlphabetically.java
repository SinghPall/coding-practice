package com.example.coding.array;
import java.util.LinkedHashMap;
import java.util.Map;

public class MaxSubStringAlphabetically {
	public static void main(String[] args) {
		/*String s = " ";
		System.out.println(s.length() +" || "+s.trim().length());*/
		String str = "hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
				//"aabaab!bb";/*"GEEKSFORGEEKS"; "ABDBEFGABEF"; */
		maxSubStringWithoutRepeatingChar(str, str.length());
	}
	public static void maxSubStringWithoutRepeatingChar(String str, int len){
		Map<Character, Integer> map = new LinkedHashMap<>();
		int sIndex = 0, eIndex = -1, max=Integer.MIN_VALUE;
		String res = new String();
		char ch = str.charAt(0);
		if(len ==1)max = 1;
		//str = str.toLowerCase();
		map.put(ch, 0);
		for(int i=1; i<len; i++){
			ch = str.charAt(i);
			eIndex = i;
			if(null != map.get(ch)){
				if(max < (map.size())){
					max = (map.size());
					res = str.substring(sIndex, eIndex);
				}
				int k = map.get(ch);
				map.entrySet().removeIf(entry -> (k > entry.getValue()));
				sIndex = k+1;
			}else{ map.put(ch, i);
				if(max < map.size()){
					max = map.size();
					res = str.substring(sIndex, i+1);
				}
			}map.put(ch, i);
		}
		System.out.println("size : "+max+", "+res.toString());
	}
}
