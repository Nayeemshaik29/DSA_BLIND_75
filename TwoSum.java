/*
things i had observed:
1. given an array and a target, we need to find two indices such that nums[i] + nums[j] == target.
2. if no such pair exists, return [-1, -1].
3. brute force uses two loops → O(n^2).
4. optimal approach uses HashMap for quick lookups → O(n).

steps i had followed:
1. brute force → check all pairs with two loops.
2. optimal → use HashMap:
   - store visited numbers with their indices.
   - for each number, check if (target - current) already exists in the map.
   - if yes, return indices.
   - else, add current number to map.
3. return [-1,-1] if no solution.

Time Complexity:
- Brute force: O(n^2)
- Optimal (HashMap): O(n)

Space Complexity:
- Brute force: O(1)
- Optimal: O(n)

-> It is an easy level problem, but a good example to explain brute force vs. optimal.
*/

import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return new int[] { -1, -1 };
    }

    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }

    // Main method to execute
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        // Brute force
        int[] result1 = sol.twoSum(nums, target);
        System.out.println("Brute Force Result: " + Arrays.toString(result1));

        // Optimal
        int[] result2 = sol.twoSum1(nums, target);
        System.out.println("Optimal Result: " + Arrays.toString(result2));
    }
}
