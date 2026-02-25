/**
 * LeetCode 258: Add Digits
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/add-digits/
 *
 * Problem:
 * Given an integer num, repeatedly add all its digits until
 * the result has only one digit, and return it.
 *
 * Approach 1: Iterative Digit Sum
 * - Keep summing digits while number has more than one digit.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

public class AddDigits {

    public static int addDigits(int num) {

        while (num > 9) {
            int sum = 0;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            num = sum;
        }

        return num;
    }

    // Optional: Local testing
    public static void main(String[] args) {
        int num = 38;
        System.out.println(addDigits(num)); // Output: 2
    }
}