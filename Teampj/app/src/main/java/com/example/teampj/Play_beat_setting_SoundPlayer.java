package com.example.teampj;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class Play_beat_setting_SoundPlayer {
    static SoundPool sp;

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

        sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

        blue_sound1 = sp.load(context, R.raw.blue_hipopsht, 1);
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

        yellow_sound1 = sp.load(context, R.raw.yellow_electric_guitar, 1);
        yellow_sound2 = sp.load(context, R.raw.blue_kick1, 1);
        yellow_sound3 = sp.load(context, R.raw.blue_kicka, 1);
        yellow_sound4 = sp.load(context, R.raw.blue_singlekick, 1);
        yellow_sound5 = sp.load(context, R.raw.blue_loosekik, 1);
        yellow_sound6 = sp.load(context, R.raw.blue_electronicsound, 1);
        yellow_sound7 = sp.load(context, R.raw.blue_dynohlsn, 1);
        yellow_sound8 = sp.load(context, R.raw.blue_dirtysnaredrum, 1);
        yellow_sound9 = sp.load(context, R.raw.blue_djembedrum, 1);
        yellow_sound10 = sp.load(context, R.raw.blue_heavykick, 1);
        yellow_sound11 = sp.load(context, R.raw.blue_what, 1);
        yellow_sound12 = sp.load(context, R.raw.blue_djembe, 1);
        yellow_sound13 = sp.load(context, R.raw.blue_drumone, 1);
        yellow_sound14 = sp.load(context, R.raw.blue_dnbloop, 1);
        yellow_sound15 = sp.load(context, R.raw.blue_loop17, 1);
        yellow_sound16 = sp.load(context, R.raw.blue_foetus, 1);

        yellow_sounds = new int[]{yellow_sound1, yellow_sound2, yellow_sound3, yellow_sound4, yellow_sound5, yellow_sound6, yellow_sound7,
                yellow_sound8, yellow_sound9,yellow_sound10,yellow_sound11,yellow_sound12,yellow_sound13,yellow_sound14,yellow_sound15,yellow_sound16};

        orange_sound1 = sp.load(context, R.raw.orange_basshit, 1);
        orange_sound2 = sp.load(context, R.raw.blue_kick1, 1);
        orange_sound3 = sp.load(context, R.raw.blue_kicka, 1);
        orange_sound4 = sp.load(context, R.raw.blue_singlekick, 1);
        orange_sound5 = sp.load(context, R.raw.blue_loosekik, 1);
        orange_sound6 = sp.load(context, R.raw.blue_electronicsound, 1);
        orange_sound7 = sp.load(context, R.raw.blue_dynohlsn, 1);
        orange_sound8 = sp.load(context, R.raw.blue_dirtysnaredrum, 1);
        orange_sound9 = sp.load(context, R.raw.blue_djembedrum, 1);
        orange_sound10 = sp.load(context, R.raw.blue_heavykick, 1);
        orange_sound11 = sp.load(context, R.raw.blue_what, 1);
        orange_sound12 = sp.load(context, R.raw.blue_djembe, 1);
        orange_sound13 = sp.load(context, R.raw.blue_drumone, 1);
        orange_sound14 = sp.load(context, R.raw.blue_dnbloop, 1);
        orange_sound15 = sp.load(context, R.raw.blue_loop17, 1);
        orange_sound16 = sp.load(context, R.raw.blue_foetus, 1);

        orange_sounds = new int[]{orange_sound1, orange_sound2, orange_sound3, orange_sound4, orange_sound5, orange_sound6, orange_sound7,
                orange_sound8, orange_sound9,orange_sound10,orange_sound11,orange_sound12,orange_sound13,orange_sound14,orange_sound15,orange_sound16};

        indigo_sound1 = sp.load(context, R.raw.indigo_piano_c, 1);
        indigo_sound2 = sp.load(context, R.raw.blue_kick1, 1);
        indigo_sound3 = sp.load(context, R.raw.blue_kicka, 1);
        indigo_sound4 = sp.load(context, R.raw.blue_singlekick, 1);
        indigo_sound5 = sp.load(context, R.raw.blue_loosekik, 1);
        indigo_sound6 = sp.load(context, R.raw.blue_electronicsound, 1);
        indigo_sound7 = sp.load(context, R.raw.blue_dynohlsn, 1);
        indigo_sound8 = sp.load(context, R.raw.blue_dirtysnaredrum, 1);
        indigo_sound9 = sp.load(context, R.raw.blue_djembedrum, 1);
        indigo_sound10 = sp.load(context, R.raw.blue_heavykick, 1);
        indigo_sound11 = sp.load(context, R.raw.blue_what, 1);
        indigo_sound12 = sp.load(context, R.raw.blue_djembe, 1);
        indigo_sound13 = sp.load(context, R.raw.blue_drumone, 1);
        indigo_sound14 = sp.load(context, R.raw.blue_dnbloop, 1);
        indigo_sound15 = sp.load(context, R.raw.blue_loop17, 1);
        indigo_sound16 = sp.load(context, R.raw.blue_foetus, 1);

        indigo_sounds = new int[]{indigo_sound1, indigo_sound2, indigo_sound3, indigo_sound4, indigo_sound5, indigo_sound6, indigo_sound7,
                indigo_sound8, indigo_sound9,indigo_sound10,indigo_sound11,indigo_sound12,indigo_sound13,indigo_sound14,indigo_sound15,indigo_sound16};

        green_sound1 = sp.load(context, R.raw.green_program, 1);
        green_sound2 = sp.load(context, R.raw.blue_kick1, 1);
        green_sound3 = sp.load(context, R.raw.blue_kicka, 1);
        green_sound4 = sp.load(context, R.raw.blue_singlekick, 1);
        green_sound5 = sp.load(context, R.raw.blue_loosekik, 1);
        green_sound6 = sp.load(context, R.raw.blue_electronicsound, 1);
        green_sound7 = sp.load(context, R.raw.blue_dynohlsn, 1);
        green_sound8 = sp.load(context, R.raw.blue_dirtysnaredrum, 1);
        green_sound9 = sp.load(context, R.raw.blue_djembedrum, 1);
        green_sound10 = sp.load(context, R.raw.blue_heavykick, 1);
        green_sound11 = sp.load(context, R.raw.blue_what, 1);
        green_sound12 = sp.load(context, R.raw.blue_djembe, 1);
        green_sound13 = sp.load(context, R.raw.blue_drumone, 1);
        green_sound14 = sp.load(context, R.raw.blue_dnbloop, 1);
        green_sound15 = sp.load(context, R.raw.blue_loop17, 1);
        green_sound16 = sp.load(context, R.raw.blue_foetus, 1);

        green_sounds = new int[]{green_sound1, green_sound2, green_sound3, green_sound4, green_sound5, green_sound6, green_sound7,
                green_sound8, green_sound9,green_sound10,green_sound11,green_sound12,green_sound13,green_sound14,green_sound15,green_sound16};


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
