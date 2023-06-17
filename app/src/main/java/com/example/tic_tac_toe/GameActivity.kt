package com.example.tic_tac_toe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

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

    fun clickfun(view: View) {
         val button : Button = view as Button
        var  cellid = 0;
        when(button.id){
            R.id.one -> cellid = 1;

        }
    }


}