package com.example.buttoncounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.EditText

private const val TAG = "MainActivity"
private const val TEXT_CONTENTS = "TextContent"

class MainActivity : AppCompatActivity() {
    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i(TAG, "onCreate: method called")
        val editText = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)
        textView = findViewById(R.id.textView)
        textView?.text = ""
        textView?.movementMethod = ScrollingMovementMethod()

        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                textView?.append("${editText.text}\n")
                editText.text.clear()
            }
        })
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart: method called")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume: method called")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause: method called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart: method called")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop: method called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy: method called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // putting textView data in outState bundle to retrive later.
        outState.putString(TEXT_CONTENTS, textView?.text.toString())
        Log.i(TAG, "onSaveInstanceState: method called")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // restoring the old data to textView
        textView?.text = savedInstanceState.getString(TEXT_CONTENTS, "")
        Log.i(TAG, "onRestoreInstanceState: method called")
    }
}