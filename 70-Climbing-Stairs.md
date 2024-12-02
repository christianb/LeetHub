# [70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs/description/)

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

## Example 1
```
Input: n = 2

Output: 2

Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
```

## Example 2
```
Input: n = 3

Output: 3

Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
```
 
## Constraints
`1 <= n <= 45`
 
## Solution
```kotlin
class Solution {

    /* 
     * Fibonacci
     *
     * Time O(n)
     * Space O(1)
     */
    fun climbStairs(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2

        var a = 1
        var b = 2
        
        for (i in 3..n) {
            val c = a + b
            a = b
            b = c
        }
        
       return b
    }

    /* 
     * Dynamic programming
     *
     * Time O(n)
     * Space O(n) - the size of the array
     */
    fun climbStairs(n: Int): Int {
        if (n == 1) return 1
        val dp = IntArray(n+1)
        dp[1] = 1
        dp[2] = 2

        for (i in 3..n) {
            dp[i] = dp[i-1] + dp[i-2]
        }
        
       return dp[n]
    }

    private val memoization = HashMap<Pair<Int,Int>,Int>()

    /* 
     * Recursive - Memoization
     * Time O(n)
     * Space O(n) - The depth of the recursion tree can go up to n
     */
    fun climbStairs(n: Int, i: Int = 0): Int {
        if (i > n) return 0
        if (i == n) return 1
        if (!memoization.contains(n to i)) {
            memoization[n to i] = climbStairs(n, i + 1) + climbStairs(n, i + 2)
        }

       return memoization.getValue(n to i)
    }

    /* 
     * Recursive
     * Time O(2^n)
     * Space O(n) - The depth of the recursion tree can go up to n
     */
    fun climbStairs(n: Int, i: Int = 0): Int {
       if (i > n) return 0
       if (i == n) return 1
       return climbStairs(n, i + 1) + climbStairs(n, i + 2)
    }
}
```

[Product of Array Except Self - Leetcode 238 - Python](https://www.youtube.com/watch?v=bNvIQI2wAjk)
