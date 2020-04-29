package com.example.mytest2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var a: String? = null
    var b: String? = null
    var c: String? = null
    var output = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        a = intent.getStringExtra("Input1")
        b = intent.getStringExtra("Input2")
        c = intent.getStringExtra("Action")
        if (a != null && b != null && c != null) {
            if (c == "Addition") {
                output = a!!.toInt() + b!!.toInt()
                val thread: Thread = object : Thread() {
                    override fun run() {
                        try {
                            sleep(1000)
                            val launchIntent = packageManager.getLaunchIntentForPackage("com.example.mytest1")
                            launchIntent!!.putExtra("result", output)
                            launchIntent.putExtra("input1", a)
                            launchIntent.putExtra("input2", b)
                            launchIntent.putExtra("action", c)
                            if (launchIntent != null) {
                                startActivity(launchIntent)
                                finish()
                            }
                        } catch (e: InterruptedException) {
                            e.printStackTrace()
                        }
                    }
                }
                thread.start()
            } else {
                output = a!!.toInt() - b!!.toInt()
                val thread: Thread = object : Thread() {
                    override fun run() {
                        try {
                            sleep(1000)
                            val launchIntent = packageManager.getLaunchIntentForPackage("com.example.mytest1")
                            launchIntent!!.putExtra("result", output)
                            launchIntent.putExtra("input1", a)
                            launchIntent.putExtra("input2", b)
                            launchIntent.putExtra("action", c)
                            if (launchIntent != null) {
                                startActivity(launchIntent)
                                finish()
                            }
                        } catch (e: InterruptedException) {
                            e.printStackTrace()
                        }
                    }
                }
                thread.start()
            }
        } else {
            Toast.makeText(applicationContext, "Please Install the othe App", Toast.LENGTH_SHORT).show()
        }
    }
}