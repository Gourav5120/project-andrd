package com.example.gouravsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonStudent,ButtonAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);
        buttonStudent = findViewById(R.id.bt01);
        ButtonAdmin = findViewById(R.id.bt02);
    }
    public void studentLogin(View view)
    {
        Intent intent = new Intent(this,loginActivity.class);
        startActivity(intent);
    }
    public void adminLogin(View view)
    {
        Intent intent = new Intent(this,adminActivity.class);
        startActivity(intent);
    }
}
