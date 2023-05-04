package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void maps(View view){
        PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
        TextInputEditText estadosp = (TextInputEditText) findViewById(R.id.estadoPS);
        String estado = estadosp.getText().toString();
        TextView informacao = (TextView) findViewById(R.id.InformaEs);

        if (estado.equals("PR")) {
            photoView.setImageResource(R.drawable.pr);
            informacao.setText("Área Territorial = 199.298,981 km²\nPopulação estimada = 11.597.484 pessoas\nIDH = 0,749\nDensidade Demográfica = 52,40 hab/km²");
        }
        else if (estado.equals("SC")) {
            photoView.setImageResource(R.drawable.sc);
            informacao.setText("Área Territorial = 95.730,690 km²\nPopulação estimada = 7.338.473 pessoas\nIDH = 0,774\nDensidade Demográfica = 65,29 hab/km²");
        }
        else if (estado.equals("RS")) {
            photoView.setImageResource(R.drawable.rs);
            informacao.setText("Área Territorial = 281.707,151 km²\nPopulação estimada = 11.466.630 pessoas\nIDH = 0,746\nDensidade Demográfica = 39,79 hab/km²");
        }
    }
}