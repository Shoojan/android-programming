package com.example.sujansmiles.list_grid_recycler;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sujansmiles.R;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_recyclerview,container,false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        //Prepare DataSource
        ArrayList<Item> list = new ArrayList<>();
        list.add(new Item(R.drawable.profile_image, "This is me."));
        list.add(new Item(R.drawable.her, "My Girlfriend"));
        list.add(new Item(R.drawable.him, "Her Ex"));
        list.add(new Item(R.drawable.post_profile_image, "Her Father"));

        //Set Layout Manager
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        //Initialize an Adapter
        RecyclerItemAdapter itemAdapter = new RecyclerItemAdapter(list);

        //Set the adapter
        recyclerView.setAdapter(itemAdapter);

        return view;
    }
}
