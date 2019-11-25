package com.example.teamproject;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class Play_beat_setting_SoundPlayer {
    static SoundPool sp,ap;

    static int load_sound;

    static int blue_sound1;
    static int blue_sound2;
    static int blue_sound3;
    static int blue_sound4;
    static int blue_sound5;
    static int blue_sound6;
    static int blue_sound7;
    static int blue_sound8;
    static int blue_sound9;
    static int blue_sound10;
    static int blue_sound11;
    static int blue_sound12;
    static int blue_sound13;
    static int blue_sound14;
    static int blue_sound15;
    static int blue_sound16;

    static int[] blue_sounds;

    static int yellow_sound1;
    static int yellow_sound2;
    static int yellow_sound3;
    static int yellow_sound4;
    static int yellow_sound5;
    static int yellow_sound6;
    static int yellow_sound7;
    static int yellow_sound8;
    static int yellow_sound9;
    static int yellow_sound10;
    static int yellow_sound11;
    static int yellow_sound12;
    static int yellow_sound13;
    static int yellow_sound14;
    static int yellow_sound15;
    static int yellow_sound16;

    static int[] yellow_sounds;

    static int orange_sound1;
    static int orange_sound2;
    static int orange_sound3;
    static int orange_sound4;
    static int orange_sound5;
    static int orange_sound6;
    static int orange_sound7;
    static int orange_sound8;
    static int orange_sound9;
    static int orange_sound10;
    static int orange_sound11;
    static int orange_sound12;
    static int orange_sound13;
    static int orange_sound14;
    static int orange_sound15;
    static int orange_sound16;

    static int[] orange_sounds;

    static int indigo_sound1;
    static int indigo_sound2;
    static int indigo_sound3;
    static int indigo_sound4;
    static int indigo_sound5;
    static int indigo_sound6;
    static int indigo_sound7;
    static int indigo_sound8;
    static int indigo_sound9;
    static int indigo_sound10;
    static int indigo_sound11;
    static int indigo_sound12;
    static int indigo_sound13;
    static int indigo_sound14;
    static int indigo_sound15;
    static int indigo_sound16;

    static int[] indigo_sounds;

    static int green_sound1;
    static int green_sound2;
    static int green_sound3;
    static int green_sound4;
    static int green_sound5;
    static int green_sound6;
    static int green_sound7;
    static int green_sound8;
    static int green_sound9;
    static int green_sound10;
    static int green_sound11;
    static int green_sound12;
    static int green_sound13;
    static int green_sound14;
    static int green_sound15;
    static int green_sound16;

    static int[] green_sounds;

    public Play_beat_setting_SoundPlayer(Context context) {

        sp = new SoundPool(30, AudioManager.STREAM_MUSIC, 0);

        blue_sound1 = sp.load(context, R.raw.blue_1, 1);
        blue_sound2 = sp.load(context, R.raw.blue_kick1, 1);
        blue_sound3 = sp.load(context, R.raw.blue_kicka, 1);
        blue_sound4 = sp.load(context, R.raw.blue_singlekick, 1);
        blue_sound5 = sp.load(context, R.raw.blue_loosekik, 1);
        blue_sound6 = sp.load(context, R.raw.blue_electronicsound, 1);
        blue_sound7 = sp.load(context, R.raw.blue_dynohlsn, 1);
        blue_sound8 = sp.load(context, R.raw.blue_dirtysnaredrum, 1);
        blue_sound9 = sp.load(context, R.raw.blue_djembedrum, 1);
        blue_sound10 = sp.load(context, R.raw.blue_heavykick, 1);
        blue_sound11 = sp.load(context, R.raw.blue_what, 1);
        blue_sound12 = sp.load(context, R.raw.blue_djembe, 1);
        blue_sound13 = sp.load(context, R.raw.blue_drumone, 1);
        blue_sound14 = sp.load(context, R.raw.blue_dnbloop, 1);
        blue_sound15 = sp.load(context, R.raw.blue_loop17, 1);
        blue_sound16 = sp.load(context, R.raw.blue_foetus, 1);

        blue_sounds = new int[]{blue_sound1, blue_sound2, blue_sound3, blue_sound4, blue_sound5, blue_sound6, blue_sound7,
                blue_sound8, blue_sound9,blue_sound10,blue_sound11,blue_sound12,blue_sound13,blue_sound14,blue_sound15,blue_sound16};

        yellow_sound1 = sp.load(context, R.raw.yellow_short1, 1);
        yellow_sound2 = sp.load(context, R.raw.yellow_short2, 1);
        yellow_sound3 = sp.load(context, R.raw.yellow_short3, 1);
        yellow_sound4 = sp.load(context, R.raw.yellow_short4, 1);
        yellow_sound5 = sp.load(context, R.raw.yellow_short5, 1);
        yellow_sound6 = sp.load(context, R.raw.yellow_short6, 1);
        yellow_sound7 = sp.load(context, R.raw.yellow_short7, 1);
        yellow_sound8 = sp.load(context, R.raw.yellow_mid1, 1);
        yellow_sound9 = sp.load(context, R.raw.yellow_mid2, 1);
        yellow_sound10 = sp.load(context, R.raw.yellow_mid3, 1);
        yellow_sound11 = sp.load(context, R.raw.yellow_mid4, 1);
        yellow_sound12 = sp.load(context, R.raw.yellow_long1, 1);
        yellow_sound13 = sp.load(context, R.raw.yellow_long2, 1);
        yellow_sound14 = sp.load(context, R.raw.yellow_long3, 1);
        yellow_sound15 = sp.load(context, R.raw.yellow_long4, 1);
        yellow_sound16 = sp.load(context, R.raw.yellow_long5, 1);

        yellow_sounds = new int[]{yellow_sound1, yellow_sound2, yellow_sound3, yellow_sound4, yellow_sound5, yellow_sound6, yellow_sound7,
                yellow_sound8, yellow_sound9,yellow_sound10,yellow_sound11,yellow_sound12,yellow_sound13,yellow_sound14,yellow_sound15,yellow_sound16};

        orange_sound1 = sp.load(context, R.raw.orange_short, 1);
        orange_sound2 = sp.load(context, R.raw.orange_gun, 1);
        orange_sound3 = sp.load(context, R.raw.orange_bomb, 1);
        orange_sound4 = sp.load(context, R.raw.orange_man, 1);
        orange_sound5 = sp.load(context, R.raw.orange_piri, 1);
        orange_sound6 = sp.load(context, R.raw.orange_dragon, 1);
        orange_sound7 = sp.load(context, R.raw.orange_zombie, 1);
        orange_sound8 = sp.load(context, R.raw.orange_mid1, 1);
        orange_sound9 = sp.load(context, R.raw.orange_mid2, 1);
        orange_sound10 = sp.load(context, R.raw.orange_thrill, 1);
        orange_sound11 = sp.load(context, R.raw.orange_thrill2, 1);
        orange_sound12 = sp.load(context, R.raw.orange_horn, 1);
        orange_sound13 = sp.load(context, R.raw.orange_guitar, 1);
        orange_sound14 = sp.load(context, R.raw.orange_long1, 1);
        orange_sound15 = sp.load(context, R.raw.orange_long2, 1);
        orange_sound16 = sp.load(context, R.raw.orange_long3, 1);

        orange_sounds = new int[]{orange_sound1, orange_sound2, orange_sound3, orange_sound4, orange_sound5, orange_sound6, orange_sound7,
                orange_sound8, orange_sound9,orange_sound10,orange_sound11,orange_sound12,orange_sound13,orange_sound14,orange_sound15,orange_sound16};

        indigo_sound1 = sp.load(context, R.raw.dubstep_low1, 1);
        indigo_sound2 = sp.load(context, R.raw.dubstep_low2, 1);
        indigo_sound3 = sp.load(context, R.raw.dubstep_low3, 1);
        indigo_sound4 = sp.load(context, R.raw.dubstep_voice, 1);
        indigo_sound5 = sp.load(context, R.raw.dubstep_mid1, 1);
        indigo_sound6 = sp.load(context, R.raw.dubstep_mid_2, 1);
        indigo_sound7 = sp.load(context, R.raw.dubstep_mid3, 1);
        indigo_sound8 = sp.load(context, R.raw.dubstep_high1, 1);
        indigo_sound9 = sp.load(context, R.raw.dubstep_high2, 1);
        indigo_sound10 = sp.load(context, R.raw.dubstep_high3, 1);
        indigo_sound11 = sp.load(context, R.raw.dubstep_high4, 1);
        indigo_sound12 = sp.load(context, R.raw.dubstep_high5, 1);
        indigo_sound13 = sp.load(context, R.raw.dubstep_long1, 1);
        indigo_sound14 = sp.load(context, R.raw.dubstep_long2, 1);
        indigo_sound15 = sp.load(context, R.raw.dubstep_long3, 1);
        indigo_sound16 = sp.load(context, R.raw.dubstep_long4, 1);

        indigo_sounds = new int[]{indigo_sound1, indigo_sound2, indigo_sound3, indigo_sound4, indigo_sound5, indigo_sound6, indigo_sound7,
                indigo_sound8, indigo_sound9,indigo_sound10,indigo_sound11,indigo_sound12,indigo_sound13,indigo_sound14,indigo_sound15,indigo_sound16};
        Play_beat_setting_record record = new Play_beat_setting_record();
        record.getFilename();

        green_sound1 = sp.load(context, R.raw.dubstep_low1, 1);
        green_sound2 = sp.load(context, R.raw.dubstep_low2, 1);
        green_sound3 = sp.load(context, R.raw.dubstep_low3, 1);
        green_sound4 = sp.load(context, R.raw.dubstep_voice, 1);
        green_sound5 = sp.load(context, R.raw.dubstep_mid1, 1);
        green_sound6 = sp.load(context, R.raw.dubstep_mid_2, 1);
        green_sound7 = sp.load(context, R.raw.dubstep_mid3, 1);
        green_sound8 = sp.load(context, R.raw.dubstep_high1, 1);
        green_sound9 = sp.load(context, R.raw.dubstep_high2, 1);
        green_sound10 = sp.load(context, R.raw.dubstep_high3, 1);
        green_sound11 = sp.load(context, R.raw.dubstep_high4, 1);
        green_sound12 = sp.load(context, R.raw.dubstep_high5, 1);
        green_sound13 = sp.load(context, R.raw.dubstep_long1, 1);
        green_sound14 = sp.load(context, R.raw.dubstep_long2, 1);
        green_sound15 = sp.load(context, R.raw.dubstep_long3, 1);
        green_sound16 = sp.load(context, R.raw.dubstep_long4, 1);

        green_sounds = new int[]{green_sound1, green_sound2, green_sound3, green_sound4, green_sound5, green_sound6, green_sound7,
                green_sound8, green_sound9,green_sound10,green_sound11,green_sound12,green_sound13,green_sound14,green_sound15,green_sound16};


    }

    public static int loadSound(String color, int tag){
        if(color.equals("blue")){
            load_sound = blue_sounds[tag-1];
        }
        else if(color.equals("yellow")){
            load_sound = yellow_sounds[tag-17];
        }
        else if(color.equals("orange")){
            load_sound = orange_sounds[tag-33];
        }
        else if(color.equals("indigo")){
            load_sound = indigo_sounds[tag-49];
        }
        else if(color.equals("green")){
            load_sound = green_sounds[tag-65];
        }
        return load_sound;
    }

    public static void playBlueSound(int tag){
        for (int i = 0; i < blue_sounds.length; i++){

            if(tag == blue_sounds[i]){

                sp.play(blue_sounds[i],1,1,0,0,1f);

            }
        }
    }

    public static void playYellowSound(int tag){
        for (int i = 0; i < yellow_sounds.length; i++){

            if(tag == yellow_sounds[i]){

                sp.play(yellow_sounds[i],1,1,0,0,1f);

            }

        }
    }

    public static void playOrangeSound(int tag){
        for (int i = 0; i < orange_sounds.length; i++){

            if(tag == orange_sounds[i]){

                sp.play(orange_sounds[i],1,1,0,0,1f);

            }
        }
    }

    public static void playIndigoSound(int tag){
        for (int i = 0; i < indigo_sounds.length; i++){

            if(tag == indigo_sounds[i]){

                sp.play(indigo_sounds[i],1,1,0,0,1f);

            }

        }
    }
    public static void playGreenSound(int tag){
        for (int i = 0; i < green_sounds.length; i++){

            if(tag == green_sounds[i]){

                sp.play(green_sounds[i],1,1,0,0,1f);

            }

        }
    }


}
