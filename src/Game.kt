import kotlin.random.Random

fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = Random.nextInt(0,100)
    val isBlessed = Random.nextBoolean()
    val isImmortal = Random.nextBoolean()

    // Aura
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20).toInt()

    val healthStatus = when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..99 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }

    val auraColor = when (karma) {
        in 0..5 -> "red"
        in 6..10 -> "orange"
        in 11..15 -> "purple"
        in 16..20 -> "green"
        else -> "no aura"
    }

    //player status
    println(
        (if (auraVisible) "(Aura: $auraColor) " else "") +
            "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}