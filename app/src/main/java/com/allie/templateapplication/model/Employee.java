package com.allie.templateapplication.model;

/**
 * Created by acaldwell on 9/20/17.
 */

//model item for your employees - hint: setters & getters
public class Employee {
    private String mName;
    private String mTitle;
    private String mTask;
    private String mRole;
    private String mHobbies;
    private int mYears;

//    public Employee(String name, String title, String role, String task){
//        mName = name;
//        mTask = task;
//        mTitle = title;
//        mRole = role;
//    }

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

}
