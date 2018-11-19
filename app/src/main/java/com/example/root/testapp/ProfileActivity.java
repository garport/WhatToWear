package com.example.root.testapp;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    boolean inEdit = false;
    int page = 0;
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
    public void onRetakeButtonPressed(View view){

        final Dialog quizDialog;
        quizDialog =   new Dialog(this);
        quizDialog.setContentView(R.layout.quizlayout);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        final TextView questionText = quizDialog.findViewById(R.id.textView4);
        final RadioButton radio1 = quizDialog.findViewById(R.id.radio1);
        final RadioButton radio2 = quizDialog.findViewById(R.id.radio2);
        final RadioButton radio3 = quizDialog.findViewById(R.id.radio3);
        final RadioButton radio4 = quizDialog.findViewById(R.id.radio4);
        final RadioButton radio5 = quizDialog.findViewById(R.id.radio5);

        final Button nxt = quizDialog.findViewById(R.id.nxt);
        nxt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(page == 0){
                    questionText.setText("How many times do you change clothes throughout the day?");
                    radio1.setText("None");
                    radio2.setText("One Time");
                    radio3.setText("Two Times");
                    radio4.setText("Three Times");
                    radio5.setText("More than four times");




                }
                else if(page == 1){
                    questionText.setText("At what temperature range do you feel comfortable without a jacket?");
                    radio1.setText("More than 75 degrees");
                    radio2.setText("At least 65 degrees");
                    radio3.setText("At least 55 degrees");
                    radio4.setText("At least 45 degrees");
                    radio5.setText("At least 35 degrees");
                }
                else if(page == 2){
                    questionText.setText("After you wear an outfit, don't recommend those clothes for:");
                    radio1.setText("Three days");
                    radio2.setText("One week");
                    radio3.setText("Two weeks");
                    radio4.setText("Three weeks");
                    radio5.setText("Four weeks");


                }
                else if (page == 3) {
                    questionText.setText("What is the most important weather feature for choosing your outfit?");
                    radio1.setText("Humidity");
                    radio2.setText("Wind Levels");
                    radio3.setText("UV Levels");
                    radio4.setText("Significant change in temperature");
                    radio5.setText("High chance of precipitation");
                    nxt.setText("Done");
                }
                else{
                    page = -1;
                    nxt.setText("Next");

                    quizDialog.dismiss();
                }

                page++;
            }
        });
        quizDialog.show();
    }
}
