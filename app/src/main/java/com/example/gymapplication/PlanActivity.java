package com.example.gymapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class PlanActivity extends AppCompatActivity {
    private static final String TAG = "PlanActivity";

    private RecyclerView monRecView,tueRecView,wedRecView,thuRecView,friRecView,satRecView,sunRecView;
    private Button addPlan;
    private RelativeLayout noPlanLayout;
    private NestedScrollView nestedScroll;
    private TextView editMon,editTue,editWed,editThu,editFri,editSat,editSun;

    private PlanRecViewAdapter monAdapter,tueAdapter,wedAdapter,thuAdapter,friAdapter,satAdapter,sunAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        initialize();
        initAdapter();
        initRecView();

        if(Util.getUserPlans().size()>0){
            noPlanLayout.setVisibility(View.GONE);
            nestedScroll.setVisibility(View.VISIBLE);
        }
        else {
            noPlanLayout.setVisibility(View.VISIBLE);
            nestedScroll.setVisibility(View.GONE);

        }

        setOnClick();
    }

    private void setOnClick(){

        addPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlanActivity.this,AllTrainingActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        editMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Monday");
                Intent intent = new Intent(PlanActivity.this,EditActivity.class);
                intent.putExtra("day","Monday");
                startActivity(intent);
            }
        });

        editThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlanActivity.this,EditActivity.class);
                intent.putExtra("day","Thursday");
                startActivity(intent);
            }
        });

        editTue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlanActivity.this,EditActivity.class);
                intent.putExtra("day","Tuesday");
                startActivity(intent);
            }
        });

        editWed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlanActivity.this,EditActivity.class);
                intent.putExtra("day","Wednesday");
                startActivity(intent);
            }
        });

        editFri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlanActivity.this,EditActivity.class);
                intent.putExtra("day","Friday");
                startActivity(intent);
            }
        });

        editSat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlanActivity.this,EditActivity.class);
                intent.putExtra("day","Saturday");
                startActivity(intent);
            }
        });

        editSun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlanActivity.this,EditActivity.class);
                intent.putExtra("day","Sunday");
                startActivity(intent);
            }
        });
    }

    private void initRecView(){
        monRecView.setAdapter(monAdapter);
        monRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<Plan> monPlans = new ArrayList<>();
        for(Plan plan : Util.getUserPlans()){
            if(plan.getDay().equals("Monday")){
                monPlans.add(plan);
            }
        }
        monAdapter.setPlans(monPlans);

        tueRecView.setAdapter(tueAdapter);
        tueRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<Plan> tuePlans = new ArrayList<>();
        for(Plan plan : Util.getUserPlans()){
            if(plan.getDay().equals("Tuesday")){
                tuePlans.add(plan);
            }
        }
        tueAdapter.setPlans(tuePlans);

        wedRecView.setAdapter(wedAdapter);
        wedRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<Plan> wedPlans = new ArrayList<>();
        for(Plan plan : Util.getUserPlans()){
            if(plan.getDay().equals("Wednesday")){
                wedPlans.add(plan);
            }
        }
        wedAdapter.setPlans(wedPlans);

        thuRecView.setAdapter(thuAdapter);
        thuRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<Plan> thuPlans = new ArrayList<>();
        for(Plan plan : Util.getUserPlans()){
            if(plan.getDay().equals("Thursday")){
                thuPlans.add(plan);
            }
        }
        thuAdapter.setPlans(thuPlans);

        friRecView.setAdapter(friAdapter);
        friRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<Plan> friPlans = new ArrayList<>();
        for(Plan plan : Util.getUserPlans()){
            if(plan.getDay().equals("Friday")){
                friPlans.add(plan);
            }
        }
        friAdapter.setPlans(friPlans);

        satRecView.setAdapter(satAdapter);
        satRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<Plan> satPlans = new ArrayList<>();
        for(Plan plan : Util.getUserPlans()){
            if(plan.getDay().equals("Saturday")){
                satPlans.add(plan);
            }
        }
        satAdapter.setPlans(satPlans);

        sunRecView.setAdapter(sunAdapter);
        sunRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<Plan> sunPlans = new ArrayList<>();
        for(Plan plan : Util.getUserPlans()){
            if(plan.getDay().equals("Sunday")){
                sunPlans.add(plan);
            }
        }
        sunAdapter.setPlans(sunPlans);
    }

    private void initAdapter(){
        monAdapter = new PlanRecViewAdapter(this);
        tueAdapter = new PlanRecViewAdapter(this);
        wedAdapter = new PlanRecViewAdapter(this);
        thuAdapter = new PlanRecViewAdapter(this);
        friAdapter = new PlanRecViewAdapter(this);
        satAdapter = new PlanRecViewAdapter(this);
        sunAdapter = new PlanRecViewAdapter(this);
    }

    private void initialize(){
        monRecView = findViewById(R.id.monRecView);
        tueRecView = findViewById(R.id.tueRecView);
        wedRecView = findViewById(R.id.wedRecView);
        thuRecView = findViewById(R.id.thuRecView);
        friRecView = findViewById(R.id.friRecView);
        satRecView = findViewById(R.id.satRecView);
        sunRecView = findViewById(R.id.sunRecView);
        addPlan =findViewById(R.id.addPlan);
        editMon = findViewById(R.id.editMon);
        editTue = findViewById(R.id.editTue);
        editWed = findViewById(R.id.editWed);
        editThu = findViewById(R.id.editThu);
        editFri = findViewById(R.id.editFri);
        editSat = findViewById(R.id.editSat);
        editSun = findViewById(R.id.editSun);
        noPlanLayout = findViewById(R.id.noPlanLayout);
        nestedScroll = findViewById(R.id.nestedScroll);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }
}
