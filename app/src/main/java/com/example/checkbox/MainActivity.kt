package com.example.checkbox

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.checkbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn : Button = findViewById(R.id.btnChoose)
        val tvChos : TextView = findViewById(R.id.tvChoose)

        btn.setOnClickListener {
            val result = StringBuilder()
            if (binding.cbCar.isChecked) {
                tvChos.text = binding.cbCar.text
            } else if (binding.cbBus.isChecked) {
                tvChos.text = binding.cbBus.text
            } else {
                tvChos.text = binding.cbTraktor.text
            }
        }
    }
}