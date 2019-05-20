package com.example.biscates;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.biscates.models.Biscates;

public class PerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        try {this.getSupportActionBar().hide();} catch(NullPointerException e){}

        // NavBar Navigation
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_profile:
                        break;
                    case R.id.navigation_dashboard:
                        Intent intent = new Intent(PerfilActivity.this, BiscatesActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_configuration:
                        Intent intent2 = new Intent(PerfilActivity.this, ConfigsActivity.class);
                        startActivity(intent2);
                        break;
                }
                return false;
            }
        });
      }

}
