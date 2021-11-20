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
    private val revisionContent: RevisionContent = RevisionContent()
    private var isFront = false

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
        val randomIndex = Random.nextInt(revisionContent.listOfLegislationContent.size)
        revisionContent.listOfLegislationContent[randomIndex].apply {
            binding.cardFront.text = word
            binding.cardBack.text = desc
        }
    }
}