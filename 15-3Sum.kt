// https://leetcode.com/problems/3sum/

class Solution {

    // Time O(N^2)
    // Space O(log N)
    fun threeSum(nums: IntArray): List<List<Int>> {

        // Based on Two Sum II: https://leetcode.com/articles/two-sum-ii-input-array-is-sorted/
        // requires a sorted array.
        nums.sort()

        // To ensure the result contains unique triplets, we need to skip duplicated values.
        // This is easy, as repeating values are next to each other in a sorted array.
        
        val result = ArrayList<List<Int>>()

        // i is our pivot element that moved from left to right
        var i = 0
        
        while (i < nums.size && nums[i] <= 0) {

            // lo and hi are the values we compare with i
            var lo = i + 1
            var hi = nums.size - 1

            if (i == 0 || nums[i] != nums[i-1]) {
                while (lo < hi) { 
                    val threeSum = nums[lo] + nums[hi] + nums[i]
                    
                    if (threeSum > 0) hi-- // if 3sum is greater 0 we move hi to left (lowering the sum)
                    else if (threeSum < 0) lo++ // if 3sum is smaller 0 we move lo to right (increasing the sum)
                    else if (threeSum == 0) { // if 3sum is 0 we found a solution
                        // post incr lo and decr hi
                        result.add(listOf(nums[i], nums[lo++], nums[hi--]))
                        // ensure lo is not the same value as before (as we need unique results)
                        while (lo < hi && nums[lo] == nums[lo - 1]) lo++
                    }
                }
            }
            i++          
        }
        return result
    }
}
