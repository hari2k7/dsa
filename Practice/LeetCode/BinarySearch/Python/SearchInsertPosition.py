"""
LeetCode 35: Search Insert Position
Difficulty: Easy
Link: https://leetcode.com/problems/search-insert-position/

Problem:
Given a sorted list of distinct integers and a target value,
return the index if the target is found.
If not, return the index where it would be inserted in order.

Approach:
- Use Binary Search
- If target is found, return index
- If not found, the left pointer gives the insert position

Time Complexity: O(log n)
Space Complexity: O(1)
"""

def search_insert(nums, target):
    left, right = 0, len(nums) - 1

    while left <= right:
        mid = left + (right - left) // 2

        if nums[mid] == target:
            return mid
        elif nums[mid] < target:
            left = mid + 1
        else:
            right = mid - 1

    # left is the correct insert position
    return left


# Optional: local testing
if __name__ == "__main__":
    nums = [1, 3, 5, 6]
    target = 5
    print(search_insert(nums, target))  # Output: 2
