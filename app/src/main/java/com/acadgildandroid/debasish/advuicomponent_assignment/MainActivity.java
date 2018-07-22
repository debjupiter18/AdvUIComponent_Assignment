package com.acadgildandroid.debasish.advuicomponent_assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private ListView lview;
    private Button ascbtn;
    private Button descbtn;


    //DATA

    private static ArrayList months=new ArrayList();
    private boolean ascending=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initializeViews();
        this.fillMonths();
    }

    private void initializeViews(){

        lview=(ListView)findViewById(R.id.lview);
        ascbtn=(Button)findViewById(R.id.ascbtn);
        descbtn=(Button)findViewById(R.id.descbtn);

        descbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                sortData(ascending);
                ascending=!ascending;
            }
        });
        ascbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                sortData(ascending);
                ascending=ascending;
            }
        });
    }

    private void sortData(boolean asc){

        //SORT ARRAY ASCENDING OR DESCENDING
        if(asc){
            Collections.sort(months);

        }
        else{
            Collections.reverse(months);
        }
        lview.setAdapter(new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,months));
    }
     private void fillMonths(){

        months.clear();
        months.add("April");
        months.add("Feb");
        months.add("Jan");
        months.add("July");
        months.add("June");
        months.add("March");
         lview.setAdapter(new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,months));
     }
}
