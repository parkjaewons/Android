package com.example.bmi_app

import android.graphics.Color
import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.round

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //넘겨온 데이터들을 받음
        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        var value = weight / (height/100.0).pow(2.0)
        value = round(value *100)/100

        //데이터들이 계속 바뀌니까 var로 선언
        var resultText = ""
        var resImage = 0
        var resColor = 0

        if(value < 18.5){
            resultText = "저체중"
            resImage = R.drawable.img_lv2
            resColor = Color.YELLOW
        } else if(value >= 18.5 && value < 23.0){
            resultText = "정상체중"
            resImage = R.drawable.img_lv
            resColor = Color.GREEN
        } else if(value >= 23.0 && value < 25.0){
            resultText = "과체중"
            resImage = R.drawable.img_lv3
            resColor = Color.BLACK
        } else if(value >= 25.0 && value < 30.0){
            resultText = "경도 비만"
            resImage = R.drawable.img_lv4
            resColor = Color.CYAN
        } else if(value >= 30.0 && value <35.0){
            resultText = "중정도 비만"
            resImage = R.drawable.img_lv5
            resColor = Color.YELLOW
        } else {
            resultText = "고도 비만"
            resImage = R.drawable.img_lv6
            resColor = Color.RED
        }

        //
        val tv_resvalue = findViewById<TextView>(R.id.tv_resvalue)
        val tv_restext = findViewById<TextView>(R.id.tv_restext)
        val iv_image = findViewById<ImageView>(R.id.iv_image)
        val btn_back = findViewById<Button>(R.id.btn_back)

        tv_resvalue.text = value.toString()
        tv_restext.text = resultText
        iv_image.setImageResource(resImage)
        tv_restext.setTextColor(resColor)

        //돌아가기 버튼 클릭시 초기화
        btn_back.setOnClickListener{
            finish()
        }
    }
}