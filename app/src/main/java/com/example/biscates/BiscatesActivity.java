package com.example.biscates;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.biscates.models.Biscates;

import java.util.ArrayList;

public class BiscatesActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private FloatingActionButton plusButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biscates);
        try {this.getSupportActionBar().hide();} catch(NullPointerException e){}

        ArrayList<Biscates> bList = new ArrayList<>();
        bList.add((new Biscates(R.drawable.ic_menu_camera, "biscate1", "Viseu", 38.0, "Isto é uma descrição","967636092", "Animais")));
        bList.add((new Biscates(R.drawable.ic_menu_camera, "biscate1", "Viseu", 38.0, "Isto é uma descrição","967636092", "Animais")));
        bList.add((new Biscates(R.drawable.ic_menu_camera, "biscate1", "Viseu", 38.0, "Isto é uma descrição","967636092", "Animais")));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new BiscatesAdapter(bList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

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
    }
}
