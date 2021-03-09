class TreeTreversal {
    data class TreeNode(val value: Int, val left: TreeNode?, val right: TreeNode?)

    fun inorderTraversal(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        inorder(root, list)
        return list
    }

    private fun inorder(root: TreeNode?, list: MutableList<Int>) {
        root?.let {
            inorder(it.left, list)
            list.add(it.value) // 前序或后续只需要将此行往上或往下放一行即可
            inorder(it.right, list)
        }
    }
}
