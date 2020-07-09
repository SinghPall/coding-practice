package com.example.coding.array;

public class LongestUniformSubSequence {

	public static void main(String[] args) {
		int res[] = findLongestUniformSubString("abbbcde");Util.print(res,  res.length); //1,3
		res = findLongestUniformSubString("aaabcd"); Util.print(res,  res.length);// 0, 2
		res = findLongestUniformSubString("abcde"); Util.print(res,  res.length);//0, 0
		res = findLongestUniformSubString("aabbccddeee"); Util.print(res,  res.length);//8,10
		res = findLongestUniformSubString(""); Util.print(res,  res.length);//-1,-1
		res = findLongestUniformSubString(null); Util.print(res,  res.length);//-1,-1
	}
	public static int[] findLongestUniformSubString(String str){
		int startIndexForMax = -1, endIndexForMax = -1; //hold start and end index for char which is occurring max time
		if(null != str && str.length() > 1){
			int len = str.length(), max = -1;
			int cache[] = new int[len];
			cache[0] = 1;
			for(int i=1; i<len ;i++){ // acbbbaa -> 1112312
				if(str.charAt(i) == str.charAt(i-1))
					cache[i] = cache[i-1] +1;
				else cache[i] =1;
			}
			/*find max ele in cache(bcz cache is holding occurances of char from string)
			to find ele which comes max number of times in given string*/
			for(int i=0; i<len ;i++){
				if(max<cache[i]){
					max = cache[i];
					endIndexForMax = i;
				}
			}
			// now if max is equal to index it means our substring is starting from 0th index
			if(max == endIndexForMax+1)
				startIndexForMax = 0;
			else
				startIndexForMax = endIndexForMax - max +1;
		}
		return new int[]{startIndexForMax, endIndexForMax};
	}
}
