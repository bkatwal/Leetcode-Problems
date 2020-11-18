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

    if (s == null || t == null) {
      return "";
    }
    int[] tSet = new int[128];

    populateTSet(tSet, t);

    int required = t.length();

    int left = 0;
    int right = 0;
    int found = 0;
    int start = -1;
    int end = -1;
    int min = Integer.MAX_VALUE;
    while (right < s.length()) {

      while (found >= required) {
        tSet[(int) s.charAt(left)]--;
        left++;
      }

      if (tSet[(int) s.charAt(right)] > 0) {
        tSet[(int) s.charAt(right)]--;
        found++;
      }

      if (found == required && (left - right) < min) {
        min = left - right;
        start = left;
        end = right;
      }
      right++;
    }
    return s.substring(start, end + 1);
  }

  private void populateTSet(int[] tSet, String t) {

    for (char c : t.toCharArray()) {
      tSet[(int) c]++;
    }
  }

  public static void main(String[] args) {
    MinWindowSubstring minWindowSubstring = new MinWindowSubstring();
    minWindowSubstring.minWindow("ADOBECODEBANC", "ABC");
  }
}
