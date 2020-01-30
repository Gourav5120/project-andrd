package com.example.gouravsproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginActivity extends AppCompatActivity {
    EditText username, passWord;
    Button LogInButton;
    TextView signUp;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        username = (EditText) findViewById(R.id.userText);
        passWord = (EditText) findViewById(R.id.passwordText);
        LogInButton = (Button) findViewById(R.id.log);
        signUp = (TextView) findViewById(R.id.signUpTextView);
        LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSignIn();
            }
        });

    }
    public void startSignIn(){
        String email = username.getText().toString();
        String password = passWord.getText().toString();
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(loginActivity.this, "sign In is succesfull", Toast.LENGTH_SHORT).show();
                        moveToNextActivity();
                    }
                    else Toast.makeText(loginActivity.this, "details are not correct", Toast.LENGTH_SHORT).show();

                }
            });
        }
        public void moveToNextActivity(){
        Intent intent = new Intent(this,resultPage.class);
        startActivity(intent);
        }
    public void sup(View view)
    {
        Intent intent = new Intent(this,studentLogin.class);
        startActivity(intent);
    }


    public void logInButtonClicked(View view) {
        Intent intent = new Intent(this,loginActivity.class);
        startActivity(intent);
    }
    public void back(View view) {
        finish();
    }

}
