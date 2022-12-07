package com.example.j11lambo

class BetSite(val name: String) {
    fun url():String{
        when(name){
            "jack9" -> {
                return "https://jack9.io"
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
            else -> {
                return "document.querySelectorAll(\".odd-button.$backlay-color\")[$betIndex].click();"
            }
        }
    }
    fun placeBetScript(stake: Double): String {
        when(name){
            "jack9" -> {
                return "var input = document.querySelector(\"ion-input.BetPlacing__input\");\n" +
                        "input.value = $stake;"
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
            else -> {
                return "document.querySelector(\"button[type='submit']\").click();"
            }
        }
    }
}