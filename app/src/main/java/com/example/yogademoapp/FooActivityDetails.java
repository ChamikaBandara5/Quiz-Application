package com.example.yogademoapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FooActivityDetails extends AppCompatActivity {

    TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_foo_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textView = findViewById(R.id.txt);
        String dstory =getIntent().getStringExtra("story");
        textView.setText(dstory);
    }

    public void gooback(View view){
        Intent  intent = new Intent(FooActivityDetails.this, FoodActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(FooActivityDetails.this, MainActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}