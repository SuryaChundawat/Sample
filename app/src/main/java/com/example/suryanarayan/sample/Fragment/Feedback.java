package com.example.suryanarayan.sample.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.suryanarayan.sample.Https.PostApi;
import com.example.suryanarayan.sample.R;

/**
 * Created by surya.narayan on 12/15/2017.
 */

public class Feedback extends Fragment implements View.OnClickListener /*implements View.OnClickListener,ApiResponse */{

    private OnFragmentInteractionListener mListener;
    private Context context;
    private ProgressBar progressBar;
    private String TAG ="Feedback";
    private PostApi postApi;
    private ImageView imageEmotion;
    private TextView txtreview;
    private RatingBar ratingBar;
    private AppCompatButton btnsubmit;




    public Feedback() {
        //Surya Narayan Singh Chundawat
        //Class
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
            View rootview = inflater.inflate(R.layout.fragment_feedback, container, false);
            InitilizeView(rootview);

            return rootview;
    }

    private void InitilizeView(View view)
    {
        imageEmotion = (ImageView) view.findViewById(R.id.imageimoge);
        txtreview = (TextView) view.findViewById(R.id.txtreview);
        ratingBar = (RatingBar) view.findViewById(R.id.featurerating);
        btnsubmit = (AppCompatButton) view.findViewById(R.id.btnsubmit);
        btnsubmit.setOnClickListener(this);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.e(TAG,"Rating is given by"+rating+"and " + " rating  bar " +ratingBar + "And from user is" + fromUser);
                if (rating==1.0)
                {
                    imageEmotion.setImageDrawable(getResources().getDrawable(R.drawable.one_star));
                    txtreview.setText(getResources().getString(R.string.one_star));

                }else if(rating == 2.0)
                {
                    imageEmotion.setImageDrawable(getResources().getDrawable(R.drawable.two_star));
                    txtreview.setText(getResources().getString(R.string.two_star));

                }else if(rating == 3.0)
                {
                    imageEmotion.setImageDrawable(getResources().getDrawable(R.drawable.three_star));
                    txtreview.setText(getResources().getString(R.string.three_star));

                }else if(rating == 4.0)
                {
                    imageEmotion.setImageDrawable(getResources().getDrawable(R.drawable.four_star));
                    txtreview.setText(getResources().getString(R.string.four_star));

                }else if(rating == 5.0)
                {
                    imageEmotion.setImageDrawable(getResources().getDrawable(R.drawable.five_star));
                    txtreview.setText(getResources().getString(R.string.five_star));
                }
            }
        });

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

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        if (v == btnsubmit) {
            showSnackbar(btnsubmit,"Thanks for your valuable Review");
            onDetach();
        }

    }

    protected void showSnackbar(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show();
    }

}