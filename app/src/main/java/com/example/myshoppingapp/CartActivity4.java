package com.example.myshoppingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CartActivity4 extends AppCompatActivity {

    private TextView tv;
    Button btnclear, btnmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart4);

        tv = (TextView) findViewById(R.id.tv);
        btnclear = (Button) findViewById(R.id.btn_clearcart);
        btnmenu = (Button) findViewById(R.id.btn_menu);


        for (int i = 0; i < CustomAdapter.modelArrayList.size(); i++) {
            if (CustomAdapter.modelArrayList.get(i).getSelected()) {
                //tv.setText(tv.getText() + "," + CustomAdapter.modelArrayList.get(i).getFoods());
                tv.setText(tv.getText() + "\n" + CustomAdapter.modelArrayList.get(i).getFoods());
            }
        }

        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("Cart Empty!");
                Toast.makeText(CartActivity4.this, "Cart Cleared!", Toast.LENGTH_SHORT).show();
            }
        });

        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CartActivity4.this, MenuActivity3.class);
                startActivity(i);
            }
        });
    }
}