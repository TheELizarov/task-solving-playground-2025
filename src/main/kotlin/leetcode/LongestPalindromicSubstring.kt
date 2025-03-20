package ru.theelizarov.leetcode

/**
 * Task https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 */
class LongestPalindromicSubstringSolution {
    fun longestPalindrome(
        source: String
    ): String {
        var result = ""
        val lastIndex = source.lastIndex
        for (i in 0..lastIndex) {
            for (j in i..lastIndex) {
                val substring = source.substring(i, j)
                if (isPalindrome(substring)) {
                    if (result.length < substring.length) {
                        result = substring
                    }
                }
            }
        }

        return result
    }

    fun isPalindrome(
        source: String
    ): Boolean {
        return when {
            source.length == 1 -> true
            else -> {
                var  check = true
                source.forEachIndexed { index, left ->
                    val right = source[source.lastIndex - index]
                    if (left != right) {
                        check = false
                        return@forEachIndexed
                    }
                }

                check
            }
        }
    }

    fun test() {
        println(">>>Start Test LongestPalindromicSubstringSolution")

        val tests = listOf(
            "babad",
            "cbbd"
        )
        tests.forEach { test ->
            println("Test")
            println("source = $test")
            println("answer = ${longestPalindrome(source = test)}")
            println()
        }

        println(">>>End Test LongestPalindromicSubstringSolution")
    }
}