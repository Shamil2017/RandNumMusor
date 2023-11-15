package com.example.randnummusor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.randnummusor.databinding.FragmentGameBinding


class GameFragment : Fragment() {
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    var randomNumber = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = binding.root
        randomNumber = (1..100).random()

        binding.btnRandNumber.setOnClickListener() {
            var userNumber: Int = binding.edNumber.text.toString().toInt()
            var rez = getAnswer(userNumber)
            // Inflate the layout for this fragment
            val action = GameFragmentDirections.actionGameFragmentToResultFragment(rez)
            view.findNavController().navigate(action)
        }
        return view
    }

    fun getAnswer(x: Int):String
    {
        if (x < randomNumber)
            return "Меньше"
        if (x > randomNumber)
            return "Больше"
        return "Угадали"
    }
}