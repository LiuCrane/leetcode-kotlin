class NoOverLappingIntervals {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        if (intervals.isEmpty()) return 0
        intervals.sortBy {
            it[it.lastIndex]
        }
        var lastEndNum = intervals[0][intervals[0].lastIndex]
        var result = 0
        intervals.forEachIndexed { index, array ->
            if (index != 0) {
                if (array[0] >= lastEndNum) lastEndNum = array[array.lastIndex] else result++
            }
        }
        return result
    }
}