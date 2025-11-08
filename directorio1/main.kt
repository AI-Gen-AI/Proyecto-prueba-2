fun main() {
    println("Calculadora simple (introduce 'salir' para terminar)")

    while (true) {
        println("\nElige una operación:")
        println("1) Sumar")
        println("2) Restar")
        println("3) Multiplicar")
        println("4) Dividir")
        println("5) Potencia (a^b)")
        print("Opción: ")

        val option = readLine()?.trim() ?: break
        if (option.equals("salir", ignoreCase = true)) break

        val op = option.toIntOrNull()
        if (op == null || op !in 1..5) {
            println("Opción no válida.")
            continue
        }

        val a = readNumber("Ingrese el primer número (o 'salir'):") ?: break
        val b = readNumber("Ingrese el segundo número (o 'salir'):") ?: break

        val result = when (op) {
            1 -> a + b
            2 -> a - b
            3 -> a * b
            4 -> {
                if (b == 0.0) {
                    println("Error: división por cero.")
                    continue
                } else a / b
            }
            5 -> Math.pow(a, b)
            else -> {
                println("Operación desconocida.")
                continue
            }
        }

        println("Resultado: $result")
    }

    println("Saliendo. ¡Hasta luego!")
}

fun readNumber(prompt: String): Double? {
    while (true) {
        print("$prompt ")
        val line = readLine() ?: return null
        if (line.trim().equals("salir", ignoreCase = true)) return null
        val num = line.toDoubleOrNull()
        if (num == null) {
            println("Número no válido. Intenta de nuevo.")
            continue
        }
        return num
    }
}