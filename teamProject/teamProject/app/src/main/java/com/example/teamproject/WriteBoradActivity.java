package com.example.teamproject;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class WriteBoradActivity extends AppCompatActivity {

    private ArrayList<String> pathList = new ArrayList<>();
    private static final int AUDIO_CODE = 1;
    private FirebaseStorage storage;
    private FirebaseDatabase database;
    private FirebaseAuth auth;
    FirebaseUser user;
    int pos;
    MediaPlayer mp;
    private EditText titleEditText;
    private EditText contentsEditText;
    private Button write_btn;
    private Button record;
    private Button start_btn;
    private Button stop_btn;
    private Button re_btn;
    private SeekBar recordBar;
    boolean isPlaying = false;
    private String profilePath;

    class MyThread extends Thread {
        @Override
        public void run() {
            while (isPlaying) {
                recordBar.setProgress(mp.getCurrentPosition());
            }
        }
    }

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_write_borad);

        findViewById(R.id.write_btn).setOnClickListener(onClickListener);
        findViewById(R.id.record).setOnClickListener(onClickListener);
        titleEditText = (EditText) findViewById(R.id.titleEditText);
        contentsEditText = (EditText) findViewById(R.id.contentsEditText);
        recordBar = (SeekBar) findViewById(R.id.recordBar);
        write_btn = (Button) findViewById(R.id.write_btn);
        record = (Button) findViewById(R.id.record);
        mp = new MediaPlayer();

        auth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();
        database = FirebaseDatabase.getInstance();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
        }
        start_btn = (Button) findViewById(R.id.start_btn);
        stop_btn = (Button) findViewById(R.id.stop_btn);
        re_btn = (Button) findViewById(R.id.re_btn);

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 0: {
                if (requestCode == 0) {
//                    profilePath = data.getStringExtra("profilePath")
                    if (data == null) {
                    } else if (data != null) {

                        if(mp != null) {
                            pos = 0;
                            mp.release();
                            MyThread.interrupted();
                            mp = new MediaPlayer();

                        }

                        profilePath = data.getStringExtra("profilePath");
//                        pathList.add(profilePath);
                        try {

                            mp.setDataSource(profilePath);
                            mp.prepare();
                            Toast.makeText(this, profilePath, Toast.LENGTH_SHORT).show();
                            recordBar.setMax(mp.getDuration());

                            recordBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                                public void onStopTrackingTouch(SeekBar seekBar) {
                                    isPlaying = true;
//                                    int ttt = seekBar.getProgress();
                                    pos = seekBar.getProgress();
                                    mp.seekTo(pos);
                                    mp.start();
                                    new MyThread().start();
                                }

                                public void onStartTrackingTouch(SeekBar seekBar) {
                                    isPlaying = false;
                                    mp.pause();
                                }

                                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                    if (seekBar.getMax() == progress) {
                                        start_btn.setVisibility(View.VISIBLE);
                                        isPlaying = false;
                                        mp.start();
                                    }
                                }
                            });
                            start_btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    mp.setLooping(false);
                                    mp.start();
                                    int a = mp.getDuration();
                                    recordBar.setMax(a);
                                    new MyThread().start();
                                    isPlaying = true;
                                }
                            });
                            stop_btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    pos = mp.getCurrentPosition();
                                    mp.pause();
                                    isPlaying = false;
                                }
                            });
                            re_btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    mp.seekTo(pos);
                                    mp.start();
                                    isPlaying = true;
                                    new MyThread().start();
                                }
                            });

                        } catch (IllegalArgumentException e) {

                            e.printStackTrace();

                        } catch (IllegalStateException e) {

                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mp.stop();
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.write_btn:
                    uploadFile(profilePath);
                    break;
                case R.id.record:
                    myStartActivity(RecordActivity.class, "audio", 0);
                    mp.pause();
                    isPlaying = false;
                    break;
            }
        }
    };

    private void uploadFile(String profilePath) {
        RecordDTO recordDTO = new RecordDTO();
        recordDTO.title = titleEditText.getText().toString();
        recordDTO.contents = contentsEditText.getText().toString();
        if(titleEditText.length() > 0 && contentsEditText.length() > 0 ) {
            if (profilePath != null) {
                final ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setTitle("업로드중...");
                progressDialog.show();
                FirebaseStorage storage = FirebaseStorage.getInstance();
                final Uri file = Uri.fromFile(new File(profilePath));
                StorageReference storageRef = storage.getReferenceFromUrl("gs://team-b26ba.appspot.com/").child("audios/" + file.getLastPathSegment());
                UploadTask uploadTask = storageRef.putFile(file);
                uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                        while (!urlTask.isSuccessful()) ;
                        Uri downloadUrl = urlTask.getResult();
                        RecordDTO recordDTO = new RecordDTO();
                        recordDTO.recordUrl = downloadUrl.toString();
                        recordDTO.title = titleEditText.getText().toString();
                        recordDTO.contents = contentsEditText.getText().toString();
                        recordDTO.userId = auth.getCurrentUser().getEmail().replace(".",",");
                        recordDTO.recordName = file.getLastPathSegment();


                        database.getReference().child("audios").push().setValue(recordDTO);
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), "업로드 완료!", Toast.LENGTH_SHORT).show();
                        mp.stop();
                        finish();
                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progressDialog.dismiss();
                                Toast.makeText(getApplicationContext(), "업로드 실패!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                                @SuppressWarnings("VisibleForTests")
                                double progress = (100 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
                                progressDialog.setMessage("Uploaded " + ((int) progress) + "% ...");
                            }
                        });
            } else {
                Toast.makeText(getApplicationContext(), "음악 파일을 선택하세요.", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "제목과 내용을 채우세요.", Toast.LENGTH_SHORT).show();
        }
    }

    public void myStartActivity (Class c ,String media, int requestCode) {
        Intent intent = new Intent(this,c);
        intent.putExtra("media",media);
        startActivityForResult(intent, 0);
    }
}
