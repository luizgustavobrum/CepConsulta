package com.app.cepconsulta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.app.cepconsulta.data.CepService.cepServiceInterfaceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnVerificar = findViewById<Button>(R.id.btn_verificar)
        btnVerificar.setOnClickListener {
            lifecycleScope.launch {
                try {
                    val response = withContext(Dispatchers.IO) {
                        cepServiceInterfaceImpl.cepInformation("22745056")
                    }

                    if (response.isSuccessful && response.body() != null) {
                        Toast.makeText(
                            this@MainActivity,
                            response.body().toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Log.e(TAG, "Response null")
                    }

                } catch (e: Exception) {
                    Log.e(TAG, e.toString())

                }
            }
        }
    }
}