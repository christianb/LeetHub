// https://leetcode.com/problems/implement-queue-using-stacks

class MyQueue() {

    private val inStack = ArrayDeque<Int>()
    private val outStack = ArrayDeque<Int>()

    // Time O(N)
    fun push(x: Int) {
        inStack.addLast(x)

        outStack.clear()
        for (i in inStack.size - 1 downTo 0) {
            outStack.addLast(inStack.get(i))
        }
    }

    // Time O(N)
    fun pop(): Int {
        val element = outStack.removeLast()

        inStack.clear()
        for (i in outStack.size - 1 downTo 0 ) {
            inStack.addLast(outStack.get(i))
        }

        return element
    }

    // Time: O(1)
    fun peek(): Int = outStack.last()

    // Time: O(1)
    fun empty(): Boolean = outStack.isEmpty()

}
