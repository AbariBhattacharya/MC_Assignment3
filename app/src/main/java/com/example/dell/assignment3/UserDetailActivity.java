package com.example.dell.assignment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserDetailActivity extends AppCompatActivity {
    private TextView mUText;
    private TextView mPText;
    private Button mViewDetails;
    private Button mNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        mUText=(TextView)findViewById(R.id.unameText);
        mUText.setText(getIntent().getExtras().getString("Uname"));
        mPText=(TextView)findViewById(R.id.passwordText2);
        mPText.setText(getIntent().getExtras().getString("Pword"));
        mViewDetails=(Button)findViewById(R.id.viewDetailButton);
        mViewDetails.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }

        });

    }
}
