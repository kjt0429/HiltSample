package com.disker.hiltsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.disker.hiltsample.ui.theme.HiltSampleTheme
import dagger.hilt.android.AndroidEntryPoint
import java.lang.reflect.Field
import java.util.Objects
import java.util.function.Consumer
import javax.inject.Inject

/**
 * Hilt 가 set-up(@HiltAndroidApp)되면, application-level component가 사용되고
 * Hilt는 @AndroidEntryPoint가 붙은 클래스에 의존성을 제공할 수 있음.
 *
 * 만약 Android class에 이를 선언했다면, 해당 Android class를 의존하는 Android class에도 해당 선언을 해야함
 * (예. A-Fragment에 선언을 했다면, A-Fragment를 참조하는 A-Activity에도 선언을 해야한다.)
 *
 * 추가로 Android class에 다음 제한이 있음
 * - ComponentActivity(such as AppCompatActivity)
 * - Androidx.fragment
 * - not support retained fragments
 *
 * 이를 선언 시, 각 Android class 마다 주입을 위한 Hilt component 들이 생성 됨. 이는
 * https://developer.android.com/training/dependency-injection/hilt-android#component-hierarchy 따라 참조가 가능하다.
 *
 * 주입을 받기 위해 필드에 @Inject 를 선언
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject lateinit var analyticsAdapter: AnalyticsAdapter
    @Inject lateinit var promotionAdapter: PromotionAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HiltSampleTheme {
                Column() {
                    Button(onClick = {
                        analyticsAdapter.sendEvent()
                    }) {
                        Text(text = "Send Event!")
                    }
                    Button(onClick = {
                        promotionAdapter.showPromotion()
                    }) {
                        Text(text = "Show Promotion!")
                    }
                }

            }
        }
    }
}