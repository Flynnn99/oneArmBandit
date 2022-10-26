package com.example.onearmbandit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.ImageButton

const val SPIN_MESSAGE = "Spins"
const val WIN_MESSAGE = "Wins"
const val WIN_LOSS_AVG_MESSAGE = "Averages"
private const val TAG = "OneArmBandit"

class MainActivity : AppCompatActivity()
{
    private var numOfSpins = 0
    private var numOfWins = 0
    private var averageWinPercent = 0.0



    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG,"Spin to Play")

        val spinButton: ImageButton = findViewById(R.id.imageButton6)
        val helpButton: ImageButton = findViewById(R.id.imageButton3)
        val statsButton: ImageButton = findViewById(R.id.imageButton5)



        spinButton.setOnClickListener{ randomImages() }

        helpButton.setOnClickListener {
            val intent = Intent(this, Help::class.java).apply{}
            startActivity(intent) }

        val numOfWinsMessage = numOfWins.toString()
        val numOfSpinsMessage = numOfSpins.toString()
        val numOfWinsLossesMessage = averageWinPercent.toString()

//      randomImages()

        statsButton.setOnClickListener {
            val intent2 = Intent(this, Stats::class.java).apply{
                putExtra(WIN_MESSAGE, numOfWins)
                putExtra(SPIN_MESSAGE, numOfSpins)
                putExtra(WIN_LOSS_AVG_MESSAGE, averageWinPercent)
            }
            startActivity(intent2)

        }



    }

    private fun randomImages()
    {
        val spins = OneArmBandit(4)


        val spinImage: ImageView = findViewById(R.id.imageView)
        val spinImage2: ImageView = findViewById(R.id.imageView2)
        val spinImage3: ImageView = findViewById(R.id.imageView3)


        val rsImage: ImageView = findViewById(R.id.imageView4)


        val drawableResource = when (spins.spin())
        {
            1 -> R.drawable.viking
            2 -> R.drawable.ninja
            3 -> R.drawable.samurai
            else -> R.drawable.bandit
        }

        val drawableResource2 = when (spins.spin())
        {
            1 -> R.drawable.viking
            2 -> R.drawable.ninja
            3 -> R.drawable.samurai
            else -> R.drawable.bandit
        }

        val drawableResource3 = when (spins.spin() )
        {
            1 -> R.drawable.viking
            2 -> R.drawable.ninja
            3 -> R.drawable.samurai
            else -> R.drawable.bandit
        }


        spinImage.setImageResource(drawableResource)
        spinImage2.setImageResource(drawableResource2)
        spinImage3.setImageResource(drawableResource3)

        if(drawableResource == drawableResource2 && drawableResource2 == drawableResource3)
        {
            rsImage.setImageResource(R.drawable.winner2)
            numOfWins++

        }
        else
        {
            rsImage.setImageResource(R.drawable.loser2)

        }
        numOfSpins ++
        averageWinPercent = (numOfWins.toDouble() / numOfSpins)



        Log.d("Num of Wins", "${numOfWins}")
        Log.d("Num of Spins", "${numOfSpins}")


        Log.d("Num of Spins", "${averageWinPercent}")
    }

    class OneArmBandit(private val numSides: Int)
    {

        fun spin(): Int {
            return (1..numSides).random()

        }
    }

    /*fun helpbutton()
    {
        val intent = Intent(this, Help::class.java).apply{}
        startActivity(intent)
    }*/


}