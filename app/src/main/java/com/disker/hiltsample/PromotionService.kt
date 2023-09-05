package com.disker.hiltsample

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 * constructor inject 이 불가한 상황이 있음.
 * @Provides 를 통한 예시 코드
 * 한정자를 통해 여러개의 구현체를 생성하여 필요한 구현체를 제공할 수 있음 (PromotionAnnotation.kt 참조)
 *
 * 이미 사전 정의된(predefined) 한정자가 있음. (예. @ApplicationContext, @ActivityContext)
 */
interface PromotionService {
    fun showPromotion(): String
}

class PromotionServiceImplOne: PromotionService {
    override fun showPromotion(): String {
        return "PromotionService - PromotionServiceImplOne"
    }
}

class PromotionServiceImplTwo: PromotionService {
    override fun showPromotion(): String {
        return "PromotionService - PromotionServiceImplTwo"
    }
}

@Module
@InstallIn(ActivityComponent::class)
object PromotionModule
{
    @PromotionServiceOne
    @Provides
    fun providePromotionModuleOne(): PromotionService {
        return PromotionServiceImplOne()
    }

    @PromotionServiceTwo
    @Provides
    fun providePromotionModuleTwo(): PromotionService {
        return PromotionServiceImplTwo()
    }
}