package com.example.mvc_mvp.Presenter

import com.example.mvc_mvp.Model.DonationModel

class DonationPresenter (private val view : IviewPresenter) {

    //Comunica con el Donation Model
    private val model : DonationModel
    init {
        model = DonationModel()
    }

    fun saveDonation(donation : String){
        if(model.saveDonation(donation)){
            view.displayConfirmationMessage()
            view.updateTotalDonation(model.getDonationAmount())
        }
        else{
            view.displayErrorMessage()
        }
    }

    fun totalDonation(){
        view.updateTotalDonation(model.getDonationAmount())
    }

    fun checkTotal(){
        view.displayColorAlert(model.checkAmount())
    }

}