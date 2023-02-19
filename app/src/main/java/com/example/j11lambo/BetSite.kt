package com.example.j11lambo

import android.util.Log

class BetSite(val name: String = "laser247.com") {
    val sites = arrayOf<String>(
        "jack9",
        "lotusbook247.bet",
        "lotusbook247.co",
        "lotusbook.io",
        "laser247.com",
        "betbhai",
        "lotus365.com",
        "corbet247",
    )
    fun url():String{
        when(name){
            "jack9" -> {
                return "https://jack9.io"
            }
            "lotusbook247.bet" -> {
                return "https://lotusbook247.bet"
            }
            "lotusbook247.co" -> {
                return "https://lotusbook247.co"
            }
            "lotusbook.io" -> {
                return "https://lotusbook.io"
            }
            "laser247.com" -> {
                return "https://laser247.com"
            }
            "betbhai" -> {
                return "https://betbhai.com"
            }
            "lotus365.com" -> {
                return "https://www.lotus365.com"
            }
            "lotusbook247.games" -> {
                return "https://www.lotusbook247.games"
            }
            "corbet247" -> {
                return "https://corbet247.com/"
            }
            else -> {
                return "https://jack9.io"
            }
        }
    }
    fun openBetScript(backlay: String, betIndex: Int): String {
        when(name){
            "jack9" -> {
                return "document.querySelectorAll(\".odd-button.$backlay-color\")[$betIndex].click();"
            }
            "lotusbook.io" -> {
                var bl = 0
                if (backlay == "back"){
                    bl = 2
                }
                return "document.querySelectorAll(\"bet-panel\")[$betIndex].querySelectorAll(\"bet-button .$backlay\")[$bl].click();"
            }
            "laser247.com" -> {
                var bl = 0
                if (backlay == "back"){
                    bl = 2
                }
                return "document.querySelectorAll(\".odds_body\")[$betIndex].querySelectorAll(\"button.$backlay\")[$bl].click()"
            }
            "betbhai" -> {
                return "document.querySelectorAll(\".$backlay-odd.exch-odd-button\")[$betIndex].click();"
            }
            "lotus365.com" -> {
                var bl = 1
                if (backlay == "back"){
                    bl = 0
                }
                return "document.querySelectorAll(\".SportEvent__market\")[$betIndex].querySelectorAll(\".odd-button\")[$bl].click();"
            } //v1.2
            "lotusbook247.games" -> {
                var bl = 3
                if (backlay == "back"){
                    bl = 2
                }
                return "document.querySelectorAll(\"bet-panel\")[$betIndex].querySelectorAll(\".bet-button\")[$bl].click(); "
            } //v1.2
            else -> {
                return "document.querySelectorAll(\".odd-button.$backlay-color\")[$betIndex].click();"
            }
        }
    }
    fun placeBetScript(betIndex: Int, stake: Double, odds: Double = 0.0): String {
        when(name){
            "jack9" -> {
                return "var input = document.querySelector(\"ion-input.BetPlacing__input\");\n" +
                        "input.value = $stake;"
            }
            "laser247.com" -> {
                var setodds = ""
                if (odds != 0.0) {
                    setodds = "\nnativeInputValueSetter.call(inputOdds, '$odds');\n" +
                            "inputOdds.dispatchEvent(ev1);\n" +
                            "inputOdds.dispatchEvent(ev2);"
                }
                return "var input = document.querySelectorAll(\"app-bet-slip input\")[2];\n" +
                        "var inputOdds = document.querySelectorAll(\"app-bet-slip input\")[0];\n" +

                        "var nativeInputValueSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, \"value\").set;\n" +
                        "var ev1 = new Event('input', { bubbles: true});\n" +
                        "var ev2 = new Event('change', { bubbles: true});\n" +

                        "nativeInputValueSetter.call(input, '$stake');\n" +
                        "input.dispatchEvent(ev1);\n" +
                        "input.dispatchEvent(ev2);" +
                        setodds
            }
            "betbhai" -> {
                var setodds = ""
                if (odds != 0.0) {
                    setodds = "\nnativeInputValueSetter.call(inputOdds, '$odds');\n" +
                            "inputOdds.dispatchEvent(ev1);\n" +
                            "inputOdds.dispatchEvent(ev2);"
                }
                return "var input = document.querySelector(\".odds-ctn input\");\n" +
                        "var inputOdds = document.querySelector(\".stake-ctn input\");\n" +

                        "var nativeInputValueSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, \"value\").set;\n" +
                        "var ev1 = new Event('input', { bubbles: true});\n" +
                        "var ev2 = new Event('change', { bubbles: true});\n" +

                        "nativeInputValueSetter.call(input, '$stake');\n" +
                        "input.dispatchEvent(ev1);\n" +
                        "input.dispatchEvent(ev2);" +
                        setodds
            }
            "lotus365.com" -> {
                var setodds = ""
                if (odds != 0.0) {
                    setodds = "inputElements[0].value = $odds;\n" +
                            "inputElements[0].dispatchEvent(new Event('input', { bubbles: true}));\n" +
                            "inputElements[0].dispatchEvent(new Event('change', { bubbles: true}));"
                }
                return "var betRows = document.querySelectorAll(\".SportEvent__market\");\n" +
                        "var inputElements = betRows[$betIndex].querySelectorAll(\"ion-input input\");\n" +
                        "inputElements[0].value = $stake;\n" +
                        "inputElements[0].dispatchEvent(new Event('input', { bubbles: true}));\n" +
                        "inputElements[0].dispatchEvent(new Event('change', { bubbles: true}));\n" +
                        setodds
            } //v1.2
            "lotusbook247.games" -> {
                var setodds = ""
                if (odds != 0.0) {
                    setodds = "\nnativeInputValueSetter.call(inputOdds, '$odds');\n" +
                            "inputOdds.dispatchEvent(ev1);\n" +
                            "inputOdds.dispatchEvent(ev2);"
                }
                return "var betRows = document.querySelectorAll('bet-panel');" +
                        "var input = betRows[$betIndex].querySelectorAll('ion-input input')[1];\n" +
                        "var inputOdds = betRows[$betIndex].querySelectorAll('ion-input input')[0];\n" +

                        "var nativeInputValueSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, \"value\").set;\n" +
                        "var ev1 = new Event('input', { bubbles: true});\n" +
                        "var ev2 = new Event('change', { bubbles: true});\n" +

                        "nativeInputValueSetter.call(input, '$stake');\n" +
                        "input.dispatchEvent(ev1);\n" +
                        "input.dispatchEvent(ev2);" +
                        setodds
            } //v1.2
            else -> {
                return "var input = document.querySelector(\"ion-input.BetPlacing__input\");\n" +
                        "input.value = $stake;"
            }
        }
    }
    fun comfirmBetScript(betIndex: Int): String {
        when(name){
            "jack9" -> {
                return "document.querySelector(\"button[type='submit']\").click();"
            }
            "lotusbook.io" -> {
                return "document.querySelector(\".confirmation-buttons\")[1].click();"
            }
            "laser247.com" -> {
                return "document.querySelector(\"app-bet-slip button.btn-betplace\").click();"
            }
            "betbhai" -> {
                return "document.querySelector(\".place-btn\").click();"
            }
            "lotus365.com" -> {
                return "var betRows = document.querySelectorAll(\".SportEvent__market\");"+
                        "betRows[$betIndex].querySelector(\".BetPlacing__btn--place\").click();"
            } //v1.2
            "lotusbook247.games" -> {
                return "document.querySelectorAll('bet-panel')[$betIndex].querySelectorAll('.confirmation-buttons')[1].click();"
            } //v1.2
            "corbet247" -> {
                return "var betslip_buttons = 'tr .exch-betslip-ctn .place-btn';\n" +
                        "var confirm_button = 0;\n" +
                        "document.querySelectorAll(betslip_buttons)[confirm_button].click();"
            }
            else -> {
                return "document.querySelector(\"button[type='submit']\").click();"
            }
        }
    }
}