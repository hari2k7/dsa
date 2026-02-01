/**
 * LeetCode 35: Search Insert Position
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/search-insert-position/
 *
 * Problem:
 * Given a sorted array of distinct integers and a target value,
 * return the index if the target is found.
 * If not, return the index where it would be inserted in order.
 *
 * Approach:
 * - Use Binary Search on the sorted array
 * - If target is found, return its index
 * - If not found, the left pointer (l) gives the correct insert position
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        // l is the correct insert position
        return l;
    }

    // Optional: main method for local testing
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;

        System.out.println(searchInsert(nums, target)); // Output: 2
    }
}
