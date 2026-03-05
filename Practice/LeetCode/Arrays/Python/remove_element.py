"""
LeetCode 27: Remove Element
Difficulty: Easy
Link: https://leetcode.com/problems/remove-element/

Problem:
Given an integer array nums and an integer val,
remove all occurrences of val in-place and return
the number of elements that are not equal to val.

Approach: Two Pointer Technique
- Use pointer k to track the next position for a valid element.
- Traverse the array with i.
- If nums[i] != val, place it at nums[k] and increment k.

Time Complexity: O(n)
Space Complexity: O(1)
"""

def remove_element(nums, val):
    k = 0

    for i in range(len(nums)):
        if nums[i] != val:
            nums[k] = nums[i]
            k += 1

    return k


# Optional local test
if __name__ == "__main__":
    nums = [3, 2, 2, 3]
    val = 3
    k = remove_element(nums, val)
    print(k)        # Output: 2
    print(nums[:k]) # Output: [2, 2]
