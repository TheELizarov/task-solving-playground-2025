/**
 * https://coderun.yandex.ru/problem/median-out-of-three
 */
class AverageValueSolution {
    fun getAverageValue(
        array: List<Int>
    ): Int {
        return array.sorted()[1]
    }

    fun parse(
        input: String
    ): List<Int> {
        return input
            .split(" ")
            .map { it.toInt() }
    }
}