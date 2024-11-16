// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    // Time O(N)
    // Space O(min(k, m)) - where k is the size of the set, and m is the size of the alphabet/charset
    fun lengthOfLongestSubstring(s: String): Int {
        var ans = 0
        val indexOfChar = mutableMapOf<Char, Int>()
        var i = 0

        for (j in 0 until s.length) {
            val char = s[j]
            if (char in indexOfChar) {
                i = max(indexOfChar[char]!! + 1, i)
            }
            ans = max(ans, j - i + 1)
            indexOfChar[char] = j
        }

        return ans   
    }
}
