package com.example.yogademoapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity2 extends AppCompatActivity {

    int[] newArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);


        newArray = new int[]{

                R.id.bow_pose,R.id.bridge_pose,R.id.chair_pose,R.id.cobbler_pose,R.id.cow_pose,R.id.playji_pose,R.id.pauseji_pose,R.id.plankji_pose,R.id.crunches_pose,R.id.situp_pose,R.id.rotation_pose,R.id.twisht_pose,R.id.windmill_pose,R.id.legup_pose,


        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.id_privacy) {

            return true;
        }

        if (id == R.id.id_term) {

            return true;

        }
        if (id == R.id.id_rate) {

            return true;
        }

        if (id == R.id.id_more) {

            return true;
        }

        if (id == R.id.id_share) {

            return true;
        }
        return false;
    }

    public void Imagebuttonclick(View view) {

        for(int i=0;i< newArray.length;i++){

            if(view.getId() == newArray[i]){
                int value = i+1;
                Log.i("FIRST",String.valueOf(value));
                Intent intent = new Intent(SecondActivity2.this,ThirdActivity2.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);
            }
        }
    }
}