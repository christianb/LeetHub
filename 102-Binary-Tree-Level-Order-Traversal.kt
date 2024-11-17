https://leetcode.com/problems/binary-tree-level-order-traversal/

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {

    // Recursive
    // Time O(N)
    // Space O(h)
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = ArrayList<ArrayList<Int>>()
        recursiveLevelOrder(root, level = 0, result)
        return result
    }

    private fun recursiveLevelOrder(root: TreeNode?, level: Int = 0, result: ArrayList<ArrayList<Int>>) {
        if (root == null) return

        val listAtLevel = result.elementAtOrElse(level, { ArrayList<Int>() }).apply { add(root.`val`) }
        if (result.size > level) result.set(level, listAtLevel)
        else result.add(listAtLevel)

        recursiveLevelOrder(root.left, level + 1, result)
        recursiveLevelOrder(root.right, level + 1, result)
    }

    // Iterative with Queue
    // Time O(N)
    // Space O()
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        val queue = ArrayDeque<TreeNode>()

        if (root != null) queue.addLast(root)

        while (!queue.isEmpty()) {
            val nodesInLevel = ArrayList<Int>()
            val k = queue.size
            for (i in 1..k) {
                val node = queue.removeFirst()
                nodesInLevel.add(node.`val`)
                
                val left = node.left
                if (left != null) queue.addLast(left)

                val right = node.right
                if (right != null) queue.addLast(right)
            }
            result.add(nodesInLevel)
        }

        return result
    }
}
