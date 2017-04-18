package com.example.hp.sharedpreferencesdemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edtName,edtPassword;
    private Button btnSave,btnNext;
    private String name,password;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName= (EditText) findViewById(R.id.edtName);
        edtPassword= (EditText) findViewById(R.id.edtPassword);
        btnSave= (Button) findViewById(R.id.btnSave);
        btnNext= (Button) findViewById(R.id.btnNext);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = edtName.getText().toString().trim();
                password = edtPassword.getText().toString().trim();

                sharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();

                editor.putString("name_key", name);
                editor.putString("password_key", password);
                editor.commit();
            }});

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });



    }
}
