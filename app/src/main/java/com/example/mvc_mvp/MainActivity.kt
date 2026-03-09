package com.example.mvc_mvp

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mvc_mvp.Controller.Controller
import com.example.mvc_mvp.Model.DonationModel
import com.example.mvc_mvp.Presenter.DonationPresenter
import com.example.mvc_mvp.Presenter.IviewPresenter
import com.example.mvc_mvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), IviewPresenter {

    private lateinit var binding: ActivityMainBinding
    //Primera parte, luego se comenta
    //private lateinit var controller : Controller

    //Parte 2: MVP
    private lateinit var presenter: DonationPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Inicializamos controller en nuestro DonationModel
        //controller = Controller()

        //Botón guardar donación
        //binding.btnDonate.setOnClickListener {
        /*   val amount = binding.etDonation.text.toString()
            val succes = controller.saveDonation(amount)
            if(succes){
                updateTotal()
                binding.etDonation.text?.clear()
            }
            else{
                binding.etDonation.error = "Ingrese un monto válido"
            }
        */

        //Parte 2: MVP
        presenter = DonationPresenter(this)

        //Activar el botón
        binding.btnDonate.setOnClickListener { makeDonation() }

    }

    /*private fun updateTotal(){
        val total = controller.totalDonation()
        binding.tvTotal.text = "Total donado: $total"
    }
    */

    private fun makeDonation(){
        val donationText = binding.etDonation.text.toString()
        if(donationText.isNotEmpty()){
            presenter.saveDonation(donationText)
            binding.etDonation.setText("")
            presenter.totalDonation()
            presenter.checkTotal()
        }
        else{
            displayErrorMessage()
        }

    }

    override fun updateTotalDonation(totalAmount: Int) {
        //Buscamos el string para setear con los valores
        val total = getString(R.string.total_donaciones, totalAmount.toString())
        binding.tvTotal.text = total
    }

    override fun displayConfirmationMessage() {
        val toast = Toast.makeText(applicationContext, "Donación exitosa", Toast.LENGTH_LONG)
        toast.show()
    }

    override fun displayErrorMessage() {
        val toast = Toast.makeText(applicationContext, "Donación fallida", Toast.LENGTH_LONG)
        toast.show()
    }

    override fun displayColorAlert(color: String) {
        binding.textView2.setBackgroundColor(Color.parseColor(color))
    }

}
