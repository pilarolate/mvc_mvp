package com.example.mvc_mvp.Model

class DonationModel {
    //Inicializar las variables
    private var totalAmount : Int = 0
    init {
        this.totalAmount = 0
    }

    //Función para guardar donaciones
    fun saveDonation(donation : String) : Boolean{
        val amount = donation.toIntOrNull()
        if(amount!=null && amount>0){
            totalAmount += amount
            return true
        }
        return false
    }

    //Función para obtener el total de las donaciones
    fun getDonationAmount() : Int{
        return totalAmount
    }

    //Parte 2: En MVP se mantiene la estructura
    fun checkAmount() : String{
        if(totalAmount >= 2000 && totalAmount <= 5000){
            return "#F31A1A"
        }
        if(totalAmount >= 5000 && totalAmount <= 10000){
            return "#FFFB33"
        }
        return "#58FF11"
    }
}