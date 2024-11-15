// https://leetcode.com/problems/linked-list-cycle/

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    // Time O(N)
    // Space O(1)
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) return false

        var slow: ListNode? = head
        var fast: ListNode? = head.next

        while (fast != null && slow != fast) {
            slow = slow?.next
            fast = fast?.next?.next
        }

        return slow == fast
    }
}
