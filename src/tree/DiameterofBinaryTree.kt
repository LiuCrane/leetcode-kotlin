package tree

import kotlin.math.max

class DiameterofBinaryTree {
    private var max = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        maxDepth(root)
        return max
    }

    private fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val leftMax = maxDepth(root.left)
        val rightMax = maxDepth(root.right)
        max = max(max, leftMax + rightMax)
        return max(leftMax, rightMax) + 1
    }
}