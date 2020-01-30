package com.example.gouravsproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class updatePage extends AppCompatActivity {
    EditText roll,id,sub,mark,section,name;
    Button updata , viewB;
    DatabaseHelperUser db;
    addPage u ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_update_page);
        db = new DatabaseHelperUser(this);
        roll = (EditText)findViewById(R.id.rollEditText);
        //id = findViewById(R.id.idEditText);
        sub = (EditText)findViewById(R.id.subjectEditText);
        mark = (EditText)findViewById(R.id.marksEditText);
        section = (EditText) findViewById(R.id.ec);
        name= (EditText) findViewById(R.id.en);
        viewB = (Button) findViewById(R.id.viewButton);
     updateData();
        viewBt();
    }
    public void update(View view)
    {
        Intent intent = new Intent(this,addPage.class);
        startActivity(intent);
    }
    public void updateData()
    {
        updata = findViewById(R.id.updateButton);
        updata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isUpdate = db.updateData(sub.getText().toString(),roll.getText().toString(),mark.getText().toString());
                if (isUpdate == true)
                {
                    Toast.makeText(updatePage.this, "data is updated", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(updatePage.this, "update operation failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void viewBt()
    {
        viewB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = db.getDataForStudent(roll.getText().toString());
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
