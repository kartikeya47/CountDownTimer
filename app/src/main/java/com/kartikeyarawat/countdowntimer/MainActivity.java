package com.kartikeyarawat.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtTimer; //UI Variables Declared
    TextView txtTimerElapsed;
    Button btnReset;
    TextView countDownCompleted;

    private final long startTime = 50 * 1000; //50000 ms or 5 sec
    private final long interval = 1000; //1000 ms or 1 sec


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTimer = findViewById(R.id.txt_timer);
        txtTimerElapsed = findViewById(R.id.txt_time_elapsed);
        btnReset = findViewById(R.id.btn_reset);
        countDownCompleted = findViewById(R.id.txt_time_completion_indication);

        CountDownTimer countDownTimer = new CountDownTimer(startTime, interval) {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long millisUntilFinished) {
                txtTimer.setText("Time: " + millisUntilFinished / 1000);
                txtTimerElapsed.setText("Time elapsed: " + (startTime - millisUntilFinished) / 1000);
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onFinish() {
                countDownCompleted.setText("Countdown Completed");

            }
        };

        countDownTimer.start();

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                countDownTimer.cancel();
                countDownTimer.start();
            }
        });

    }
}