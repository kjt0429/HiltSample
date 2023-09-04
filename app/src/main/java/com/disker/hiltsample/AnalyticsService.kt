package com.disker.hiltsample

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Inject

/**
 * constructor inject 이 불가한 상황이 있음.
 * @Bind 를 통한 예시 코드
 */
interface AnalyticsService {
    fun getName(): String
}

class AnalyticsServiceImpl @Inject constructor() : AnalyticsService {
    override fun getName(): String {
        return "AnalyticsServiceImpl"
    }
}

/**
 * @Module annotation을 통해 Hilt Module을 생성하고, Hilt에게 주입을 위한 도구를 알려줌
 * @InstallIn 에서 어느 컴포넌트에서 사용할 것인지 표시
 * (추가 목록: https://developer.android.com/training/dependency-injection/hilt-android#generated-components)
 */
@Module
@InstallIn(ActivityComponent::class)
abstract class AnalyticsModule {

    @Binds
    abstract fun bindAnalyticsService(analyticsServiceImpl: AnalyticsServiceImpl):
            AnalyticsService
}