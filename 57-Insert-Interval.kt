// https://leetcode.com/problems/insert-interval/

class Solution {
    // Time O(n)
    // Space O(n)
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = ArrayList<IntArray>()

        var i = 0

        // Case 1: No overlapping before merging intervals
        while (i < intervals.size && newInterval[START] > intervals[i][END]) {
            result.add(intervals[i])
            i++
        }

        // Case 2: Overlapping and merging intervals
        while (i < intervals.size && newInterval[END] >= intervals[i][START]) {
            newInterval[START] = min(newInterval[START], intervals[i][START])
            newInterval[END] = max(newInterval[END], intervals[i][END])
            i++
        }

        result.add(newInterval)

        // Case 3: No overlapping after merging intervals
        while (i < intervals.size && newInterval[END] < intervals[i][START]) {
            result.add(intervals[i])
            i++
        }

        return result.toTypedArray()
    }
}

const val START = 0
const val END = 1
