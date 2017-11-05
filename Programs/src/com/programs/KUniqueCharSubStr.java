package com.programs;

import java.util.HashMap;
import java.util.Map;

public class KUniqueCharSubStr {
	public static void main(String[] args) {
		System.out.println(kUniqueCharSubStr("aabacbebebe", 3));
	}

	private static int kUniqueCharSubStr(String src, int k) {
		Map<Character, Integer> charMap = new HashMap<>();

		int maxLen = -1, maxStart = 0, start = 0, end = 0, count = 0;
		while (end < src.length()) {
			char tempC = src.charAt(end);
			charMap.put(tempC, charMap.getOrDefault(tempC, 0) + 1);
			if (charMap.get(tempC) == 1) {
				count++;
			}
			end++;
			while (count > k) {

				char c = src.charAt(start);
				if (charMap.containsKey(c)) {
					charMap.put(c, charMap.get(c) - 1);
				}
				if (charMap.get(c) == 0) {
					count--;
				}
				start++;

			}
			if (maxLen < (end - start) && count == k) {
				maxLen = end - start;
				maxStart = start;
			}
		}
		System.out.println(src.substring(maxStart, maxStart + maxLen));
		return maxLen;
	}

}
