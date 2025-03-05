package com.example.sujansmiles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sujansmiles.fragments.FragmentDemoActivity;
import com.example.sujansmiles.himher.HimActivity;

public class FirstLayout extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.first_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        TextView profileNameView = findViewById(R.id.profileNameView);

        Intent intent = getIntent();
        String userName = intent.getStringExtra(Constant.USER_NAME);

        profileNameView.setText(userName);
    }

    @Override
    protected void onResume() {
        super.onResume();

        ImageButton peopleButton = findViewById(R.id.peopleButton);

        peopleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent peopleIntent = new Intent(FirstLayout.this, HimActivity.class);
                startActivity(peopleIntent);
            }
        });

        findViewById(R.id.messageButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent peopleIntent = new Intent(FirstLayout.this, FragmentDemoActivity.class);
                startActivity(peopleIntent);
            }
        });
    }
}
