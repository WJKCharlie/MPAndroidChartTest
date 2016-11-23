package com.charlie.mpandroidcharttest.common;

import android.content.Context;

import com.charlie.mpandroidcharttest.R;
import com.charlie.mpandroidcharttest.util.StringUtils;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;

/**
 * Created by JKWANG-PC on 2016/11/1.
 *
 * Since release v3.0.0, markers (popup views) in the chart are represented by the IMarker interface.
 */

public class MPChartMarkerView extends MarkerView {

    private ArrowTextView tvContent;

    /**
     * Constructor. Sets up the MarkerView with a custom layout resource.
     *
     * @param context
     * @param layoutResource the layout resource to use for the MarkerView
     */
    public MPChartMarkerView(Context context, int layoutResource) {
        super(context, layoutResource);

        tvContent = (ArrowTextView) findViewById(R.id.tvContent);
    }

    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        if (e instanceof CandleEntry) {

            CandleEntry ce = (CandleEntry) e;

            tvContent.setText(StringUtils.double2String(ce.getHigh(), 2));
        } else {

            tvContent.setText(StringUtils.double2String(e.getY(), 2));
        }

        super.refreshContent(e, highlight);//必须加上该句话；This sentence must be added.
    }

    private MPPointF mOffset;

    @Override
    public MPPointF getOffset() {
        if(mOffset == null) {
            // center the marker horizontally and vertically
            mOffset = new MPPointF(-(getWidth() / 2), -getHeight());
        }

        return mOffset;
    }
}
