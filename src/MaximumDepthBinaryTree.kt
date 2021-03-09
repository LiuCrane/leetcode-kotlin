import kotlin.math.max

class MaximumDepthBinaryTree {
    fun maxDepth(root: TreeNode?): Int = if (root == null) 0 else max(maxDepth(root.left), maxDepth(root.right)) + 1
}