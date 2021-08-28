package com.example.mmd;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    //Intialize variable
    Activity activity;
    ArrayList<String> arrayList;

    //craete constructor
    public MainAdapter(Activity activity, ArrayList<String> arrayList) {
        this.activity = activity;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //initialize view
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_selectable_list_item, parent, false);
        //Return view
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MainAdapter.ViewHolder holder, int position) {
        //Set text on text view
        holder.textView.setText(arrayList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Display Toast
                Toast.makeText(activity, arrayList.get(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        //Return arraysList Size

        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }
    }

}
