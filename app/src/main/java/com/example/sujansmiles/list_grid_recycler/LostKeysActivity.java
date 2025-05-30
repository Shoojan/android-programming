package com.example.sujansmiles.list_grid_recycler;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.sujansmiles.R;

public class LostKeysActivity extends AppCompatActivity {

    Button listViewButton, gridViewButton, recyclerViewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lost_keys);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listViewButton = findViewById(R.id.listViewButton);
        gridViewButton = findViewById(R.id.gridViewButton);
        recyclerViewButton = findViewById(R.id.recyclerViewButton);
    }

    @Override
    protected void onResume() {
        super.onResume();

        this.registerFragmentOnButtonClick(listViewButton, new ListViewFragment());
        this.registerFragmentOnButtonClick(gridViewButton, new GridViewFragment());
        this.registerFragmentOnButtonClick(recyclerViewButton, new RecyclerViewFragment());
    }

    private void registerFragmentOnButtonClick(View view, Fragment fragment) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainerView, fragment)
                        .commit();
            }
        });
    }
}