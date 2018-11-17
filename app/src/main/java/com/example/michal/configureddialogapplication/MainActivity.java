package com.example.michal.configureddialogapplication;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AlertDialog ad1,ad2;
    String[] colors={"Red","Green","Blue"};
    int [] color = {0,0,0};
    LinearLayout ly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ly=(LinearLayout)findViewById(R.id.ly);

        AlertDialog.Builder adb1;
        adb1=new AlertDialog.Builder(this);
        adb1.setTitle("List Of Colors");
        adb1.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which==0){
                    ly.setBackgroundColor(Color.RED);
                }
                if (which==1){
                    ly.setBackgroundColor(Color.GREEN);
                }
                if (which==2){
                    ly.setBackgroundColor(Color.BLUE);
                }
            }
        });
        adb1.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { }});
        ad1= adb1.create();


        AlertDialog.Builder adb2;
        adb2=new AlertDialog.Builder(this);
        adb2.setTitle("List Of Colors");
        adb2.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                color [which]=55;
                ly.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }});
        adb2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ly.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });
        adb2.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { }});
        ad2=adb2.create();
    }

    public void btn1(View view) {

        ad1.show();
    }

    public void btn2(View view) {
        ad2.show();
    }

    public void btn3(View view) {
        ly.setBackgroundColor(Color.WHITE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Credits");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this,"Application Of Michal Leybovich",Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }
}
