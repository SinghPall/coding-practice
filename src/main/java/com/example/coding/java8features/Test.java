package com.example.coding.java8features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.LinkedHashMap;
public class Test {
	static final int NO_OF_CHAR = 256;
	public static void main(String[] args) {
		String str = "geeksforgeeks"; int k = 4;
		int i = kthNonRepeatingChar(str, k);
		System.out.println((i != -1 && i < str.length()) ? str.charAt(i) : "Not present");
		System.out.println(kthNonRepeatingCharUsingMapWithCustomClass(str, k));
		
		List<Log> list = new ArrayList<>();	
		list.add(new Log("11.1.1", "23.2.2020"));
		list.add(new Log("1.0.1", "28.2.2020"));
		list.add(new Log("1.0.1", "13.2.2020"));
		list.add(new Log("11.1.1", "24.3.2020"));
		//System.out.println(maxLogEntry(list));
	}
	public static String maxLogEntry(List<Log> list){
		if(null != list){
			Map<Object, Long> map = list.stream().collect(Collectors.groupingBy(e -> e.getIpAddress(), Collectors.counting()));
			return map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey().toString();

			/*Map<Object, Long> mapOfIpWithCount = list.stream().collect(Collectors.groupingBy(x -> x.getIpAddress(), Collectors.counting()));
			return mapOfIpWithCount.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey().toString();
			
			//Map<Object, Long> map = list.stream().collect(Collectors.groupingBy(x -> x.getIpAddress(), Collectors.counting()));
			//String ip = map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey().toString();
			//return ip;			
*/		
		}return null;
	}
	public static int kthNonRepeatingChar(String str, int k){
		if(null != str){
			int l =str.length();
			if(l == k) return 0;
			
			int count[] = new int[NO_OF_CHAR];
			int index[] = new int[NO_OF_CHAR];
			Arrays.fill(index, l);
			char temp = 0;
			for(int i=0; i< l; i++){
				temp = str.charAt(i);
				++count[temp];
				if(count[temp] == 1)
					index[temp] = i;
				if(count[temp] == 2)
					index[temp] = l;
			}Arrays.sort(index);
			return (index[k-1] != l) ? index[k-1] : -1;
		} 
		return -1;
	}
	public static char kthNonRepeatingCharUsingMapWithCustomClass(String str, int k){
		if(null != str){
			Map<Character, CountIndex> letterCount = new LinkedHashMap<>(NO_OF_CHAR);
			int l = str.length(); char c = 0; CountIndex key = null;
			for(int i=0; i<l; i++){
				c = str.charAt(i);
				key = letterCount.get(c);
				if(null != key){
					letterCount.get(c).incCount();
				}else{
					letterCount.put(c, new CountIndex(1, i));
				}
			}System.out.println(letterCount);
			int count = 0;
			for(Map.Entry<Character, CountIndex> map : letterCount.entrySet()){
				if(map.getValue().count == 1)
					count++;
				if(count == k) 
					return map.getKey();
			}
		}System.out.println("Not Present");
		return 0;
	}
}
class CountIndex{
	int count, index;
	CountIndex(int c, int i){count = c; index = i;}
	public int incCount(){
		return count++;
	}
	public String toString(){
		return "[index: "+index+", count: "+count+"]";
	}
}
