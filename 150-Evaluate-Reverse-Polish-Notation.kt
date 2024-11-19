// https://leetcode.com/problems/evaluate-reverse-polish-notation/

class Solution {
    // Time O(N)
    // Space O(N) - In the worst case, the stack will have all the numbers on it at the same time. This is never more than half the length of the input array.
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()
        
        for (token in tokens) {
            if (token.isOperator()) {
                val second = stack.removeLast()
                val first = stack.removeLast()
                stack.addLast(evaluate(first, second, token))
            } else stack.addLast(token.toInt())
        }

        return stack.removeLast()
    }

    private fun String.isOperator(): Boolean {
        return this == "+" || this == "-" || this == "*" || this == "/" 
    }

    private fun evaluate(a: Int, b: Int, operator: String): Int =  when (operator) {
        "+" -> a + b
        "-" -> a - b
        "*" -> a * b
        "/" -> a / b
        else -> error("unexpected operator")
    }
}
