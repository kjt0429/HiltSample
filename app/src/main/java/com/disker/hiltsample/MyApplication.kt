package com.disker.hiltsample

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Hilt App 인 경우, 반드시 CustomApplication 에서 @HiltAndroidApp Annotation 포함 필요.
 * Hilt 코드가 생성되고, 생성된 Hilt Component 는 Applications object 에 attach 됨.
 * application-level 에서 dependency container 제공.
 */
@HiltAndroidApp
class MyApplication : Application()