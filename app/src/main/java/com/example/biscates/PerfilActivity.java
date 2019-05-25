package com.example.biscates;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.biscates.models.Biscates;
import com.example.biscates.models.User;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class PerfilActivity extends AppCompatActivity {
    User user;
    float x1, x2, y1, y2;
    BottomNavigationView navView;
    FirebaseAuth firebaseAuth;
    String name = getIntent().getStringExtra("name");
    TextView namePerfil = (TextView)findViewById(R.id.namePerfil);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        try {this.getSupportActionBar().hide();} catch (NullPointerException e) {        }

//        String name = this.user.getName();
//        String location = this.user.getLocation();
//        namePerfil.setText(name);
//        locationPerfil.setText(location);

        // NavBar Navigation
        navView = findViewById(R.id.nav_view);
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

        //testing the username
        namePerfil.setText(name);

        // Logout
        firebaseAuth = FirebaseAuth.getInstance();
        Button logoutbtn = findViewById(R.id.endSession);
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    // CancelButton
    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Tem a certeza que pretende terminar sessão?");
        // alert.setMessage("Message");
        alert.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                firebaseAuth.signOut();
                startActivity(new Intent(PerfilActivity.this, MainActivity.class));
            }
        });
        alert.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.dismiss();
                    }
                });
        alert.show();

    }
}
