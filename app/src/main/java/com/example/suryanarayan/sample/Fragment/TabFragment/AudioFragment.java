package com.example.suryanarayan.sample.Fragment.TabFragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
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

public class AudioFragment extends Fragment implements View.OnClickListener
{
    private RecyclerView Listview;
    private TextView txtSoiId,txtDatetime;
    private ArrayList<VedioParameter> list;
    private Context context;
    private int id = 0;
    private Adapter_audio mAdapter;
    private String KEY_ADAPTER_STATE="ActiHyigene";
    private FloatingActionMenu floatingActionMenu;
    private FloatingActionButton fabSearch,fabRequestaudio;

    public AudioFragment()
    {

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
            View rootview = inflater.inflate(R.layout.fragment_audio, container, false);
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
                if(mAdapter != null) {
                    mAdapter.onRestoreInstanceState(list);
                }

                Listview.setAdapter(mAdapter);


            return rootview;
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


        private void InitilizeView(View view) {
            Listview = (RecyclerView) view.findViewById(R.id.listview);
            txtSoiId = (TextView) view.findViewById(R.id.txtsoiid);
            txtDatetime = (TextView) view.findViewById(R.id.txtdatetime);
            floatingActionMenu = (FloatingActionMenu) view .findViewById(R.id.fabmenu);
            fabSearch = (FloatingActionButton) view.findViewById(R.id.fabsearch);
            fabRequestaudio = (FloatingActionButton) view.findViewById(R.id.fabaudio);
            fabRequestaudio.setOnClickListener(this);
            fabSearch.setOnClickListener(this);
            list = new ArrayList<>();
            InitilizeFab();
        }


        private void InitilizeFab()
        {
            floatingActionMenu.setIconAnimated(false);
            floatingActionMenu.setClosedOnTouchOutside(false);
            //floatingActionMenu.hideMenuButton(false);
            /*floatingActionMenu.setClosedOnTouchOutside(true);
            floatingActionMenu.hideMenuButton(false);*/




        }



        private void Loaddata() {

            VedioParameter imp;
            imp = new VedioParameter("4578","20th Jan 2016","10.15 AM","20th Jan 2016,10.15 AM","4 Days","On demand",getString(R.string.str_location));
            list.add(imp);
            imp = new VedioParameter("7845","11th Feb 2015 ","21.50 PM","20th Jan 2016,10.15 AM","4 Days","On demand",getString(R.string.str_location));
            list.add(imp);
            imp = new VedioParameter("1234","18th March 2014","14.12 PM","20th Jan 2016,10.15 AM","4 Days","On demand",getString(R.string.str_location));
            list.add(imp);
            imp = new VedioParameter("8547","16th April 2013","16.45 PM","20th Jan 2016,10.15 AM","4 Days","On demand",getString(R.string.str_location));
            list.add(imp);

            mAdapter = new Adapter_audio(list,context,id);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
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
            // mListener = (OnFragmentInteractionListener) context;

        }

        @Override
        public void onDetach() {
            super.onDetach();
            //mListener = null;
        }


    @Override
    public void onClick(View view) {
            if (view == fabRequestaudio) {
                Toast.makeText(context,"Fab is clicked",Toast.LENGTH_LONG).show();
            }

    }
}
