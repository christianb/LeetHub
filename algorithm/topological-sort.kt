import java.util.*

/**
 * Implementation of Topological Sorting using Kahn's Algorithm (BFS).
 *
 * Topological Sorting is an ordering of vertices in a directed acyclic graph (DAG) such that 
 * for every directed edge u -> v, vertex u comes before vertex v in the ordering.
 *
 * Kahn's Algorithm uses a Breadth-First Search (BFS) approach to achieve topological sorting.
 *
 * **Algorithm Overview:**
 * 1. Compute the in-degree (number of incoming edges) for each vertex.
 * 2. Enqueue all vertices with an in-degree of 0 (no dependencies).
 * 3. While the queue is not empty:
 *      - Dequeue a vertex and add it to the topological order.
 *      - For each outgoing edge from the dequeued vertex, reduce the in-degree of the target vertex by 1.
 *      - If the in-degree of the target vertex becomes 0, enqueue it.
 * 4. If the number of vertices in the topological order is less than the total vertices in the graph, a cycle exists.
 *
 * **Parameters:**
 * @param graph A map representing the directed graph where keys are vertices and values are sets of adjacent vertices.
 *
 * **Returns:**
 * A list of vertices in topological order. If the graph contains a cycle, an exception is thrown.
 *
 * **Complexity:**
 * - Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges, 
 *   as we process each vertex and edge once.
 * - Space Complexity: O(V), for storing the in-degree array and the queue.
 *
 * **Use Case:**
 * Topological sorting is used in:
 * - Task scheduling where certain tasks must be completed before others (e.g., job scheduling).
 * - Dependency resolution in build systems (e.g., resolving package dependencies in software builds).
 * - Compilation processes where source files depend on each other.
 * 
 * **Throws:**
 * IllegalArgumentException if the graph contains a cycle, as topological sorting is not possible in cyclic graphs.
 */
fun topologicalSortKahn(graph: Map<Int, Set<Int>>): List<Int> {
    // Step 1: Compute in-degree for each vertex
    val inDegree = IntArray(graph.keys.size) { 0 }
    for (vertex in graph.keys) {
        for (neighbor in graph[vertex] ?: emptySet()) {
            inDegree[neighbor]++
        }
    }

     // Step 2: Initialize queue with vertices having in-degree 0
    val queue: Queue<Int> = LinkedList()
    for (vertex in graph.keys) {
        if (inDegree.get(vertex) == 0) queue.add(vertex)
    }

    // Step 3: Process the graph using BFS
    val topologicalOrder = mutableListOf<Int>()
    while (queue.isNotEmpty()) {
        val current = queue.poll()
        topologicalOrder.add(current)

        // Reduce in-degree for all neighbors
        for (neighbor in graph[current] ?: emptySet()) {
            inDegree[neighbor] = inDegree[neighbor] - 1
            if (inDegree[neighbor] == 0) queue.add(neighbor)
        }
    }

     // Step 4: Check for cycles
    if (topologicalOrder.size != inDegree.size) {
        throw IllegalStateException("The graph contains a cycle; topological sorting is not possible.")
    }
    
    return topologicalOrder
}
