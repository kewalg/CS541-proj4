package com.example.myshoppingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    int[] images = {
            R.drawable.blank, R.drawable.milk, R.drawable.chicken, R.drawable.bread, R.drawable.egg, R.drawable.broccoli, R.drawable.fish,
            R.drawable.blank, R.drawable.tv, R.drawable.laptop, R.drawable.blank, R.drawable.speaker, R.drawable.wires, R.drawable.monitor,
            R.drawable.blank, R.drawable.tshirt, R.drawable.shirt, R.drawable.trousers, R.drawable.sweater, R.drawable.lifejacket, R.drawable.swimsuit};

    private Context context;
    public static ArrayList<Model> modelArrayList;


    public CustomAdapter(Context context, ArrayList<Model> modelArrayList) {

        this.context = context;
        this.modelArrayList = modelArrayList;

    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public int getCount() {
        return modelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return modelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_layout, null, true);

            holder.checkBox = (CheckBox) convertView.findViewById(R.id.cb);
            holder.tvAnimal = (TextView) convertView.findViewById(R.id.animal);
            holder.images = (ImageView) convertView.findViewById(R.id.images);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        holder.tvAnimal.setText(modelArrayList.get(position).getFoods());
        holder.images.setImageResource(images[position]);
        holder.checkBox.setChecked(modelArrayList.get(position).getSelected());
        holder.checkBox.setTag(R.integer.btnplusview, convertView);
        holder.checkBox.setTag(position);
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View tempview = (View) holder.checkBox.getTag(R.integer.btnplusview);
                TextView tv = (TextView) tempview.findViewById(R.id.animal);
                Integer pos = (Integer) holder.checkBox.getTag();

                if (modelArrayList.get(pos).getSelected()) {
                    modelArrayList.get(pos).setSelected(false);
                } else {
                    modelArrayList.get(pos).setSelected(true);
                }

            }
        });

        return convertView;
    }

    private class ViewHolder {

        protected CheckBox checkBox;
        private TextView tvAnimal;
        private ImageView images;

    }

}