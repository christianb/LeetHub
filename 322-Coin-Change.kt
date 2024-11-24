// https://leetcode.com/problems/coin-change/

class Solution {
    // Time O(amount + len(coins))
    // Space O(amount)
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount+1) { amount + 1 }
        dp[0] = 0

        for (a in 1..amount) {
            for (coin in coins) {
                if (a - coin >= 0) dp[a] = min(dp[a], 1 + dp[a - coin])
            }
        }

        return if (dp[amount] < amount + 1) dp[amount] else -1
    }
}
