package com.example.biscates;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class BiscatesActivity extends AppCompatActivity {
    float x1, x2, y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biscates);
        try {this.getSupportActionBar().hide();} catch(NullPointerException e){}

        // Add activity
        FloatingActionButton add_bisc = findViewById(R.id.plusButton);
        add_bisc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BiscatesActivity.this, NewBiscateActivity.class));
            }
        });

        // Go to Biscate with more information
        Button goToButton = findViewById(R.id.goToButton);
        goToButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BiscatesActivity.this, DisplayBiscateActivity.class));
            }
        });

        // NavBar
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_profile:
                        Intent intent = new Intent(BiscatesActivity.this, PerfilActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_dashboard:
                        break;                }
                return false;
            }
        });
    }
}

