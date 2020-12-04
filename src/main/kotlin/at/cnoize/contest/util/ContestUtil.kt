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
    require (this.size == 2) { "List is not of length 2!" }
    return Pair(this[1], this[2])
}
