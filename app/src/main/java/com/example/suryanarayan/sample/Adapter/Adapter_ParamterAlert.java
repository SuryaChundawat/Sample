package com.example.suryanarayan.sample.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
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
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

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

        //Initilize Pie Chart for the use
        holder.pieChart.setUsePercentValues(true);
        holder.pieChart.getDescription().setEnabled(false);
        holder.pieChart.setExtraOffsets(5, 10, 5, 5);
        holder.pieChart.setDragDecelerationFrictionCoef(0.95f);
        holder.pieChart.setDrawHoleEnabled(true);
        holder.pieChart.setHoleColor(Color.WHITE);
        holder.pieChart.setTransparentCircleColor(Color.WHITE);
        holder.pieChart.setTransparentCircleAlpha(110);
        holder.pieChart.setHoleRadius(58f);
        holder.pieChart.setTransparentCircleRadius(61f);
        holder.pieChart.setDrawCenterText(true);
        holder.pieChart.setRotationAngle(0);
        holder.pieChart.setRotationEnabled(false);
        // enable rotation of the chart by touch
        holder.pieChart.setHighlightPerTapEnabled(true);
        holder.pieChart.setTransparentCircleColor(Color.WHITE);
        holder.pieChart.setTransparentCircleAlpha(110);

        holder.pieChart.setHoleRadius(70f);
        holder.pieChart.setTransparentCircleRadius(61f);
        holder.pieChart.setDrawCenterText(true);
        holder.pieChart.setRotationAngle(0);

        setData(4, 100,holder,context,pr);

        holder.pieChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        // holder.pieChart.spin(2000, 0, 360);

        Legend l = holder.pieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);
        holder.pieChart.getLegend().setEnabled(false);
        holder.pieChart.setEntryLabelColor(Color.WHITE);
        holder.pieChart.setEntryLabelTextSize(12f);


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

    private void setData(int count, float range,MyViewHolder holder,Context context,ModalParamter pr) {

        float mult = range;

        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();

        String value = pr.getAlertPercentage();
        value = value.replaceAll("%","");
        value = value.trim();
        int intvalue = Integer.valueOf(value);
        int remainvalue = 100-intvalue;
        float a,b;
        a= Float.valueOf(intvalue);
        b = Float.valueOf(remainvalue);

        entries.add(new PieEntry(a, 1));
        entries.add(new PieEntry(b, 2));
        holder.pieChart.setCenterText(generateCenterSpannableText(a));


        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
       /* for (int i = 0; i < count ; i++) {
            entries.add(new PieEntry((0),
                    mParties[0],
                    ""));
        }*/

        PieDataSet dataSet = new PieDataSet(entries, " ");
        //dataSet.setDrawIcons(false);
        dataSet.setSliceSpace(1f);
        //dataSet.setIconsOffset(new MPPointF(0, 0));
        dataSet.setSelectionShift(1f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<Integer>();

        /*for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);*/

        colors.add(Color.RED);
        colors.add(Color.parseColor("#eeeeee"));

        dataSet.setColors(colors);
        dataSet.setDrawValues(false);
        dataSet.setDrawIcons(false);
        //dataSet.setSelectionShift(0f);

        PieData data = new PieData(dataSet);
        data.setDrawValues(false);
        /*data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);*/
        holder.pieChart.setData(data);

        // undo all highlights
        //holder.pieChart.highlightValues(null);

        holder.pieChart.invalidate();
    }

    protected String[] mParties = new String[] {
            /*"Party A", "Party B", "Party C", "Party D", "Party E", "Party F", "Party G", "Party H",
            "Party I", "Party J", "Party K", "Party L", "Party M", "Party N", "Party O", "Party P",
            "Party Q", "Party R", "Party S", "Party T", "Party U", "Party V", "Party W", "Party X",
            "Party Y", "Party Z"*/
    };

    private SpannableString generateCenterSpannableText(float b) {

        SpannableString s = new SpannableString("Alerts\n"+String.valueOf(b)+"%");
        s.setSpan(new RelativeSizeSpan(1.0f), 0, s.length(), 0);
        s.setSpan(new StyleSpan(Typeface.NORMAL), 0, s.length(), 0);
        s.setSpan(new StyleSpan(Typeface.NORMAL), s.length() - 5, s.length(), 0);
        s.setSpan(new ForegroundColorSpan(Color.RED), s.length() - 5, s.length(), 0);
        return s;
    }
}