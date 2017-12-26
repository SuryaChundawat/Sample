package com.example.suryanarayan.sample.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.example.suryanarayan.sample.BaseClass.BaseActivity;
import com.example.suryanarayan.sample.Modal.ImageParameter;
import com.example.suryanarayan.sample.R;

import java.util.ArrayList;

/**
 * Created by surya.narayan on 12/22/2017.
 */

@SuppressLint("Registered")
public class Activity_Search extends BaseActivity
{

    private RecyclerView listview;
    private ArrayList<ImageParameter> list;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        InitilizeView();
    }

    private void InitilizeView()
    {
        listview = (RecyclerView) findViewById(R.id.listview);

    }
}
