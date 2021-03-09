import kotlin.math.abs
import kotlin.math.max

class BalancedBinaryTree {
    private var result = true

    fun isBalanced(root: TreeNode?): Boolean {
        maxDepth(root)
        return result
    }

    private fun maxDepth(root: TreeNode?): Int {
        if (root == null || !result) return 0
        val leftDepth = maxDepth(root.left)
        val rightDepth = maxDepth(root.right)
        if (abs(leftDepth - rightDepth) > 1) result = false
        return max(leftDepth, rightDepth) + 1
    }
}