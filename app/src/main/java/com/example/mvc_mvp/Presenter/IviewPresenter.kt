package com.example.mvc_mvp.Presenter

interface IviewPresenter {

    //Actualizar el monto en el texto de la vista
    fun updateTotalDonation(totalAmount : Int)

    //Mostrar mensaje de confirmación
    fun displayConfirmationMessage()

    //Mostrar error
    fun displayErrorMessage()

    //Mostrar un color
    fun displayColorAlert(color : String)

}