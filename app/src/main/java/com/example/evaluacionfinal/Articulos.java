package com.example.evaluacionfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.mindorks.placeholderview.PlaceHolderView;

import WebServicies.WsRevista;

public class Articulos extends AppCompatActivity {

    PlaceHolderView placeHolderView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulos);

        Bundle extra = getIntent().getExtras();
        String value = extra.getString("idarticulo");

        placeHolderView = (PlaceHolderView) findViewById(R.id.pvh_articulos);
        placeHolderView.setHasFixedSize(true);
        placeHolderView.setLayoutManager(new LinearLayoutManager(this));

        WsRevista ws_revista = new WsRevista("https://revistas.uteq.edu.ec/ws/pubs.php?i_id=" + value, Articulos.this);
        ws_revista.loadArticulo(placeHolderView);
    }
}