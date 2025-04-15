package com.example.sujansmiles.list_grid_recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sujansmiles.R;

import java.util.ArrayList;

class ViewHolder extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView textView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.itemImage);
        textView = itemView.findViewById(R.id.itemTitle);
    }
}

public class RecyclerItemAdapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<Item> items;

    public RecyclerItemAdapter(ArrayList<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = this.items.get(position);

        holder.imageView.setImageResource(item.getImageResource());
        holder.textView.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }
}
