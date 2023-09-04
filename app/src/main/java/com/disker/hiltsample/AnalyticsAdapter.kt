package com.disker.hiltsample

import android.util.Log
import javax.inject.Inject

/**
 * constructor @Inject 를 통한 주입 예시 코드
 *
 * constructor @Inject 가 불가한 상황이 있음
 * 1. interface (생성자가 없음)
 * 2. 외부 SDK API (해당 코드 수정 불가)
 */
class AnalyticsAdapter @Inject constructor(private val analyticsService: AnalyticsService) {

    fun sendEvent() {
        Log.d("HiltSample", "${analyticsService.getName()} sendEvent")
    }
}