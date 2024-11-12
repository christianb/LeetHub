// https://leetcode.com/problems/binary-search

class Solution {
    // Time O(log n)
    // Space O(1)
    fun search(nums: IntArray, target: Int): Int {
        return binarySearch(nums, target, left = 0, right = nums.size - 1)
    }

    private fun binarySearch(nums: IntArray, target: Int, left: Int, right: Int): Int {
        if (left > right) return -1

        val mid = left + (right - left) / 2
        if (nums[mid] == target) return mid
        
        return if (nums[mid] < target) binarySearch(nums, target, left = mid + 1, right)
        else binarySearch(nums, target, left, right = mid - 1)
    }
}
