package tree

class InvertTree {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        val left = root.left
        invertTree(left)
        invertTree(root.right)
        root.left = root.right
        root.right = left
        return root
    }
}