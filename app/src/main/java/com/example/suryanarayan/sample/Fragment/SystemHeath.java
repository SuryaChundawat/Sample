package com.example.suryanarayan.sample.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

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
        PieChart pieChart = (PieChart) view.findViewById(R.id.piechart);
        InitilizePieChart(pieChart);
        
    }
    
    private void InitilizePieChart(PieChart pieChart)
    {
        ArrayList<Entry> yvalues = new ArrayList<Entry>();
        int valuea = 69;
        int valueb = 31;

        yvalues.add(new Entry(valuea, 1));
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
        /*xVals.add("February");
        xVals.add("March");
        xVals.add("April");
        xVals.add("May");
        xVals.add("June");*/

        PieData data = new PieData(xVals ,dataSet);
        data.setValueTextColor(Color.WHITE);
        //Default value
        //data.setValueFormatter(new DefaultValueFormatter(0));
        pieChart.setData(data);
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


}
