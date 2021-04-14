package com.example.livedata_viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


enum class ActionType {
    Plus, Minus
}

// 데이터의 변경
// 데이터의 변경사항을 알려주는 라이브데이터를 가지고 있음
class MyViewModel: ViewModel() {

    // mutable 라이브데이터 -> 값 변경 가능
    // 라이브데이터 -> 값 변경 불가능

    private val currentValue = MutableLiveData<Int>() // 내부에서 설정하는 자료형은 변경 가능하도록(mutable) 설정

    // 값을 라이브데이터에 직접 접근하지 않고 뷰모델을 통해 가져올 수 있도록 설정
    val data: LiveData<Int>
    get() = currentValue // getter

    init {
        currentValue.value = 0 // 초기값 설정
    }

    // 뷰모델이 가지고 있는 값을 변경하는 함수
    fun updateValue(actionType: ActionType, input: Int){
        when(actionType){
            ActionType.Minus -> currentValue.value = currentValue.value?.minus(input)
            ActionType.Plus -> currentValue.value = currentValue.value?.plus(input)
        }
    }
}