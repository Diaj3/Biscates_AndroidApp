package com.example.biscates;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import java.util.ArrayList;

public class PerfilActivity extends AppCompatActivity {
    float x1, x2, y1, y2;
    BottomNavigationView navView;
    FirebaseAuth firebaseAuth;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Biscates> bList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        try {this.getSupportActionBar().hide();} catch (NullPointerException e) {        }
        createBiscatesList();
        buildRecyclerview();
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

        // Butao apagar
        final Button eraseButton = findViewById(R.id.eraseButton);
        eraseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bList.remove(0);
                mAdapter.notifyDataSetChanged();
                eraseButton.setVisibility(View.GONE);
            }
        });
        // Logout
        firebaseAuth = FirebaseAuth.getInstance();
        Button logoutbtn = findViewById(R.id.endSession);
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        insertItem();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name =extras.getString("name");
            String location =extras.getString("location");
            Double price = extras.getDouble("price");
            String description= extras.getString("description");
            String cellphone = extras.getString("phone");
            String categoria = extras.getString("categoria");

            bList.add(new Biscates(R.drawable.ic_menu_camera, name, location, price, description, cellphone, categoria));
            mAdapter.notifyItemInserted(bList.size());
        }
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
    private void buildRecyclerview() {
        mRecyclerView = findViewById(R.id.recyclerView2);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new BiscatesAdapter(bList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void createBiscatesList() {
        bList.add((new Biscates(R.drawable.ic_menu_camera, "Cortar Relva",
            "Viseu", 25.0,
            "Preciso de alguém que me corte a relva. É um jardim com cerca de 25m2. Mais informações contactar.",
            "999666333", "Tarefas Domésticas")));
    }


    public void insertItem() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name =extras.getString("name");
            String location =extras.getString("location");
            Double price = extras.getDouble("price");
            String description= extras.getString("description");
            String cellphone = extras.getString("phone");
            String categoria = extras.getString("categoria");

            bList.add(new Biscates(R.drawable.ic_menu_camera, name, location, price, description, cellphone, categoria));
            mAdapter.notifyItemInserted(bList.size());
        }

    }

}
