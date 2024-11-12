// https://leetcode.com/problems/valid-anagram/

class Solution {
		// Time O(n)
    // Space O(1)
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        var array = IntArray(26)
        for (c in s) { array[c - 'a']++ }

        for (c in t) {
            if (array[c - 'a'] <= 0) return false
            array[c - 'a']--
        }

        return true
    }
}
