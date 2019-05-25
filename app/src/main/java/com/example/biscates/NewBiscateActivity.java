package com.example.biscates;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class NewBiscateActivity extends AppCompatActivity {
    BiscatesActivity biscatesActivity;
    Spinner categorias;
    Spinner cidades;
    TextView name;
    TextView price;
    TextView contact;
    TextView description;
    TextView cc;
    TextView cc2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_biscate);
        try {this.getSupportActionBar().hide();} catch(NullPointerException e){}
        name = findViewById(R.id.nameBiscate);
        price = findViewById(R.id.price);
        contact = findViewById(R.id.contact);
        description = findViewById(R.id.description);
        cc = findViewById(R.id.charCount);
        cc2 = findViewById(R.id.charCount2);

        // Publish button
        Button publishButton = findViewById(R.id.publish);
        publishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkFields()){
                    //biscatesActivity.addBiscate(R.drawable.ic_menu_camera, "B2", "viseu", 38.0, "Isto é que é uma descrição", "967636092", "Categoria");
                    Intent intent = new Intent(NewBiscateActivity.this, BiscatesActivity.class);
                    intent.putExtra("name", name.getText().toString());
                    intent.putExtra("location", cidades.getSelectedItem().toString());
                    intent.putExtra("price", Double.parseDouble(price.getText().toString()));
                    intent.putExtra("description", name.getText().toString());
                    intent.putExtra("phone", contact.getText().toString());
                    intent.putExtra("categoria", categorias.getSelectedItem().toString());
                    startActivity(intent);
                    Toast.makeText(NewBiscateActivity.this, "Biscate Publicado!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Live counter of words
        description.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {          }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            // Change the color and text
            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() < 20){
                    cc.setTextColor(Color.parseColor("#ef4046"));
                }
                if(s.length() > 20){
                    cc.setTextColor(Color.parseColor("#5fe873"));
                }
                cc.setText(String.valueOf(s.length())); }});
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {            }
            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() > 40){
                    cc2.setTextColor(Color.parseColor("#ef4046"));
                }
                if(s.length() < 40){
                    cc2.setTextColor(Color.parseColor("#5fe873"));
                }
                cc2.setText(String.valueOf(40 - s.length() + "/40"));
            }
        });

        // Seta Retroceder
        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewBiscateActivity.this, BiscatesActivity.class));
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

        categorias = findViewById(R.id.spinner_categorias);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categorias, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorias.setAdapter(adapter);

        cidades = findViewById(R.id.spinnerCidades);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.cidades, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cidades.setAdapter(adapter2);
    }

    // CancelButton
    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Tem a certeza que pretende cancelar?");
        // alert.setMessage("Message");
        alert.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                startActivity(new Intent(NewBiscateActivity.this, BiscatesActivity.class));
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

    public boolean checkFields(){
        if(name.length() == 0 || price.length() == 0 || contact.length() == 0 || description.length() == 0){
            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(name.length() < 3 || name.length() > 40){
            Toast.makeText(this, "Por favor, insira um nome válido", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(contact.length() < 9){
            Toast.makeText(this, "Por favor, insira um contacto válido.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(description.length() < 20){
            Toast.makeText(this, "Por favor, insira uma descrição válida.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (categorias.getSelectedItem().toString().equals("Por favor, selecione uma categoria...")){
            Toast.makeText(this, "Por favor, selecione uma categoria.", Toast.LENGTH_SHORT).show();
        }

        if (cidades.getSelectedItem().toString().equals("Por favor, selecione uma cidade...")){
            Toast.makeText(this, "Por favor, selecione uma cidade.", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

}
