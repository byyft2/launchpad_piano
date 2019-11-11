package com.example.teampj;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
//
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button pianobutton, beatbutton, concertbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pianobutton = findViewById(R.id.button);
        beatbutton = findViewById(R.id.button2);
        concertbutton = findViewById(R.id.button3);

//        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
//            startLoginActivity();
//        }


        pianobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Play_piano.class);
                startActivity(intent);
            }
        });

        beatbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Play_beat.class);
                startActivity(intent);
            }
        });
//        concertbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//                startActivity(intent);
//            }
//        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_Signout:
//                FirebaseAuth.getInstance().signOut();
////                startLoginActivity();
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//
//    }
//    private void startLoginActivity(){
//        Intent intent = new Intent(this,LoginActivity.class);
//        startActivity(intent);
//
//    }
//    메뉴바숨기기

//    private void hideActionBar() {
//        ActionBar actionBar = getSupportActionBar();
//        if(actionBar != null)
//            actionBar.hide();
//    }
}
