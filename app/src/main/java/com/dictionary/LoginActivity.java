package com.dictionary;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
private EditText etuser,etPass;
private Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etuser=findViewById(R.id.etuser);
        etPass=findViewById(R.id.etpass);
        btnlogin=findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckUser();
            }
        });



    }
    private void CheckUser(){
        SharedPreferences sharedPreferences=getSharedPreferences("User",MODE_PRIVATE);
        String username=sharedPreferences.getString("username","");
        String password=sharedPreferences.getString("password","");

        if (username.equals(etuser.getText().toString()) &&
        password.equals(etPass.getText().toString())
        ) {
            Toast.makeText(LoginActivity.this, "succcessful", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(LoginActivity.this, "either username or password incorrect", Toast.LENGTH_SHORT).show();
        }
    }
}
