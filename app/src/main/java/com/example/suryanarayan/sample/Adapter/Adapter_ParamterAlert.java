package com.example.suryanarayan.sample.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.suryanarayan.sample.Modal.ModalParamter;
import com.example.suryanarayan.sample.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by surya.narayan on 12/12/2017.
 */

public class Adapter_ParamterAlert extends RecyclerView.Adapter<Adapter_ParamterAlert.MyViewHolder> {
    private ArrayList<ModalParamter> modalParamters;
    private Context context;

    public Adapter_ParamterAlert(ArrayList<ModalParamter> modalParamters, Context context) {
        this.modalParamters = modalParamters;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_parameter, parent, false);
        Log.d("Set infalter", "" + v);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ModalParamter pr = modalParamters.get(position);

        ArrayList<Entry> yvalues = new ArrayList<Entry>();
        String value = pr.getAlertPercentage();
        value = value.replaceAll("%","");
        value = value.trim();
        int intvalue = Integer.valueOf(value);
        int remainvalue = 100-intvalue;
        float a,b;
        a= Float.valueOf(intvalue);
        b = Float.valueOf(remainvalue);

        yvalues.add(new Entry(a, 1));
        yvalues.add(new Entry(b, 2));
        PieDataSet dataSet = new PieDataSet(yvalues, " ");

        holder.pieChart.setCenterText("Alerts:"+"\n"+String.valueOf(yvalues.get(0).getVal()));
        holder.pieChart.setCenterTextColor(Color.RED);
        holder.pieChart.invalidate();
        holder.pieChart.setUsePercentValues(true);
        //holder.pieChart.getDescription().setEnabled(false);
        holder.pieChart.setExtraOffsets(5, 10, 5, 5);
        holder.pieChart.setDragDecelerationFrictionCoef(0.95f);
        holder.pieChart.setDrawHoleEnabled(true);
        holder.pieChart.setHoleColor(Color.WHITE);

        holder.pieChart.setTransparentCircleColor(Color.WHITE);
        holder.pieChart.setTransparentCircleAlpha(110);

        holder.pieChart.setHoleRadius(70f);
        holder.pieChart.setTransparentCircleRadius(61f);

        holder.pieChart.setDrawCenterText(true);

        holder.pieChart.setRotationAngle(0);
        // enable rotation of the chart by touch
        holder.pieChart.setRotationEnabled(true);
        holder.pieChart.setHighlightPerTapEnabled(true);

        // mChart.setUnit(" €");
        // mChart.setDrawUnitsInChart(true);

        // add a selection listener
        //holder.pieChart.setOnChartValueSelectedListener(context);

        //setData(4, 100);

        holder.pieChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);

        //set all the content to the pie chart
        holder.txtHeader.setText(pr.getHeaderName());
        holder.txtStore1.setText(pr.getStoreOne());
        holder.txtStore1value.setText(pr.getStoreOnevalue());
        holder.txtStore2.setText(pr.getStoreTwo());
        holder.txtStore2value.setText(pr.getStoreTwovalue());
        holder.txtStore3.setText(pr.getStorethree());
        holder.txtStore3value.setText(pr.getStoreThreevalue());
        holder.txtStore4.setText(pr.getStoreFour());
        holder.txtStore4value.setText(pr.getStoreFourvalue());
        holder.txtStore5.setText(pr.getStoreFive());
        holder.txtStore5value.setText(pr.getStoreFivevalue());
       /* holder.pieChart.setEntryLabelColor(Color.WHITE);
        holder.pieChart.setEntryLabelTypeface(mTfRegular);
        holder.pieChart.setEntryLabelTextSize(12f);*/





        ArrayList<String> xVals = new ArrayList<String>();

        xVals.add(" ");
        xVals.add(" ");
        /*xVals.add("February");
        xVals.add("March");
        xVals.add("April");
        xVals.add("May");
        xVals.add("June");*/

        PieData data = new PieData(xVals ,dataSet);
        data.setValueTextColor(Color.WHITE);
        //Default value
        //data.setValueFormatter(new DefaultValueFormatter(0));
        holder.pieChart.setData(data);

        dataSet.setColors(new int[]{Color.RED});
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);



        //holder.chkproduct.setText(pr.getProductname());
        //String Amount = String.valueOf(pr.getProductAmount());
        //holder.txtprice.setText(Amount);
        //holder.imageView.setImageResource(pr.getQty());
        //holder.imageView.setImageBitmap(Bitmap.createBitmap(pr.getQty()));
       //Log.d("TAG Adpater", "prodct namme" + productList.get(position).getProductname() + "product amount" + productList.get(position).getProductAmount());

    }

    @Override
    public int getItemCount() {
        return modalParamters.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
       private PieChart pieChart;
       private TextView txtHeader;
       private TextView txtStore1,txtStore2,txtStore3,txtStore4,txtStore5,txtStore1value,txtStore2value,txtStore3value,txtStore4value,txtStore5value;
        /*https://stackoverflow.com/questions/24885223/why-doesnt-recyclerview-have-onitemclicklistener*/


        public MyViewHolder(View itemView) {
            super(itemView);
            pieChart = (PieChart) itemView.findViewById(R.id.piechart);
            txtHeader = (TextView) itemView.findViewById(R.id.paramter_textheader);
            txtStore1 = (TextView) itemView.findViewById(R.id.textparamterstore1);
            txtStore2 = (TextView) itemView.findViewById(R.id.textparamterstore2);
            txtStore3 = (TextView) itemView.findViewById(R.id.textparamterstore3);
            txtStore4 = (TextView) itemView.findViewById(R.id.textparamterstore4);
            txtStore5 = (TextView) itemView.findViewById(R.id.textparamterstore5);
            txtStore1value = (TextView) itemView.findViewById(R.id.txtparamter1);
            txtStore2value = (TextView) itemView.findViewById(R.id.txtparamter2);
            txtStore3value = (TextView) itemView.findViewById(R.id.txtparamter3);
            txtStore4value = (TextView) itemView.findViewById(R.id.txtparamter4);
            txtStore5value = (TextView) itemView.findViewById(R.id.txtparamter5);
            //imageView = (ImageView) itemView.findViewById(R.id.image_product);
            //txtprice = (AppCompatTextView) itemView.findViewById(R.id.txtprice);


        }


    }
}