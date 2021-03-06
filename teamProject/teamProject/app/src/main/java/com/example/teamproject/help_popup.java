package com.example.teamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class help_popup extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //타이틀바 없애기
            setContentView(R.layout.activity_help_popup);
        }
        //확인 버튼 클릭
        public void mOnClose(View v){
            //데이터 전달하기
            Intent intent = new Intent();
            intent.putExtra("result", "Close Popup");
            setResult(RESULT_OK, intent);

           //액티비티(팝업) 닫기
            finish();
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            //바깥레이어 클릭시 안닫히게
            if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
                return false;
            }
            return true;
        }
    }