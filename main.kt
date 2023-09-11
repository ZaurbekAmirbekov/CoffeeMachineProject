package machine

import kotlin.system.exitProcess

val coffeeMachineHas = mutableListOf(400, 540, 120, 9, 550)
val espresso = mutableListOf(250, 0, 16, 4)
val latte = mutableListOf(350, 75, 20, 7)
val cappuccino = mutableListOf(200, 100, 12, 6)

fun main() {
    while (true) {
        println("Write action (buy, fill, take, remaining, exit):")
        val input1 = readLine()
        when (input1) {
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> remaining()
            "exit" -> exit()
        }
    }
}

fun buy() {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
    val input2 = readLine()
    when (input2) {
        "1" -> {
            if (coffeeMachineHas[0] < espresso[0] || coffeeMachineHas[2] < espresso[2] || coffeeMachineHas[3] < 1) {
                if (coffeeMachineHas[0] < espresso[0]) println("Sorry, not enough water!")
                if (coffeeMachineHas[2] < espresso[2]) println("Sorry, not enough coffee beans!")
                if (coffeeMachineHas[3] < 1) println("Sorry, not enough disposable cups!")
            } else {
                println("I have enough resources, making your coffee!")
                coffeeMachineHas[0] -= espresso[0]
                coffeeMachineHas[2] -= espresso[2]
                coffeeMachineHas[3]--
                coffeeMachineHas[4] += espresso[3]
            }
        }

        "2" -> {
            if (coffeeMachineHas[0] < latte[0] || coffeeMachineHas[1] < latte[1] || coffeeMachineHas[2] < latte[2] || coffeeMachineHas[3] < 1) {
                if (coffeeMachineHas[0] < latte[0]) println("Sorry, not enough water!")
                if (coffeeMachineHas[1] < latte[1]) println("Sorry, not enough milk!")
                if (coffeeMachineHas[2] < latte[2]) println("Sorry, not enough coffee beans!")
                if (coffeeMachineHas[3] < 1) println("Sorry, not enough disposable cups!")
            } else {
                println("I have enough resources, making your coffee!")
                coffeeMachineHas[0] -= latte[0]
                coffeeMachineHas[1] -= latte[1]
                coffeeMachineHas[2] -= latte[2]
                coffeeMachineHas[3]--
                coffeeMachineHas[4] += latte[3]
            }
        }

        "3" -> {
            if (coffeeMachineHas[0] < cappuccino[0] || coffeeMachineHas[1] < cappuccino[1] || coffeeMachineHas[2] < cappuccino[2] || coffeeMachineHas[3] < 1) {
                if (coffeeMachineHas[0] < cappuccino[0]) println("Sorry, not enough water!")
                if (coffeeMachineHas[1] < cappuccino[1]) println("Sorry, not enough milk!")
                if (coffeeMachineHas[2] < cappuccino[2]) println("Sorry, not enough coffee beans!")
                if (coffeeMachineHas[3] < 1) println("Sorry, not enough disposable cups!")
            } else {
                println("I have enough resources, making your coffee!")
                coffeeMachineHas[0] -= cappuccino[0]
                coffeeMachineHas[1] -= cappuccino[1]
                coffeeMachineHas[2] -= cappuccino[2]
                coffeeMachineHas[3]--
                coffeeMachineHas[4] += cappuccino[3]
            }
        }

        "back" -> return
    }
}

fun fill() {
    println("Write how many ml of water you want to add (or 'back' to return to the main menu):")
    val h1 = readLine()
    if (h1 == "back") return
    if (h1 == "exit") exit()

    println("Write how many ml of milk you want to add (or 'back' to return to the main menu):")
    val h2 = readLine()
    if (h2 == "back") return
    if (h2 == "exit") exit()

    println("Write how many grams of coffee beans you want to add (or 'back' to return to the main menu):")
    val h3 = readLine()
    if (h3 == "back") return
    if (h3 == "exit") exit()

    println("Write how many disposable cups you want to add (or 'back' to return to the main menu):")
    val h4 = readLine()
    if (h4 == "back") return
    if (h4 == "exit") exit()

    coffeeMachineHas[0] += h1!!.toInt()
    coffeeMachineHas[1] += h2!!.toInt()
    coffeeMachineHas[2] += h3!!.toInt()
    coffeeMachineHas[3] += h4!!.toInt()
}

fun take() {
    println("I gave you $${coffeeMachineHas[4]}")
    coffeeMachineHas[4] = 0
}

fun remaining() {
    println("The coffee machine has:")
    println("${coffeeMachineHas[0]} ml of water")
    println("${coffeeMachineHas[1]} ml of milk")
    println("${coffeeMachineHas[2]} g of coffee beans")
    println("${coffeeMachineHas[3]} disposable cups")
    println("$${coffeeMachineHas[4]} of money")
}

fun exit() {
    exitProcess(0)
}
