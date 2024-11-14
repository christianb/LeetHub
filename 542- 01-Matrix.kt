// https://leetcode.com/problems/01-matrix/

class Solution {
    // Time O(n*m)
    // Space O(n*m)
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val matrix: Array<IntArray> = Array(mat.size) { IntArray(mat[0].size) { 0 } }
        val seen = HashSet<Pair<Int, Int>>()
        val queue = ArrayDeque<Node>()

        val directions = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0)
        )

        for (r in 0 until mat.size) {
            for (c in 0 until mat[r].size) {
                matrix[r][c] = mat[r][c];
                if (mat[r][c] == 0) {
                    queue.addLast(Node(r, c, 0))
                    seen.add(r to c)
                }
            }
        }

        while (queue.isNotEmpty()) {
            val node: Node = queue.removeFirst()
            
            val row = node.row
            val column = node.column
            val distance = node.distance

            for (direction in directions) {
                val nextRow = row + direction[0]
                val nextColumn = column + direction[1]

                val isValid = matrix.isValid(nextRow, nextColumn)
                if (isValid && !seen.contains(nextRow to nextColumn)) {
                    seen.add(nextRow to nextColumn)
                    queue.addLast(Node(nextRow, nextColumn, distance + 1))
                    matrix[nextRow][nextColumn] = distance + 1
                }
            }
        }

        return matrix 
    }

    private fun Array<IntArray>.isValid(row: Int, column: Int): Boolean {
        return 0 <= row && row < this.size && 0 <= column && column < this[row].size
    }
}

data class Node(
    val row: Int,
    val column: Int,
    val distance: Int,
)
