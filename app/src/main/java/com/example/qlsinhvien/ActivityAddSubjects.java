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
import android.widget.TextView;
import android.widget.Toast;

import com.example.qlsinhvien.database.database;
import com.example.qlsinhvien.model.Subject;

public class ActivityAddSubjects extends AppCompatActivity {

    Button buttonAddSubject;
    EditText edtSubjectTitle,edtCredits,edtTime,edtPlace, edtBuoi, edtThu;
    database database;
    int counter = 0;

    //Spriner
    Spinner spinnerNgayTrongTuan,spinnerBuoiTrongNgay;
    EditText edtNgayTrongTuan,edtBuoiTrongNgay;
    ArrayAdapter adapter,adapter1;
    String []dsNgay;
    String []dsBuoi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subjects);

        //Spiner
        addcontrols();
        addEvents();

        addcontrols1();
        addEvents1();

        buttonAddSubject = findViewById(R.id.buttonAddSubject);
        edtCredits = findViewById(R.id.EditTextCredits);
        edtPlace = findViewById(R.id.EditTextPlace);
        edtSubjectTitle = findViewById(R.id.EditTextSubjectTitle);
        edtTime = findViewById(R.id.EditTextTime);
        edtBuoi = findViewById(R.id.EditTextBuoi);
        edtThu = findViewById(R.id.EditTextThu);

        database = new database(this);

        buttonAddSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogAdd();
            }
        });
    }


    //Hàm spiner Ngày trong tuần
    private void addEvents() {

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

    private void addcontrols() {

        spinnerNgayTrongTuan = (Spinner) findViewById(R.id.spinner_ngaytrongtuan);
        edtNgayTrongTuan = (EditText) findViewById(R.id.EditTextThu);
        dsNgay = getResources().getStringArray(R.array.arrNgayTrongTuan);
        adapter = new ArrayAdapter<String>(ActivityAddSubjects.this, android.R.layout.simple_spinner_item,dsNgay);

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerNgayTrongTuan.setAdapter(adapter);

    }

    //Hàm spiner Buổi trong ngày
    private void addEvents1() {

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

    private void addcontrols1() {

        spinnerBuoiTrongNgay = (Spinner) findViewById(R.id.spinner_buoitrongngay);
        edtBuoiTrongNgay = (EditText) findViewById(R.id.EditTextBuoi);
        dsBuoi = getResources().getStringArray(R.array.arrBuoiTrongNgay);
        adapter = new ArrayAdapter<String>(ActivityAddSubjects.this, android.R.layout.simple_spinner_item,dsBuoi);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerBuoiTrongNgay.setAdapter(adapter);

    }

    //Dialog Add
    private void DialogAdd() {

        //Tạo đối tượng cửa sổ dialog
        Dialog dialog  =  new Dialog(this);

        //Nạp layout vào
        dialog.setContentView(R.layout.dialogadd);

        //Click No mới thoát, click ngoài ko thoát
        dialog.setCanceledOnTouchOutside(false);

        //Ánh xạ
        Button btnYes = dialog.findViewById(R.id.buttonYesAddSubject);
        Button btnNo = dialog.findViewById(R.id.buttonNoAddSubject);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subjecttitle = edtSubjectTitle.getText().toString();
                String credits = edtCredits.getText().toString();
                String time = edtTime.getText().toString();
                String place = edtPlace.getText().toString();
                String buoi = edtBuoi.getText().toString();
                String thu = edtThu.getText().toString();

                if(subjecttitle.equals("") || credits.equals("") || time.equals("") || place.equals("") || buoi.equals("") || thu.equals("")){
                    Toast.makeText(ActivityAddSubjects.this,"Vui lòng nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checksubject = database.checkschedule(thu,buoi);
                    if(checksubject == false){
                        Subject subject = CreatSubject();
                        database.AddSubjects(subject);
                        //Khởi tạo lại activity main
                        Intent intent = new Intent(ActivityAddSubjects.this,ActivitySubjects.class);
                        //finish();
                        startActivity(intent);
                        Toast.makeText(ActivityAddSubjects.this,"Thêm thành công",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getApplication(),"Trùng lịch môn học, hãy sửa lại",Toast.LENGTH_LONG).show();
                    }

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
    private Subject CreatSubject(){

        Intent intent = getIntent();

        String subjecttitle = edtSubjectTitle.getText().toString();
        int credits = Integer.parseInt(edtCredits.getText()+"");
        String time = edtTime.getText().toString();
        String place = edtPlace.getText().toString();
        String thu = edtThu.getText().toString();
        String buoi = edtBuoi.getText().toString();
        String email = TG.email;


        Subject subject = new Subject(subjecttitle,credits,time,place,email,thu,buoi);
        return subject;
    }


}