package com.allie.templateapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.allie.templateapplication.model.Employee;
import com.allie.templateapplication.viewholders.EmployeeViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acaldwell on 9/14/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<EmployeeViewHolder> {
    private List<Employee> mList = new ArrayList<>();
    private Context mContext;

    public RecyclerAdapter(Context context) {
//        this.mList = list;
        this.mContext = context;
    }

    public void updateAdapter(List<Employee> list){
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    public void appendAdapter(Employee e){
        mList.add(e);
        notifyDataSetChanged();
    }

    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.recyclerview_item, parent, false);
        EmployeeViewHolder holder = new EmployeeViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(EmployeeViewHolder holder, int position) {
        //set the text for each cell in the recyclerview from the list



        holder.bind(mList.get(position), new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                mList.remove(position);
                notifyDataSetChanged();
            }
        });

    }


    //we probably need a method to add items to the recyclerview dynamically


    @Override
    public int getItemCount() {
        if (mList == null){
           return 0;
        }
        return mList.size();
    }



        //this might be a good place to add your onClickListener for the delete button
    }

