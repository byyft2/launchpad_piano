package com.example.teampj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaRecorder;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Play_piano extends AppCompatActivity {

    SoundPool sp;

    LinearLayout bottom_negative_layout,bottom_two_layout;

    Button piano_change_button;
    Button record_button, record_stop_button;
    Button play_button, play_stop_button;
    Button piano_change_instrument_button;

    int zero_do,zero_do_shop;
    int zero_re,zero_re_shop;
    int zero_mi;
    int zero_fa,zero_fa_shop;
    int zero_sol,zero_sol_shop;
    int zero_la,zero_la_shop;
    int zero_si;

    int one_do,one_do_shop;
    int one_re,one_re_shop;
    int one_mi;
    int one_fa,one_fa_shop;
    int one_sol,one_sol_shop;
    int one_la,one_la_shop;
    int one_si;

    int two_do,two_do_shop;
    int two_re,two_re_shop;
    int two_mi;
    int two_fa,two_fa_shop;
    int two_sol,two_sol_shop;
    int two_la,two_la_shop;
    int two_si;

    int three_do,three_do_shop;
    int three_re,three_re_shop;
    int three_mi;
    int three_fa,three_fa_shop;
    int three_sol,three_sol_shop;
    int three_la,three_la_shop;
    int three_si;

    int four_do,four_do_shop;
    int four_re,four_re_shop;

    int changeCount=2;
    int recordCount=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window win=getWindow();
        win.requestFeature(Window.FEATURE_NO_TITLE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_play_piano);

        piano_change_instrument_button = findViewById(R.id.piano_change_instrument_button);
        piano_change_instrument_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(getApplicationContext(), v);

                getMenuInflater().inflate(R.menu.select_instrument,popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.select_menu_piano:
                                Toast.makeText(getApplicationContext(),"잠시만 기다려주십시오.",Toast.LENGTH_SHORT).show();
                                sp = new SoundPool(100, AudioManager.STREAM_MUSIC, 0);
                                zero_do = sp.load(getApplicationContext(), R.raw.zero_do, 1);
                                zero_do_shop = sp.load(getApplicationContext(), R.raw.zero_do_shop, 1);
                                zero_re = sp.load(getApplicationContext(), R.raw.zero_re, 1);
                                zero_re_shop = sp.load(getApplicationContext(), R.raw.zero_re_shop, 1);
                                zero_mi = sp.load(getApplicationContext(), R.raw.zero_mi, 1);
                                zero_fa = sp.load(getApplicationContext(), R.raw.zero_fa, 1);
                                zero_fa_shop = sp.load(getApplicationContext(), R.raw.zero_fa_shop, 1);
                                zero_sol = sp.load(getApplicationContext(), R.raw.zero_sol, 1);
                                zero_sol_shop = sp.load(getApplicationContext(), R.raw.zero_sol_shop, 1);
                                zero_la = sp.load(getApplicationContext(), R.raw.zero_la, 1);
                                zero_la_shop = sp.load(getApplicationContext(), R.raw.zero_la_shop, 1);
                                zero_si = sp.load(getApplicationContext(), R.raw.zero_si, 1);

                                one_do = sp.load(getApplicationContext(), R.raw.one_do, 1);
                                one_do_shop = sp.load(getApplicationContext(), R.raw.one_do_shop, 1);
                                one_re = sp.load(getApplicationContext(), R.raw.one_re, 1);
                                one_re_shop = sp.load(getApplicationContext(), R.raw.one_re_shop, 1);
                                one_mi = sp.load(getApplicationContext(), R.raw.one_mi, 1);
                                one_fa = sp.load(getApplicationContext(), R.raw.one_fa, 1);
                                one_fa_shop = sp.load(getApplicationContext(), R.raw.one_fa_shop, 1);
                                one_sol = sp.load(getApplicationContext(), R.raw.one_sol, 1);
                                one_sol_shop = sp.load(getApplicationContext(), R.raw.one_sol_shop, 1);
                                one_la = sp.load(getApplicationContext(), R.raw.one_la, 1);
                                one_la_shop = sp.load(getApplicationContext(), R.raw.one_la_shop, 1);
                                one_si = sp.load(getApplicationContext(), R.raw.one_si, 1);

                                two_do = sp.load(getApplicationContext(), R.raw.two_do, 1);
                                two_do_shop = sp.load(getApplicationContext(), R.raw.two_do_shop, 1);
                                two_re = sp.load(getApplicationContext(), R.raw.two_re, 1);
                                two_re_shop = sp.load(getApplicationContext(), R.raw.two_re_shop, 1);
                                two_mi = sp.load(getApplicationContext(), R.raw.two_mi, 1);
                                two_fa = sp.load(getApplicationContext(), R.raw.two_fa, 1);
                                two_fa_shop = sp.load(getApplicationContext(), R.raw.two_fa_shop, 1);
                                two_sol = sp.load(getApplicationContext(), R.raw.two_sol, 1);
                                two_sol_shop = sp.load(getApplicationContext(), R.raw.two_sol_shop, 1);
                                two_la = sp.load(getApplicationContext(), R.raw.two_la, 1);
                                two_la_shop = sp.load(getApplicationContext(), R.raw.two_la_shop, 1);
                                two_si = sp.load(getApplicationContext(), R.raw.two_si, 1);

                                three_do = sp.load(getApplicationContext(), R.raw.three_do, 1);
                                three_do_shop = sp.load(getApplicationContext(), R.raw.three_do_shop, 1);
                                three_re = sp.load(getApplicationContext(), R.raw.three_re, 1);
                                three_re_shop = sp.load(getApplicationContext(), R.raw.three_re_shop, 1);
                                three_mi = sp.load(getApplicationContext(), R.raw.three_mi, 1);
                                three_fa = sp.load(getApplicationContext(), R.raw.three_fa, 1);
                                three_fa_shop = sp.load(getApplicationContext(), R.raw.three_fa_shop, 1);
                                three_sol = sp.load(getApplicationContext(), R.raw.three_sol, 1);
                                three_sol_shop = sp.load(getApplicationContext(), R.raw.three_sol_shop, 1);
                                three_la = sp.load(getApplicationContext(), R.raw.three_la, 1);
                                three_la_shop = sp.load(getApplicationContext(), R.raw.three_la_shop, 1);
                                three_si = sp.load(getApplicationContext(), R.raw.three_si, 1);

                                four_do = sp.load(getApplicationContext(), R.raw.four_do, 1);
                                four_do_shop = sp.load(getApplicationContext(), R.raw.four_do_shop, 1);
                                four_re = sp.load(getApplicationContext(), R.raw.four_re, 1);
                                four_re_shop = sp.load(getApplicationContext(), R.raw.four_re_shop, 1);
                                Toast.makeText(getApplicationContext(),"다 되었습니다.",Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.select_menu_violin:
                                Toast.makeText(getApplicationContext(),"잠시만 기다려주십시오.",Toast.LENGTH_SHORT).show();
                                sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
                                zero_do = sp.load(getApplicationContext(),R.raw.violin_zero_do, 1);
                                zero_do_shop = sp.load(getApplicationContext(), R.raw.violin_zero_do_shop, 1);
                                zero_re = sp.load(getApplicationContext(), R.raw.violin_zero_re, 1);
                                zero_re_shop = sp.load(getApplicationContext(), R.raw.violin_zero_re_shop, 1);
                                zero_mi = sp.load(getApplicationContext(), R.raw.violin_zero_mi, 1);
                                zero_fa = sp.load(getApplicationContext(), R.raw.violin_zero_fa, 1);
                                zero_fa_shop = sp.load(getApplicationContext(), R.raw.violin_zero_fa_shop, 1);
                                zero_sol = sp.load(getApplicationContext(), R.raw.violin_zero_sol, 1);
                                zero_sol_shop = sp.load(getApplicationContext(), R.raw.violin_zero_sol_shop, 1);
                                zero_la = sp.load(getApplicationContext(), R.raw.violin_zero_la, 1);
                                zero_la_shop = sp.load(getApplicationContext(), R.raw.violin_zero_la_shop, 1);
                                zero_si = sp.load(getApplicationContext(), R.raw.violin_zero_si, 1);

                                one_do = sp.load(getApplicationContext(), R.raw.violin_one_do, 1);
                                one_do_shop = sp.load(getApplicationContext(), R.raw.violin_one_do_shop, 1);
                                one_re = sp.load(getApplicationContext(), R.raw.violin_one_re, 1);
                                one_re_shop = sp.load(getApplicationContext(), R.raw.violin_one_re_shop, 1);
                                one_mi = sp.load(getApplicationContext(), R.raw.violin_one_mi, 1);
                                one_fa = sp.load(getApplicationContext(), R.raw.violin_one_fa, 1);
                                one_fa_shop = sp.load(getApplicationContext(), R.raw.violin_one_fa_shop, 1);
                                one_sol = sp.load(getApplicationContext(), R.raw.violin_one_sol, 1);
                                one_sol_shop = sp.load(getApplicationContext(), R.raw.violin_one_sol_shop, 1);
                                one_la = sp.load(getApplicationContext(), R.raw.violin_one_la, 1);
                                one_la_shop = sp.load(getApplicationContext(), R.raw.violin_one_la_shop, 1);
                                one_si = sp.load(getApplicationContext(), R.raw.violin_one_si, 1);

                                two_do = sp.load(getApplicationContext(), R.raw.violin_two_do, 1);
                                two_do_shop = sp.load(getApplicationContext(), R.raw.violin_two_do_shop, 1);
                                two_re = sp.load(getApplicationContext(), R.raw.violin_two_re, 1);
                                two_re_shop = sp.load(getApplicationContext(), R.raw.violin_two_re_shop, 1);
                                two_mi = sp.load(getApplicationContext(), R.raw.violin_two_mi, 1);
                                two_fa = sp.load(getApplicationContext(), R.raw.violin_two_fa, 1);
                                two_fa_shop = sp.load(getApplicationContext(), R.raw.violin_two_fa_shop, 1);
                                two_sol = sp.load(getApplicationContext(), R.raw.violin_two_sol, 1);
                                two_sol_shop = sp.load(getApplicationContext(), R.raw.violin_two_sol_shop, 1);
                                two_la = sp.load(getApplicationContext(), R.raw.violin_two_la, 1);
                                two_la_shop = sp.load(getApplicationContext(), R.raw.violin_two_la_shop, 1);
                                two_si = sp.load(getApplicationContext(), R.raw.violin_two_si, 1);

                                three_do = sp.load(getApplicationContext(), R.raw.violin_three_do, 1);
                                three_do_shop = sp.load(getApplicationContext(), R.raw.violin_three_do_shop, 1);
                                three_re = sp.load(getApplicationContext(), R.raw.violin_three_re, 1);
                                three_re_shop = sp.load(getApplicationContext(), R.raw.violin_three_re_shop, 1);
                                three_mi = sp.load(getApplicationContext(), R.raw.violin_three_mi, 1);
                                three_fa = sp.load(getApplicationContext(), R.raw.violin_three_fa, 1);
                                three_fa_shop = sp.load(getApplicationContext(), R.raw.violin_three_fa_shop, 1);
                                three_sol = sp.load(getApplicationContext(), R.raw.violin_three_sol, 1);
                                three_sol_shop = sp.load(getApplicationContext(), R.raw.violin_three_sol_shop, 1);
                                three_la = sp.load(getApplicationContext(), R.raw.violin_three_la, 1);
                                three_la_shop = sp.load(getApplicationContext(), R.raw.violin_three_la_shop, 1);
                                three_si = sp.load(getApplicationContext(), R.raw.violin_three_si, 1);

                                four_do = sp.load(getApplicationContext(), R.raw.violin_four_do, 1);
                                four_do_shop = sp.load(getApplicationContext(), R.raw.violin_four_do_shop, 1);
                                four_re = sp.load(getApplicationContext(), R.raw.violin_four_re, 1);
                                four_re_shop = sp.load(getApplicationContext(), R.raw.violin_four_re_shop, 1);
                                Toast.makeText(getApplicationContext(),"다 되었습니다.",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.select_menu_trumpet:
                                Toast.makeText(getApplicationContext(),"잠시만 기다려주십시오.",Toast.LENGTH_SHORT).show();
                                sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
                                zero_do = sp.load(getApplicationContext(),R.raw.trumpet_zero_do, 1);
                                zero_do_shop = sp.load(getApplicationContext(), R.raw.trumpet_zero_do_shop, 1);
                                zero_re = sp.load(getApplicationContext(), R.raw.trumpet_zero_re, 1);
                                zero_re_shop = sp.load(getApplicationContext(), R.raw.trumpet_zero_re_shop, 1);
                                zero_mi = sp.load(getApplicationContext(), R.raw.trumpet_zero_mi, 1);
                                zero_fa = sp.load(getApplicationContext(), R.raw.trumpet_zero_fa, 1);
                                zero_fa_shop = sp.load(getApplicationContext(), R.raw.trumpet_zero_fa_shop, 1);
                                zero_sol = sp.load(getApplicationContext(), R.raw.trumpet_zero_sol, 1);
                                zero_sol_shop = sp.load(getApplicationContext(), R.raw.trumpet_zero_sol_shop, 1);
                                zero_la = sp.load(getApplicationContext(), R.raw.trumpet_zero_la, 1);
                                zero_la_shop = sp.load(getApplicationContext(), R.raw.trumpet_zero_la_shop, 1);
                                zero_si = sp.load(getApplicationContext(), R.raw.trumpet_zero_si, 1);

                                one_do = sp.load(getApplicationContext(), R.raw.trumpet_one_do, 1);
                                one_do_shop = sp.load(getApplicationContext(), R.raw.trumpet_one_do_shop, 1);
                                one_re = sp.load(getApplicationContext(), R.raw.trumpet_one_re, 1);
                                one_re_shop = sp.load(getApplicationContext(), R.raw.trumpet_one_re_shop, 1);
                                one_mi = sp.load(getApplicationContext(), R.raw.trumpet_one_mi, 1);
                                one_fa = sp.load(getApplicationContext(), R.raw.trumpet_one_fa, 1);
                                one_fa_shop = sp.load(getApplicationContext(), R.raw.trumpet_one_fa_shop, 1);
                                one_sol = sp.load(getApplicationContext(), R.raw.trumpet_one_sol, 1);
                                one_sol_shop = sp.load(getApplicationContext(), R.raw.trumpet_one_sol_shop, 1);
                                one_la = sp.load(getApplicationContext(), R.raw.trumpet_one_la, 1);
                                one_la_shop = sp.load(getApplicationContext(), R.raw.trumpet_one_la_shop, 1);
                                one_si = sp.load(getApplicationContext(), R.raw.trumpet_one_si, 1);

                                two_do = sp.load(getApplicationContext(), R.raw.trumpet_two_do, 1);
                                two_do_shop = sp.load(getApplicationContext(), R.raw.trumpet_two_do_shop, 1);
                                two_re = sp.load(getApplicationContext(), R.raw.trumpet_two_re, 1);
                                two_re_shop = sp.load(getApplicationContext(), R.raw.trumpet_two_re_shop, 1);
                                two_mi = sp.load(getApplicationContext(), R.raw.trumpet_two_mi, 1);
                                two_fa = sp.load(getApplicationContext(), R.raw.trumpet_two_fa, 1);
                                two_fa_shop = sp.load(getApplicationContext(), R.raw.trumpet_two_fa_shop, 1);
                                two_sol = sp.load(getApplicationContext(), R.raw.trumpet_two_sol, 1);
                                two_sol_shop = sp.load(getApplicationContext(), R.raw.trumpet_two_sol_shop, 1);
                                two_la = sp.load(getApplicationContext(), R.raw.trumpet_two_la, 1);
                                two_la_shop = sp.load(getApplicationContext(), R.raw.trumpet_two_la_shop, 1);
                                two_si = sp.load(getApplicationContext(), R.raw.trumpet_two_si, 1);

                                three_do = sp.load(getApplicationContext(), R.raw.trumpet_three_do, 1);
                                three_do_shop = sp.load(getApplicationContext(), R.raw.trumpet_three_do_shop, 1);
                                three_re = sp.load(getApplicationContext(), R.raw.trumpet_three_re, 1);
                                three_re_shop = sp.load(getApplicationContext(), R.raw.trumpet_three_re_shop, 1);
                                three_mi = sp.load(getApplicationContext(), R.raw.trumpet_three_mi, 1);
                                three_fa = sp.load(getApplicationContext(), R.raw.trumpet_three_fa, 1);
                                three_fa_shop = sp.load(getApplicationContext(), R.raw.trumpet_three_fa_shop, 1);
                                three_sol = sp.load(getApplicationContext(), R.raw.trumpet_three_sol, 1);
                                three_sol_shop = sp.load(getApplicationContext(), R.raw.trumpet_three_sol_shop, 1);
                                three_la = sp.load(getApplicationContext(), R.raw.trumpet_three_la, 1);
                                three_la_shop = sp.load(getApplicationContext(), R.raw.trumpet_three_la_shop, 1);
                                three_si = sp.load(getApplicationContext(), R.raw.trumpet_three_si, 1);

                                four_do = sp.load(getApplicationContext(), R.raw.trumpet_four_do, 1);
                                four_do_shop = sp.load(getApplicationContext(), R.raw.trumpet_four_do_shop, 1);
                                four_re = sp.load(getApplicationContext(), R.raw.trumpet_four_re, 1);
                                four_re_shop = sp.load(getApplicationContext(), R.raw.trumpet_four_re_shop, 1);
                                Toast.makeText(getApplicationContext(),"다 되었습니다.",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.select_menu_flute:
                                Toast.makeText(getApplicationContext(),"잠시만 기다려주십시오.",Toast.LENGTH_SHORT).show();
                                sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
                                zero_do = sp.load(getApplicationContext(),R.raw.flute_zero_do, 1);
                                zero_do_shop = sp.load(getApplicationContext(), R.raw.flute_zero_do_shop, 1);
                                zero_re = sp.load(getApplicationContext(), R.raw.flute_zero_re, 1);
                                zero_re_shop = sp.load(getApplicationContext(), R.raw.flute_zero_re_shop, 1);
                                zero_mi = sp.load(getApplicationContext(), R.raw.flute_zero_mi, 1);
                                zero_fa = sp.load(getApplicationContext(), R.raw.flute_zero_fa, 1);
                                zero_fa_shop = sp.load(getApplicationContext(), R.raw.flute_zero_fa_shop, 1);
                                zero_sol = sp.load(getApplicationContext(), R.raw.flute_zero_sol, 1);
                                zero_sol_shop = sp.load(getApplicationContext(), R.raw.flute_zero_sol_shop, 1);
                                zero_la = sp.load(getApplicationContext(), R.raw.flute_zero_la, 1);
                                zero_la_shop = sp.load(getApplicationContext(), R.raw.flute_zero_la_shop, 1);
                                zero_si = sp.load(getApplicationContext(), R.raw.flute_zero_si, 1);

                                one_do = sp.load(getApplicationContext(), R.raw.flute_one_do, 1);
                                one_do_shop = sp.load(getApplicationContext(), R.raw.flute_one_do_shop, 1);
                                one_re = sp.load(getApplicationContext(), R.raw.flute_one_re, 1);
                                one_re_shop = sp.load(getApplicationContext(), R.raw.flute_one_re_shop, 1);
                                one_mi = sp.load(getApplicationContext(), R.raw.flute_one_mi, 1);
                                one_fa = sp.load(getApplicationContext(), R.raw.flute_one_fa, 1);
                                one_fa_shop = sp.load(getApplicationContext(), R.raw.flute_one_fa_shop, 1);
                                one_sol = sp.load(getApplicationContext(), R.raw.flute_one_sol, 1);
                                one_sol_shop = sp.load(getApplicationContext(), R.raw.flute_one_sol_shop, 1);
                                one_la = sp.load(getApplicationContext(), R.raw.flute_one_la, 1);
                                one_la_shop = sp.load(getApplicationContext(), R.raw.flute_one_la_shop, 1);
                                one_si = sp.load(getApplicationContext(), R.raw.flute_one_si, 1);

                                two_do = sp.load(getApplicationContext(), R.raw.flute_two_do, 1);
                                two_do_shop = sp.load(getApplicationContext(), R.raw.flute_two_do_shop, 1);
                                two_re = sp.load(getApplicationContext(), R.raw.flute_two_re, 1);
                                two_re_shop = sp.load(getApplicationContext(), R.raw.flute_two_re_shop, 1);
                                two_mi = sp.load(getApplicationContext(), R.raw.flute_two_mi, 1);
                                two_fa = sp.load(getApplicationContext(), R.raw.flute_two_fa, 1);
                                two_fa_shop = sp.load(getApplicationContext(), R.raw.flute_two_fa_shop, 1);
                                two_sol = sp.load(getApplicationContext(), R.raw.flute_two_sol, 1);
                                two_sol_shop = sp.load(getApplicationContext(), R.raw.flute_two_sol_shop, 1);
                                two_la = sp.load(getApplicationContext(), R.raw.flute_two_la, 1);
                                two_la_shop = sp.load(getApplicationContext(), R.raw.flute_two_la_shop, 1);
                                two_si = sp.load(getApplicationContext(), R.raw.flute_two_si, 1);

                                three_do = sp.load(getApplicationContext(), R.raw.flute_three_do, 1);
                                three_do_shop = sp.load(getApplicationContext(), R.raw.flute_three_do_shop, 1);
                                three_re = sp.load(getApplicationContext(), R.raw.flute_three_re, 1);
                                three_re_shop = sp.load(getApplicationContext(), R.raw.flute_three_re_shop, 1);
                                three_mi = sp.load(getApplicationContext(), R.raw.flute_three_mi, 1);
                                three_fa = sp.load(getApplicationContext(), R.raw.flute_three_fa, 1);
                                three_fa_shop = sp.load(getApplicationContext(), R.raw.flute_three_fa_shop, 1);
                                three_sol = sp.load(getApplicationContext(), R.raw.flute_three_sol, 1);
                                three_sol_shop = sp.load(getApplicationContext(), R.raw.flute_three_sol_shop, 1);
                                three_la = sp.load(getApplicationContext(), R.raw.flute_three_la, 1);
                                three_la_shop = sp.load(getApplicationContext(), R.raw.flute_three_la_shop, 1);
                                three_si = sp.load(getApplicationContext(), R.raw.flute_three_si, 1);

                                four_do = sp.load(getApplicationContext(), R.raw.flute_four_do, 1);
                                four_do_shop = sp.load(getApplicationContext(), R.raw.flute_four_do_shop, 1);
                                four_re = sp.load(getApplicationContext(), R.raw.flute_four_re, 1);
                                four_re_shop = sp.load(getApplicationContext(), R.raw.flute_four_re_shop, 1);
                                Toast.makeText(getApplicationContext(),"다 되었습니다.",Toast.LENGTH_SHORT).show();
                                break;
                        }

                        return false;
                    }
                });
                popup.show();
            }
        });
        bottom_negative_layout = findViewById(R.id.negative_octave_layout);
        bottom_two_layout = findViewById(R.id.two_octave_layout);


        piano_change_button = findViewById(R.id.piano_change_piano_button);
        piano_change_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),String.valueOf(changeCount),Toast.LENGTH_SHORT).show();
                if(changeCount%2==0){
                    bottom_negative_layout.setVisibility(View.INVISIBLE);
                    bottom_two_layout.setVisibility(View.VISIBLE);
                    changeCount = changeCount+1;
                }
                else if(changeCount%2==1){
                    bottom_two_layout.setVisibility(View.INVISIBLE);
                    bottom_negative_layout.setVisibility(View.VISIBLE);
                    changeCount= changeCount+1;
                }
            }
        });

        record_button = findViewById(R.id.piano_record_button);
        record_stop_button = findViewById(R.id.piano_record_stop_button);
        play_button = findViewById(R.id.piano_play_button);
        play_stop_button = findViewById(R.id.piano_play_stop_button);
        final MediaRecorder mRecorder = new MediaRecorder();


//
//        record_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
//                mRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
//                mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
//                mRecorder.setOutputFile(Environment.getExternalStorageDirectory().getAbsolutePath()+"/record.aac");
//
//                if(recordCount%2 ==0){
//                    mRecorder.start();
//                }
//                else if(recordCount%2 ==1){
//                    mRecorder.stop();
//                }
//
//            }
//        });
//        record_stop_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mRecorder.stop();
//            }
//        });


        sp = new SoundPool(100, AudioManager.STREAM_MUSIC, 0);
        zero_do = sp.load(this, R.raw.zero_do, 1);
        zero_do_shop = sp.load(this, R.raw.zero_do_shop, 1);
        zero_re = sp.load(this, R.raw.zero_re, 1);
        zero_re_shop = sp.load(this, R.raw.zero_re_shop, 1);
        zero_mi = sp.load(this, R.raw.zero_mi, 1);
        zero_fa = sp.load(this, R.raw.zero_fa, 1);
        zero_fa_shop = sp.load(this, R.raw.zero_fa_shop, 1);
        zero_sol = sp.load(this, R.raw.zero_sol, 1);
        zero_sol_shop = sp.load(this, R.raw.zero_sol_shop, 1);
        zero_la = sp.load(this, R.raw.zero_la, 1);
        zero_la_shop = sp.load(this, R.raw.zero_la_shop, 1);
        zero_si = sp.load(this, R.raw.zero_si, 1);

        one_do = sp.load(this, R.raw.one_do, 1);
        one_do_shop = sp.load(this, R.raw.one_do_shop, 1);
        one_re = sp.load(this, R.raw.one_re, 1);
        one_re_shop = sp.load(this, R.raw.one_re_shop, 1);
        one_mi = sp.load(this, R.raw.one_mi, 1);
        one_fa = sp.load(this, R.raw.one_fa, 1);
        one_fa_shop = sp.load(this, R.raw.one_fa_shop, 1);
        one_sol = sp.load(this, R.raw.one_sol, 1);
        one_sol_shop = sp.load(this, R.raw.one_sol_shop, 1);
        one_la = sp.load(this, R.raw.one_la, 1);
        one_la_shop = sp.load(this, R.raw.one_la_shop, 1);
        one_si = sp.load(this, R.raw.one_si, 1);

        two_do = sp.load(this, R.raw.two_do, 1);
        two_do_shop = sp.load(this, R.raw.two_do_shop, 1);
        two_re = sp.load(this, R.raw.two_re, 1);
        two_re_shop = sp.load(this, R.raw.two_re_shop, 1);
        two_mi = sp.load(this, R.raw.two_mi, 1);
        two_fa = sp.load(this, R.raw.two_fa, 1);
        two_fa_shop = sp.load(this, R.raw.two_fa_shop, 1);
        two_sol = sp.load(this, R.raw.two_sol, 1);
        two_sol_shop = sp.load(this, R.raw.two_sol_shop, 1);
        two_la = sp.load(this, R.raw.two_la, 1);
        two_la_shop = sp.load(this, R.raw.two_la_shop, 1);
        two_si = sp.load(this, R.raw.two_si, 1);

        three_do = sp.load(this, R.raw.three_do, 1);
        three_do_shop = sp.load(this, R.raw.three_do_shop, 1);
        three_re = sp.load(this, R.raw.three_re, 1);
        three_re_shop = sp.load(this, R.raw.three_re_shop, 1);
        three_mi = sp.load(this, R.raw.three_mi, 1);
        three_fa = sp.load(this, R.raw.three_fa, 1);
        three_fa_shop = sp.load(this, R.raw.three_fa_shop, 1);
        three_sol = sp.load(this, R.raw.three_sol, 1);
        three_sol_shop = sp.load(this, R.raw.three_sol_shop, 1);
        three_la = sp.load(this, R.raw.three_la, 1);
        three_la_shop = sp.load(this, R.raw.three_la_shop, 1);
        three_si = sp.load(this, R.raw.three_si, 1);

        four_do = sp.load(this, R.raw.four_do, 1);
        four_do_shop = sp.load(this, R.raw.four_do_shop, 1);
        four_re = sp.load(this, R.raw.four_re, 1);
        four_re_shop = sp.load(this, R.raw.four_re_shop, 1);

    }
    public void mOnClick(View v) {
        switch (v.getId()) {
            case R.id.negative_octave_do_top:
                sp.play(zero_do, 1, 1, 0, 0, 1);
                break;
            case R.id.negative_octave_do_bottom:
                sp.play(zero_do, 1, 1, 0, 0, 1);
                break;
            case R.id.negative_octave_do_shop_left:
                sp.play(zero_do_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.negative_octave_do_shop_right:
                sp.play(zero_do_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.negative_octave_re_bottom:
                sp.play(zero_re, 1, 1, 0, 0, 1);
                break;
            case R.id.negative_octave_re_shop_left:
                sp.play(zero_re_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.negative_octave_re_shop_right:
                sp.play(zero_re_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.negative_octave_mi_top:
                sp.play(zero_mi, 1, 1, 0, 0, 1);
                break;
            case R.id.negative_octave_mi_bottom:
                sp.play(zero_mi, 1, 1, 0, 0, 1);
                break;
            case R.id.negative_octave_fa_top:
                sp.play(zero_fa, 1, 1, 0, 0, 1);
                break;
            case R.id.negative_octave_fa_bottom:
                sp.play(zero_fa, 1, 1, 0, 0, 1);
                break;
            case R.id.negative_octave_fa_shop_left:
                sp.play(zero_fa_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.negative_octave_fa_shop_right:
                sp.play(zero_fa_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.negative_octave_sol_bottom:
                sp.play(zero_sol, 1, 1, 0, 0, 1);
                break;
            case R.id.negative_octave_sol_shop_left:
                sp.play(zero_sol_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.negative_octave_sol_shop_right:
                sp.play(zero_sol_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.negative_octave_la_bottom:
                sp.play(zero_la, 1, 1, 0, 0, 1);
                break;
            case R.id.negative_octave_la_shop_left:
                sp.play(zero_la_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.negative_octave_la_shop_right:
                sp.play(zero_la_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.negative_octave_si_top:
                sp.play(zero_si, 1, 1, 0, 0, 1);
                break;
            case R.id.negative_octave_si_bottom:
                sp.play(zero_si, 1, 1, 0, 0, 1);
                break;


            case R.id.zero_octave_do_top:
                sp.play(one_do, 1, 1, 0, 0, 1);
                break;
            case R.id.zero_octave_do_bottom:
                sp.play(one_do, 1, 1, 0, 0, 1);
                break;
            case R.id.zero_octave_do_shop_left:
                sp.play(one_do_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.zero_octave_do_shop_right:
                sp.play(one_do_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.zero_octave_re_bottom:
                sp.play(one_re, 1, 1, 0, 0, 1);
                break;
            case R.id.zero_octave_re_shop_left:
                sp.play(one_re_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.zero_octave_re_shop_right:
                sp.play(one_re_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.zero_octave_mi_top:
                sp.play(one_mi, 1, 1, 0, 0, 1);
                break;
            case R.id.zero_octave_mi_bottom:
                sp.play(one_mi, 1, 1, 0, 0, 1);
                break;
            case R.id.zero_octave_fa_top:
                sp.play(one_fa, 1, 1, 0, 0, 1);
                break;
            case R.id.zero_octave_fa_bottom:
                sp.play(one_fa, 1, 1, 0, 0, 1);
                break;
            case R.id.zero_octave_fa_shop_left:
                sp.play(one_fa_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.zero_octave_fa_shop_right:
                sp.play(one_fa_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.zero_octave_sol_bottom:
                sp.play(one_sol, 1, 1, 0, 0, 1);
                break;
            case R.id.zero_octave_sol_shop_left:
                sp.play(one_sol_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.zero_octave_sol_shop_right:
                sp.play(one_sol_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.zero_octave_la_bottom:
                sp.play(one_la, 1, 1, 0, 0, 1);
                break;
            case R.id.zero_octave_la_shop_left:
                sp.play(one_la_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.zero_octave_la_shop_right:
                sp.play(one_la_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.zero_octave_si_top:
                sp.play(one_si, 1, 1, 0, 0, 1);
                break;
            case R.id.zero_octave_si_bottom:
                sp.play(one_si, 1, 1, 0, 0, 1);
                break;

            case R.id.one_octave_do_top:
                sp.play(two_do, 1, 1, 0, 0, 1);
                break;
            case R.id.one_octave_do_bottom:
                sp.play(two_do, 1, 1, 0, 0, 1);
                break;
            case R.id.one_octave_do_shop_left:
                sp.play(two_do_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.one_octave_do_shop_right:
                sp.play(two_do_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.one_octave_re_bottom:
                sp.play(two_re, 1, 1, 0, 0, 1);
                break;
            case R.id.one_octave_re_shop_left:
                sp.play(two_re_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.one_octave_re_shop_right:
                sp.play(two_re_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.one_octave_mi_top:
                sp.play(two_mi, 1, 1, 0, 0, 1);
                break;
            case R.id.one_octave_mi_bottom:
                sp.play(two_mi, 1, 1, 0, 0, 1);
                break;
            case R.id.one_octave_fa_top:
                sp.play(two_fa, 1, 1, 0, 0, 1);
                break;
            case R.id.one_octave_fa_bottom:
                sp.play(two_fa, 1, 1, 0, 0, 1);
                break;
            case R.id.one_octave_fa_shop_left:
                sp.play(two_fa_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.one_octave_fa_shop_right:
                sp.play(two_fa_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.one_octave_sol_bottom:
                sp.play(two_sol, 1, 1, 0, 0, 1);
                break;
            case R.id.one_octave_sol_shop_left:
                sp.play(two_sol_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.one_octave_sol_shop_right:
                sp.play(two_sol_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.one_octave_la_bottom:
                sp.play(two_la, 1, 1, 0, 0, 1);
                break;
            case R.id.one_octave_la_shop_left:
                sp.play(two_la_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.one_octave_la_shop_right:
                sp.play(two_la_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.one_octave_si_top:
                sp.play(two_si, 1, 1, 0, 0, 1);
                break;
            case R.id.one_octave_si_bottom:
                sp.play(two_si, 1, 1, 0, 0, 1);
                break;

            case R.id.two_octave_do_top:
                sp.play(three_do, 1, 1, 0, 0, 1);
                break;
            case R.id.two_octave_do_bottom:
                sp.play(three_do, 1, 1, 0, 0, 1);
                break;
            case R.id.two_octave_do_shop_left:
                sp.play(three_do_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.two_octave_do_shop_right:
                sp.play(three_do_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.two_octave_re_bottom:
                sp.play(three_re, 1, 1, 0, 0, 1);
                break;
            case R.id.two_octave_re_shop_left:
                sp.play(three_re_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.two_octave_re_shop_right:
                sp.play(three_re_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.two_octave_mi_top:
                sp.play(three_mi, 1, 1, 0, 0, 1);
                break;
            case R.id.two_octave_mi_bottom:
                sp.play(three_mi, 1, 1, 0, 0, 1);
                break;
            case R.id.two_octave_fa_top:
                sp.play(three_fa, 1, 1, 0, 0, 1);
                break;
            case R.id.two_octave_fa_bottom:
                sp.play(three_fa, 1, 1, 0, 0, 1);
                break;
            case R.id.two_octave_fa_shop_left:
                sp.play(three_fa_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.two_octave_fa_shop_right:
                sp.play(three_fa_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.two_octave_sol_bottom:
                sp.play(three_sol, 1, 1, 0, 0, 1);
                break;
            case R.id.two_octave_sol_shop_left:
                sp.play(three_sol_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.two_octave_sol_shop_right:
                sp.play(three_sol_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.two_octave_la_bottom:
                sp.play(three_la, 1, 1, 0, 0, 1);
                break;
            case R.id.two_octave_la_shop_left:
                sp.play(three_la_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.two_octave_la_shop_right:
                sp.play(three_la_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.two_octave_si_top:
                sp.play(three_si, 1, 1, 0, 0, 1);
                break;
            case R.id.two_octave_si_bottom:
                sp.play(three_si, 1, 1, 0, 0, 1);
                break;

            case R.id.three_octave_do_top:
                sp.play(four_do, 1, 1, 0, 0, 1);
                break;
            case R.id.three_octave_do_bottom:
                sp.play(four_do, 1, 1, 0, 0, 1);
                break;
            case R.id.three_octave_do_shop_left:
                sp.play(four_do_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.three_octave_do_shop_right:
                sp.play(four_do_shop, 1, 1, 0, 0, 1);
                break;
            case R.id.three_octave_re_bottom:
                sp.play(four_re, 1, 1, 0, 0, 1);
                break;
            case R.id.three_octave_re_shop_left:
                sp.play(four_re_shop, 1, 1, 0, 0, 1);
                break;
        }
    }

}
