package ru.theelizarov.leetcode

/**
 * Task https://leetcode.com/problems/two-sum/description/
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */

class Solution {
    /**
     * Очевидный алгоритм:
     * 1. перебираем for по всем элементам: суммируем каждый с каждым и сравниваем с target
     * 2. каждое следующее число не надо сравнивать с предыдущими, так как эти суммы были проверены ранее
     * 3. если проверяемое число больше target, то его пропускаем, переходим к следующему
     *
     * return массив из двух элементов, каждый элемент - индекс элементы из nums, сложив эти элементы, получаем
     * сумму target
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val result = IntArray(2)



        return result
    }
}