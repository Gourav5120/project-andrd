package com.example.gouravsproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class adminPage extends AppCompatActivity {
    Button userAdd,userUpdate,userDelete;
    Button v;
    DatabaseHelperUser db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_admin_page);
        db = new DatabaseHelperUser(this);
        userAdd = findViewById(R.id.bt1);
        userDelete = findViewById(R.id.bt2);
        userUpdate = findViewById(R.id.bt3);
        userUpdate = findViewById(R.id.viewAllBut);

    }
    public void add(View view)
    {
        Intent intent = new Intent(this,addPage.class);
        startActivity(intent);
    }
    public void update(View view)
    {
        Intent intent = new Intent(this,updatePage.class);
        startActivity(intent);
    }
    public void delete(View view) {
        Intent intent = new Intent(this, deletePage.class);
        startActivity(intent);
    }
    public void views(View view)
    {
                Cursor res = db.getAllData();
                if (res.getCount() == 0)
                {
                    showMessage("Error","no data found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext())
                {
                    buffer.append("ROLL NUMBER         " + res.getString(2)+"            \n");
                    buffer.append("NAME                "+res.getString(4)+"              \n");
                    buffer.append("SECTION             "+res.getString(5)+"              \n");
                    buffer.append("SUBJECT             "+ res.getString(1)+"             \n");
                    buffer.append("MARKS               "+ res.getString(3)+"\n\n\n\n");
                }
                showMessage("result of student is ",buffer.toString());

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
