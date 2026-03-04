/**
 * LeetCode 27: Remove Element
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/remove-element/
 *
 * Problem:
 * Given an integer array nums and an integer val,
 * remove all occurrences of val in-place.
 * The relative order of elements may be changed.
 * Return the number of elements in nums which are not equal to val.
 *
 * Approach: Two Pointer Technique
 * - Use pointer k to track the position of the next valid element.
 * - Traverse the array with i.
 * - If nums[i] is not equal to val, place it at nums[k].
 * - Increment k.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int removeElement(int[] nums, int val) {

        int k = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }

        }

        return k;
    }
}