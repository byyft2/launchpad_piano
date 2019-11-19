package com.example.teampj;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class Play_beat_setting_save extends AppCompatActivity {

    SoundPool sp;


    int savebtn;
    int btn1_1;

    int fill_button_index[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

    int state[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

    String gettedColor;
    int gettedIndex;

    Button beat_1row_1button,beat_1row_2button,beat_1row_3button,beat_1row_4button;
    Button beat_2row_1button,beat_2row_2button,beat_2row_3button,beat_2row_4button;
    Button beat_3row_1button,beat_3row_2button,beat_3row_3button,beat_3row_4button;
    Button beat_4row_1button,beat_4row_2button,beat_4row_3button,beat_4row_4button;

    Button insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_beat_setting_save);

        Intent intent = getIntent();
        String color = intent.getStringExtra("color");
        int index = intent.getIntExtra("index", 1);

        gettedColor = color;
        gettedIndex = index;

        insert = findViewById(R.id.play_beat_setting_save_button);

        beat_1row_1button = findViewById(R.id.beat_1row_1button);
        beat_1row_2button = findViewById(R.id.beat_1row_2button);
        beat_1row_3button = findViewById(R.id.beat_1row_3button);
        beat_1row_4button = findViewById(R.id.beat_1row_4button);

        beat_2row_1button = findViewById(R.id.beat_2row_1button);
        beat_2row_2button = findViewById(R.id.beat_2row_2button);
        beat_2row_3button = findViewById(R.id.beat_2row_3button);
        beat_2row_4button = findViewById(R.id.beat_2row_4button);

        beat_3row_1button = findViewById(R.id.beat_3row_1button);
        beat_3row_2button = findViewById(R.id.beat_3row_2button);
        beat_3row_3button = findViewById(R.id.beat_3row_3button);
        beat_3row_4button = findViewById(R.id.beat_3row_4button);

        beat_4row_1button = findViewById(R.id.beat_4row_1button);
        beat_4row_2button = findViewById(R.id.beat_4row_2button);
        beat_4row_3button = findViewById(R.id.beat_4row_3button);
        beat_4row_4button = findViewById(R.id.beat_4row_4button);

        Button[] beat_btn = {beat_1row_1button, beat_1row_2button, beat_1row_3button, beat_1row_4button,
                beat_2row_1button, beat_2row_2button, beat_2row_3button, beat_2row_4button,
                beat_3row_1button, beat_3row_2button, beat_3row_3button, beat_3row_4button,
                beat_4row_1button, beat_4row_2button, beat_4row_3button, beat_4row_4button};

        sp = new SoundPool(100, AudioManager.STREAM_MUSIC, 0);


        if (color.equals("blue")) {
            if (index % 16 == 1) {
                savebtn = R.raw.blue_1;
            }
        }


        Log.d("세이브쪽", gettedColor + " " + String.valueOf(gettedIndex));


        Intent intent1 = new Intent(getApplicationContext(), Play_beat_setting.class);
        state = intent1.getIntArrayExtra("state");
//        Log.d("스테이트받음", String.valueOf(state[0]));
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Play_beat_setting.class);
                intent.putExtra("state", state);

//               Log.d("스테이트보냄",String.valueOf(state[1]));
                startActivity(intent);
            }
        });


//        for (final Button soundPad : beat_btn) {
//            soundPad.setOnTouchListener(new View.OnTouchListener() {
//                @Override
//                public boolean onTouch(View v, MotionEvent motionEvent) {
//                    Log.d("스테이트보냄", String.valueOf(v.getTag()));
//                    return false;
//                }
//            });
//        }
    }


    public void mOnClick(View v) {
        switch (v.getId()) {
            case R.id.beat_1row_1button:
                fill_button_index[0] = 1;
                if(gettedColor.equals("blue")){
                    beat_1row_1button.setBackgroundResource(R.drawable.button_1row_style);
                }
                else if(gettedColor.equals("yellow")){
                    beat_1row_1button.setBackgroundResource(R.drawable.button_2row_style);
                }
                else if(gettedColor.equals("orange")){
                    beat_1row_1button.setBackgroundResource(R.drawable.button_3row_style);
                }
                else if(gettedColor.equals("indigo")){
                    beat_1row_1button.setBackgroundResource(R.drawable.button_4row_style);
                }
                else if(gettedColor.equals("green")){
                    beat_1row_1button.setBackgroundResource(R.drawable.button_5row_style);
                }
                break;

            case R.id.beat_1row_2button:
                if(gettedColor.equals("blue")){
                    beat_1row_2button.setBackgroundResource(R.drawable.button_1row_style);
                }
                else if(gettedColor.equals("yellow")){
                    beat_1row_2button.setBackgroundResource(R.drawable.button_2row_style);
                }
                else if(gettedColor.equals("orange")){
                    beat_1row_2button.setBackgroundResource(R.drawable.button_3row_style);
                }
                else if(gettedColor.equals("indigo")){
                    beat_1row_2button.setBackgroundResource(R.drawable.button_4row_style);
                }
                else if(gettedColor.equals("green")){
                    beat_1row_2button.setBackgroundResource(R.drawable.button_5row_style);
                }
                break;
            case R.id.beat_1row_3button:
                if(gettedColor.equals("blue")){
                    beat_1row_3button.setBackgroundResource(R.drawable.button_1row_style);
                }
                else if(gettedColor.equals("yellow")){
                    beat_1row_3button.setBackgroundResource(R.drawable.button_2row_style);
                }
                else if(gettedColor.equals("orange")){
                    beat_1row_3button.setBackgroundResource(R.drawable.button_3row_style);
                }
                else if(gettedColor.equals("indigo")){
                    beat_1row_3button.setBackgroundResource(R.drawable.button_4row_style);
                }
                else if(gettedColor.equals("green")){
                    beat_1row_3button.setBackgroundResource(R.drawable.button_5row_style);
                }
                break;
            case R.id.beat_1row_4button:
                if(gettedColor.equals("blue")){
                    beat_1row_4button.setBackgroundResource(R.drawable.button_1row_style);
                }
                else if(gettedColor.equals("yellow")){
                    beat_1row_4button.setBackgroundResource(R.drawable.button_2row_style);
                }
                else if(gettedColor.equals("orange")){
                    beat_1row_4button.setBackgroundResource(R.drawable.button_3row_style);
                }
                else if(gettedColor.equals("indigo")){
                    beat_1row_4button.setBackgroundResource(R.drawable.button_4row_style);
                }
                else if(gettedColor.equals("green")){
                    beat_1row_4button.setBackgroundResource(R.drawable.button_5row_style);
                }
                break;
            case R.id.beat_2row_1button:
                if(gettedColor.equals("blue")){
                    beat_2row_1button.setBackgroundResource(R.drawable.button_1row_style);
                }
                else if(gettedColor.equals("yellow")){
                    beat_2row_1button.setBackgroundResource(R.drawable.button_2row_style);
                }
                else if(gettedColor.equals("orange")){
                    beat_2row_1button.setBackgroundResource(R.drawable.button_3row_style);
                }
                else if(gettedColor.equals("indigo")){
                    beat_2row_1button.setBackgroundResource(R.drawable.button_4row_style);
                }
                else if(gettedColor.equals("green")){
                    beat_2row_1button.setBackgroundResource(R.drawable.button_5row_style);
                }
                break;
            case R.id.beat_2row_2button:
                if(gettedColor.equals("blue")){
                    beat_2row_2button.setBackgroundResource(R.drawable.button_1row_style);
                }
                else if(gettedColor.equals("yellow")){
                    beat_2row_2button.setBackgroundResource(R.drawable.button_2row_style);
                }
                else if(gettedColor.equals("orange")){
                    beat_2row_2button.setBackgroundResource(R.drawable.button_3row_style);
                }
                else if(gettedColor.equals("indigo")){
                    beat_2row_2button.setBackgroundResource(R.drawable.button_4row_style);
                }
                else if(gettedColor.equals("green")){
                    beat_2row_2button.setBackgroundResource(R.drawable.button_5row_style);
                }
                break;
            case R.id.beat_2row_3button:
                if(gettedColor.equals("blue")){
                    beat_2row_3button.setBackgroundResource(R.drawable.button_1row_style);
                }
                else if(gettedColor.equals("yellow")){
                    beat_2row_3button.setBackgroundResource(R.drawable.button_2row_style);
                }
                else if(gettedColor.equals("orange")){
                    beat_2row_3button.setBackgroundResource(R.drawable.button_3row_style);
                }
                else if(gettedColor.equals("indigo")){
                    beat_2row_3button.setBackgroundResource(R.drawable.button_4row_style);
                }
                else if(gettedColor.equals("green")){
                    beat_2row_3button.setBackgroundResource(R.drawable.button_5row_style);
                }
                break;
            case R.id.beat_2row_4button:
                if(gettedColor.equals("blue")){
                    beat_2row_4button.setBackgroundResource(R.drawable.button_1row_style);
                }
                else if(gettedColor.equals("yellow")){
                    beat_2row_4button.setBackgroundResource(R.drawable.button_2row_style);
                }
                else if(gettedColor.equals("orange")){
                    beat_2row_4button.setBackgroundResource(R.drawable.button_3row_style);
                }
                else if(gettedColor.equals("indigo")){
                    beat_2row_4button.setBackgroundResource(R.drawable.button_4row_style);
                }
                else if(gettedColor.equals("green")){
                    beat_2row_4button.setBackgroundResource(R.drawable.button_5row_style);
                }
                break;
            case R.id.beat_3row_1button:
                if(gettedColor.equals("blue")){
                    beat_3row_1button.setBackgroundResource(R.drawable.button_1row_style);
                }
                else if(gettedColor.equals("yellow")){
                    beat_3row_1button.setBackgroundResource(R.drawable.button_2row_style);
                }
                else if(gettedColor.equals("orange")){
                    beat_3row_1button.setBackgroundResource(R.drawable.button_3row_style);
                }
                else if(gettedColor.equals("indigo")){
                    beat_3row_1button.setBackgroundResource(R.drawable.button_4row_style);
                }
                else if(gettedColor.equals("green")){
                    beat_3row_1button.setBackgroundResource(R.drawable.button_5row_style);
                }
                break;
            case R.id.beat_3row_2button:
                if(gettedColor.equals("blue")){
                    beat_3row_2button.setBackgroundResource(R.drawable.button_1row_style);
                }
                else if(gettedColor.equals("yellow")){
                    beat_3row_2button.setBackgroundResource(R.drawable.button_2row_style);
                }
                else if(gettedColor.equals("orange")){
                    beat_3row_2button.setBackgroundResource(R.drawable.button_3row_style);
                }
                else if(gettedColor.equals("indigo")){
                    beat_3row_2button.setBackgroundResource(R.drawable.button_4row_style);
                }
                else if(gettedColor.equals("green")){
                    beat_3row_2button.setBackgroundResource(R.drawable.button_5row_style);
                }
                break;
            case R.id.beat_3row_3button:
                if(gettedColor.equals("blue")){
                    beat_3row_3button.setBackgroundResource(R.drawable.button_1row_style);
                }
                else if(gettedColor.equals("yellow")){
                    beat_3row_3button.setBackgroundResource(R.drawable.button_2row_style);
                }
                else if(gettedColor.equals("orange")){
                    beat_3row_3button.setBackgroundResource(R.drawable.button_3row_style);
                }
                else if(gettedColor.equals("indigo")){
                    beat_3row_3button.setBackgroundResource(R.drawable.button_4row_style);
                }
                else if(gettedColor.equals("green")){
                    beat_3row_3button.setBackgroundResource(R.drawable.button_5row_style);
                }
                break;
            case R.id.beat_3row_4button:
                if(gettedColor.equals("blue")){
                    beat_3row_4button.setBackgroundResource(R.drawable.button_1row_style);
                }
                else if(gettedColor.equals("yellow")){
                    beat_3row_4button.setBackgroundResource(R.drawable.button_2row_style);
                }
                else if(gettedColor.equals("orange")){
                    beat_3row_4button.setBackgroundResource(R.drawable.button_3row_style);
                }
                else if(gettedColor.equals("indigo")){
                    beat_3row_4button.setBackgroundResource(R.drawable.button_4row_style);
                }
                else if(gettedColor.equals("green")){
                    beat_3row_4button.setBackgroundResource(R.drawable.button_5row_style);
                }
                break;
            case R.id.beat_4row_1button:
                if(gettedColor.equals("blue")){
                    beat_4row_1button.setBackgroundResource(R.drawable.button_1row_style);
                }
                else if(gettedColor.equals("yellow")){
                    beat_4row_1button.setBackgroundResource(R.drawable.button_2row_style);
                }
                else if(gettedColor.equals("orange")){
                    beat_4row_1button.setBackgroundResource(R.drawable.button_3row_style);
                }
                else if(gettedColor.equals("indigo")){
                    beat_4row_1button.setBackgroundResource(R.drawable.button_4row_style);
                }
                else if(gettedColor.equals("green")){
                    beat_4row_1button.setBackgroundResource(R.drawable.button_5row_style);
                }
                break;
            case R.id.beat_4row_2button:
                if(gettedColor.equals("blue")){
                    beat_4row_2button.setBackgroundResource(R.drawable.button_1row_style);
                }
                else if(gettedColor.equals("yellow")){
                    beat_4row_2button.setBackgroundResource(R.drawable.button_2row_style);
                }
                else if(gettedColor.equals("orange")){
                    beat_4row_2button.setBackgroundResource(R.drawable.button_3row_style);
                }
                else if(gettedColor.equals("indigo")){
                    beat_4row_2button.setBackgroundResource(R.drawable.button_4row_style);
                }
                else if(gettedColor.equals("green")){
                    beat_4row_2button.setBackgroundResource(R.drawable.button_5row_style);
                }
                break;
            case R.id.beat_4row_3button:
                if(gettedColor.equals("blue")){
                    beat_4row_3button.setBackgroundResource(R.drawable.button_1row_style);
                }
                else if(gettedColor.equals("yellow")){
                    beat_4row_3button.setBackgroundResource(R.drawable.button_2row_style);
                }
                else if(gettedColor.equals("orange")){
                    beat_4row_3button.setBackgroundResource(R.drawable.button_3row_style);
                }
                else if(gettedColor.equals("indigo")){
                    beat_4row_3button.setBackgroundResource(R.drawable.button_4row_style);
                }
                else if(gettedColor.equals("green")){
                    beat_4row_3button.setBackgroundResource(R.drawable.button_5row_style);
                }
                break;
            case R.id.beat_4row_4button:
                if(gettedColor.equals("blue")){
                    beat_4row_4button.setBackgroundResource(R.drawable.button_1row_style);
                }
                else if(gettedColor.equals("yellow")){
                    beat_4row_4button.setBackgroundResource(R.drawable.button_2row_style);
                }
                else if(gettedColor.equals("orange")){
                    beat_4row_4button.setBackgroundResource(R.drawable.button_3row_style);
                }
                else if(gettedColor.equals("indigo")){
                    beat_4row_4button.setBackgroundResource(R.drawable.button_4row_style);
                }
                else if(gettedColor.equals("green")){
                    beat_4row_4button.setBackgroundResource(R.drawable.button_5row_style);
                }
                break;

        }
    }
}
