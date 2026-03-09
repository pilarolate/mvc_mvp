package com.example.mvc_mvp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mvc_mvp.Controller.Controller
import com.example.mvc_mvp.Model.DonationModel
import com.example.mvc_mvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var controller : Controller

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Inicializamos controller en nuestro DonationModel
        controller = Controller()

        //Botón guardar donación
        binding.btnDonate.setOnClickListener {
            val amount = binding.etDonation.text.toString()
            val succes = controller.saveDonation(amount)
            if(succes){
                updateTotal()
                binding.etDonation.text?.clear()
            }
            else{
                binding.etDonation.error = "Ingrese un monto válido"
            }
        }

    }

    private fun updateTotal(){
        val total = controller.totalDonation()
        binding.tvTotal.text = "Total donado: $total"
    }
}