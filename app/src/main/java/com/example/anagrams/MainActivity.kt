package com.example.anagrams

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editWord = findViewById<EditText>(R.id.editTextName)
        val result = findViewById<TextView>(R.id.textView)
        val btn = findViewById<Button>(R.id.button)

        btn.setOnClickListener {
            val word: String = editWord.getText().toString()
            // val reverseWord = word.reversed()
            val reverseWord = doTheReverse(word)
            result.setText(reverseWord)
        }
    }


    fun doTheReverse(str: String): String {

        if (str == null || str.equals("")) {
            return str;
        }


        var r = str.length - 1
        var l = 0
        var c = str.toCharArray()
        var tmp: Char
        while (l < r) {
            if (!str[l].isLetter()) {
                l++
            } else if (!str[r].isLetter()) {
                r--
            } else {
                tmp = str[l]
                c[l] = str[r]
                c[r] = tmp;
                l++
                r--
            }

        }

        return String(c)

    }
}



