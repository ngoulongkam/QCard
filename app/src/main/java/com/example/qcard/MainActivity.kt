package com.example.qcard

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.qcard.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var frontAnim: AnimatorSet
    private lateinit var backAnim: AnimatorSet
    private lateinit var binding: ActivityMainBinding
    private var isFront = true

    private val listOfWordAndDescription = listOf(
        WordDescription("Abyssinian", "Coat colour: Reddish-brown with black ticking"),
        WordDescription("Balinese", "Coat colour: Dark brown, blue, chocolate, lilac"),
        WordDescription("Bengal", "Coat colour: Brown, snow, silver, blue"),
        WordDescription("Birman", "Coat colour: Seal, blue, lilac, chocolate, red, cream"),
        WordDescription("British", "Coat colour: white, black, blue, lilac, chocolate, red (single colour)")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val scale = applicationContext.resources.displayMetrics.density
        binding.cardFront.cameraDistance = 8000 * scale
        binding.cardBack.cameraDistance = 8000 * scale

        frontAnim = AnimatorInflater.loadAnimator(applicationContext, R.animator.front_animator) as AnimatorSet
        backAnim = AnimatorInflater.loadAnimator(applicationContext, R.animator.back_animator) as AnimatorSet

        binding.flipButton.setOnClickListener {
            if (isFront) flipFrontToBack()  else flipBackToFront()
        }

        binding.nextButton.setOnClickListener {
            if (!isFront) flipBackToFront()
            setNextWordAndDescription()
        }
    }

    private fun flipFrontToBack() {
        frontAnim.setTarget(binding.cardFront)
        backAnim.setTarget(binding.cardBack)
        frontAnim.start()
        backAnim.start()
        isFront = false
    }

    private fun flipBackToFront() {
        frontAnim.setTarget(binding.cardBack)
        backAnim.setTarget(binding.cardFront)
        backAnim.start()
        frontAnim.start()
        isFront = true
    }

    private fun setNextWordAndDescription() {
        val randomIndex = Random.nextInt(listOfWordAndDescription.size)
        listOfWordAndDescription[randomIndex].apply {
            binding.cardFront.text = word
            binding.cardBack.text = desc
        }
    }

    data class WordDescription(
        val word: String,
        val desc: String
    )
}