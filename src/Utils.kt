import java.io.File
import java.math.BigInteger
import java.security.MessageDigest
import kotlin.math.pow

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String): List<String> = File("src", "$name.txt").readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)

/**
 * For Day01.kt
 */
fun day01InputToListOfIntegers(strings: List<String>): List<Int> = strings.map { str -> str.trim().toInt() }

/**
 * For Day03.kt
 */
fun day03ConvertBinaryToDecimal(binaryRepresentation: String): UInt {
    var number = 0u
    binaryRepresentation.forEachIndexed { pos, valueOfBit -> number += Character.getNumericValue(valueOfBit).toUInt() * 2.0.pow(binaryRepresentation.lastIndex - pos).toUInt() }
    return number
}