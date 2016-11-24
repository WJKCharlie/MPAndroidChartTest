# MPAndroidChartTest
MPAndroidChart库测试，并封装LineChart、BarChart、PieChart和CombineChart设置代码。

# 项目介绍
引用的库是MPAndroidChart:v3.0.1；自定义了MPChartMarkerView、MyValueFormatter和StringAxisValueFormatter。<br>
# MPAndroidChart使用流程大致如下
### 1、创建Chart
    使用LineChart, BarChart, PieChart或CombineChart时需要先在布局文件中进行定义，然后在后台代码中绑定；或者直接在代码中声明也行（不常用）。
### 2、设置Chart样式
    当创建好一个chart后，就可以为该chart设置样式，包括chart的放缩，chart视图窗口的边距和加载动画，X/Y轴标签的样式、显示的位置、坐标轴的宽度、是否可用等，图例的位置、文字大小等等。<br>
```Java
lineChart.getDescription().setEnabled(false);//设置描述
lineChart.setPinchZoom(true);//设置按比例放缩柱状图

//x坐标轴设置
XAxis xAxis = lineChart.getXAxis();
xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//设置X轴标签显示位置
xAxis.setDrawGridLines(false);//不绘制格网线
xAxis.setGranularity(1f);//设置最小间隔，防止当放大时，出现重复标签。
xAxis.setLabelCount(12);//设置x轴显示的标签个数
xAxis.setAxisLineWidth(2f);//设置x轴宽度, ...其他样式

//y轴设置
YAxis leftAxis = lineChart.getAxisLeft();//取得左侧y轴
leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);//y轴标签绘制的位置
leftAxis.setDrawGridLines(false);//不绘制y轴格网线
leftAxis.setDrawLabels(false);//不显示坐标轴上的值, ...其他样式

lineChart.getAxisRight().setEnabled(false);

//图例设置
Legend legend = lineChart.getLegend();
legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
legend.setDrawInside(false);
legend.setDirection(Legend.LegendDirection.LEFT_TO_RIGHT);
legend.setForm(Legend.LegendForm.LINE);
legend.setTextSize(12f);//设置图例字体大小, ...其他样式

lineChart.setExtraOffsets(10, 30, 20, 10);//设置视图窗口大小
lineChart.animateX(1500);//数据显示动画，从左往右依次显示
```
### 3、设置Chart数据
* 当设置好一个chart的样式后，就可以为该chart添加数据。例如LineChart，一个Entry类代表图上的一个(x,y)坐标对。但在其他的chart类型中，例如BarChart，则是BarEntry类代表图上的一个(x,y)坐标对。<br>
```Java
YourData[] dataObjects = ...;
List<Entry> entries = new ArrayList<Entry>();
for (YourData data : dataObjects) {
    // turn your data into Entry objects
    entries.add(new Entry(data.getValueX(), data.getValueY()));
}
```
* 用List\<Entry>初始化一个LineDataSet对象以代表该数据集。如果一个LineChart有多个LineDataSet，每个LineDataSet可以设置自己的样式。<br>
```Java
LineDataSet dataSet = new LineDataSet(entries, "Label"); // add entries to dataset
dataSet.setColor(...);
dataSet.setValueTextColor(...); // styling, ...
```
* 然后，将LineDataSet添加到LineData对象中。LineData对象持有LineChart的所有数据，并允许设置额外的样式。最后，将LineData对象设置到LineChart并刷新该LineChart即可。<br>
```Java
ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
dataSets.add(dataSet); // add the datasets ...other add

LineData lineData = new LineData(dataSets);
chart.setData(lineData);
chart.setValueTextSize(10f);//设置数值字体大小, ...other styling 
chart.invalidate(); // refresh
```
# 截图如下
![github](https://github.com/WJKCharlie/MPAndroidChartTest/raw/master/screenshots/1.png)
![github](https://github.com/WJKCharlie/MPAndroidChartTest/raw/master/screenshots/2.png)
![github](https://github.com/WJKCharlie/MPAndroidChartTest/raw/master/screenshots/3.png)
![github](https://github.com/WJKCharlie/MPAndroidChartTest/raw/master/screenshots/4.png)
![github](https://github.com/WJKCharlie/MPAndroidChartTest/raw/master/screenshots/5.png)
![github](https://github.com/WJKCharlie/MPAndroidChartTest/raw/master/screenshots/6.png)
![github](https://github.com/WJKCharlie/MPAndroidChartTest/raw/master/screenshots/7.png)
![github](https://github.com/WJKCharlie/MPAndroidChartTest/raw/master/screenshots/8.png)
