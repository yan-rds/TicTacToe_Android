package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.view.isVisible

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
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

    private fun checkWinner(){
        var winner = 3
        var isGameEnded = false
        if(
            playerOne.contains(1) && playerOne.contains(2) && playerOne.contains(3) ||
            playerOne.contains(4) && playerOne.contains(5) && playerOne.contains(6) ||
            playerOne.contains(7) && playerOne.contains(8) && playerOne.contains(9) ||
            playerOne.contains(1) && playerOne.contains(4) && playerOne.contains(7) ||
            playerOne.contains(2) && playerOne.contains(5) && playerOne.contains(8) ||
            playerOne.contains(3) && playerOne.contains(6) && playerOne.contains(9) ||
            playerOne.contains(1) && playerOne.contains(5) && playerOne.contains(9) ||
            playerOne.contains(3) && playerOne.contains(5) && playerOne.contains(7)) {
            winner = 1
            Toast.makeText(this,"X won the game!", Toast.LENGTH_LONG).show()
            isGameEnded = true
        }else if(
            playerTwo.contains(1) && playerTwo.contains(2) && playerTwo.contains(3) ||
            playerTwo.contains(4) && playerTwo.contains(5) && playerTwo.contains(6) ||
            playerTwo.contains(7) && playerTwo.contains(8) && playerTwo.contains(9) ||
            playerTwo.contains(1) && playerTwo.contains(4) && playerTwo.contains(7) ||
            playerTwo.contains(2) && playerTwo.contains(5) && playerTwo.contains(8) ||
            playerTwo.contains(3) && playerTwo.contains(6) && playerTwo.contains(9) ||
            playerTwo.contains(1) && playerTwo.contains(5) && playerTwo.contains(9) ||
            playerTwo.contains(3) && playerTwo.contains(5) && playerTwo.contains(7)) {
            winner = 2
            Toast.makeText(this,"O won the game!", Toast.LENGTH_LONG).show()
            isGameEnded = true
        }else if (playerOne.size == 5 && winner != 1){
            Toast.makeText(this, "DRAW", Toast.LENGTH_LONG).show()
            isGameEnded = true
        }

        if (isGameEnded){
            val restartButton = findViewById<Button>(R.id.restartButton)
            val buttonList = getButtonList()

            restartButton.isVisible = true

            for (button in buttonList){
                button.isEnabled = false
            }
        }

    }

    private fun playAgain(){

        val buttonList = getButtonList()

        for (button in buttonList){
            button.isEnabled = true
            button.text = ""
        }

        playerOne = ArrayList()
        playerTwo = ArrayList()

    }

    private fun getButtonList(): ArrayList<Button>{

        val buttonList = ArrayList<Button>()
        buttonList.add(findViewById(R.id.button))
        buttonList.add(findViewById(R.id.button2))
        buttonList.add(findViewById(R.id.button3))
        buttonList.add(findViewById(R.id.button4))
        buttonList.add(findViewById(R.id.button5))
        buttonList.add(findViewById(R.id.button6))
        buttonList.add(findViewById(R.id.button7))
        buttonList.add(findViewById(R.id.button8))
        buttonList.add(findViewById(R.id.button9))

        return buttonList
    }



}