package com.example.gymapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

public class PlanRecViewAdapter extends RecyclerView.Adapter<PlanRecViewAdapter.ViewHolder>{

    private Context context;
    private ArrayList<Plan> plans = new ArrayList<>();

    public PlanRecViewAdapter(Context context) {
        this.context = context;
    }

    private String type = "";

    public interface DeletePlan{
        void onDeletingPlan(String day);
    }
    private DeletePlan deletePlan;

    public PlanRecViewAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plan_list_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.trainingName.setText(plans.get(position).getTraining().getName());
        holder.shortDesc.setText(plans.get(position).getTraining().getShortDesc());
        Glide.with(context)
                .asBitmap()
                .load(plans.get(position).getTraining().getImageUrl())
                .into(holder.trainingImage);
        holder.displayTime.setText(String.valueOf(plans.get(position).getMinutes()));

        if(plans.get(position).isAccomplished()){
            holder.emptyCheckBox.setVisibility(View.GONE);
            holder.filledCheckBox.setVisibility(View.VISIBLE);
        }
        else {
            holder.emptyCheckBox.setVisibility(View.VISIBLE);
            holder.filledCheckBox.setVisibility(View.GONE);
        }

        holder.planCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context,TrainingActivity.class);
                intent.putExtra("training",plans.get(position).getTraining());
                context.startActivity(intent);
            }
        });

        if(type.equals("edit")){
            holder.emptyCheckBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Accomplished?")
                            .setMessage("Have you done " + plans.get(position).getTraining().getName() + " ?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    plans.get(position).setAccomplished(true);
                                    for(Plan plan: Util.getUserPlans()){
                                        if(plan.equals(plans.get(position))){
                                            plan.setAccomplished(true);
                                        }
                                    }
                                    notifyDataSetChanged();
                                }
                            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.create().show();
                }
            });

            try {
                deletePlan = (DeletePlan) context;
            }catch (ClassCastException e){
                e.printStackTrace();
            }

            holder.planCardView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    AlertDialog.Builder builder =new AlertDialog.Builder(context);
                    builder.setTitle("Delete")
                            .setMessage("Are you sure you want to delete " + plans.get(position).getTraining().getName() + "" +
                                    " from your weekly plans?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Util.removePlan(plans.get(position));
                                    deletePlan.onDeletingPlan(plans.get(position).getDay());
                                }
                            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.create().show();
                    return true;
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return plans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView trainingName,displayTime,shortDesc;
        private ImageView trainingImage,emptyCheckBox,filledCheckBox;
        private CardView planCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            trainingName = itemView.findViewById(R.id.trainingName);
            trainingImage = itemView.findViewById(R.id.trainingImage);
            displayTime = itemView.findViewById(R.id.displayTime);
            shortDesc = itemView.findViewById(R.id.shortDesc);
            emptyCheckBox = itemView.findViewById(R.id.emptyCheckBox);
            filledCheckBox = itemView.findViewById(R.id.filledCheckBox);
            planCardView = itemView.findViewById(R.id.planCardView);
        }
    }

    public void setPlans(ArrayList<Plan> plans) {
        this.plans = plans;
        notifyDataSetChanged();
    }

    public void setType(String type) {
        this.type = type;
    }
}
