package com.bkatwal.leetcode.slidingwindow;


/**
 * 76. Minimum Window Substring
 * <p>
 * Given two strings s and t, return the minimum window in s which will contain all the characters
 * in t. If there is no such window in s that covers all characters in t, return the empty string
 * "".
 * <p>
 * Note that If there is such a window, it is guaranteed that there will always be only one unique
 * minimum window in s.
 */
public class MinWindowSubstring {

  public String minWindow(String s, String t) {

    String result = "";
    if (s.isEmpty() || t.length() > s.length()) {
      return result;
    }
    int[] map = new int[128];
    int start = 0;
    int minStart = 0;
    int end = 0;
    int count = t.length();
    int minLength = Integer.MAX_VALUE;
    for (char temp : t.toCharArray()) {
      map[temp]++;
    }
    while (end < s.length()) {
      if (map[s.charAt(end)] > 0) {
        count--;
      }
      map[s.charAt(end)]--;
      end++;
      while (count == 0) {
        if (end - start < minLength) {
          minStart = start;
          minLength = end - start;
        }
        map[s.charAt(start)]++;
        if (map[s.charAt(start)] > 0) {
          count++;
        }
        start++;
      }
    }
    if (minLength == Integer.MAX_VALUE) {
      return "";
    }
    return s.substring(minStart, minStart + minLength);
  }
}
