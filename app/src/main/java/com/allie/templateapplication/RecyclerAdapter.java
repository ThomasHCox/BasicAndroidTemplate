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

import com.allie.templateapplication.interfaces.IListener;
import com.allie.templateapplication.model.Advertisement;
import com.allie.templateapplication.model.Employee;
import com.allie.templateapplication.viewholders.AdViewHolder;
import com.allie.templateapplication.viewholders.EmployeeViewHolder;
import com.allie.templateapplication.viewholders.EmptyViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acaldwell on 9/14/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Employee> mList = new ArrayList<>();
    private List<Object> mViewHolderList = new ArrayList<>();
    private Context mContext;
    private IListener mListener;
    private static final int View_Type_Employee = 0;
    private static final int View_Type_Advertisement = 1;
    private static final int View_Type_Empty = 2;

    public RecyclerAdapter(Context context, IListener profileListener) {
//        this.mList = list;
        this.mContext = context;
        mListener = profileListener;
    }

    public void updateAdapter(List<Employee> list){
        mList.clear();
        mList.addAll(list);
        addAds();
        notifyDataSetChanged();
    }

    public void appendAdapter(Employee e){
        mList.add(e);
        addAds();
        notifyDataSetChanged();
    }

    public void addItem(Employee e){
        mList.add(e);
        addAds();
    }

    public void addAds(){
        mViewHolderList.clear();
        if (mList.size() > 2){
            Advertisement ads = new Advertisement("Red");
            for (int i = 0; i < mList.size(); i++){
                if ((i>0) && ((i%2)==0)){
                    mViewHolderList.add(ads);
                    mViewHolderList.add(mList.get(i));
                }else{
                    mViewHolderList.add(mList.get(i));
                }
            }
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v;
        if (viewType == View_Type_Employee){
            v = inflater.inflate(R.layout.recyclerview_item, parent, false);
            EmployeeViewHolder holder = new EmployeeViewHolder(v);
            return holder;
        }else if (viewType == View_Type_Advertisement){
            v = inflater.inflate(R.layout.viewholder_ad, parent, false);
            AdViewHolder holder = new AdViewHolder(v);
            return holder;
        }else{
            v = inflater.inflate(R.layout.viewholder_empty, parent, false);
            EmptyViewHolder holder = new EmptyViewHolder(v);
            return holder;
        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //set the text for each cell in the recyclerview from the list


        if (holder instanceof EmployeeViewHolder) {
            ((EmployeeViewHolder) holder).bind((Employee)mViewHolderList.get(position), new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    mViewHolderList.remove(position);
                    notifyDataSetChanged();
                }
            }, mListener);
        }

        if (holder instanceof AdViewHolder){
            ((AdViewHolder) holder).bind((Advertisement)mViewHolderList.get(position));
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (mViewHolderList.get(position) instanceof Employee){
            return View_Type_Employee;
        }else if (mViewHolderList.get(position) instanceof Advertisement){
            return View_Type_Advertisement;
        }else{
            return View_Type_Empty;
        }
    }

    //we probably need a method to add items to the recyclerview dynamically


    @Override
    public int getItemCount() {
        if (mViewHolderList == null){
           return 0;
        }
        return mViewHolderList.size();
    }



        //this might be a good place to add your onClickListener for the delete button
    }

