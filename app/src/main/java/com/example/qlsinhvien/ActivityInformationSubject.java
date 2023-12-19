package com.example.qlsinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityInformationSubject extends AppCompatActivity {

    TextView txtTitle,txtCredit,txtTime,txtPlace,txtThu,txtBuoi;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_subject);

        txtCredit = findViewById(R.id.txtSubjectCredit);
        txtPlace = findViewById(R.id.txtSubjectPlace);
        txtTime = findViewById(R.id.txtSubjectTime);
        txtTitle = findViewById(R.id.txtSubjectTitle);
        txtBuoi = findViewById(R.id.txtSubjectBuoi);
        txtThu = findViewById(R.id.txtSubjectThu);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        int credit = intent.getIntExtra("credit",0);
        String time = intent.getStringExtra("time");
        String place = intent.getStringExtra("place");
        String thu = intent.getStringExtra("thu");
        String buoi = intent.getStringExtra("buoi");

        txtTitle.setText(title);
        txtCredit.setText(credit+"");
        txtTime.setText(time);
        txtPlace.setText(place);
        txtThu.setText(thu);
        txtBuoi.setText(buoi);

    }
}