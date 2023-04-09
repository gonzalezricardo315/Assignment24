package com.example.assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.assignment2.R
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private var add = false
    private var decimal = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnOpen: Button = findViewById(R.id.btnOpenActivity)
        btnOpen.setOnClickListener{
            Intent(this, SecondActivity::class.java).also {
                startActivity(it)
            }
        }
    }



    fun numAction(view: View) {
        val calcId: EditText = findViewById(R.id.calc)
        if(view is Button) {
            if(view.text == ".") {
                if(decimal) {
                    calcId.append(view.text)
                }
                decimal = false
            } else {
                calcId.append(view.text)
            }
            add = true
        }
    }

    fun opAction(view: View) {
        val calcId: EditText = findViewById(R.id.calc)
        if(view is Button && add) {
            calcId.append(view.text)
            add = false
            decimal = true
        }
    }

    fun clearAction(view: View){
        val calcId: EditText = findViewById(R.id.calc)
        val resId: TextView = findViewById(R.id.result)
        calcId.setText("")
        resId.text = ""
        add = false
        decimal = true
    }

    fun eqAction(view: View) {
        val resId: TextView = findViewById(R.id.result)
        resId.text = calcResults()
    }

    private fun calcResults(): String {
        val digOperator = digOperator()
        if(digOperator.isEmpty()) {
            return ""
        }

        val mulDiv = multAndDiv(digOperator)
        if(mulDiv.isEmpty()) {
            return ""
        }

        val answer = addAndSub(mulDiv)
        return answer.toString()
    }

    private fun multAndDiv(list: MutableList<Any>): MutableList<Any> {
        var tempList = list
        while (tempList.contains('x') || list.contains('/')) {
            tempList = calculateEquation(tempList)
        }
        return tempList
    }

    private fun calculateEquation(list: MutableList<Any>): MutableList<Any> {
        val tempList = mutableListOf<Any>()
        var res = list.size

        for(i in list.indices) {
            if(list[i] is Char && i != list.lastIndex && i < res) {
                val op = list[i]
                val prev = list[i - 1] as Float
                val next = list[i + 1] as Float
                when(op) {
                    'x' -> {
                        tempList.add(prev * next)
                        res = i + 1
                    }
                    '/' -> {
                        tempList.add(prev / next)
                        res = i + 1
                    }
                    else -> {
                        tempList.add(prev)
                        tempList.add(op)
                    }
                }
            }

            if(i > res){
                tempList.add(list[i])
            }
        }
        return tempList
    }

    private fun addAndSub(list: MutableList<Any>): Float
    {
        var ans = list[0] as Float

        for(i in list.indices)
        {
            if(list[i] is Char && i != list.lastIndex)
            {
                val op = list[i]
                val next = list[i + 1] as Float
                if (op == '+')
                    ans += next
                if (op == '-')
                    ans -= next
            }
        }

        return ans
    }

    private fun digOperator(): MutableList<Any> {
        val calcId: EditText = findViewById(R.id.calc)
        val list = mutableListOf<Any>()
        var cur = ""
        for(character in calcId.text) {
            if(character.isDigit() || character == '.'){
                cur += character
            }

            else {
                list.add(cur.toFloat())
                cur = ""
                list.add(character)
            }
        }

        if(cur != ""){
            list.add(cur.toFloat())
        }

        return list
    }


}