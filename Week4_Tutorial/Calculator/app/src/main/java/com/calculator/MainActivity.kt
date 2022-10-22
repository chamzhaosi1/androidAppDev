package com.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    lateinit var tvExpression : TextView
    lateinit var tvResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvOne : TextView = findViewById(R.id.tvOne)
        val tvTwo : TextView = findViewById(R.id.tvTwo)
        val tvThree : TextView = findViewById(R.id.tvThree)
        val tvFour : TextView = findViewById(R.id.tvFour)
        val tvFive : TextView = findViewById(R.id.tvFive)
        val tvSix : TextView = findViewById(R.id.tvSix)
        val tvSeven : TextView = findViewById(R.id.tvSeven)
        val tvEight : TextView = findViewById(R.id.tvEight)
        val tvNine : TextView = findViewById(R.id.tvNine)
        val tvZero : TextView = findViewById(R.id.tvZero)
        val tvDot : TextView = findViewById(R.id.tvDot)

        val tvPlus : TextView = findViewById(R.id.tvPlus)
        val tvMinus : TextView = findViewById(R.id.tvMinus)
        val tvMul : TextView = findViewById(R.id.tvMul)
        val tvDivide : TextView = findViewById(R.id.tvDivide)
        val tvOpen : TextView = findViewById(R.id.tvOpen)
        val tvClose : TextView = findViewById(R.id.tvClose)

        val tvClear : TextView = findViewById(R.id.tvClear)
        val tvBack : ImageView = findViewById(R.id.tvBack)
        val tvEquals : TextView = findViewById(R.id.tvEquals)

        tvExpression = findViewById<TextView>(R.id.txExpression)
        tvResult = findViewById<TextView>(R.id.tvResult)

        // Number
        tvOne.setOnClickListener { appendOnExprenstion("1", true) }
        tvTwo.setOnClickListener { appendOnExprenstion("2", true) }
        tvThree.setOnClickListener { appendOnExprenstion("3", true) }
        tvFour.setOnClickListener { appendOnExprenstion("4", true) }
        tvFive.setOnClickListener { appendOnExprenstion("5", true) }
        tvSix.setOnClickListener { appendOnExprenstion("6", true) }
        tvSeven.setOnClickListener { appendOnExprenstion("7", true) }
        tvEight.setOnClickListener { appendOnExprenstion("8", true) }
        tvNine.setOnClickListener { appendOnExprenstion("9", true) }
        tvZero.setOnClickListener { appendOnExprenstion("0", true) }
        tvDot.setOnClickListener { appendOnExprenstion(".", true) }

        //Operators
        tvPlus.setOnClickListener { appendOnExprenstion("+", false) }
        tvMinus.setOnClickListener { appendOnExprenstion("-", false) }
        tvMul.setOnClickListener { appendOnExprenstion("*", false) }
        tvDivide.setOnClickListener { appendOnExprenstion("/", false) }
        tvOpen.setOnClickListener { appendOnExprenstion("(", false) }
        tvClose.setOnClickListener { appendOnExprenstion(")", false) }

        tvClear.setOnClickListener {
            tvExpression.text = ""
            tvResult.text = ""
        }

        tvBack.setOnClickListener {
            val string = tvExpression.text.toString()
            if(string.isNotEmpty()){
                tvExpression.text = string.substring(0, string.length-1)
            }
            tvResult.text = ""
        }

        tvEquals.setOnClickListener {
            try {
                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()

                if(result == longResult.toDouble()){
                    tvResult.text = longResult.toString()
                }else{
                    tvResult.text = result.toString()
                }

            }catch (e:Exception){
                Log.d("Exception", "message : " + e.message)
            }
        }

    }

    fun appendOnExprenstion(string: String, canClear: Boolean){

        if(tvResult.text.isNotEmpty()){
            tvExpression.text = ""
        }

        if (canClear){
            tvResult.text = "";
            tvExpression.append(string)
        }else{
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }
    }
}