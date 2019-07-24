package com.walltip.categories.util

import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.MotionScene

/**
 * Created by Arif Khan on 2019-07-25.
 */
interface MotionLayoutTransitionListener: MotionLayout.TransitionListener {

    override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) = Unit

    override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) = Unit

    override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) = Unit

    override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) = Unit

    override fun allowsTransition(p0: MotionScene.Transition?): Boolean = true
}