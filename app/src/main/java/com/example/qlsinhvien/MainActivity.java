package com.example.qlsinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qlsinhvien.database.database;
import com.example.qlsinhvien.model.Subject;

public class MainActivity extends AppCompatActivity {

    Button btnSubjects,btnAuthor,btnExit,btnTkb;
    TextView tv;
    int counter = 0;
    database database;
    LinearLayout ll_sub,ll_tc,ll_tkb,ll_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll_sub = findViewById(R.id.ll_sub);
        ll_tc = findViewById(R.id.ll_tc);
        ll_tkb = findViewById(R.id.ll_tkb);
        ll_exit = findViewById(R.id.ll_exit);


        tv = findViewById(R.id.tvtest);

        database = new database(this);

        ll_tc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                informationUser(TG.email);
            }
        });
        ll_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogExit();
            }
        });
        ll_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ActivitySubjects.class);
                startActivity(intent);
            }
        });
        ll_tkb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =  new Intent(MainActivity.this,testTKB.class);

                    //Thứ 2 sáng
                    Cursor cursor = database.getSubjectT2S(TG.email,"Thứ 2","Sáng");
                    if( cursor.getCount() != 0){
                        cursor.moveToFirst();

                        String title = cursor.getString(1);
                        intent.putExtra("titlet2s",title);
                    }else {
                    }

                    //Thứ 2 chiều
                    Cursor cursor1 = database.getSubjectT2S(TG.email,"Thứ 2","Chiều");
                    if( cursor1.getCount() != 0){
                        cursor1.moveToFirst();
                        String title = cursor1.getString(1);
                        intent.putExtra("titlet2c",title);

                    }else {
                    }

                //Thứ 3 sáng
                Cursor cursor2 = database.getSubjectT2S(TG.email,"Thứ 3","Sáng");
                if( cursor2.getCount() != 0){
                    cursor2.moveToFirst();

                    String title = cursor2.getString(1);
                    intent.putExtra("titlet3s",title);
                }else {
                }

                //Thứ 3 chiều
                Cursor cursor3 = database.getSubjectT2S(TG.email,"Thứ 3","Chiều");
                if( cursor3.getCount() != 0){
                    cursor3.moveToFirst();
                    String title = cursor3.getString(1);
                    intent.putExtra("titlet3c",title);

                }else {
                }

                //Thứ 4 sáng
                Cursor cursor4 = database.getSubjectT2S(TG.email,"Thứ 4","Sáng");
                if( cursor4.getCount() != 0){
                    cursor4.moveToFirst();

                    String title = cursor4.getString(1);
                    intent.putExtra("titlet4s",title);
                }else {
                }

                //Thứ 4 chiều
                Cursor cursor5 = database.getSubjectT2S(TG.email,"Thứ 4","Chiều");
                if( cursor5.getCount() != 0){
                    cursor5.moveToFirst();
                    String title = cursor5.getString(1);
                    intent.putExtra("titlet4c",title);

                }else {
                }


                //Thứ 5 sáng
                Cursor cursor6 = database.getSubjectT2S(TG.email,"Thứ 5","Sáng");
                if( cursor6.getCount() != 0){
                    cursor6.moveToFirst();

                    String title = cursor6.getString(1);
                    intent.putExtra("titlet5s",title);
                }else {
                }

                //Thứ 5 chiều
                Cursor cursor7 = database.getSubjectT2S(TG.email,"Thứ 5","Chiều");
                if( cursor7.getCount() != 0){
                    cursor7.moveToFirst();
                    String title = cursor7.getString(1);
                    intent.putExtra("titlet5c",title);

                }else {
                }

                //Thứ 6 sáng
                Cursor cursor8 = database.getSubjectT2S(TG.email,"Thứ 6","Sáng");
                if( cursor8.getCount() != 0){
                    cursor8.moveToFirst();

                    String title = cursor8.getString(1);
                    intent.putExtra("titlet6s",title);
                }else {
                }

                //Thứ 6 chiều
                Cursor cursor9 = database.getSubjectT2S(TG.email,"Thứ 6","Chiều");
                if( cursor9.getCount() != 0){
                    cursor9.moveToFirst();
                    String title = cursor9.getString(1);
                    intent.putExtra("titlet6c",title);

                }else {
                }

                //Thứ 7 sáng
                Cursor cursor10 = database.getSubjectT2S(TG.email,"Thứ 7","Sáng");
                if( cursor10.getCount() != 0){
                    cursor10.moveToFirst();

                    String title = cursor10.getString(1);
                    intent.putExtra("titlet7s",title);
                }else {
                }

                //Thứ 7 chiều
                Cursor cursor11 = database.getSubjectT2S(TG.email,"Thứ 7","Chiều");
                if( cursor11.getCount() != 0){
                    cursor11.moveToFirst();
                    String title = cursor11.getString(1);
                    intent.putExtra("titlet7c",title);

                }else {
                }

                //Chủ nhật sáng
                Cursor cursor12 = database.getSubjectT2S(TG.email,"Chủ nhật","Sáng");
                if( cursor12.getCount() != 0){
                    cursor12.moveToFirst();

                    String title = cursor12.getString(1);
                    intent.putExtra("titlecns",title);
                }else {
                }

                //Chủ nhật chiều
                Cursor cursor13 = database.getSubjectT2S(TG.email,"Chủ nhật","Chiều");
                if( cursor13.getCount() != 0){
                    cursor13.moveToFirst();
                    String title = cursor13.getString(1);
                    intent.putExtra("titlecnc",title);

                }else {
                }

                startActivity(intent);


            }
        });

    }

    private void informationUser(final String tk_user) {

        Cursor cursor = database.getDataUser(tk_user);
        if (cursor != null) {
            Toast.makeText(getApplication(), "Có giá trị", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, ActivityInformationUser.class);
            cursor.moveToFirst();
            String username = cursor.getString(0);
            String name = cursor.getString(2);
            String phone = cursor.getString(3);
            String address = cursor.getString(4);
            String pass = cursor.getString(1);

            intent.putExtra("username", username);
            intent.putExtra("name", name);
            intent.putExtra("phone", phone);
            intent.putExtra("address", address);
            intent.putExtra("pass",pass);

            startActivity(intent);

        }
    }


    //Dialog Thoát
    private void DialogExit() {

        //Tạo đối tượng cửa sổ dialog
        Dialog dialog  =  new Dialog(this);

        //Nạp layout vào
        dialog.setContentView(R.layout.dialogexit);

        //Click No mới thoát, click ngoài ko thoát
        dialog.setCanceledOnTouchOutside(false);

        //Ánh xạ
        Button btnYes = dialog.findViewById(R.id.buttonYes);
        Button btnNo = dialog.findViewById(R.id.buttonNo);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Khởi tạo lại activity main
                Intent intent = new Intent(getApplicationContext(), loginActivity.class);
                startActivity(intent);

                // Tạo sự kiện kết thúc app
//                Intent startMain = new Intent(Intent.ACTION_MAIN);
//                startMain.addCategory(Intent.CATEGORY_HOME);
//                startActivity(startMain);
            }
        });
        //Nếu no thì đóng dialog
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        //show dialog lên activity
        dialog.show();
    }

    //Nhấn nút back trên android 2 lần trên activity main thì thoát ứng dụng
    @Override
    public void onBackPressed() {
        counter++;
        if (counter >= 1){
            // Tạo sự kiện kết thúc app
            Intent startMain = new Intent(Intent.ACTION_MAIN);
            startMain.addCategory(Intent.CATEGORY_HOME);
            startActivity(startMain);
        }
    }
}