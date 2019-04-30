package com.dictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class CapitalActivity extends AppCompatActivity {

        TextView tvcapital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capital);

        tvcapital = findViewById ( R.id.tvcapital );

        Bundle bundle = getIntent ().getExtras ();


        if(bundle!=null){
            String meaning = bundle.getString ( "meaning" );

            tvcapital.setText ( meaning );
        }
//        else {
//            Toast.makeText ( this,
//                    "New Meaning",
//                    Toast.LENGTH_LONG).show ();
//        }


    }
}
