package com.crow.learn.compose.ui

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.app.ComponentActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

fun ComponentActivity.initializeSplashScreen() {
    // 启动动画
    val splash = installSplashScreen()

    // 设置退出动画
    splash.setOnExitAnimationListener {  provider ->
        val splashScreenView = provider.view
        // Set the pivot point to the top of the view
        splashScreenView.pivotY = splashScreenView.height.toFloat()

        // Create your custom animation.
        val a1 = ObjectAnimator.ofFloat(
            splashScreenView,
            View.SCALE_Y,
            1f,
            0f
        )
        val a2 = ObjectAnimator.ofFloat(
            splashScreenView,
            View.SCALE_X,
            1f,
            0f,
        )
        val a3 = ObjectAnimator.ofFloat(
            splashScreenView,
            View.ALPHA,
            1f,
            0f,
        )
        val a4 = ObjectAnimator.ofFloat(
            splashScreenView,
            View.TRANSLATION_Y,
            0f,
            splashScreenView.height.toFloat(),
        )
        val set = AnimatorSet()
            .apply {
                interpolator = AnticipateInterpolator()
                doOnEnd {
                    provider.remove()
                }
            }
            .setDuration(600L)
        set.playTogether(a3)
        set.start()
    }

    // 可以监听动画是否展示完毕来延长launch的展示
    splash.setKeepOnScreenCondition { false }
}