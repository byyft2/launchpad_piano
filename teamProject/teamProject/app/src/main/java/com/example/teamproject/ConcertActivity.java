package com.example.teamproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ConcertActivity extends AppCompatActivity {
    private List<String> pathList = new ArrayList<>();
    private RecyclerView recyclerview;
    private List<RecordDTO> recordDTOS = new ArrayList<>();

    private FirebaseDatabase database;
    private Button item_start_btn;
    MediaPlayer player;
    private SeekBar item_recordbar;
    boolean isPlaying = false; // 재생중인지 확인할 변수
    private FirebaseStorage storage;
    private long pressedTime;
    private FirebaseFirestore firebaseFirestore;
    class MyThread extends Thread {
        @Override
        public void run() { // 쓰레드가 시작되면 콜백되는 메서드
            // 씨크바 막대기 조금씩 움직이기 (노래 끝날 때까지 반복)
            while (isPlaying) {
                item_recordbar.setProgress(player.getCurrentPosition());
            }
        }
    }
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_concert);

        recyclerview = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        final BoardRecyclerViewAdapter boardRecyclerViewAdapter = new BoardRecyclerViewAdapter();
        recyclerview.setAdapter(boardRecyclerViewAdapter);
        item_start_btn = (Button) findViewById(R.id.item_start_btn);
        database = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance();
        findViewById(R.id.board_plus).setOnClickListener(onClickListener);
        firebaseFirestore = FirebaseFirestore.getInstance();
        database.getReference().child("audios").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                pathList.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    RecordDTO recordDTO = snapshot.getValue(RecordDTO.class);
                    String uidKey = snapshot.getKey();
                    recordDTOS.add(recordDTO);
                    pathList.add(uidKey);
                }
                boardRecyclerViewAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    class BoardRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private DatabaseReference mdata;
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_board, parent, false);
            return new CustomViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            ((CustomViewHolder) holder).item_title.setText(recordDTOS.get(position).title);
            ((CustomViewHolder) holder).item_contents.setText(recordDTOS.get(position).contents);
            ((CustomViewHolder) holder).item_start_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(recordDTOS.get(position).recordUrl));
                    startActivity(intent);
                }
            });
            ((CustomViewHolder) holder).item_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    delete_content(position);
                }
            });

        }

        @Override
        public int getItemCount() {
            return recordDTOS.size();
        }

        private void delete_content(final int position) {
//          시발 다른사람꺼 삭제방지?해야되는데
            Intent getIntent = getIntent();
            String login_id = getIntent.getStringExtra("Login_id");
//            try {
                Query myTop = database.getReference().child("audios").child(recordDTOS.get(position).userId);
                @SuppressLint("RestrictedApi") String id = String.valueOf(myTop.getPath());
                id = id.substring(8);
                String[] list_id = id.split(",");
                list_id[0].length();
                if (login_id.length() >= list_id[0].length()) {
                    login_id = login_id.substring(0, list_id[0].length());
                }
                if (list_id[0].equals(login_id) == true) {
                    storage.getReference().child("audios").child(recordDTOS.get(position).recordName).delete().addOnSuccessListener(new OnSuccessListener<Void>() {

                        @Override
                        public void onSuccess(Void aVoid) {
                            database.getReference().child("audios").child(pathList.get(position)).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {

                                @Override
                                public void onSuccess(Void aVoid) {
                                    startMainActivty();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                }
                            });
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(ConcertActivity.this, "삭제 실패", Toast.LENGTH_SHORT).show();

                        }
                    });
                } else {
                    Toast.makeText(ConcertActivity.this, "작성자의 아이디가 아닙니다.", Toast.LENGTH_LONG).show();
                }


        }
    }
        private class CustomViewHolder extends RecyclerView.ViewHolder {

            TextView item_title;
            TextView item_contents;
            ImageView item_delete;
            Button item_start_btn;
            public CustomViewHolder(View view) {
                super(view);
                item_delete = (ImageView)view.findViewById(R.id.item_delete);
                item_title = (TextView)view.findViewById(R.id.item_title);
                item_contents = (TextView)view.findViewById(R.id.item_contents);
                item_start_btn =(Button)view.findViewById(R.id.item_start_btn);
            }
        }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.board_plus:
                    startWriteBoradActivty();
                    break;
            }
        }
    };
    private void startWriteBoradActivty(){
        Intent intent = new Intent(this,WriteBoradActivity.class);
        startActivity(intent);

    }
    private void startMainActivty() {
        Intent intent = new Intent(this, MainActivity.class);
        Toast.makeText(getApplicationContext(), "삭제가 완료 되었습니다", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    }
