package com.example.biscates;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth fireBaseAuth;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fireBaseAuth = FirebaseAuth.getInstance();
        // Regist buttons
        Button logBtn = findViewById(R.id.loginBtn);
        TextView regBtn = findViewById(R.id.registerBtn);
        final TextView emailInput =  findViewById(R.id.loginEmail);
        final TextView passwordInput =  findViewById(R.id.loginPasswordField);
        // On click login jump to login page
        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();
                if(email.length() > 0 && password.length() > 0) {
                    loginWithUsernameAndPassword(email, password);
                }else {
                    Toast.makeText(MainActivity.this, "Tens de preencher os campos burro", Toast.LENGTH_SHORT).show();
                }
            }
        });


        // On click regist jump to login page
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
    }

    public void onStart() {
        super.onStart();
        user = fireBaseAuth.getCurrentUser();
        if(user != null) {
            navigateToHomeScreen();
        }
    }

    private void loginWithUsernameAndPassword(String email, String password) {
        fireBaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            System.out.println("Login feito com sucesso");
                            user = fireBaseAuth.getCurrentUser();
                            navigateToHomeScreen();
                        } else {
                            Toast.makeText(MainActivity.this, "Oh burro, isso nao e assim", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void navigateToHomeScreen() {
        startActivity(new Intent(MainActivity.this, HomeActivity.class));
    }
}
