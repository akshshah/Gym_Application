package com.example.gymapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity implements PlanRecViewAdapter.DeletePlan {
    private static final String TAG = "EditActivity";
    public RecyclerView editRecView;
    private TextView txtDay;
    public Button addPlan;

    private PlanRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editRecView = findViewById(R.id.editRecView);
        txtDay = findViewById(R.id.txtDay);
        addPlan = findViewById(R.id.addPlan);

        adapter = new PlanRecViewAdapter(this);
        editRecView.setAdapter(adapter);
        editRecView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setType("edit");

        Intent intent = getIntent();
        try{
            Log.d(TAG, "onCreate: Edit");
            String day = intent.getStringExtra("day");
            if (null != day){
                txtDay.setText(day);

                ArrayList<Plan> plans = new ArrayList<>();
                for(Plan plan : Util.getUserPlans()){
                    if(plan.getDay().equals(day)){
                        plans.add(plan);
                    }
                }
                adapter.setPlans(plans);
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }

        addPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditActivity.this,AllTrainingActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDeletingPlan(String day) {
        txtDay.setText(day);

        ArrayList<Plan> plans = new ArrayList<>();
        for (Plan plan : Util.getUserPlans()){
            if(plan.getDay().equals(day)){
                plans.add(plan);
            }
        }
        adapter.setPlans(plans);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(EditActivity.this,PlanActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}
