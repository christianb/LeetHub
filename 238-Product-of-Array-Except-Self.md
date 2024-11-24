# [238. Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)

Given an integer array nums, return an array answer such that `answer[i]` is equal to the product of all the elements of nums except `nums[i]`.

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

## Example 1
Input: nums = [1,2,3,4]

Output: [24,12,8,6]

## Example 2
Input: nums = [-1,1,0,-3,3]

Output: [0,0,9,0,0]
 
## Constraints
`2 <= nums.length <= 105`

`-30 <= nums[i] <= 30`

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 
## Follow up: 
Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

## Solution
```kotlin
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
```

[Product of Array Except Self - Leetcode 238 - Python](https://www.youtube.com/watch?v=bNvIQI2wAjk)
