package com.example.suryanarayan.sample.Fragment.TabFragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suryanarayan.sample.Adapter.Adapter_audio;
import com.example.suryanarayan.sample.Adapter.Adapter_vedio;
import com.example.suryanarayan.sample.Modal.VedioParameter;
import com.example.suryanarayan.sample.R;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;

/**
 * Created by surya.narayan on 12/19/2017.
 */

public class VedioFragment extends Fragment implements View.OnClickListener
{
    private RecyclerView Listview;
    private TextView txtSoiId,txtDatetime;
    private ArrayList<VedioParameter> list;
    private Context context;
    private int id=1;
    private FloatingActionMenu fab;
    private FloatingActionButton fabSearch,fabVideo;


    public VedioFragment()
    {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_vedio, container, false);
        InitilizeView(rootview);
        return rootview;
    }

        private void InitilizeView(View view)
        {
            Listview = (RecyclerView) view.findViewById(R.id.listview);
            txtSoiId = (TextView) view.findViewById(R.id.txtsoiid);
            txtDatetime = (TextView) view.findViewById(R.id.txtdatetime);
            fab = (FloatingActionMenu) view.findViewById(R.id.fabmenu);
            fabSearch = (FloatingActionButton) view.findViewById(R.id.fabsearch);
            fabVideo = (FloatingActionButton) view.findViewById(R.id.fabvedio);
            fabSearch.setOnClickListener(this);
            fabVideo.setOnClickListener(this);
            fab.setOnClickListener(this);
            list = new ArrayList<>();
            Loaddata();
            InitilizeFab();
        }


    private void Loaddata()
    {
        VedioParameter imp;
        imp = new VedioParameter("4578","20th Jan 2016","10.15 AM","20th Jan 2016,10.15 AM","4 Days","On demand",getString(R.string.str_location));
        list.add(imp);
        imp = new VedioParameter("7845","11th Feb 2015 ","21.50 PM","20th Jan 2016,10.15 AM","4 Days","On demand",getString(R.string.str_location));
        list.add(imp);
        imp = new VedioParameter("1234","18th March 2014","14.12 PM","20th Jan 2016,10.15 AM","4 Days","On demand",getString(R.string.str_location));
        list.add(imp);
        imp = new VedioParameter("8547","16th April 2013","16.45 PM","20th Jan 2016,10.15 AM","4 Days","On demand",getString(R.string.str_location));
        list.add(imp);

        Adapter_vedio adapterVedio = new Adapter_vedio(list,context,id);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        Listview.setLayoutManager(mLayoutManager);
        Listview.setItemAnimator(new DefaultItemAnimator());
        Listview.setAdapter(adapterVedio);

    }

    private void InitilizeFab()
    {
        fab.setIconAnimated(false);
        fab.setClosedOnTouchOutside(false);
        //floatingActionMenu.hideMenuButton(false);
            /*floatingActionMenu.setClosedOnTouchOutside(true);
            floatingActionMenu.hideMenuButton(false);*/




    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
       /* if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }*/
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        // mListener = (OnFragmentInteractionListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }


    @Override
    public void onClick(View view) {

        if (view == fabSearch) {
            Toast.makeText(context,"Fab is clicked",Toast.LENGTH_LONG).show();
        }

        if (view == fabVideo) {
            Toast.makeText(context,"Fab is clicked",Toast.LENGTH_LONG).show();
        }
    }
}
