package com.charlie.mpandroidcharttest.chartactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.charlie.mpandroidcharttest.R;
import com.charlie.mpandroidcharttest.util.MPChartHelper;
import com.github.mikephil.charting.charts.LineChart;

import java.util.ArrayList;
import java.util.List;

public class MultiLineChartActivity extends AppCompatActivity {

    private LineChart lineChart;
    private List<String> xAxisValues;
    private List<String> titles;
    private List<List<Float>> yAxisValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);

        initView();
        initData();
        MPChartHelper.setLinesChart(lineChart,xAxisValues,yAxisValues,titles,false,null);
    }

    private void initView(){
        lineChart=(LineChart)findViewById(R.id.lineChart);
    }

    private void initData(){
        xAxisValues = new ArrayList<>();
        List<Float> yAxisValues1 = new ArrayList<>();
        List<Float> yAxisValues2 = new ArrayList<>();
        List<Float> yAxisValues3 = new ArrayList<>();
        for(int i=0;i<10;++i){
            xAxisValues.add(String.valueOf(i));
            yAxisValues1.add((float)(Math.random()*20+20));
            yAxisValues2.add((float)(Math.random()*20+40));
            yAxisValues3.add((float)(Math.random()*20+60));
        }

        yAxisValues = new ArrayList<>();
        yAxisValues.add(yAxisValues1);
        yAxisValues.add(yAxisValues2);
        yAxisValues.add(yAxisValues3);

        titles = new ArrayList<>();
        titles.add("折线1");
        titles.add("折线2");
        titles.add("折线3");
    }
}
