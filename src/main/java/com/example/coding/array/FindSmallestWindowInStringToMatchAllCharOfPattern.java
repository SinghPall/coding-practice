package com.example.coding.array;

public class FindSmallestWindowInStringToMatchAllCharOfPattern {
	static final int numOfChar = 256;
	public static void main(String[] args) {
		String str = "this is a test string";
		String pat =  "tist";
		System.out.println(smallestWindowInStringHavingAllCharsOfPattern(str, pat));
	}

	public static String smallestWindowInStringHavingAllCharsOfPattern(String str, String pat){
		if(null == pat || null == str || pat.length() > str.length())
			return "-1";
		int hashPat[] = new int[numOfChar];
		int hashStr[] = new int[numOfChar];
		// preparing hash for pattern
		for(int i=0; i<pat.length(); i++)
			hashPat[pat.charAt(i)]++;
		
		int count = 0, start = 0, startIndex = -1, minLen = Integer.MAX_VALUE;
		
		for(int i=0; i<str.length(); i++){
			
			hashStr[str.charAt(i)]++;
			if(hashPat[str.charAt(i)] != 0 && hashStr[str.charAt(i)] <= hashPat[str.charAt(i)])
				count++;
			//if all char matched then need to shorten the window size
			if(count == pat.length()){
				
				while(hashStr[str.charAt(start)] > hashPat[str.charAt(start)] || hashPat[str.charAt(start)] == 0){
					if( hashStr[str.charAt(start)] > hashPat[str.charAt(start)] )
						hashStr[str.charAt(start)]--;
					start++;
				}
				int lenOfWindow = i - start + 1;
				if(minLen > lenOfWindow){
					minLen = lenOfWindow;
					startIndex = start;
				}
			}
		}
		if(startIndex == -1){
			System.out.println("No window present");
			return "-1";
		}
	return str.substring(startIndex, startIndex+minLen);		
	}
}
