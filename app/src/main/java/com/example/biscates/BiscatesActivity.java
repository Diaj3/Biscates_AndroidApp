package com.example.biscates;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.example.biscates.models.Biscates;

import java.util.ArrayList;

public class BiscatesActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private  ArrayList<Biscates> bList = new ArrayList<>();

    private FloatingActionButton plusButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biscates);
        try {this.getSupportActionBar().hide();} catch(NullPointerException e){}
//        createBiscatesList();
        buildRecyclerview();

        // Hide plus Button
        plusButton = findViewById(R.id.plusButton);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(dy > 0 ){
                    if(plusButton.isShown()) plusButton.hide();
                } else {
                    if(!plusButton.isShown()) plusButton.show();
                }
            }
        });
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BiscatesActivity.this, NewBiscateActivity.class));
            }
        });

        // NavBar
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_profile:
                        Intent intent = new Intent(BiscatesActivity.this, PerfilActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.navigation_dashboard:
                        break;                }
                return false;
            }
        });
        insertItem();
    }

    private void buildRecyclerview() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new BiscatesAdapter(bList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

//    private void createBiscatesList() {bList.add((new Biscates(R.drawable.ic_menu_camera, "biscate1", "Viseu", 38.0, "Isto é uma descrição","967636092", "Animais"))); }

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
