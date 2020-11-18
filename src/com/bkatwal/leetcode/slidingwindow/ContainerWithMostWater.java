package com.bkatwal.leetcode.slidingwindow;


/**
 * 11. Container With Most Water
 * <p>
 * <p>
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i,
 * ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i,
 * 0). Find two lines, which, together with the x-axis forms a container, such that the container
 * contains the most water.
 * <p>
 * Notice that you may not slant the container.
 */
public class ContainerWithMostWater {

  public int maxArea(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }

    int left = 0;
    int right = height.length - 1;

    int res = 0;
    int minHeight;
    while (right > left) {
      minHeight = Math.min(height[right], height[left]);
      res = Math.max(res, (right - left) * minHeight);

      if (height[right] < height[left]) {
        right--;
      } else {
        left++;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println((int) 'A');

    System.out.println((char) 65);
  }
}
