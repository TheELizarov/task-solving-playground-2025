package ru.theelizarov.leetcode

/**
 * Task https://leetcode.com/problems/add-two-numbers/description/
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 */
class AddToNumbersSolution {
    /**
     * Example:
     * var li = ListNode(5)
     * var v = li.`val`
     * Definition for singly-linked list.
     * class ListNode(var `val`: Int) {
     *     var next: ListNode? = null
     * }
     */
    fun addTwoNumbers(
        l1: ListNode?,
        l2: ListNode?
    ): ListNode? {
        var result: ListNode? = null

        var node = result
        var node1 = l1
        var node2 = l2
        var offset = 0

        var hasNode = true
        while (hasNode) {
            val value1 = node1?.x ?: 0
            val value2 = node2?.x ?: 0

            var value3 = value1 + value2 + offset
            if (value3 >= 10) {
                value3 -= 10
                offset = 1
            } else {
                offset = 0
            }

            var newNode = ListNode(x = value3, link = null)
            if (node != null) {
                node.link = newNode
                node = newNode
            } else {
                node = newNode
                result = node
            }

            hasNode = node1?.link != null || node2?.link != null

            if (!hasNode && offset > 0) {
                newNode = ListNode(offset, link = null)
                node.link = newNode
                node = newNode
            }

            node1 = node1?.link
            node2 = node2?.link
        }

        return result
    }

    fun testAddToNumbers() {
        println(">>>Start Test AddToNumbers")
        val n11 = ListNode(x = 3, link = null)
        val n12 = ListNode(x = 4, link = n11)
        val n13 = ListNode(x = 2, link = n12)

        val n21 = ListNode(x = 4, link = null)
        val n22 = ListNode(x = 6, link = n21)
        val n23 = ListNode(x = 5, link = n22)

        val tests = listOf(
            n13 to n23
        )
        tests.forEach { nodes ->
            println()
            val l1 = nodes.first
            val l2 = nodes.second
            println("l1 = ${getString(l1)}")
            println("l2 = ${getString(l2)}")
            val result = addTwoNumbers(l1, l2)
            println("result = ${getString(result)}")
        }

        println(">>>End Test AddToNumbers")
    }

    private fun getString(head: ListNode?): String {
        val sb = StringBuilder()

        var current = head
        while (current != null) {
            sb.append("${current.x}, ")
            current = current.link
        }

        return sb.toString()
    }

    data class ListNode(
        val x: Int,
        var link: ListNode?
    )
}