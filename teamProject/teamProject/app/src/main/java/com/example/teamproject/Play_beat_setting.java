package com.example.teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.common.SignInButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Play_beat_setting extends AppCompatActivity {

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference conditionRef = mRootRef.child("text");

    String saveColor;
    int saveIndex;

    int[] saveIndex_array = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    String[] saveColor_array = {"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"};
    int save_beat_index;

    int[] saveGreenIndex_array = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

    int[] saveGreenSound_array = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    String[] saveGreenSoundPath= {"no","no","no","no","no","no","no","no","no","no","no","no","no","no","no","no"};
    float[] volume_array = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    int[] sync_sound_path={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    ArrayList<ToggleButton> savebtns;
    ArrayList<Button> beat_button;
    ArrayList<Button> soundbulebtns;
    ArrayList<ToggleButton> soundyellowbtns;
    ArrayList<ToggleButton> soundorangebtns;
    ArrayList<ToggleButton> soundindigobtns;
    ArrayList<ToggleButton> soundgreenbtns;

    String[] from_beat_saveColor_array = {"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"};
    int[] from_beat_saveIndex_array = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    int[] from_beat_saveGreenIndex_array = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    String[] from_beat_saveGreenSoundPath = {"no","no","no","no","no","no","no","no","no","no","no","no","no","no","no","no"};
    int[] from_beat_btn_sound = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};


    int[] btn_sound = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

    LinearLayout sound_select_layout, insert_btn_layout;
    LinearLayout green_layout,original_layout;
    Button go_record, go_load;

    Button back,insert;

    Button complete;

    Button beat_1row_1button,beat_1row_2button,beat_1row_3button,beat_1row_4button;
    Button beat_2row_1button,beat_2row_2button,beat_2row_3button,beat_2row_4button;
    Button beat_3row_1button,beat_3row_2button,beat_3row_3button,beat_3row_4button;
    Button beat_4row_1button,beat_4row_2button,beat_4row_3button,beat_4row_4button;

    int green_btn1,green_btn2,green_btn3,green_btn4,green_btn5,green_btn6,green_btn7,green_btn8,
            green_btn9,green_btn10,green_btn11,green_btn12,green_btn13,green_btn14,green_btn15,green_btn16;

    int[] green_btns = {green_btn1,green_btn2,green_btn3,green_btn4,green_btn5,green_btn6,green_btn7,green_btn8,
            green_btn9,green_btn10,green_btn11,green_btn12,green_btn13,green_btn14,green_btn15,green_btn16};

    ToggleButton green_button1,green_button2,green_button3,green_button4,green_button5,green_button6,green_button7,green_button8,
            green_button9,green_button10,green_button11,green_button12,green_button13,green_button14,green_button15,green_button16;



    public String getSaveColor(){
        return this.saveColor;
    }


    public Button get_beat(String color, int index){
        Button btn =null;
        if(color.equals("blue")){
            btn =  this.soundbulebtns.get(index);
        }
        return btn;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_beat_setting);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Button btn_insert = (Button)findViewById(R.id.btn_insert);

        complete = findViewById(R.id.btn_complete);

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

        Intent get__intent =getIntent();
        if(get__intent.getStringArrayExtra("saveColorArray_from_beat") != null) {
            saveColor_array = get__intent.getStringArrayExtra("saveColorArray_from_beat");
            saveIndex_array = get__intent.getIntArrayExtra("not_green_arrays_from_beat");
            saveGreenIndex_array = get__intent.getIntArrayExtra("GreenIndex_array_from_beat");
            saveGreenSoundPath = get__intent.getStringArrayExtra("GreenSoundPath_from_beat");
            btn_sound = get__intent.getIntArrayExtra("btn_sounds_from_beat");

        }


        final Button[] beat_btn = {beat_1row_1button, beat_1row_2button, beat_1row_3button, beat_1row_4button,
                beat_2row_1button, beat_2row_2button, beat_2row_3button, beat_2row_4button,
                beat_3row_1button, beat_3row_2button, beat_3row_3button, beat_3row_4button,
                beat_4row_1button, beat_4row_2button, beat_4row_3button, beat_4row_4button};

        back = findViewById(R.id.play_beat_back);
        insert = findViewById(R.id.play_beat_setting_save_button);

        sound_select_layout = findViewById(R.id.sound_select_layout);
        insert_btn_layout = findViewById(R.id.insert_btn_layout);

        btn_insert.setOnClickListener(new View.OnClickListener() {  //파란색,노란색,오렌지 누르고나서 버튼에 넣기 버튼 눌렀을때
            @Override
            public void onClick(View view) {
                if(saveColor == null) {
                    Context c = view.getContext();
                    Toast.makeText(c, "비트을 선택하세요", Toast.LENGTH_LONG).show();
                }
                else if(saveColor != null){
                    for(int i = 0; i<16; i++) {
                        if (saveIndex_array[i] == 0) {
                            if (saveColor.equals("blue") || saveColor_array[i].equals("blue")) {
                                beat_btn[i].setBackgroundResource(R.drawable.no_select_style_blue);
                            } else if (saveColor.equals("yellow") || saveColor_array[i].equals("yellow")) {
                                beat_btn[i].setBackgroundResource(R.drawable.no_select_style_yellow);
                            } else if (saveColor.equals("orange") || saveColor_array[i].equals("orange")) {
                                beat_btn[i].setBackgroundResource(R.drawable.no_select_style_orange);
                            } else if (saveColor.equals("indigo") || saveColor_array[i].equals("indigo")) {
                                beat_btn[i].setBackgroundResource(R.drawable.no_select_style_indigo);
                            } else if (saveColor.equals("green") || saveColor_array[i].equals("green")) {
                                beat_btn[i].setBackgroundResource(R.drawable.no_select_style_green);
                            }
                        }
                    }


                    sound_select_layout.setVisibility(View.INVISIBLE);
                    insert_btn_layout.setVisibility(View.VISIBLE);

                }
            }
        });

        insert.setOnClickListener(new View.OnClickListener() { //버튼에 넣고 넣기버튼 눌렀을때
            @Override
            public void onClick(View v) {
                insert_btn_layout.setVisibility(View.INVISIBLE);
                sound_select_layout.setVisibility(View.VISIBLE);

                saveColor_array[save_beat_index] = saveColor;

                saveColor = null;
                saveIndex = 0;

                for(int i = 0; i<16; i++) {
                    if(saveIndex_array[i] == 1){
                        saveIndex_array[i] = -1;
                    }

                    soundbulebtns.get(i).setBackgroundResource(R.drawable.button_1row_style);
                    soundyellowbtns.get(i).setBackgroundResource(R.drawable.button_2row_style);
                    soundorangebtns.get(i).setBackgroundResource(R.drawable.button_3row_style);
                    soundindigobtns.get(i).setBackgroundResource(R.drawable.button_4row_style);
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert_btn_layout.setVisibility(View.INVISIBLE);
                sound_select_layout.setVisibility(View.VISIBLE);
            }
        });

        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Play_beat.class);
                Intent getIntent = getIntent();

                intent.putExtra("saveColorArray",saveColor_array);
                intent.putExtra("not_green_arrays",saveIndex_array);
                intent.putExtra("GreenIndex_array",saveGreenIndex_array);
                intent.putExtra("GreenSoundPath",saveGreenSoundPath);
                intent.putExtra("btn_sounds",btn_sound);
                intent.putExtra("select_index",saveIndex);
                intent.putExtra("sync_array",sync_sound_path);


                intent.putExtra("saveGreenSoundPath",saveGreenSoundPath);
                intent.putExtra("sync23",sync_sound_path);
                intent.putExtra("sound1234",btn_sound);
                intent.putExtra("go_from_setting",500);

                startActivity(intent);
            }
        });

        go_record = findViewById(R.id.go_record_btn);
        go_load = findViewById(R.id.go_load_btn);

        go_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Play_beat_setting_record.class);
                intent.putExtra("getted_index",saveIndex);  //지금 누른 인덱스
                intent.putExtra("saveColorArray",saveColor_array);
                intent.putExtra("not_green_arrays",saveIndex_array);
                intent.putExtra("save_sound_array",saveGreenSound_array);       //소리가 담긴 배열
                intent.putExtra("saved_index", saveGreenIndex_array);           //누른곳의 인덱스에 100부터 넣어져있는 배열
                intent.putExtra("saved_path", saveGreenSoundPath);              //path가 담긴 배열
                intent.putExtra("sync",sync_sound_path);                        //path랑 소리인덱스
                startActivity(intent);
            }
        });

        go_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Play_beat_setting_load.class);
                intent.putExtra("saveColorArray",saveColor_array);
                intent.putExtra("not_green_arrays",saveIndex_array);
                intent.putExtra("GreenIndex_array",saveGreenIndex_array);
                intent.putExtra("GreenSoundPath",saveGreenSoundPath);
                intent.putExtra("btn_sounds",btn_sound);
                intent.putExtra("select_index",saveIndex);
                intent.putExtra("sync_array",sync_sound_path);
                Log.d("고로드",saveGreenIndex_array+"  "+saveGreenSound_array+" "+String.valueOf(btn_sound));
                startActivity(intent);
            }
        });
        Play_beat_setting_SoundPlayer soundPlayer = new Play_beat_setting_SoundPlayer(getApplicationContext());
        savebtns = new ArrayList<ToggleButton>();

        beat_button = new ArrayList<Button>();
        addbeatbtn();
        soundbulebtns = new ArrayList<Button>();
        addsoundblue();
        soundyellowbtns = new ArrayList<ToggleButton>();
        addsoundyellow();
        soundorangebtns = new ArrayList<ToggleButton>();
        addsoundorange();
        soundindigobtns = new ArrayList<ToggleButton>();
        addsoundindigo();
        soundgreenbtns = new ArrayList<ToggleButton>();
        addsoundgreen();

        green_layout = findViewById(R.id.green_layout);
        original_layout = findViewById(R.id.original_layout);

        final ArrayList<String> items = new ArrayList<String>();
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice,items);
        final GridLayout beatmaker_one = (GridLayout)findViewById(R.id.beatmaker_one);


        Button beatmaker_btn1 = (Button) findViewById(R.id.beatmaker_btn1);
        Button beatmaker_btn2 = (Button) findViewById(R.id.beatmaker_btn2);
        Button beatmaker_btn3 = (Button) findViewById(R.id.beatmaker_btn3);
        Button beatmaker_btn4 = (Button) findViewById(R.id.beatmaker_btn4);
        Button beatmaker_btn5 = (Button) findViewById(R.id.beatmaker_btn5);


        beatmaker_btn1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeView(0);
            }
        });
        beatmaker_btn2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeView(1);
            }
        });
        beatmaker_btn3.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v){
                changeView(2);
            }
        });
        beatmaker_btn4.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                changeView(3);
            }
        });
        beatmaker_btn5.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v){
                changeView(4);
            }
        });

        beatmaker_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeView(0);
                green_layout.setVisibility(View.INVISIBLE);
                original_layout.setVisibility(View.VISIBLE);
            }
        });

        beatmaker_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeView(1);
                green_layout.setVisibility(View.INVISIBLE);
                original_layout.setVisibility(View.VISIBLE);
            }
        });
        beatmaker_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeView(2);
                green_layout.setVisibility(View.INVISIBLE);
                original_layout.setVisibility(View.VISIBLE);
            }
        });
        beatmaker_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeView(3);
                green_layout.setVisibility(View.INVISIBLE);
                original_layout.setVisibility(View.VISIBLE);
            }
        });

        beatmaker_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeView(4);
                original_layout.setVisibility(View.INVISIBLE);
                green_layout.setVisibility(View.VISIBLE);
            }
        });

//

    }

    public void addbeatbtn(){
        beat_button.add((Button) findViewById(R.id.beat_1row_1button));
        beat_button.add((Button) findViewById(R.id.beat_1row_2button));
        beat_button.add((Button) findViewById(R.id.beat_1row_3button));
        beat_button.add((Button) findViewById(R.id.beat_1row_4button));
        beat_button.add((Button) findViewById(R.id.beat_2row_1button));
        beat_button.add((Button) findViewById(R.id.beat_2row_2button));
        beat_button.add((Button) findViewById(R.id.beat_2row_3button));
        beat_button.add((Button) findViewById(R.id.beat_2row_4button));
        beat_button.add((Button) findViewById(R.id.beat_3row_1button));
        beat_button.add((Button) findViewById(R.id.beat_3row_2button));
        beat_button.add((Button) findViewById(R.id.beat_3row_3button));
        beat_button.add((Button) findViewById(R.id.beat_3row_4button));
        beat_button.add((Button) findViewById(R.id.beat_4row_1button));
        beat_button.add((Button) findViewById(R.id.beat_4row_2button));
        beat_button.add((Button) findViewById(R.id.beat_4row_3button));
        beat_button.add((Button) findViewById(R.id.beat_4row_4button));

        for(final Button select_btn : beat_button){     //버튼 셋팅하는 그 버튼들 클릭시
            select_btn.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    if (event.getAction() == MotionEvent.ACTION_DOWN) {

                        save_beat_index = Integer.parseInt(String.valueOf(v.getTag())) - 1;
                        for (int i = 0; i < 16; i++) {
                            if (saveIndex_array[i] >= 0) {
                                saveIndex_array[i] = 0;
                            }

                        }

                        if (saveIndex_array[(Integer.parseInt(String.valueOf(v.getTag())) - 1)] == -1) { //원래 설정해놓은 버튼을 클릭시

                        } else if (saveIndex_array[(Integer.parseInt(String.valueOf(v.getTag())) - 1)] == 0) {
                            saveIndex_array[(Integer.parseInt(String.valueOf(v.getTag())) - 1)] = 1;


                            for (int i = 0; i < 16; i++) {
                                if (saveIndex_array[i] != -1 && saveIndex_array[i] != 1) {
                                    saveIndex_array[i] = 0;
                                }
                            }

                            for (int i = 0; i < 16; i++) {
                                if (saveIndex_array[i] == 0) {
                                    if (saveColor.equals("blue")) {
                                        beat_button.get(i).setBackgroundResource(R.drawable.no_select_style_blue);
                                    } else if (saveColor.equals("yellow")) {
                                        beat_button.get(i).setBackgroundResource(R.drawable.no_select_style_yellow);
                                    } else if (saveColor.equals("orange")) {
                                        beat_button.get(i).setBackgroundResource(R.drawable.no_select_style_orange);
                                    } else if (saveColor.equals("indigo")) {
                                        beat_button.get(i).setBackgroundResource(R.drawable.no_select_style_indigo);
                                    } else if (saveColor.equals("green")) {
                                        beat_button.get(i).setBackgroundResource(R.drawable.no_select_style_green);
                                    }
                                }
                            }
                            if (saveColor.equals("blue")) {
                                beat_button.get(Integer.parseInt(String.valueOf(v.getTag())) - 1).setBackgroundResource(R.drawable.button_1row_style);
                            } else if (saveColor.equals("yellow")) {
                                beat_button.get(Integer.parseInt(String.valueOf(v.getTag())) - 1).setBackgroundResource(R.drawable.button_2row_style);
                            } else if (saveColor.equals("orange")) {
                                beat_button.get(Integer.parseInt(String.valueOf(v.getTag())) - 1).setBackgroundResource(R.drawable.button_3row_style);
                            } else if (saveColor.equals("indigo")) {
                                beat_button.get(Integer.parseInt(String.valueOf(v.getTag())) - 1).setBackgroundResource(R.drawable.button_4row_style);
                            } else if (saveColor.equals("green")) {
                                beat_button.get(Integer.parseInt(String.valueOf(v.getTag())) - 1).setBackgroundResource(R.drawable.button_5row_style);
                            }
                            if (saveColor.equals("green")) {
                                btn_sound[Integer.parseInt(String.valueOf(v.getTag())) - 1] = Play_beat_setting_SoundPlayer.loadSound(saveColor, saveIndex + 65);

                                for(int i = 0; i<16; i++){
                                    if (saveIndex_array[i] == 0) {
                                        btn_sound[i] = 0;
                                    }
                                }
                            } else {
                                if (saveIndex_array[Integer.parseInt(String.valueOf(v.getTag())) - 1] == 1) {

                                    btn_sound[Integer.parseInt(String.valueOf(v.getTag())) - 1] = Play_beat_setting_SoundPlayer.loadSound(saveColor, saveIndex);
                                    for(int i = 0; i<16; i++){
                                        if (saveIndex_array[i] == 0) {
                                            btn_sound[i] = 0;
                                        }
                                    }
                                    Toast.makeText(getApplicationContext(), String.valueOf(btn_sound[Integer.parseInt(String.valueOf(v.getTag())) - 1]), Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                    }
                    return false;
                }
            });
        }
    }
    public void addsoundblue(){
        soundbulebtns.add((Button) findViewById(R.id.blue_btn1));
        soundbulebtns.add((Button) findViewById(R.id.blue_btn2));
        soundbulebtns.add((Button) findViewById(R.id.blue_btn3));
        soundbulebtns.add((Button) findViewById(R.id.blue_btn4));
        soundbulebtns.add((Button) findViewById(R.id.blue_btn5));
        soundbulebtns.add((Button) findViewById(R.id.blue_btn6));
        soundbulebtns.add((Button) findViewById(R.id.blue_btn7));
        soundbulebtns.add((Button) findViewById(R.id.blue_btn8));
        soundbulebtns.add((Button) findViewById(R.id.blue_btn9));
        soundbulebtns.add((Button) findViewById(R.id.blue_btn10));
        soundbulebtns.add((Button) findViewById(R.id.blue_btn11));
        soundbulebtns.add((Button) findViewById(R.id.blue_btn12));
        soundbulebtns.add((Button) findViewById(R.id.blue_btn13));
        soundbulebtns.add((Button) findViewById(R.id.blue_btn14));
        soundbulebtns.add((Button) findViewById(R.id.blue_btn15));
        soundbulebtns.add((Button) findViewById(R.id.blue_btn16));


        for (final Button soundPad : soundbulebtns){
            soundPad.setOnTouchListener(new View.OnTouchListener() {
//                EditText edittext = (EditText)findViewById(R.id.edittext);

                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {

                    Button btn_insert = (Button)findViewById(R.id.btn_insert);
                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        Play_beat_setting_SoundPlayer.playBlueSound(Integer.parseInt(String.valueOf(view.getTag())));
                        saveColor = "blue";
                        saveIndex = Integer.parseInt(String.valueOf(view.getTag()));
                    }
                    if (motionEvent.getAction() == MotionEvent.ACTION_BUTTON_PRESS) {

                        return true;
                    }
                    if (motionEvent.getAction() == MotionEvent.ACTION_BUTTON_RELEASE) {
                        return true;
                    }

                    else {

                        for(int i = 0; i<16; i++){
                            soundyellowbtns.get(i).setBackgroundResource(R.drawable.button_2row_style);
                            soundorangebtns.get(i).setBackgroundResource(R.drawable.button_3row_style);
                            soundindigobtns.get(i).setBackgroundResource(R.drawable.button_4row_style);
                        }
                        for( int i = 0; i<(Integer.parseInt(String.valueOf(view.getTag()))); i++) {

                            soundbulebtns.get(i).setBackgroundResource(R.drawable.button_1row_style);


                        }
                        for(int i= (Integer.parseInt(String.valueOf(view.getTag()))); i<16; i++ ){
                            soundbulebtns.get(i).setBackgroundResource(R.drawable.button_1row_style);
                        }
                        soundPad.setBackgroundResource(R.drawable.selected_1row_style);
                    }
                    return false;
                }

            });

        }

    }


    public void addsoundyellow() {
        View beatmaker_yellow = (View) findViewById(R.id.main_beatmaker_yellow);

        soundyellowbtns.add((ToggleButton) beatmaker_yellow.findViewById(R.id.yellow_btn1));
        soundyellowbtns.add((ToggleButton) beatmaker_yellow.findViewById(R.id.yellow_btn2));
        soundyellowbtns.add((ToggleButton) beatmaker_yellow.findViewById(R.id.yellow_btn3));
        soundyellowbtns.add((ToggleButton) beatmaker_yellow.findViewById(R.id.yellow_btn4));
        soundyellowbtns.add((ToggleButton) beatmaker_yellow.findViewById(R.id.yellow_btn5));
        soundyellowbtns.add((ToggleButton) beatmaker_yellow.findViewById(R.id.yellow_btn6));
        soundyellowbtns.add((ToggleButton) beatmaker_yellow.findViewById(R.id.yellow_btn7));
        soundyellowbtns.add((ToggleButton) beatmaker_yellow.findViewById(R.id.yellow_btn8));
        soundyellowbtns.add((ToggleButton) beatmaker_yellow.findViewById(R.id.yellow_btn9));
        soundyellowbtns.add((ToggleButton) beatmaker_yellow.findViewById(R.id.yellow_btn10));
        soundyellowbtns.add((ToggleButton) beatmaker_yellow.findViewById(R.id.yellow_btn11));
        soundyellowbtns.add((ToggleButton) beatmaker_yellow.findViewById(R.id.yellow_btn12));
        soundyellowbtns.add((ToggleButton) beatmaker_yellow.findViewById(R.id.yellow_btn13));
        soundyellowbtns.add((ToggleButton) beatmaker_yellow.findViewById(R.id.yellow_btn14));
        soundyellowbtns.add((ToggleButton) beatmaker_yellow.findViewById(R.id.yellow_btn15));
        soundyellowbtns.add((ToggleButton) beatmaker_yellow.findViewById(R.id.yellow_btn16));

        for (int i = 0; i < 16; i++) {
            soundyellowbtns.get(i).setChecked(true);
        }

        for (final ToggleButton soundPad : soundyellowbtns) {
            soundPad.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (soundPad.isChecked()) {
                        soundPad.setBackgroundColor(Color.BLACK);

                        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                            Play_beat_setting_SoundPlayer.playYellowSound(Integer.parseInt(String.valueOf(view.getTag())));
                            soundPad.setChecked(false);
                        }
                        if (motionEvent.getAction() == MotionEvent.ACTION_BUTTON_PRESS) {
                            return true;
                        }
                        if (motionEvent.getAction() == MotionEvent.ACTION_BUTTON_RELEASE) {
                            return true;
                        }
                    }
                    else {
                        for(int i = 0; i<16; i++){
                            soundbulebtns.get(i).setBackgroundResource(R.drawable.button_1row_style);
                            soundorangebtns.get(i).setBackgroundResource(R.drawable.button_3row_style);
                            soundindigobtns.get(i).setBackgroundResource(R.drawable.button_4row_style);
                        }

                        for (int i = 16; i < (Integer.parseInt(String.valueOf(view.getTag()))); i++) {
                            soundyellowbtns.get(i-16).setBackgroundResource(R.drawable.button_2row_style);
                            saveColor = "yellow";
                            saveIndex = Integer.parseInt(String.valueOf(view.getTag()));
                        }
                        for (int i = (Integer.parseInt(String.valueOf(view.getTag()))); i < 32; i++) {
                            soundyellowbtns.get(i-16).setBackgroundResource(R.drawable.button_2row_style);


                        }

                        soundPad.setBackgroundResource(R.drawable.selected_2row_style);
                    }
                    return false;
                }
            });
        }
    }

    public void addsoundorange(){
        View beatmaker_orange = (View)findViewById(R.id.main_beatmaker_orange);

        soundorangebtns.add((ToggleButton) beatmaker_orange.findViewById(R.id.orange_btn1));
        soundorangebtns.add((ToggleButton) beatmaker_orange.findViewById(R.id.orange_btn2));
        soundorangebtns.add((ToggleButton) beatmaker_orange.findViewById(R.id.orange_btn3));
        soundorangebtns.add((ToggleButton) beatmaker_orange.findViewById(R.id.orange_btn4));
        soundorangebtns.add((ToggleButton) beatmaker_orange.findViewById(R.id.orange_btn5));
        soundorangebtns.add((ToggleButton) beatmaker_orange.findViewById(R.id.orange_btn6));
        soundorangebtns.add((ToggleButton) beatmaker_orange.findViewById(R.id.orange_btn7));
        soundorangebtns.add((ToggleButton) beatmaker_orange.findViewById(R.id.orange_btn8));
        soundorangebtns.add((ToggleButton) beatmaker_orange.findViewById(R.id.orange_btn9));
        soundorangebtns.add((ToggleButton) beatmaker_orange.findViewById(R.id.orange_btn10));
        soundorangebtns.add((ToggleButton) beatmaker_orange.findViewById(R.id.orange_btn11));
        soundorangebtns.add((ToggleButton) beatmaker_orange.findViewById(R.id.orange_btn12));
        soundorangebtns.add((ToggleButton) beatmaker_orange.findViewById(R.id.orange_btn13));
        soundorangebtns.add((ToggleButton) beatmaker_orange.findViewById(R.id.orange_btn14));
        soundorangebtns.add((ToggleButton) beatmaker_orange.findViewById(R.id.orange_btn15));
        soundorangebtns.add((ToggleButton) beatmaker_orange.findViewById(R.id.orange_btn16));

        for (int i = 0; i < 16; i++) {
            soundorangebtns.get(i).setChecked(true);
        }
        for (final ToggleButton soundPad : soundorangebtns){
            soundPad.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (soundPad.isChecked()) {
                        soundPad.setBackgroundColor(Color.BLACK);
                        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                            Play_beat_setting_SoundPlayer.playOrangeSound(Integer.parseInt(String.valueOf(view.getTag())));
                            saveColor = "orange";
                            saveIndex = Integer.parseInt(String.valueOf(view.getTag()));
                            soundPad.setChecked(false);
                        }
                        if (motionEvent.getAction() == MotionEvent.ACTION_BUTTON_PRESS) {
                            return true;
                        }
                        if (motionEvent.getAction() == MotionEvent.ACTION_BUTTON_RELEASE) {
                            return true;
                        }
                    }
                    else{
                        for(int i = 0; i<16; i++){
                            soundbulebtns.get(i).setBackgroundResource(R.drawable.button_1row_style);
                            soundyellowbtns.get(i).setBackgroundResource(R.drawable.button_2row_style);
                            soundindigobtns.get(i).setBackgroundResource(R.drawable.button_4row_style);
                        }
                        for (int i = 32; i < (Integer.parseInt(String.valueOf(view.getTag()))); i++) {
                            soundorangebtns.get(i-32).setBackgroundResource(R.drawable.button_3row_style);
                        }
                        for (int i = (Integer.parseInt(String.valueOf(view.getTag()))); i < 48; i++) {
                            soundorangebtns.get(i-32).setBackgroundResource(R.drawable.button_3row_style);
                        }
                        soundPad.setBackgroundResource(R.drawable.selected_3row_style);
                    }
                    return false;
                }
            });
        }
    }

    public void addsoundindigo(){
        View beatmaker_indigo = (View)findViewById(R.id.main_beatmaker_indogo);

        soundindigobtns.add((ToggleButton) beatmaker_indigo.findViewById(R.id.indigo_btn1));
        soundindigobtns.add((ToggleButton) beatmaker_indigo.findViewById(R.id.indigo_btn2));
        soundindigobtns.add((ToggleButton) beatmaker_indigo.findViewById(R.id.indigo_btn3));
        soundindigobtns.add((ToggleButton) beatmaker_indigo.findViewById(R.id.indigo_btn4));
        soundindigobtns.add((ToggleButton) beatmaker_indigo.findViewById(R.id.indigo_btn5));
        soundindigobtns.add((ToggleButton) beatmaker_indigo.findViewById(R.id.indigo_btn6));
        soundindigobtns.add((ToggleButton) beatmaker_indigo.findViewById(R.id.indigo_btn7));
        soundindigobtns.add((ToggleButton) beatmaker_indigo.findViewById(R.id.indigo_btn8));
        soundindigobtns.add((ToggleButton) beatmaker_indigo.findViewById(R.id.indigo_btn9));
        soundindigobtns.add((ToggleButton) beatmaker_indigo.findViewById(R.id.indigo_btn10));
        soundindigobtns.add((ToggleButton) beatmaker_indigo.findViewById(R.id.indigo_btn11));
        soundindigobtns.add((ToggleButton) beatmaker_indigo.findViewById(R.id.indigo_btn12));
        soundindigobtns.add((ToggleButton) beatmaker_indigo.findViewById(R.id.indigo_btn13));
        soundindigobtns.add((ToggleButton) beatmaker_indigo.findViewById(R.id.indigo_btn14));
        soundindigobtns.add((ToggleButton) beatmaker_indigo.findViewById(R.id.indigo_btn15));
        soundindigobtns.add((ToggleButton) beatmaker_indigo.findViewById(R.id.indigo_btn16));

        for (int i = 0; i < 16; i++) {
            soundindigobtns.get(i).setChecked(true);
        }
        for (final ToggleButton soundPad : soundindigobtns){
            soundPad.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (soundPad.isChecked()) {
                        soundPad.setBackgroundColor(Color.BLACK);

                        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                            Play_beat_setting_SoundPlayer.playIndigoSound(Integer.parseInt(String.valueOf(view.getTag())));
                            saveColor = "indigo";
                            saveIndex = Integer.parseInt(String.valueOf(view.getTag()));

                            Log.d("??ㅇㅇㅇㅇㅇㅇ?", "잘됬냐? "+ saveColor+String.valueOf(saveIndex));
                            soundPad.setChecked(false);
                        }

                        if (motionEvent.getAction() == MotionEvent.ACTION_BUTTON_PRESS) {
                            return true;
                        }
                        if (motionEvent.getAction() == MotionEvent.ACTION_BUTTON_RELEASE) {
                            return true;
                        }
                    }
                    else{
                        for(int i = 0; i<16; i++){
                            soundbulebtns.get(i).setBackgroundResource(R.drawable.button_1row_style);
                            soundyellowbtns.get(i).setBackgroundResource(R.drawable.button_2row_style);
                            soundorangebtns.get(i).setBackgroundResource(R.drawable.button_3row_style);

                        }
                        for (int i = 48; i < (Integer.parseInt(String.valueOf(view.getTag()))); i++) {
                            soundindigobtns.get(i-48).setBackgroundResource(R.drawable.button_4row_style);
                        }
                        for (int i = (Integer.parseInt(String.valueOf(view.getTag()))); i < 64; i++) {
                            soundindigobtns.get(i-48).setBackgroundResource(R.drawable.button_4row_style);
                        }
                        soundPad.setBackgroundResource(R.drawable.selected_4row_style);
                    }
                    return false;
                }
            });
        }

    }

    public void setSaveGreenIndex_array(int index, int minus){
        this.saveGreenIndex_array[index] = minus;
    }

    public void setSaveGreenIndex_array(int[] array){
        this.saveGreenIndex_array = array;
    }
    public int[] getSaveGreenIndex_array(){
        return this.saveGreenIndex_array;
    }

    public void setSaveGreenSoundPath(String[] array){
        this.saveGreenSoundPath = array;
    }
    public String[] getSaveGreenSoundPath(){
        return this.saveGreenSoundPath;
    }





    public void addsoundgreen(){
        View beatmaker_green = (View)findViewById(R.id.main_beatmaker_green);
        final SoundPool sp;

        sp = new SoundPool(100, AudioManager.STREAM_MUSIC, 0);
        green_button1 = findViewById(R.id.green_btn1);
        green_button2 = findViewById(R.id.green_btn2);
        green_button3 = findViewById(R.id.green_btn3);
        green_button4 = findViewById(R.id.green_btn4);
        green_button5 = findViewById(R.id.green_btn5);
        green_button6 = findViewById(R.id.green_btn6);
        green_button7 = findViewById(R.id.green_btn7);
        green_button8 = findViewById(R.id.green_btn8);
        green_button9 = findViewById(R.id.green_btn9);
        green_button10 = findViewById(R.id.green_btn10);
        green_button11 = findViewById(R.id.green_btn11);
        green_button12 = findViewById(R.id.green_btn12);
        green_button13 = findViewById(R.id.green_btn13);
        green_button14 = findViewById(R.id.green_btn14);
        green_button15 = findViewById(R.id.green_btn15);
        green_button16 = findViewById(R.id.green_btn16);

        soundgreenbtns.add((ToggleButton) beatmaker_green.findViewById(R.id.green_btn1));
        soundgreenbtns.add((ToggleButton) beatmaker_green.findViewById(R.id.green_btn2));
        soundgreenbtns.add((ToggleButton) beatmaker_green.findViewById(R.id.green_btn3));
        soundgreenbtns.add((ToggleButton) beatmaker_green.findViewById(R.id.green_btn4));
        soundgreenbtns.add((ToggleButton) beatmaker_green.findViewById(R.id.green_btn5));
        soundgreenbtns.add((ToggleButton) beatmaker_green.findViewById(R.id.green_btn6));
        soundgreenbtns.add((ToggleButton) beatmaker_green.findViewById(R.id.green_btn7));
        soundgreenbtns.add((ToggleButton) beatmaker_green.findViewById(R.id.green_btn8));
        soundgreenbtns.add((ToggleButton) beatmaker_green.findViewById(R.id.green_btn9));
        soundgreenbtns.add((ToggleButton) beatmaker_green.findViewById(R.id.green_btn10));
        soundgreenbtns.add((ToggleButton) beatmaker_green.findViewById(R.id.green_btn11));
        soundgreenbtns.add((ToggleButton) beatmaker_green.findViewById(R.id.green_btn12));
        soundgreenbtns.add((ToggleButton) beatmaker_green.findViewById(R.id.green_btn13));
        soundgreenbtns.add((ToggleButton) beatmaker_green.findViewById(R.id.green_btn14));
        soundgreenbtns.add((ToggleButton) beatmaker_green.findViewById(R.id.green_btn15));
        soundgreenbtns.add((ToggleButton) beatmaker_green.findViewById(R.id.green_btn16));

        final ToggleButton[] green_buttons = {green_button1,green_button2,green_button3,green_button4,green_button5,green_button6,green_button7,green_button8,
                green_button9,green_button10,green_button11,green_button12,green_button13,green_button14,green_button15,green_button16};

        Intent intent = getIntent();


        final float loaded_volume = intent.getFloatExtra("sound",-1);

        int loaded_index;
        if(loaded_volume != -1.0){

            loaded_index = intent.getIntExtra("select_index",-1);
            int[] array = intent.getIntArrayExtra("GreenIndex_array");
            String[] patharr = intent.getStringArrayExtra("GreenSoundPath");
            saveIndex_array = intent.getIntArrayExtra("not_green_array");
            saveColor_array = intent.getStringArrayExtra("saveColorArray");
            String[] saveColor_array_two = intent.getStringArrayExtra("saveColorArray2");

            saveGreenIndex_array = array;
            saveGreenSoundPath = patharr;


            if(intent.getIntArrayExtra("from_setvolume_btn_sound") != null) {
                btn_sound = intent.getIntArrayExtra("from_setvolume_btn_sound");
            }

            String loaded_sound = intent.getStringExtra("file");
            for(int i=0; i<16; i++){
                if(saveIndex_array[i] <0){
                    if (saveColor_array[i].equals("blue")) {
                        beat_button.get(i).setBackgroundResource(R.drawable.button_1row_style);
                    } else if (saveColor_array[i].equals("yellow")) {
                        beat_button.get(i).setBackgroundResource(R.drawable.button_2row_style);
                    } else if (saveColor_array[i].equals("orange")) {
                        beat_button.get(i).setBackgroundResource(R.drawable.button_3row_style);
                    } else if (saveColor_array[i].equals("indigo")) {
                        beat_button.get(i).setBackgroundResource(R.drawable.button_4row_style);
                    } else if (saveColor_array[i].equals("green")) {
                        beat_button.get(i).setBackgroundResource(R.drawable.button_5row_style);
                    }
                }
            }

            int plus = 0;   //-1을 주는게아니고 들어올때마다 순서를 정해주기 위함
            for(int i=0;i<16;i++) {

                if(saveGreenIndex_array[i] >99){
                    plus= plus+1;
                }

            }

            saveGreenSoundPath[loaded_index] = loaded_sound;
            saveGreenIndex_array[loaded_index] = 100+plus;

            for(int i=0;i<16;i++) {
                saveGreenSound_array[i] = sp.load(saveGreenSoundPath[i],1);
            }
            for(int i = 0; i<16; i++) {
                if (saveGreenIndex_array[i] > 99) {    //차있는 경우에 초록색으로 세팅
                    green_buttons[i].setBackgroundResource(R.drawable.button_5row_style);

                }
            }

        }

        int sival = intent.getIntExtra("original_index",-1);     //인덱스
        String recorded_sound = intent.getStringExtra("record_sound");      //사운드path

        int[] getted_save_sound = intent.getIntArrayExtra("loaded_saved_sound");

        sync_sound_path = intent.getIntArrayExtra("sync");


        Log.d("시발 되는겨?"," "+String.valueOf(sival)+" "+recorded_sound);
        if(intent.getIntExtra("into_the_unknown",1) == 1000){
            for(int i=0;i<16;i++) {
                saveGreenSound_array[i] = sp.load(saveGreenSoundPath[i],1);
            }

            for(int i = 0; i<16; i++) {
                if (saveGreenIndex_array[i] > 99) {    //차있는 경우에 초록색으로 세팅
                    green_buttons[i].setBackgroundResource(R.drawable.button_5row_style);

                }

            }
        }
      if(sival !=-1 && !recorded_sound.isEmpty()) {

            saveGreenSoundPath = intent.getStringArrayExtra("loaded_sound_path");
            saveGreenIndex_array = intent.getIntArrayExtra("loaded_saved_index");

            String[] saveColor_array_two = intent.getStringArrayExtra("saveColorArray2");
            saveGreenSoundPath[sival] = recorded_sound; //가져온 소리 저장


            int plus = 0;   //-1을 주는게아니고 들어올때마다 순서를 정해주기 위함
            for(int i=0;i<16;i++) {
                if(saveGreenIndex_array[i] >99){
                    plus= plus+1;
                }
            }
            saveGreenIndex_array[sival] = 100+plus;

            for(int i=0;i<16;i++) {
                saveGreenSound_array[i] = sp.load(saveGreenSoundPath[i],1);
            }

            for(int i = 0; i<16; i++) {
                if (saveGreenIndex_array[i] > 99) {    //차있는 경우에 초록색으로 세팅
                    green_buttons[i].setBackgroundResource(R.drawable.button_5row_style);

                }

            }
            saveIndex_array = intent.getIntArrayExtra("not_green_arrays2");
            for(int i=0; i<16; i++){
                if(saveIndex_array[i] <0){
                    if (saveColor_array[i].equals("blue") || saveColor_array_two[i].equals("blue")) {
                        beat_button.get(i).setBackgroundResource(R.drawable.button_1row_style);
                    } else if (saveColor_array[i].equals("yellow") || saveColor_array_two[i].equals("yellow")) {
                        beat_button.get(i).setBackgroundResource(R.drawable.button_2row_style);
                    } else if (saveColor_array[i].equals("orange") || saveColor_array_two[i].equals("orange")) {
                        beat_button.get(i).setBackgroundResource(R.drawable.button_3row_style);
                    } else if (saveColor_array[i].equals("indigo") || saveColor_array_two[i].equals("indigo")) {
                        beat_button.get(i).setBackgroundResource(R.drawable.button_4row_style);
                    } else if (saveColor_array[i].equals("green") || saveColor_array_two[i].equals("green")) {
                        beat_button.get(i).setBackgroundResource(R.drawable.button_5row_style);
                    }
                }
            }

        }
        for (int i = 0; i < 16; i++) {
            green_buttons[i].setChecked(true);
        }

        for (final ToggleButton soundPad : green_buttons){
            soundPad.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {

                    if (soundPad.isChecked()) {
                        if (saveGreenIndex_array[Integer.parseInt(String.valueOf(view.getTag())) -65] < 100) { //선택안된거 눌렀을때
                            for (int i = 0; i < 16 ; i++) {
                                if (saveGreenIndex_array[i] < 99) {
                                    green_buttons[i].setBackgroundColor(Color.rgb(255, 255, 255));
                                }
                                green_buttons[Integer.parseInt(String.valueOf(view.getTag())) - 65].setBackgroundResource(R.drawable.selected_5row_style);
                            }
                            soundPad.setChecked(false);
                            original_layout.setVisibility(View.INVISIBLE);
                            green_layout.setVisibility(View.VISIBLE);
                            Log.d("11111111111111111111111111","88888888888888888888888");
                        }
                        else if (saveGreenIndex_array[Integer.parseInt(String.valueOf(view.getTag()))-65] >= 100) {
                            sp.play(saveGreenSound_array[Integer.parseInt(String.valueOf(view.getTag()))-65],loaded_volume,loaded_volume,0,0,1f);
                            saveColor="green";
                            saveIndex = Integer.parseInt(String.valueOf(view.getTag()))-65;
                            green_layout.setVisibility(View.INVISIBLE);
                            original_layout.setVisibility(View.VISIBLE);

                        }
                        Log.d("2222222222222222222222","아쎾쓰  "+String.valueOf(saveGreenIndex_array[Integer.parseInt(String.valueOf(view.getTag()))-65]));
                        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
//                            Play_beat_setting_SoundPlayer.playGreenSound(Integer.parseInt(String.valueOf(view.getTag())));
                            saveColor = "green";
                            saveIndex = Integer.parseInt(String.valueOf(view.getTag()))-65;
                            setSaveIndex(saveIndex);


                            soundPad.setChecked(false);
                        }

                        if (motionEvent.getAction() == MotionEvent.ACTION_BUTTON_PRESS) {
                            return true;
                        }
                        if (motionEvent.getAction() == MotionEvent.ACTION_BUTTON_RELEASE) {
                            return true;
                        }
                    }
                    else {
                        if (saveGreenIndex_array[Integer.parseInt(String.valueOf(view.getTag()))-65] < 100) {
                            Log.d("뭔데씨이이이이발",String.valueOf(Integer.parseInt(String.valueOf(view.getTag()))));
                            for (int i = 0; i < 16; i++) {
                                soundbulebtns.get(i).setBackgroundResource(R.drawable.button_1row_style);
                                soundyellowbtns.get(i).setBackgroundResource(R.drawable.button_2row_style);
                                soundorangebtns.get(i).setBackgroundResource(R.drawable.button_3row_style);
                                soundindigobtns.get(i).setBackgroundResource(R.drawable.button_4row_style);
                            }

                            soundPad.setBackgroundResource(R.drawable.selected_5row_style);
                        }
                        else if(saveGreenIndex_array[Integer.parseInt(String.valueOf(view.getTag()))-65] < 0){

                        }
                    }


                    return false;
                }
            });
        }

    }

    public void setSaveIndex(int index){
        this.saveIndex = index;
    }
    public int getsaveIndex(){
        return this.saveIndex;
    }
    private void changeView(int index){
        GridLayout beatmaker_one = (GridLayout) findViewById(R.id.beatmaker_one);
        View beatmaker_yellow = (View) findViewById(R.id.main_beatmaker_yellow);
        View beatmaker_orange = (View)findViewById(R.id.main_beatmaker_orange);
        View beatmaker_indigo = (View)findViewById(R.id.main_beatmaker_indogo);
        View beatmaker_green = (View)findViewById(R.id.main_beatmaker_green);
        switch (index) {
            case 0:
                beatmaker_one.setVisibility(View.VISIBLE);
                beatmaker_yellow.setVisibility(View.INVISIBLE);
                beatmaker_orange.setVisibility(View.INVISIBLE);
                beatmaker_indigo.setVisibility(View.INVISIBLE);
                beatmaker_green.setVisibility(View.INVISIBLE);
                break;
            case 1:
                beatmaker_one.setVisibility(View.INVISIBLE);
                beatmaker_yellow.setVisibility(View.VISIBLE);
                beatmaker_orange.setVisibility(View.INVISIBLE);
                beatmaker_indigo.setVisibility(View.INVISIBLE);
                beatmaker_green.setVisibility(View.INVISIBLE);
                break;
            case 2:
                beatmaker_one.setVisibility(View.INVISIBLE);
                beatmaker_yellow.setVisibility(View.INVISIBLE);
                beatmaker_orange.setVisibility(View.VISIBLE);
                beatmaker_indigo.setVisibility(View.INVISIBLE);
                beatmaker_green.setVisibility(View.INVISIBLE);
                break;
            case 3:
                beatmaker_one.setVisibility(View.INVISIBLE);
                beatmaker_yellow.setVisibility(View.INVISIBLE);
                beatmaker_orange.setVisibility(View.INVISIBLE);
                beatmaker_indigo.setVisibility(View.VISIBLE);
                beatmaker_green.setVisibility(View.INVISIBLE);
                break;
            case 4:
                beatmaker_one.setVisibility(View.INVISIBLE);
                beatmaker_yellow.setVisibility(View.INVISIBLE);
                beatmaker_orange.setVisibility(View.INVISIBLE);
                beatmaker_indigo.setVisibility(View.INVISIBLE);
                beatmaker_green.setVisibility(View.VISIBLE);
        }

    }
}
