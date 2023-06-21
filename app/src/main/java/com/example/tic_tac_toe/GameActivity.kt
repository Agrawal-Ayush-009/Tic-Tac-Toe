package com.example.tic_tac_toe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

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
    }

    var activePlayer = 'O'
    var array = arrayOf<Char>('0', '0', '0', '0', '0', '0', '0', '0', '0')
    var emptyArr = arrayOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)

    fun clickfun(view: View) {
        val button = view as Button
        var id = 0
        when(button.id){
            R.id.one -> id = 1
            R.id.two -> id = 2
            R.id.three -> id = 3
            R.id.four -> id = 4
            R.id.five -> id = 5
            R.id.six -> id = 6
            R.id.seven -> id = 7
            R.id.eight -> id = 8
            R.id.nine -> id = 9
        }
        play(button,id)
    }

    fun changeTurn(){
        if(activePlayer == 'O'){
            activePlayer = 'X'
        }else{
            activePlayer = 'O'
        }
    }

    fun checkWinner(){

        var winLine = ""
        for(i in 0..7){
            if(i == 0){
                winLine += array[0]
                winLine += array[1]
                winLine += array[2]
            }else if(i == 1){
                winLine += array[3]
                winLine += array[4]
                winLine += array[5]
            }else if(i == 2){
                winLine += array[6]
                winLine += array[7]
                winLine += array[8]
            }else if(i == 3){
                winLine += array[0]
                winLine += array[3]
                winLine += array[6]
            }else if(i == 4){
                winLine += array[1]
                winLine += array[4]
                winLine += array[7]
            }else if(i == 5){
                winLine += array[2]
                winLine += array[5]
                winLine += array[8]
            }else if(i == 6){
                winLine += array[0]
                winLine += array[4]
                winLine += array[8]
            }else if(i == 7){
                winLine += array[2]
                winLine += array[4]
                winLine += array[6]
            }
        }

//        if(winLine == "XXX"){
//            return 'X'
//        }else if(winLine == "OOO"){
//            return 'O'
//        }

    }


    fun play(button: Button, id: Int){

    }


}