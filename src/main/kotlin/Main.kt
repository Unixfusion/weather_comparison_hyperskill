class City(val name: String) {
    var degrees: Int? = CityTemp.getCity(name)?.temp
        set(value) {
            field = when (value){
                in -92..57 -> value
                else -> CityTemp.getCity(name)?.temp
            }
        }
}
enum class CityTemp(
    val city: String,
    val temp: Int
) {
    DUBAI("Dubai", 30),
    HANOI("Hanoi", 20),
    MOSKOW("Moskow", 5);

    companion object {
        fun getCity(name: String) = CityTemp.values().firstOrNull { it.city == name }
    }
}

fun main(args: Array<String>) {
        val first = readLine()!!.toInt()
        val second = readLine()!!.toInt()
        val third = readLine()!!.toInt()
        val firstCity = City(CityTemp.DUBAI.city)
        firstCity.degrees = first
        val secondCity = City(CityTemp.MOSKOW.city)
        secondCity.degrees = second
        val thirdCity = City(CityTemp.HANOI.city)
        thirdCity.degrees = third

    val list = listOf(firstCity, secondCity, thirdCity).sortedBy { it.degrees }

    if (list[0].degrees == list[1].degrees ) {
        println("neither")
    } else println(list[0].name)
}
