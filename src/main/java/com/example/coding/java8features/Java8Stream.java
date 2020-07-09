package com.example.coding.java8features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Person{
	String name; Gender gender;
	Person(String n, Gender g){name = n; gender = g;}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	@Override
	public String toString(){
		return "Person[Name: "+name+", G: "+gender+"]";
	}
}
enum Gender{
	MALE, FEMALE;
}
public class Java8Stream {
	public static void main(String args[]){
		List<Person> list = new ArrayList<>();
		list.add(new Person("Ram", Gender.MALE));
		list.add(new Person("Aarya", Gender.FEMALE));
		list.add(new Person("Jenny", Gender.FEMALE));
		list.add(new Person("Jenny", Gender.FEMALE));
		list.add(new Person("Jai", Gender.MALE));
		System.out.println(list);
		List<String> name= new ArrayList<>();
		// exp :- 1
		list.stream().filter( p -> p.getGender() == Gender.FEMALE)
					 .map( p -> p.getName().toUpperCase())
					 .forEach( n -> name.add(n));
		System.out.println(name);
		// exp :- 2
		Map<String, Person> m = list.stream()
									.filter(p -> p.getName().startsWith("J"))
									.collect(Collectors.toMap(Person::getName, Person -> Person, 
											(newVal, oldVal) -> newVal, LinkedHashMap::new));
		System.out.println(m);
		// exp :- 3
		List<String> l = list.stream()
					 .filter(p -> {
						 		   System.out.println("Can write multiple line");
						           return p.getGender() == Gender.MALE;
						          }
							 )
					 .sorted(Comparator.comparing(Person::getName))
					 .map(p -> {
							 System.out.println("mapping name");
							 return p.getName();
					 	  })
					 .limit(1)
					 .collect(Collectors.toCollection(LinkedList::new));
		System.out.println(l);
		// exp :- 4
		List<Integer> num = Arrays.asList(5,8,25,9,0);
		int max = num.stream().reduce(1, Integer::max); System.out.println(max);
	}
}
