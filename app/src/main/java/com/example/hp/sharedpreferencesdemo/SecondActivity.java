package com.example.hp.sharedpreferencesdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView txtName,txtPassword;
    private Button btnLoad;
    private String name,password;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtName= (TextView) findViewById(R.id.txtName);
        txtPassword= (TextView) findViewById(R.id.txtPassword);
        btnLoad= (Button) findViewById(R.id.btnLoad);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences=getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                name=sharedPreferences.getString("name_key",null);
                password=sharedPreferences.getString("password_key",null);

                txtName.setText(name);
                txtPassword.setText(password);

            }
        });

    }
}
