import java.util.PriorityQueue

class HeapSortKLargest {
    fun sortKLargest(nums: IntArray, k: Int): Int {
        val queue = PriorityQueue<Int>()
        nums.forEach {
            queue.add(it)
            if (queue.size > k) queue.poll() // 大于K的时候，移除堆顶的元素（k + 1中最小的那个，最终剩下的K个元素中，堆顶的那个即是第K大的那个）
        }
        return queue.peek()
    }
}