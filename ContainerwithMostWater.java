/*
Problem: Container With Most Water (LeetCode #11)

Observation:
1. Given an array of heights, each index represents a line on the x-axis.
2. We need to find two lines that, along with the x-axis, form a container holding the **maximum water**.
3. The area between two lines = height * width
   - height = min(height[i], height[j])
   - width = j - i

Approach:
1. Brute Force:
   - Check area for all pairs (i, j).
   - Time: O(n^2)
2. Optimal (Two Pointer Approach):
   - Use two pointers `i = 0`, `j = n - 1`.
   - Compute area = min(height[i], height[j]) * (j - i).
   - Move the pointer with the **smaller height**, because increasing the smaller height might increase the area.
   - Keep track of the maximum area found.

Steps Followed:
1. Initialize two pointers and `water = 0`.
2. While (i < j):
   - Calculate area.
   - Update maximum area.
   - Move the pointer with smaller height.
3. Return the maximum area.

Time Complexity:
- Brute Force: O(n^2)
- Optimal (Two Pointer): O(n)

Space Complexity:
- O(1)

👉 It's a classic **two-pointer** problem showing how narrowing search space smartly gives linear-time optimization.
*/

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0, j = n - 1;
        int water = 0;

        while (i < j) {
            int h = Math.min(height[i], height[j]); // height of container
            int w = j - i; // width between lines
            int area = h * w; // area = height * width
            water = Math.max(water, area); // update max water

            // move pointer with smaller height
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return water;
    }

    // Main method to execute
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] height = {1,8,6,2,5,4,8,3,7};

        int result = sol.maxArea(height);
        System.out.println("Maximum Water Stored: " + result);
    }
}
