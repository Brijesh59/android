package com.example.infinity.recyclerview;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomListAdapter extends RecyclerView.Adapter<CustomListAdapter.MyViewHolder>{
     ArrayList<String> names;
     ArrayList<Integer> images;

    // Constructor
    CustomListAdapter(ArrayList<String> names, ArrayList<Integer> images)                                       {
       this.names = names;
       this.images = images;
    }

    // ViewHolder Class
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView, deleteButton;
        ConstraintLayout constraintLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);
            deleteButton = itemView.findViewById(R.id.delete);
        }
    }

    // This is something you need to create always, so need to remember the same exact code
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View listItem = inflater.inflate(R.layout.custom_view, viewGroup, false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {

        myViewHolder.textView.setText(names.get(i));
        myViewHolder.imageView.setImageResource(images.get(i));

        myViewHolder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), names.get(i), Toast.LENGTH_SHORT).show();
            }
        });

        myViewHolder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                names.remove(i);
                images.remove(i);
                notifyItemRemoved(i);
                notifyItemRangeChanged(i, names.size());
                myViewHolder.itemView.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

}
