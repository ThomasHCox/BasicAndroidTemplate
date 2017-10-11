package com.allie.templateapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by acaldwell on 9/20/17.
 */

//model item for your employees - hint: setters & getters
public class Employee implements Parcelable {
    private String mName;
    private String mTitle;
    private String mTask;
    private String mRole;
    private String mHobbies;
    private int mYears;

    public Employee(String name, String title, String role, String task, String hobbies, int years){
        mName = name;
        mTask = task;
        mTitle = title;
        mRole = role;
        mHobbies = hobbies;
        mYears = years;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getTask() {
        return mTask;
    }

    public void setTask(String task) {
        mTask = task;
    }

    public String getRole() {
        return mRole;
    }

    public void setRole(String role) {
        mRole = role;
    }


    public String getHobbies() {
        return mHobbies;
    }

    public void setHobbies(String hobbies) {
        mHobbies = hobbies;
    }

    public int getYears() {
        return mYears;
    }

    public void setYears(int years) {
        mYears = years;
    }



//Parcelable implementation

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mName);
        dest.writeString(this.mTitle);
        dest.writeString(this.mTask);
        dest.writeString(this.mRole);
        dest.writeString(this.mHobbies);
        dest.writeInt(this.mYears);
    }

    protected Employee(Parcel in) {
        this.mName = in.readString();
        this.mTitle = in.readString();
        this.mTask = in.readString();
        this.mRole = in.readString();
        this.mHobbies = in.readString();
        this.mYears = in.readInt();
    }

    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel source) {
            return new Employee(source);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };
}
