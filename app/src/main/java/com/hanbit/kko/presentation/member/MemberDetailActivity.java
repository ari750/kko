package com.hanbit.kko.presentation.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hanbit.kko.R;
import com.hanbit.kko.domain.MemberBean;
import com.hanbit.kko.presentation.message.RegistMessgeActivity;
import com.hanbit.kko.service.MemberService;
import com.hanbit.kko.service.MemberServiceImpl;
import com.hanbit.kko.util.Phone;

public class MemberDetailActivity extends AppCompatActivity  implements View.OnClickListener{
    MemberService service;
    MemberBean member;
    TextView tvID,tvPass,tvName,tvPhone,tvAddr;
    Button btCall,btMap,btMessage,btUpdate,btDelete,btList;
    ImageView ivPhoto;
    Phone phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_detail);
        service = new MemberServiceImpl(this.getApplicationContext());
        Intent intent = this.getIntent();
        String id = intent.getExtras().getString("id");
        member = service.serachById(id);
        phone = new Phone(this,this);

        tvID = (TextView) findViewById(R.id.tvID);
        tvPass = (TextView) findViewById(R.id.tvPass);
        tvName =(TextView) findViewById(R.id.tvName);
        tvPhone =(TextView) findViewById(R.id.tvPhone);
        tvAddr =(TextView) findViewById(R.id.tvAddr);
        btCall = (Button) findViewById(R.id.btCall);
        btMap = (Button) findViewById(R.id.btMap);
        btMessage = (Button) findViewById(R.id.btMessage);
        btUpdate = (Button) findViewById(R.id.btUpdate);
        btDelete = (Button) findViewById(R.id.btDelete);
        btList =(Button) findViewById(R.id.btList);
        ivPhoto = (ImageView) findViewById(R.id.iv_photo);

        tvID.setText(member.getId());
        tvPass.setText(member.getPw());
        tvName.setText(member.getName());
        tvPhone.setText(member.getPhone());
        tvAddr.setText(member.getAadr());
        Log.d("DB프로필이미지",member.getPhoto());
        int foo = getResources().getIdentifier(this.getPackageName()+":drawable/"+member.getPhoto(),null,null);
        ivPhoto.setImageDrawable(getResources().getDrawable(foo,getApplicationContext().getTheme()));

        btCall.setOnClickListener(this);
        btMap.setOnClickListener(this);
        btMessage.setOnClickListener(this);
        btUpdate.setOnClickListener(this);
        btDelete.setOnClickListener(this);
        btList.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btCall:
                Log.d("전화번호:",member.getPhone());
                phone.dial(member.getPhone());
                break;
            case R.id.btMap:
                Intent intent3 = new Intent(MemberDetailActivity.this, MapsActivity.class);
                member.setAadr("37.5662950,126.9779450");
                intent3.putExtra("position",member.getAadr());
                startActivity(intent3);
                break;
            case R.id.btMessage:
                Intent intent2 = new Intent(MemberDetailActivity.this, RegistMessgeActivity.class);
                intent2.putExtra("phone",member.getPhone());
                startActivity(intent2);
                break;
            case R.id.btUpdate:
                Intent intent = new Intent(MemberDetailActivity.this,ModifyMemberActivity.class);
                intent.putExtra("id",member.getId());
                startActivity(intent);
                break;
            case R.id.btDelete:
                service.unregist(member.getId());
                startActivity(new Intent(this, MemberListActivity.class));
                break;
            case R.id.btList:
                startActivity(new Intent(this, MemberListActivity.class));
                break;
        }
    }
}
