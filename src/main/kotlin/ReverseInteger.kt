package ru.theelizarov

import kotlin.math.absoluteValue

/**
 * Solution https://leetcode.com/problems/reverse-integer/solutions/6633596/reverse-integer-solution-kotlin-by-theel-ahyf/
 *
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

    fun reverse(x: Int): Int {
        return when (val value = x.toLong()) {
            !in Int.MIN_VALUE..Int.MAX_VALUE -> 0
            else -> reverse1(value)
        }
    }

    fun test() {
        println(">>> Start Test ReverseInteger")

        val tests = listOf(
            1534236469,
            9646324351
        )
        tests.forEach { test ->
            println("Test x = $test")
            println("Reversed x = ${reverse1(test.toLong())}")
        }

        println(">>> End Test ReverseInteger")
    }

    /**
     * Простой алгоритм при преобразовании числа в строку,
     * реверс ее и преобразовании обратно в число
     */
    private fun reverse1(
        x: Long
    ): Int {
        var result = x.absoluteValue
            .toString()
            .reversed()
            .toLong()

        if (x < 0) {
            result *= -1
        }

        return when (result) {
            !in Int.MIN_VALUE..Int.MAX_VALUE -> 0
            else -> result.toInt()
        }
    }
}