// https://leetcode.com/problems/k-closest-points-to-origin/

class Solution {
    // Time: O(N * Log K)
    // Space: O(K)
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val heap = PriorityQueue<IntArray> { a, b -> b[DISTANCE] - a[DISTANCE] }

        for (p1 in points) {
                val distance: Int = p1[X] * p1[X] + p1[Y] * p1[Y]
                heap.add(intArrayOf(p1[X], p1[Y], distance))
                if (heap.size > k) heap.poll()
        }

        return heap.map { intArrayOf(it[X], it[Y]) }.toTypedArray()
    }
}

const val X = 0
const val Y = 1
const val DISTANCE = 2
