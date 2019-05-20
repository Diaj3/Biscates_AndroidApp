package com.example.biscates;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;

    TextView nameField;
    TextView emailField;
    TextView passField;
    TextView confirmPassField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize the firebase auth
        firebaseAuth = FirebaseAuth.getInstance();

        try {this.getSupportActionBar().hide();} catch(NullPointerException e){}

        setContentView(R.layout.activity_registo);

        Button registerBtn = findViewById(R.id.registerBtn);

        this.nameField = findViewById(R.id.registerName);

        this.emailField = findViewById(R.id.registerEmail);

        this.passField = findViewById(R.id.registerPassword);

        this.confirmPassField = findViewById(R.id.registerConfirmPassword);


        // On click regist jump to login page
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIfFieldsAreValid()) {
                    registerUserAndNavigateToHome();
                }
            }
        });
    }

    public boolean checkIfFieldsAreValid() {
        String name = this.nameField.getText().toString();
        String email = this.emailField.getText().toString();
        String password = this.passField.getText().toString();
        String confirmPassword = this.confirmPassField.getText().toString();
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos, por favor.", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "As Passwords não correspondem.", Toast.LENGTH_SHORT).show();
            return false;
        } else if (password.length() < 6 || confirmPassword.length() < 6){
            Toast.makeText(this, "A Password tem de ter 6 caracteres no mínimo.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void registerUserAndNavigateToHome() {
        String email = emailField.getText().toString();
        String password = passField.getText().toString();
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, "Utilizador criado.", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                } else {
                    Toast.makeText(RegisterActivity.this, "Erro a registar o utlizador", Toast.LENGTH_SHORT).show();
                    Log.w("tag", task.getException());
                }
            }
        });
    }
}
