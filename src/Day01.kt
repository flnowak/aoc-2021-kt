fun main() {
    fun part1(measurements: List<Int>): UInt {
        var count: UInt = 0u

        measurements.reduce { prev, next -> if (next > prev) count+=1u; next }
        return count
    }

    fun part2(measurements: List<Int>): UInt = part1(measurements.windowed(3).map { values -> values.sum() })

    val measurements: List<Int> = day01InputToListOfIntegers(readInput("Day01"))
    println("Number of times a depth measurement increased: ${part1(measurements)}")
    println("Number of times the sum of measurements increased: ${part2(measurements)}")
}
