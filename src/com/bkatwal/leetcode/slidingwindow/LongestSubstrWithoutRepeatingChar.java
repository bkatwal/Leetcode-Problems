package com.bkatwal.leetcode.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters Given a string s, find the length of the
 * longest substring without repeating characters.
 */

public class LongestSubstrWithoutRepeatingChar {

  public int lengthOfLongestSubstring(final String s) {

    if (s == null || s.isEmpty()) {
      return 0;
    }

    Set<Character> set = new HashSet<>();

    int left = 0;
    int right = 0;
    int res = 0;

    while (right < s.length()) {

      while (set.contains(s.charAt(right))) {
        set.remove(s.charAt(left));
        left++;
      }
      res = Math.max(res, right - left + 1);
      set.add(s.charAt(right));
      right++;
    }

    return res;
  }
}
