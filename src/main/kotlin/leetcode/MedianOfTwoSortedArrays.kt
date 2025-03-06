package ru.kvado.leetcode

/**
 * Задача https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 */

class MedianOfTwoSortedArraysSolution {
    fun findMedianSortedArrays(
        nums1: IntArray,
        nums2: IntArray
    ): Double {
        return -1.0
    }

    fun testGetMedian() {
        println(">>>start Test getMedian(IntArray)")
        val tests = listOf(
            intArrayOf(1, 2, 3),
            intArrayOf(1, 2),
            intArrayOf(1),
            intArrayOf(),
            intArrayOf(1, 2, 4, 10, 12, 14)
        )

        tests.forEach { test ->
            println(">>>")
            println("test = ${test.joinToString()}")
            println("median = ${getMedian(test)}")
        }

        println(">>>end Test getMedian(IntArray)")
    }

    private fun getMedian(
        array: IntArray
    ): Double {
        val size = array.size

        val isOnlyOne = size == 1
        val isEven = size % 2 == 0

        return when {
            array.isEmpty() -> 0.0
            isOnlyOne -> array[0]/2.0
            isEven -> {
                val halfIndex = (size - 1)/2
                (array[halfIndex] + array[halfIndex + 1])/2.0
            }
            else -> {
                val index = (size - 1)/2
                array[index].toDouble()
            }
        }
    }
}