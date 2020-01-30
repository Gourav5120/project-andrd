package com.example.gouravsproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class resultPage extends AppCompatActivity {
    DatabaseHelperUser db;
    EditText roll;
    Button viewB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_result_page);
        db = new DatabaseHelperUser(this);
        roll = (EditText)findViewById(R.id.editText);
        viewB = (Button)findViewById(R.id.button);
        ViewS();
    }
    public void ViewS(){
        viewB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = db.getDataForStudent(roll.getText().toString());
                StringBuffer buffer = new StringBuffer();
                buffer.append("ROLL NO.         ");
                buffer.append("SUBJECT        ");
                buffer.append("MARKS                 ");
                while(res.moveToNext())
                {
                    buffer.append(res.getString(2)+"       ");
                    buffer.append(res.getString(1)+"              ");
                    buffer.append(res.getString(3)+"\n");
                }
                showMessage("Result",buffer.toString());
            }
        });
    }
    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void back(View view) {
        finish();
    }
}