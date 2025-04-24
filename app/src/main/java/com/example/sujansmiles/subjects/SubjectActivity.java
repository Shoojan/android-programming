package com.example.sujansmiles.subjects;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sujansmiles.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import yuku.ambilwarna.AmbilWarnaDialog;

public class SubjectActivity extends AppCompatActivity {

    ArrayList<Subject> list;
    ListView listView;
    SubjectAdapter subjectAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_subject);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        list = new ArrayList<>();

        listView = findViewById(R.id.listView);
        subjectAdapter = new SubjectAdapter(this, list);
        listView.setAdapter(subjectAdapter);

        FloatingActionButton addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1. Show Custom Dialog
                showCustomDialog();
            }
        });
    }

    private void showCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SubjectActivity.this);

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.subject_dialog, null);
        builder.setView(view);

        EditText nameEditText = view.findViewById(R.id.nameEditText);
        Button colorButton = view.findViewById(R.id.colorButton);

        Subject subject = new Subject();

        colorButton.setOnClickListener(v1 -> pickColor(subject, v1));

        builder.setPositiveButton("Save", (dialog, which) -> {
            subject.setName(nameEditText.getText().toString());
            list.add(subject);
            subjectAdapter.notifyDataSetChanged();
        });

        builder.setNegativeButton("Cancel", null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void pickColor(Subject subject, View colorButton) {
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(
                SubjectActivity.this,
                subject.getColor(),
                new AmbilWarnaDialog.OnAmbilWarnaListener() {
                    @Override
                    public void onCancel(AmbilWarnaDialog dialog) {
                    }

                    @Override
                    public void onOk(AmbilWarnaDialog dialog, int color) {
                        subject.setColor(color);
                        colorButton.setBackgroundColor(color);
                    }
                }
        );
        colorPicker.show();
    }
}