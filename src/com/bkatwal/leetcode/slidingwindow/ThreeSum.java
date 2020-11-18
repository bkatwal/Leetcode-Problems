package com.bkatwal.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    if (nums.length == 0) {
      return Collections.emptyList();
    }
    Set<List<Integer>> res = new HashSet<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      int left = i + 1;
      int right = nums.length - 1;

      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];

        if (sum == 0) {
          res.add(Arrays.asList(nums[i], nums[left], nums[right]));
          left++;
          right--;
        } else if (sum > 0) {
          right--;
        } else {
          left++;
        }
      }

    }
    return new ArrayList<>(res);
  }
}
