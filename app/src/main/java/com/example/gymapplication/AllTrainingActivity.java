package com.example.gymapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

public class AllTrainingActivity extends AppCompatActivity {

    private RecyclerView recView;
    private TrainingRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_training);

        adapter = new TrainingRecViewAdapter(this);
        recView = findViewById(R.id.recView);
        recView.setAdapter(adapter);

        recView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setTrainings(Util.getAllTrainings());
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AllTrainingActivity.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}
