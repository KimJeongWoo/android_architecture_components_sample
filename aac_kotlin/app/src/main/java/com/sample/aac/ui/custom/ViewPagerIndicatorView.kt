package com.sample.aac.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout

class ViewPagerIndicatorView : LinearLayout {
    private var mContext: Context? = null
    private var dotImages = arrayListOf<ImageView>()
    private var mDefaultDot: Int = 0
    private var mSelectedDot: Int = 0

    constructor(context: Context) : super(context) {
        mContext = context
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        mContext = context
    }

    fun init(count: Int, defaultDot: Int, selectedDot: Int, margin: Int) {
        this.removeAllViews()
        mDefaultDot = defaultDot
        mSelectedDot = selectedDot
        for (i in 0 until count) {
            dotImages.add(ImageView(mContext))
            val width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8f, resources.displayMetrics).toInt()
            val height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8f, resources.displayMetrics).toInt()
            val params = LayoutParams(width, height)
            params.topMargin = 0
            params.bottomMargin = 0
            params.leftMargin = 0
            if (i == count - 1)
                params.rightMargin = 0
            else
                params.rightMargin = margin
            params.gravity = Gravity.CENTER

            dotImages[i].layoutParams = params
            dotImages[i].setImageResource(defaultDot)
            dotImages[i].setTag(dotImages[i].id, false)
            this.addView(dotImages[i])
        }
        setSelection(0)
    }

    fun setSelection(position: Int) {
        for (i in dotImages.indices) {
            if (i == position) {
                dotImages[i].setImageResource(mSelectedDot)
            } else {
                dotImages[i].setImageResource(mDefaultDot)
            }
        }
    }
}
