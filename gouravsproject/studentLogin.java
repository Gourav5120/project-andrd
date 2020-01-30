package com.example.gouravsproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class studentLogin extends AppCompatActivity {
    private TextView userName;
    private TextView passWord;
    TextView loginTextView;
    ImageView iv;
    Button signUp;
    private FirebaseAuth mAuth;
    public void loginButtonCllcked(View view) {
        Intent intent = new Intent(this,loginActivity.class);
        startActivity(intent);
    }

    public void sup(View view) {
        String email = userName.getText().toString();
        String password = passWord.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(studentLogin.this,"Suceesfully sign up ",Toast.LENGTH_SHORT).show();
                nextActivity();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(studentLogin.this,e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void nextActivity()
    {
        Intent intent = new Intent(this,resultPage.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_student_login);
        iv = (ImageView) findViewById(R.id.iv);
        userName = (TextView) findViewById(R.id.userText);
        passWord = (TextView) findViewById(R.id.passwordText);
        loginTextView =(TextView)findViewById(R.id.signUpTextView);
        signUp =(Button)findViewById(R.id.log);
        mAuth = FirebaseAuth.getInstance();
    }
    public void back(View view) {
        finish();
    }
}
