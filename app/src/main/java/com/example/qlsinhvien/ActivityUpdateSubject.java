package com.example.qlsinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.qlsinhvien.database.database;
import com.example.qlsinhvien.model.Subject;

public class ActivityUpdateSubject extends AppCompatActivity {

    EditText udTitle,udCredit,udTime,udPlace, udThu, udBuoi;
    Button buttonUpdate;

    database database;

    //Spriner
    Spinner spinnerNgayTrongTuan,spinnerBuoiTrongNgay;
    EditText edtNgayTrongTuan,edtBuoiTrongNgay;
    ArrayAdapter adapter,adapter1;
    String []dsNgay;
    String []dsBuoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_subject);

        //Spiner
        udNgayaddcontrols();
        udNgayaddEvents();

        udBuoiaddcontrols();
        udBuoiaddEvents();

        Intent intent = getIntent();

        int id = intent.getIntExtra("id",0);

        String title = intent.getStringExtra("title1");
        int credit = intent.getIntExtra("credit1",0);
        String time = intent.getStringExtra("time1");
        String place = intent.getStringExtra("place1");
        String thu = intent.getStringExtra("thu1");
        String buoi = intent.getStringExtra("buoi1");

        udCredit = findViewById(R.id.EditTextUpdateCredits);
        udPlace = findViewById(R.id.EditTextUpdatePlace);
        udTime = findViewById(R.id.EditTextUpdateTime);
        udTitle = findViewById(R.id.EditTextUpdateSubjectTitle);
        udThu = findViewById(R.id.EditTextUpdateThu);
        udBuoi =findViewById(R.id.EditTextUpdateBuoi);
        buttonUpdate = findViewById(R.id.buttonUpdateSubject);


        udTitle.setText(title);
        udCredit.setText(credit+"");
        udTime.setText(time);
        udPlace.setText(place);
        udThu.setText(thu);
        udBuoi.setText(buoi);

        database = new database(this);


        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUpdate(id);
            }
        });
    }



    //Update buổi bằng spiner
    private void udBuoiaddcontrols() {
        spinnerBuoiTrongNgay = (Spinner) findViewById(R.id.spinnerud_buoitrongngay);
        edtBuoiTrongNgay = (EditText) findViewById(R.id.EditTextUpdateBuoi);
        dsBuoi = getResources().getStringArray(R.array.arrBuoiTrongNgay);
        adapter = new ArrayAdapter<String>(ActivityUpdateSubject.this, android.R.layout.simple_spinner_item,dsBuoi);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerBuoiTrongNgay.setAdapter(adapter);
    }

    private void udBuoiaddEvents() {


        spinnerBuoiTrongNgay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                edtBuoiTrongNgay.setText(dsBuoi[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    //Update ngày bằng spiner
    private void udNgayaddEvents() {
        spinnerNgayTrongTuan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                edtNgayTrongTuan.setText(dsNgay[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void udNgayaddcontrols() {
        spinnerNgayTrongTuan = (Spinner) findViewById(R.id.spinnerud_ngaytrongtuan);
        edtNgayTrongTuan = (EditText) findViewById(R.id.EditTextUpdateThu);
        dsNgay = getResources().getStringArray(R.array.arrNgayTrongTuan);
        adapter = new ArrayAdapter<String>(ActivityUpdateSubject.this, android.R.layout.simple_spinner_item,dsNgay);

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerNgayTrongTuan.setAdapter(adapter);
    }

    //Dialog Update
    private void DialogUpdate(int id) {


        //Tạo đối tượng cửa sổ dialog
        Dialog dialog  =  new Dialog(this);

        //Nạp layout vào
        dialog.setContentView(R.layout.dialogupdate);

        //Click No mới thoát, click ngoài ko thoát
        dialog.setCanceledOnTouchOutside(false);

        //Ánh xạ
        Button btnYes = dialog.findViewById(R.id.buttonYesUpdateSubject);
        Button btnNo = dialog.findViewById(R.id.buttonNoUpdateSubject);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String subjecttitle = udTitle.getText().toString();
                String credits = udCredit.getText().toString();
                String time = udTime.getText().toString();
                String place = udPlace.getText().toString();
                String thu = udThu.getText().toString();
                String buoi = udBuoi.getText().toString();

                Subject subject = updatesubject();

                if(subjecttitle.equals("") || credits.equals("") || time.equals("") || place.equals("") ){
                    Toast.makeText(ActivityUpdateSubject.this,"Vui lòng điền đầy đủ thông tin!",Toast.LENGTH_SHORT).show();
                }
                else {

                    Boolean checktkb = database.checkschedule(thu,buoi);
                    if(checktkb == false){
                        database.UpdateSubject(subject,id);
                        //Khởi tạo lại activity main
                        Intent intent = new Intent(ActivityUpdateSubject.this,ActivitySubjects.class);

                        startActivity(intent);
                        Toast.makeText(ActivityUpdateSubject.this,"Cập nhật thành công",Toast.LENGTH_SHORT).show();
                    }else
                        Toast.makeText(getApplication(),"Đã trùng lịch môn học, hãy sửa lại",Toast.LENGTH_LONG).show();

                }
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
    //Create Subject
    private Subject updatesubject(){

        String subjecttitle = udTitle.getText().toString();
        int credits = Integer.parseInt(udCredit.getText().toString());
        String time = udTime.getText().toString();
        String place = udPlace.getText().toString();
        String thu = udThu.getText().toString();
        String buoi = udBuoi.getText().toString();

        Subject subject = new Subject(subjecttitle,credits,time,place,thu,buoi);
        return subject;
    }
}