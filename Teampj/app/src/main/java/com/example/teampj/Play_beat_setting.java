package com.example.teampj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

//import com.google.android.gms.common.SignInButton;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Play_beat_setting extends AppCompatActivity {

//    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
//    DatabaseReference conditionRef = mRootRef.child("text");


    int saveInteger;
    ArrayList<ToggleButton> savebtns;
    ArrayList<Button> soundbulebtns;
    ArrayList<ToggleButton> soundyellowbtns;
    ArrayList<ToggleButton> soundorangebtns;
    ArrayList<ToggleButton> soundindigobtns;
    ArrayList<ToggleButton> soundgreenbtns;

    LinearLayout green_layout,original_layout;
    Button go_record, go_load;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_beat_setting);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Button btn_insert = (Button)findViewById(R.id.btn_insert);



        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context c = view.getContext();
                Toast.makeText(c,"비트을 선택하세요",Toast.LENGTH_LONG).show();

            }
        });


        go_record = findViewById(R.id.go_record_btn);
        go_load = findViewById(R.id.go_load_btn);

        go_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Play_beat_setting_record.class);
                startActivity(intent);
            }
        });

//        go_load.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), Play_beat_setting_record.class);
//                startActivity(intent);
//            }
//        });
        Play_beat_setting_SoundPlayer soundPlayer = new Play_beat_setting_SoundPlayer(getApplicationContext());
        savebtns = new ArrayList<ToggleButton>();

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

//        for(int i=0; i<16; i++){
//            soundbulebtns.get(i).setChecked(true);
//        }

        for (final Button soundPad : soundbulebtns){
            soundPad.setOnTouchListener(new View.OnTouchListener() {
//                EditText edittext = (EditText)findViewById(R.id.edittext);

                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {

                    Button btn_insert = (Button)findViewById(R.id.btn_insert);
                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        Play_beat_setting_SoundPlayer.playBlueSound(Integer.parseInt(String.valueOf(view.getTag())));

                    }
                    if (motionEvent.getAction() == MotionEvent.ACTION_BUTTON_PRESS) {

                        return true;
                    }
                    if (motionEvent.getAction() == MotionEvent.ACTION_BUTTON_RELEASE) {
                        return true;
                    }

                    else {

                        for(int i = 0; i<16; i++){
                            soundyellowbtns.get(i).setBackgroundColor(Color.rgb(255, 255, 0));
                            soundorangebtns.get(i).setBackgroundColor(Color.rgb(255, 136, 0));
                            soundindigobtns.get(i).setBackgroundColor(Color.rgb(64, 0, 255));
                            soundgreenbtns.get(i).setBackgroundColor(Color.rgb(0, 255, 0));
                        }
                        for( int i = 0; i<(Integer.parseInt(String.valueOf(view.getTag()))); i++) {

                            soundbulebtns.get(i).setBackgroundColor(Color.rgb(0,191,255));
//                            btn_insert.setOnClickListener(new View.OnClickListener() {
//                                @Override
//                                public void onClick(View view) {
//                                    Intent intent = new Intent(getApplicationContext(),Four_four.class);
//
//                                    intent.putExtra("contact",soundbulebtns.toString());
////                                    intent.putExtra("contact",edittext.getText().toString());
//                                    startActivity(intent);
//
//                                }
//                            });
                        }
                        for(int i= (Integer.parseInt(String.valueOf(view.getTag()))); i<16; i++ ){
                            soundbulebtns.get(i).setBackgroundColor(Color.rgb(0,191,255));
                        }
                        soundPad.setBackgroundColor(Color.rgb(204,132,224));
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
                            soundbulebtns.get(i).setBackgroundColor(Color.rgb(0,191,255));
                            soundorangebtns.get(i).setBackgroundColor(Color.rgb(255, 136, 0));
                            soundindigobtns.get(i).setBackgroundColor(Color.rgb(64, 0, 255));
                            soundgreenbtns.get(i).setBackgroundColor(Color.rgb(0, 255, 0));
                        }

                        for (int i = 16; i < (Integer.parseInt(String.valueOf(view.getTag()))); i++) {
                            soundyellowbtns.get(i-16).setBackgroundColor(Color.rgb(255, 255, 0));
                            Toast.makeText(getApplicationContext(),(String.valueOf(view.getTag())), Toast.LENGTH_SHORT).show();
                        }
                        for (int i = (Integer.parseInt(String.valueOf(view.getTag()))); i < 32; i++) {
                            soundyellowbtns.get(i-16).setBackgroundColor(Color.rgb(255, 255, 0));


                        }

                        soundPad.setBackgroundColor(Color.BLACK);
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
                            soundbulebtns.get(i).setBackgroundColor(Color.rgb(0,191,255));
                            soundyellowbtns.get(i).setBackgroundColor(Color.rgb(255, 255, 0));
                            soundindigobtns.get(i).setBackgroundColor(Color.rgb(64, 0, 255));
                            soundgreenbtns.get(i).setBackgroundColor(Color.rgb(0, 255, 0));

                        }
                        for (int i = 32; i < (Integer.parseInt(String.valueOf(view.getTag()))); i++) {
                            soundorangebtns.get(i-32).setBackgroundColor(Color.rgb(255, 136, 0));
                        }
                        for (int i = (Integer.parseInt(String.valueOf(view.getTag()))); i < 48; i++) {
                            soundorangebtns.get(i-32).setBackgroundColor(Color.rgb(255, 136, 0));
                        }
                        soundPad.setBackgroundColor(Color.BLACK);
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
                            soundbulebtns.get(i).setBackgroundColor(Color.rgb(0,191,255));
                            soundorangebtns.get(i).setBackgroundColor(Color.rgb(255, 136, 0));
                            soundyellowbtns.get(i).setBackgroundColor(Color.rgb(255, 255, 0));
                            soundgreenbtns.get(i).setBackgroundColor(Color.rgb(0, 255, 0));
                        }
                        for (int i = 48; i < (Integer.parseInt(String.valueOf(view.getTag()))); i++) {
                            soundindigobtns.get(i-48).setBackgroundColor(Color.rgb(64, 0, 255));
                        }
                        for (int i = (Integer.parseInt(String.valueOf(view.getTag()))); i < 64; i++) {
                            soundindigobtns.get(i-48).setBackgroundColor(Color.rgb(64, 0, 255));
                        }
                        soundPad.setBackgroundColor(Color.BLACK);
                    }
                    return false;
                }
            });
        }

    }
    public void addsoundgreen(){
        View beatmaker_green = (View)findViewById(R.id.main_beatmaker_green);

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

        for (int i = 0; i < 16; i++) {
            soundgreenbtns.get(i).setChecked(true);
        }

        for (final ToggleButton soundPad : soundgreenbtns){
            soundPad.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (soundPad.isChecked()) {
                        soundPad.setBackgroundColor(Color.BLACK);

                        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                            Play_beat_setting_SoundPlayer.playGreenSound(Integer.parseInt(String.valueOf(view.getTag())));
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
                            soundbulebtns.get(i).setBackgroundColor(Color.rgb(0,191,255));
                            soundorangebtns.get(i).setBackgroundColor(Color.rgb(255, 136, 0));
                            soundyellowbtns.get(i).setBackgroundColor(Color.rgb(255, 255, 0));
                            soundindigobtns.get(i).setBackgroundColor(Color.rgb(64, 0, 255));
                        }
                        for (int i = 64; i < (Integer.parseInt(String.valueOf(view.getTag()))); i++) {
                            soundgreenbtns.get(i-64).setBackgroundColor(Color.rgb(0, 255, 0));
                        }
                        for (int i = (Integer.parseInt(String.valueOf(view.getTag()))); i < 80; i++) {
                            soundgreenbtns.get(i-64).setBackgroundColor(Color.rgb(0, 255, 0));
                        }
                        soundPad.setBackgroundColor(Color.BLACK);
                    }
                    return false;
                }
            });
        }

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
