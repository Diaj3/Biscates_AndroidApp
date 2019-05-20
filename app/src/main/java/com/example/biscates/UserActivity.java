package com.example.biscates;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.biscates.R;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {
    ArrayList<String> cidades;
    Spinner spinner_cidades;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.user_profile);

        spinner_cidades = (Spinner)findViewById(R.id.spinner_cidades);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cidades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_cidades.setAdapter(adapter);

    }

}
