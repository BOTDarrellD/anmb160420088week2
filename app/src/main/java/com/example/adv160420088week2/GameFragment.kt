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
import kotlin.random.Random


/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null) {
            val playerName =
                GameFragmentArgs.fromBundle(requireArguments()).playerName
            val txtTurn = view.findViewById<TextView>(R.id.txtTurn)
            txtTurn.text = "$playerName's Turn"
        }

        val btnAnswer = view.findViewById<Button>(R.id.btnAnswer)
        btnAnswer.setOnClickListener {
            val txtAnswer =view.findViewById<TextInputEditText>(R.id.txtAnswer)
            val playerAnswer =txtAnswer.text.toString()
            val action = GameFragmentDirections.actionResultFragment(playerAnswer)
            Navigation.findNavController(it).navigate(action)
        }

        val btnBack = view.findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            val action = GameFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}