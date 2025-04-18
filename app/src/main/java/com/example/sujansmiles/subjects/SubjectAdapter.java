package com.example.sujansmiles.subjects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sujansmiles.R;

import java.util.ArrayList;

public class SubjectAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Subject> subjectList;

    public SubjectAdapter(Context context, ArrayList<Subject> subjectList) {
        this.context = context;
        this.subjectList = subjectList;
    }

    @Override
    public int getCount() {
        return subjectList.size();
    }

    @Override
    public Subject getItem(int position) {
        return subjectList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.subject_item, parent, false);

        Subject subject = getItem(position);

        View colorView = view.findViewById(R.id.colorView);
        TextView subjectName = view.findViewById(R.id.subjectName);

        colorView.setBackgroundColor(subject.getColor());
        subjectName.setText(subject.getName());

        return view;
    }
}
