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

                    age.setInputType(0);
                    name.setInputType(0);
                    bio.setInputType(0);
                    editButton.setText("Edit");
                }
            }
        });
    }
}
