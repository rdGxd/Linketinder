package org.example.utils

class InputHandler {
    Scanner scanner = new Scanner(System.in)

    String getInput(String prompt) {
        println prompt
        return scanner.nextLine()
    }
}