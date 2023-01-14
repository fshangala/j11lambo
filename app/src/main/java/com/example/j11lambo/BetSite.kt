package com.example.j11lambo

import android.util.Log

class BetSite(val name: String = "laser247.com") {
    val sites = arrayOf<String>(
        "jack9",
        "lotusbook247.bet",
        "lotusbook247.co",
        "lotusbook.io",
        "laser247.com",
        "betbhai"
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
                return "document.querySelectorAll(\"bet-panel\")[$betIndex].querySelectorAll(\"bet-button .$backlay\")[$bl]"
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
            else -> {
                return "document.querySelectorAll(\".odd-button.$backlay-color\")[$betIndex].click();"
            }
        }
    }
    fun placeBetScript(stake: Double, odds: Double = 0.0): String {
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
            else -> {
                return "var input = document.querySelector(\"ion-input.BetPlacing__input\");\n" +
                        "input.value = $stake;"
            }
        }
    }
    fun comfirmBetScript(): String {
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
            else -> {
                return "document.querySelector(\"button[type='submit']\").click();"
            }
        }
    }
}