package com.bkatwal.leetcode.misc;


import com.bkatwal.leetcode.util.MonotonicStack;
import com.bkatwal.leetcode.util.TwoPointers;

/**
 * 42. Trapping Rain Water
 * <p>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 */
@TwoPointers
@MonotonicStack
public class RainWaterTrapping2D {

  public int trap(int[] height) {

    if (height == null) {
      return 0;
    }

    int[] leftWall = new int[height.length];
    int[] rightWall = new int[height.length];

    populateLeftWall(leftWall, height);
    populateRightWall(rightWall, height);

    int res = 0;
    for (int i = 1; i < height.length; i++) {
      int smallerWall = Math.min(leftWall[i], rightWall[i]);

      if (smallerWall > height[i]) {
        res = res + (smallerWall - height[i]);
      }
    }

    return res;
  }

  private void populateLeftWall(int[] left, int[] height) {

    int maxWall = 0;
    for (int i = 1; i < height.length; i++) {
      maxWall = Math.max(maxWall, height[i - 1]);
      left[i] = maxWall;
    }
  }

  private void populateRightWall(int[] right, int[] height) {

    int maxWall = 0;
    for (int i = height.length - 2; i >= 0; i--) {
      maxWall = Math.max(maxWall, height[i + 1]);
      right[i] = maxWall;
    }
  }
}
