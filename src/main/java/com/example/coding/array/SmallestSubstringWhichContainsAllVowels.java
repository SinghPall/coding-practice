package com.example.coding.array;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SmallestSubstringWhichContainsAllVowels {

	public static void main(String[] args) {
		String str = "ababeivoucu";
		smallestSubstringWithAllVowels(str);
	}
/* Find smallest substring which contains all vowels present in string. If string is not having all vowel return null
 * will store each vowel with its count and indexes. 
 * If map size is less than 5 it means we dont have all vowel present in given string, return null
 * While adding items in map keep 1st and last vowel index in two temp var
 * Now wth first and last vowel we need to minimize our substring, by fist++ and last-- iff its sizes are greater than 1
 */
	public static int[] smallestSubstringWithAllVowels(String str){
		int res[] = new int[2];
		char c; int firstVowel = -1, lastVowel = -1;
		Map<Character, Index> map = new LinkedHashMap<>();
		for(int i=0; i<str.length(); i++){
			c = str.charAt(i);
			if(c == 'a' || c=='e' || c=='i' || c=='o' || c=='u'){
				if(firstVowel == -1)
					firstVowel = i;
				Index in;
				if(null != map.get(c)){
					in = map.get(c);
					in.setCount(in.getCount()+1);
					in.getIndex().add(i);
				}
				else{
					in = new Index(i, 1);
					map.put(c, in);
				}
				lastVowel = i;
			}
		}
		if(map.size() < 5) return null;
		map.forEach((k, v) -> System.out.println(k +", "+v));
		System.out.println(firstVowel +", "+ lastVowel);
		Index indexF, indexS; char lastVo;
		if(firstVowel < lastVowel){
			c = str.charAt(firstVowel); lastVo = str.charAt(lastVowel);
			indexF = map.get(c);
			indexS = map.get(lastVo);
			int i = 0, j = indexS.getCount()-1;
			while(indexF.getCount() > 1){
				indexF.getIndex().remove(i++);
				indexF.setCount(indexF.getCount()-1);
			}
			res[0] = indexF.getIndex().get(0);	
			while(indexS.getCount() > 1){
				indexS.getIndex().remove(j--);
				indexS.setCount(indexS.getCount()-1);
			}
			res[1] = indexS.getIndex().get(0);
		}	
		return res;
		// return str.substring(res[0], res[1]+1); // substring with all vowel
	}
}
class Index{
	List<Integer> index = new LinkedList<>(); int count;
	Index(int in, int c){index.add(in); count = c;};

	public List<Integer> getIndex() {
		return index;
	}

	public void setIndex(List<Integer> index) {
		this.index = index;
	}

	public int getCount(){
		return count;
	}
	public void setCount(int i){
		count = i;
	}

	@Override
	public String toString() {
		return "[index=" + index + ", count=" + count + "]";
	}
}
