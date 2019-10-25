package com.example.myshoppingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static java.util.Arrays.asList;

public class MenuActivity3 extends AppCompatActivity {

    ListView lv_groceries;
    String[] grocerieslist = {"Chicken", "Milk", "Eggs", "Bread", "Broccoli", "Peas", "Peanuts", "Mix Veggies", "Pizza", "Salmon", "Ground Beef", "Talapia"};
    int[] images = {R.drawable.turkey, R.drawable.broccoli, R.drawable.fish, R.drawable.milk};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu3);
        lv_groceries = findViewById(R.id.lv_groceries);

        CustomAdapter customAdapter = new CustomAdapter();
        lv_groceries.setAdapter(customAdapter);

    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.listview_layout, null);
            ImageView image = view.findViewById(R.id.img_row);
            TextView txt = view.findViewById(R.id.txt_row);

            image.setImageResource(images[position]);
            txt.setText(grocerieslist[position]);
            return view;
        }
    }
}
