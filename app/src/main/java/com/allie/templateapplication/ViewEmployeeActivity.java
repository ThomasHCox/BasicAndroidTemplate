package com.allie.templateapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.allie.templateapplication.model.Employee;

/**
 * Created by tcox on 10/10/17.
 */

public class ViewEmployeeActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_employee_item);
        Intent i = getIntent();
        Employee employee = i.getParcelableExtra("EmployeeParcel");

        TextView name = (TextView) findViewById(R.id.name_text);
        name.setText(employee.getName());
        TextView title = (TextView) findViewById(R.id.title_text);
        title.setText(employee.getTitle());
        TextView role = (TextView) findViewById(R.id.role_text);
        role.setText(employee.getRole());
        TextView tasks = (TextView) findViewById(R.id.tasks_text);
        tasks.setText(employee.getTask());
        TextView hobbies = (TextView) findViewById(R.id.hobbies_text);
        hobbies.setText(employee.getHobbies());
        TextView years = (TextView) findViewById(R.id.years_text);
        years.setText(String.valueOf(employee.getYears()));
//        years.setText(passedYears + " years worked");






    }
}
