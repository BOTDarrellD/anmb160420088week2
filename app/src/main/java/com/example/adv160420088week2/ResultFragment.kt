package com.example.adv160420088week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText

class ResultFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnReturns= view.findViewById<Button>(R.id.btnReturns)
        btnReturns.setOnClickListener {
            val action = ResultFragmentDirections.actionMainFragment2()
            Navigation.findNavController(it).navigate(action)
        }

        if(arguments != null) {
            val playerAnswer =
                ResultFragmentArgs.fromBundle(requireArguments()).playerAnswer
            val txtScore = view.findViewById<TextView>(R.id.txtScore)
            txtScore.text = "Your Score is $playerAnswer"
        }
    }
}