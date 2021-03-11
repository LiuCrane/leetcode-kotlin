package greedy

import java.util.*

class ReconstructionQueue {
    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        if (people.isEmpty()) return people
        Arrays.sort(people) { a, b -> if (a[0] == b[0]) a[1].compareTo(b[1]) else b[0].compareTo(a[0]) }
        val result = LinkedList<IntArray>()
        people.forEach { result.add(it[1], it) }
        return result.toTypedArray()
    }
}