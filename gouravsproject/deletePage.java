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
import android.widget.Toast;

public class deletePage extends AppCompatActivity {
    EditText Roll,name,section;
    Button del,viewB;
    DatabaseHelperUser db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        setContentView(R.layout.activity_delete_page);
        Roll = (EditText)findViewById(R.id.rollEditText);
        name = (EditText)findViewById(R.id.en);
        section = (EditText)findViewById(R.id.ec);
        del = (Button)findViewById(R.id.deleteButton);
        db = new DatabaseHelperUser(this);
        viewB = (Button) findViewById(R.id.viewButton);
        delete();
        viewBut() ;
    }
    public void delete() {
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer del = db.deleteData(Roll.getText().toString());
                if (del > 0) {
                    Toast.makeText(deletePage.this, "The User " + Roll.getText().toString() + " has been deleted", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(deletePage.this, "No user with ROll NUMBER:" + Roll.getText().toString() + " Exists", Toast.LENGTH_SHORT).show();
            }
        });
    }
        public void viewBut()
        {
            viewB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
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


