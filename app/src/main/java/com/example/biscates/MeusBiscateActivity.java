package com.example.biscates;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MeusBiscateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meus_biscates);
        try {this.getSupportActionBar().hide();} catch(NullPointerException e){}

        // NavBar
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_profile:
                        Intent intent = new Intent(MeusBiscateActivity.this, PerfilActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_dashboard:
                        break;
                    case R.id.navigation_configuration:
                        Intent intent2 = new Intent(MeusBiscateActivity.this, ConfigsActivity.class);
                        startActivity(intent2);
                        break;
                }
                return false;
            }
        });

        configureBackButton();
    }

    private void configureBackButton(){
        Button backButton = (Button) findViewById(R.id.nextButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
