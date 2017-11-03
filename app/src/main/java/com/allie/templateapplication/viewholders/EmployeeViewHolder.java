package com.allie.templateapplication.viewholders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.allie.templateapplication.R;
import com.allie.templateapplication.ViewEmployeeActivity;
import com.allie.templateapplication.interfaces.IListener;
import com.allie.templateapplication.model.Employee;

/**
 * Created by tcox on 10/11/17.
 */

public class EmployeeViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView title;
    private TextView role;
    private TextView task;
    private ImageButton deleteButton;
    private View profileImage;
    private Context mContext;

    public EmployeeViewHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        name = (TextView) itemView.findViewById(R.id.text_view_name);
        title = (TextView) itemView.findViewById(R.id.text_view_title);
        role = (TextView) itemView.findViewById(R.id.text_view_role);
        task = (TextView) itemView.findViewById(R.id.text_view_task);
        deleteButton = (ImageButton) itemView.findViewById(R.id.delete_button);
        profileImage = itemView.findViewById(R.id.user_icon);
    }





    public void bind (Employee employee, View.OnClickListener deleteButtonOnClickListener, IListener    profileImageOnClickListener){

        name.setText(employee.getName());
        title.setText(employee.getTitle());
        role.setText(employee.getRole());
        task.setText(employee.getTask());

        deleteButton.setOnClickListener(deleteButtonOnClickListener);

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profileImageOnClickListener.onEmployeeListener(employee);
            }
        });

    }

}