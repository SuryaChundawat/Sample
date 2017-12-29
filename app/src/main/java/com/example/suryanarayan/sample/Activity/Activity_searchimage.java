package com.example.suryanarayan.sample.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.suryanarayan.sample.Adapter.Adapter_ImageSearch;
import com.example.suryanarayan.sample.Adapter.Adapter_audio;
import com.example.suryanarayan.sample.BaseClass.BaseActivity;
import com.example.suryanarayan.sample.Modal.ImageParameter;
import com.example.suryanarayan.sample.R;

import java.util.ArrayList;

/**
 * Created by surya.narayan on 12/26/2017.
 */

public class Activity_searchimage extends BaseActivity implements View.OnClickListener
{
    private Toolbar toolbar;
    private SearchView searchView;
    private ProgressBar progressBar;
    private RecyclerView listview;
    private Context context;
    private ArrayList<ImageParameter>list;
    private AppCompatButton btnback;
    private Adapter_ImageSearch mAdapter;
    private int ActivityId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagesearch);
        context = this;
        getRef();
        list = new ArrayList<ImageParameter>();
        if (savedInstanceState == null) {
            Bundle bundle = getIntent().getExtras();
            assert bundle != null;
            list = bundle.getParcelableArrayList("imageresources");
            ActivityId = bundle.getInt("id");
            assert list != null;
            mAdapter = new Adapter_ImageSearch(list,context,ActivityId);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
            listview.setLayoutManager(mLayoutManager);
            listview.setItemAnimator(new DefaultItemAnimator());
            listview.setAdapter(mAdapter);
        }

    }

    private void getRef()
    {
        searchView = (SearchView) findViewById(R.id.search);
        listview = (RecyclerView) findViewById(R.id.listview);
        btnback = (AppCompatButton) findViewById(R.id.btnback);
        btnback.setOnClickListener(this);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return true;
            }
        });
    }


    @Override
    public void onClick(View v) {
        if (v == btnback) {
            finish();
        }

    }
}
