// https://leetcode.com/problems/maximum-subarray/

class Solution {
    // Time O(n)
    // Space O(1)
    fun maxSubArray(nums: IntArray): Int {
        var currentSum = nums[0]
        var maxSum = nums[0]

        for (i in 1..nums.size-1) {
            if (currentSum < 0) currentSum = 0
            currentSum += nums[i]
            maxSum = max(maxSum, currentSum)
        }

        return maxSum 
    }
}
