package com.example.mvc_mvp.Controller

import com.example.mvc_mvp.Model.DonationModel

class Controller {
    //Comunicar con el DonationModel
    private val model : DonationModel
    init {
        model = DonationModel()
    }

    //Llamar la función del model guardar
    fun saveDonation(amount : String) : Boolean{
        return model.saveDonation(amount)
    }

    //Llamar la función del model que muestra las donaciones
    fun totalDonation() : Int{
        return model.getDonationAmount()
    }
}