package leetcode.sum

import java.lang.IllegalArgumentException
import java.util.HashMap


/*1. Two Sum*/
/**
 * 暴力法
 * time complexity O(n*n)
 * space complexity O(1)
 */
fun bruteForce(nums: IntArray, target: Int): IntArray? {
    if (nums.size < 2)
        throw IllegalArgumentException("numbers must more than one ")
    nums.forEachIndexed { outIndex, outData ->
        nums.forEachIndexed { index, data ->
            if (index != outIndex) {
                if (outData + data == target) {
                    val result = IntArray(2)
                    result[0] = outIndex
                    result[1] = index
                    return result
                }
            }
        }
    }
    throw IllegalArgumentException("No two sum solution ")
}

/**
 * Two-pass Hash Table
 *
 *
 * 通过hashMap实现空间换时间
 *
 * We reduce the look up time from O(n) to O(1) by trading space for speed,A hash table is built exactly for this purpose,
 * it supports fast look up in near constant time.
 * I say "near" because if a collision occurred, a look up could degenerate to O(n) time.
 * But look up in hash table should be amortized O(1) time as long as the hash function was chosen carefully.
 *
 * A simple implementation uses two iterations. In the first iteration, we add each element's value and its index to the table.
 * Then, in the second iteration we check if each element's complement (target - nums[i]target−nums[i]) exists in the table.
 * Beware that the complement must not be nums[i]nums[i] itself!
 *
 *
 * time complexity O(2n)
 * space complexity O(n)
 *
 *
 *
 */
fun twoPassHashTable(nums: IntArray, target: Int): IntArray? {
    if (nums.size < 2)
        throw IllegalArgumentException("nums must more than one element ")

    val hashMap = HashMap<Int, Int>()
    nums.forEachIndexed { index, element ->
        hashMap[element] = index//需要根据value找key 所以位置换下
    }
    nums.forEachIndexed { index, element ->
        val complement = target - element
        if (hashMap.containsKey(complement) && hashMap[complement] != index) {
            return intArrayOf(index, hashMap[complement]!!)
        }
    }
    throw  IllegalArgumentException("No two sum solution")

}

/**
 *  time complexity O(n)
 *  space complexity O(n)
 *
 */
fun onePassHashTable(nums: IntArray, target: Int): IntArray? {
    if (nums.size < 2)
        throw IllegalArgumentException("nums must more than one element")

    val hashMap = HashMap<Int, Int>()
    nums.forEachIndexed { index, element ->
        val complement = target - element
        if (hashMap.containsKey(complement)) {
            return intArrayOf(index, hashMap[complement]!!)
        } else {
            hashMap[element] = index
        }
    }
    throw IllegalArgumentException("No two sum solution")
}

/**
 *
 * 这个应该是最快的方法了
 *
 *
 * 自己构建了一个数组arr
 * 然后将nums数组中每个数的index存在arr中位置就是该数的大小
 * 其实就是优化后的map 通过空间换时间
 *
 * 然后遍历nums 获取target-nums[i] 并判断在arr中target-nums[i]处角标是否为0 不为0存的值就是该值得角标
 *
 * 思想跟 Approach 3: One-pass Hash Table一样. 只是通过array替换了hashMap来节省时间，位操作是用来保证数组不会角标越界，类似于一个哈希函数。
 */
fun twoSum(nums: IntArray, target: Int): IntArray? {
    if (nums.size < 2)
        throw IllegalArgumentException("nums must more than one element")
    val arr = IntArray(2048)
    val max = arr.size - 1
    val first = nums[0]
    for (i in 1 until nums.size) {
        val diff = target - nums[i]
        if (first == diff)
            return intArrayOf(0, i)
        val index = arr[diff and max]
        if (index != 0) {
            return intArrayOf(index, i)
        }
        arr[nums[i] and max] = i
    }
    throw IllegalArgumentException("No two sum solution")

}


/**********************************  167. Two Sum II - Input array is sorted*******************************/

/**
 * 对于已经排序(升序)的数组twoSum
 * 因为已经是升序的所以从两边往中间取
 *
 * time complexity O(n)
 * space complexity O(1)
 */
fun twoSumForSortedNums(numbers: IntArray, target: Int): IntArray {
    if (numbers.size < 2)
        throw IllegalArgumentException("nums must more than one element")
    var lowIndex = 0
    var heightIndex = numbers.lastIndex
    while (lowIndex < heightIndex) {
        val sum = numbers[lowIndex] + numbers[heightIndex]
        when {
            target == sum -> return intArrayOf(lowIndex, heightIndex)
            target < sum -> heightIndex--
            target > sum -> lowIndex++
        }
    }
    throw IllegalArgumentException("No two sum solution")

}

/**
 * 对于已经排序(升序)的数组twoSum
 * 因为已经是升序的所以使用二分查找
 *
 * time complexity O( n log n)
 * space complexity O(1)
 */
fun twoSumForSortedNums1(numbers: IntArray, target: Int): IntArray {
    if (numbers.size < 2)
        throw IllegalArgumentException("nums must more than one element")
    numbers.forEachIndexed { firstIndex, element ->
        var lowIndex = firstIndex + 1
        var heightIndex = numbers.size - 1
        while (lowIndex <= heightIndex) {
            val midIndex = (lowIndex + heightIndex).shr(1)
            when {
                numbers[midIndex] + element == target -> return intArrayOf(firstIndex, midIndex)
                numbers[midIndex] + element < target -> lowIndex = midIndex + 1
                numbers[midIndex] + element > target -> heightIndex = midIndex - 1
            }
        }
    }
    throw IllegalArgumentException("No two sum solution")
}


