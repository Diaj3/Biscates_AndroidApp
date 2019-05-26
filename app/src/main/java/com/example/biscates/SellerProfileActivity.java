package com.example.biscates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SellerProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_profile);
        try {this.getSupportActionBar().hide();} catch(NullPointerException e){}
        ImageView backB = findViewById(R.id.backButton3);
        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SellerProfileActivity.this, DisplayBiscatesActivity.class));
            }
        });
    }
}
