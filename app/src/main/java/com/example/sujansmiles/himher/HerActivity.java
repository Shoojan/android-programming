package com.example.sujansmiles.himher;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sujansmiles.Constant;
import com.example.sujansmiles.R;

public class HerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_her);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.her), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent giftIntent = getIntent();
        String gift = giftIntent.getStringExtra(Constant.GIFT);

        if(gift == null){
            Toast.makeText(HerActivity.this, "Sorry! No gift for you. ", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(HerActivity.this, "Recevied \uD83C\uDF81: " + gift, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        EditText responseEditText = findViewById(R.id.giftResponseEditText);
        Button sendGiftResponseBtn = findViewById(R.id.sendGiftResponseBtn);

        sendGiftResponseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String response = responseEditText.getText().toString();

                Intent responseIntent = new Intent();

                responseIntent.putExtra(Constant.GIFT_RESPONSE,response);

                setResult(RESULT_OK, responseIntent);

                finish(); // Ends HerActivity and returns back to HimActivity
            }
        });

    }
}