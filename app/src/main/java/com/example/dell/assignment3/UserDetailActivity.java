package com.example.dell.assignment3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UserDetailActivity extends AppCompatActivity {
    private TextView mUText;
    private TextView mPText;
    static final int REQUEST_LOGOUT= 100;
    private Button mNext;
    private Button mLogOut;
    DatabaseHelper myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        myDatabase=new DatabaseHelper(this);
        mUText=(TextView)findViewById(R.id.unameText);
        mUText.setText(getIntent().getExtras().getString("Uname"));
        mPText=(TextView)findViewById(R.id.passwordText2);
        mPText.setText(getIntent().getExtras().getString("Pword"));
        mLogOut=(Button)findViewById(R.id.logoutbutton);
        mLogOut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                SharedPreferences sharedPreferences=getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();

                editor.clear();
                Toast.makeText(UserDetailActivity.this,"Logged out", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getBaseContext(),LoginPageActivity.class);
                startActivity(intent);

            }
        });
        mNext=(Button)findViewById(R.id.nextbutton);
        mNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent intent=new Intent(getBaseContext(),AboutMeActivity.class);
                startActivity(intent);

            }
        });
    }


}
