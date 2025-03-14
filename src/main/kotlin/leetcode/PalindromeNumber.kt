package ru.theelizarov.leetcode

class PalindromeNumberSolution {
    /**
     * Link solution https://leetcode.com/problems/palindrome-number/solutions/6536575/solving-check-palindrome-number-bit-by-b-guve
     *
     * Task https://leetcode.com/problems/palindrome-number/
     *
     * Given an integer x, return true if x is a palindrome, and false otherwise.
     *
     *
     *
     * Example 1:
     *
     * Input: x = 121
     * Output: true
     * Explanation: 121 reads as 121 from left to right and from right to left.
     * Example 2:
     *
     * Input: x = -121
     * Output: false
     * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
     * Example 3:
     *
     * Input: x = 10
     * Output: false
     * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
     *
     *
     * Constraints:
     */
    fun isPalindrome(
        x: Int
    ): Boolean {
        return isPalindrome1(x)
    }

    fun testCheckPalindrome() {
        println(">>>Start Test Palindrome")

        val tests = listOf(1, -1, 0, 11, 12, 121, 123454321, 1212)
        tests.forEach { test ->
            println("test = $test")
            println("palindrome = ${isPalindrome1(test)}")
            println()
        }

        println(">>>End Test Palindrome")
    }

    /**
     * Простой очевидный алгоритм:
     *  1. x рассматриваем как строку
     *  2. сравниваем каждый символ каждого разряда с права и слева
     *  3. если есть несовпадения на каком-то разряде, то это не палиндром
     *
     * Замечания:
     *  1. строка из одного символа - палиндром
     *  2. отрицательное число - не палиндром
     */
    private fun isPalindrome1(
        x: Int
    ): Boolean {
        var result = true

        val value = x.toString()
        val lastIndex = value.lastIndex

        when {
            lastIndex == 0-> {
                result = true
            }
            x < 0 -> {
                result = false
            }
            else -> {
                value.forEachIndexed { index, left ->
                    val right = value[lastIndex - index]
                    if (left != right) {
                        result = false
                        return@forEachIndexed
                    }
                }
            }
        }

        return result
    }
}