package com.disker.hiltsample

import android.util.Log
import javax.inject.Inject

class PromotionAdapter @Inject constructor(@PromotionServiceOne /* @PromotionServiceTwo */private val promotionService: PromotionService) {

    fun showPromotion() {
        Log.d("HiltSample", promotionService.showPromotion())
    }
}