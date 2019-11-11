package com.example.teampj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Play_beat extends AppCompatActivity {

    SoundPool sp;

    ImageButton settingBtn;

    Button beat_1row_1button;
    Button beat_1row_2button;
    Button beat_1row_3button;
    Button beat_1row_4button;

    Button beat_2row_1button;
    Button beat_2row_2button;
    Button beat_2row_3button;
    Button beat_2row_4button;

    Button beat_3row_1button;
    Button beat_3row_2button;
    Button beat_3row_3button;
    Button beat_3row_4button;

    Button beat_4row_1button;
    Button beat_4row_2button;
    Button beat_4row_3button;
    Button beat_4row_4button;

    int bluebutton1,bluebutton2,bluebutton3,bluebutton4;
    int yellowbutton1,yellowbutton2,yellowbutton3,yellowbutton4;
    int orangebutton1,orangebutton2,orangebutton3,orangebutton4;
    int indigobutton1,indigobutton2,indigobutton3,indigobutton4;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_beat);
        setTitle("나라에서 허락한 유일한 마약");

        sp = new SoundPool(100, AudioManager.STREAM_MUSIC, 0);

        settingBtn = (ImageButton)findViewById(R.id.settingButton);

        beat_1row_1button = (Button)findViewById(R.id.beat_1row_1button);
        beat_1row_2button = (Button)findViewById(R.id.beat_1row_2button);
        beat_1row_3button = (Button)findViewById(R.id.beat_1row_3button);
        beat_1row_4button = (Button)findViewById(R.id.beat_1row_4button);

        beat_2row_1button = (Button)findViewById(R.id.beat_2row_1button);
        beat_2row_2button = (Button)findViewById(R.id.beat_2row_2button);
        beat_2row_3button = (Button)findViewById(R.id.beat_2row_3button);
        beat_2row_4button = (Button)findViewById(R.id.beat_2row_4button);

        beat_3row_1button = (Button)findViewById(R.id.beat_3row_1button);
        beat_3row_2button = (Button)findViewById(R.id.beat_3row_2button);
        beat_3row_3button = (Button)findViewById(R.id.beat_3row_3button);
        beat_3row_4button = (Button)findViewById(R.id.beat_3row_4button);

        beat_4row_1button = (Button)findViewById(R.id.beat_4row_1button);
        beat_4row_2button = (Button)findViewById(R.id.beat_4row_2button);
        beat_4row_3button = (Button)findViewById(R.id.beat_4row_3button);
        beat_4row_4button = (Button)findViewById(R.id.beat_4row_4button);



//        beat_1row_1button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        settingBtn.setOnClickListener(new View.OnClickListener() {  //셋팅버튼 클릭시 버튼셋팅 xml연결
            @Override
            public void onClick(View view) { //이준희꺼 넣으면 됨
                Intent intent = new Intent(getApplicationContext(),Play_beat_setting.class);
                startActivity(intent);
            }
        });





    }
}
