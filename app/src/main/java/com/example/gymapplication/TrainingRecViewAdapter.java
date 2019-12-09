package com.example.gymapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class TrainingRecViewAdapter extends RecyclerView.Adapter<TrainingRecViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<GymTraining> trainings = new ArrayList<>();

    public TrainingRecViewAdapter(Context context) {
        this.context = context;
    }

    public TrainingRecViewAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trainig_list_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.trainingName.setText(trainings.get(position).getName());
        holder.shortDesc.setText(trainings.get(position).getShortDesc());

        Glide.with(context)
                .asBitmap()
                .load(trainings.get(position).getImageUrl())
                .into(holder.trainingImage);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,TrainingActivity.class);
                intent.putExtra("training",trainings.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return trainings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView shortDesc,trainingName;
        private ImageView trainingImage;
        private CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            shortDesc = itemView.findViewById(R.id.shortDesc);
            trainingName = itemView.findViewById(R.id.trainingName);
            trainingImage = itemView.findViewById(R.id.trainingImage);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }

    public void setTrainings(ArrayList<GymTraining> trainings)
    {
        this.trainings = trainings;
        notifyDataSetChanged();
    }
}
