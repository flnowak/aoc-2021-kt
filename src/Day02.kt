fun main() {
    fun part1(commands: List<String>, position: MutableList<Long>): Long {
        for (command in commands) {
            val (dir, x) = command.split(" ")
            val dist = x.toLong()
            when (dir) {
                "forward" -> position[0] += dist
                "down" -> position[1] += dist
                "up" -> position[1] -= dist
            }
        }

        return position[0] * position[1]
    }

    fun part2(commands: List<String>, position: MutableList<Long>): Long {
        for (command in commands) {
            val (dir, x) = command.split(" ")
            val value = x.toLong()
            when (dir) {
                "forward" -> {
                    position[0] += value
                    position[1] += position[2] * value
                }
                "down" -> position[2] += value
                "up" -> position[2] -= value
            }
        }

        return position[0] * position[1]
    }


    val commands: List<String> = readInput("Day02")

    println(part1(commands, mutableListOf<Long>(0L, 0L)))
    println(part2(commands, mutableListOf<Long>(0L, 0L, 0L)))
}