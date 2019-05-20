package com.example.biscates;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class NovoBiscateActivity extends AppCompatActivity {
    ArrayList<String> categorias;
    Spinner spinner_categorias;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.novo_biscate);

        spinner_categorias = (Spinner) findViewById(R.id.spinner_categorias);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categorias, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_categorias.setAdapter(adapter);

    }
}
