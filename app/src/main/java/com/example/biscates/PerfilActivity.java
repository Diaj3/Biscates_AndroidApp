package com.example.biscates;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.biscates.models.Biscates;
import com.google.firebase.auth.FirebaseAuth;

public class PerfilActivity extends AppCompatActivity {
    float x1, x2, y1, y2;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        try {          this.getSupportActionBar().hide();        } catch (NullPointerException e) {        }

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
                    }
                return false;
            }
        });

        // Logout
        firebaseAuth = FirebaseAuth.getInstance();
        TextView logoutbtn = findViewById(R.id.end_session);
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                startActivity(new Intent(PerfilActivity.this, MainActivity.class));
            }
        });
    }

    // Swipe
    public boolean onTouchEvent(MotionEvent touchevent){
        switch (touchevent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchevent.getX();
                y1 = touchevent.getY();
                System.out.println(x1 + y1);
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchevent.getX();
                y2 = touchevent.getY();
                System.out.println(x2 + y2);
                if(x1 > x2){
                    System.out.println("devia arrastar");
                    Intent i = new Intent(getApplicationContext(), Biscates.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
}
