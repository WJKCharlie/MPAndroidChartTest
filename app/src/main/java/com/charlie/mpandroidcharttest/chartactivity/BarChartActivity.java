package com.charlie.mpandroidcharttest.chartactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.charlie.mpandroidcharttest.R;
import com.charlie.mpandroidcharttest.util.MPChartHelper;
import com.github.mikephil.charting.charts.BarChart;

import java.util.ArrayList;
import java.util.List;

public class BarChartActivity extends AppCompatActivity {

    private BarChart barChart1;

    private List<String> xAxisValues;
    private List<Float> yAxisValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        initView();
        initData();
        MPChartHelper.setBarChart(barChart1,xAxisValues,yAxisValues,"柱状图（单）",15,null);
    }

    private void initView(){
        barChart1=(BarChart)findViewById(R.id.barChart1);
    }

    private void initData(){
        xAxisValues = new ArrayList<>();
        yAxisValues = new ArrayList<>();
        for(int i=0;i<10;++i){
            xAxisValues.add(String.valueOf(i));
            yAxisValues.add((float)(Math.random()*1000+20));
        }
    }
}
