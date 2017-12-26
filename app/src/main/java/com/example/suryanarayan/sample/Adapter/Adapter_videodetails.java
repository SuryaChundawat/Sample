package com.example.suryanarayan.sample.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.suryanarayan.sample.Modal.VedioDetailsParameter;
import com.example.suryanarayan.sample.Modal.VedioParameter;
import com.example.suryanarayan.sample.R;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by surya.narayan on 12/20/2017.
 */

public class Adapter_videodetails extends RecyclerView.Adapter<Adapter_videodetails.MyViewHolder> {
    private ArrayList<VedioDetailsParameter> imageParametersList;
    private Context context;
    private Gson gson;
    private int id;

    public Adapter_videodetails(ArrayList<VedioDetailsParameter> imageParametersList, Context context, int id) {
        this.imageParametersList = imageParametersList;
        this.context = context;
        this.id = id;
    }


    @Override
    public Adapter_videodetails.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_vedioother, parent, false);
        Log.d("Set infalter", "" + v);
        return new Adapter_videodetails.MyViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final Adapter_videodetails.MyViewHolder holder, final int position) {
        VedioDetailsParameter pr = imageParametersList.get(position);
        holder.txtdate.setText(Html.fromHtml(pr.getStrDate().trim()));
        holder.txtInterval.setText(Html.fromHtml(pr.getStrDuration().trim()));
        holder.txtSolId.setText(Html.fromHtml("<b>" + "Sol Id:  " + "</b> " + pr.getStrSolid().trim()));
        if (id==0)
        {holder.imageView.setImageResource(mThumbIds[0]);}else
        {holder.imageView.setImageResource(mThumbIds[1]);}

    }

    private Integer[] mThumbIds = {
            R.drawable.audio_gray,
            R.drawable.video_gray,
    };

    @Override
    public int getItemCount() {
        return imageParametersList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txtSolId, txtdate, txtInterval;
        private CardView card;
        private ImageView imageView;

        MyViewHolder(View itemView) {
            super(itemView);
            txtSolId = (TextView) itemView.findViewById(R.id.txtsolid);
            txtdate = (TextView) itemView.findViewById(R.id.txtdate);
            txtInterval = (TextView) itemView.findViewById(R.id.txtvideoduration);
            card = (CardView) itemView.findViewById(R.id.card);
            imageView = (ImageView) itemView.findViewById(R.id.image);
        }

    }
}