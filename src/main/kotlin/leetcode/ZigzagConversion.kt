package ru.theelizarov.leetcode

/**
 * Task https://leetcode.com/problems/zigzag-conversion/description/
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 *
 * Input: s = "A", numRows = 1
 * Output: "A"
 *
 */
class ZigzagConversionSolution {
    /**
     * Алгоритм:
     *  1. созааем матрицу [i, j],
     *   где i - количество столбцов (source.length - 1)/numRows
     *       j - количество строк numRows
     *
     *  2. заполняем матрицу по столбцам
     *   [0, 0] = source[0],
     *   [0, 1] = source[1],
     *   [0, 2] = source[2],
     *   ...
     *   [1, 0] = " ",
     *   [1, 1] = source[3],
     *   [1, 2] = " ",
     *   ...
     *   Нужно определить логику заполнения пустых ячеек
     *
     *  3. Далее проходим по матрице по строкам и склеиваем данные из ячеек в строку, при переходе
     *  на след строку добавляем символ /n
     */
    fun convert(
        source: String,
        rows: Int
    ): String {
        var result = ""

        val cells = mutableListOf<List<Char>>()

//        val column = 0
//        for (j in 0 until rows) {
//            val row = List(rows - 1) {
//                source[j + column * rows]
//            }
//        }

        return result
    }
}