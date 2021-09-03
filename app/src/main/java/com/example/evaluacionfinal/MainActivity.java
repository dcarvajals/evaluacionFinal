package com.example.evaluacionfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mindorks.placeholderview.PlaceHolderView;

import WebServicies.WsRevista;

public class MainActivity extends AppCompatActivity {

    PlaceHolderView placeHolderView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarRevistas();
    }

    public void cargarRevistas () {
        placeHolderView = (PlaceHolderView) findViewById(R.id.phv_revistas);
        placeHolderView.setHasFixedSize(true);
        placeHolderView.setLayoutManager(new LinearLayoutManager(this));

        WsRevista ws_revista = new WsRevista("https://revistas.uteq.edu.ec/ws/journals.php", MainActivity.this);
        ws_revista.executeWs(placeHolderView);
    }
}