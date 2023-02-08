package com.example.buttlerlogin

import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Interpolator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


// data class ParentModel(val list : List<String>)

class CirclePagerIndicatorDecoration : RecyclerView.ItemDecoration() {

    companion object {
         var DP = Resources.getSystem().displayMetrics.density

       var px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, DP , Resources.getSystem().displayMetrics)




        private var colorActive = Color.parseColor("#061524")
        private var colorInactive = Color.parseColor("#33061524")

        /**
         * Height of the space the indicator takes up at the bottom of the view.
         */
        private var mIndicatorHeight = (DP * 16).toInt()

        /**
         * Indicator stroke width.
         */
        private var mIndicatorStrokeWidth = DP * 4

        /**
         * Indicator width.
         */
        private var mIndicatorItemLength = DP * 5

        /**
         * Padding between indicators.
         */
        private var mIndicatorItemPadding = DP * 8


        fun setColorActive(color : String)
        {
            this.colorActive = Color.parseColor(color)
        }

        fun setColorInactive(color: String){
            this.colorInactive = Color.parseColor(color)
        }

        fun setIndicatorWidth(size : Int){
            this.mIndicatorItemLength = DP * size
        }

        fun setIndicatorPadding(size : Int){
            this.mIndicatorItemPadding = DP * size
        }

        fun setIndicatorHeight(size : Int){
            this.mIndicatorHeight = (DP * size).toInt()
        }

        fun setIndicatorStrokeWidth(size : Int){
            this.mIndicatorStrokeWidth = DP * size
        }


    }



    /**
     * Some more natural animation interpolation
     */
    private val mInterpolator: Interpolator = AccelerateDecelerateInterpolator()
    private val mPaint = Paint()

    init {
        mPaint.strokeWidth = mIndicatorStrokeWidth
        mPaint.style = Paint.Style.STROKE
        mPaint.isAntiAlias = true
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        val itemCount = parent.adapter!!.itemCount

        // center horizontally, calculate width and subtract half from center
        val totalLength = mIndicatorItemLength * itemCount
        val paddingBetweenItems = Math.max(0, itemCount - 1) * mIndicatorItemPadding
        val indicatorTotalWidth = totalLength + paddingBetweenItems
        val indicatorStartX = (parent.width - indicatorTotalWidth) / 2f

        // center vertically in the allotted space
        val indicatorPosY = parent.height - mIndicatorHeight / 2f
        drawInactiveIndicators(c, indicatorStartX, indicatorPosY, itemCount)

        // find active page (which should be highlighted)
        val layoutManager = parent.layoutManager as LinearLayoutManager?
        val activePosition = layoutManager!!.findFirstVisibleItemPosition()
        if (activePosition == RecyclerView.NO_POSITION) {
            return
        }

        // find offset of active page (if the user is scrolling)
        val activeChild = layoutManager.findViewByPosition(activePosition)
        val left = activeChild!!.left
        val width = activeChild.width
        val right = activeChild.right

        // on swipe the active item will be positioned from [-width, 0]
        // interpolate offset for smooth animation
        val progress: Float = mInterpolator.getInterpolation(left * -1 / width.toFloat())
        drawHighlights(c, indicatorStartX, indicatorPosY, activePosition, progress)
    }

    private fun drawInactiveIndicators(
        c: Canvas,
        indicatorStartX: Float,
        indicatorPosY: Float,
        itemCount: Int
    ) {
        mPaint.color = colorInactive

        // width of item indicator including padding
        val itemWidth = mIndicatorItemLength + mIndicatorItemPadding
        var start = indicatorStartX
        for (i in 0 until itemCount) {
            c.drawCircle(start, indicatorPosY, mIndicatorItemLength / 2f, mPaint)
            start += itemWidth
        }
    }

    private fun drawHighlights(
        c: Canvas, indicatorStartX: Float, indicatorPosY: Float,
        highlightPosition: Int, progress: Float
    ) {
        mPaint.color = colorActive

        // width of item indicator including padding
        val itemWidth = mIndicatorItemLength + mIndicatorItemPadding
        if (progress == 0f) {
            // no swipe, draw a normal indicator
            val highlightStart = indicatorStartX + itemWidth * highlightPosition
            c.drawCircle(highlightStart, indicatorPosY, mIndicatorItemLength / 2f, mPaint)
        } else {
            val highlightStart = indicatorStartX + itemWidth * highlightPosition
            // calculate partial highlight
            val partialLength = mIndicatorItemLength * progress + mIndicatorItemPadding * progress
            c.drawCircle(
                highlightStart + partialLength,
                indicatorPosY,
                mIndicatorItemLength / 2f,
                mPaint
            )
        }
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom = mIndicatorHeight
    }


}