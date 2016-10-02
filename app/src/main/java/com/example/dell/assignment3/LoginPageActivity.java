package com.example.dell.assignment3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPageActivity extends AppCompatActivity {

    private Button mLoginButton;
    private Button mSignUpButton;
    private EditText mUName;
    private EditText mPWord;
    static final int REQUEST_CODE_DETAILPAGE= 100;
    static final int REQUEST_CODE_SIGNUPPAGE= 200;
    private static final String TAG = "LoginPageActivity";
    public final String DEFAULT="NA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "in OnCreate function");
        mUName =(EditText) findViewById(R.id.usernameEdit);
        mPWord =(EditText) findViewById(R.id.passwordEdit);
        mSignUpButton=(Button)findViewById(R.id.signUp);
        mSignUpButton.setOnClickListener(new View.OnClickListener(){
            @Override
         public void onClick(View view){
              Intent intent=new Intent("com.example.dell.assignment3.SignUpActivity");
                startActivityForResult(intent,REQUEST_CODE_SIGNUPPAGE);
            }

        });
        mLoginButton=(Button)findViewById((R.id.login));
        mLoginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                SharedPreferences sharedPreferences=getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("UserName",mUName.getText().toString());
                editor.putString("Password",mPWord.getText().toString());
                editor.commit();
                Toast.makeText(LoginPageActivity.this,"Data saved", Toast.LENGTH_SHORT).show();
                String name=sharedPreferences.getString("UserName",DEFAULT);
                String pwd=sharedPreferences.getString("Password",DEFAULT);
                Intent intent=new Intent("com.example.dell.assignment3.UserDetailActivity");
                intent.putExtra("Uname",name);
                intent.putExtra("Pword",pwd);
                startActivityForResult(intent,REQUEST_CODE_DETAILPAGE);
                finish();
            }
        });
    }
}
