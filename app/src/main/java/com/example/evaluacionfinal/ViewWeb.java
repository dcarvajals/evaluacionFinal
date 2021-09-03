package com.example.evaluacionfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class ViewWeb extends AppCompatActivity {
    WebView miVisorWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_web);

        Bundle extra = getIntent().getExtras();
        String value = extra.getString("doi");

        miVisorWeb = (WebView) findViewById(R.id.wv_doi);
        final WebSettings ajustesVisorWeb = miVisorWeb.getSettings();
        ajustesVisorWeb.setJavaScriptEnabled(true);
        miVisorWeb.loadUrl(value);

    }
}