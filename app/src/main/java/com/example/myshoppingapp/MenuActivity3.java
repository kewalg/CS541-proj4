package com.example.myshoppingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myshoppingapp.CustomAdapter;
import com.example.myshoppingapp.Model;
import com.example.myshoppingapp.R;

import java.util.ArrayList;

public class MenuActivity3 extends AppCompatActivity {

    private ListView lv;
    private ArrayList<Model> modelArrayList;
    private CustomAdapter customAdapter;
    private Button btnselect, btndeselect, btnnext, btncart;
    private String[] food_items = new String[]{
            "Food Items:", "Milk", "Chicken", "Bread", "Eggs", "Broccoli", "Salmon",
            "Electronics Items:", "TV", "Laptop", "Mobile", "Speakers", "Peripherals", "Monitors",
            "Clothing Items:", "T-Shirts", "Shirts", "Jeans", "KnitWear", "Jackets", "Inners"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu3);

        lv = (ListView) findViewById(R.id.lv);
        btncart = (Button) findViewById(R.id.cart_btn);
        btnnext = (Button) findViewById(R.id.next);

        modelArrayList = getModel(false);
        customAdapter = new CustomAdapter(this, modelArrayList);
        lv.setAdapter(customAdapter);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity3.this, CartActivity4.class);
                startActivity(intent);
            }
        });

        btncart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity3.this, CartActivity4.class);
                startActivity(i);
            }
        });
    }

    private ArrayList<Model> getModel(boolean isSelect) {
        ArrayList<Model> list = new ArrayList<>();
        for (int i = 0; i < 21; i++) {

            Model model = new Model();
            model.setSelected(isSelect);
            model.setFood(food_items[i]);
            list.add(model);
        }
        return list;
    }

}