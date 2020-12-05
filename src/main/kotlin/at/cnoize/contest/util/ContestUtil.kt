package at.cnoize.contest.util

fun <RETURN_TYPE> String.asResource(work: (String) -> RETURN_TYPE): RETURN_TYPE {
    return Thread.currentThread().contextClassLoader
        .getResource(this)
        ?.readText()
        ?.let { work(it) }
        ?: throw IllegalArgumentException("Resource not found: $this")
}

fun Int.zeroPad(length: Int): String = this.toString().padStart(length, '0')

fun <T> List<T>.toPair(): Pair<T, T> {
    require(this.size == 2) { "List is not of length 2!" }
    return Pair(this[1], this[2])
}

fun <T> List<T>.minAndMax(): Pair<T, T> where T : Comparable<T> {
    require(this.isNotEmpty()) { "List is empty" }
    return Pair(
        this.minOrNull() ?: throw IllegalArgumentException("No minimum found"),
        this.maxOrNull() ?: throw IllegalArgumentException("No maximum found")
    )
}

fun Pair<Int, Int>.toRange(): IntRange {
    return this.first..this.second
}
