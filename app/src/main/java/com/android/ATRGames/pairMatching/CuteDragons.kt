package com.android.ATRGames.pairMatching

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.android.ATRGames.GamesMenu
import com.android.ATRGames.R
import com.android.ATRGames.R.drawable.*
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_cute_dragons.*

class CuteDragons : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cute_dragons)

        val images: MutableList<Int> =
                mutableListOf(cute_dragons1, cute_dragons2, cute_dragons3, cute_dragons4, cute_dragons5, cute_dragons6,
                        cute_dragons1, cute_dragons2, cute_dragons3, cute_dragons4, cute_dragons5, cute_dragons6)
        val buttons = arrayOf(buttonCuteDragons1, buttonCuteDragons2, buttonCuteDragons3, buttonCuteDragons4, buttonCuteDragons5, buttonCuteDragons6,
                buttonCuteDragons7, buttonCuteDragons8, buttonCuteDragons9, buttonCuteDragons10, buttonCuteDragons11, buttonCuteDragons12)

        val cardBack: Int = cute
        var clicked = 0
        var turnOver = false
        var lastClicked = -1
        var points = 0
        var allPair = 0
        val allPairClicked = 6

        homeCuteDragons.setOnClickListener() {
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
                        pointsCuteDragons.text = points.toString() + " נקודות "
                        allPair ++
                        if (allPairClicked == allPair) {
                            val snackbar = Snackbar.make(findViewById(R.id.pop_upCuteDragons), "נגמר המשחק כל הכבוד !!", Snackbar.LENGTH_LONG)
                            snackbar.show()
                            snackbar.setAction("חזרה לתפריט", View.OnClickListener {
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