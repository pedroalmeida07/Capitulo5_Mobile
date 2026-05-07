package com.example.capitulo5

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.capitulo5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initListeners()
    }
    private fun initListeners(){
        binding.btnPrimeiraTela.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("user", User("Pedro de Souza", 18))

            startActivity(intent)
        }
    }
}