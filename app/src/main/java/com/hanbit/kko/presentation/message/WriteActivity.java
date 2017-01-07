package com.hanbit.kko.presentation.message;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hanbit.kko.R;
import com.hanbit.kko.service.MessageService;
import com.hanbit.kko.service.MessageServiceImpl;

public class WriteActivity extends AppCompatActivity {
    //인스턴스 변수
    MessageService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        //인스턴스 변수 초기화  Activity에서 Service로 alt+엔터로 service쪽에 생성자 생성
        service = new MessageServiceImpl(this.getApplicationContext());


    }
}
