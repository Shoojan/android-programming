package com.example.sujansmiles.list_grid_recycler;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sujansmiles.Constant;
import com.example.sujansmiles.R;

import java.util.ArrayList;

public class ListViewFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_listview, container, false);

        ListView listView = view.findViewById(R.id.listView);

        // Simple Approach of display list of strings in ListView
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
//                getContext(),
//                android.R.layout.simple_list_item_1,
//                Constant.LOST_ITEMS
//        );
//
//        listView.setAdapter(arrayAdapter);


        //Customized Approach
        //1. Prepare the data source
        ArrayList<Item> list = new ArrayList<>();
        list.add(new Item(R.drawable.profile_image, "This is me."));
        list.add(new Item(R.drawable.her, "My Girlfriend"));
        list.add(new Item(R.drawable.him, "Her Ex"));
        list.add(new Item(R.drawable.post_profile_image, "Her Father"));

        ItemAdapter itemAdapter = new ItemAdapter(getContext(), list);
        listView.setAdapter(itemAdapter);

        return view;
    }
}
