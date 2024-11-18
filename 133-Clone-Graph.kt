// https://leetcode.com/problems/clone-graph/

/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */

class Solution {

    // Time O(N + M) - where N is a number of nodes (vertices) and M is a number of edges
    // Space (N) - This space is occupied by the visited dictionary and in addition to that, space would also be occupied by the queue since we are adopting the BFS approach here. 
    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null
        val visited = HashMap<Node, Node>()

        val queue = ArrayDeque<Node>()
        queue.addLast(node)

        while (queue.isNotEmpty()) {
            val node: Node = queue.removeFirst()

            val copy: Node = visited.getOrDefault(node, Node(node.`val`))
            visited[node] = copy

            // copy adjacent nodes
            for (neighbor in node.neighbors) {
                if (neighbor == null) continue

                if (!visited.contains(neighbor)) {
                    queue.addLast(neighbor)
                    visited[neighbor] = Node(neighbor.`val`)
                }

                copy.neighbors.add(visited[neighbor])
            }
        }

        return visited.getValue(node)
    }
}
