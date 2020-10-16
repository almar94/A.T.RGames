package com.android.ATRGames.pairMatching

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.ATRGames.GamesMenu
import com.android.ATRGames.R
import com.android.ATRGames.R.drawable.*
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_cute_bugs.*


class CuteBugs : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cute_bugs)

        val images: MutableList<Int> =
                mutableListOf(cute_bugs1, cute_bugs2, cute_bugs3, cute_bugs4, cute_bugs5, cute_bugs6,
                        cute_bugs1, cute_bugs2, cute_bugs3, cute_bugs4, cute_bugs5, cute_bugs6)
        val buttons = arrayOf(buttonPair1, buttonPair2, buttonPair3, buttonPair4, buttonPair5, buttonPair6,
                buttonPair7, buttonPair8, buttonPair9, buttonPair10, buttonPair11, buttonPair12)

        val cardBack: Int = cute
        var clicked = 0
        var turnOver = false
        var lastClicked = -1
        var points = 0
        var allPair = 0
        val allPairClicked = 6


        homeCuteBugs.setOnClickListener(){
            val i = Intent(this, GamesMenu::class.java)
            startActivity(i)
            finish()
        }

        images.shuffle();
        for (i in 0..11) {
            buttons[i].text = "cardBack"
            buttons[i].textSize = 0.0F
            buttons[i].setOnClickListener() {
                if (buttons[i].text == "cardBack" && !turnOver) {
                    buttons[i].setBackgroundResource(images[i])
                    buttons[i].setText(images[i])
                    if (clicked == 0) {
                        lastClicked = i
                    }
                    clicked++
                } else if (buttons[i].text !in "cardBack") {
                    buttons[i].setBackgroundResource(cardBack)
                    buttons[i].text = "cardBack"
                    clicked--
                }
                if (clicked == 2) {
                    turnOver = true
                    if (buttons[i].text == buttons[lastClicked].text) {
                        buttons[i].isClickable = false
                        buttons[lastClicked].isClickable = false
                        turnOver = false
                        clicked = 0
                        points += 10
                        pointsPair.text = points.toString() + " נקודות "
                        allPair ++
                        if (allPairClicked == allPair) {
                            val snackBar = Snackbar.make(findViewById(R.id.pop_upCuteBugs), "נגמר המשחק כל הכבוד !!", Snackbar.LENGTH_LONG)
                            snackBar.show()
                            snackBar.setAction("חזרה לתפריט", View.OnClickListener {
                                val i = Intent(this, PairMenu::class.java)
                                startActivity(i)
                                finish()
                            })
                        }
                    }
                } else if (clicked == 0) {
                    turnOver = false
                }
            }
        }



    }
}