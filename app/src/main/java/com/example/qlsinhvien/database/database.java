package com.example.qlsinhvien.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.qlsinhvien.model.Student;
import com.example.qlsinhvien.model.Subject;
import com.example.qlsinhvien.model.User;

public class database extends SQLiteOpenHelper {
    //Tên database
    private static String DATABASE_NAME = "studentmanagement";
    //Bảng môn học
    private static String TABLE_SUBJECTS = "subject";
    private static String ID_SUBJECTS = "idsubject";
    private static String SUBJECT_TITLE = "subjecttitle";
    private static String CREDITS = "credits";
    private static String TIME = "time";
    private static String PLACE = "place";
    private static String THU = "thu";
    private static String BUOI = "buoi";
    private static int VERSION = 1;

    //Bảng sinh viên
    private static String TABLE_STUDENT = "student";
    private static String ID_STUDENT = "idstudent";
    private static String STUDENT_NAME = "sudentname";
    private static String SEX = "sex";
    private static String STUDENT_CODE = "studentcode";
    private static String DATE_OF_BIRTH = "dateofbirth";

    //Bảng user
    private static String TABLE_USER = "users";
    private static String TK_USER = "username";
    private static String PASS_USER = "password";
    private static String NAME_USER = "name";
    private static String PHONE_USER = "phone";
    private static String ADDRESS_USER = "address";



    private Context context;


    //Tạo bảng user
    private String SQLQuery2 = "CREATE TABLE "+ TABLE_USER +" ( "+TK_USER+" TEXT PRIMARY KEY,  "
            +PASS_USER+" TEXT,"+NAME_USER+" TEXT, "+PHONE_USER+" TEXT, "+ADDRESS_USER+" TEXT ) ";

    //Tạo bảng môn học
    private String SQLQuery = "CREATE TABLE "+ TABLE_SUBJECTS +" ( "+ID_SUBJECTS+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +SUBJECT_TITLE+" TEXT, "
            +CREDITS+" INTEGER, "
            +TIME+" TEXT, "
            + PLACE+" TEXT,"
            +THU+" TEXT,"
            + BUOI+" TEXT,"
            +TK_USER+" TEXT, FOREIGN KEY ( "+TK_USER+" ) REFERENCES "
            +TABLE_USER+"("+TK_USER+"))";

    //Tạo bảng sinh viên
    private String SQLQuery1 = "CREATE TABLE "+ TABLE_STUDENT +" ( "+ID_STUDENT+" integer primary key AUTOINCREMENT, "
            +STUDENT_NAME+" TEXT, "
            +SEX+" TEXT, "
            +STUDENT_CODE+" TEXT, "
            +DATE_OF_BIRTH+" TEXT, "
            +ID_SUBJECTS+" INTEGER , FOREIGN KEY ( "+ ID_SUBJECTS +" ) REFERENCES "+
            TABLE_SUBJECTS+"("+ID_SUBJECTS+"))";


    public database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Tạo 2 bảng
        db.execSQL(SQLQuery);
        db.execSQL(SQLQuery1);
        db.execSQL(SQLQuery2);
     //   db.execSQL("CREATE TABLE users(username TEXT PRIMARY KEY, password TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_SUBJECTS);
    }

    //Insert User
    public Boolean AddUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();

        //không thể lưu trực tiếp xuống insert nên thông qua contentvalues
        ContentValues values = new ContentValues();
        values.put(TK_USER,user.getTk_user());
        values.put(PASS_USER,user.getPass_user());
        values.put(NAME_USER, user.getName_user());
        values.put(PHONE_USER, user.getPhone_user());
        values.put(ADDRESS_USER, user.getAddress_user());

        long result = db.insert("users",null,values);
      //  db.close();
        if(result == -1) return false;
        else
            return true;

    }

    public Boolean checkusername(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username = ?",new String[] {username});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username = ? AND password = ?" , new String[] {username,password});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    //Check trùng lịch môn học
    public Boolean checkschedule(String thu, String buoi){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_SUBJECTS+" WHERE thu = ? AND buoi = ?" , new String[] {thu,buoi});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    //Insert môn học
    public void AddSubjects(Subject subject){
        SQLiteDatabase db = this.getWritableDatabase();

        //không thể lưu trực tiếp xuống insert nên thông qua contentvalues
        ContentValues values = new ContentValues();
        values.put(SUBJECT_TITLE,subject.getSubject_title());
        values.put(CREDITS,subject.getNumber_of_credits());
        values.put(TIME,subject.getTime());
        values.put(PLACE,subject.getPlace());
        values.put(TK_USER, subject.getTk_user());
        values.put(THU,subject.getTkb_thu());
        values.put(BUOI,subject.getTkb_buoi());


        db.insert(TABLE_SUBJECTS,null,values);
        //đóng lại db cho an toàn
        db.close();
    }
    //cập nhật môn học
    public boolean UpdateSubject(Subject subject, int id){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(SUBJECT_TITLE,subject.getSubject_title());
        values.put(CREDITS,subject.getNumber_of_credits());
        values.put(TIME,subject.getTime());
        values.put(PLACE,subject.getPlace());
        values.put(THU,subject.getTkb_thu());
        values.put(BUOI,subject.getTkb_buoi());

        db.update(TABLE_SUBJECTS,values,ID_SUBJECTS+" = "+id,null);
        Log.e("Ok : ",id+" - id "+values.get(SUBJECT_TITLE)+" + "+values.get(CREDITS)+" + "+values.get(TIME)+" + "+values.get(PLACE));
        return true;
    }
    //cập nhật sinh viên
    public boolean UpdateStudent(Student student, int id){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(STUDENT_NAME,student.getStudent_name());
        values.put(SEX,student.getSex());
        values.put(STUDENT_CODE,student.getStudent_code());
        values.put(DATE_OF_BIRTH,student.getDate_of_birth());



        db.update(TABLE_STUDENT,values,ID_STUDENT+" = "+id,null);
        Log.e("Ok : ",id+" - id "+values.get(STUDENT_NAME)+" + "+values.get(SEX)+" + "+values.get(STUDENT_CODE)+" + "+values.get(DATE_OF_BIRTH));
        return true;
    }

    //Lấy tất mon hoc
    public Cursor getDataSubjects(String tk_user){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_SUBJECTS+" WHERE "+TK_USER+" = "+"'"+ tk_user+ "'",null);
        return res;
    }

    //Lấy Information user
    public Cursor getDataUser(String tk_user){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+ TABLE_USER+" WHERE "+TK_USER+" = "+"'"+ tk_user+ "'", null);
        return res;
    }

    //Thứ 2 Sáng
    public Cursor getSubjectT2S(String tk_user,String Thu, String Buoi){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+ TABLE_SUBJECTS+" WHERE "+TK_USER+" = "+"'"+ tk_user +"' AND "
                +THU+" = "+"'"+ Thu + "' AND " + BUOI+ " = "+ "'"+ Buoi + "'", null);
        return res;
    }



    //xóa môn học
    public int DeleteSubject(int i){
        SQLiteDatabase db = this.getWritableDatabase();
        int res = db.delete(TABLE_SUBJECTS,ID_SUBJECTS+" = "+i,null);
        return res;
    }
    //xóa student
    public int DeleteSubjectStudent(int i){
        SQLiteDatabase db = this.getWritableDatabase();
        int res = db.delete(TABLE_STUDENT,ID_SUBJECTS+" = "+i,null);
        return res;
    }


    //Insert student
    public void AddStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();

        //không thể lưu trực tiếp xuống insert nên thông qua contentvalues
        ContentValues values = new ContentValues();
        values.put(STUDENT_NAME,student.getStudent_name());
        values.put(SEX,student.getSex());
        values.put(STUDENT_CODE,student.getStudent_code());
        values.put(DATE_OF_BIRTH,student.getDate_of_birth());
        values.put(ID_SUBJECTS,student.getId_subject());

        db.insert(TABLE_STUDENT,null,values);
        //đóng lại db cho an toàn
        db.close();
    }
    //Lấy tất sinh viên thuộc môn học đó
    public Cursor getDataStudent(int id_subject){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_STUDENT+" WHERE "+ID_SUBJECTS+" = "+id_subject,null);
        return res;
    }

    //xóa student
    public int DeleteStudent(int i){
        SQLiteDatabase db = this.getWritableDatabase();
        int res = db.delete(TABLE_STUDENT,ID_STUDENT+" = "+i,null);
        return res;
    }
}
