package com.example.capitulo5

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.capitulo5.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: androidx.appcompat.widget.Toolbar = binding.toolbar
        toolbar.title = "Tela 2 - Olá Dev!"
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        getExtra()
    }

    fun getExtra(){
        val user: User? = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            intent.getSerializableExtra("user", User::class.java)
        } else{
            intent.getSerializableExtra("user") as? User
        }

        user?.let{
            Log.i("INFOTESTE", "getExtra: $(it.name)")
            Log.i("INFOTESTE", "getExtra: $(it.age)")
        } ?: Log.e("INFOTESTE", "Usuário não encontrado")
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}