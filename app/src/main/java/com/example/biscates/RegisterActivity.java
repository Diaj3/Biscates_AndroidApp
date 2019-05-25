package com.example.biscates;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.biscates.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    User user;
    FirebaseAuth firebaseAuth;
    Spinner spinnercidades;
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
        this.spinnercidades = findViewById(R.id.spinnerCidadesRegisto);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.cidades, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnercidades.setAdapter(adapter2);

        // On click regist jump to login page
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIfFieldsAreValid()) {
                    registerUserAndNavigateToHome();
                }
            }
        });

        // Cancel Button
        Button cancelButton = findViewById(R.id.cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
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
        } else if (spinnercidades.getSelectedItem().toString().equals("Por favor, selecione uma cidade...")){
            Toast.makeText(this, "Por favor, selecione uma cidade.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void registerUserAndNavigateToHome() {
//        this.user = new User( spinnercidades.getSelectedItem().toString(), nameField.getText().toString());
        final String name  = nameField.getText().toString();
        String email = emailField.getText().toString();
        String password = passField.getText().toString();
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    //getting the username test
                    Intent intent = new Intent(getBaseContext(), PerfilActivity.class);
                    intent.putExtra("Name", name);
                    startActivity(intent);

                    Toast.makeText(RegisterActivity.this, "Utilizador criado.", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                } else {
                    Toast.makeText(RegisterActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                    Log.w("tag", task.getException());
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Tem a certeza que pretende cancelar?");
        // alert.setMessage("Message");

        alert.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
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
