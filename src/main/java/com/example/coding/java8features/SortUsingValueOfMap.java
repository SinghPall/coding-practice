package com.example.coding.java8features;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortUsingValueOfMap {
	public static void main(String args[]){

		Map<String, Integer> budget = new HashMap<>();
		budget.put("clothes", 120); budget.put("grocery", 150); 
		budget.put("transportation", 100); budget.put("utility", 130); 
		budget.put("rent", 1150); budget.put("miscellneous", 90);
		budget.forEach((k, v) -> System.out.println(k+" -> "+ v));
		System.out.println();
		
		budget
		.entrySet()
		.stream()
		.sorted(Map.Entry.comparingByValue())
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (k, v) -> k, LinkedHashMap::new))
		.forEach((k,v) -> System.out.println(k+" -> "+v));

	}
}
