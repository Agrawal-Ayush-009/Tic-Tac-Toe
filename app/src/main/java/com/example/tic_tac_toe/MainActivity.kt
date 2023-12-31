package com.example.tic_tac_toe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun playButton(view: View) {
        val name1 = findViewById<EditText>(R.id.player1Name).editableText.toString()
        val name2 = findViewById<EditText>(R.id.player2Name).editableText.toString()

        if(name1.isEmpty() && name2.isEmpty()){
            Toast.makeText(this, "Enter the Names!", Toast.LENGTH_SHORT).show()
        }else if(name1.isEmpty()){
            Toast.makeText(this,"Enter a Name for Player 1!",Toast.LENGTH_SHORT).show()
        }else if(name2.isEmpty()) {
            Toast.makeText(this, "Enter a Name for Player 2!", Toast.LENGTH_SHORT).show()
        }else{
            val intent = Intent(this, GameActivity :: class.java)

            intent.putExtra(GameActivity.NAME1_EXTRA, name1)
            intent.putExtra(GameActivity.NAME2_EXTRA, name2)

            startActivity(intent)
        }


        var text=findViewById<TextView>(R.id.playButton)

        val animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.tictactoe_anim)
        val textView = findViewById<TextView>(R.id.playButton)
        text.startAnimation(animationFadeIn)
        Handler().postDelayed({
            textView.visibility = View.VISIBLE
        }, 1000)
        }
    }
    


