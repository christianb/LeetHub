// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    // Time O(log n)
    // Space O(h)
    // Recursive
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || p == null || q == null) return null
        
        return if (p.`val` < root.`val` && q.`val` < root.`val`) lowestCommonAncestor(root.left, p, q)
        else if (p.`val` > root.`val` && q.`val` > root.`val`) lowestCommonAncestor(root.right, p, q)
        else root
    }

    // Time O(log n)
    // Space O(1)
    // Iterative
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || p == null || q == null) return null

        var node = root
        while (node != null) {
            if (p.`val` < node.`val` && q.`val` < node.`val`) node = node.left
            else if (p.`val` > node.`val` && q.`val` > node.`val`) node = node.right
            else return node
        }

        return null
    }
}
