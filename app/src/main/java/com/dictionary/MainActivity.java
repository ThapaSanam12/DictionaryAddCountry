package com.dictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
//
//    public static final String countries []={
//            "Nepal","Kathmandu",
//            "India","New Delhi",
//            "China","Beijing",
//            "UK","London",
//            "USA","Washington,DC"
//    };
private ListView lvcountries;
    private Map<String,String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


      lvcountries = findViewById ( R.id.lvcountries);

        dictionary = new HashMap<>(  );


       // for(int i=0;i<countries.length;i+=2){
         //   dictionary.put (countries[i],countries[i+1]);
        //}
        readFromFile();
        ArrayAdapter countryAdapter = new ArrayAdapter<> (
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList( dictionary.keySet () )
        );

        lvcountries.setAdapter(countryAdapter);


        lvcountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String country = parent.getItemAtPosition(position).toString ();
                String capital = dictionary.get(country);

                Intent intent = new Intent ( MainActivity.this,CapitalActivity.class );
                intent.putExtra ( "meaning",capital );
                startActivity(intent);

            }
        });


    }

    private void readFromFile() {
        try {
            FileInputStream fos=openFileInput("word.text");
            InputStreamReader isr=new InputStreamReader(fos);
            BufferedReader br=new BufferedReader(isr);
            String line="";
            while ((line=br.readLine()) !=null){
                String[] parts=line.split("->");
                dictionary.put(parts[0],parts[1]);

            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
