package com.example.biscates;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayBiscatesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_biscate);
        try {this.getSupportActionBar().hide();} catch(NullPointerException e){}

        // Fav Star
        final ImageView star = findViewById(R.id.star_before);
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star.setImageResource(R.drawable.star_after_click);
                Toast.makeText(DisplayBiscatesActivity.this, "Biscate adicionado aos favoritos", Toast.LENGTH_SHORT).show();
            }
        });

        // Seta Retroceder
        ImageView backButton = findViewById(R.id.backButton2);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DisplayBiscatesActivity.this, BiscatesActivity.class));
            }
        });

        TextView profile = findViewById(R.id    .namePerson);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DisplayBiscatesActivity.this, SellerProfileActivity.class
                ));
            }
        });
        // Call Button
        Button callButton = findViewById(R.id.callButton);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dialIntent = new Intent();
                dialIntent.setAction(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:987654321"));
                startActivity(dialIntent);
            }
        });

    }

}
