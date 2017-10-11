package com.allie.templateapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.allie.templateapplication.model.Employee;

import com.allie.templateapplication.constants.ActivityCodes;

/**
 * Created by tcox on 9/22/17.
 */

public class CreateEmployeeActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_employee_item);
        ImageButton addEmployeeButton = (ImageButton) findViewById(R.id.add_button);
        EditText title = (EditText) findViewById(R.id.title_edit_text);
        EditText name = (EditText) findViewById(R.id.name_edit_text);
        EditText role = (EditText) findViewById(R.id.role_edit_text);
        EditText tasks = (EditText) findViewById(R.id.tasks_edit_text);
        EditText hobbies = (EditText) findViewById(R.id.hobbies_edit_text);
        EditText years = (EditText) findViewById(R.id.years_edit_text);
        ImageButton cancelButton = (ImageButton) findViewById(R.id.cancel_button);

        addEmployeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                Bundle bundle = new Bundle();


                Employee e = new Employee(name.getText().toString(),
                        title.getText().toString(),
                        role.getText().toString(),
                        tasks.getText().toString(),
                        hobbies.getText().toString(),
                        Integer.parseInt((years.getText().toString())));
                intent.putExtra("EmployeeParcel",e);
                setResult(ActivityCodes.CREATE_EMPLOYEE_RESPONSE,intent);
                finish();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                setResult(ActivityCodes.CREATE_EMPLOYEE_RESPONSE_CANCEL, intent);
                finish();
            }

        });

    }
}
