package ru.theelizarov.leetcode

/**
 * Solution https://leetcode.com/problems/longest-substring-without-repeating-characters/solutions/6556272/solving-longest-substring-without-repeat-pp37
 *
 * Task https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */
class LongestSubstringWithoutRepeatingCharactersSolution {
    /**
     * Алгоритм:
     *  1. Проходим по строке for
     *  2. Рассматриваем каждый символ, если такого символа нет в массиве уникальных символов buffer
     *   копируем его туда, в противном случае берем длину массива и сохраняем в переменную result
     *
     */
    fun lengthOfLongestSubstring(
        source: String
    ): Int {
        var result = 0

        val buffer = mutableListOf<Char>()
        source.forEach { char ->
            if (!buffer.contains(char)) {
                buffer.add(char)
            } else {
                if (result < buffer.size) {
                    result = buffer.size
                }

                val index = buffer.indexOf(char) + 1
                val buffer2 = mutableListOf<Char>()
                for (i in index..buffer.lastIndex) {
                    buffer2.add(buffer[i])
                }

                buffer.clear()
                buffer.addAll(buffer2)

                buffer.add(char)
            }
        }

        if (result < buffer.size) {
            result = buffer.size
        }

        return result
    }

    fun test() {
        println(">>>Start Test LongestSubstringWithoutRepeatingCharactersSolution")

        val tests = listOf(
            "ohvhjdml",
//            "dvdf",
//            " ",
//            "abcabcbb",
//            "bbbb",
//            "pwwkew"
        )
        tests.forEach { test ->
            println("Test")
            println("source = $test")
            println("result = ${lengthOfLongestSubstring(test)}")
        }

        println(">>>End Test LongestSubstringWithoutRepeatingCharactersSolution")
    }
}