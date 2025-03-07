package ru.kvado.leetcode

/**
 * Task https://leetcode.com/problems/median-of-two-sorted-arrays/description/
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
    /**
     * <ru>
     *     Простой алгоритм:
     *     - созадем массив nums3[n + m]
     *     - наполняем его данными из двух массивов с учтоем сортировки
     *     - вычисляем медианц
     *     Сложность: 2 for-а O(n^2)
     *
     *     Общие размышления (не окончательный вариант)
     *     Алгоритм решения:
     *      1. берем массив, большей длинны (хотя это не обязательно), определяем его центральные элементы, запоминаем индекс
     *          - если нечетный, то это будет один элемент; если четный, то два.
     *      2. проходим for по второму массиву, для каждого элемента второго массива оцениваем:
     *          - по методу золотого сечения определяем, индекс этого элемента в первом массиве,
     *          сам элемент не вставляем в первый массив
     *          - вычисляем медиану
     *
     *     Например,
     *      nums1 = [1, 3, 10, 20, 45], центр index = 2, nums[index] = 10, медиана 10/2
     *      nums2 = [1, 1, 1, 2, 7, 50]
     *
     *      i = 0
     *      nums2[i] = 1
     *      по золотому сечению индекс в первом массиве 1 (то есть 2 элементом вставился бы)
     *      длина массива nums1 увеличилась на 1, стала 6: [1, 1, 3, 10, 20, 45], медина (nums[2] + nums[3])/2
     *      запоминаем также -1 и +1 элементы от медианных
     *
     *      i = 1
     *      nums2[i] = 1
     *      по золотому сечению индекс в первом массиве 2 (то есть 3 элементом вставился бы)
     *      длина массива nums1 увеличилась на 1, стала 7: [1, 1, 1, 3, 10, 20, 45], медина (nums[3])/2
     *      запоминаем также -1 и +1 элементы от медианных
     *
     *      i = 2
     *      nums2[i] = 1
     *      по золотому сечению индекс в первом массиве 2 (то есть 3 элементом вставился бы)
     *      длина массива nums1 увеличилась на 1, стала 7: [1, 1, 1, 1, 3, 10, 20, 45], медина (nums[3])/2
     *      запоминаем также -1 и +1 элементы от медианных
     * </ru>
     */
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
            intArrayOf(1, 3),
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