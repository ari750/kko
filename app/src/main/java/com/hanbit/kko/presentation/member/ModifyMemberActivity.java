package com.hanbit.kko.presentation.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hanbit.kko.R;
import com.hanbit.kko.domain.MemberBean;
import com.hanbit.kko.service.MemberService;
import com.hanbit.kko.service.MemberServiceImpl;


public class ModifyMemberActivity extends AppCompatActivity implements View.OnClickListener{
    MemberService service;
    MemberBean member;
    EditText etPass,etName,etPhone,etAddr,etPhoto;
    TextView tvId;
    Button btUpdate,btCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_member);
        service = new MemberServiceImpl(this.getApplicationContext());
        Intent intent = this.getIntent();
        String id = intent.getExtras().getString("id");
        member = service.serachById(id);
        tvId = (TextView) findViewById(R.id.tvId);
        etPass = (EditText) findViewById(R.id.etPass);
        etName = (EditText) findViewById(R.id.etName);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etAddr = (EditText) findViewById(R.id.etAddr);
        btUpdate = (Button) findViewById(R.id.btUpdate);
        btCancel = (Button) findViewById(R.id.btCancel);
        btUpdate.setOnClickListener(this);
        btCancel.setOnClickListener(this);
        Log.d("*******멤버아이디:",member.getId());
        tvId.setText(member.getId());
        etPass.setHint(member.getPw());
        etName.setHint(member.getName());
        etPhone.setHint(member.getPhone());
        etAddr.setHint(member.getAadr());
        etPhoto.setHint(member.getPhoto());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btUpdate:
                MemberBean temp = new MemberBean();
                temp.setId(tvId.getText().toString());
                //String pass = (etPass.getText().toString() == null)?member.getPw():etPass.getText().toString();
                temp.setPw( (etPass.getText().toString().equals(""))?member.getPw():etPass.getText().toString());
                temp.setName( (etName.getText().toString().equals(""))?member.getName():etName.getText().toString());
                temp.setAadr( (etAddr.getText().toString().equals(""))?member.getAadr():etAddr.getText().toString());
                temp.setPhone( (etPhone.getText().toString().equals(""))?member.getPhone():etPhone.getText().toString());
                temp.setPhoto( (etPhone.getText().toString().equals(""))?member.getPhoto():etPhone.getText().toString());
                service.modify(temp);
                break;
            case R.id.btCancel:
                break;
        }
        Intent intent = new Intent(ModifyMemberActivity.this,MemberDetailActivity.class);
        intent.putExtra("id",member.getId());
        startActivity(intent);

    }
}
