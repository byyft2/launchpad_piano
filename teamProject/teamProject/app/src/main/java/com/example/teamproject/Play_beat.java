package com.example.teamproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

import static android.widget.Toast.makeText;

public class Play_beat extends AppCompatActivity {


    public void permissionCheck() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO, Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||  ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
    }
    SoundPool sp;

    ImageButton settingBtn;

    Button record_button;
    Button load_button;
    ImageButton play_button;
    ImageButton pause_button;
    ImageButton stop_button;
    String[] soundPath;

    int[] save_loaded_sound = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};


    int position;
    MediaRecorder recorder;
    boolean recording = false, pausing = false, playing = false;
    File sdcard, file;
    String filename =null, input_filename;
    View dialogView;
    EditText input_name;
    MediaPlayer player;

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

    int blue_sound1,blue_sound2,blue_sound3,blue_sound4,blue_sound5,blue_sound6,blue_sound7,blue_sound8,blue_sound9,blue_sound10,blue_sound11,blue_sound12,blue_sound13
            ,blue_sound14,blue_sound15,blue_sound16;
    int yellow_sound1,yellow_sound2,yellow_sound3,yellow_sound4,yellow_sound5,yellow_sound6,yellow_sound7,yellow_sound8,yellow_sound9,yellow_sound10,yellow_sound11,yellow_sound12,yellow_sound13
            ,yellow_sound14,yellow_sound15,yellow_sound16;
    int orange_sound1,orange_sound2,orange_sound3,orange_sound4,orange_sound5,orange_sound6,orange_sound7,orange_sound8,orange_sound9,orange_sound10,orange_sound11,orange_sound12,orange_sound13
            ,orange_sound14,orange_sound15,orange_sound16;
    int indigo_sound1,indigo_sound2,indigo_sound3,indigo_sound4,indigo_sound5,indigo_sound6,indigo_sound7,indigo_sound8,indigo_sound9,indigo_sound10,indigo_sound11,indigo_sound12,
            indigo_sound13,indigo_sound14,indigo_sound15,indigo_sound16;

    int green_sound1,green_sound2,green_sound3,green_sound4,green_sound5,green_sound6,green_sound7,green_sound8,
            green_sound9,green_sound10,green_sound11,green_sound12,green_sound13,green_sound14,green_sound15,green_sound16;

    int[] green_sounds = {green_sound1,green_sound2,green_sound3,green_sound4,green_sound5,green_sound6,green_sound7,green_sound8,
            green_sound9,green_sound10,green_sound11,green_sound12,green_sound13,green_sound14,green_sound15,green_sound16};

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_beat);
        permissionCheck();
        sp = new SoundPool(100, AudioManager.STREAM_MUSIC, 0);
        blue_sound1 = sp.load(getApplicationContext(), R.raw.blue_1, 1);
        blue_sound2 = sp.load(getApplicationContext(), R.raw.blue_kick1, 1);
        blue_sound3 = sp.load(getApplicationContext(), R.raw.blue_kicka, 1);
        blue_sound4 = sp.load(getApplicationContext(), R.raw.blue_singlekick, 1);
        blue_sound5 = sp.load(getApplicationContext(), R.raw.blue_loosekik, 1);
        blue_sound6 = sp.load(getApplicationContext(), R.raw.blue_electronicsound, 1);
        blue_sound7 = sp.load(getApplicationContext(), R.raw.blue_dynohlsn, 1);
        blue_sound8 = sp.load(getApplicationContext(), R.raw.blue_dirtysnaredrum, 1);
        blue_sound9 = sp.load(getApplicationContext(), R.raw.blue_djembedrum, 1);
        blue_sound10 = sp.load(getApplicationContext(), R.raw.blue_heavykick, 1);
        blue_sound11 = sp.load(getApplicationContext(), R.raw.blue_what, 1);
        blue_sound12 = sp.load(getApplicationContext(), R.raw.blue_djembe, 1);
        blue_sound13 = sp.load(getApplicationContext(), R.raw.blue_drumone, 1);
        blue_sound14 = sp.load(getApplicationContext(), R.raw.blue_dnbloop, 1);
        blue_sound15 = sp.load(getApplicationContext(), R.raw.blue_loop17, 1);
        blue_sound16 = sp.load(getApplicationContext(), R.raw.blue_foetus, 1);

        yellow_sound1 = sp.load(getApplicationContext(), R.raw.yellow_short1, 1);
        yellow_sound2 = sp.load(getApplicationContext(), R.raw.yellow_short2, 1);
        yellow_sound3 = sp.load(getApplicationContext(), R.raw.yellow_short3, 1);
        yellow_sound4 = sp.load(getApplicationContext(), R.raw.yellow_short4, 1);
        yellow_sound5 = sp.load(getApplicationContext(), R.raw.yellow_short5, 1);
        yellow_sound6 = sp.load(getApplicationContext(), R.raw.yellow_short6, 1);
        yellow_sound7 = sp.load(getApplicationContext(), R.raw.yellow_short7, 1);
        yellow_sound8 = sp.load(getApplicationContext(), R.raw.yellow_mid1, 1);
        yellow_sound9 = sp.load(getApplicationContext(), R.raw.yellow_mid2, 1);
        yellow_sound10 = sp.load(getApplicationContext(), R.raw.yellow_mid3, 1);
        yellow_sound11 = sp.load(getApplicationContext(), R.raw.yellow_mid4, 1);
        yellow_sound12 = sp.load(getApplicationContext(), R.raw.yellow_long1, 1);
        yellow_sound13 = sp.load(getApplicationContext(), R.raw.yellow_long2, 1);
        yellow_sound14 = sp.load(getApplicationContext(), R.raw.yellow_long3, 1);
        yellow_sound15 = sp.load(getApplicationContext(), R.raw.yellow_long4, 1);
        yellow_sound16 = sp.load(getApplicationContext(), R.raw.yellow_long5, 1);

        orange_sound1 = sp.load(getApplicationContext(), R.raw.orange_short, 1);
        orange_sound2 = sp.load(getApplicationContext(), R.raw.orange_gun, 1);
        orange_sound3 = sp.load(getApplicationContext(), R.raw.orange_bomb, 1);
        orange_sound4 = sp.load(getApplicationContext(), R.raw.orange_man, 1);
        orange_sound5 = sp.load(getApplicationContext(), R.raw.orange_piri, 1);
        orange_sound6 = sp.load(getApplicationContext(), R.raw.orange_dragon, 1);
        orange_sound7 = sp.load(getApplicationContext(), R.raw.orange_zombie, 1);
        orange_sound8 = sp.load(getApplicationContext(), R.raw.orange_mid1, 1);
        orange_sound9 = sp.load(getApplicationContext(), R.raw.orange_mid2, 1);
        orange_sound10 = sp.load(getApplicationContext(), R.raw.orange_thrill, 1);
        orange_sound11 = sp.load(getApplicationContext(), R.raw.orange_thrill2, 1);
        orange_sound12 = sp.load(getApplicationContext(), R.raw.orange_horn, 1);
        orange_sound13 = sp.load(getApplicationContext(), R.raw.orange_guitar, 1);
        orange_sound14 = sp.load(getApplicationContext(), R.raw.orange_long1, 1);
        orange_sound15 = sp.load(getApplicationContext(), R.raw.orange_long2, 1);
        orange_sound16 = sp.load(getApplicationContext(), R.raw.orange_long3, 1);

        indigo_sound1 = sp.load(getApplicationContext(), R.raw.dubstep_low1, 1);
        indigo_sound2 = sp.load(getApplicationContext(), R.raw.dubstep_low2, 1);
        indigo_sound3 = sp.load(getApplicationContext(), R.raw.dubstep_low3, 1);
        indigo_sound4 = sp.load(getApplicationContext(), R.raw.dubstep_voice, 1);
        indigo_sound5 = sp.load(getApplicationContext(), R.raw.dubstep_mid1, 1);
        indigo_sound6 = sp.load(getApplicationContext(), R.raw.dubstep_mid_2, 1);
        indigo_sound7 = sp.load(getApplicationContext(), R.raw.dubstep_mid3, 1);
        indigo_sound8 = sp.load(getApplicationContext(), R.raw.dubstep_high1, 1);
        indigo_sound9 = sp.load(getApplicationContext(), R.raw.dubstep_high2, 1);
        indigo_sound10 = sp.load(getApplicationContext(), R.raw.dubstep_high3, 1);
        indigo_sound11 = sp.load(getApplicationContext(), R.raw.dubstep_high4, 1);
        indigo_sound12 = sp.load(getApplicationContext(), R.raw.dubstep_high5, 1);
        indigo_sound13 = sp.load(getApplicationContext(), R.raw.dubstep_long1, 1);
        indigo_sound14 = sp.load(getApplicationContext(), R.raw.dubstep_long2, 1);
        indigo_sound15 = sp.load(getApplicationContext(), R.raw.dubstep_long3, 1);
        indigo_sound16 = sp.load(getApplicationContext(), R.raw.dubstep_long4, 1);


        Intent intent = getIntent();

        Intent what_intent = getIntent();
        int came_from_setting = intent.getIntExtra("go_from_setting",-1);

        if(came_from_setting == -1){

        }

        else if(came_from_setting == 500) {
            soundPath = intent.getStringArrayExtra("saveGreenSoundPath");

            for (int i = 0; i < 16; i++) {
                if(soundPath[i].equals("no")){
                    green_sounds[i]=sp.load(this, R.raw.nono156,1);
                }
                else if(!soundPath[i].equals("no")) {
                    green_sounds[i] = sp.load(soundPath[i], 1);
                }
            }
        }

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

        record_button = findViewById(R.id.recordButton);

        record_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(recording == false) {
                    closePlayer();
                    recording = true;
                    dialogView = (View) View.inflate(Play_beat.this, R.layout.filename_input, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(Play_beat.this);
                    dlg.setTitle("파일 이름 설정");
                    dlg.setView(dialogView);
                    dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            input_name = (EditText) dialogView.findViewById(R.id.input_name);
                            sdcard = Environment.getExternalStorageDirectory();
                            input_filename = String.format("%s.mp4", input_name.getText().toString());
                            file = new File(sdcard, input_filename);
                            filename = file.getAbsolutePath();
                            setFilename(filename);
                            Log.d("Play_beat_setting_record", "저장할 파일 명 : " + filename);
                            recordAudio();
                            record_button.setBackgroundResource(R.mipmap.ic_stop_record_red_foreground);

                        }
                    });
                    dlg.setNegativeButton("취소",     new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            recording = false;
                        }
                    });
                    dlg.show();
                }
                else {
                    recording = false;
                    stopRecording();
                    record_button.setBackgroundResource(R.mipmap.ic_record_red_foreground);
                }
            }
        });

        play_button = findViewById(R.id.playButton);

        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent get_intent = getIntent();
                if(get_intent.getIntExtra("beat_check",-1) != -1) {
                    filename = get_intent.getStringExtra("piano_file_path");
                }
                if(playing == false)
                {
                    if(player != null)
                    {
                        player.start();
                        playing = true;

                        pausing = false;
                        play_button.setBackgroundResource(R.mipmap.ic_pause_blue_foreground);
                    }
                    else {
                        playAudio();
                        playing = true;
                        pausing = false;
                        play_button.setBackgroundResource(R.mipmap.ic_pause_blue_foreground);
                    }
                }
                else
                {
                    if(pausing == false) {
                        if (player != null) {
                            pauseAudio();
                            pausing = true;
                            play_button.setBackgroundResource(R.mipmap.ic_pause_blue_foreground);
                        }
                    }
                    else
                    {
                        if(player != null)
                        {
                            resumeAudio();
                            pausing = false;
                            play_button.setBackgroundResource(R.mipmap.ic_pause_blue_foreground);
                        }
                    }
                }
            }
        });

        stop_button = findViewById(R.id.stopButton);
        stop_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAudio();
                play_button.setBackgroundResource(R.mipmap.ic_play_blue_foreground);
                playing = false;
            }
        });

        load_button = findViewById(R.id.selectMusicbutton);
        load_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Play_beat_setting_load.class);
                intent.putExtra("signal1",150);
                intent.putExtra("signal","빽");
                intent.putExtra("into_the_unknown",save_loaded_sound);
                intent.putExtra("atohalen",soundPath);

                startActivity(intent);
            }
        });

        Button[] beat_buttons = {beat_1row_1button,beat_1row_2button,beat_1row_3button,beat_1row_4button,
                beat_2row_1button,beat_2row_2button,beat_2row_3button,beat_2row_4button,
                beat_3row_1button,beat_3row_2button,beat_3row_3button,beat_3row_4button,
                beat_4row_1button,beat_4row_2button,beat_4row_3button,beat_4row_4button};

        Intent into_the_unknown = getIntent();
        int load_count=0;
        if(into_the_unknown.getIntArrayExtra("show_yourself") != null) {
            save_loaded_sound = into_the_unknown.getIntArrayExtra("show_yourself");

            soundPath = intent.getStringArrayExtra("atohalenn");

            for (int i = 0; i < 16; i++) {
                if(soundPath[i].equals("no")){
                    green_sounds[i]=sp.load(this, R.raw.nono156,1);
                }
                else if(!soundPath[i].equals("no")) {
                    green_sounds[i] = sp.load(soundPath[i], 1);
                }
            }

            int count = 0;
            for (int i = 0; i < 16; i++) {
                if (save_loaded_sound[i] == 0) {
                    count++;
                }
            }

            load_count=count;

            if (count < 16) {
                for(int i=0; i<16; i++) {
                    if (save_loaded_sound[i] > 64) {
                        beat_buttons[i].setBackgroundResource(R.drawable.button_5row_style);
                    } else if (save_loaded_sound[i] < 65 && save_loaded_sound[i] > 48) {
                        beat_buttons[i].setBackgroundResource(R.drawable.button_4row_style);
                    } else if (save_loaded_sound[i] < 49 && save_loaded_sound[i] > 32) {
                        beat_buttons[i].setBackgroundResource(R.drawable.button_3row_style);
                    } else if (save_loaded_sound[i] < 33 && save_loaded_sound[i] > 16) {
                        beat_buttons[i].setBackgroundResource(R.drawable.button_2row_style);
                    } else if (save_loaded_sound[i] < 17 && save_loaded_sound[i] > 0) {
                        beat_buttons[i].setBackgroundResource(R.drawable.button_1row_style);
                    } else {
                        beat_buttons[i].setBackgroundResource(R.drawable.no_select_style_blue);
                    }

                }
                bluebutton1 = save_loaded_sound[0];
                bluebutton2 = save_loaded_sound[1];
                bluebutton3 = save_loaded_sound[2];
                bluebutton4 = save_loaded_sound[3];

                yellowbutton1 = save_loaded_sound[4];
                yellowbutton2 = save_loaded_sound[5];
                yellowbutton3 = save_loaded_sound[6];
                yellowbutton4 = save_loaded_sound[7];

                orangebutton1 = save_loaded_sound[8];
                orangebutton2 = save_loaded_sound[9];
                orangebutton3 = save_loaded_sound[10];
                orangebutton4 = save_loaded_sound[11];

                indigobutton1 = save_loaded_sound[12];
                indigobutton2 = save_loaded_sound[13];
                indigobutton3 = save_loaded_sound[14];
                indigobutton4 = save_loaded_sound[15];

                Log.d("아아~아아~",String.valueOf(save_loaded_sound[0])+" "+String.valueOf(save_loaded_sound[1]));
            } else if (count == 16) {
            }
        }
        if(intent.getIntArrayExtra("sound1234") == null && (load_count == 16 || load_count ==0)){

            bluebutton1 = sp.load(getApplicationContext(), R.raw.blue_kick1, 1);
            bluebutton2 = sp.load(getApplicationContext(), R.raw.blue_electronicsound, 1);
            bluebutton3 = sp.load(getApplicationContext(), R.raw.blue_dynohlsn, 1);
            bluebutton4 = sp.load(getApplicationContext(), R.raw.blue_1, 1);

            yellowbutton1 = sp.load(getApplicationContext(), R.raw.yellow_short2, 1);
            yellowbutton2 = sp.load(getApplicationContext(), R.raw.yellow_short3, 1);
            yellowbutton3 = sp.load(getApplicationContext(), R.raw.yellow_mid1, 1);
            yellowbutton4 = sp.load(getApplicationContext(), R.raw.yellow_mid3, 1);

            orangebutton1 = sp.load(getApplicationContext(), R.raw.orange_piri, 1);
            orangebutton2 = sp.load(getApplicationContext(), R.raw.orange_mid2, 1);
            orangebutton3 = sp.load(getApplicationContext(), R.raw.orange_thrill2, 1);
            orangebutton4 = sp.load(getApplicationContext(), R.raw.orange_guitar, 1);

            indigobutton1 = sp.load(getApplicationContext(), R.raw.dubstep_voice, 1);
            indigobutton2 = sp.load(getApplicationContext(), R.raw.dubstep_low1, 1);
            indigobutton3 = sp.load(getApplicationContext(), R.raw.dubstep_mid_2, 1);
            indigobutton4 = sp.load(getApplicationContext(), R.raw.dubstep_high2, 1);

        }

        else if(intent.getIntArrayExtra("sound1234") != null){
            int[] soundbuttons = {bluebutton1,bluebutton2,bluebutton3,bluebutton4,yellowbutton1,yellowbutton2,yellowbutton3,yellowbutton4,
                    orangebutton1,orangebutton2,orangebutton3,orangebutton4,indigobutton1,indigobutton2,indigobutton3,indigobutton4};
            int[] loaded_sound = intent.getIntArrayExtra("sound1234");
            save_loaded_sound = loaded_sound;
            for(int i=0; i<16; i++){

//                if(loaded_sound[i] > 64){
//                    beat_buttons[i].setBackgroundResource(R.drawable.button_5row_style);
//                }
//                else if(loaded_sound[i] < 65 && loaded_sound[i] > 48){
//                    beat_buttons[i].setBackgroundResource(R.drawable.button_4row_style);
//                }
//                else if(loaded_sound[i] < 49 && loaded_sound[i] > 32){
//                    beat_buttons[i].setBackgroundResource(R.drawable.button_3row_style);
//                }
//                else if(loaded_sound[i] < 33 && loaded_sound[i] > 16){
//                    beat_buttons[i].setBackgroundResource(R.drawable.button_2row_style);
//                }
//                else if(loaded_sound[i] < 17 && loaded_sound[i] > 0){
//                    beat_buttons[i].setBackgroundResource(R.drawable.button_1row_style);
//                }
//                else{
//                    beat_buttons[i].setBackgroundResource(R.drawable.no_select_style_blue);
//                }
                if(save_loaded_sound[i] > 64){
                    beat_buttons[i].setBackgroundResource(R.drawable.button_5row_style);
                }
                else if(save_loaded_sound[i] < 65 && save_loaded_sound[i] > 48){
                    beat_buttons[i].setBackgroundResource(R.drawable.button_4row_style);
                }
                else if(save_loaded_sound[i] < 49 && save_loaded_sound[i] > 32){
                    beat_buttons[i].setBackgroundResource(R.drawable.button_3row_style);
                }
                else if(save_loaded_sound[i] < 33 && save_loaded_sound[i] > 16){
                    beat_buttons[i].setBackgroundResource(R.drawable.button_2row_style);
                }
                else if(save_loaded_sound[i] < 17 && save_loaded_sound[i] > 0){
                    beat_buttons[i].setBackgroundResource(R.drawable.button_1row_style);
                }
                else{
                    beat_buttons[i].setBackgroundResource(R.drawable.no_select_style_blue);
                }


            }
//            bluebutton1 = loaded_sound[0];
//            bluebutton2 = loaded_sound[1];
//            bluebutton3 = loaded_sound[2];
//            bluebutton4 = loaded_sound[3];
//
//            yellowbutton1 = loaded_sound[4];
//            yellowbutton2 = loaded_sound[5];
//            yellowbutton3 = loaded_sound[6];
//            yellowbutton4 = loaded_sound[7];
//
//            orangebutton1 = loaded_sound[8];
//            orangebutton2 = loaded_sound[9];
//            orangebutton3 = loaded_sound[10];
//            orangebutton4 = loaded_sound[11];
//
//            indigobutton1 = loaded_sound[12];
//            indigobutton2 = loaded_sound[13];
//            indigobutton3 = loaded_sound[14];
//            indigobutton4 = loaded_sound[15];

            bluebutton1 = save_loaded_sound[0];
            bluebutton2 = save_loaded_sound[1];
            bluebutton3 = save_loaded_sound[2];
            bluebutton4 = save_loaded_sound[3];

            yellowbutton1 = save_loaded_sound[4];
            yellowbutton2 = save_loaded_sound[5];
            yellowbutton3 = save_loaded_sound[6];
            yellowbutton4 = save_loaded_sound[7];

            orangebutton1 = save_loaded_sound[8];
            orangebutton2 = save_loaded_sound[9];
            orangebutton3 = save_loaded_sound[10];
            orangebutton4 = save_loaded_sound[11];

            indigobutton1 = save_loaded_sound[12];
            indigobutton2 = save_loaded_sound[13];
            indigobutton3 = save_loaded_sound[14];
            indigobutton4 = save_loaded_sound[15];

        }

        settingBtn = (ImageButton)findViewById(R.id.settingButton);






        settingBtn.setOnClickListener(new View.OnClickListener() {  //셋팅버튼 클릭시 버튼셋팅 xml연결
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Play_beat_setting.class);
                Intent getintent = getIntent();

                if(getintent.getStringArrayExtra("saveColorArray") != null) {
                    intent.putExtra("saveColorArray_from_beat", getintent.getStringArrayExtra("saveColorArray"));
                    intent.putExtra("not_green_arrays_from_beat", getintent.getIntArrayExtra("not_green_arrays"));
                    intent.putExtra("GreenIndex_array_from_beat", getintent.getIntArrayExtra("GreenIndex_array"));
                    intent.putExtra("GreenSoundPath_from_beat", getintent.getStringArrayExtra("GreenSoundPath"));
                    intent.putExtra("btn_sounds_from_beat", getintent.getIntArrayExtra("btn_sounds"));
                    intent.putExtra("select_index_from_beat", getintent.getIntExtra("select_index", -1));
                    intent.putExtra("sync_array_from_beat", getintent.getIntArrayExtra("sync_array"));
                    intent.putExtra("into_the_unknown", 1000);
                    startActivity(intent);
                }
                else if(getintent.getStringArrayExtra("saveColorArray") == null){
                    startActivity(intent);
                }
            }
        });




    }
    private void playAudio() {
        try {
            if(filename == null)
            {
                Toast.makeText(this, "노래를 선택해 주십시오.", Toast.LENGTH_SHORT).show();
                return;
            }
            player = new MediaPlayer();
            player.setDataSource(filename);
            player.prepare();
            player.start();

            Toast.makeText(this, "재생 시작됨", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void closePlayer() {
        if(player != null) {
            player.release();
            pausing = false;
            playing = false;
            player = null;
        }
    }
    private void pauseAudio() {
        if(player != null)
        {
            position = player.getCurrentPosition();
            player.pause();

            Toast.makeText(this, "일시정지됨", Toast.LENGTH_SHORT).show();
        }
    }
    private void resumeAudio() {
        if(player != null && !player.isPlaying()) {
            player.seekTo(position); // position의 값만큼 후의 음성부터 실행
            player.start();

            Toast.makeText(this, "재시작됨", Toast.LENGTH_SHORT).show();
        }
    }
    private void stopAudio() {
        if(player != null) {
            position = 0;
            player.pause();
            pausing = false;
            Toast.makeText(this, "중지됨", Toast.LENGTH_SHORT).show();
        }
    }
    private void recordAudio() {
        recorder = new MediaRecorder();

        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);

        recorder.setOutputFile(filename);

        try{
            recorder.prepare();
            recorder.start();

            makeText(this, "녹음 시작됨.", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void stopRecording() {
        if(recorder != null)
        {
            recorder.stop();
            recorder.release();
            recorder = null;
            makeText(this, "녹화 중지됨.", Toast.LENGTH_SHORT).show();
        }
    }
    public void setFilename(String filename){
        this.filename = filename;
    }


    public void mOnClick(View v) {
        switch (v.getId()) {
            case R.id.beat_1row_1button:
                sp.play(bluebutton1,0.32f,0.32f,0,0,1);
                break;
            case R.id.beat_1row_2button:
                sp.play(bluebutton2,1,1,0,0,1);
                break;
            case R.id.beat_1row_3button:
                sp.play(bluebutton3,1,1,0,0,1);
                break;
            case R.id.beat_1row_4button:
                sp.play(bluebutton4,1,1,0,0,1);
                break;

            case R.id.beat_2row_1button:
                sp.play(yellowbutton1,1,1,0,0,1);
                break;
            case R.id.beat_2row_2button:
                sp.play(yellowbutton2,1,1,0,0,1);
                break;
            case R.id.beat_2row_3button:
                sp.play(yellowbutton3,1,1,0,0,1);
                break;
            case R.id.beat_2row_4button:
                sp.play(yellowbutton4,1,1,0,0,1);
                break;



            case R.id.beat_3row_1button:
                sp.play(orangebutton1,1,1,0,0,1);
                break;
            case R.id.beat_3row_2button:
                sp.play(orangebutton2,1,1,0,0,1);
                break;
            case R.id.beat_3row_3button:
                sp.play(orangebutton3,1,1,0,0,1);
                break;
            case R.id.beat_3row_4button:
                sp.play(orangebutton4,1,1,0,0,1);
                break;


            case R.id.beat_4row_1button:
                sp.play(indigobutton1,1,1,0,0,1);
                break;
            case R.id.beat_4row_2button:
                sp.play(indigobutton2,1,1,0,0,1);
                break;
            case R.id.beat_4row_3button:
                sp.play(indigobutton3,1,1,0,0,1);
                break;
            case R.id.beat_4row_4button:
                sp.play(indigobutton4,1,1,0,0,1);
                break;
        }
    }
}
