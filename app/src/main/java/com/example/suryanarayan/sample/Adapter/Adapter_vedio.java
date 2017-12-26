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

import com.bumptech.glide.Glide;
import com.example.suryanarayan.sample.Activity.AudioDetails;
import com.example.suryanarayan.sample.Activity.ImageDetails;
import com.example.suryanarayan.sample.Activity.VideoDetails;
import com.example.suryanarayan.sample.Modal.ImageParameter;
import com.example.suryanarayan.sample.Modal.VedioParameter;
import com.example.suryanarayan.sample.R;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by surya.narayan on 12/19/2017.
 */

public class Adapter_vedio extends RecyclerView.Adapter<Adapter_vedio.MyViewHolder>
{
    private ArrayList<VedioParameter> imageParametersList;
    private Context context;
    private Gson gson;
    private int id;
    private Layout layout;

    public Adapter_vedio(ArrayList<VedioParameter> imageParametersList, Context context,int id) {
        this.imageParametersList = imageParametersList;
        this.id = id;

        this.context = context;
    }


    @Override
    public Adapter_vedio.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_vedio, parent, false);
        Log.d("Set infalter",""+v);
        return new Adapter_vedio.MyViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final Adapter_vedio.MyViewHolder holder, final int position) {
        VedioParameter pr = imageParametersList.get(position);
        holder.txtdate.setText(Html.fromHtml("<b>" + "Sol ID: " + "</b> "+pr.getStrDate().trim()));
        holder.txtdatetime.setText(Html.fromHtml("<b>" + "Interval: " + "</b> "+pr.getStrDatetime().trim()));
        holder.txtInterval.setText(Html.fromHtml("<b>" + "Date & Time: " + "</b> "+pr.getStrInterval().trim()));
        holder.txtRetentionperiod.setText(Html.fromHtml("<b>" + "Retention Period: " + "</b> "+pr.getStrRetentionperiod().trim()));
        holder.txtaudiotype.setText(Html.fromHtml("<b>" + "Audio Type: " + "</b> "+pr.getStrAudiotype().trim()));
        holder.imageView.setVisibility(View.GONE);
        holder.txtlocation.setText(Html.fromHtml("<b>" + "Location: " + "</b> "+pr.getStrLocation().trim()));
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        //String ProductList = gson.toJson(imageParametersList);
                        Intent intent1 = new Intent(context, VideoDetails.class);
                        //bundle.putParcelableArrayList("list", list);
                        intent1.putExtra("position", position);
                        ActivityOptionsCompat options1 = ActivityOptionsCompat.
                                makeSceneTransitionAnimation((Activity) context, holder.txtSolId,"product_video");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            context.startActivity(intent1, options1.toBundle());
                        }else{
                            context.startActivity(intent1);
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
}