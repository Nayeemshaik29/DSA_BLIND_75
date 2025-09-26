/*
things i had observed:
1. the next largest arrangement of given input.
2. if the input is already the largest arrangement then return the smallest arrangement.
3. inplace operation.
4. constant space.

steps i had followed:
1. traverse from the end of the array to find the first decreasing element.
2. if found, traverse again from the end to find the first element larger than the found element.
3. swap the two elements.
4. reverse the elements after the index of the first found element.

Time Complexity: O(n)
Space Complexity: O(1)

-> it is medium level problem. but the approach is very interesting and feels easy after knowing the approach.
*/

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Find the first decreasing element from the end
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = n - 1;
            // Find the element just larger than nums[i]
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // Swap them
            swap(nums, i, j);
        }

        // Reverse the elements after index i
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
