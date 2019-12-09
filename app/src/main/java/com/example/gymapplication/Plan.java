package com.example.gymapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Plan implements Parcelable {

    private GymTraining training;
    private String day;
    private int minutes;
    private boolean isAccomplished;

    public Plan(GymTraining training, String day, int minutes, boolean isAccomplished) {
        this.training = training;
        this.day = day;
        this.minutes = minutes;
        this.isAccomplished = isAccomplished;
    }

    public Plan() {
    }

    protected Plan(Parcel in) {
        training = in.readParcelable(GymTraining.class.getClassLoader());
        day = in.readString();
        minutes = in.readInt();
        isAccomplished = in.readByte() != 0;
    }

    public static final Creator<Plan> CREATOR = new Creator<Plan>() {
        @Override
        public Plan createFromParcel(Parcel in) {
            return new Plan(in);
        }

        @Override
        public Plan[] newArray(int size) {
            return new Plan[size];
        }
    };

    public GymTraining getTraining() {
        return training;
    }

    public void setTraining(GymTraining training) {
        this.training = training;
    }

    public String getDay() {
        return day;
    }

    public boolean isAccomplished() {
        return isAccomplished;
    }

    public void setAccomplished(boolean accomplished) {
        isAccomplished = accomplished;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "training=" + training +
                ", day='" + day + '\'' +
                ", minutes=" + minutes +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(training, i);
        parcel.writeString(day);
        parcel.writeInt(minutes);
    }
}
