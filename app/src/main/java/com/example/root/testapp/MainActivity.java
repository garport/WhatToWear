package com.example.root.testapp;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Dialog quizDialog;
    RadioGroup radioGroup;
    ImageButton google;
    ImageButton facebook;
    int page = 0;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        LinearLayout gallery = findViewById(R.id.gallery);

        LayoutInflater galInflater = LayoutInflater.from(this);

        for(int i = 0; i < 1; i++ ){

            View view = galInflater.inflate(R.layout.item,gallery,false);

            ImageView imageview = view.findViewById(R.id.imageView3);
            imageview.setImageResource(R.drawable.outfit1);

            gallery.addView(view);
        }
        for(int i = 0; i < 1; i++ ){

            View view = galInflater.inflate(R.layout.item,gallery,false);

            ImageView imageview = view.findViewById(R.id.imageView3);
            imageview.setImageResource(R.drawable.outfitcold);

            gallery.addView(view);
        }
        for(int i = 0; i < 1; i++ ){

            View view = galInflater.inflate(R.layout.item,gallery,false);

            ImageView imageview = view.findViewById(R.id.imageView3);
            imageview.setImageResource(R.drawable.outfit2);

            gallery.addView(view);
        }
        final Button custom = findViewById(R.id.button_customize);
        custom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, CustomizeActivity.class));

            }
        });

        //inspired by https://stackoverflow.com/questions/4636141/determine-if-android-app-is-the-first-time-used
        final String PREFS_NAME = "MyPrefsFile";

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

        if (settings.getBoolean("my_first_time", true)) {
            //the app is being launched for first time, do something
            Log.d("Comments", "First time");

            // first time task
            quizDialog =   new Dialog(this);
            quizDialog.setContentView(R.layout.quizlayout);
            //inspired by https://www.youtube.com/watch?v=4g1_UH_6VQc
            radioGroup = findViewById(R.id.radioGroup);
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
                        radio1. setText("None");
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


            final Dialog login = new Dialog(this);
            login.setContentView(R.layout.login);
            facebook = login.findViewById(R.id.imageButton4);
            google= login.findViewById(R.id.imageButton5);
            facebook.setOnClickListener( new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    login.dismiss();
                    quizDialog.show();

                }
            });
            google.setOnClickListener( new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    login.dismiss();
                    quizDialog.show();

                }
            });

            login.show();

            // record the fact that the app has been started at least once
            settings.edit().putBoolean("my_first_time", false).commit();
        }
        final Dialog confirm = new Dialog(this);
        confirm.setContentView(R.layout.confirm);
        final Button wearIt = findViewById(R.id.button_wear);

        wearIt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //add test outfit to wear
                ClothingTopH top = new ClothingTopH("Green","Warm","Formal","Short-Sleeve",R.drawable.shirt1);
                ClothingBottomH bottom = new ClothingBottomH("Navy","Cool","Informal","Pants",R.drawable.pants1);
                ClothingShoesH shoes = new ClothingShoesH("Boots",R.drawable.shoes1);
                Outfit exampleOutfit = new Outfit(top, bottom, shoes, "11/17/18", R.drawable.outfit1);
                HistoryActivity.outfitHistory.add(0,exampleOutfit);

                confirm.show();
            }
        });

        final ImageButton bigWeather = findViewById(R.id.imageButton2);
        final Dialog enlargedWeather = new Dialog(this);
        enlargedWeather.setContentView(R.layout.enlarged_weather);
        bigWeather.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                enlargedWeather.show();
            }
        });
        final ImageButton bigCalender = findViewById(R.id.calendarbutton);
        final Dialog enlargedCalender = new Dialog(this);
        enlargedCalender.setContentView(R.layout.enlarged_calender);

        bigCalender.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                enlargedCalender.show();
                Window window = enlargedCalender.getWindow();
                window.setLayout(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the p button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action

        } else if (id == R.id.nav_closet) {

            startActivity(new Intent(MainActivity.this, ClosetActivity.class));
        } else if (id == R.id.nav_social) {
            startActivity(new Intent(MainActivity.this, SocialActivity.class));


        } else if (id == R.id.nav_history) {
            startActivity(new Intent(MainActivity.this, HistoryActivity.class));

        } else if (id == R.id.nav_profile) {
            startActivity(new Intent(MainActivity.this, ProfileActivity.class));

        } else if (id == R.id.nav_settings) {
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));


        } else if (id == R.id.nav_logout) {
            final String PREFS_NAME = "MyPrefsFile";

            final SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            settings.edit().putBoolean("my_first_time", true).commit();

            quizDialog =   new Dialog(this);
            quizDialog.setContentView(R.layout.quizlayout);

            radioGroup = findViewById(R.id.radioGroup);
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
                        settings.edit().putBoolean("my_first_time", false).commit();

                        quizDialog.dismiss();
                    }

                    page++;
                }
            });
            final Dialog login = new Dialog(this);
            login.setContentView(R.layout.login);
            facebook = login.findViewById(R.id.imageButton4);
            google= login.findViewById(R.id.imageButton5);
            facebook.setOnClickListener( new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    login.dismiss();
                    quizDialog.show();

                }
            });
            google.setOnClickListener( new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    login.dismiss();
                    quizDialog.show();


                }
            });

            login.show();
            //startActivity(new Intent(MainActivity.this, LoginActivity.class));


        }



        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
