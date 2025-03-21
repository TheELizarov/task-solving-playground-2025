package ru.theelizarov.leetcode

/**
 * Post with result https://leetcode.com/problems/median-of-two-sorted-arrays/solutions/6528742/simple-solution-on-kotlin-for-calculatin-xepe
 *
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
     *     - создаем массив nums3[n + m]
     *     - наполняем его данными из двух массивов с учетом сортировки,
     *          алгоритм слияния https://habr.com/ru/articles/281675/
     *     - вычисляем медиану
     * </ru>
     */
    fun findMedianSortedArrays(
        nums1: IntArray,
        nums2: IntArray
    ): Double {
        return getMedian(merge(nums1, nums2))
    }

    fun testMergeArrays() {
        println(">>> Start Test Merge Sorted Arrays")

        val tests = mapOf(
            intArrayOf(1) to intArrayOf(),
            intArrayOf(1, 3) to intArrayOf(2),
            intArrayOf(1, 3, 7, 10) to intArrayOf(2, 3, 4, 5),
        )

        tests.forEach { array1, array2 ->
            println("Test:")
            println("  array1 = ${array1.joinToString()}")
            println("  array2 = ${array2.joinToString()}")
            println("  merge = ${merge(array1, array2).joinToString()}")
            println()
        }
        println("")


        println(">>> End Test Merge Sorted Arrays")
    }

    fun testGetMedian() {
        println(">>>start Test getMedian(IntArray)")
        val tests = listOf(
            intArrayOf(1),
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

    /**
     * Слияние двух сортированных массивов
     */
    private fun merge(
        array1: IntArray,
        array2: IntArray
    ): IntArray {
        val size = array1.size + array2.size
        val result = IntArray(size)

        /**
         * Хранение элементов из массивов
         * для последующего сравнения между собой
         * меньший элемент будет вставлен в result
         *
         * при след итерации будет помещен новый элемент из
         * рассматриваемых массивов
         */
        val buffer = IntArray(2)

        var index1 = 0
        var index2 = 0

        /**
         * Индекс массива, элемент которого был перемещен
         * из buffer в result
         * может быть 1 или 2
         */
        var currentArray = 1

        for (indexResult in 0 until size) {
            val hasItemsInArray1 = index1 < array1.size
            val hasItemsInArray2 = index2 < array2.size

            val blockOnComparingItems = {
                when {
                    indexResult == 0 -> {
                        buffer[0] = array1[index1]
                        buffer[1] = array2[index2]
                    }
                    currentArray == 1 -> {
                        buffer[0] = array1[index1]
                    }
                    currentArray == 2 -> {
                        buffer[1] = array2[index2]
                    }
                }

                result[indexResult] = when {
                    buffer[0] < buffer[1] -> {
                        currentArray = 1
                        ++index1
                        buffer[0]
                    }
                    else -> {
                        currentArray = 2
                        ++index2
                        buffer[1]
                    }
                }
            }
            val blockOnCopyArray2ToResult = {
                result[indexResult] = array2[index2]
                ++index2
            }
            val blockOnCopyArray1ToResult = {
                result[indexResult] = array1[index1]
                ++index1
            }

            when {
                hasItemsInArray1 && hasItemsInArray2 -> {
                    /**
                     * есть не рассмотренные элементы
                     * в первом и втором массивах
                     */
                    blockOnComparingItems()
                }
                !hasItemsInArray1 && hasItemsInArray2 -> {
                    /**
                     * копируем все оставшиеся
                     * элементы из array2 в result
                     */
                    blockOnCopyArray2ToResult()
                }
                hasItemsInArray1 && !hasItemsInArray2 -> {
                    /**
                     * копируем все оставшиеся элементы
                     * из array1 в result
                     */
                    blockOnCopyArray1ToResult()
                }
                else -> break
            }
        }

        return result
    }

    private fun getMedian(
        array: IntArray
    ): Double {
        val size = array.size

        val isOnlyOne = size == 1
        val isEven = size % 2 == 0

        return when {
            array.isEmpty() -> 0.0
            isOnlyOne -> array[0].toDouble() ///2.0
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