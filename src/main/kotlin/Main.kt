package ru.theelizarov

import ru.theelizarov.leetcode.MedianOfTwoSortedArraysSolution
import ru.theelizarov.leetcode.PalindromeNumberSolution
import ru.theelizarov.leetcode.TwoSumSolution

fun main() {
    testPalindrome()
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