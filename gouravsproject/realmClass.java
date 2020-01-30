package com.example.gouravsproject;

import io.realm.RealmObject;

public class realmClass extends RealmObject {
    private int rollno;
    private String subject;
    private int marks;
    private String  name ;
    private String  section;


    public realmClass(int rollno, String subject, int marks ,String  name ,String  section) {
        this.rollno = rollno;
        this.subject = subject;
        this.marks = marks;
        this.name = name;
        this.section =section;

    }
    public realmClass(){}

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
