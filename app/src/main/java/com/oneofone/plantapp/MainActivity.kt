package com.oneofone.plantapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pl.droidsonroids.gif.GifImageView

class MainActivity : AppCompatActivity() {

    // declare
    private lateinit var gifImage: GifImageView
    private lateinit var gifRain: GifImageView
    private lateinit var gifFertilize: GifImageView
    private lateinit var gifsun: GifImageView
    private var water = 65
    private var health = 32
    private var sunlight = 87

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //initialise
        gifImage = findViewById(R.id.gifPlant)
        gifRain = findViewById(R.id.gifRain)
        gifsun = findViewById(R.id.gifsun)
        gifFertilize = findViewById(R.id.gifFertilize)

        val btnWater = findViewById<Button>(R.id.btnWater)
        val btnFertilize = findViewById<Button>(R.id.btnFertilize)
        val btnSun = findViewById<Button>(R.id.btnSun)


        btnWater.setOnClickListener {
            // set images invisible
            gifFertilize.visibility = View.INVISIBLE
            gifsun.visibility = View.INVISIBLE

            // make main gif visible
            gifRain.visibility = View.VISIBLE

            updateUI()
            waterPlant()
        }

        btnFertilize.setOnClickListener {
            // set images invisible
            gifRain.visibility = View.INVISIBLE
            gifsun.visibility = View.INVISIBLE

            // make main gif visible
            gifFertilize.visibility = View.VISIBLE

            updateUI()
            fertilizePlant()
        }

        btnSun.setOnClickListener {
            // set images invisible
            gifRain.visibility = View.INVISIBLE
            gifFertilize.visibility = View.INVISIBLE

            // make main gif visible
            gifsun.visibility = View.VISIBLE

            updateUI()
            plantInSunlight()
        }
    }

    // create function when ran will do following
    @SuppressLint("CutPasteId", "SetTextI18n")
    private fun updateUI() {

        val tvWater = findViewById<TextView>(R.id.tvWater)
        val tvHealth = findViewById<TextView>(R.id.tvHealth)
        val tvSunlight = findViewById<TextView>(R.id.tvSunlight)

        tvWater.text = "Water: $water%"
        tvHealth.text = "Health: $health%"
        tvSunlight.text = "Sunlight: $sunlight%"

    }

    // create function when ran will do following
    private fun waterPlant() {
        sunlight -= 5
        if (sunlight < 0) sunlight = 0

        water += 13
        if (water > 100) water = 100
    }

    // create function when ran will do following
    private fun fertilizePlant() {
        health += 20
        if (health > 100) health = 100

        water -= 6
        if (water < 0) water = 0

        sunlight -= 2
        if (sunlight < 0) sunlight = 0

    }

    // create function when ran will do following
    private fun plantInSunlight() {

        health -= 10
        if (health < 0) health = 0

        sunlight += 10
        if (sunlight > 100) sunlight = 100

        water -= 5
        if (water < 0) water = 0

    }
}