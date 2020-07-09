package com.example.coding.java8features;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapUsingJava8 {

	public static void main(String[] args) {
		Map<String, Integer> wordMap = getWordCount("C:/Users/pallavikumari/Desktop/InterviewJava/word.txt");
		Map<String, Integer> sortedByValue = sortByValue(wordMap);
		
		sortedByValue.forEach((k, v) -> System.out.println(k +":"+ v));
	}

	public static Map<String, Integer> getWordCount(String fileName){
		File file = new File(fileName);
		if(file.exists()){
			Map<String, Integer> map = new HashMap<>();
			try(FileInputStream fis = new FileInputStream(file);
					BufferedReader br = new BufferedReader(new InputStreamReader(fis));){
				String word, tmp;
				while((word = br.readLine()) != null){
					tmp = word.trim();
					if(map.containsKey(tmp))
						map.put(tmp, map.get(tmp) + 1);
					else
						map.put(tmp, 1);
				}
			}catch(IOException e){
				System.out.println("Exception while reading file");
				return null;
			}
			return map;
		}else{
			System.out.println("No File exists.");
			return null;
		}
	}
	public static Map<String, Integer> sortByValue(Map<String, Integer> map){
		return map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}
}
