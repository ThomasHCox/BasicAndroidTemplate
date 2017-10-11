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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acaldwell on 9/14/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
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
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.recyclerview_item, parent, false);
        RecyclerViewHolder holder = new RecyclerViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        //set the text for each cell in the recyclerview from the list
        holder.name.setText(mList.get(position).getName());
        holder.title.setText(mList.get(position).getTitle());
        holder.role.setText(mList.get(position).getRole());
        holder.task.setText(mList.get(position).getTask());



    }


    //we probably need a method to add items to the recyclerview dynamically


    @Override
    public int getItemCount() {
        if (mList == null){
           return 0;
        }
        return mList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView title;
        public TextView role;
        public TextView task;
        public ImageButton deleteButton;
        public View profileImage;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            Context context = itemView.getContext();
            name = (TextView) itemView.findViewById(R.id.text_view_name);
            title = (TextView) itemView.findViewById(R.id.text_view_title);
            role = (TextView) itemView.findViewById(R.id.text_view_role);
            task = (TextView) itemView.findViewById(R.id.text_view_task);
            deleteButton = (ImageButton) itemView.findViewById(R.id.delete_button);
            profileImage = itemView.findViewById(R.id.user_icon);
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mList.remove(getAdapterPosition());
                    notifyDataSetChanged();
                }
            });

            profileImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ViewEmployeeActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Name",mList.get(getAdapterPosition()).getName());
                    bundle.putString("Title",mList.get(getAdapterPosition()).getTitle());
                    bundle.putString("Role",mList.get(getAdapterPosition()).getRole());
                    bundle.putString("Tasks",mList.get(getAdapterPosition()).getTask());
                    bundle.putString("Hobbies",mList.get(getAdapterPosition()).getHobbies());
                    bundle.putInt("Years",mList.get(getAdapterPosition()).getYears());
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });

        }


        //this might be a good place to add your onClickListener for the delete button
    }
}
