package com.android.ATRGames.pairMatching

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.ATRGames.GamesMenu
import com.android.ATRGames.R
import kotlinx.android.synthetic.main.activity_pair_menu.*

class PairMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pair_menu)

        PairMenu_home.setOnClickListener(){
            val i = Intent(this, GamesMenu::class.java)
            startActivity(i)
            finish()
        }

        cuteBugsMenu.setOnClickListener(){
            val i = Intent(this, CuteBugs::class.java)
            startActivity(i)
            finish()
        }

        cuteDragonsMenu.setOnClickListener(){
            val i = Intent(this, CuteDragons::class.java)
            startActivity(i)
            finish()
        }

    }
}