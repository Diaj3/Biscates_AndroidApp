package com.example.biscates;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.biscates.models.Biscates;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class BiscatesAdapter extends RecyclerView.Adapter<BiscatesAdapter.ExampleViewHolder> {
    private ArrayList<Biscates> mExampleList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextViewTitle;
        public TextView mTextViewLocation;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imagensCategorias);
            mTextViewTitle = itemView.findViewById(R.id.tituloBiscate);
            mTextViewLocation = itemView.findViewById(R.id.localizacaoBiscate);
        }
    }

    public BiscatesAdapter(ArrayList<Biscates> exampleList){
        mExampleList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.example_item, viewGroup, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        Biscates currentItem = mExampleList.get(position);
        holder.mImageView.setImageResource(currentItem.getmImageResource());
        holder.mTextViewTitle.setText(currentItem.getName());
        holder.mTextViewLocation.setText(currentItem.getLocation());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
