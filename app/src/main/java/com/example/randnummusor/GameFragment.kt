package com.example.randnummusor

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.randnummusor.databinding.FragmentGameBinding


class GameFragment : Fragment() {
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    companion object {
        var randomNumber = (1..100).random()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = binding.root

        Toast.makeText(getActivity(),randomNumber.toString(),Toast.LENGTH_SHORT).show()
        Log.d("GameFragment",randomNumber.toString() )

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