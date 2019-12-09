package com.example.gymapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class AskForDetailDialog extends DialogFragment {

    private EditText editMin;
    private Button cancel, add;
    private Spinner spinner;
    private TextView trainingName;

    public interface GetDetails{
        void onGettingDetailsResult(Plan plan);
    }

    private GetDetails getDetails;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_ask_for_deatils, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle("Enter Details")
                .setCancelable(false)
                .setView(view);

        initialize(view);

        ArrayList<String> days = new ArrayList<>();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("friday");
        days.add("Saturday");
        days.add("Sunday");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, days);
        spinner.setAdapter(adapter);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        try {
            getDetails = (GetDetails) getActivity();
        }catch (ClassCastException e){
            e.printStackTrace();
        }
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getArguments();
                GymTraining training = bundle.getParcelable("training");
                if(null != training){
                    Plan plan = new Plan();
                    plan.setAccomplished(false);
                    plan.setDay(spinner.getSelectedItem().toString());
                    plan.setMinutes(Integer.valueOf(editMin.getText().toString()));
                    plan.setTraining(training);
                    getDetails.onGettingDetailsResult(plan);
                }

            }
        });

        return builder.create();
    }

    private void initialize(View view) {
        editMin = view.findViewById(R.id.editMin);
        cancel = view.findViewById(R.id.cancel);
        add = view.findViewById(R.id.add);
        spinner = view.findViewById(R.id.spinner);
        trainingName = view.findViewById(R.id.trainingName);
    }
}
