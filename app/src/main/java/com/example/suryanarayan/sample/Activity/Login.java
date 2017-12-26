package com.example.suryanarayan.sample.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.suryanarayan.sample.BaseClass.BaseActivity;
import com.example.suryanarayan.sample.R;

/**
 * Created by surya.narayan on 12/14/2017.
 */

public class Login extends BaseActivity implements View.OnClickListener
{

    private Context context;
    private EditText edtusername,edtpassword;
    private Button btnLogin;
    private TextView txtforgotpassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = this;
        InitiStatus();
        InitilizeView();
    }

    private void InitilizeView() {
        edtusername = (EditText) findViewById(R.id.edtUsername);
        edtpassword = (EditText)  findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnlogin);
        txtforgotpassword =(TextView) findViewById(R.id.txtforgetpassword);
        txtforgotpassword.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

    }


    public static void StartActivity(Context context) {
        context.startActivity(new Intent(context,Login.class));
    }

    @Override
    public void onClick(View v) {
        if (v==btnLogin) {
            MainActivity.StartActivity(context);
            finish();
        }

        if (v == txtforgotpassword )
        {
            showSnackbar(btnLogin,"Work Under progress");
        }

    }
}
