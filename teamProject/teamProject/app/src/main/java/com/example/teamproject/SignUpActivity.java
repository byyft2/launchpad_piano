package com.example.teamproject;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    private  static final String TAG = "SignUpActivity";
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.signUpbtn).setOnClickListener(onClickListener);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v){
            switch (v.getId()){
                case R.id.signUpbtn:
                    signUp();
                    break;

            }
        }
    };
    private  void signUp(){
        String email = ((EditText)findViewById(R.id.emaileditText)).getText().toString();
        String password = ((EditText)findViewById(R.id.passwordEditText)).getText().toString();
        String passwordCheck = ((EditText)findViewById(R.id.passwordCheckEditText)).getText().toString();

        if(email.length() > 0 && password.length() > 0 && passwordCheck.length() > 0){
            if(password.equals(passwordCheck)){
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    startToast("회원가입을 성공하였습니다.");
                                    startLoginActivty();
                                } else {
//                                    if(task.getException() != null) {
//                                        startToast(task.getException().toString());
//                                    }
                                    try {
                                        throw task.getException();
                                    } catch(FirebaseAuthWeakPasswordException e) {
                                        Toast.makeText(SignUpActivity.this,"비밀번호가 6글자 이상 기입하셔야됩니다." ,Toast.LENGTH_SHORT).show();
                                    } catch(FirebaseAuthInvalidCredentialsException e) {
                                        Toast.makeText(SignUpActivity.this,"email 형식에 맞지 않습니다." ,Toast.LENGTH_SHORT).show();
                                    } catch(FirebaseAuthUserCollisionException e) {
                                        Toast.makeText(SignUpActivity.this,"이미존재하는 email 입니다." ,Toast.LENGTH_SHORT).show();
                                    } catch(Exception e) {
                                        Toast.makeText(SignUpActivity.this,"다시 확인해주세요.." ,Toast.LENGTH_SHORT).show();
                                    }


                                }
                            }
                        });
            }else{
                startToast("비밀번호가 일치하지않습니다.");
            }
        }else{
            startToast("이메일 또는 비밀번호를 입력해 주세요.");
        }
        }
    private void startToast(String msg){
        Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();
    }
    private void startLoginActivty(){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);

    }


}
