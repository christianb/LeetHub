// https://leetcode.com/problems/ransom-note

class Solution {
    // Time O(N)
    // Space O(1)
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val map = HashMap<Char, Int>()
        
        for (c in magazine) {
            if (!map.contains(c)) map[c] = 0
            map[c] = map.getValue(c) + 1
        }

        for (c in ransomNote) {
            if (!map.contains(c)) return false
            else map[c] = map.getValue(c) - 1

            if (map.getValue(c) < 0) return false
        }

        return true
    }
}
