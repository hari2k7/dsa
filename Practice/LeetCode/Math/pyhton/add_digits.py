"""
LeetCode 258: Add Digits
Difficulty: Easy
Link: https://leetcode.com/problems/add-digits/

Problem:
Given an integer num, repeatedly add all its digits until
the result has only one digit, and return it.

Approach 1: Iterative Digit Sum
- Keep summing digits while number has more than one digit.

Time Complexity: O(log n)
Space Complexity: O(1)
"""


def add_digits(num: int) -> int:
    while num > 9:
        total = 0

        while num > 0:
            total += num % 10
            num //= 10

        num = total

    return num


# Optional: local testing
if __name__ == "__main__":
    num = 38
    print(add_digits(num))  # Output: 2