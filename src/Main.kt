import kotlin.random.Random

fun main() {
    Sorts::class.java.methods.filter { m -> m.name.matches(Regex("^[a-zA-Z0-9_]*[Ss]ort$")) }
        .forEach { testSort(it.name) { l -> it.invoke(Sorts(), l) as List<Int> } }
}

fun testSort(name: String, sort: (List<Int>) -> List<Int>) {
    val arr = (0..10000).map { Random.nextInt(1, 1000) }
    val valid = arr.sorted()

    val start = System.nanoTime()
    val sorted = sort(arr)
    val end = System.nanoTime()

    if (sorted != valid)
        println("sort '${name}' failed.")
    else
        println("sort '${name}' finished in ${(end - start) / 1e9}s")
}
