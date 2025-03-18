package ru.theelizarov

import ru.theelizarov.hackerrank.SortingMarkToysSolution
import ru.theelizarov.leetcode.AddToNumbersSolution
import ru.theelizarov.leetcode.MedianOfTwoSortedArraysSolution
import ru.theelizarov.leetcode.PalindromeNumberSolution
import ru.theelizarov.leetcode.TwoSumSolution

fun main() {
    testSortingMarkToysSolution()
}

private fun testSortingMarkToysSolution() {
    val solution = SortingMarkToysSolution()
    solution.test()
}

private fun testAddToNumbers() {
    val solution = AddToNumbersSolution()
    solution.testAddToNumbers()
}

private fun testPalindrome() {
    val solution = PalindromeNumberSolution()
    solution.testCheckPalindrome()
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