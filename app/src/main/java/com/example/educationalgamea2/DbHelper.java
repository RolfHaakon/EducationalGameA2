package com.example.educationalgamea2;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class DbHelper {
    int _id;
    String _name;
    int _score;
    public DbHelper(int id, String name, int _score){
        this._id = id;
        this._name = name;
        this._score = _score;
    }

    public DbHelper(){
        this._name = _name;
        this._score = _score;
    }
    public int getID(){
        return this._id;
    }

    public void setID(int id){
        this._id = id;
    }

    public String getName(){
        return this._name;
    }

    public void setName(String name){
        this._name = name;
    }

    public int getScore(){
        return this._score;
    }

    public void setScore(int score){
        this._score = score;
    }

}
