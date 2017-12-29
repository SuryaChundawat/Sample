package com.example.suryanarayan.sample.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.suryanarayan.sample.Https.PostApi;
import com.example.suryanarayan.sample.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.ArrayList;


/*
*
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PersonalDetailsActivity.OnFragmentInteractionListener} interface
 * to handle interaction events.
*/


public class SystemHeath extends Fragment /*implements View.OnClickListener,ApiResponse */{

    private OnFragmentInteractionListener mListener;
    private Context context;
    private ProgressBar progressBar;

    private String TAG ="SystemHealth";
    private PostApi postApi;
    private TextView txtstartdate,txtenddate;
    private PieChart mChart;

    public SystemHeath() {
     //Surya Narayan Singh Chundawat
     //Class
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_systemhealth, container, false);
        InitilizeView(rootview);

        return rootview;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    private void InitilizeView(View view)
    {
        txtstartdate = (TextView) view.findViewById(R.id.txtstartdate);
        txtenddate = (TextView) view.findViewById(R.id.txtenddate);
        mChart = (PieChart) view.findViewById(R.id.piechart);
        InitilizePieChart();
        
    }
    
    private void InitilizePieChart()
    {
        ArrayList<Entry> yvalues = new ArrayList<Entry>();
        int valuea = 69;
        int valueb = 31;

        //New pie chart Initilization start
        mChart.setUsePercentValues(true);
        mChart.getDescription().setEnabled(false);
        mChart.getDescription().setEnabled(false);
        mChart.setExtraOffsets(5, 10, 5, 5);
        mChart.setDragDecelerationFrictionCoef(0.95f);
        //mChart.setCenterTextTypeface(mTfLight);
        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColor(Color.WHITE);

        mChart.setTransparentCircleColor(Color.WHITE);
        mChart.setTransparentCircleAlpha(110);

        mChart.setHoleRadius(58f);
        mChart.setTransparentCircleRadius(61f);

        mChart.setDrawCenterText(true);

        mChart.setRotationAngle(0);
        mChart.setRotationEnabled(false);
        // enable rotation of the chart by touch
        mChart.setHighlightPerTapEnabled(true);
        mChart.setTransparentCircleColor(Color.WHITE);
        mChart.setTransparentCircleAlpha(110);

        mChart.setHoleRadius(70f);
        mChart.setTransparentCircleRadius(61f);

        mChart.setDrawCenterText(true);

        mChart.setRotationAngle(0);

        // mChart.setUnit(" €");
        // mChart.setDrawUnitsInChart(true);

        // add a selection listener
        //mChart.setOnChartValueSelectedListener(context);

        setData(4, 100);

        mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        // mChart.spin(2000, 0, 360);

        Legend l = mChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setXEntrySpace(10f);
        l.setYEntrySpace(10f);
        l.setYOffset(10f);

        // entry label styling
        mChart.setEntryLabelColor(Color.WHITE);
        //mChart.setEntryLabelTypeface(mTfRegular);
        mChart.setEntryLabelTextSize(12f);


        //Initilize Pie Chart End





        // mChart.setUnit(" €");
        // mChart.setDrawUnitsInChart(true);

        // add a selection listener
        //holder.pieChart.setOnChartValueSelectedListener(context);
        //setData(4, 100);

        mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        // mChart.setUnit(" €");
        // mChart.setDrawUnitsInChart(true);
        // add a selection listener
        //mChart.setOnChartValueSelectedListener(context);
       /* setData(4, 100);
        mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);*/
        // mChart.spin(2000, 0, 360);
        
        //Initilization end here




       /* yvalues.add(new Entry(valuea, 1));
        yvalues.add(new Entry(valueb, 2));
        PieDataSet dataSet = new PieDataSet(yvalues, " ");


        pieChart.setCenterText(valuea +"%"+ " "+"Active"+"\n"+ "Network Satuts");
        pieChart.setCenterTextColor(Color.RED);
        pieChart.invalidate();
        pieChart.setUsePercentValues(true);
        //pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10, 5, 5);
        pieChart.setDragDecelerationFrictionCoef(0.95f);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);

        pieChart.setTransparentCircleColor(Color.WHITE);
        pieChart.setTransparentCircleAlpha(110);
        pieChart.setHoleRadius(70f);
        pieChart.setTransparentCircleRadius(61f);

        pieChart.setDrawCenterText(true);

        pieChart.setRotationAngle(0);
        // enable rotation of the chart by touch
        pieChart.setRotationEnabled(true);
        pieChart.setHighlightPerTapEnabled(true);

        // mChart.setUnit(" €");
        // mChart.setDrawUnitsInChart(true);

        // add a selection listener
        //pieChart.setOnChartValueSelectedListener(context);

        //setData(4, 100);

        pieChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);

        ArrayList<String> xVals = new ArrayList<String>();

        xVals.add("OFF");
        xVals.add("ON");
        *//*xVals.add("February");
        xVals.add("March");
        xVals.add("April");
        xVals.add("May");
        xVals.add("June");*//*

        PieData data = new PieData(xVals ,dataSet);
        data.setValueTextColor(Color.WHITE);
        //Default value
        //data.setValueFormatter(new DefaultValueFormatter(0));
        pieChart.setData(data);*/
    }
    

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (OnFragmentInteractionListener) context;
        this.context= context;

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private SpannableString generateCenterSpannableText(int a) {

        SpannableString s = new SpannableString(a+"%"+"  Active"+"\n"+"Network Status");
        s.setSpan(new RelativeSizeSpan(1.7f), 0, 3, 0);
        s.setSpan(new StyleSpan(Typeface.NORMAL), 3, s.length(), 0);
        //s.setSpan(new ForegroundColorSpan(Color.GRAY), 14, s.length() - 15, 0);
        //s.setSpan(new RelativeSizeSpan(.8f), 14, s.length() - 15, 0);
        s.setSpan(new ForegroundColorSpan(Color.GREEN), 0, s.length()-21, 0);
        return s;
    }

    private void setData(int count, float range) {

        float mult = range;

        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();
        float  a [] = {69f,31f};
        for (int i = 0; i < a.length ; i++) {
            entries.add(new PieEntry((float) a[i],
                    mParties[i],
                    getResources().getDrawable(R.drawable.star)));
        }





       /* entries.add(new PieEntry(69, 1));
        entries.add(new PieEntry(21, 2));*/
        mChart.setCenterText(generateCenterSpannableText(69));

        PieDataSet dataSet = new PieDataSet(entries, " ");

        dataSet.setDrawIcons(false);
        dataSet.setSliceSpace(1f);
        dataSet.setIconsOffset(new MPPointF(40, 40));
        dataSet.setSelectionShift(0f);
        dataSet.setDrawValues(false);
        dataSet.setDrawIcons(false);

        // add a lot of colors
        ArrayList<Integer> colors = new ArrayList<Integer>();

        colors.add(Color.parseColor("#0ca612"));
        colors.add(Color.parseColor("#fe0100"));

        dataSet.setColors(colors);
        //dataSet.setSelectionShift(0f);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        mChart.setData(data);

        // undo all highlights
        mChart.highlightValues(null);

        mChart.invalidate();
    }

    protected String[] mParties = new String[] {
            "ON", "OFF"
    };


}
