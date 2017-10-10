package com.allie.templateapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by tcox on 10/10/17.
 */

public class ViewEmployeeActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_employee_item);
        Intent i = getIntent();

        Bundle bundle = i.getExtras();
        String passedName = bundle.getString("Name");
        String passedTitle = bundle.getString("Title");
        String passedRole = bundle.getString("Role");
        String passedTasks = bundle.getString("Tasks");
        String passedHobbies = bundle.getString("Hobbies");
        int passedYears = bundle.getInt("Years", 0);


        TextView name = (TextView) findViewById(R.id.name_text);
        name.setText(passedName);
        TextView title = (TextView) findViewById(R.id.title_text);
        title.setText(passedTitle);
        TextView role = (TextView) findViewById(R.id.role_text);
        role.setText(passedRole);
        TextView tasks = (TextView) findViewById(R.id.tasks_text);
        tasks.setText(passedTasks);
        TextView hobbies = (TextView) findViewById(R.id.hobbies_text);
        hobbies.setText(passedHobbies);
        TextView years = (TextView) findViewById(R.id.years_text);
        years.setText(String.valueOf(passedYears));
//        years.setText(passedYears + " years worked");






    }
}
