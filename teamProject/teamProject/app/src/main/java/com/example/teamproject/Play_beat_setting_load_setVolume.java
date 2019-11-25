package com.example.teamproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;

public class Play_beat_setting_load_setVolume extends AppCompatActivity {
    String f_pass;
    float s_pass;

    File music;
    String path, filename = null;
    MediaPlayer player;
    int position;
    float sound_size = 1.0f;
    private Thread Thread;
    ImageButton play, pause, stop, save, cancel;
    boolean pausing = false, watching = false;
    SeekBar sound;
    TextView time, sound_text;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_beat_setting_load_set_volume);

        play = (ImageButton)findViewById(R.id.play);
        pause = (ImageButton)findViewById(R.id.pause);
        stop = (ImageButton)findViewById(R.id.stop);
        time = (TextView)findViewById(R.id.timeText);
        sound = (SeekBar)findViewById(R.id.sound);
        sound_text = (TextView)findViewById(R.id.textView2);
        cancel = (ImageButton)findViewById(R.id.cancel);
        save = (ImageButton)findViewById(R.id.save);

        path = getIntent().getStringExtra("file");
        music = new File(path);
        filename = music.getAbsolutePath();
        Toast.makeText(this, filename, Toast.LENGTH_LONG).show();
        sound.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                sound_text.setText("음량 : "+i);
                sound_size = 15.0f * ((float)i/100);
                player.setVolume(sound_size, sound_size);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Play_beat_setting_load_setVolume.this);
                builder.setTitle("취소").setMessage("정말 취소하시겠습니까?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent cancel_intent = new Intent(getApplicationContext(), Play_beat_setting_load.class );
                        cancel_intent.putExtra("cancel_setVolume",100);
                        startActivity(cancel_intent);
                    }
                });
                builder.setNegativeButton("NO", null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();;
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(Play_beat_setting_load_setVolume.this);
                builder2.setTitle("저장").setMessage("파일을 저장하시겠습니까?");
                builder2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent save_intent = new Intent(getApplicationContext(),Play_beat_setting.class );
                        Intent get_intent = getIntent();
                        save_intent.putExtra("saveColorArray",get_intent.getStringArrayExtra("saveColorArray"));
                        save_intent.putExtra("not_green_array",get_intent.getIntArrayExtra("no_green_array"));
                        save_intent.putExtra("select_index",get_intent.getIntExtra("select_index",-1));
                        save_intent.putExtra("GreenIndex_array",get_intent.getIntArrayExtra("GreenIndex_array"));
                        save_intent.putExtra("GreenSoundPath",get_intent.getStringArrayExtra("GreenSoundPath"));
                        save_intent.putExtra("sync_path_array",get_intent.getIntArrayExtra("sync_arr"));
                        save_intent.putExtra("from_setvolume_btn_sound",get_intent.getIntArrayExtra("from_load_btn_sounds"));
                        save_intent.putExtra("file", music.getPath());
                        save_intent.putExtra("sound", sound_size/15.0f);
                        startActivity(save_intent);
                    }
                });
                builder2.setNegativeButton("NO", null);
                AlertDialog alertDialog2 = builder2.create();

                alertDialog2.show();
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pausing == true)
                {
                    sound.setVisibility(View.VISIBLE);
                    resumeAudio();
                    pausing = false;
                    watching = true;
                }
                else {
                    playAudio();
                    watching = true;
                    Thread = new Thread(new timeThread());
                    Thread.start();
                    pausing = false;
                }
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(player != null)
                {
                    if(pausing == false) {
                        position = player.getCurrentPosition();
                        player.pause();
                        pausing = true;
                        watching = false;
                    }
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAudio();
                Thread.interrupt();
                watching = false;
            }
        });
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            int mSec = msg.arg1%100;
            int sec = (msg.arg1/100)%60;
            int min = (msg.arg1/100)/60;
            int hour = (msg.arg1%3600)%24;
            String result = String.format("%03d:%02d:%02d", min, sec, mSec);
            time.setText(result);
        }
    };

    public class timeThread implements Runnable {
        @Override
        public void run() {
            int i = 0;

            while(true)
            {
                while(watching) {
                    Message msg = new Message();
                    msg.arg1 = i++;
                    handler.sendMessage(msg);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        }
    }
    private void playAudio() {
        try {
            closePlayer();

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
        if(player != null ) {
            player.stop();
            pausing = false;
            Toast.makeText(this, "중지됨", Toast.LENGTH_SHORT).show();
        }
    }
}
