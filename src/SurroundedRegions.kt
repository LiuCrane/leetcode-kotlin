class SurroundedRegions {
    private var m = 0
    private var n = 0

    fun solve(board: Array<CharArray>): Unit {
        if (board.size < 2 || board[0].size < 2) return
        m = board.lastIndex
        n = board[0].lastIndex
        for (i in 0..m) {
            dfs(board, i, 0)
            dfs(board, i, n)
        }
        for (i in 1 until n) {
            dfs(board, 0, i)
            dfs(board, m, i)
        }
        for (i in 0..m) for (j in 0..n) board[i][j] = when (board[i][j]) {
            'E' -> 'O'
            else -> 'X'
        }
    }

    private fun dfs(board: Array<CharArray>, x: Int, y: Int) {
        if (x < 0 || y < 0 || x > m || y > n || board[x][y] == 'X' || board[x][y] == 'E') return
        if (board[x][y] == 'O') board[x][y] = 'E'
        dfs(board, x + 1, y)
        dfs(board, x - 1, y)
        dfs(board, x, y + 1)
        dfs(board, x, y -1)
    }
}