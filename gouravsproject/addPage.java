package com.example.gouravsproject;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.sql.Types.VARCHAR;

public class addPage extends AppCompatActivity {
    EditText subject,marks, roll,section,name,subject2,marks2,subject3,marks3,subject4,marks4,subject5,marks5;
    DatabaseHelperUser db;
    Button additon,viewB;
//    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_add_page);
        db = new DatabaseHelperUser(this);
        roll = (EditText) findViewById(R.id.rollEditText);
        section = (EditText) findViewById(R.id.ec);
        name= (EditText) findViewById(R.id.en);
        subject = (EditText)findViewById(R.id.subjectEditText);
        marks = (EditText)findViewById(R.id.marksEditText);
        subject2 = (EditText)findViewById(R.id.subjectEditText2);
        marks2 = (EditText)findViewById(R.id.marksEditText2);
        subject3 = (EditText)findViewById(R.id.subjectEditText3);
        marks3 = (EditText)findViewById(R.id.marksEditText3);
        subject4 = (EditText)findViewById(R.id.subjectEditText4);
        marks4 = (EditText)findViewById(R.id.marksEditText4);
        subject5 = (EditText)findViewById(R.id.subjectEditText5);
        marks5 = (EditText)findViewById(R.id.marksEditText5);
        additon = (Button) findViewById(R.id.addButton);
        viewB = (Button) findViewById(R.id.viewButton);
         addData();
         viewBut();

    }
    public void update(View view)
    {
        Intent intent = new Intent(this,updatePage.class);
        startActivity(intent);
    }
    public void addData(){
        additon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((Integer.parseInt(marks.getText().toString())) <= 100 && (Integer.parseInt(marks2.getText().toString())) <= 100
                && (Integer.parseInt(marks3.getText().toString())) <= 100 && (Integer.parseInt(marks4.getText().toString())) <= 100
                && (Integer.parseInt(marks5.getText().toString())) <= 100 ) {
                    if (roll.getText().toString().matches("") || subject.getText().toString().matches("") ||
                            subject2.getText().toString().matches("") ||
                            subject3.getText().toString().matches("") ||
                            subject4.getText().toString().matches("")
                    || subject5.getText().toString().matches("") ||
                            marks.getText().toString().matches("") ||
                            marks2.getText().toString().matches("") ||
                            marks3.getText().toString().matches("") ||
                            marks4.getText().toString().matches("")
                    || marks5.getText().toString().matches("")) {
                        Toast.makeText(addPage.this, "fields cannot be empty", Toast.LENGTH_SHORT).show();

                    }
                    else{
                        boolean isInserted = db.insertData(subject.getText().toString(), roll.getText().toString(), marks.getText().toString(), name.getText().toString(), section.getText().toString());
                        boolean isInserted2 = db.insertData(subject2.getText().toString(), roll.getText().toString(), marks2.getText().toString(), name.getText().toString(), section.getText().toString());
                        boolean isInserted3 = db.insertData(subject3.getText().toString(), roll.getText().toString(), marks3.getText().toString(), name.getText().toString(), section.getText().toString());
                        boolean isInserted4 = db.insertData(subject4.getText().toString(), roll.getText().toString(), marks4.getText().toString(), name.getText().toString(), section.getText().toString());
                        boolean isInserted5 = db.insertData(subject5.getText().toString(), roll.getText().toString(), marks5.getText().toString(), name.getText().toString(), section.getText().toString());
                        if (isInserted == true && isInserted2 == true && isInserted3 == true && isInserted4 == true && isInserted5 == true) {
                            Toast.makeText(addPage.this, "your data has been sucessfully inserted into the database", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(addPage.this, "sorry unable to insert data into the database", Toast.LENGTH_SHORT).show();
                    }
                }
            }
             });
    }

    public void viewBut()
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
               else{ StringBuffer buffer = new StringBuffer();
//                buffer.append("ROLL NO.         ");
//                buffer.append("NAME =              ");
//                buffer.append("SECTION =           ");
//                buffer.append("SUBJECT           ");
//                buffer.append("MARKS                 ");
                int i=1;
                while(res.moveToNext())
                {
                     if(i!=3 &&i!=1){
                         buffer.append(res.getColumnName(i)+"   "+res.getString(i)+" \n");
                     }
                     i++;
                }
                buffer.append(res.getColumnName(1)+"               "+res.getColumnName(3)+" \n");
                buffer.append(subject.getText().toString() + "               "+marks.getText().toString()+"\n");
                buffer.append(subject2.getText().toString() + "              "+marks2.getText().toString()+"\n");
                buffer.append(subject3.getText().toString() + "              "+marks3.getText().toString()+"\n");
                buffer.append(subject5.getText().toString() + "              "+marks5.getText().toString()+"\n");
                buffer.append(subject4.getText().toString() + "              "+marks4.getText().toString()+"\n");

                showMessage("result of student is ",buffer.toString());

            }}

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
    public void semesClicked(View view){
        subject.setText("C PR.");
        subject2.setText("DIFF");
        subject3.setText("ENV");
        subject4.setText("SOCIAL");
        subject5.setText("CHEME");

    }
    public void semClicked(View view) {
        subject.setText("MATHS");
        subject2.setText("ENG");
        subject3.setText("OCV");
        subject4.setText("OOPS");
        subject5.setText("PYTHON_");
    }
    public void semesCicked(View view) {
        subject.setText("BIO");
        subject2.setText("AUTOMETA");
        subject3.setText("DBMS");
        subject4.setText("JAVA");
        subject5.setText("ADA");
    }
    public void smesClicked(View view){
        subject.setText("WEBTECH");
        subject2.setText("EVS");
        subject3.setText("APTIUDE");
        subject4.setText("EN SKIL");
        subject5.setText("SAP");
    }
    public void back(View view) {
        finish();
    }

}