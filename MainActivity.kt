package com.example.mykotlinapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener{

    lateinit var et_a : EditText
    lateinit var et_b : EditText
    lateinit var add : Button
    lateinit var sub : Button
    lateinit var mul : Button
    lateinit var div : Button
    lateinit var res : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        et_a = findViewById(R.id.et_a)
        et_b = findViewById(R.id.et_b)
        add = findViewById(R.id.add)
        sub = findViewById(R.id.sub)
        mul = findViewById(R.id.mul)
        div = findViewById(R.id.div)
        res = findViewById(R.id.tv_result)

        add.setOnClickListener(this)
        sub.setOnClickListener(this)
        mul.setOnClickListener(this)
        div.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        var a = et_a.text.toString().toDouble()
        var b = et_b.text.toString().toDouble()
        var result = 0.0
        when(v?.id){
            R.id.add -> {result = a + b}
            R.id.sub -> {result = a - b}
            R.id.mul -> {result = a * b}
            R.id.div -> {result = a / b}
        }
        res.text = result.toString()
    }
}