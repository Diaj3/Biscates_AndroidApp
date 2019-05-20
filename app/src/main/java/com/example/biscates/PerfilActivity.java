package com.example.biscates;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.biscates.models.Biscates;
import com.google.firebase.auth.FirebaseAuth;

public class PerfilActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    TextView nameField;
    TextView passField;
    TextView confirmPassField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }

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

        firebaseAuth = FirebaseAuth.getInstance();

        TextView logoutbtn = findViewById(R.id.end_session);

        this.nameField = findViewById(R.id.registerName);

        this.passField = findViewById(R.id.registerPassword);

        this.confirmPassField = findViewById(R.id.registerConfirmPassword);


        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                startActivity(new Intent(PerfilActivity.this, MainActivity.class));
            }
        });
    }

        public boolean checkIfFieldsAreValid () {
            String name = this.nameField.getText().toString();
            String password = this.passField.getText().toString();
            String confirmPassword = this.confirmPassField.getText().toString();
            if (name.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Todos os campos são obrigatórios", Toast.LENGTH_SHORT).show();
                return false;
            } else if (!password.equals(confirmPassword)) {
                Toast.makeText(this, "Password e Confirm Password têm de ser iguais", Toast.LENGTH_SHORT).show();
                return false;
            }
            return true;
        }

    }
