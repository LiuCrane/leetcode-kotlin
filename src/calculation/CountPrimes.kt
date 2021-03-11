package calculation

class CountPrimes {
    /**
     * 数出n以内(不包括n)所有素数， 将素数的倍数全部筛掉，剩下的全是素数
     *
     * @param n Int
     * @return Int
     */
    fun countPrimes(n: Int): Int {
        if (n < 3) return 0
        val isPrimes = Array(n) { true }
        var count = 0
        for (i in 2 until n) {
            if (!isPrimes[i]) continue
            count++
            for (j in i.toLong() * i until n.toLong() step i.toLong()) {
                isPrimes[j.toInt()] = false
            }
        }
        return count
    }
}