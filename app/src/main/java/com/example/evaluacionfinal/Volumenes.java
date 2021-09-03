package com.example.evaluacionfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.mindorks.placeholderview.PlaceHolderView;

import WebServicies.WsRevista;

public class Volumenes extends AppCompatActivity {

    PlaceHolderView placeHolderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumenes);

        Bundle extra = getIntent().getExtras();
        String value = extra.getString("idrevista");

        placeHolderView = (PlaceHolderView) findViewById(R.id.pvh_volumenes);
        placeHolderView.setHasFixedSize(true);
        placeHolderView.setLayoutManager(new LinearLayoutManager(this));

        WsRevista ws_revista = new WsRevista("https://revistas.uteq.edu.ec/ws/issues.php?j_id=" + value, Volumenes.this);
        ws_revista.loadVolume(placeHolderView);

    }
}