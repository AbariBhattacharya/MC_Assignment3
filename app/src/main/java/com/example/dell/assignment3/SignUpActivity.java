package com.example.dell.assignment3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {


    private static final String TAG = "SignUpPageActivity";
    DatabaseHelper testDb;
    EditText mEditFName;
    EditText meditLname;
    EditText meditUname;
    EditText meditPassword;
    EditText meditPhone;
    Button mSaveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Log.d(TAG, "in OnCreate function");
        testDb=new DatabaseHelper(this);

       mEditFName=(EditText)findViewById(R.id.fnameeditText);
       meditLname=(EditText)findViewById(R.id.lnameeditText2);
       meditUname=(EditText)findViewById(R.id.unameeditText3);
        meditPassword=(EditText)findViewById(R.id.passwordeditText4);
       meditPhone=(EditText)findViewById(R.id.phoneeditText5);

        mSaveButton=(Button)findViewById(R.id.savetodb);
       saveData();
    }

   public void saveData(){
        mSaveButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        boolean isInserted=testDb.insertData(mEditFName.getText().toString(),
                                meditLname.getText().toString(),
                                meditUname.getText().toString(),
                                meditPassword.getText().toString(),
                                meditPhone.getText().toString()
                                );
                        if(isInserted==true) {
                            Log.d(TAG, "in save data function");
                            Toast.makeText(SignUpActivity.this, "Data Successfully Inserted", Toast.LENGTH_LONG).show();

                        }
                        else
                           Toast.makeText(SignUpActivity.this,"Data not inserted",Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
