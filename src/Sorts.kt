import java.lang.StrictMath.ceilDiv
import java.util.*
import java.util.Comparator.comparingInt
import kotlin.Int.Companion.MAX_VALUE

class Sorts {
    fun mergeSort(arr: List<Int>): List<Int> = if (arr.size <= 1) ArrayList(arr) else
        arr.chunked(ceilDiv(arr.size, 2)).map { LinkedList(mergeSort(it)).apply { add(MAX_VALUE) } }.run {
            (0..<arr.size).map { minWith(comparingInt(LinkedList<Int>::peekFirst)).pop() }
        }

    fun selectionSort(input: List<Int>): List<Int> = ArrayList(input).run { (0..<size).map { min().also(::remove) } }
}

// template for sort:
// fun Sort(input: List<Int>): List<Int> =