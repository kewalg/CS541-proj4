package com.example.myshoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edtuser = findViewById(R.id.edtusername);
        final EditText edtpass = findViewById(R.id.edtpassword);
        Button submitbtn = findViewById(R.id.btnsubmit);
        Button registerbtn = findViewById(R.id.btnregister);

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edtuser.getText().toString().equals("kewalg" )&& edtpass.getText().toString().equals("1234")){

                    Intent i = new Intent(MainActivity.this, MenuActivity2.class);
                    startActivity(i);
                }
            }
        });
    }
}
