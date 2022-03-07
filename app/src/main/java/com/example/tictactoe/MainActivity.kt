package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClick(view:View){
        val selectedButton = view as Button
        var buttonId = 0

        when(selectedButton.id){
            R.id.button -> buttonId = 1
            R.id.button2 -> buttonId = 2
            R.id.button3 -> buttonId = 3
            R.id.button4 -> buttonId = 4
            R.id.button5 -> buttonId = 5
            R.id.button6 -> buttonId = 6
            R.id.button7 -> buttonId = 7
            R.id.button8 -> buttonId = 8
            R.id.button9 -> buttonId = 9
            R.id.restartButton -> playAgain()
        }
        if (buttonId != 0) {
            playGame(buttonId, selectedButton)
        }
    }

    var playerOne = ArrayList<Int>()
    var playerTwo = ArrayList<Int>()
    var activePlayer = 1

    private fun playGame(buttonId:Int, selectedButton: Button){
        if (playerOne.isEmpty()){
            activePlayer = 1
        }
        if(activePlayer == 1){
            selectedButton.text = "X"
            playerOne.add(buttonId)
            activePlayer = 2
        } else {
            selectedButton.text = "O"
            playerTwo.add(buttonId)
            activePlayer = 1
        }

        selectedButton.isEnabled = false
        checkWinner()
    }



}