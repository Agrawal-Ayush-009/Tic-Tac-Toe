package com.example.tic_tac_toe

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class GameActivity : AppCompatActivity() {
    companion object{
        val NAME1_EXTRA = "name1"
        val NAME2_EXTRA = "name2"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)



        val name1 = intent.getStringExtra(NAME1_EXTRA)
        val name2 = intent.getStringExtra(NAME2_EXTRA)

        findViewById<TextView>(R.id.p1).text = name1
        findViewById<TextView>(R.id.p2).text = name2


        findViewById<TextView>(R.id.turnO).setText("${findViewById<TextView>(R.id.p1).text.toString()}'s Turn!").toString()
    }

    var activePlayer = 'O'
    var array = arrayOf<Char>('0', '0', '0', '0', '0', '0', '0', '0', '0')
    var emptyArr = ArrayList<Int>()
    var ID = 0


    private fun changeTurn(){
        if(activePlayer == 'O'){
            activePlayer = 'X'
            val player2 = findViewById<TextView>(R.id.p2).text.toString()
            findViewById<TextView>(R.id.turnX).setText("$player2's Turn!").toString()
            findViewById<TextView>(R.id.turnO).setText("").toString()
        }else{
            activePlayer = 'O'
            val player1 = findViewById<TextView>(R.id.p1).text.toString()
            findViewById<TextView>(R.id.turnO).setText("$player1's Turn!").toString()
            findViewById<TextView>(R.id.turnX).setText("").toString()
        }
    }

    private fun checkWinner(){

         lateinit var player : String

        for(i in 0..7) {
            var winLine = ""
            when (i) {
                0 -> {
                    winLine += array[0]
                    winLine += array[1]
                    winLine += array[2]
                }

                1 -> {
                    winLine += array[3]
                    winLine += array[4]
                    winLine += array[5]
                }

                2 -> {
                    winLine += array[6]
                    winLine += array[7]
                    winLine += array[8]
                }

                3 -> {
                    winLine += array[0]
                    winLine += array[3]
                    winLine += array[6]
                }

                4 -> {
                    winLine += array[1]
                    winLine += array[4]
                    winLine += array[7]
                }

                5 -> {
                    winLine += array[2]
                    winLine += array[5]
                    winLine += array[8]
                }

                6 -> {
                    winLine += array[0]
                    winLine += array[4]
                    winLine += array[8]
                }

                7 -> {
                    winLine += array[2]
                    winLine += array[4]
                    winLine += array[6]
                }
            }

            if (winLine.compareTo("OOO") == 0) {
                player = findViewById<TextView?>(R.id.p1).text.toString()
                val popup = Dialog(this)
                popup.requestWindowFeature(Window.FEATURE_NO_TITLE)
                popup.setCancelable(false)
                popup.setContentView(R.layout.winner_popup)
                popup.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


                val message = popup.findViewById<TextView>(R.id.message)
                val reset = popup.findViewById<Button>(R.id.reset_Button)
                message.setText("$player is WINNER!").toString()
                popup.show()

                reset.setOnClickListener {
                    popup.dismiss()
                    resetFun()
                }
                break
            } else if (winLine.compareTo("XXX") == 0) {
                player = findViewById<TextView>(R.id.p2).text.toString()
                val popup = Dialog(this)
                popup.requestWindowFeature(Window.FEATURE_NO_TITLE)
                popup.setCancelable(false)
                popup.setContentView(R.layout.winner_popup)
                popup.window?.setBackgroundDrawable(ColorDrawable(Color.WHITE))


                val message = popup.findViewById<TextView>(R.id.message)
                val reset = popup.findViewById<Button>(R.id.reset_Button)
                message.setText("$player is WINNER!").toString()
                popup.show()

                reset.setOnClickListener {
                    popup.dismiss()
                    resetFun()
                }
                break
            }

        }

        if(emptyArr.size == 9){
            val popup = Dialog(this)
            popup.requestWindowFeature(Window.FEATURE_NO_TITLE)
            popup.setCancelable(false)
            popup.setContentView(R.layout.tie_popup)
            popup.window?.setBackgroundDrawable(ColorDrawable(Color.WHITE))


            val message = popup.findViewById<TextView>(R.id.message)
            val reset = popup.findViewById<Button>(R.id.reset_Button)
            message.setText("It's a TIE").toString()
            popup.show()

            reset.setOnClickListener {
                popup.dismiss()
                resetFun()
            }
        }
    }


    private fun resetFun(){
        for(i in 1..9){
            lateinit var button: Button
            when(i){
                1 -> button = findViewById<Button>(R.id.one)
                2 -> button = findViewById<Button>(R.id.two)
                3 -> button = findViewById<Button>(R.id.three)
                4 -> button = findViewById<Button>(R.id.four)
                5 -> button = findViewById<Button>(R.id.five)
                6 -> button = findViewById<Button>(R.id.six)
                7 -> button = findViewById<Button>(R.id.seven)
                8 -> button = findViewById<Button>(R.id.eight)
                9 -> button = findViewById<Button>(R.id.nine)

            }

            button.setText("").toString()
        }
        array = arrayOf<Char>('0', '0', '0', '0', '0', '0', '0', '0', '0')
        emptyArr.clear()

    }



    private fun play(button: Button, ID: Int){
        if(button.text.isEmpty()){
            if(activePlayer == 'O'){
                button.setText("O").toString()
                array[ID - 1] = 'O'
                emptyArr.add(ID - 1)
            }else{
                button.setText("X").toString()
                array[ID - 1] = 'X'
                emptyArr.add(ID - 1)
            }

            checkWinner();

            changeTurn();
        }else{
            Toast.makeText(this,"Select a different Position", Toast.LENGTH_SHORT).show()
        }

    }

    fun onTap(view: View) {
        val button = view as Button
        when(button.tag.toString().toInt()){
            1 -> ID = 1
            2-> ID = 2
            3 -> ID = 3
            4 -> ID = 4
            5 -> ID = 5
            6 -> ID = 6
            7 -> ID = 7
            8 -> ID = 8
            9 -> ID = 9
        }

        play(button,ID)
    }


}