package com.hanbit.kko;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hanbit.kko.presentation.member.LoginActivity;
import com.hanbit.kko.presentation.member.RegistMemberActivity;
import com.hanbit.kko.util.BackPressCloseHandler;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button regist_btn, login_btn;
            //, menu_login, menu_help;
    //LinearLayout hepl_center;
    //TextView menu_home;
    //View mCustomView;
    private BackPressCloseHandler backPressCloseHandler;
    Button btJoin,btLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  menu_home = (TextView)findViewById(R.id.menu_home);
        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDefaultDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(false);
       // mCustomView = LayoutInflater.from(MainActivity.this).inflate(R.layout.main_customer,null);
       // actionBar.setCustomView(mCustomView);
       setContentView(R.layout.activity_main);
        init();
        /*
        btJoin = (Button) findViewById(btJoin);
        btLogin = (Button) findViewById(btLogin);
        btJoin.setOnClickListener(this);
        btLogin.setOnClickListener(this);
        */


    }

    public void init(){
        regist_btn =(Button)findViewById(R.id.regist_btn);
        login_btn = (Button) findViewById(R.id.login_btn);
      //  menu_login =(Button)mCustomView.findViewById(R.id.menu_login);
      //  menu_help =(Button)mCustomView.findViewById(R.id.menu_help);
        regist_btn.setOnClickListener(this);
        login_btn.setOnClickListener(this);
      //  menu_help.setOnClickListener(this);
      //  menu_login.setOnClickListener(this);
        backPressCloseHandler = new BackPressCloseHandler(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.regist_btn:
                startActivity(new Intent(MainActivity.this, RegistMemberActivity.class));
                break;
            case R.id.login_btn:
                this.startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
            /*case R.id.menu_help:
                this.startActivity(new Intent(MainActivity.this, null));
                break;
            case R.id.menu_login:
                this.startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;*/
        }

    }

    public void onBackPressed(){
        backPressCloseHandler.onBackPressed();
    }
}
