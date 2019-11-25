package com.example.teamproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Play_beat_setting_load extends AppCompatActivity {
    private TextView textView;
    private ListView listView;
    private ArrayAdapter<String> listAdapter;
    private ArrayList<String> items;
    private String rootPath = "";
    private String nextPath = "";
    private String prevPath = "";
    private String currentPath = "";
    private String settingEx[] = {"mp3", "mp4", "wav", "flac"};
    boolean isEx = false;
    //private TextView messageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_beat_setting_load);

        textView = (TextView)findViewById(R.id.textView);
        listView = (ListView)findViewById(R.id.list);

        items = new ArrayList<>();
        listAdapter = new ArrayAdapter<String>(Play_beat_setting_load.this,
                android.R.layout.simple_list_item_1, items);

        // 루트 경로 가져오기
        rootPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        boolean result = Init(rootPath);

        if ( result == false )
            return;

        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("KJH_TEST", position + " : " + items.get(position).toString());
                currentPath = textView.getText().toString();
                String path = items.get(position).toString();
                if (path.equals("..")) {
                    prevPath(path);
                } else {
                    nextPath(path);
                }
            }
        });

    }

    public boolean Init(String rootPath)    {
        // 파일 객체 생성
        File fileRoot = new File(rootPath);
        if(fileRoot.isDirectory() == false)        {
            Toast.makeText(Play_beat_setting_load.this, "Not Directory" , Toast.LENGTH_SHORT).show();
            return false;
        }
        textView.setText(rootPath);
        // 파일 리스트 가져오기
        String[] fileList = fileRoot.list();
        if ( fileList == null )        {
            Toast.makeText(Play_beat_setting_load.this, "Could not find List" , Toast.LENGTH_SHORT).show();
            return false;
        }

        // 아이템 리스트 전부 삭제
        items.clear();

        // 리스트의 첫 항목은 뒤로가기 위해 ".." 세팅
        items.add("..");
        for ( int i = 0; i < fileList.length; i++ )        {
            items.add(fileList[i]);
        }

        // 리스트 뷰에 적용
        listAdapter.notifyDataSetChanged();
        return true;
    }

    public void nextPath(String str)    {
        prevPath = currentPath;

        // 현재 경로에서 / 와 다음 경로 붙이기
        nextPath = currentPath + "/" + str;
        File file = new File(nextPath);
        if ( file.isDirectory() == false )        {
            if(file.isFile() == true)
            {
                isEx = false;
                String ex = getOnlyExtension(file.getPath());
                for(int i = 0; i< settingEx.length; i++)
                {
                    if(ex.equals(settingEx[i]))
                    {
                        isEx = true;
                    }
                }
                if(isEx) {
                    Intent intent = new Intent(getApplicationContext(), Play_beat_setting_load_setVolume.class);
                    Intent get_intent = getIntent();
                    int saved_index = get_intent.getIntExtra("select_index", -1);
                    intent.putExtra("saveColorArray", get_intent.getStringArrayExtra("saveColorArray"));
                    intent.putExtra("no_green_array", get_intent.getIntArrayExtra("not_green_arrays"));
                    Log.d("현재 저장상태가?", String.valueOf(get_intent.getStringArrayExtra("")));
                    intent.putExtra("file", file.getPath());
                    intent.putExtra("from_load_btn_sounds",get_intent.getIntArrayExtra("btn_sounds"));
                    intent.putExtra("select_index", saved_index);
                    intent.putExtra("GreenIndex_array", get_intent.getIntArrayExtra("GreenIndex_array"));
                    intent.putExtra("GreenSoundPath", get_intent.getStringArrayExtra("GreenSoundPath"));
                    intent.putExtra("sync_arr",intent.getIntArrayExtra("sync_array"));


                    Intent piano_intent = new Intent(getApplicationContext(), Play_piano.class);

                    if(get_intent.getIntExtra("cancel_setVolume",-1) == 100){ //setVolume에서 cancel해서 넘어왔을때
                        startActivity(intent);
                    }

                    else if (get_intent.getIntExtra("cancel_setVolume",-1) == -1 &&
                            get_intent.getIntExtra("select_index", -1) == -1 &&
                            get_intent.getIntExtra("signal1",-1) != 150) {

                        piano_intent.putExtra("piano_check", 1);
                        piano_intent.putExtra("piano_file_path", file.getPath());
                        startActivity(piano_intent);

                    }
                    else if(get_intent.getIntExtra("signal1",-1) == 150){
                        Intent beat_intent = new Intent(getApplicationContext(), Play_beat.class);
                        beat_intent.putExtra("show_yourself",get_intent.getIntArrayExtra("into_the_unknown"));
                        beat_intent.putExtra("beat_check",1);
                        beat_intent.putExtra("piano_file_path",file.getPath());
                        beat_intent.putExtra("atohalenn",get_intent.getStringArrayExtra("atohalen"));
                        startActivity(beat_intent);
                    }
                    else if (get_intent.getIntExtra("select_index", -1) != -1){
                        startActivity(intent);
                    }



                    int len = file.getName().length();
                    Toast.makeText(Play_beat_setting_load.this, file.getName(), Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(Play_beat_setting_load.this, ex+"파일 입니다", Toast.LENGTH_LONG).show();
                }
            }
            else
                Toast.makeText(Play_beat_setting_load.this, "Not Directory" , Toast.LENGTH_SHORT).show();
            return;
        }

        String[] fileList = file.list();
        items.clear();
        items.add("..");

        for ( int i = 0; i < fileList.length; i++ )        {
            items.add(fileList[i]);
        }

        textView.setText(nextPath);
        listAdapter.notifyDataSetChanged();

    }

    public void prevPath(String str)    {
        nextPath = currentPath;
        prevPath = currentPath;


        // 마지막 / 의 위치 찾기
        int lastSlashPosition = prevPath.lastIndexOf("/");

        // 처음부터 마지막 / 까지의 문자열 가져오기
        prevPath = prevPath.substring(0, lastSlashPosition);
        File file = new File(prevPath);

        if ( file.isDirectory() == false)        {
            Toast.makeText(Play_beat_setting_load.this, "Not Directory" , Toast.LENGTH_SHORT).show();
            return;
        }

        String[] fileList = file.list();
        items.clear();
        items.add("..");

        for( int i = 0; i < fileList.length; i++ )        {
            items.add(fileList[i]);
        }

        textView.setText(prevPath);
        listAdapter.notifyDataSetChanged();
    }
    public void permissionCheck() {

    }

    public static String getOnlyExtension(String fullUri)
    {
        int fileIndex = fullUri.lastIndexOf(".");
        return  fullUri.substring(fileIndex + 1, fullUri.length());
    }
}
