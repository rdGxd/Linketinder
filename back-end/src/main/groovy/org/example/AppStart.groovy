package org.example

import org.example.utils.OptionInputHandler


class AppStart {

    static void iniciar() {
        def optionInputHandler = new OptionInputHandler()

        while (true) {
            if (!optionInputHandler.getOption()) {
                println "Saindo..."
                break
            }
        }
    }
}
