package com.app.cepconsulta.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.app.cepconsulta.databinding.ActivityMainBinding
import com.app.cepconsulta.repository.CepRepositoryImpl

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(CepRepositoryImpl()) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnVerificar.setOnClickListener {
            val cepText = binding.EdtCep.text.toString()
            mainViewModel.getCepInformation(cepText)
        }

        mainViewModel.uiCepState.asLiveData().observe(this, { cepState ->
            when (cepState) {
                is UiCepState.Success -> {
                    Toast.makeText(this, cepState.success.toString(), Toast.LENGTH_SHORT).show()
                }
                is UiCepState.Error -> {
                    Toast.makeText(this, cepState.error, Toast.LENGTH_SHORT).show()
                }
                is UiCepState.Loading -> {

                }
                is UiCepState.Inital -> Unit
            }
        })
    }
}