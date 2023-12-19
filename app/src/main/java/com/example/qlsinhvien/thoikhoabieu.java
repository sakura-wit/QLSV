package com.example.qlsinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;

import com.example.qlsinhvien.database.database;

public class thoikhoabieu extends AppCompatActivity {

    com.example.qlsinhvien.database.database database, databasetkb , databasetg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thoikhoabieu);

        databasetg = (com.example.qlsinhvien.database.database) database.getDataSubjects(TG.email);
    }
}