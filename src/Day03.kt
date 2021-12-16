fun main() {
    fun getBitValuesBalanceList(report: List<String>, entryLength: Int): MutableList<Int> {
        val bitValuesBalanceList: MutableList<Int> = MutableList(entryLength) { 0 }
        report.forEach { it.forEachIndexed { pos, valueOfBit -> bitValuesBalanceList[pos] += 2 * valueOfBit.digitToInt() - 1 } }
        return bitValuesBalanceList
    }

    fun calcGammaRateBinary(bitValuesBalanceList: MutableList<Int>): String = bitValuesBalanceList.map { if (it >= 0) 1 else 0 }.joinToString("")

    fun part1(report: List<String>, entryLength: Int): UInt {
        val gammaRateBinary = calcGammaRateBinary(getBitValuesBalanceList(report, entryLength))

        val epsilonRateBinary = gammaRateBinary.toMutableList().map { if (it == '1') '0' else '1' }.joinToString("")
        return day03ConvertBinaryToDecimal(gammaRateBinary) * day03ConvertBinaryToDecimal(epsilonRateBinary)
    }

    fun part2(report: List<String>, entryLength: Int): UInt {
        var mostCommonBitValues = getBitValuesBalanceList(report, entryLength).map { if (it >= 0) 1 else 0 }.joinToString("")
        var leastCommonBitValues = getBitValuesBalanceList(report, entryLength).map { if (it >= 0) 0 else 1 }.joinToString("")

        var ox = report.toMutableList()
        for (pos in 0 until entryLength) {
            ox = ox.filter { it[pos] == mostCommonBitValues[pos] }.toMutableList()
            if (1 >= ox.size) {
                break
            }
            mostCommonBitValues = getBitValuesBalanceList(ox, entryLength).map { if (it >= 0) 1 else 0 }.joinToString("")
        }

        var co = report.toMutableList()
        for (pos in 0 until entryLength) {
            co = co.filter { it[pos] == leastCommonBitValues[pos] }.toMutableList()
            if (1 >= co.size) {
                break
            }
            leastCommonBitValues = getBitValuesBalanceList(co, entryLength).map { if (it >= 0) 0 else 1 }.joinToString("")
        }
        return day03ConvertBinaryToDecimal(ox[0]) * day03ConvertBinaryToDecimal(co[0])
    }


    val report: List<String> = readInput("Day03")

    println(part1(report, report[0].length))
    println(part2(report, report[0].length))
}