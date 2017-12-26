package com.example.suryanarayan.sample.Activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.suryanarayan.sample.Adapter.Adapter_Image;
import com.example.suryanarayan.sample.Adapter.Adpter_NextImage;
import com.example.suryanarayan.sample.BaseClass.BaseActivity;
import com.example.suryanarayan.sample.Modal.ImageParameter;
import com.example.suryanarayan.sample.Modal.NextImageParameter;
import com.example.suryanarayan.sample.R;

import java.util.ArrayList;

/**
 * Created by surya.narayan on 12/19/2017.
 */

public class ImageDetails extends BaseActivity
{
    private RecyclerView listview;
    private ImageView imageView;
    private TextView txtcameraPosition,txttime,txtSoiID,txtdate,txtLocation;
    private Context context;
    private ProgressBar progressBar;
    private ArrayList<NextImageParameter> list;
    private CollapsingToolbarLayout collapsingToolbarLayout;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagenext);
        InitiStatus();
        context  = this;
        InitilizeView();
        setView ();
        Loadlist();

    }

    private void InitilizeView()
    {
        imageView = (ImageView) findViewById(R.id.product_image);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        listview = (RecyclerView) findViewById(R.id.listview);
        txtSoiID = (TextView) findViewById(R.id.txtsoiid);
        txtdate = (TextView) findViewById(R.id.datetime);
        txtLocation = (TextView) findViewById(R.id.txtlocation);
        list = new ArrayList<>();
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        collapsingToolbarLayout.setTitle("Service Request");
        collapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, android.R.color.transparent));
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setTitleTextColor(getResources().getColor(R.color.black));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                // what do you want here
            }
        });//
    }

    private void setView () {
        Glide
                .with(context)
                .load("http://placehold.it/120x120&text=image1")
                .placeholder(R.mipmap.ic_placeholder) // can also be a drawable
                .error(R.mipmap.ic_placeholder) // will be displayed if the image cannot be loaded
                .crossFade()
                .into(imageView);
    }


    private void Loadlist()
    {

        NextImageParameter imp;
        imp = new NextImageParameter("http://placehold.it/120x120&text=image1");
        list.add(imp);
        imp = new NextImageParameter("http://placehold.it/120x120&text=image2");
        list.add(imp);
        imp = new NextImageParameter("http://placehold.it/120x120&text=image3");
        list.add(imp);
        imp = new NextImageParameter("http://placehold.it/120x120&text=image4");
        list.add(imp);
        imp = new NextImageParameter("http://placehold.it/120x120&text=image4");
        list.add(imp);
        imp = new NextImageParameter("http://placehold.it/120x120&text=image4");
        list.add(imp);
        imp = new NextImageParameter("http://placehold.it/120x120&text=image4");
        list.add(imp);
        imp = new NextImageParameter("http://placehold.it/120x120&text=image4");
        list.add(imp);
        imp = new NextImageParameter("http://placehold.it/120x120&text=image4");
        list.add(imp);
        imp = new NextImageParameter("http://placehold.it/120x120&text=image4");
        list.add(imp);
        imp = new NextImageParameter("http://placehold.it/120x120&text=image4");
        list.add(imp);
        imp = new NextImageParameter("http://placehold.it/120x120&text=image4");
        list.add(imp);
        imp = new NextImageParameter("http://placehold.it/120x120&text=image4");
        list.add(imp);
        imp = new NextImageParameter("http://placehold.it/120x120&text=image4");
        list.add(imp);

        Adpter_NextImage productAdapter = new Adpter_NextImage(list,context);
        /* RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(context,2);
        listview.setLayoutManager(mLayoutManager);
        listview.setItemAnimator(new DefaultItemAnimator());
        listview.setAdapter(productAdapter);*/
        listview.setHasFixedSize(true);
        listview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        listview.setItemAnimator(new DefaultItemAnimator());
        listview.setAdapter(productAdapter);

    }


}
