package ru.theelizarov

import ru.theelizarov.leetcode.MedianOfTwoSortedArraysSolution
import ru.theelizarov.leetcode.TwoSumSolution

fun main() {
    testTwoSum()
}

private fun testTwoSum() {
    val solution = TwoSumSolution()
    solution.testTwoSum()
}

private fun testAllMedianOfTwoSortedArrays() {
    testMedianOfTwoSortedArrays()
    testMergeOfTwoSortedArrays()
}

private fun testMergeOfTwoSortedArrays() {
    val solution = MedianOfTwoSortedArraysSolution()
    solution.testMergeArrays()
}

private fun testMedianOfTwoSortedArrays() {
    val solution = MedianOfTwoSortedArraysSolution()
    solution.testGetMedian()
}