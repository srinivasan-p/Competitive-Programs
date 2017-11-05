package com.programs;

import java.util.Map;

public class LongRepeatingCharRelacement {
	public static void main(String[] args) {
		System.out.println(characterReplacement("AABABBA", 1));
	}

	public static int characterReplacement(String s, int k) {
		int[] sMap = new int[128];
		int left = 0, right = 0, count = 0, maxLen = 0;
		char[] sArr = s.toCharArray();
		while (right < s.length()) {
			sMap[sArr[right] - 'A']++;
			if (count < sMap[sArr[right] - 'A']) {
				count = sMap[sArr[right] - 'A'];
			}
			right++;
			while (!(right - left - count <= k)) {
				sMap[sArr[left] - 'A']--;
				count = getMaxArray(sMap);
				left++;
			}
			maxLen = Math.max(maxLen, right - left);
		}
		return maxLen;

	}

	private static int getMaxArray(int[] sMap) {
		int maxRes = 0;
		for (int i : sMap) {
			maxRes = Math.max(maxRes, i);
		}
		return maxRes;
	}

	private static int getMax(Map<Character, Integer> map) {
		int max = 0;
		for (int freq : map.values()) {
			max = Math.max(max, freq);
		}
		return max;
	}
}
