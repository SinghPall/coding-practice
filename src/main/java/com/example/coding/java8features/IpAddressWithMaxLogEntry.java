package com.example.coding.java8features;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Log{
	String ipAddress;
	String timeStamp;
	Log(String i, String t){ipAddress = i; timeStamp = t;}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
}
public class IpAddressWithMaxLogEntry {

	public static void main(String[] args) {
		List<Log> list = new ArrayList<>();	
		list.add(new Log("11.1.1", "23.2.2020"));
		list.add(new Log("1.0.1", "28.2.2020"));
		list.add(new Log("1.0.1", "13.2.2020"));
		list.add(new Log("1.11.1", "24.3.2020"));
		//System.out.println(maxLogEntry(list)); 
		maxLogEntryUsinJava8(list);//using java8
	}
	public static String maxLogEntryUsinJava8(List<Log> logs){
		Map<Object, Long> map = logs.stream()
			.collect(Collectors.groupingBy(x -> x.getIpAddress(), Collectors.counting()));
		System.out.println(map);
		System.out.println(map.values().stream().max(Long::compareTo)); // give max val in map
		System.out.println(map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey());//give max value with its key
		return null;
	}

	public static String maxLogEntry(List<Log> logs){
		String ip = null; int val = 1;
		if(null != logs){
			Map<String, Integer> ipCount = new HashMap<>();
			for(Log l : logs){
				ipCount.put(l.getIpAddress(), ipCount.getOrDefault(l.getIpAddress(), 0)+1);
				if(val < ipCount.get(l.getIpAddress())){
					val = ipCount.get(l.getIpAddress());
					ip = l.getIpAddress();
				}
			} System.out.println(ipCount);
		}
		return val > 1 ? ip : "All are equal";
	}

}
