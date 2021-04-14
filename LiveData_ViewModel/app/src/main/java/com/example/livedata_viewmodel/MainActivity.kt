package com.example.livedata_viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 사용 할 뷰모델 클래스를 넣어서 가져오기
        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        // 라이브데이더의 값을 옵저빙
        myViewModel.data.observe(this, Observer {
            textView.text = it.toString()
        })

        btnPlus.setOnClickListener(this)
        btnMinus.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val userInput = edtText.text.toString().toInt()

        when(view){
            btnPlus -> myViewModel.updateValue(actionType = ActionType.Plus, userInput)
            btnMinus -> myViewModel.updateValue(actionType = ActionType.Minus, userInput)
        }
    }
}