class NumbersOfIslands {
    private val direction = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
    private var m = 0
    private var n = 0

    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) return 0
        m = grid.lastIndex
        n = grid[0].lastIndex
        var count = 0
        for (i in 0..m) for (j in 0..n) if(dfs(grid, i, j) > 0) count++
        return count
    }

    private fun dfs(grid: Array<CharArray>, i: Int, j: Int): Int {
        if (i < 0 || j < 0 || i > m || j > n || grid[i][j] == '0') return 0
        grid[i][j] = '0'
        var size = 1
        direction.forEach { size += dfs(grid, i + it[0], j + it[1]) }
        return size
    }
}