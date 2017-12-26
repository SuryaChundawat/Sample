package com.example.suryanarayan.sample.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.suryanarayan.sample.Activity.ImageDetails;
import com.example.suryanarayan.sample.Modal.ImageParameter;
import com.example.suryanarayan.sample.Modal.NextImageParameter;
import com.example.suryanarayan.sample.R;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by surya.narayan on 12/19/2017.
 */

public class Adpter_NextImage extends RecyclerView.Adapter<Adpter_NextImage.MyViewHolder>
{
    private ArrayList<NextImageParameter> imageParametersList;
    private Context context;
    private Gson gson;

    public Adpter_NextImage(ArrayList<NextImageParameter> imageParametersList, Context context) {
        this.imageParametersList = imageParametersList;
        this.context = context;
    }


    @Override
    public Adpter_NextImage.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_nextimages, parent, false);
        Log.d("Set infalter",""+v);
        return new Adpter_NextImage.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final Adpter_NextImage.MyViewHolder holder, final int position) {
        NextImageParameter pr = imageParametersList.get(position);
        String imageurl = pr.getImagepath().trim();
        Glide
                .with(context)
                .load(imageurl)
                .placeholder(R.mipmap.ic_launcher_round) // can also be a drawable
                .error(R.mipmap.ic_placeholder) // will be displayed if the image cannot be loaded
                .crossFade()
                .into(holder.imageView);

        //Make Transacation of the image  for the other activty

        /*holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String ProductList = gson.toJson(imageParametersList);
                Intent intent = new Intent(context, ImageDetails.class);
                //bundle.putParcelableArrayList("list", list);
                intent.putExtra("position", position);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation((Activity) context, holder.imageView,"product_image");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    context.startActivity(intent, options.toBundle());
                }else{
                    context.startActivity(intent);
                }
                // ProductReview.startScreen(mcontext, ProductList, position);
            }
        });*/
        //Log.d("TAG Adpater","prodct namme"+productList.get(position).getProductname()+"product amount"+productList.get(position).getProductAmount());
    }

    @Override
    public int getItemCount() {
        return imageParametersList.size();
    }

    class  MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageview);
        }

    }
}
