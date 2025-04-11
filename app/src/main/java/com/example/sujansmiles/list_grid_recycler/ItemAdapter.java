package com.example.sujansmiles.list_grid_recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sujansmiles.R;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Item> items;

    public ItemAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Item getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getImageResource();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.item_view, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.itemImage);
        TextView textView = convertView.findViewById(R.id.itemTitle);

        Item item = getItem(position);

        imageView.setImageResource(item.getImageResource());
        textView.setText(item.getTitle());

        return convertView;
    }
}
