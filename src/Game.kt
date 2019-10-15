import kotlin.random.Random

fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false
    var inebriation = 1
    val numFireballs: Int = Random.nextInt(1, 50)

    // Aura
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = auraColor(auraVisible)

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    inebriation *= numFireballs
    castFireball(numFireballs)
    performCombat()
    performCombat("Ulv")
    performCombat("Sabrina", true)

    //player status
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)
    println("Inebriation Level: ${determineInebriationLevel(inebriation)}")

}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println(
        "(Aura: $auraColor) " +
                "(Blessed: ${if (isBlessed) "YES" else "NO"})"
    )
    println("$name $healthStatus")
}

private fun auraColor(auraVisible: Boolean): String = if (auraVisible) "GREEN" else "NONE"

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String {
    return when (healthPoints) {
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
}

private fun determineInebriationLevel(inebriation: Int): String {
    return when (inebriation) {
        in 1..10 -> "tipsy"
        in 11..20 -> "sloshed"
        in 21..30 -> "soused"
        in 31..40 -> "stewed"
        in 41..50 -> "..toaSt3d"
        else -> "I'm not drunk"
    }
}

private fun castFireball(numFireballs: Int) {
    println("A glass of Fireball springs into existence. (x$numFireballs)")
}

fun performCombat() {
    println("You see nothing to fight!")
}
fun performCombat(enemyName: String) {
    println("You begin fighting $enemyName")
}

fun performCombat(enemyName: String, isBlessed: Boolean) {
    if (isBlessed) {
        println("You begin fighting $enemyName. You are blessed with 2X damage!")
    } else {
        println("You begin fighting $enemyName.")
    }
}


