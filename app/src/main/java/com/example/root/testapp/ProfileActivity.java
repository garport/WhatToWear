package com.example.root.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {
    boolean inEdit = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.profile_activity);
        final EditText name = findViewById(R.id.editText1);
        final EditText age = findViewById(R.id.editText2);
        final EditText bio = findViewById(R.id.editText3);
        if(ClosetList.getInstance().age != null){
            age.setText(ClosetList.getInstance().age);
        }
        if(ClosetList.getInstance().profilename != null){
            name.setText(ClosetList.getInstance().profilename);
        }
        if(ClosetList.getInstance().bio != null){
            bio.setText(ClosetList.getInstance().bio);
        }
        age.setInputType(0);
        name.setInputType(0);
        bio.setInputType(0);


        final Button editButton = findViewById(R.id.edit);
        editButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                inEdit = !inEdit;
                if(inEdit){

                    age.setInputType(1);
                    name.setInputType(1);
                    bio.setInputType(1);
                    editButton.setText("Done");
                }
                else{
                    ClosetList.getInstance().profilename = name.getText().toString();
                    ClosetList.getInstance().age = age.getText().toString();

                    ClosetList.getInstance().bio = bio.getText().toString();


                    age.setInputType(0);
                    name.setInputType(0);
                    bio.setInputType(0);
                    editButton.setText("Edit");
                }
            }
        });
    }
}
