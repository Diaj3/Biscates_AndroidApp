package com.example.biscates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    TextView nameField;
    TextView passField;
    TextView confirmPassField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();

        try {this.getSupportActionBar().hide();} catch(NullPointerException e){}

        TextView logoutbtn = findViewById(R.id.end_session);

        Button registerBtn = findViewById(R.id.registerBtn);

        this.nameField = findViewById(R.id.registerName);

        this.passField = findViewById(R.id.registerPassword);

        this.confirmPassField = findViewById(R.id.registerConfirmPassword);


        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
            }
        });
    }

    public boolean checkIfFieldsAreValid() {
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
