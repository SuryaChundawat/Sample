package com.example.suryanarayan.sample.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.suryanarayan.sample.Activity.AudioDetails;
import com.example.suryanarayan.sample.Activity.VideoDetails;
import com.example.suryanarayan.sample.Modal.VedioDetailsParameter;
import com.example.suryanarayan.sample.Modal.VedioParameter;
import com.example.suryanarayan.sample.R;
import com.google.gson.Gson;

import java.util.ArrayList;

import static java.util.Collections.addAll;

/**
 * Created by surya.narayan on 12/21/2017.
 */

public class Adapter_audio extends RecyclerView.Adapter<Adapter_audio.MyViewHolder>
{
    private ArrayList<VedioParameter> imageParametersList;
    private Context context;
    private Gson gson;
    private int id;
    private Layout layout;

    public Adapter_audio(ArrayList<VedioParameter> imageParametersList, Context context,int id) {
        this.imageParametersList = imageParametersList;
        this.id = id;

        this.context = context;
    }


    @Override
    public Adapter_audio.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_vedio, parent, false);
        Log.d("Set infalter",""+v);
        return new Adapter_audio.MyViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final Adapter_audio.MyViewHolder holder, final int position) {
        VedioParameter pr = imageParametersList.get(position);
        holder.txtdate.setText(Html.fromHtml("<b>" + "Sol ID: " + "</b> "+pr.getStrDate().trim()));
        holder.txtdatetime.setText(Html.fromHtml("<b>" + "Interval: " + "</b> "+pr.getStrDatetime().trim()));
        holder.txtInterval.setText(Html.fromHtml("<b>" + "Date & Time: " + "</b> "+pr.getStrInterval().trim()));
        holder.txtRetentionperiod.setText(Html.fromHtml("<b>" + "Retention Period: " + "</b> "+pr.getStrRetentionperiod().trim()));
        holder.txtaudiotype.setText(Html.fromHtml("<b>" + "Audio Type: " + "</b> "+pr.getStrAudiotype().trim()));
        holder.imageView.setVisibility(View.VISIBLE);

        holder.txtlocation.setText(Html.fromHtml("<b>" + "Location: " + "</b> "+pr.getStrLocation().trim()));
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        //String ProductList = gson.toJson(imageParametersList);
                        Intent intent = new Intent(context, AudioDetails.class);
                        //bundle.putParcelableArrayList("list", list);
                        intent.putExtra("position", position);
                        ActivityOptionsCompat options = ActivityOptionsCompat.
                                makeSceneTransitionAnimation((Activity) context, holder.txtSolId,"product_audio");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            context.startActivity(intent, options.toBundle());
                        }else{
                            context.startActivity(intent);
                        }
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageParametersList.size();
    }

    class  MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txtSolId,txtdate,txtInterval,txtdatetime,txtRetentionperiod,txtaudiotype,txtlocation;
        private CardView card;
        private ImageView imageView;

        MyViewHolder(View itemView) {
            super(itemView);
            txtSolId=(TextView) itemView.findViewById(R.id.txtsoiid);
            txtdate = (TextView) itemView.findViewById(R.id.txtdate);
            txtInterval = (TextView) itemView.findViewById(R.id.txtinterval);
            txtdatetime = (TextView) itemView.findViewById(R.id.txtdatetime);
            txtRetentionperiod = (TextView) itemView.findViewById(R.id.txtretentionperiod);
            txtaudiotype = (TextView) itemView.findViewById(R.id.txtaudiotype);
            txtlocation = (TextView) itemView.findViewById(R.id.txtlocation);
            card = (CardView) itemView.findViewById(R.id.card);
            imageView = (ImageView) itemView.findViewById(R.id.image);
        }

    }

    public ArrayList<VedioParameter> onSaveInstanceState(){
        int size = getItemCount();
        ArrayList<VedioParameter> items = new ArrayList<VedioParameter>(size);
        for(int i=0;i<size;i++){
            items.add(imageParametersList.get(i));
        }
        return items;
    }

    public void onRestoreInstanceState(ArrayList<VedioParameter> items) {
        //clear();
        addAll(items);
    }
}