package com.allie.templateapplication;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.allie.templateapplication.constants.ActivityCodes;
import com.allie.templateapplication.model.Employee;

import java.util.ArrayList;
import java.util.List;


//Homework 1 - Pass information back to main activity

//Homework 2, add a cancel button to the CreateEmployeeActivity so it backs out without firing a toast.
//Add a new result code for cancel that pops a toast that says it was cancelled.
//Look up the activity lifecycle and familiarize yourself with it.  Specifically be familiar with onCreate, onResume, and onPause.

//Homework 3
//Fill the other items in the list
//        role, task, title
//        [4:14 PM] Richard Sauther: we need getters and setters

//Homework 4
//Get the delete button on each item to work to delete a specific employee
//Rename the title of the app

//Homework 5
//Create new Employee with 2 additional fields.  What ever we want to add
//Bundle all 6 on the intent
//Google the bundle
//Pass the bundle back to the activity
//Display the original 4 pieces of information, do not use the 2 new ones yet
//Click on the employee icon which opens a new Activity called Profile
//Profile will contain everything
//EC
//Return to the list
//EC - EC
//Add second viewHolder

public class MainActivity extends AppCompatActivity {
    private RecyclerAdapter mAdapter;
    private ActionBar mActionBar;
    private Toolbar mToolbar;
    private  List<Employee> mList = new ArrayList<Employee>();

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ActivityCodes.CREATE_EMPLOYEE_REQUEST){
            if (resultCode == ActivityCodes.CREATE_EMPLOYEE_RESPONSE){
           /*     String passedName = data.getStringExtra("Name");
                String passedTitle = data.getStringExtra("Title");
                String passedRole = data.getStringExtra("Role");
                String passedTasks = data.getStringExtra("Tasks");*/
                Bundle bundle = data.getExtras();
                String passedName = bundle.getString("Name");
                String passedTitle = bundle.getString("Title");
                String passedRole = bundle.getString("Role");
                String passedTasks = bundle.getString("Tasks");
                String passedHobbies = bundle.getString("Hobbies");
                int passedYears = bundle.getInt("Years", 0);

//                mList = new ArrayList<Employee>();
//                Toast.makeText(getApplicationContext(),
//                            passedName + " " +
//                            passedTitle + " " +
//                            passedRole + " " +
//                            passedTasks,
//                        Toast.LENGTH_LONG).show();
//                Employee e = new Employee(passedName, passedTitle, passedRole, passedTasks);
                Employee e = new Employee(passedName, passedTitle, passedRole, passedTasks, passedHobbies, passedYears);
//                //mList.add(e);
//                mList.add(passedName);
                //mAdapter.updateAdapter(mList);
                mAdapter.appendAdapter(e);

            }
            else if (resultCode == ActivityCodes.CREATE_EMPLOYEE_RESPONSE_CANCEL){
                Toast.makeText(getApplicationContext(), "You cancelled without adding a new employee", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);

        toolbarSetup();

        Button addEmployee = (Button) findViewById(R.id.add_button);
        addEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CreateEmployeeActivity.class);

                //With an intent, you can attach information to an intent before you pass it
                //intent.putExtra("name", "Thomas");

                //startActivity(intent);
                startActivityForResult(intent, ActivityCodes.CREATE_EMPLOYEE_REQUEST);


            }
        });


        //this is an example list - create your own from your json file to populate the recyclerview
        Employee e = new Employee("Thomas Cox", "Mobile QA Manager", "Hot Mess Response Team", "Everything", "Hiking", 4);
        mList.add(e);
        e = new Employee("Rich Sauther", "Lead QA Analyst", "WebMD", "iOS", "Saving Money", 2);
        mList.add(e);
        e = new Employee("Tabassum Tayyab", "Lead QA Analyst", "WebMD Rx", "iOS & Android", "Hobby", 4);
        mList.add(e);
//        mList.add("Employee");
//        mList.add("Employee");
//        mList.add("Employee");
//        Intent click = getIntent();
//        String passedName = click.getStringExtra("Name");
//        String passedTitle = click.getStringExtra("Title");
//        String passedRole = click.getStringExtra("Role");
//        String passedTasks = click.getStringExtra("Tasks");

//        Toast.makeText(getApplicationContext(),
//                        passedName + " " +
//                        passedTitle + " " +
//                        passedRole + " " +
//                        passedTasks,
//                        Toast.LENGTH_LONG).show();

                recyclerViewSetup();
        mAdapter.updateAdapter(mList);
    }

    private void recyclerViewSetup() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //pass in your list to the recyclerview adapter
        //RecyclerAdapter adapter = new RecyclerAdapter(list, this);

        mAdapter = new RecyclerAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void toolbarSetup() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        mActionBar = getSupportActionBar();

        mActionBar.setTitle(R.string.app_name);
        mActionBar.setDisplayShowTitleEnabled(true);
    }

    //example of how to get items from your json file
//    private List<Employee> getJsonObject() {
//            if (mJsonList == null) {
//                String json = null;
//                try {
//                    InputStream is = MainActivity.this.getAssets().open("Employee.json");
//                    int size = is.available();
//                    byte[] buffer = new byte[size];
//                    is.read(buffer);
//                    is.close();
//                    json = new String(buffer, "UTF-8");
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                    return null;
//                }
//                Gson gson = new Gson();
//                Type type = new TypeToken<List<Employee>>() {
//                }.getType();
//                mJsonList = gson.fromJson(json, type);
//
//                for (Employee employee : mJsonList) {
//                }
//            }
//            return mJsonList;
//        }
}
