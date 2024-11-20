/**
 * Disjoint Set (Union-Find) implementation with path compression and union by rank.
 * This data structure is used to efficiently manage a collection of disjoint sets.
 * 
 * The algorithm supports two main operations:
 * - **find**: Determines the representative (or root) of the set containing a particular element.
 * - **union**: Merges two sets into one by linking their roots together.
 * 
 * ## Time Complexity
 * - **find**: O(α(n)) where α(n) is the inverse Ackermann function, which grows very slowly, so it can be considered almost constant time.
 * - **union**: O(α(n)) due to the combination of path compression and union by rank.
 * 
 * ## Space Complexity
 * - O(n) where n is the number of elements in the disjoint set.
 * 
 * ## Use Cases
 * This algorithm is commonly used in solving problems related to:
 * - **Connected Components**: In graph theory, to find connected components of a graph.
 * - **Cycle Detection**: To detect cycles in an undirected graph.
 * - **MST (Minimum Spanning Tree)**: Used in Kruskal's algorithm for finding the Minimum Spanning Tree in a graph.
 * 
 * ## Example Problem
 * - Determining if a network of devices is fully connected or if there are isolated devices.
 * - Dynamic connectivity queries in a network, where we need to check if two nodes are connected or not.
 * 
 * @param size The number of elements in the disjoint set.
 */
class DisjointSet(size: Int) {
    // store the parent of each element
    private val parent = IntArray(size) { it }

    // store the rank (or depth) of each element for union by rank
    private val rank = IntArray(size) { 0 }

    /**
     * Finds the representative (or root) of the set containing the given element.
     * Uses path compression to flatten the tree structure, improving future lookups.
     *
     * @param x The element whose set representative is to be found.
     * @return The representative of the set containing x.
     */
    fun find(x: Int): Int {
        if (parent[x] != x) {
            // Path compression: make the tree flatter
            parent[x] = find(parent[x])
        }
        return parent[x]
    }

    /**
     * Merges two sets into one by linking their roots. The root of the set with the larger rank
     * becomes the parent of the other set. This ensures a balanced tree structure.
     *
     * @param x One element from the first set.
     * @param y One element from the second set.
     */
    fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)

        if (rootX != rootY) {
            // Union by rank: attach the smaller tree under the larger tree
            when {
                rank[rootX] > rank[rootY] -> parent[rootY] = rootX
                rank[rootX] < rank[rootY] -> parent[rootX] = rootY
                else -> {
                    // If ranks are the same, make one root the parent of the other and increase its rank
                    parent[rootY] = rootX
                    rank[rootX]++
                }
            }
        }
    }
}
