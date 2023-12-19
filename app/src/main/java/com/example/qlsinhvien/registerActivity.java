package com.example.qlsinhvien;

import android.annotation.SuppressLint;
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
import com.example.qlsinhvien.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registerActivity extends AppCompatActivity {
    private EditText edtemail, edtpassword, edtrepass, edtname, edtphone,edtaddress;
    private Button btnregister;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        edtemail = (EditText) findViewById(R.id.edtemail);
        edtpassword = (EditText) findViewById(R.id.edtpassword);
        edtrepass =(EditText) findViewById(R.id.edtrepassword);
        edtname = (EditText) findViewById(R.id.edtname);
        edtphone = findViewById(R.id.edtphone);
        edtaddress = findViewById(R.id.edtaddress);
        btnregister = (Button) findViewById(R.id.btnregister);

        database db = new database(this);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, pass, repass, name, phone, address;
                email = edtemail.getText().toString().trim();
                pass =edtpassword.getText().toString().trim();
                repass = edtrepass.getText().toString().trim();
                name =edtname.getText().toString().trim();
                phone =edtphone.getText().toString().trim();
                address = edtaddress.getText().toString().trim();

                User user = new User(email,pass,name,phone,address);

                if(email.equals("")|| pass.equals("") || repass.equals("")){
                    Toast.makeText(registerActivity.this, "Vui lòng nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                }else {
                    if(pass.equals(repass)){
                        Boolean checkuser = db.checkusername(email);
                        if(checkuser == false){
                            Boolean insert = db.AddUser(user);
                            if(insert == true){
                                Toast.makeText(registerActivity.this, "Đăng ký thành công ", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(registerActivity.this, loginActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(getApplicationContext(), "Tạo tài khoảng không thành công", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(registerActivity.this,"Tài khoản đã tồn tại, vui lòng đăng nhập",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(registerActivity.this,"mật khẩu không giống nhau, mời nhập lại",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }


//        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if(task.isSuccessful()){
//                    Toast.makeText(getApplicationContext(), "Tạo tài khoảng thành công", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(registerActivity.this, loginActivity.class);
//                    startActivity(intent);
//                }else{
//                    Toast.makeText(getApplicationContext(), "Tạo tài khoảng không thành công", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }

