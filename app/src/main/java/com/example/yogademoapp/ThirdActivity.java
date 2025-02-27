package com.example.yogademoapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class ThirdActivity extends AppCompatActivity {

    String buttonvalue;
    Button startBtn;
    private CountDownTimer countDownTimer;
    TextView mtextview;
    private boolean MTimeRunning;
    private long MTimeLeftinmills;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        buttonvalue = intent.getStringExtra("value");

        int intvalue = Integer.parseInt(buttonvalue);

        switch (intvalue) {
            case 1:
                setContentView(R.layout.activity_bow);
                break;
            case 2:
                setContentView(R.layout.activity_bridge);
                break;
            case 3:
                setContentView(R.layout.activity_chair);
                break;
            case 4:
                setContentView(R.layout.activity_child);
                break;
            case 5:
                setContentView(R.layout.activity_cobbler);
                break;
            case 6:
                setContentView(R.layout.activity_cow);
                break;
            case 7:
                setContentView(R.layout.activity_playji);
                break;
            case 8:
                setContentView(R.layout.activity_pauseji);
                break;
            case 9:
                setContentView(R.layout.activity_plank);
                break;
            case 10:
                setContentView(R.layout.activity_crunches);
                break;
            case 11:
                setContentView(R.layout.activity_situp);
                break;
            case 12:
                setContentView(R.layout.activity_rotation);
                break;
            case 13:
                setContentView(R.layout.activity_twisht);
                break;
            case 14:
                setContentView(R.layout.activity_windmill);
                break;
            case 15:
                setContentView(R.layout.activity_legup);
                break;
        }

        // Initialize views after setting the layout
        startBtn = findViewById(R.id.startbutton);
        mtextview = findViewById(R.id.time);

        // Check if startBtn and mtextview exist in the layout
        if (startBtn == null || mtextview == null) {
            Toast.makeText(this, "Missing startbutton or time TextView in layout for value: " + intvalue, Toast.LENGTH_LONG).show();
            return;
        }

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MTimeRunning) {
                    stopTimer();
                } else {
                    startTimer();
                }
            }
        });
    }

    private void stopTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        MTimeRunning = false;
        startBtn.setText("START");
    }

    private void startTimer() {
        try {
            String timeText = mtextview.getText().toString();
            String[] parts = timeText.split(":");
            if (parts.length != 2) {
                throw new IllegalArgumentException("Time format is incorrect. Use MM:SS");
            }

            int minutes = Integer.parseInt(parts[0]);
            int seconds = Integer.parseInt(parts[1]);

            int number = minutes * 60 + seconds;
            MTimeLeftinmills = number * 1000;

            countDownTimer = new CountDownTimer(MTimeLeftinmills, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    MTimeLeftinmills = millisUntilFinished;
                    updateTimer();
                }

                @Override
                public void onFinish() {
                    int newvalue = Integer.parseInt(buttonvalue) + 1;
                    if (newvalue > 15) {
                        newvalue = 1;
                    }
                    Intent intent = new Intent(ThirdActivity.this, ThirdActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("value", String.valueOf(newvalue));
                    startActivity(intent);
                }
            }.start();

            startBtn.setText("Pause");
            MTimeRunning = true;
        } catch (Exception e) {
            Toast.makeText(this, "Invalid time format. Use MM:SS", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateTimer() {
        int minutes = (int) (MTimeLeftinmills / 60000);
        int seconds = (int) (MTimeLeftinmills % 60000 / 1000);

        String timeLeftText = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        mtextview.setText(timeLeftText);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
