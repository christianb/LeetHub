// https://leetcode.com/problems/invert-binary-tree/

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
    // Time O(n)
    // Space O(h)
    fun invertTree(root: TreeNode?): TreeNode? {
        return recursiveInvert(root)
        // return iterativeInvert(root)
    }

    private fun recursiveInvert(root: TreeNode?): TreeNode? {
        if (root == null) return null

        // in-order traversal: left-root-right
        invertTree(root.left)

        val right = root.right
        root.right = root.left
        root.left = right
        
        invertTree(right)

        return root
    }

    // Time: O(N)
    // Space: O(h) 
    private fun iterativeInvert(root: TreeNode?): TreeNode? {
        if (root == null) return null

        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)

        while(queue.isNotEmpty()) {
            val node: TreeNode = queue.removeLast()
            val left: TreeNode? = node.left
            val right: TreeNode? = node.right

            if (right != null) queue.addLast(right)
            if (left != null) queue.addLast(left)

            node.left = right
            node.right = left
        }

        return root
    }
}
