// https://leetcode.com/problems/implement-trie-prefix-tree/

class Trie() {
    val root: Node = Node()

    fun insert(word: String) {
        var node = root
        for (c in word) {
            if (c !in node.children) node.children[c] = Node()             
            node = node.children.getValue(c)
        }

        node.isEndOfWord = true
    }

    fun search(word: String): Boolean {
        var node = root
        for (c in word) {
            if (c !in node.children) return false
            else node = node.children.getValue(c)
        }

        return node.isEndOfWord
    }

    fun startsWith(prefix: String): Boolean {
        var node = root
        for (c in prefix) {
            if (c !in node.children) return false
            else node = node.children.getValue(c)
        }

        return true
    }
}

class Node {
    val children = HashMap<Char, Node>()
    var isEndOfWord: Boolean = false
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
