package ru.theelizarov.hackerrank

/**
 * Task https://www.hackerrank.com/challenges/mark-and-toys/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
 *
 * Mark and Jane are very happy after having their first child. Their son loves toys, so Mark wants to buy some. There are a number of different toys lying in front of him, tagged with their prices. Mark has only a certain amount to spend, and he wants to maximize the number of toys he buys with this money. Given a list of toy prices and an amount to spend, determine the maximum number of gifts he can buy.
 *
 * Note Each toy can be purchased only once.
 *
 * Example
 *
 *
 * The budget is  units of currency. He can buy items that cost  for , or  for  units. The maximum is  items.
 *
 * Function Description
 *
 * Complete the function maximumToys in the editor below.
 *
 * maximumToys has the following parameter(s):
 *
 * int prices[n]: the toy prices
 * int k: Mark's budget
 * Returns
 *
 * int: the maximum number of toys
 */
class SortingMarkToysSolution {
    /**
     * Алгоритм:
     *  1. сортируем массив prices со стоимостями игрушек
     *  2. проходим по массиву и считаем количество игрушек, сумма стоимостей которых меньше k
     *  3. возвращаем количество игрушек
     *
     *  Примечание:
     *   При сортировке можно не учитывать элементы, которые больше k
     */
    fun maximumToys(
        prices: Array<Int>,
        k: Int
    ): Int {
        var result = 0
        val lastIndex = prices.size - 1

        /**
         * Сортировка пузырьком
         */
        for (i in 0..lastIndex) {
            val first = prices[i]
            if (first < k) {
                for (j in 0..lastIndex) {
                    val second = prices[j]
                    if (second < 0) {
                        if (second < first) {
                            prices[i] = second
                            prices[j] = first
                        }
                    }
                }
            }
        }

        /**
         * Подсчет количества игрушек,
         * стоимость которых укладывается в бюджет k
         */
        var sum = 0
        for (i in 0..lastIndex) {
            sum += prices[i]
            if (sum < k) {
                ++result
            } else {
                break
            }
        }

        return result
    }

    fun test() {
        println(">>>Start Test SortingMarkToysSolution")

        val tests = listOf(
            intArrayOf(1, 12, 5, 111, 200, 1000, 10) to 50
        )
        tests.forEach { test ->
            println("Test")
            println("array = ${test.first.joinToString()}")
            println("k = ${test.second}")
            println("result = ${maximumToys(test.first.toTypedArray(), test.second)}")
        }

        println(">>>End Test SortingMarkToysSolution")
    }
}