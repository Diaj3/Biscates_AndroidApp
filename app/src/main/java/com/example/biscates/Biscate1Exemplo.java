package com.example.biscates;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

public class Biscate1Exemplo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biscate1_exemplo);
        try {this.getSupportActionBar().hide();} catch(NullPointerException e){}

        // NavBar
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_profile:
                        Intent intent = new Intent(Biscate1Exemplo.this, PerfilActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_dashboard:
                        Intent intent3= new Intent(Biscate1Exemplo.this, BiscatesActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.navigation_configuration:
                        Intent intent2 = new Intent(Biscate1Exemplo.this, ConfigsActivity.class);
                        startActivity(intent2);
                        break;
                }
                return false;
            }
        });
    }

}
