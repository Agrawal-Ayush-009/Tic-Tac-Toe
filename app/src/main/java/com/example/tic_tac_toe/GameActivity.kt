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


    private fun changeTurn(){
        if(activePlayer == 'O'){
            activePlayer = 'X'
            val player2 = findViewById<TextView>(R.id.p2).text.toString()
            Toast.makeText(this,"$player2's Turn", Toast.LENGTH_SHORT).show()
        }else{
            activePlayer = 'O'
            val player1 = findViewById<TextView>(R.id.p1).text.toString()
            Toast.makeText(this, "$player1's Turn", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkWinner(){
        if(emptyArr.isEmpty()){
            Toast.makeText(this,"It's a Tie", Toast.LENGTH_SHORT).show()
            return
        }

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

        if(winLine == "XXX"){
            Toast.makeText(this,"X Won", Toast.LENGTH_SHORT).show()
        }else if(winLine == "OOO"){
            Toast.makeText(this,"X Won", Toast.LENGTH_SHORT).show()
        }

    }

    private fun removeByIndex(array: Array<Int>, index: Int): Array<Int> {
        val result = arrayOf<Int>(array.lastIndex)
        System.arraycopy(array, 0, result, 0, index)
        if (array.size != index) {
            System.arraycopy(array, index + 1, result, index, array.lastIndex - index)
        }
        return result
    }


    private fun play(button: Button, ID: Int){
        if(activePlayer == 'O'){
            button.setText("O").toString()
            array[ID - 1] = 'O'
            emptyArr = removeByIndex(emptyArray(),ID - 1)
        }else{
            button.setText("X").toString()
            array[ID - 1] = 'X'
            emptyArr = removeByIndex(emptyArray(), ID - 1)
        }


        checkWinner();

        changeTurn();
    }

    fun onTap(view: View) {
        val button = view as Button
        var ID = 0
        when(button.id){
            R.id.one -> ID = 1
            R.id.two -> ID = 2
            R.id.three -> ID = 3
            R.id.four -> ID = 4
            R.id.five -> ID = 5
            R.id.six -> ID = 6
            R.id.seven -> ID = 7
            R.id.eight -> ID = 8
            R.id.nine -> ID = 9
        }

        play(button,ID)
    }


}