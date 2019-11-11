package com.example.teampj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

import static android.widget.Toast.makeText;

public class Play_beat_setting_record extends AppCompatActivity {
    MediaRecorder recorder;
    String filename =null, input_filename;
    ImageButton StartRecord, play, pause, stop;
    TextView time;
    Button del;
    boolean recording = false, watching = false, pausing = false;
    private Thread Thread;
    View dialogView;
    EditText input_name;
    File sdcard, file;
    // TextView fName;

    MediaPlayer player;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_beat_setting_record);

        permissionCheck();
        input_name = (EditText)findViewById(R.id.input_name);
        time = (TextView)findViewById(R.id.timeText);
        del = (Button)findViewById(R.id.delete);
        StartRecord = (ImageButton)findViewById(R.id.record);
        play = (ImageButton)findViewById(R.id.play);
        pause = (ImageButton)findViewById(R.id.pause);
        stop = (ImageButton)findViewById(R.id.stop);
        StartRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(recording == false) {
                    recording = true;
                    dialogView = (View) View.inflate(Play_beat_setting_record.this, R.layout.filename_input, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(Play_beat_setting_record.this);
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
                            Log.d("Play_beat_setting_record", "저장할 파일 명 : " + filename);
                            recordAudio();
                            StartRecord.setImageResource(R.mipmap.ic_stop_record_red_foreground);
                            time.setText("00:00:00");
                            if(watching == false)
                            {
                                Thread = new Thread(new timeThread());
                                Thread.start();
                                watching = true;
                            }
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
                    StartRecord.setImageResource(R.mipmap.ic_record_red_foreground);
                    Thread.interrupt();
                    watching = false;
                }
            }

        });
//        StartRecord.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(file != null) {
                    AlertDialog.Builder Del_dlg = new AlertDialog.Builder(Play_beat_setting_record.this);
                    Del_dlg.setTitle("삭제");
                    Del_dlg.setMessage("파일명 : "+filename+" 파일을 삭제합니다.");
                    Del_dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            deleteFile(file);
                            watching = false;
                            pausing = false;
                            recording = false;
                        }
                    });
                    Del_dlg.setNegativeButton("취소", null);
                    Del_dlg.show();
                }
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pausing == true)
                {
                    resumeAudio();
                    pausing = false;
                }
                else {
                    playAudio();
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

                    }
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAudio();
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
    public void permissionCheck() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO, Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
    }
    private void deleteFile(File f){
        if(f.delete()){
            Log.i("banana", "file remove = "+ f.getName() + ", 삭제 성공");
        }
        else {
            Log.i("banana", "file remove = "+ f.getName() + ", 삭제 실패");
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
        if(player != null) {
            player.stop();
            pausing = false;
            Toast.makeText(this, "중지됨", Toast.LENGTH_SHORT).show();
        }
    }
}
