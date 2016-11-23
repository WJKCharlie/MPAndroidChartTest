package com.charlie.mpandroidcharttest.chartactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.charlie.mpandroidcharttest.R;
import com.charlie.mpandroidcharttest.util.MPChartHelper;
import com.github.mikephil.charting.charts.LineChart;

import java.util.ArrayList;
import java.util.List;

public class LineChartActivity extends AppCompatActivity {

    private LineChart lineChart;
    private List<String> xAxisValues;
    private List<Float> yAxisValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);

        initView();
        initData();
        MPChartHelper.setLineChart(lineChart,xAxisValues,yAxisValues,"折线图（单）",true);
    }

    private void initView(){
        lineChart=(LineChart)findViewById(R.id.lineChart);
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
