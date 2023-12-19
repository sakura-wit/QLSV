package com.example.qlsinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class testTKB extends AppCompatActivity {

    TextView t2s,t3s,t4s,t5s,t6s,t7s,cns,t2c,t3c,t4c,t5c,t6c,t7c,cnc;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thoikhoabieu);

        t2s = findViewById(R.id.t2_sang);
        t3s = findViewById(R.id.t3_sang);
        t4s =findViewById(R.id.t4_sang);
        t5s = findViewById(R.id.t5_sang);
        t6s =findViewById(R.id.t6_sang);
        t7s = findViewById(R.id.t7_sang);
        cns = findViewById(R.id.cn_sang);
        t2c = findViewById(R.id.t2_chieu);
        t3c = findViewById(R.id.t3_chieu);
        t4c =findViewById(R.id.t4_chieu);
        t5c = findViewById(R.id.t5_chieu);
        t6c =findViewById(R.id.t6_chieu);
        t7c = findViewById(R.id.t7_chieu);
        cnc = findViewById(R.id.cn_chieu);

        Intent intent = getIntent();
        t2s.setText(intent.getStringExtra("titlet2s"));
        t2c.setText(intent.getStringExtra("titlet2c"));
        t3s.setText(intent.getStringExtra("titlet3s"));
        t3c.setText(intent.getStringExtra("titlet3c"));
        t4s.setText(intent.getStringExtra("titlet4s"));
        t4c.setText(intent.getStringExtra("titlet4c"));
        t5s.setText(intent.getStringExtra("titlet5s"));
        t5c.setText(intent.getStringExtra("titlet5c"));
        t6s.setText(intent.getStringExtra("titlet6s"));
        t6c.setText(intent.getStringExtra("titlet6c"));
        t7s.setText(intent.getStringExtra("titlet7s"));
        t7c.setText(intent.getStringExtra("titlet7c"));
        cns.setText(intent.getStringExtra("titlecns"));
        cnc.setText(intent.getStringExtra("titlecnc"));


    }
}