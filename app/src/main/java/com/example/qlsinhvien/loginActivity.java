package com.example.qlsinhvien;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.qlsinhvien.database.database;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginActivity extends AppCompatActivity {

     EditText edtemail, edtpassword;
     Button btndangnhap, btnregister;
     String EmailG;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        database db = new database(this);

        edtemail = (EditText) findViewById(R.id.edtemail);
        edtpassword = (EditText)findViewById(R.id.edtpassword);
        btndangnhap = findViewById(R.id.btndangnhap);
        btnregister = findViewById(R.id.btnregister);

        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtemail.getText().toString().trim();
                String pass = edtpassword.getText().toString().trim();



                if(email.equals("") || pass.equals("")){
                    Toast.makeText(loginActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {

                    if(email.equals("") || pass.equals("")){
                        Toast.makeText(loginActivity.this, "Vui lòng nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                    }else {
                        Boolean checkuserpass = db.checkusernamepassword(email,pass);
                        if(checkuserpass == true){
                            TG.email = edtemail.getText().toString();
                            Toast.makeText(loginActivity.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(loginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(getApplicationContext(), "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
                        }
                    }
                   // login();

                }
            }
        });
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }

    private void register() {
        Intent i = new Intent(loginActivity.this, registerActivity.class);
        startActivity(i);
    }

    private void login() {
        String email, pass;
        email  = edtemail.getText().toString();
        pass = edtpassword.getText().toString();



//        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if(task.isSuccessful()){
//
//                    TG.email = email;
//
//                    Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(loginActivity.this, MainActivity.class);
//
//                    startActivity(intent);
//                }else{
//                    Toast.makeText(getApplicationContext(), "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }
}
