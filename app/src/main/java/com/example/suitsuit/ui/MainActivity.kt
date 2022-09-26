package com.example.suitsuit.ui

import Callback
import Controller
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.example.suitsuit.R
import com.example.suitsuit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Callback {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val controller = Controller(this)

        val pemain1 = arrayListOf(
            binding.btn1,
            binding.btn2,
            binding.btn3
        )

        val com = arrayListOf(
            binding.btn4,
            binding.btn5,
            binding.btn6
        )

        pemain1.forEach { imageView ->
            imageView.setOnClickListener {
                Log.d("Click", "Clink Button Pilihan")
                imageView.selected()
                val computer = com.random()
                controller.adu(
                    imageView.contentDescription.toString(),
                    computer.contentDescription.toString(),
                )
                computer.selected()
            }
        }

        binding.btn7.setOnClickListener {
            Log.d("Click", "Click Button Reset")
            pemain1.forEach { imageView -> imageView.unselected() }
            com.forEach { imageView -> imageView.unselected() }
            binding.vs.text = "VS"
            binding.vs.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
            binding.vs.textSize = 80F
            binding.vs.setTextColor(ContextCompat.getColor(this, R.color.red))
        }

    }

    private fun ImageView.selected() {
        background = ContextCompat.getDrawable(this@MainActivity, R.drawable.bg_rounded)
    }

    private fun ImageView.unselected() {
        background = ContextCompat.getDrawable(this@MainActivity, R.drawable.bg_rounded_white)
    }

    override fun tampilanHasil(hasil: String) {
        binding.vs.text = hasil
        binding.vs.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
        binding.vs.textSize = 25F
        binding.vs.setTextColor(ContextCompat.getColor(this, R.color.white))
    }
}

