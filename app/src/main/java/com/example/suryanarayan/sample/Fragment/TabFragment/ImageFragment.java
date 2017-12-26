package com.example.suryanarayan.sample.Fragment.TabFragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suryanarayan.sample.Adapter.Adapter_Image;
import com.example.suryanarayan.sample.Fragment.ServiceRequest;
import com.example.suryanarayan.sample.Modal.ImageParameter;
import com.example.suryanarayan.sample.R;

import java.util.ArrayList;

/**
 * Created by surya.narayan on 12/19/2017.
 */

public class ImageFragment extends Fragment implements View.OnClickListener
{
    private RecyclerView Listview;
    private TextView txtSoiId,txtDatetime;
    private ArrayList<ImageParameter> list;
    private Context context;
    private Adapter_Image mAdapter;
    private String KEY_ADAPTER_STATE="ImageParameter";
    private FloatingActionButton fab;

    //Testing Url for the image showing
//    http://placehold.it/120x120&text=image1
//    http://placehold.it/120x120&text=image2
//    http://placehold.it/120x120&text=image3
//    http://placehold.it/120x120&text=image4

    public ImageFragment()
    {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if(mAdapter != null){
            //This case is for when the fragment is at the top of the stack. onCreateView was called and hence there is state to save
            list = mAdapter.onSaveInstanceState();
        }

        //However, remember that this method is called when the device is rotated even if your fragment is on the back stack.
        //In such cases, the onCreateView was not called, hence there is nothing to save.
        //Hence, we just re-save the state that we had retrieved in onCreate. We sort of relay the state from onCreate to onSaveInstanceState.
        outState.putParcelableArrayList(KEY_ADAPTER_STATE, list);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //list = (ArrayList<VedioParameter>) savedInstanceState.getSerializable("list");
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Retrieve saved state in onCreate. This method is called even when this fragment is on the back stack
        if(savedInstanceState != null && savedInstanceState.containsKey(KEY_ADAPTER_STATE)){
            list = savedInstanceState.getParcelableArrayList(KEY_ADAPTER_STATE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_image, container, false);
        InitilizeView(rootview);

        //When we go to next fragment and return back here, the adapter is already present and populated.
        //Don't create it again in such cases. Hence the null check.
        if(mAdapter == null){
            Loaddata();

        }

        //Use the state retrieved in onCreate and set it on your views etc in onCreateView
        //This method is not called if the device is rotated when your fragment is on the back stack.
        //That's OK since the next time the device is rotated, we save the state we had retrieved in onCreate
        //instead of saving current state. See onSaveInstanceState for more details.
        if(mAdapter != null){
            mAdapter.onRestoreInstanceState(list);
        }

        Listview.setAdapter(mAdapter);


        return rootview;
    }

    private void InitilizeView(View view)
    {
        Listview = (RecyclerView) view.findViewById(R.id.listview);
        txtSoiId = (TextView) view.findViewById(R.id.txtsoiid);
        txtDatetime = (TextView) view.findViewById(R.id.txtdatetime);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(this);
        list = new ArrayList<>();
        //fab = ((ServiceRequest) g)
        Loaddata();

    }

    private void Loaddata() {

        ImageParameter imp;
        imp = new ImageParameter("Camera 23","13:56","http://placehold.it/120x120&text=image1");
        list.add(imp);
        imp = new ImageParameter("Camera 85","07:14","http://placehold.it/120x120&text=image2");
        list.add(imp);
        imp = new ImageParameter("Camera 15","19:46","http://placehold.it/120x120&text=image3");
        list.add(imp);
        imp = new ImageParameter("Camera 9","9:01","http://placehold.it/120x120&text=image4");
        list.add(imp);

        mAdapter = new Adapter_Image(list,context);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(context,2);
        Listview.setLayoutManager(mLayoutManager);
        Listview.setItemAnimator(new DefaultItemAnimator());
        Listview.setAdapter(mAdapter);

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
       //mListener = (OnFragmentInteractionListener) context;

    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View view) {
        if (view == fab) {
            Toast.makeText(context, "Fab is clicked", Toast.LENGTH_SHORT).show();

        }

    }
}
