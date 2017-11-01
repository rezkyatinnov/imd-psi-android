package com.rezkyatinnov.imdpsi.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import com.rezkyatinnov.imdpsi.R
import com.rezkyatinnov.imdpsi.models.Psi
import com.rezkyatinnov.kyandroid.localdata.LocalData
import com.rezkyatinnov.kyandroid.localdata.QueryFilters
import kotlinx.android.synthetic.main.fragment_chart.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by rezkyatinnov on 31/10/2017.
 */
internal class Chart24Fragment : Fragment() {

    protected var colorsTemplate = intArrayOf(ColorTemplate.COLORFUL_COLORS[0], ColorTemplate.COLORFUL_COLORS[1], ColorTemplate.VORDIPLOM_COLORS[2], ColorTemplate.VORDIPLOM_COLORS[3], ColorTemplate.VORDIPLOM_COLORS[4], ColorTemplate.MATERIAL_COLORS[0], ColorTemplate.MATERIAL_COLORS[1])

    val date: String
        get() {
            @SuppressLint("SimpleDateFormat") val df = SimpleDateFormat("yyyy-MM-dd")
            df.timeZone = TimeZone.getTimeZone("GMT+8")
            return df.format(Date())
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_chart, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initChart()

        var filter = QueryFilters()
        filter.add("isDatetime",0)
        setChartData(linechart,LocalData.get(filter,Psi::class.java))
    }

    private fun initChart() {
        linechart!!.setDrawGridBackground(false)
        linechart!!.description.isEnabled = false
        linechart!!.setTouchEnabled(true)
        linechart!!.isDragEnabled = true
        linechart!!.setScaleEnabled(true)
        linechart!!.setPinchZoom(true)
        linechart!!.axisLeft.setDrawGridLines(false)
        linechart!!.axisRight.isEnabled = true
        linechart!!.xAxis.setDrawGridLines(false)
        linechart!!.xAxis.setDrawAxisLine(false)
        linechart!!.invalidate()
    }

    protected fun setChartData(chart: LineChart, data: Psi) {
        val dataSets = ArrayList<ILineDataSet>()
        for (yAxis in 0 until data.regionMetadata!!.size) {
            val region = data.regionMetadata!![yAxis]!!.name
            val yValues = ArrayList<Entry>()
            for (xAxis in 0 until data.items!!.size) {
                val psiRegion = data.items!![xAxis]!!.readings?.getPsiByRegion(region!!)
                val xVal = (xAxis + 1).toFloat()
                val entry = Entry(xVal, psiRegion?.get("psiTwentyFourHourly")!!.toFloat())
                yValues.add(entry)
            }
            val d = LineDataSet(yValues, region)
            d.lineWidth = 2.5f
            d.circleRadius = 4f

            val color = colorsTemplate[yAxis % colorsTemplate.size]
            d.color = color
            d.setCircleColor(color)
            dataSets.add(d)
        }
        val lineData = LineData(dataSets)
        chart.data = lineData
        val legend = chart.legend
        legend.isEnabled = true
        chart.invalidate()
    }
}
