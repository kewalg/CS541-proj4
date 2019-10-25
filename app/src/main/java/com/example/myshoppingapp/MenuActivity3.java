package com.example.myshoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class MenuActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu3);

        ListView lv_food = findViewById(R.id.lv_groceries);
        ArrayList<String> fooditems = new ArrayList<String>(asList("Chicken", "Milk", "Eggs", "Bread"));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fooditems);
        lv_food.setAdapter(arrayAdapter);

        ListView lv_clothes = findViewById(R.id.lv_clothes);
        ArrayList<String> clothitems = new ArrayList<String>(asList("Shirts", "Tshirts", "Jeans", "Joggers"));
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, clothitems);
        lv_clothes.setAdapter(arrayAdapter1);

        ListView lv_electronics = findViewById(R.id.lv_electronics);
        ArrayList<String> electronicitems = new ArrayList<String>(asList("Laptops", "Mobiles", "Earphones", "Speakers"));
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, electronicitems);
        lv_electronics.setAdapter(arrayAdapter2);

    }
}
