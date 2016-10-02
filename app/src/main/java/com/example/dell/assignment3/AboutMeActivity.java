package com.example.dell.assignment3;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AboutMeActivity extends AppCompatActivity {

    private EditText mAboutMe;
    private Button mIntButton;
    private Button mExtButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        mAboutMe = (EditText) findViewById(R.id.aboutMeEditText);
        mIntButton = (Button) findViewById(R.id.intButton);
        mIntButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aboutme = mAboutMe.getText().toString();
                FileOutputStream fileOutputStream = null;
                File file = null;
                try {
                    file = getFilesDir();
                    fileOutputStream = openFileOutput("aboutme.txt", Context.MODE_PRIVATE);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    fileOutputStream.write(aboutme.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                Toast.makeText(AboutMeActivity.this, "file written successfully" + file + "/aboutme.txt", Toast.LENGTH_SHORT).show();

            }

        });


    }
}

