package com.example.qlsinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class ActivityInformationUser extends AppCompatActivity {

    EditText edtuser,edtname,edtphone,edtaddress,edtpass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_user);

        edtuser = findViewById(R.id.edtIusername);
        edtname = findViewById(R.id.edtIname);
        edtphone = findViewById(R.id.edtIphone);
        edtaddress = findViewById(R.id.edtIaddress);
        edtpass = findViewById(R.id.edtIpassword);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String name = intent.getStringExtra("name");
        String phone = intent.getStringExtra("phone");
        String address = intent.getStringExtra("address");
        String pass = intent.getStringExtra("pass");

        edtuser.setText(username);
        edtname.setText(name);
        edtphone.setText(phone);
        edtaddress.setText(address);
        edtpass.setText(pass);
    }
}