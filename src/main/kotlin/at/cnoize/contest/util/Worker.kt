package at.cnoize.contest.util

fun interface Worker {
    fun work(input: List<String>): String

    fun withInputFile(inputFile: String) {
        println(
            inputFile.asResource { wholeInput ->
                work(
                    wholeInput
                        .split('\n')
                        .filterNot(String::isBlank)
                )
            }
        )
    }
}
