package com.example.qcard

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.qcard.databinding.FragmentRevisionBinding
import kotlin.random.Random

class RevisionFragment : Fragment() {

    private lateinit var frontAnim: AnimatorSet
    private lateinit var backAnim: AnimatorSet
    private lateinit var binding: FragmentRevisionBinding
    private val revisionContent: RevisionContent = RevisionContent()
    private var isFront = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRevisionBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val scale = requireContext().resources.displayMetrics.density
        binding.cardFront.cameraDistance = 8000 * scale
        binding.cardBack.cameraDistance = 8000 * scale

        frontAnim = AnimatorInflater.loadAnimator(requireContext(), R.animator.front_animator) as AnimatorSet
        backAnim = AnimatorInflater.loadAnimator(requireContext(), R.animator.back_animator) as AnimatorSet

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