package com.example.suryanarayan.sample.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.suryanarayan.sample.Activity.ActivityCalender;
import com.example.suryanarayan.sample.Adapter.Adapter_ParamterAlert;
import com.example.suryanarayan.sample.Https.ApiResponse;
import com.example.suryanarayan.sample.Https.PostApi;
import com.example.suryanarayan.sample.Modal.ModalParamter;
import com.example.suryanarayan.sample.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/*
*
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DashBoard.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DashBoard#newInstance} factory method to
 * create an instance of this fragment.
*/
public class DashBoard extends Fragment implements ApiResponse,View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Context context;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView txtIrId,txtdashName,txtdashdate,txtdash_available_points;

    private OnFragmentInteractionListener mListener;
    private SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private String TAG="Dashboard.fragment";
    private PostApi postApi;
    private AppCompatButton btnParamterAlert,btnStoreAlert;
    private RecyclerView listview;
    private ArrayList<ModalParamter> ParamterProduct;
    private FloatingActionButton fab;






    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.activity_dashboard, container, false);
        GetRef(rootview);
        // Inflate the layout for this fragment
        return rootview;
    }

    @SuppressLint("CommitPrefEdits")
    private void GetRef(View view)
    {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
        btnParamterAlert = (AppCompatButton) view.findViewById(R.id.btnParamterAlert);
        btnStoreAlert = (AppCompatButton) view.findViewById(R.id.btnStoreAlert);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(this);
        btnStoreAlert.setOnClickListener(this);
        btnParamterAlert.setOnClickListener(this);

        listview = (RecyclerView) view.findViewById(R.id.listview);
        ParamterProduct = new ArrayList<ModalParamter>();
        FeelStaticvalue();
        submit();
    }

    private void FeelStaticvalue () {
        ModalParamter modalParamter;
        modalParamter = new ModalParamter("Header Frist Name","52 % ","abc store","xbd store","star store", "fifa store","other store alerts","45 %","89 5","12 %","25 %", "75 %");
        ParamterProduct.add(modalParamter);
        modalParamter = new ModalParamter("Header Second Name","60 % ","shdkj store","xbd store","star store", "fifa store","other store alerts","45 %","89 5","12 %","25 %", "75 %");
        ParamterProduct.add(modalParamter);
        modalParamter = new ModalParamter("Header third Name","57 % ","ask store","xbd store","star store", "fifa store","other store alerts","45 %","89 5","12 %","25 %", "75 %");
        ParamterProduct.add(modalParamter);
        modalParamter = new ModalParamter("Header four Name","46 % ","ags store","xbd store","star store", "fifa store","other store alerts","45 %","89 5","12 %","25 %", "75 %");
        ParamterProduct.add(modalParamter);
        modalParamter = new ModalParamter("Header five Name","75 % ","xcvkl store","xbd store","star store", "fifa store","other store alerts","45 %","89 5","12 %","25 %", "75 %");
        ParamterProduct.add(modalParamter);
        modalParamter = new ModalParamter("Header six Name","15 % ","yrue store","xbd store","star store", "fifa store","other store alerts","45 %","89 5","12 %","25 %", "75 %");
        ParamterProduct.add(modalParamter);
        modalParamter = new ModalParamter("Header seven Name","78 % ","skd store","xbd store","star store", "fifa store","other store alerts","45 %","89 5","12 %","25 %", "75 %");
        ParamterProduct.add(modalParamter);


        Adapter_ParamterAlert productAdapter = new Adapter_ParamterAlert(ParamterProduct,getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        listview.setLayoutManager(mLayoutManager);
        listview.setItemAnimator(new DefaultItemAnimator());
        listview.setAdapter(productAdapter);

    }


    private void submit() {

        if (isOnline(context)) {

        } else {
            //showSnackbar(txtIrId,"Ooops!! Check your Network");
        }
    }

    private void callback(int id, String...data) {
        switch (id) {
            case 0:
                /*String URL = NetworkUrl.URL_ENCASHPOINTS;
                String apiTag = NetworkUrl.URL_ENCASHPOINTS;
                JSONObject jsonObject = GetLoginObject();
                Log.e(TAG, "callback: json" + jsonObject.toString());
                postApi = new PostApi(context, URL, jsonObject, apiTag, TAG ,0);  // 1 is id for call deshboard api*/
                break;

            default:
                break;
        }
    }


    //Request For The Object Header Permission
    private JSONObject GetLoginObject() {
        String irid=sharedPreferences.getString("irid","");
        Log.d(TAG,"irid"+irid);
        JSONObject jobject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("IR_ID",irid );
            jsonArray.put(jsonObject);
            jobject.put("jsonObject_Details",jsonArray);
        }catch (JSONException e) {
            e.printStackTrace();
            Log.d(TAG, "GetLoginObject: " + e.getMessage());
        }
        Log.d(TAG,"Registration Object"+jobject);
        return jobject;
    }




    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (OnFragmentInteractionListener) context;
        this.context= context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    protected void showSnackbar(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show();
    }

    protected boolean isOnline(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }




    public OnFragmentInteractionListener getmListener() {
        return mListener;
    }


    //{"IR_EncashDetailsList":[{"IR_CreditAmount":"600.00","IR_Date":"10\/08\/2017 10:09:44 PM",
    // "IR_EncashPoints":"1000.00","IR_ID":"17330001","IR_WeekNo":"41","IR_YearNo":"2017",
    // "Message":"","Status":"Success"}]}

    @Override
    public void OnSucess(JSONObject response, int id) {
        Log.e(TAG, "OnSucess: "+id+"  "+ response);
        if (id ==3) {
            //showProgress(false);
            try {
                String status =response.getString("IR_EncashDetailsList");
               /* JSONArray jsonArray = */
                if(status.equals("Success")) {
                    showSnackbar(txtdashName,status);
                    String IR_DOB =response.getString("IR_DOB");
                    String IR_EmailID =response.getString("IR_EmailID");
                    String IR_FirstName =response.getString("IR_FirstName");
                    String IR_ID =response.getString("IR_ID");
                    String IR_LastName =response.getString("IR_LastName");
                    String IR_MiddleName =response.getString("IR_MiddleName");
                    String IR_MobileNo =response.getString("IR_MobileNo");
                    String Message =response.getString("Message");

                } else {
                    showSnackbar(txtdashName,status);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void OnFailed(int error, int id) {

    }

    @Override
    public void onClick(View v) {
        if (v == btnParamterAlert) {
            btnParamterAlert.setBackgroundDrawable(getResources().getDrawable(R.drawable.shap_round_color));
            btnStoreAlert.setBackgroundColor(btnParamterAlert.getContext().getResources().getColor(R.color.colorPrimary));
            btnParamterAlert.setTextColor(btnParamterAlert.getContext().getResources().getColor(R.color.white));
            btnStoreAlert.setTextColor(btnStoreAlert.getContext().getResources().getColor(R.color.black));
            Adapter_ParamterAlert productAdapter = new Adapter_ParamterAlert(ParamterProduct,getActivity());
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
            listview.setLayoutManager(mLayoutManager);
            listview.setItemAnimator(new DefaultItemAnimator());
            listview.setAdapter(productAdapter);
        }

        if (v == btnStoreAlert) {
            btnStoreAlert.setBackgroundDrawable(getResources().getDrawable(R.drawable.shap_round_color));
            btnParamterAlert.setBackgroundColor(btnParamterAlert.getContext().getResources().getColor(R.color.colorPrimary));
            btnParamterAlert.setTextColor(btnParamterAlert.getContext().getResources().getColor(R.color.black));
            btnStoreAlert.setTextColor(btnStoreAlert.getContext().getResources().getColor(R.color.white));
            Adapter_ParamterAlert productAdapter = new Adapter_ParamterAlert(ParamterProduct,getActivity());
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
            listview.setLayoutManager(mLayoutManager);
            listview.setItemAnimator(new DefaultItemAnimator());
            listview.setAdapter(productAdapter);

        }

        if (v == fab) {
            ActivityCalender.StartActivity(context);

        }

    }
}
