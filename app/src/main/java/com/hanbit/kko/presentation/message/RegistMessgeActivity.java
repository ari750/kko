package com.hanbit.kko.presentation.message;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.hanbit.kko.R;

public class RegistMessgeActivity extends AppCompatActivity {
    WebView mWebView;
    WebSettings mWebSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_messge);
        Intent intent = this.getIntent();
        String phone = intent.getExtras().getString("phone");
        mWebView = (WebView) findViewById(R.id.mWebView);
        mWebSettings = mWebView.getSettings();
        mWebSettings.setJavaScriptEnabled(true);
        mWebSettings.setUseWideViewPort(true);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.addJavascriptInterface(new JavascriptInterface(this),"Hybrid");
        mWebView.loadUrl("file:///android_asset/www/message_write.html");
    }
}
