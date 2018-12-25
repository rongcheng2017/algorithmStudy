import java.lang.Exception
import java.lang.IllegalArgumentException

fun binaraySearch(numbers: IntArray, iStartIndex: Int, iEndIndex: Int, key: Int): Int {

    if (numbers.isEmpty())
        throw IllegalArgumentException("numbers can not be null")

    var startIndex = iStartIndex
    var endIndex = iEndIndex
    var midIndex = (startIndex + endIndex) / 2

    while (startIndex <= endIndex)
        when {
            key == numbers[midIndex] -> return midIndex
            key < numbers[midIndex] -> {
                endIndex = midIndex-1
                midIndex = (startIndex + endIndex) / 2
            }
            key > numbers[midIndex] -> {
                startIndex = midIndex+1
                midIndex = (startIndex + endIndex) / 2
            }
        }
    return -1

}
