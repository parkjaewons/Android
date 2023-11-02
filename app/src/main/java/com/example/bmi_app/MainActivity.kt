package com.example.bmi_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //xml 데이터를 activity에서 사용할 수 있게
        val heightEditText = findViewById<EditText>(R.id.et_height)
        val weightEditText = findViewById<EditText>(R.id.et_weight)
        val submitButton = findViewById<Button>(R.id.btn_check)

        //버튼을 클릭 했을 때 이벤트
        submitButton.setOnClickListener {
            if(heightEditText.text.isEmpty()){
                Toast.makeText(this,"신장을 입력해주세요.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(weightEditText.text.isEmpty()){
                Toast.makeText(this,"체중을 입력해주세요.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //입력된 데이터를 문자열에서 정수형으로 변경
            val height : Int = heightEditText.text.toString().toInt()
            val weight : Int = weightEditText.text.toString().toInt()

            //height,weight 를 ResultActivity로 넘김
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("height",height)
            intent.putExtra("weight",weight)
            startActivity(intent)
        }
    }
}