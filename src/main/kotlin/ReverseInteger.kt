package ru.theelizarov

import kotlin.math.absoluteValue

/**
 * Task https://leetcode.com/problems/reverse-integer/
 *
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 */
class ReverseIntegerSolution {
    class Solution {
        fun reverse(x: Int): Int {
            return reverse1(x)
        }

        /**
         * Простой алгоритм при преобразовании числа в строку,
         * реверс ее и преобразовании обратно в число
         */
        private fun reverse1(
            x: Int
        ): Int {

            var result = x.absoluteValue
                .toString()
                .reversed()
                .toInt()

            if (x < 0) {
               result *= -1
            }

            return result
        }
    }
}