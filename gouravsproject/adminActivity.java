package com.example.gouravsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adminActivity extends AppCompatActivity {
    Button logInButton;
    EditText user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_admin);
        logInButton = findViewById(R.id.logInButton);
        user = findViewById(R.id.usernameEditText);
        pass = findViewById(R.id.passwordEditText);
    }
    String username = "admin";
    String password = "12345";
    public void log(View view) {
        if (username.equals(user.getText().toString())&& password.equals(pass.getText().toString()) )
        {
            Intent intent = new Intent(this,adminPage.class);
            startActivity(intent);
        }else{
            Toast.makeText(adminActivity.this,"invalid details",Toast.LENGTH_LONG ).show() ;

        }
    }
    public void back(View view) {
        finish();
    }
}
