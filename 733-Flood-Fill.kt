// https://leetcode.com/problems/flood-fill/

class Solution {
    // Time O (N * M)
    // Space O(N * M)
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        if (sr >= image.size) return image
        if (sc >= image[sr].size) return image

        floodFill(image, sr, sc, color, originalColor = image[sr][sc])
        return image
    }

    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int, originalColor: Int) {
        if (sr >= image.size || sr < 0) return
        if (sc >= image[sr].size || sc < 0) return
        
        if (image[sr][sc] != originalColor) return
        if (image[sr][sc] == color) return

        image[sr][sc] = color
      
        floodFill(image, sr - 1, sc, color, originalColor) // left
        floodFill(image, sr + 1, sc, color, originalColor) // right
        floodFill(image, sr, sc - 1, color, originalColor) // top
        floodFill(image, sr, sc + 1, color, originalColor) // bottom
    }
}
