package com.example.suryanarayan.sample.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.suryanarayan.sample.Activity.Activity_searchimage;
import com.example.suryanarayan.sample.Activity.AudioDetails;
import com.example.suryanarayan.sample.Activity.ImageDetails;
import com.example.suryanarayan.sample.Activity.VideoDetails;
import com.example.suryanarayan.sample.Modal.ImageParameter;
import com.example.suryanarayan.sample.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.addAll;

/**
 * Created by surya.narayan on 12/27/2017.
 */

public class Adapter_ImageSearch extends RecyclerView.Adapter<Adapter_ImageSearch.MyViewHolder> implements Filterable
{
    private ArrayList<ImageParameter> imageParametersList;
    private ArrayList<ImageParameter> list;
    private Context context;
    private Gson gson;
    ValueFilter valueFilter;
    private int activityid;

    public Adapter_ImageSearch(ArrayList<ImageParameter> imageParametersList, Context context,int id) {
        this.imageParametersList = imageParametersList;
        this.context = context;
        this.list = imageParametersList;
        this.activityid = id;
    }


    @Override
    public Adapter_ImageSearch.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_search, parent, false);
        Log.d("Set infalter",""+v);
        return new Adapter_ImageSearch.MyViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final Adapter_ImageSearch.MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        ImageParameter pr = imageParametersList.get(position);
        String strSolid = pr.getStrSoiId();
        String Datetime = pr.getStrDateTime();
        String Time= pr.getStrTime();
        String Imagepath = pr.getStrImagepath();
        String camerapath = pr.getStrCameraPath();
        Log.e("Image Holder","Sol Id "+strSolid);
        holder.txtsolid.setText(Html.fromHtml("Sol Id : "+"<b>" + pr.getStrSoiId().trim() + "</b> "));
        holder.txtlocation.setText("Location : "+pr.getStrLocation().trim());
        String imageurl = pr.getStrImagepath().trim();
        Glide
                .with(context)
                .load(imageurl)
                .placeholder(R.mipmap.kfc) // can also be a drawable
                .error(R.mipmap.kfc) // will be displayed if the image cannot be loaded
                .crossFade()
                .into(holder.imageView);

        //Make Transacation of the image  for the other activty

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (activityid)
                {
                    case 1:
                        Intent intent = new Intent(context,ImageDetails.class);
                        Bundle bundle = new Bundle();
                        bundle.putParcelableArrayList("imageresources", list);
                        bundle.putInt("Position",position);
                        intent.putExtras(bundle);
                        context.startActivity(intent);
                        ActivityOptionsCompat options = ActivityOptionsCompat.
                                makeSceneTransitionAnimation((Activity) context, holder.imageView,"product_image");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            context.startActivity(intent, options.toBundle());
                        } else {
                            context.startActivity(intent);
                        }
                        break;
                    case 2:
                        Intent intent2 = new Intent(context, AudioDetails.class);
                        //bundle.putParcelableArrayList("list", list);
                        intent2.putExtra("position", position);
                        ActivityOptionsCompat options2 = ActivityOptionsCompat.
                                makeSceneTransitionAnimation((Activity) context, holder.imageView,"product_audio");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            context.startActivity(intent2, options2.toBundle());
                        }else{
                            context.startActivity(intent2);
                        }
                        break;
                    case 3:
                        Intent intent1 = new Intent(context, VideoDetails.class);
                        intent1.putExtra("position", position);
                        ActivityOptionsCompat options1 = ActivityOptionsCompat.
                                makeSceneTransitionAnimation((Activity) context, holder.imageView,"product_video");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            context.startActivity(intent1, options1.toBundle());
                        } else{
                            context.startActivity(intent1);
                        }
                        break;

                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return imageParametersList.size();
    }

    @Override
    public Filter getFilter() {
        if (valueFilter == null) {
            valueFilter = new ValueFilter();
        }
        return valueFilter;
    }

    class  MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView txtsolid,txtlocation;
        private CardView card;

        MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.Image_view);
            txtsolid=(TextView) itemView.findViewById(R.id.txtsolid);
            txtlocation = (TextView) itemView.findViewById(R.id.txtlocation);
            card  = (CardView) itemView.findViewById(R.id.card);
        }

    }

    public ArrayList<ImageParameter> onSaveInstanceState(){
        int size = getItemCount();
        ArrayList<ImageParameter> items = new ArrayList<ImageParameter>(size);
        for(int i=0;i<size;i++){
            items.add(imageParametersList.get(i));
        }
        return items;
    }

    public void onRestoreInstanceState(ArrayList<ImageParameter> items) {
        //clear();
        addAll(items);
    }




    private class ValueFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint != null && constraint.length() > 0) {
                ArrayList<ImageParameter> filterList = new ArrayList<ImageParameter>();
                for (int i = 0; i < list.size(); i++) {
                    if ((list.get(i).getStrSoiId().toUpperCase()).contains(constraint.toString().toUpperCase())) {
                        filterList.add(list.get(i));
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = list.size();
                results.values = list;
            }
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            imageParametersList = (ArrayList<ImageParameter>) results.values;
            notifyDataSetChanged();
        }

    }



}