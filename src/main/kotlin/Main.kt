package ru.theelizarov

import ru.theelizarov.hackerrank.SortingMarkToysSolution
import ru.theelizarov.leetcode.*

fun main() {
    testLongestPalindromicSubstringSolution()
}

private fun testLongestPalindromicSubstringSolution() {
    val solution = LongestPalindromicSubstringSolution()
    solution.test()
}

private fun testLongestSubstringWithoutRepeatingCharactersSolution() {
    val solution = LongestSubstringWithoutRepeatingCharactersSolution()
    solution.test()
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