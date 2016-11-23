package com.charlie.mpandroidcharttest.chartactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.charlie.mpandroidcharttest.R;
import com.charlie.mpandroidcharttest.util.MPChartHelper;
import com.github.mikephil.charting.charts.BarChart;

import java.util.ArrayList;
import java.util.List;

public class ThreeBarChartActivity extends AppCompatActivity {

    private BarChart barChart1;

    private List<Integer> xAxisValues;
    private List<Float> yAxisValues1;
    private List<Float> yAxisValues2;
    private List<Float> yAxisValues3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        initView();
        initData();
        MPChartHelper.setThreeBarChart(barChart1,xAxisValues,yAxisValues1,yAxisValues2,yAxisValues3,"柱状图1","柱状图2","柱状图3");
    }

    private void initView(){
        barChart1=(BarChart)findViewById(R.id.barChart1);
    }

    private void initData(){
        xAxisValues = new ArrayList<>();
        yAxisValues1 = new ArrayList<>();
        yAxisValues2 = new ArrayList<>();
        yAxisValues3 = new ArrayList<>();
        for(int i=0;i<10;++i){
            xAxisValues.add(i);
            yAxisValues1.add((float)(Math.random()*800+20));
            yAxisValues2.add((float)(Math.random()*1000+20));
            yAxisValues3.add((float)(Math.random()*900+20));
        }
    }
}
