package com.example.gymapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class TrainingActivity extends AppCompatActivity implements AskForDetailDialog.GetDetails {

    private Button addToPlan;
    private TextView trainingName,longDesc;
    private ImageView trainingImage;
    private static final String TAG = "TrainingActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        Log.d(TAG, "onCreate: Training");

        initialize();

        Intent intent = getIntent();
        try{
            Log.d(TAG, "onCreate: Training 2");
            final GymTraining incomingTraining = intent.getParcelableExtra("training");
            trainingName.setText(incomingTraining.getName());
            longDesc.setText(incomingTraining.getLongDesc());
            Glide.with(this)
                    .asBitmap()
                    .load(incomingTraining.getImageUrl())
                    .into(trainingImage);

           addToPlan.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   AskForDetailDialog askForDetailDialog = new AskForDetailDialog();
                   Bundle bundle = new Bundle();
                   bundle.putParcelable("training",incomingTraining);
                   askForDetailDialog.setArguments(bundle);
                   askForDetailDialog.show(getSupportFragmentManager(),"ask for details");
               }
           });

        }catch (NullPointerException e){
            e.getMessage();
        }


    }
    private void initialize()
    {
        addToPlan = findViewById(R.id.addToPlan);
        trainingImage = findViewById(R.id.trainingImage);
        trainingName = findViewById(R.id.trainingName);
        longDesc = findViewById(R.id.longDesc);

    }

    @Override
    public void onGettingDetailsResult(Plan plan) {
        Util.addUserPlans(plan);
        Intent intent = new Intent(this,PlanActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("plan",plan);
        startActivity(intent);
    }
}
