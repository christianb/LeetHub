// https://leetcode.com/problems/product-of-array-except-self/

class Solution {

    // One-Pass 
    // Time O(n)
    // Space O(1)
    fun productExceptSelf(nums: IntArray): IntArray {
        val output = IntArray(nums.size)

        var prefix = 1
        output[0] = 1
        for (i in 0 until nums.size - 1) {
            prefix = prefix * nums[i]
            output[i+1] = prefix
        }

        var postfix = 1
        for (i in nums.size -1 downTo 0) {
            output[i] = postfix * output[i]
            postfix = postfix * nums[i]
        }

        return output
    }

    // 3-Pass
    // Time O(n)
    // Space O(n)
    fun productExceptSelf(nums: IntArray): IntArray {
        val prefix = IntArray(nums.size)
        prefix[0] = nums[0]
        for (i in 1 until nums.size) {
            prefix[i] = prefix[i-1] * nums[i]
        }

        val postfix = IntArray(nums.size)
        postfix[nums.size-1] = nums[nums.size-1]
        for (i in nums.size - 2 downTo 1) {
            postfix[i] = postfix[i+1] * nums[i]
        }

        val output = IntArray(nums.size)
        for (i in 0 until nums.size) {
            val pre = if (i >= 1) prefix[i-1] else 1
            val post = if (i <= nums.size - 2) postfix[i+1] else 1
            output[i] = pre * post
        }

        return output
    }
}
