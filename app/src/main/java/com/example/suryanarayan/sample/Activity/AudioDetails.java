package com.example.suryanarayan.sample.Activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.suryanarayan.sample.Adapter.Adapter_audio;
import com.example.suryanarayan.sample.Adapter.Adapter_videodetails;
import com.example.suryanarayan.sample.BaseClass.BaseActivity;
import com.example.suryanarayan.sample.Modal.VedioDetailsParameter;
import com.example.suryanarayan.sample.R;

import java.util.ArrayList;

/**
 * Created by surya.narayan on 12/20/2017.
 */

public class AudioDetails extends BaseActivity
{

    private RecyclerView Listview;
    private VideoView videoView;
    private TextView txtsolid,txttime,txtrequest,txtfulfield,txtlocation;
    private Context context;
    ArrayList<VedioDetailsParameter> list;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar toolbar;
    private int id=0;




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audiodetails);
        context  = this;
        InitiStatus();
        InitilizeView();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void InitilizeView()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        Listview = (RecyclerView) findViewById(R.id.listview);
        txtsolid = (TextView) findViewById(R.id.txtsolid);
        txttime = (TextView) findViewById(R.id.txttime);
        txtrequest = (TextView) findViewById(R.id.txtrequest);
        txtfulfield = (TextView) findViewById(R.id.txtfulfilled);
        txtlocation = (TextView) findViewById(R.id.txtlocation);
        list = new ArrayList<>();
       /* collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        collapsingToolbarLayout.setTitle("Vedio Request");
        collapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, android.R.color.transparent));*/
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setTitleTextColor(getResources().getColor(R.color.black));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                // what do you want here
            }
        });//
        LoadList();
    }


    private void LoadList()
    {
        VedioDetailsParameter vd ;
        vd = new VedioDetailsParameter("7896","10/5/2015","00:05:46");
        list.add(vd);
        vd = new VedioDetailsParameter("1234","10/5/2015","00:05:46");
        list.add(vd);
        vd = new VedioDetailsParameter("5678","10/5/2015","00:05:46");
        list.add(vd);
        vd = new VedioDetailsParameter("8945","10/5/2015","00:05:46");
        list.add(vd);
        vd = new VedioDetailsParameter("7821","10/5/2015","00:05:46");
        list.add(vd);
        vd = new VedioDetailsParameter("9865","10/5/2015","00:05:46");
        list.add(vd);
        vd = new VedioDetailsParameter("2222","10/5/2015","00:05:46");
        list.add(vd);
        vd = new VedioDetailsParameter("4562","10/5/2015","00:05:46");
        list.add(vd);
        vd = new VedioDetailsParameter("6874","10/5/2015","00:05:46");
        list.add(vd);
        vd = new VedioDetailsParameter("5487","10/5/2015","00:05:46");
        list.add(vd);
        vd = new VedioDetailsParameter("0214","10/5/2015","00:05:46");
        list.add(vd);

        Adapter_videodetails productAdapter = new Adapter_videodetails(list,context,id);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(context,3);
        Listview.setHasFixedSize(true);
        Listview.setLayoutManager(mLayoutManager);
        Listview.setItemAnimator(new DefaultItemAnimator());
        Listview.setAdapter(productAdapter);
    }

}