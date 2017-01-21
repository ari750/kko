package com.hanbit.kko.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.hanbit.kko.domain.MemberBean;

import java.util.ArrayList;

/**
 * Created by hb2012 on 2017-01-07.
 */
//database접속, 쿼리문 적용
public class MemberDAO extends SQLiteOpenHelper{ //alt + 엔터

    //생성자 생성 - 데이타베이스 경로(applicationContext)
    public MemberDAO(Context applicationContext) {
        super(applicationContext,"hanbit.db",null,1);   //기존 DB삭제 hanbit.db로 변경 (데이타베이스 생성)
        this.getWritableDatabase();
    }
/*
    public MemberDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
*/

    @Override
    //객체 생성
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS Member \n" +
                "(\n" +
                "\tid TEXT PRIMARY KEY,\n" +
                "    pw TEXT,\n" +
                "    name TEXT,\n" +
                "    email TEXT,\n" +
                "    phone TEXT,\n" +
                "    photo TEXT,\n" +
                "    addr TEXT\n" +
                ");");
        db.execSQL("CREATE TABLE IF NOT EXISTS Message \n" +
                "(\n" +
                "    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    sender TEXT,\n" +
                "    receiver TEXT,\n" +
                "    content TEXT,\n" +
                "    writeTime TEXT,\n" +
                "    id TEXT,\n" +
                "    FOREIGN KEY(id) REFERENCES Member(id)\n" +
                ");    ");
/*
        db.execSQL("INSERT INTO Member(id,pw,name,email,phone,photo,addr)\n" +
                "VALUES('hong','1','홍길동','hong@test.com','010-2449-4191','default_profile','서울');");

        db.execSQL("INSERT INTO Member(id,pw,name,email,phone,photo,addr)\n" +
                "VALUES('kim','1','김유신','hong@test.com','010-2449-4191','default_profile','서울');");
        db.execSQL("INSERT INTO Member(id,pw,name,email,phone,photo,addr)\n" +
                "VALUES('Lee','1','이유경','hong@test.com','010-2449-4191','default_profile','서울');");
        db.execSQL("INSERT INTO Member(id,pw,name,email,phone,photo,addr)\n" +
                "VALUES('Kang','1','강소라','hong@test.com','010-2449-4191','default_profile','서울');");
*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // I insert O
    public void insert(MemberBean param) {                  //createMember

        String sql = "";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close(); //리턴값이 없는 메소드의 경우 db.close()
    }
    public ArrayList<MemberBean> selectAll() {                    //readAll
        ArrayList<MemberBean> list = new ArrayList<MemberBean>();
        String sql = "SELECT id,pw,name,email,phone,photo,addr FROM MEMBER ";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor != null){
            Log.d("member !!","Exist !!");
            cursor.moveToFirst();
        }
        do{
            MemberBean member = new MemberBean();
            member.setId(cursor.getString(0));
            member.setPw(cursor.getString(1));
            member.setName(cursor.getString(2));
            member.setEmail(cursor.getString(3));
            member.setPhone(cursor.getString(4));
            member.setPhoto(cursor.getString(5));
            member.setAadr(cursor.getString(6));
            list.add(member);
        }while(cursor.moveToNext());
        Log.d("Member Count",String.valueOf(list.size()));
        return list;
    }

    public ArrayList<MemberBean> selectByName(String name) {
        return null;
    }

    public MemberBean selectById(String id){                          //readOne
        MemberBean member = new MemberBean();
        String sql = "SELECT id,pw,name,email,phone,photo,addr FROM member WHERE id = '"+id+"';";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToNext()){

            Log.d("ID결과:",cursor.getString(0));
            member.setId(cursor.getString(0));
            member.setPw(cursor.getString(1));
            member.setName(cursor.getString(2));
            member.setEmail(cursor.getString(3));
            member.setPhone(cursor.getString(4));
            member.setPhoto(cursor.getString(5));
            member.setAadr(cursor.getString(6));

        }else{
            member.setId("fail");
        }
        return member;
    }
    public MemberBean login(MemberBean param){                 //보안상 bean으로 id,pw전달
        MemberBean member = new MemberBean();
        String sql = "SELECT id,pw,name,email,phone,photo,addr FROM member WHERE id = '"+param.getId()+"' AND pw = '"+param.getPw()+"' ";
        Log.d("login SQL:",sql);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToNext()){

            Log.d("ID결과:",cursor.getString(0));
            member.setId(cursor.getString(0));
            member.setPw(cursor.getString(1));
            member.setName(cursor.getString(2));
            member.setEmail(cursor.getString(3));
            member.setPhone(cursor.getString(4));
            member.setPhoto(cursor.getString(5));
            member.setAadr(cursor.getString(6));

        }else{
            member.setId("fail");
        }
        Log.d("login result:",member.getId());
        return member;
    }
    public int count(){                                     //readCount}
        int count = 0;
        String sql = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        return count;
    }
    public void update(MemberBean param){                   //updateMember
        String sql = "UPDATE Member SET pw ='"+param.getPw()+"', name ='"+param.getName()+"', phone='"+param.getPhone()+"', addr = '"+param.getAadr()+"', photo = '"+param.getPhoto()+"'" +
                " WHERE id = '"+param.getId()+"'";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }
    public void delete(String id){                          //deleteMember
        String sql = "DELETE FROM Member WHERE id = '"+id+"'";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }
}
